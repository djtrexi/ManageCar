package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.request.car.CarAddRequest;
import com.example.demo.request.car.CarDeleteRequest;
import com.example.demo.response.car.CarDTO;
import com.example.demo.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService serviceCar;

	@RequestMapping(method = RequestMethod.POST, path = "/addCar")
	public ResponseEntity<CarDTO> addCar(@RequestBody CarAddRequest request) {
		if(!request.isValidValue() || !request.isValidDate()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();	
		}
		else {
			Car c = new Car(request.getModel(), request.getBrand(), request.getColor(), request.getNumberCar(), request.getAnnoProduzione(), request.isRental(), request.isAvailable(), request.getDateAvalableStart(), request.getDateAvalableFinish(), null, null, request.getMoneyDaily());
			if(serviceCar.addCar(c)) {
				return ResponseEntity.status(HttpStatus.OK).body(new CarDTO(c));
			}
			else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
	}
	
	public ResponseEntity deleteCar(@RequestBody ) {
		
	}
}