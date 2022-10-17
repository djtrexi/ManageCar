package com.example.demo.response.worker;

public class WorkerLoginResponse {
	private String email;

	public WorkerLoginResponse() {}

	public WorkerLoginResponse(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}