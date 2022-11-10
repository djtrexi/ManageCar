package com.example.demo.response.client;

public class ClientGetIdByEmailResponse {
	private long id;

	public ClientGetIdByEmailResponse() {}

	public ClientGetIdByEmailResponse(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}