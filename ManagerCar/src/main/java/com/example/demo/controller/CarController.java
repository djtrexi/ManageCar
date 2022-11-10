package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.catalina.connector.Response;
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
import com.example.demo.request.car.CarChangeVisibilityCarRequest;
import com.example.demo.request.car.CarCheckVisibilityCarDateRequest;
import com.example.demo.request.car.CarCountTotCarRentalByIdClientRequest;
import com.example.demo.request.car.CarDeleteRequest;
import com.example.demo.request.car.CarDifferenceDateRequest;
import com.example.demo.request.car.CarGetIdWorkerByCarIdRequest;
import com.example.demo.request.car.CarGetIsRentalByIdRequest;
import com.example.demo.request.car.CarMoneyDailyByIdRequest;
import com.example.demo.request.car.CarOfWorkerRequest;
import com.example.demo.request.car.CarRentalRequest;
import com.example.demo.request.car.CarUpdatePaymentRequest;
import com.example.demo.request.car.CarsOfClientRequest;
import com.example.demo.request.car.GetBrandCarByIdRequest;
import com.example.demo.response.car.CarCountResponse;
import com.example.demo.response.car.CarCountTotCarRentalByIdClientResponse;
import com.example.demo.response.car.CarDTO;
import com.example.demo.response.car.CarDTOPrintOfWorker;
import com.example.demo.response.car.CarDifferenceDateResponse;
import com.example.demo.response.car.CarGetIdWorkerByCarIdResponse;
import com.example.demo.response.car.CarGetIsRentalByIdResponse;
import com.example.demo.response.car.CarMoneyDailyByIdResponse;
import com.example.demo.response.car.CarPrintResponse;
import com.example.demo.response.car.GetBrandCarByIdResponse;
import com.example.demo.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService serviceCar;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, path = "/rentalCar")
	public ResponseEntity rentalCar(@RequestBody CarRentalRequest request) {
		if(request.isValid()) {
			if(serviceCar.rentalCar(request.getIdCar(), request.getIdClient(), request.getDateBegin(), request.getDateFinish())) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.POST, path = "/addCar")
	public ResponseEntity<CarDTO> addCar(@RequestBody CarAddRequest request) {
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();	
		}
		else {
			Car c = new Car(request.getBrand(), request.getModel(), request.getColor(), request.getNumberCar(), request.getAnnoProduzione(), request.getDateAvalableStart(), request.getDateAvalableFinish(), request.getMoneyDaily());
			if(serviceCar.addCar(request.getidWorker(), c)) {
				return ResponseEntity.status(HttpStatus.OK).body(new CarDTO(c));
			}
			else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, path = "/changeVisibilityCar")
	public ResponseEntity changeVisibilityCar(@RequestBody CarChangeVisibilityCarRequest request) {
		if(serviceCar.changeVisibilityCar(request.getId()) == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, path = "/checkVisibilityCarDate")
	public ResponseEntity checkVisibilityCarDate(@RequestBody CarCheckVisibilityCarDateRequest request) {
		if(!serviceCar.checkVisibilityCarDate(request.getId(), request.getDateAvailableStart(), request.getDateAvailableFinish())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
	
	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.PUT, path = "/deleteCar")
	public ResponseEntity deleteCar(@RequestBody CarDeleteRequest request) {
		if(serviceCar.deleteCar(request.getId())) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/updatePayment")
	public ResponseEntity updatePayment(@RequestBody CarUpdatePaymentRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			Boolean result = serviceCar.updatePayment(request.getId(), request.getTotalMoneyRental(), request.isTypePay());
			if(result == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).build();
			}
		}
	}
	
	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.GET, path = "/viewAllCar")
	public ResponseEntity<CarPrintResponse> viewAllCar() {
		List<Car> cars = serviceCar.viewAllCar();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}	
	}

	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.GET, path = "/viewCarRental")
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
	@RequestMapping(method = RequestMethod.GET, path = "/viewCarAvailable")
	public ResponseEntity<CarPrintResponse> viewAllCarAvailable(){
		List<Car> cars = serviceCar.viewAllCarAvailable();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}
	}

	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.GET, path = "/viewCarRentalForClient")
	public ResponseEntity<CarPrintResponse> viewCarForTheRental(){
		List<Car> cars = serviceCar.viewCarForTheRental();
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/viewCarsOfClient")
	public ResponseEntity<CarPrintResponse> viewCarsOfClient(@RequestBody CarsOfClientRequest request){
		List<Car> cars = serviceCar.viewCarsOfClient(request.getId());
		if(cars == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new CarPrintResponse(cars));
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, path = "/countTotCarAvailable")
	public ResponseEntity<CarCountResponse> countTotCarAvailable(){
		if(serviceCar.countTotCarAvailable() >= 0) {
			int tot = serviceCar.countTotCarAvailable();
			return ResponseEntity.status(HttpStatus.OK).body(new CarCountResponse(tot));		
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/viewCarOfWorker")
	public ResponseEntity<CarDTOPrintOfWorker> viewCarOfWorker(@RequestBody CarOfWorkerRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.viewCarOfWorker(request.getId()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				List<Car> cars = serviceCar.viewCarOfWorker(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new CarDTOPrintOfWorker(cars));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getBrandCarById")
	public ResponseEntity<GetBrandCarByIdResponse> getBrandCarById(@RequestBody GetBrandCarByIdRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.getBrandCarById(request.getId()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				String brand = serviceCar.getBrandCarById(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new GetBrandCarByIdResponse(brand));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getIdWorkerByCarId")
	public ResponseEntity<CarGetIdWorkerByCarIdResponse> getIdWorkerByCarId(@RequestBody CarGetIdWorkerByCarIdRequest request){
		System.out.println(request.getId());
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.getIdWorkerByCarId(request.getId()) == 0) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				long idWorker = serviceCar.getIdWorkerByCarId(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new CarGetIdWorkerByCarIdResponse(idWorker));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getIsRentalByIdRequest")
	public ResponseEntity<CarGetIsRentalByIdResponse> getIsAvailableByIdRequest(@RequestBody CarGetIsRentalByIdRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.getIsRentalById(request.getId()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				boolean isAvailable = serviceCar.getIsRentalById(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new CarGetIsRentalByIdResponse(isAvailable));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/countTotCarRentalByIdClient")
	public ResponseEntity<CarCountTotCarRentalByIdClientResponse> countTotCarRentalByIdClient(@RequestBody CarCountTotCarRentalByIdClientRequest request) {
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.countTotCarRentalByIdClient(request.getId()) == -1) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				int count = serviceCar.countTotCarRentalByIdClient(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new CarCountTotCarRentalByIdClientResponse(count));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/differenceDate")
	public ResponseEntity<CarDifferenceDateResponse> differenceDate(@RequestBody CarDifferenceDateRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.differenceDate(request.getId()) == -1) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				int tot = serviceCar.differenceDate(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new CarDifferenceDateResponse(tot));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/moneyDailyById")
	public ResponseEntity<CarMoneyDailyByIdResponse> moneyDailyById(@RequestBody CarMoneyDailyByIdRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceCar.moneyDailyById(request.getId()) == -1) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				double moneyDaily = serviceCar.moneyDailyById(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new CarMoneyDailyByIdResponse(moneyDaily));
			}
		}
	}
}