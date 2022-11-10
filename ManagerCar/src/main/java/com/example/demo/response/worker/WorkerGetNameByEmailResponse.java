package com.example.demo.response.worker;

public class WorkerGetNameByEmailResponse {
	private String name;

	public WorkerGetNameByEmailResponse() {}

	public WorkerGetNameByEmailResponse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
