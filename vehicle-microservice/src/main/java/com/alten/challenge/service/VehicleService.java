package com.alten.challenge.service;

import com.alten.challenge.model.Vehicle;
import com.alten.challenge.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
}
