package com.example.demo.request.worker;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WorkerGetIdByEmailRequest {
	private String email;

	public WorkerGetIdByEmailRequest() {}

	public WorkerGetIdByEmailRequest(String email) {
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