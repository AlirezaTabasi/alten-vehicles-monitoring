package com.alten.customer.controller;

import com.alten.customer.dto.VehicleDTO;
import com.alten.customer.mapper.VehicleMapper;
import com.alten.customer.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public List<VehicleDTO> getVehicles() {
        return vehicleService.getVehicles().stream().map(vehicleMapper::convertToDto).collect(Collectors.toList());
    }
}
