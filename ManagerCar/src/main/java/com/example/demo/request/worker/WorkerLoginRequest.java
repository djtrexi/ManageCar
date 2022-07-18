package com.example.demo.request.worker;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WorkerLoginRequest {
	private String email;
	private String password;

	public WorkerLoginRequest() {}

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
	public boolean isValidThisLogin() {
		if(email.equals("") || password.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
}