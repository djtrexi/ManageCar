package com.example.demo.request.worker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WorkerLoginRequest {
	private String email;
	private String password;
	private String codWorker;

	public WorkerLoginRequest() {}

	public WorkerLoginRequest(String email, String password, String codWorker) {
		this.email = email;
		this.password = password;
		this.codWorker = codWorker;
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

	public String getCodWorker() {
		return codWorker;
	}

	public void setCodWorker(String codWorker) {
		this.codWorker = codWorker;
	}
	
	@JsonIgnore
	public boolean isValid() {
		final String PATTERN_REGEX_EMAIL = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		final String PATTERN_REGEX_PASSWORD = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{8,16})";
		
		Pattern patternEmail = Pattern.compile(PATTERN_REGEX_EMAIL);
		Matcher matcher = patternEmail.matcher(email);
		
		Pattern patternPassword = Pattern.compile(PATTERN_REGEX_PASSWORD);
		Matcher matcher2 = patternPassword.matcher(password);
		
		if(!matcher.matches() || !matcher2.matches() || codWorker.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
}