package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	@Query("SELECT c FROM Car c ORDER BY c.model, c.brand")
	public List<Car> viewAllCar();
	
	@Query("SELECT c FROM Car c WHERE c.worker.id = ?1 ORDER BY c.model, c.brand")
	public List<Car> viewCarOfWorker(long id);
	
	@Query("SELECT c FROM Car c WHERE c.client.id = ?1 ORDER BY c.model, c.brand")
	public List<Car> viewCarsOfClient(long id);
	
	@Query("SELECT c FROM Car c WHERE c.isRental = false ORDER BY c.model, c.brand")
	public List<Car> viewAllCarRental();
	
	@Query("SELECT c FROM Car c WHERE c.isAvailable = true ORDER BY c.model, c.brand")
	public List<Car> viewAllCarAvailable();
	
	@Query("SELECT c FROM Car c WHERE c.isAvailable = true AND c.isRental = false AND c.dateRentalFinish < NOW() AND c.dateRentalStart IS NULL AND c.dateRentalFinish IS NULL ORDER BY c.model, c.brand")
	public List<Car> viewCarForTheRental();
	
	@Query("SELECT c.id FROM Car c WHERE c.numberCar = ?1 ORDER BY c.model, c.brand")
	public long getIdOfCarByNumberCar(String numberCar);
	
	@Query("SELECT c FROM Car c WHERE c.id = ?1")
	public Car getCarById(long id);
	
	@Query("SELECT COUNT(c) FROM Car c WHERE c.isAvailable = true AND c.isRental = false")
	public int countTotCarAvailable();
	
	@Query("SELECT COUNT(c) FROM Car c WHERE c.client.id = ?1")
	public int countTotCarRentalByIdClient(long id);
	
	@Query("SELECT c.brand FROM Car c WHERE c.id = ?1")
	public String getBrandCarById(long id);
	
	@Query("SELECT c.client.id FROM Car c WHERE c.id = ?1")
	public long getIdWorkerByCarId(long id);
	
	@Query("SELECT c.isRental FROM Car c WHERE c.id = ?1")
	public boolean getIsRentalById(long id);
	
	/*@Query("SELECT DATEDIFF(c.dateRentalStart, c.dateRentalFinish) FROM Car c WHERE c.id = ?1")
	public int differenceDate(long id);*/
	
	@Query("SELECT c.moneyDaily FROM Car c WHERE c.id = ?1")
	public double moneyDailyById(long id);
	
	@Query("SELECT c.client.id FROM Car c WHERE c.id = ?1")
	public long getIdClientByCarRentalId(long id);
	
	@Query("SELECT c.dateAvalableStart FROM Car c WHERE c.id = ?1")
	public String getDateAvalableStartById(long id);
	
	@Query("SELECT c,dateAvalableFinish FROM Car c WHERE c.id = ?1")
	public String getdateAvalableFinishById(long id);
}