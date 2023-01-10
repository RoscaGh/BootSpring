package com.showroom.firstBootSpring.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cars", schema="public")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "body_type")
    private String bodyType;
    @Column(name = "first_registration")
    private LocalDate firstRegistration;
    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "mileage")
    private Long mileage;
    @Column(name = "model_make")
    private String modelMake;
}
