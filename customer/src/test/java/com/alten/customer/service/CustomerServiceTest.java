package com.alten.customer.service;

import com.alten.customer.model.Customer;
import com.alten.customer.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private  CustomerService customerService;

    @Test
    public void get_customers_test() {
        Customer customer = getFakeCustomer();
        Mockito.when(customerRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(customer, customer, customer)));
        int customerCount = customerService.getCustomers().size();
        Assert.assertEquals(customerCount, 3);
    }

    @Test
    public void get_customers_by_name(){
        Customer customer = getFakeCustomer();
        Mockito.when(customerRepository.findCustomerByPartOfName("rez")).thenReturn(new ArrayList<>(Arrays.asList(customer)));
        int customerCount = customerService.getCustomersByName("rez").size();
        Assert.assertEquals(customerCount, 1);
    }

    private Customer getFakeCustomer() {
        return new Customer(1L, "Alireza", "Iran, Tehran");
    }
}
