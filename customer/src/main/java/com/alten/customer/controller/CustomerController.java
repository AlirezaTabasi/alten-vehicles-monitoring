package com.alten.customer.controller;

import com.alten.customer.dto.CustomerDTO;
import com.alten.customer.mapper.CustomerMapper;
import com.alten.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers().stream().map(customerMapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("name/{customerName}")
    public List<CustomerDTO> getCustomersByName(@PathVariable("customerName") String customerName) {
        return customerService.getCustomersByName(customerName).stream().map(customerMapper::convertToDto).collect(Collectors.toList());
    }
}
