package com.alten.vehicle.scheduler;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import com.alten.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class PingScheduler {

    private final VehicleRepository vehicleRepository;

    @Scheduled(fixedRate = 50 * 1000)
    public void pingVehicles() {
        Random random = new Random();
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles.forEach(vehicle -> {
            if (random.nextBoolean() == true) {
                vehicle.setStatus(VehicleStatus.ONLINE);
            } else {
                vehicle.setStatus(VehicleStatus.OFFLINE);
            }
            vehicleRepository.save(vehicle);
        });
    }
}
