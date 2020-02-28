package com.alten.vehicle.controller;

import com.alten.vehicle.dto.VehicleDTO;
import com.alten.vehicle.mapper.VehicleMapper;
import com.alten.vehicle.model.VehicleStatus;
import com.alten.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("vehicle")
@AllArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    @GetMapping("/customerId/{customerId}")
    public List<VehicleDTO> getVehiclesByCustomerId(@PathVariable("customerId") Long customerId) {
        return vehicleService.getVehiclesByCustomerId(customerId).stream().map(vehicleMapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/customerId/{customerId}/{status}")
    public List<VehicleDTO> getVehiclesByCustomerId(@PathVariable("customerId") Long customerId,
                                                    @PathVariable("status") VehicleStatus status) {
        return vehicleService.getVehiclesByCustomerIdAndStatus(customerId, status).stream()
                .map(vehicleMapper::convertToDto).collect(Collectors.toList());
    }
}
