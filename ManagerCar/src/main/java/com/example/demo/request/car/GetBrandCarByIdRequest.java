package com.example.demo.request.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetBrandCarByIdRequest {
	private long id;

	public GetBrandCarByIdRequest() {}

	public GetBrandCarByIdRequest(long id) {
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