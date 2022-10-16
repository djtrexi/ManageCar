package com.example.demo.request.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientLoginRentalRequest {
	private String email;
	private String password;

	public ClientLoginRentalRequest() {}
	
	public ClientLoginRentalRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
  
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public boolean isValidValue() {
		if(email.equals("") || password.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
}