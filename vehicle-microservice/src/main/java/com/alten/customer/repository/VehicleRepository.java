package com.alten.customer.repository;

import com.alten.customer.model.Vehicle;
import com.alten.customer.model.VehicleStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    public Optional<List<Vehicle>> findAllByCustomerID(Long customerID);

    public Optional<List<Vehicle>> findAllByStatus(VehicleStatus status);
}
