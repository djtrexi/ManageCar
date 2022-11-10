package com.example.demo.response.client;

import com.example.demo.model.Client;

public class ClientByObjectGetIdResponse {
	private String name;
	private String surname;

	public ClientByObjectGetIdResponse() {}
	
	public ClientByObjectGetIdResponse(Client c) {
		name = c.getName();
		surname = c.getSurname();
	}

	public ClientByObjectGetIdResponse(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
