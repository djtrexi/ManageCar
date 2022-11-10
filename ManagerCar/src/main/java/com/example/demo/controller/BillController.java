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
import com.example.demo.request.bill.BillGetIdByIdClientAndIdWorkerRequest;
import com.example.demo.request.bill.BillTotBillCashForDeterminedWorkerRequest;
import com.example.demo.response.bill.BillGetIdByIdClientAndIdWorkerResponse;
import com.example.demo.response.bill.BillPrintResponse;
import com.example.demo.response.bill.BillTotBillCashForDeterminedWorkerResponse;
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
	@RequestMapping(method = RequestMethod.PUT, path = "/finishThePayment")
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

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, path = "/billNotFinish")
	public ResponseEntity<BillPrintResponse> billNotFinish() {
		List<Bill> bills = serviceBill.billNotFinish();
		if(bills == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new BillPrintResponse(bills));
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/totBillCashForDeterminedWorker")
	public ResponseEntity<BillTotBillCashForDeterminedWorkerResponse> totBillCashForDeterminedWorker(@RequestBody BillTotBillCashForDeterminedWorkerRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceBill.totBillCashForDeterminedWorker(request.getId()) == -1) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(new BillTotBillCashForDeterminedWorkerResponse(serviceBill.totBillCashForDeterminedWorker(request.getId())));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getIdByIdClientAndIdWorker")
	public ResponseEntity<BillGetIdByIdClientAndIdWorkerResponse> getIdByIdClientAndIdWorker(@RequestBody BillGetIdByIdClientAndIdWorkerRequest request) {
	  if(!request.isValid()) {
		  return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	  }
	  else {
		  if(serviceBill.getIdByIdClientAndIdWorker(request.getIdClient(), request.getIdWorker()) == 0) {
			  return ResponseEntity.status(HttpStatus.CONFLICT).build();
		  }
		  else {
			  return ResponseEntity.status(HttpStatus.OK).body(new BillGetIdByIdClientAndIdWorkerResponse(serviceBill.getIdByIdClientAndIdWorker(request.getIdClient(), request.getIdWorker())));
		  }
	  }
	}
}