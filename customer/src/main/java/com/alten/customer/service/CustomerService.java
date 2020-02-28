package com.alten.customer.service;

import com.alten.customer.model.Customer;
import com.alten.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findCustomerByPartOfName(name);
    }
}
