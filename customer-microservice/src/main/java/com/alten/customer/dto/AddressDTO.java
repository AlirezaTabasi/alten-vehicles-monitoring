package com.alten.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String addressLine;

    private String city;

    private String state;

    private String country;

    private String postalCode;
}
