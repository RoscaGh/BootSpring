package com.showroom.firstBootSpring.repository;

import com.showroom.firstBootSpring.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}