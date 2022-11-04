package com.example.demo.response.car;

public class CarGetIsRentalByIdResponse {
	private boolean isAvailable;

	public CarGetIsRentalByIdResponse() {}

	public CarGetIsRentalByIdResponse(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}