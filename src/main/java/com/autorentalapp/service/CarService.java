package com.autorentalapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autorentalapp.models.Car;
import com.autorentalapp.models.CarStock;
import com.autorentalapp.repository.CarRepository;

@Service
public class CarService {
		
	@Autowired
	private CarRepository carRepository;
	
	public Car registerCar(Car car) {
		return carRepository.registerCar(car);
	}
	
}
