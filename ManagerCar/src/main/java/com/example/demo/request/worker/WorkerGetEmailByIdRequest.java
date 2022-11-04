package com.example.demo.request.worker;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WorkerGetEmailByIdRequest {
	private long id;

	public WorkerGetEmailByIdRequest() {}

	public WorkerGetEmailByIdRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public boolean isValid() {
		if(id <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}