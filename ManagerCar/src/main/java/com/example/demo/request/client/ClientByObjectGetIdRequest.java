package com.example.demo.request.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientByObjectGetIdRequest {
	private long id;

	public ClientByObjectGetIdRequest() {}

	public ClientByObjectGetIdRequest(long id) {
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
