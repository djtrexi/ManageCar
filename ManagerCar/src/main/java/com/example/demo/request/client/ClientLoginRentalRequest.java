package com.example.demo.request.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		final String PATTERN_REGEX_EMAIL = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		final String PATTERN_REGEX_PASSWORD = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16})";
		
		Pattern patternEmail = Pattern.compile(PATTERN_REGEX_EMAIL);
		Matcher matcher = patternEmail.matcher(email);
		
		Pattern patternPassword = Pattern.compile(PATTERN_REGEX_PASSWORD);
		Matcher matcher2 = patternPassword.matcher(password);
		
		if(!matcher.matches() || !matcher2.matches()) {
			return false;
		}
		else {
			return true;
		}
	}
}