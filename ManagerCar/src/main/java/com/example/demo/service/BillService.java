package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bill;
import com.example.demo.model.Car;
import com.example.demo.model.Client;
import com.example.demo.model.Door;
import com.example.demo.model.Worker;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DoorRepository;
import com.example.demo.repository.WorkerRepository;

@Service
public class BillService {
	@Autowired
	BillRepository br;

	@Autowired
	WorkerRepository wr;

	@Autowired
	DoorRepository dr;

	@Autowired
	ClientRepository crl;

	public List<Bill> getBillByIdWorker(long id) {
		try {
			return br.getBillByIdWorker(id);
		} catch(Exception e) {
			return null;
		}
	}

	public Boolean finishThePayment(long id) {
		try {
			if(br.finishThePayment(id) == null) {
				return null;
			}
			else {
				Bill b = br.finishThePayment(id);

				long idWorker = br.getIdWorkerByIdBill(id);
				Worker w = wr.getReferenceById(idWorker); 
				if(w == null) {
					return null;
				}
				else {
					Door d = dr.getObjectWithId(w.getDoor().getId());
					if(d == null) {
						return null;
					}
					else {
						long idClient = br.getIdClientByIdBill(id);
						Client c = crl.getReferenceById(idClient);
						if(c == null) {
							return null;
						}
						else {
							d.setAvailable(true);
							w.setDoor(null);
							b.setDone(true);
							b.setPay(true);
							c.setDoor(null);

							dr.save(d);
							wr.save(w);
							br.save(b);
							return true;							
						}
						
					}
				}
			}
		} catch(Exception e) {
			return null;
		}
	}

	public List<Bill> billNotFinish(){
		try {
			return br.billNotFinish();
		} catch(Exception e) {
			return null;
		}
	}
	
	public int totBillCashForDeterminedWorker(long idWorker) {
		try {
			return br.totBillCashForDeterminedWorker(idWorker);
		} catch(Exception e) {
			return -1;
		}
	}
	
	public long getIdByIdClientAndIdWorker(long idClient, long idWorker) {
		try {
			return br.getIdByIdClientAndIdWorker(idClient, idWorker);
		} catch(Exception e) {
			return 0;
		}
	}
}
