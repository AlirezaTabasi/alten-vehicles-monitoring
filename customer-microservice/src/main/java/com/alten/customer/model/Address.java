package com.alten.customer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Setter
@Getter
public class Address {
    @NotNull
    @Size(max = 200)
    private String addressLine;

    @NotNull
    @Size(max = 40)
    private String city;

    @NotNull
    @Size(max = 40)
    private String state;

    @NotNull
    @Size(max = 40)
    private String country;

    @NotNull
    @Size(max = 6)
    private String postalCode;
}
