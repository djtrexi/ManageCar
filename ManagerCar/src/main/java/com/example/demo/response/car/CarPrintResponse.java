package com.example.demo.response.car;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Car;

public class CarPrintResponse {
	private List<CarDTO> c;

	public CarPrintResponse() {}

	public CarPrintResponse(List<Car> listCars) {
		c = new ArrayList<>();

		for(int i = 0; i < listCars.size(); i++) {
			c.add(new CarDTO(listCars.get(i)));
		}
	}

	public List<CarDTO> getC() {
		return c;
	}

	public void setC(List<CarDTO> c) {
		this.c = c;
	}
}