package com.showroom.firstBootSpring.controller;

import com.showroom.firstBootSpring.model.Car;
import com.showroom.firstBootSpring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin(value = "http://localhost:4200")
public class CarController{
    public static String UPLOAD_DIRECTORY="src/main/resources/static/uploads/";
    @Autowired
    private CarService carService;
    @GetMapping()
//    public ResponseEntity<List> getCars(){
//        List<Car> cars=carService.getAllCars();
//        return ResponseEntity.status(HttpStatus.OK).body(cars);
//    }
    public List <Car> getCars(){
        return carService.getAllCars();
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
//        return ResponseEntity.status(HttpStatus.OK).body("Deleted car with id-"+id);
        return ResponseEntity.status(HttpStatus.OK).body("\"success\"");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteById(){
        carService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All cars are deleted");
    }

    @PostMapping("/upload")
    public String uploadImage(Model model, @RequestParam("file") MultipartFile file) throws IOException, IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "\"success\"";
    }
}