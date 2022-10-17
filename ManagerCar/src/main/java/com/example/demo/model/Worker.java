package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, unique = true)
	private String codWorker;

	@OneToMany(mappedBy = "worker")
	private List<Car> cars;

	public Worker() {}

	public Worker(long id, String name, String surname, String email, String password, String codWorker, List<Car> cars) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.codWorker = codWorker;
		this.cars = cars;
	}

	public Worker(long id, String name, String surname, String email, String password, String codWorker) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.codWorker = codWorker;
	}

	public Worker(String name, String surname, String email, String password, String codWorker, List<Car> cars) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.codWorker = codWorker;
		this.cars = cars;
	}

	public Worker(String name, String surname, String email, String password, String codWorker) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.codWorker = codWorker;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodWorker() {
		return codWorker;
	}

	public void setCodWorker(String codWorker) {
		this.codWorker = codWorker;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}