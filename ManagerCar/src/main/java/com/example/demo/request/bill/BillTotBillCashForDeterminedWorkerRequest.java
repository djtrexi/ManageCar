package com.example.demo.request.bill;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillTotBillCashForDeterminedWorkerRequest {
	private long id;

	public BillTotBillCashForDeterminedWorkerRequest() {}

	public BillTotBillCashForDeterminedWorkerRequest(long id) {
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