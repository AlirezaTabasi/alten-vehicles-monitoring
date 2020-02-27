package com.alten.challenge.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "PING_SIGNAL")
@Setter
@Getter
public class PingSignal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REGISTRATION_NUMBER", nullable = false)
    private String registrationNumber;

    @Column(name = "PING_DATE", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime pingDate = ZonedDateTime.now();
}
