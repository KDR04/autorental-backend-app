package com.autorentalapp.controller;


import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.autorentalapp.models.Car;
import com.autorentalapp.models.CarStock;
import com.autorentalapp.service.CarService;


@CrossOrigin
@Controller
public class CarController {
	
	private CarService carService;
	
	public CarController(CarService carService) {
		// TODO Auto-generated constructor stub
		this.carService = carService;
	}
	
	@PostMapping("v1/registerCar")
	public  ResponseEntity<Car> registerUser(@RequestBody Car car) {
		System.out.println("comes here in post");
		Car carOutput = carService.registerCar(car);
		if (Objects.nonNull(carOutput)) {
			return new ResponseEntity<>(car, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
