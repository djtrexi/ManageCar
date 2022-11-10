package com.example.demo.response.client;

public class ClientSetDoorClientResponse {
	private String numberDoor;

	public ClientSetDoorClientResponse() {}

	public ClientSetDoorClientResponse(String numberDoor) {
		this.numberDoor = numberDoor;
	}

	public String getNumberDoor() {
		return numberDoor;
	}

	public void setNumberDoor(String numberDor) {
		this.numberDoor = numberDor;
	}
}