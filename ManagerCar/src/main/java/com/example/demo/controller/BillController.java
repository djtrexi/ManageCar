package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bill;
import com.example.demo.request.bill.BillFinishThePaymentRequest;
import com.example.demo.request.bill.BillGetBillByIdWorkerRequest;
import com.example.demo.request.bill.BillPrintResponse;
import com.example.demo.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService serviceBill;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getBillByIdWorker")
	public ResponseEntity<BillPrintResponse> getBillByIdWorker(@RequestBody BillGetBillByIdWorkerRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			List<Bill> bills = serviceBill.getBillByIdWorker(request.getId());
			if(bills == null) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(new BillPrintResponse(bills));
			}
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/finishThePayment")
	public ResponseEntity finishThePayment(@RequestBody BillFinishThePaymentRequest request) {
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceBill.finishThePayment(request.getId()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
		}
	}
}