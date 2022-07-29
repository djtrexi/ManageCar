package com.example.demo.response.car;

import com.example.demo.model.Car;

public class CarDTOPrint {
	private long id;
	private String model;
	private String brand;
	private String color;

	public CarDTOPrint() {}

	public CarDTOPrint(Car c) {
		id = c.getId();
		model = c.getModel();
		brand = c.getBrand(); 
		color = c.getColor();
	}

	public CarDTOPrint(long id, String model, String brand, String color) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.color = color;
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
}