package com.example.demo.response.worker;

public class WorkerGetNameByIdResponse {
	private String name;

	public WorkerGetNameByIdResponse() {}

	public WorkerGetNameByIdResponse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}