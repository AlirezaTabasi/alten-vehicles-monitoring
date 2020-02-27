package com.alten.challenge.dto;

import com.alten.challenge.model.VehicleStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

@Getter
@Setter
public class VehicleDTO {
    private Long id;

    private String vehicleID;

    private String registrationNumber;

    private Long customerID;

    private VehicleStatus status;
}
