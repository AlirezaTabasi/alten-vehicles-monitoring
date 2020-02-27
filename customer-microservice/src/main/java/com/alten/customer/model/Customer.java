package com.alten.customer.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER")
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    @Size(min = 5, max = 150)
    private String name;

    @Embedded
    private Address address;
}
