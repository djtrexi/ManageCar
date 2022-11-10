package com.example.demo.request.car;

public class CarDeleteRequest {
	private long id;

	public CarDeleteRequest() {}

	public CarDeleteRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}