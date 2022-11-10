package com.example.demo.response.worker;

public class WorkerGetEmailByIdResponse {
	private String email;

	public WorkerGetEmailByIdResponse() {}

	public WorkerGetEmailByIdResponse(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}