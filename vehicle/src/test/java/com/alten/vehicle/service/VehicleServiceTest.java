package com.alten.vehicle.service;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import com.alten.vehicle.repository.VehicleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {
    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @Test
    public void get_vehicles_by_customer_id_test() {
        Vehicle vehicle = getFakeVehicle(VehicleStatus.ONLINE);
        when(vehicleRepository.findAllByCustomerID(any())).thenReturn(new ArrayList<>(Arrays.asList(vehicle)));
        int vehicleCount = vehicleService.getVehiclesByCustomerId(-1L).size();
        Assert.assertEquals(vehicleCount, 1);
    }

    @Test
    public void get_vehicles_by_customer_id_and_status_test() {
        Vehicle vehicle = getFakeVehicle(VehicleStatus.ONLINE);
        when(vehicleRepository.findAllByCustomerIDAndStatus(-1L, VehicleStatus.ONLINE)).thenReturn(new ArrayList<>(Arrays.asList(vehicle)));
        int vehicleCount = vehicleService.getVehiclesByCustomerIdAndStatus(-1L, VehicleStatus.ONLINE).size();
        Assert.assertEquals(vehicleCount, 1);
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
