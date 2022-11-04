package com.example.demo.request.car;

import java.time.LocalDate;

import com.example.demo.model.Worker;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarAddRequest {
	private String model;
	private String brand;
	private String color;
	private String numberCar;
	private LocalDate annoProduzione;
	private LocalDate dateAvalableStart;
	private LocalDate dateAvalableFinish;
	private double moneyDaily;
	private long idWorker;

	public CarAddRequest() {}

	public CarAddRequest(String model, String brand, String color, String numberCar, LocalDate annoProduzione, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, double moneyDaily, long idWorker) {
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoProduzione = annoProduzione;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.moneyDaily = moneyDaily;
		this.idWorker = idWorker;
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

	public double getMoneyDaily() {
		return moneyDaily;
	}

	public void setMoneyDaily(double moneyDaily) {
		this.moneyDaily = moneyDaily;
	}

	public long getidWorker() {
		return idWorker;
	}

	public void setCod_worker(long idWorker) {
		this.idWorker = idWorker;
	}

	@JsonIgnore
	public boolean isValid() {
		if(model.equals("") || brand.equals("") || color.equals("") || numberCar.equals("")) {
			return false;
		}
		else if(annoProduzione == null || dateAvalableFinish == null || dateAvalableStart == null || annoProduzione.isAfter(dateAvalableFinish) || annoProduzione.isAfter(dateAvalableFinish) || dateAvalableFinish.isBefore(dateAvalableStart) || dateAvalableStart.isAfter(dateAvalableFinish)) {
			return false;
		}
		else {
			return true;
		}
	}
}