package com.alten.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    @Size(min = 5, max = 150)
    private String name;

    @NotEmpty
    @Column(name = "ADDRESS", nullable = false)
    @Size(min = 5, max = 200)
    private String address;
}
