package com.example.demo.request.car;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarAddRequest {
	private String model;
	private String brand;
	private String color;
	private String numberCar;
	private LocalDate annoProduzione;
	private LocalDate dateAvalableStart;
	private LocalDate dateAvalableFinish;
	private boolean rental; 
	private boolean available;
	private double moneyDaily;

	public CarAddRequest() {}

	public CarAddRequest(String model, String brand, String color, String numberCar, LocalDate annoProduzione, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, boolean rental, boolean available, double moneyDaily) {
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoProduzione = annoProduzione;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.rental = rental;
		this.available = available;
		this.moneyDaily = moneyDaily;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumberCar() {
		return numberCar;
	}

	public void setNumberCar(String numberCar) {
		this.numberCar = numberCar;
	}

	public LocalDate getAnnoProduzione() {
		return annoProduzione;
	}

	public void setAnnoProduzione(LocalDate annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	public LocalDate getDateAvalableStart() {
		return dateAvalableStart;
	}

	public void setDateAvalableStart(LocalDate dateAvalableStart) {
		this.dateAvalableStart = dateAvalableStart;
	}

	public LocalDate getDateAvalableFinish() {
		return dateAvalableFinish;
	}

	public void setDateAvalableFinish(LocalDate dateAvalableFinish) {
		this.dateAvalableFinish = dateAvalableFinish;
	}

	public boolean isRental() {
		return rental;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public double getMoneyDaily() {
		return moneyDaily;
	}

	public void setMoneyDaily(double moneyDaily) {
		this.moneyDaily = moneyDaily;
	}

	@JsonIgnore
	public boolean isValidValue() {
		if(model.equals("") || brand.equals("") || color.equals("") || numberCar.equals("") || moneyDaily <= 0.0 || numberCar.length() > 7){
			return false;
		}
		else {
			return true;
		}
	}

	@JsonIgnore
	public boolean isValidDate() {
		if(annoProduzione.isAfter(LocalDate.now()) || dateAvalableStart.isBefore(LocalDate.now()) || dateAvalableFinish.isBefore(LocalDate.now()) || dateAvalableStart.isBefore(annoProduzione) || dateAvalableFinish.isBefore(annoProduzione) || annoProduzione.isAfter(dateAvalableFinish) || annoProduzione.isAfter(dateAvalableStart) || annoProduzione == null || dateAvalableStart == null || dateAvalableFinish == null) {
			return false;
		}
		else {
			return true;
		}
	}
}