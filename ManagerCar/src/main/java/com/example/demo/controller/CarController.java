package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.request.car.CarAddRequest;
import com.example.demo.request.car.CarDeleteRequest;
import com.example.demo.response.car.CarDTO;
import com.example.demo.response.car.CarPrintResponse;
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

	@RequestMapping(method = RequestMethod.POST, path = "/deleteCar")
	public ResponseEntity deleteCar(@RequestBody CarDeleteRequest request) {
		if(serviceCar.deleteCar(request.getId())) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@RequestMapping(method = RequestMethod.POST, path = "/viewAllCar")
	public ResponseEntity<CarPrintResponse> viewAllCar() {
		List<Car> cars = serviceCar.viewAllCar();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}	
	}

	@RequestMapping(method = RequestMethod.POST, path = "/viewCarRental")
	public ResponseEntity<CarPrintResponse> viewAllCarRental() {
		List<Car> cars = serviceCar.viewAllCarRental();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}
	}

	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.POST, path = "/viewCarAvailable")
	public ResponseEntity<CarPrintResponse> viewAllCarAvailable(){
		List<Car> cars = serviceCar.viewAllCarAvailable();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}
	}

	@RequestMapping(method = RequestMethod.POST, path = "/viewCarRentalForClient")
	public ResponseEntity<CarPrintResponse> viewCarForTheRental(){
		List<Car> cars = serviceCar.viewCarForTheRental();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}
	}
}