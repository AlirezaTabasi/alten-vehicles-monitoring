package com.alten.customer.controller;

import com.alten.customer.mapper.CustomerMapper;
import com.alten.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService vehicleService;
    private final CustomerMapper vehicleMapper;

}
