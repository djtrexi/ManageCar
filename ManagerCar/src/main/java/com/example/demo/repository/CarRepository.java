package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	@Query("SELECT c FROM Car c ORDER BY c.model")
	public List<Car> viewAllCar();
	
	@Query("SELECT c FROM Car c WHERE c.isRental = false")
	public List<Car> viewAllCarRental();
	
	@Query("SELECT c FROM Car c WHERE c.isAvailable = true")
	public List<Car> viewAllCarAvailable();
	
	@Query("SELECT c FROM Car c WHERE c.isAvailable = true AND c.isRental = false AND c.dateRentalFinish < NOW() AND c.dateRentalStart IS NULL AND c.dateRentalFinish IS NULL")
	public List<Car> viewCarForTheRental();
	
	@Query("SELECT c.id FROM Car c WHERE c.numberCar = ?1")
	public long getIdOfCarByNumberCar(String numberCar);
}