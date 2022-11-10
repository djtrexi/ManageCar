package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Door;
import com.example.demo.model.Worker;
import com.example.demo.repository.DoorRepository;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerService {
	@Autowired
	WorkerRepository wr;

	@Autowired
	DoorRepository dr;
	
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
	
	public Worker getObjectById(long id) {
		try {
			return wr.getObjectById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	public Boolean setDoorForWorkWorker() {
		try {
			if(wr.searchWorkerFree() == null || dr.getDoorAvailable() == null) {
				return null;
			}
			else {
				List<Worker> workers = wr.searchWorkerFree();
				List<Door> doors = dr.getDoorAvailable();
				
				workers.get(0).setDoor(doors.get(0));
				wr.save(workers.get(0));
				return true;
			}
		} catch(Exception e) {
			return null;
		}
	}
}