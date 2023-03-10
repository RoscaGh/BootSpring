package com.showroom.firstBootSpring.service;

import com.showroom.firstBootSpring.model.Car;
import com.showroom.firstBootSpring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public Car addCar(Car car){
        return carRepository.save(car);
    }
    public List<Car> getAllCars(){
        return (List<Car>) carRepository.findAll();
    }
    public Car getCarbyId(Long id){
        return carRepository.findById(id).orElse(new Car());
    }
    public Car updateCarById(Long id, Car car){
        car.setId(id);
        return carRepository.save(car);
    }
    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }
    public void deleteAll(){
        carRepository.deleteAll();
    }

}
