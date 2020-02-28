package com.alten.vehicle.service;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import com.alten.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehiclesByCustomerId(Long customerId) {
        return vehicleRepository.findAllByCustomerID(customerId);
    }

    public List<Vehicle> getVehiclesByCustomerIdAndStatus(Long customerId, VehicleStatus status) {
        return vehicleRepository.findAllByCustomerIDAndStatus(customerId, status);
    }
}
