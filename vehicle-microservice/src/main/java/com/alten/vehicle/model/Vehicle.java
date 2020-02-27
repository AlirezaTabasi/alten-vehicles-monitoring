package com.alten.vehicle.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;


@Entity
@Table(name = "VEHICLE")
@Setter
@Getter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 17, max = 17)
    @Column(name = "VEHICLE_ID")
    private String vehicleID;

    @NotNull
    @Size(min = 6, max = 6)
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @NotNull
    @Column(name = "CUSTOMER_ID")
    private Long customerID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleStatus status;

    @Column(name = "LAST_PING", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime lastPing = ZonedDateTime.now();
}
