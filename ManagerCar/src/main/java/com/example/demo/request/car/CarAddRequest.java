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
		if(model.equals("") || brand.equals("") || color.equals("") || numberCar.equals("") || moneyDaily <= 0.0){
			return false;
		}
		else {
			return true;
		}
	}

	@JsonIgnore
	public boolean isValidDate() {
		if(annoProduzione.isBefore(LocalDate.now()) || dateAvalableStart.isBefore(LocalDate.now()) || dateAvalableFinish.isBefore(LocalDate.now())) {
			return false;
		}
		else {
			if(annoProduzione == null || dateAvalableStart == null || dateAvalableFinish == null) {
				return false;
			}
			else {
				return true;
			}
		}
	}
}