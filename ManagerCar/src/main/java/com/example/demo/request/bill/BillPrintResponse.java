package com.example.demo.request.bill;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Bill;

public class BillPrintResponse {
	private List<BillDTOPrint> c;

	public BillPrintResponse() {}

	public BillPrintResponse(List<Bill> listBill) {
		c = new ArrayList<>();

		for(int i = 0; i < listBill.size(); i++) {
			c.add(new BillDTOPrint(listBill.get(i)));
		}
	}

	public List<BillDTOPrint> getC() {
		return c;
	}

	public void setC(List<BillDTOPrint> c) {
		this.c = c;
	}
}