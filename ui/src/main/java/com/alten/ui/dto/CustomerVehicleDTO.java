package com.alten.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerVehicleDTO {
    private Long customerId;

    private Long vehicleId;

    private String customerName;

    private String address;

    private String vin;

    private String registrationNumber;

    private VehicleStatusDTO status;
}
