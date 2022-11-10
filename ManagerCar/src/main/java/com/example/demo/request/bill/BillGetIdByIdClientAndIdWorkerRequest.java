package com.example.demo.request.bill;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillGetIdByIdClientAndIdWorkerRequest {
	private long idClient;
	private long idWorker;

	public BillGetIdByIdClientAndIdWorkerRequest() {}

	public BillGetIdByIdClientAndIdWorkerRequest(long idClient, long idWorker) {
		this.idClient = idClient;
		this.idWorker = idWorker;
	}

	public long getIdClient() {
		return idClient;
	}

	public long getIdWorker() {
		return idWorker;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public void setIdWorker(long idWorker) {
		this.idWorker = idWorker;
	}

	@JsonIgnore
	public boolean isValid() {
		if(idClient <= 0 || idWorker <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}