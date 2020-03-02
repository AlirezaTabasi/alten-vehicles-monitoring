package com.alten.vehicle.repository;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.model.VehicleStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@SpringBootTest
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void insert_vehicle_test() {
        Vehicle vehicle = getFakeVehicle(VehicleStatus.OFFLINE);

        Vehicle insertedVehicle = vehicleRepository.save(vehicle);
        String vin = vehicleRepository.findById(insertedVehicle.getId()).get().getVin();

        Assert.assertEquals(vin, vehicle.getVin());
    }

    @Test
    public void find_all_by_customer_id() {
        Vehicle vehicle = getFakeVehicle(VehicleStatus.OFFLINE);

        vehicleRepository.save(vehicle);

        int vehicleCount = vehicleRepository.findAllByCustomerID(1L).size();
        Assert.assertEquals(vehicleCount, 1);
    }

    @Test
    public void find_all_by_customer_id_and_status() {
        Vehicle vehicle = getFakeVehicle(VehicleStatus.OFFLINE);
        vehicleRepository.save(vehicle);

        int vehicleCount = vehicleRepository.findAllByCustomerIDAndStatus(1L, VehicleStatus.OFFLINE).size();
        Assert.assertEquals(vehicleCount, 1);
        vehicleCount = vehicleRepository.findAllByCustomerIDAndStatus(1L, VehicleStatus.ONLINE).size();
        Assert.assertEquals(vehicleCount, 0);
    }
    private Vehicle getFakeVehicle(VehicleStatus status) {
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber("ABC123");
        vehicle.setVin("YS2R4X20005399401");
        vehicle.setCustomerID(1L);
        vehicle.setStatus(status);
        return vehicle;
    }


}
