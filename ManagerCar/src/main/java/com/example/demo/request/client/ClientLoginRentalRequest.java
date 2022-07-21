package com.example.demo.request.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientLoginRentalRequest {
	private String email;
	private String phone;

	public ClientLoginRentalRequest() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonIgnore
	public boolean isValidValue() {
		if(email.equals("") || phone.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
}