package com.example.demo.request.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarGetIdWorkerByCarIdRequest {
	private long id;

	public CarGetIdWorkerByCarIdRequest() {}

	public CarGetIdWorkerByCarIdRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public boolean isValid() {
		if(id <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}