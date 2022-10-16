package com.example.demo.request.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientSignRequest {
	private String name;
	private String surname;
	private String email;
	private String phone; 
	private String password;

	public ClientSignRequest() {}

	public ClientSignRequest(String name, String surname, String email, String phone, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public boolean isValidValue() {
		if(name.equals("") || surname.equals("") || email.equals("") || phone.equals("")) {
			return false; 
		}
		else if(password.equals("") || password.length() <= 5) {
			return false;
		}
		else {
			return true;
		}
	}
}