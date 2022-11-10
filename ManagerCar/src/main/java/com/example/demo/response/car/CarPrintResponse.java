package com.example.demo.response.car;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Car;

public class CarPrintResponse {
	private List<CarDTOPrint> c;

	public CarPrintResponse() {}

	public CarPrintResponse(List<Car> listCars) {
		c = new ArrayList<>();

		for(int i = 0; i < listCars.size(); i++) {
			c.add(new CarDTOPrint(listCars.get(i)));
		}
	}

	public List<CarDTOPrint> getC() {
		return c;
	}

	public void setC(List<CarDTOPrint> c) {
		this.c = c;
	}
}