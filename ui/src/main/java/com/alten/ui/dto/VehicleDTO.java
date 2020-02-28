package com.alten.ui.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {
    private Long id;

    private String vin;

    private String registrationNumber;

    private Long customerID;

    private VehicleStatusDTO status;
}
