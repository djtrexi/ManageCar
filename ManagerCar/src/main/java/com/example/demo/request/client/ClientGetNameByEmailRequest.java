package com.example.demo.request.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientGetNameByEmailRequest {
	private String email;

	public ClientGetNameByEmailRequest() {}

	public ClientGetNameByEmailRequest(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public boolean isValid() {
		if(email.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
}