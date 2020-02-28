package com.alten.ui.service;

import com.alten.ui.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitoringService {

    @Value("${gateway.url}")
    private String gatewayUrl;

    private final RestTemplate restTemplate;

    public List<CustomerVehicleDTO> getCustomerVehicles() {
        List<CustomerVehicleDTO> customerVehicles = new ArrayList<>();
        ResponseEntity<CustomerDTO[]> customers = restTemplate.getForEntity(gatewayUrl + "/customer", CustomerDTO[].class);
        for (CustomerDTO customer : customers.getBody()) {
            ResponseEntity<VehicleDTO[]> vehicles = restTemplate.getForEntity(gatewayUrl + "/vehicle/customerId/" + customer.getId(),
                    VehicleDTO[].class);
            for (VehicleDTO vehicle : vehicles.getBody()) {
                customerVehicles.add(new CustomerVehicleDTO(customer.getId(), vehicle.getId(), customer.getName(), customer.getAddress(),
                        vehicle.getVin(), vehicle.getRegistrationNumber(), vehicle.getStatus()));
            }
        }
        return customerVehicles;
    }

    public List<CustomerVehicleDTO> getCustomerVehiclesByFilter(FilterDTO filter) {
        List<CustomerVehicleDTO> customerVehicles = new ArrayList<>();
        ResponseEntity<CustomerDTO[]> customers;
        if (StringUtils.isEmpty(filter.getName())) {
            customers = restTemplate.getForEntity(gatewayUrl + "/customer", CustomerDTO[].class);
        } else {
            customers = restTemplate.getForEntity(gatewayUrl + "/customer/name/" + filter.getName(), CustomerDTO[].class);
        }

        for (CustomerDTO customer : customers.getBody()) {
            ResponseEntity<VehicleDTO[]> vehicles;
            if (VehicleStatusDTO.ALL.equals(filter.getStatus())) {
                vehicles = restTemplate.getForEntity(gatewayUrl + "/vehicle/customerId/" + customer.getId(), VehicleDTO[].class);
            } else {
                vehicles = restTemplate.getForEntity(gatewayUrl + "/vehicle/customerId/" + customer.getId() + "/"
                        + filter.getStatus(), VehicleDTO[].class);
            }
            for (VehicleDTO vehicle : vehicles.getBody()) {
                customerVehicles.add(new CustomerVehicleDTO(customer.getId(), vehicle.getId(), customer.getName(), customer.getAddress(),
                        vehicle.getVin(), vehicle.getRegistrationNumber(), vehicle.getStatus()));
            }
        }
        return customerVehicles;
    }
}
