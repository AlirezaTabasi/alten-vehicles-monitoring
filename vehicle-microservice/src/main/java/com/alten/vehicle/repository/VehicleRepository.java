package com.alten.vehicle.repository;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    public Optional<List<Vehicle>> findAllByCustomerID(Long customerID);

    public Optional<List<Vehicle>> findAllByStatus(VehicleStatus status);
}
