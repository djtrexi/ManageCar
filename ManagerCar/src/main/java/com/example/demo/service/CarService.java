package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.model.Client;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ClientRepository;

@Service
@Component
public class CarService {
	@Autowired
	CarRepository cr;

	@Autowired
	ClientRepository crl;

	public boolean rentalCar(long idCar, long idClient, LocalDate dataBegin, LocalDate dataFinish) {
		try {
			if(crl.getReferenceById(idClient) == null) {
				return false;
			}
			else {
				if(cr.getCarById(idCar) == null) {
					return false;
				}
				else {
					Car car = cr.getCarById(idCar);
					car.setDateRentalStart(dataBegin);
					car.setDateRentalFinish(dataFinish);
					car.setAvailable(false);
					car.setRental(true);
					Client c = crl.getReferenceById(idClient);
					car.setClient(c);
					cr.save(car);
					return true;
				}
			}
		} catch(Exception e) {
			return false;
		}
	}

	public boolean addCar(Car c) {
		try {
			cr.save(c);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public Car getCarById(long id) {
		try {
			if(cr.getCarById(id) == null) {
				return null;
			}
			else {
				return cr.getCarById(id);
			}
		} catch(Exception e) {
			return null;
		}
	}

	public Boolean deleteCar(long id) {
		try {
			if(cr.existsById(id)) {
				Car car = cr.getReferenceById(id);
				if(car.getClient() != null) {
					return null;
				}
				else {
					car.setAvailable(false);
					car.setDateRentalStart(null);
					car.setDateRentalFinish(null);
					car.setDateAvalableStart(null);
					car.setDateAvalableFinish(null);
					cr.save(car);
					return true;
				}
			}
			else {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
	}

	public List<Car> viewAllCar(){
		return cr.viewAllCar();
	}

	public List<Car> viewAllCarRental(){
		return cr.viewAllCarRental();
	}

	public List<Car> viewAllCarAvailable(){
		return cr.viewAllCarAvailable();
	}

	public List<Car> viewCarForTheRental(){
		return cr.viewCarForTheRental();
	}

	public List<Car> viewCarsOfClient(long id){
		try {
			if(crl.getReferenceById(id) == null) {
				return null;
			}
			else {
				return cr.viewCarsOfClient(id);
			}
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public int countTotCarAvailable() {
		try {
			return cr.countTotCarAvailable();
		} catch(Exception e) {
			return -1;
		}
	}
}