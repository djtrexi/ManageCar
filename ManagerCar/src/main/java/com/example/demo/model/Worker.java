package com.example.demo.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private LocalTime startWork;
	private LocalTime finishWork;
	private boolean free;
	private boolean work;

	@OneToMany(mappedBy = "worker")
	private List<Car> cars;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codDoor")
	private Door door;

	@OneToMany(mappedBy = "worker")
	private List<Bill> bills; 

	public Worker() {}

	public Worker(long id, String name, String surname, String email, String password, String codWorker, LocalTime startWork, LocalTime finishWork, boolean free, boolean work, List<Car> cars, Door door,List<Bill> bills) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.codWorker = codWorker;
		this.startWork = startWork;
		this.finishWork = finishWork;
		this.free = free;
		this.work = work;
		this.cars = cars;
		this.door = door;
		this.bills = bills;
	}

	public Worker(long id, String name, String surname, String email, String password, String codWorker) {
		this.id = id;
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

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

	public LocalTime getStartWork() {
		return startWork;
	}

	public void setStartWork(LocalTime startWork) {
		this.startWork = startWork;
	}

	public LocalTime getFinishWork() {
		return finishWork;
	}

	public void setFinishWork(LocalTime finishWork) {
		this.finishWork = finishWork;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}