package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerService {
	@Autowired
	WorkerRepository wr;

	public Worker loginWorker(String email, String password, String codWorker) {
		try {
			if(wr.loginWorker(email, password, codWorker) == null) {
				return null;
			}
			else {
				Worker w = wr.loginWorker(email, password, codWorker);
				w.setWork(true);
				w.setFree(true);
				return w;
			}
		} catch(Exception e) {
			return null;
		}
	}

	public String getNameByEmail(String email) {
		try {
			if(wr.getNameByEmail(email) == null) {
				return null;
			}
			else {
				return wr.getNameByEmail(email);
			}
		} catch(Exception e) {
			return null;
		}
	}
	
	public long getIdByEmail(String email) {
		try {
			if(wr.getIdByEmail(email) <= 0) {
				return 0;
			}
			else {
				return wr.getIdByEmail(email);
			}
		} catch(Exception e) {
			return 0;
		}
	}
	
	public Worker getIdByObject(long id) {
		try {
			if(id <= 0) {
				return null;
			}
			else {
				return wr.getIdByObject(id);
			}
		} catch (Exception e) {
		  return null;
		}
	}
	
	public String getNameById(long id) {
		try {
			if(id <= 0) {
				return null;
			}
			else {
				return wr.getNameById(id);
			}
		} catch(Exception e) {
			return null;
		}
	}
	
	public String getEmailById(long id) {
		try {
			if(id <= 0) {
				return null;
			}
			else {
				return wr.getEmailById(id);
			}
		} catch(Exception e) {
			return null;
		}
	}
}