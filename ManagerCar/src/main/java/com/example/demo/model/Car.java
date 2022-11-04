package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@Column(nullable = false, unique = true)
	private String numberCar;
	@Column(nullable = true)
	private LocalDate annoPorduzione;
	@Column(nullable = false)
	private boolean isRental;
	@Column(nullable = false)
	private boolean isAvailable;
	private LocalDate dateAvalableStart;
	private LocalDate dateAvalableFinish;
	private LocalDate dateRentalStart;
	private LocalDate dateRentalFinish;
	@Column(nullable = false)
	private double moneyDaily;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codClient")
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codWorker")
	private Worker worker;
	
	@OneToMany(mappedBy = "car")
	private List<Bill> bills;
	
	public Car() {}

	public Car(long id, String model, String brand, String color, String numberCar, LocalDate annoPorduzione, boolean isRental, boolean isAvailable, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, LocalDate dateRentalStart, LocalDate dateRentalFinish, double moneyDaily, Client client, Worker worker, List<Bill> bills) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoPorduzione = annoPorduzione;
		this.isRental = isRental;
		this.isAvailable = isAvailable;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.dateRentalStart = dateRentalStart;
		this.dateRentalFinish = dateRentalFinish;
		this.moneyDaily = moneyDaily;
		this.client = client;
		this.worker = worker;
		this.bills = bills;
	}

	public Car(long id, String model, String brand, String color, String numberCar, LocalDate annoPorduzione, boolean isRental, boolean isAvailable, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, LocalDate dateRentalStart, LocalDate dateRentalFinish, double moneyDaily) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoPorduzione = annoPorduzione;
		this.isRental = isRental;
		this.isAvailable = isAvailable;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.dateRentalStart = dateRentalStart;
		this.dateRentalFinish = dateRentalFinish;
		this.moneyDaily = moneyDaily;
	}

	public Car(String model, String brand, String color, String numberCar, LocalDate annoPorduzione, boolean isRental, boolean isAvailable, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, LocalDate dateRentalStart, LocalDate dateRentalFinish, double moneyDaily) {
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoPorduzione = annoPorduzione;
		this.isRental = isRental;
		this.isAvailable = isAvailable;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.dateRentalStart = dateRentalStart;
		this.dateRentalFinish = dateRentalFinish;
		this.moneyDaily = moneyDaily;
	}

	public Car(String model, String brand, String color, String numberCar, LocalDate annoPorduzione, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, double moneyDaily) {
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoPorduzione = annoPorduzione;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.moneyDaily = moneyDaily;
	}

	public Car(String model, String brand, String color, String numberCar, LocalDate annoPorduzione, LocalDate dateAvalableStart, LocalDate dateAvalableFinish, double moneyDaily, Worker worker) {
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.numberCar = numberCar;
		this.annoPorduzione = annoPorduzione;
		this.dateAvalableStart = dateAvalableStart;
		this.dateAvalableFinish = dateAvalableFinish;
		this.moneyDaily = moneyDaily;
		this.worker = worker;
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

	public boolean isRental() {
		return isRental;
	}

	public void setRental(boolean isRental) {
		this.isRental = isRental;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getNumberCar() {
		return numberCar;
	}

	public void setNumberCar(String numberCar) {
		this.numberCar = numberCar;
	}

	public LocalDate getDateAvalableStart() {
		return dateAvalableStart;
	}

	public void setDateAvalableStart(LocalDate dateAvalableStart) {
		this.dateAvalableStart = dateAvalableStart;
	}

	public LocalDate getDateAvalableFinish() {
		return dateAvalableFinish;
	}

	public void setDateAvalableFinish(LocalDate dateAvakabkeFinish) {
		this.dateAvalableFinish = dateAvakabkeFinish;
	}

	public LocalDate getDateRentalStart() {
		return dateRentalStart;
	}

	public void setDateRentalStart(LocalDate dateRentalStart) {
		this.dateRentalStart = dateRentalStart;
	}

	public LocalDate getDateRentalFinish() {
		return dateRentalFinish;
	}

	public void setDateRentalFinish(LocalDate dateRentalFinish) {
		this.dateRentalFinish = dateRentalFinish;
	}

	public double getMoneyDaily() {
		return moneyDaily;
	}

	public void setMoneyDaily(double moneyDaily) {
		this.moneyDaily = moneyDaily;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}