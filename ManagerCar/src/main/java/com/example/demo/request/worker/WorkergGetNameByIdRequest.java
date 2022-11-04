package com.example.demo.request.worker;

public class WorkergGetNameByIdRequest {
	private long id;

	public WorkergGetNameByIdRequest() {}

	public WorkergGetNameByIdRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
