package com.alten.vehicle.dto;

import com.alten.vehicle.model.VehicleStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {
    private Long id;

    private String vehicleID;

    private String registrationNumber;

    private Long customerID;

    private VehicleStatus status;
}
