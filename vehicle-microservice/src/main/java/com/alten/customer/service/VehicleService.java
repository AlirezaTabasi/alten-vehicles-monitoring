package com.alten.customer.service;

import com.alten.customer.model.Vehicle;
import com.alten.customer.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
}
