package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ClientRepository;

@Service
public class CarService {
	@Autowired
	CarRepository cr;

	@Autowired
	ClientRepository crl;

	public boolean rentalCar(long idUtente, long idClient, LocalDate dataBegin, LocalDate dataFinish) {
		try {
			if(crl.getReferenceById(idUtente) == null) {
				return false;
			}
			else {
				Car car = cr.getReferenceById(idClient);
				car.setDateRentalStart(dataBegin);
				car.setDateRentalFinish(dataFinish);
				car.setAvailable(false);
				car.setRental(true);
				car.getClient().setId(idClient);
				cr.save(car);
				return true;
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

	/*public void modifyCar(Car c) {
		try {
			
		} catch(Exception e) {
			return;
		}
	}*/
	
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
}