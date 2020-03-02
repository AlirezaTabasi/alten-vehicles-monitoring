package com.alten.customer.controller;

import com.alten.customer.mapper.CustomerMapper;
import com.alten.customer.model.Customer;
import com.alten.customer.service.CustomerService;
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
public class CustomerControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private CustomerMapper localCustomerMapper = new CustomerMapper(new ModelMapper());

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        FieldSetter.setField(customerController, customerController.getClass().getDeclaredField("customerMapper"),
                localCustomerMapper);
    }

    @Test
    public void get_customers_test() throws Exception {
        when(customerService.getCustomers()).thenReturn(new ArrayList<>(Arrays.asList(getFakeCustomer())));

        mockMvc.perform(get("/customer")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$..id").value(1));
    }

    @Test
    public void get_customers_by_name_test() throws Exception {
        when(customerService.getCustomersByName(any())).thenReturn(Arrays.asList(getFakeCustomer()));

        mockMvc.perform(get("/customer/name/{customerName}", "rez")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$..id").value(1));
    }

    private Customer getFakeCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Alireza");
        customer.setAddress("Iran, Tehran");
        return customer;
    }
}
