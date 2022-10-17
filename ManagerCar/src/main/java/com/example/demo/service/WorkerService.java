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
			  return wr.loginWorker(email, password, codWorker);
		  }
	  } catch(Exception e) {
		  return null;
	  }
  }
}