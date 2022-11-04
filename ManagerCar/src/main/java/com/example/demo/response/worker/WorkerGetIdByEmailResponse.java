package com.example.demo.response.worker;

public class WorkerGetIdByEmailResponse {
	private long id;

	public WorkerGetIdByEmailResponse() {}

	public WorkerGetIdByEmailResponse(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}