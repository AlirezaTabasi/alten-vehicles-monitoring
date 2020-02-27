package com.alten.customer.service;

import com.alten.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


}
