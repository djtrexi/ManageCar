package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	@Query("SELECT b FROM Bill b WHERE b.worker.id = ?1")
	public List<Bill> getBillByIdWorker(long id);
	
	@Query("SELECT b FROM Bill b WHERE b.id = ?1")
	public Bill finishThePayment(long id);
	
	@Query("SELECT b FROM Bill b WHERE b.client.id = ?1 AND b.worker.id = ?2 AND b.done = false AND b.pay = false")
	public long getIdByIdClientAndIdWorker(long idClient, long idWorker);
	
	@Query("SELECT b.worker.id FROM Bill b WHERE b.id = ?1")
	public long getIdWorkerByIdBill(long id);
	
	@Query("SELECT b.client.id FROM Bill b WHERE b.id = ?1")
	public long getIdClientByIdBill(long id);
	
	@Query("SELECT b FROM Bill b WHERE b.typePay = 1")
	public List<Bill> billNotFinish();
	
	@Query("SELECT COUNT(b) FROM Bill b WHERE b.worker.id = ?1 AND b.typePay = 1 AND b.done = false")
	public int totBillCashForDeterminedWorker(long idWorker);
}