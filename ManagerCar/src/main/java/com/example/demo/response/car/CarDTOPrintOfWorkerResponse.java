package com.example.demo.response.car;

import com.example.demo.model.Car;

public class CarDTOPrintOfWorkerResponse {
	private long id;
	private String model;
	private String brand;
	private String color;
	private double moneyDaily;
	private boolean isAvailable;
	private boolean isRental;

	public CarDTOPrintOfWorkerResponse() {}

	public CarDTOPrintOfWorkerResponse(Car c) {
		id = c.getId();
		model = c.getModel();
		brand = c.getBrand(); 
		color = c.getColor();
		moneyDaily = c.getMoneyDaily();
		isAvailable = c.isAvailable();
		isRental = c.isRental();
	}

	public CarDTOPrintOfWorkerResponse(long id, String model, String brand, String color, double moneyDaily, boolean isAvailable, boolean isRental) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.moneyDaily = moneyDaily;
		this.isAvailable = isAvailable;
		this.isRental = isRental;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

	public double getMoneyDaily() {
		return moneyDaily;
	}

	public void setMoneyDaily(double moneyDaily) {
		this.moneyDaily = moneyDaily;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isRental() {
		return isRental;
	}

	public void setRental(boolean isRental) {
		this.isRental = isRental;
	}
}