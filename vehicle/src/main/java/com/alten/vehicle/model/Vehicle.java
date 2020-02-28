package com.alten.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "VEHICLE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 17, max = 17)
    @Column(name = "VIN")
    private String vin;

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
}
