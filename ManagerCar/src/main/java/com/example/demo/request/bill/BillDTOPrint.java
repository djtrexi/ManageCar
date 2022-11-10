package com.example.demo.request.bill;

public class BillDTOPrint {
	private long id;
	private long idWorker;
	private long idClient;
	private long idCar;

	public BillDTOPrint() {}

	public BillDTOPrint(long id, long idWorker, long idClient, long idCar) {
		this.id = id;
		this.idWorker = idWorker;
		this.idClient = idClient;
		this.idCar = idCar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(long idWorker) {
		this.idWorker = idWorker;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public long getIdCar() {
		return idCar;
	}

	public void setIdCar(long idCar) {
		this.idCar = idCar;
	}
}