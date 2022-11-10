package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = true)
	private String description;
	@Column(nullable = true)
	private boolean done;
	@Column(nullable = true)
	private double totalMoneyRental;
	@Column(nullable = true)
	private boolean typePay;
	@Column(nullable = true)
	private boolean pay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codWorker")
	private Worker worker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codClient")
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codCar")
	private Car car;
	
	public Bill() {}

	public Bill(long id, String description, boolean done, double totalMoneyRental, boolean typePay, boolean pay, Worker worker, Client client, Car car) {
		this.id = id;
		this.description = description;
		this.done = done;
		this.totalMoneyRental = totalMoneyRental;
		this.typePay = typePay;
		this.pay = pay;
		this.worker = worker;
		this.client = client;
		this.car = car;
	}

	public Bill(double totalMoneyRental, boolean typePay, boolean pay, Worker worker, Client client, Car car) {
		this.totalMoneyRental = totalMoneyRental;
		this.typePay = typePay;
		this.pay = pay;
		this.worker = worker;
		this.client = client;
		this.car = car;
	}

	public Bill(double totalMoneyRental, boolean typePay, Worker worker, Client client, Car car) {
		this.totalMoneyRental = totalMoneyRental;
		this.typePay = typePay;
		this.worker = worker;
		this.client = client;
		this.car = car;
	}

	public Bill(Worker worker, Client client, Car car) {
		this.worker = worker;
		this.client = client;
		this.car = car;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public double getTotalMoneyRental() {
		return totalMoneyRental;
	}

	public void setTotalMoneyRental(double totalMoneyRental) {
		this.totalMoneyRental = totalMoneyRental;
	}

	public boolean isTypePay() {
		return typePay;
	}

	public void setTypePay(boolean typePay) {
		this.typePay = typePay;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}
}