package com.example.demo.request.bill;

import com.example.demo.model.Bill;
import com.example.demo.model.Car;
import com.example.demo.model.Client;
import com.example.demo.model.Worker;

public class BillDTOPrint {
	private long id;
	private Worker worker;
	private Client client;
	private Car car;

	public BillDTOPrint() {}

	public BillDTOPrint(Bill b) {
		id = b.getId();
		worker = b.getWorker();
		client = b.getClient();
		car = b.getCar();
	}

	public BillDTOPrint(long id, Worker worker, Client client, Car car) {
		this.id = id;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}