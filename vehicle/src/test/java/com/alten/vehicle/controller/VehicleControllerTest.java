package com.alten.vehicle.controller;

import com.alten.vehicle.mapper.VehicleMapper;
import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import com.alten.vehicle.service.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehicleControllerTest {
    private MockMvc mockMvc;

    @Mock
    private VehicleMapper vehicleMapper;

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleController vehicleController;

    private VehicleMapper localVehicleMapper = new VehicleMapper(new ModelMapper());

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
        FieldSetter.setField(vehicleController, vehicleController.getClass().getDeclaredField("vehicleMapper"),
                localVehicleMapper);
    }

    @Test
    public void get_vehicles_by_customer_id_test() throws Exception {
        when(vehicleService.getVehiclesByCustomerId(any())).thenReturn(new ArrayList<>(Arrays.asList(getFakeVehicle(VehicleStatus.ONLINE))));

        mockMvc.perform(get("/vehicle/customerId/{customerId}", -1L)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$..customerID").value(-1));
    }

    @Test
    public void get_vehicles_by_customer_id_and_status_test() throws Exception {
        when(vehicleService.getVehiclesByCustomerIdAndStatus(-1L, VehicleStatus.ONLINE))
                .thenReturn(new ArrayList<>(Arrays.asList(getFakeVehicle(VehicleStatus.ONLINE))));
        mockMvc.perform(get("/vehicle/customerId/{customerId}/{status}", -1L, VehicleStatus.ONLINE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$..customerID").value(-1));
    }

    private Vehicle getFakeVehicle(VehicleStatus status) {
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber("ABC123");
        vehicle.setVin("YS2R4X20005399401");
        vehicle.setCustomerID(-1L);
        vehicle.setStatus(status);
        return vehicle;
    }
}
