package com.example.demo.request.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if(name.equals("") || surname.equals("")) {
			return false; 
		}
		else {
			final String PATTERN_REGEX_EMAIL = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			final String PATTERN_REGEX_PASSWORD = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{8,16})";
			
			Pattern patternEmail = Pattern.compile(PATTERN_REGEX_EMAIL);
			Matcher matcher = patternEmail.matcher(email);
			
			Pattern patternPassword = Pattern.compile(PATTERN_REGEX_PASSWORD);
			Matcher matcher2 = patternPassword.matcher(password);
			
			if(!matcher.matches() || !matcher2.matches() ) {
				return false;
			}
			else {
				return true;
			}
		}
	}
}