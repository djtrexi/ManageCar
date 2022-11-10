package com.example.demo.response.worker;

import com.example.demo.model.Worker;

public class WorkerGetObjectByIdResponse {
	private String name;
	private String surname;

	public WorkerGetObjectByIdResponse() {}

	public WorkerGetObjectByIdResponse(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public WorkerGetObjectByIdResponse(Worker w) {
		this.name = w.getName();
		this.surname = w.getSurname();
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
