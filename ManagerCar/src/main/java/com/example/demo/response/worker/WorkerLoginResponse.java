package com.example.demo.response.worker;

import com.example.demo.model.Worker;

public class WorkerLoginResponse {
	private long id;

	public WorkerLoginResponse() {}

	public WorkerLoginResponse(long id) {
		this.id = id;
	}

	public WorkerLoginResponse(Worker w) {
		id = w.getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}