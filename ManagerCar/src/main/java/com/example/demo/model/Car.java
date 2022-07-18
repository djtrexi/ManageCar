package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String color;
	private LocalDate annoPorduzione;

	@ManyToMany
	@JoinTable(name = "rental", joinColumns = @JoinColumn(name = "codCar"), inverseJoinColumns = @JoinColumn(name = "codClient"))
	private List<Client> clients = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "manage", joinColumns = @JoinColumn(name = "codCar"), inverseJoinColumns = @JoinColumn(name = "codWorker"))
	private List<Worker> workers = new ArrayList<>();

	public Car() {}

	public Car(long id, String model, String brand, String color, LocalDate annoPorduzione) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.annoPorduzione = annoPorduzione;
	}

	public Car(String model, String brand, String color, LocalDate annoPorduzione) {
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.annoPorduzione = annoPorduzione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getAnnoPorduzione() {
		return annoPorduzione;
	}

	public void setAnnoPorduzione(LocalDate annoPorduzione) {
		this.annoPorduzione = annoPorduzione;
	}
}