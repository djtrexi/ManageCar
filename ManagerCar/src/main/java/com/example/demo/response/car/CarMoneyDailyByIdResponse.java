package com.example.demo.response.car;

public class CarMoneyDailyByIdResponse {
	private double moneyDaily;

	public CarMoneyDailyByIdResponse() {}

	public CarMoneyDailyByIdResponse(double moneyDaily) {
		this.moneyDaily = moneyDaily;
	}

	public double getMoneyDaily() {
		return moneyDaily;
	}

	public void setMoneyDaily(double moneyDaily) {
		this.moneyDaily = moneyDaily;
	}
}