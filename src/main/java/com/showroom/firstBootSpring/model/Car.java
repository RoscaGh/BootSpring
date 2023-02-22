package com.showroom.firstBootSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars", schema="public")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "first_registration")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate firstRegistration;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "model_make")
    @NotEmpty(message = "Model name cannot be empty")
    @Size(min=5, max=50,message = "Model name should be between 5 and 50 characters")
    private String modelMake;

    @Column(name = "img")
    private String img;
}
