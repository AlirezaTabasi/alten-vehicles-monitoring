package com.alten.challenge.controller;

import com.alten.challenge.dto.VehicleDTO;
import com.alten.challenge.mapper.VehicleMapper;
import com.alten.challenge.service.VehicleService;
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
