package com.example.demo.request.car;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarRentalRequest {
	private long idCar;
	private long idClient;
	private LocalDate dateBegin;
	private LocalDate dateFinish;

	public CarRentalRequest() {}

	public CarRentalRequest(long idCar, long idClient, LocalDate dateBegin, LocalDate dateFinish) {
		this.idCar = idCar;
		this.idClient = idClient;
		this.dateBegin = dateBegin;
		this.dateFinish = dateFinish;
	}

	public long getIdCar() {
		return idCar;
	}

	public void setIdCar(long idCar) {
		this.idCar = idCar;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}

	public LocalDate getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(LocalDate dateFinish) {
		this.dateFinish = dateFinish;
	}
	
	@JsonIgnore
	public boolean isValid() {
		if(idCar <= 0 || idClient <= 0) {
			return false;
		}
		else if(dateBegin.equals(null) || dateFinish.equals(null) || dateBegin.isAfter(dateFinish) || dateFinish.isBefore(dateBegin)) {
			return false;
		}
		else {
			return true;
		}
	}
}