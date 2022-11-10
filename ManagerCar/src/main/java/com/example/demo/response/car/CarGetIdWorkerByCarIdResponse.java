package com.example.demo.response.car;

public class CarGetIdWorkerByCarIdResponse {
	private long cod_worker;

	public CarGetIdWorkerByCarIdResponse() {}

	public CarGetIdWorkerByCarIdResponse(long cod_worker) {
		this.cod_worker = cod_worker;
	}

	public long getCod_worker() {
		return cod_worker;
	}

	public void setCod_worker(long cod_worker) {
		this.cod_worker = cod_worker;
	}
}