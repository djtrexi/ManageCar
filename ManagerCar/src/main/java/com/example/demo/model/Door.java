package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Door {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true)
	private String numberDoor;
	@Column(nullable = false)
	private boolean isAvailable;

	@OneToMany(mappedBy = "door")
	private List<Worker> workers;
	
	@OneToMany(mappedBy = "door")
	private List<Client> clients;

	public Door() {}

	public Door(long id, String numberDoor, boolean isAvailable, List<Worker> workers, List<Client> clients) {
		this.id = id;
		this.numberDoor = numberDoor;
		this.isAvailable = isAvailable;
		this.workers = workers;
		this.clients = clients;
	}

	public Door(String numberDoor, boolean isAvailable, List<Worker> workers, List<Client> clients) {
		this.numberDoor = numberDoor;
		this.isAvailable = isAvailable;
		this.workers = workers;
		this.clients = clients;
	}

	public Door(String numberDoor, boolean isAvailable) {
		this.numberDoor = numberDoor;
		this.isAvailable = isAvailable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumberDoor() {
		return numberDoor;
	}

	public void setNumberDoor(String numberDoor) {
		this.numberDoor = numberDoor;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
}
