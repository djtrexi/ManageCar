package com.example.demo.response.car;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Car;

public class CarDTOPrintOfWorker {
	private List<CarDTOPrintOfWorkerResponse> c;

	public CarDTOPrintOfWorker() {}

	public CarDTOPrintOfWorker(List<Car> listCars) {
		c = new ArrayList<>();

		for(int i = 0; i < listCars.size(); i++) {
			c.add(new CarDTOPrintOfWorkerResponse(listCars.get(i)));
		}
	}

	public List<CarDTOPrintOfWorkerResponse> getC() {
		return c;
	}

	public void setC(List<CarDTOPrintOfWorkerResponse> c) {
		this.c = c;
	}
}