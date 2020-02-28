package com.alten.vehicle.initilize;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import com.alten.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final VehicleRepository vehicleRepository;

    public void run(ApplicationArguments args) {
        vehicleRepository.deleteAll();
        Vehicle vehicle = new Vehicle(1L, "YS2R4X20005399401", "ABC123", 1L, VehicleStatus.ONLINE);
        vehicleRepository.save(vehicle);
        vehicle = new Vehicle(2L, "VLUR4X20009093588", "DEF456", 1L, VehicleStatus.ONLINE);
        vehicleRepository.save(vehicle);
        vehicle = new Vehicle(3L, "VLUR4X20009048066", "GHI789", 1L, VehicleStatus.OFFLINE);
        vehicleRepository.save(vehicle);

        vehicle = new Vehicle(4L, "YS2R4X20005388011", "JKL012", 2L, VehicleStatus.ONLINE);
        vehicleRepository.save(vehicle);
        vehicle = new Vehicle(5L, "YS2R4X20005387949", "MNO345", 2L, VehicleStatus.OFFLINE);
        vehicleRepository.save(vehicle);

        vehicle = new Vehicle(6L, "YS2R4X20005387765", "PQR678", 3L, VehicleStatus.ONLINE);
        vehicleRepository.save(vehicle);
        vehicle = new Vehicle(7L, "YS2R4X20005387055", "STU901", 3L, VehicleStatus.OFFLINE);
        vehicleRepository.save(vehicle);
    }
}
