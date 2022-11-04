package com.example.demo.request.bill;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillGetBillByIdWorkerRequest {
	private long id;

	public BillGetBillByIdWorkerRequest() {}

	public BillGetBillByIdWorkerRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public boolean isValid() {
		if(id <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}