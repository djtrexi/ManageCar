package com.example.demo.request.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarUpdatePaymentRequest {
	private long id;
	private double totalMoneyRental;
	private boolean typePay;

	public CarUpdatePaymentRequest() {}

	public CarUpdatePaymentRequest(long id, double totalMoneyRental, boolean typePay) {
		this.id = id;
		this.totalMoneyRental = totalMoneyRental;
		this.typePay = typePay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalMoneyRental() {
		return totalMoneyRental;
	}

	public void setTotalMoneyRental(double totalMoneyRental) {
		this.totalMoneyRental = totalMoneyRental;
	}

	public boolean isTypePay() {
		return typePay;
	}

	public void setTypePay(boolean typePay) {
		this.typePay = typePay;
	}

	@JsonIgnore
	public boolean isValid() {
		if(id <= 0 || totalMoneyRental < 0) {
			return false;
		}
		else {
			return true;
		}
	}
}