package com.alten.customer.dto;

import com.alten.customer.model.VehicleStatus;
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
