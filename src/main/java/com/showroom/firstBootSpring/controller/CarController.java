package com.showroom.firstBootSpring.controller;

import com.showroom.firstBootSpring.model.Car;
import com.showroom.firstBootSpring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController{
    @Autowired
    private CarService carService;
    @GetMapping()
    public ResponseEntity<Iterable> getCars(){
        Iterable<Car> cars=carService.getAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCarbyId(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car addedCar=carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCar);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCarbyId(@PathVariable Long id, @RequestBody Car car){
        Car addedCar=carService.updateCarById(id,car);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCar);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        carService.deleteCarById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted car with id-"+id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteById(){
        carService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All cars are deleted");
    }
}