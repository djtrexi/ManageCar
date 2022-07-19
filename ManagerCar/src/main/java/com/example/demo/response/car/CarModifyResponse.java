package com.example.demo.response.car;

import com.example.demo.model.Car;

public class CarModifyResponse {
	private String model;
	private String brand;
	private String color;

	public CarModifyResponse() {}

	public CarModifyResponse(String model, String brand, String color) {
		this.model = model;
		this.brand = brand;
		this.color = color;
	}

	public CarModifyResponse(Car c) {
		model = c.getModel();
		brand = c.getBrand();
		color = c.getColor();
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