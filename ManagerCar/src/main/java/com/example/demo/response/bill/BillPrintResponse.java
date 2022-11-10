package com.example.demo.response.bill;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Bill;
import com.example.demo.model.Worker;
import com.example.demo.request.bill.BillDTOPrint;

public class BillPrintResponse {
	private List<BillDTOPrint> c;

	public BillPrintResponse() {}

	public BillPrintResponse(List<Bill> listBill) {
		c = new ArrayList<>();
		long idWorker = 0, idCar = 0, idClient = 0;

		for(int i = 0; i < listBill.size(); i++) {
			idWorker = listBill.get(i).getWorker().getId();
			idCar = listBill.get(i).getCar().getId();
			idClient = listBill.get(i).getClient().getId();
			c.add(new BillDTOPrint(listBill.get(i).getId(), idWorker, idClient, idCar));
		}
	}

	public List<BillDTOPrint> getC() {
		return c;
	}

	public void setC(List<BillDTOPrint> c) {
		this.c = c;
	}
}