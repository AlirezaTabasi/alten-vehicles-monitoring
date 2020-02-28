package com.alten.vehicle.repository;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    public List<Vehicle> findAllByCustomerID(Long customerID);

    public List<Vehicle> findAllByCustomerIDAndStatus(Long customerID, VehicleStatus status);
}
