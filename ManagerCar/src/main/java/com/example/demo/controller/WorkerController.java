package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Worker;
import com.example.demo.request.worker.WorkerLoginRequest;
import com.example.demo.response.worker.WorkerLoginResponse;
import com.example.demo.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	WorkerService serviceWorker;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/loginWorker")
	public ResponseEntity<WorkerLoginResponse> loginWorker(@RequestBody WorkerLoginRequest request){
		if(request.isValid()) {
			if(serviceWorker.loginWorker(request.getEmail(), request.getPassword(), request.getCodWorker()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				Worker w = serviceWorker.loginWorker(request.getEmail(), request.getPassword(), request.getCodWorker());
				return ResponseEntity.status(HttpStatus.OK).body(new WorkerLoginResponse(w.getEmail())); 
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}