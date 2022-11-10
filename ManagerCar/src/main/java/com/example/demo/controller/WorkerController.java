package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.worker.WorkerGetEmailByIdRequest;
import com.example.demo.request.worker.WorkerGetNameByEmailRequest;
import com.example.demo.request.worker.WorkerGetObjectByIdRequest;
import com.example.demo.request.worker.WorkerLoginRequest;
import com.example.demo.request.worker.WorkergGetNameByIdRequest;
import com.example.demo.response.worker.WorkerGetEmailByIdResponse;
import com.example.demo.response.worker.WorkerGetIdByEmailResponse;
import com.example.demo.response.worker.WorkerGetNameByEmailResponse;
import com.example.demo.response.worker.WorkerGetNameByIdResponse;
import com.example.demo.response.worker.WorkerGetObjectByIdResponse;
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
				return ResponseEntity.status(HttpStatus.OK).body(new WorkerLoginResponse(request.getEmail())); 
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getNameByEmail")
	public ResponseEntity<WorkerGetNameByEmailResponse> getNameByEmail(@RequestBody WorkerGetNameByEmailRequest request){
		if(request.isValid()) {
			if(serviceWorker.getNameByEmail(request.getEmail()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				String name = serviceWorker.getNameByEmail(request.getEmail());
				return ResponseEntity.status(HttpStatus.OK).body(new WorkerGetNameByEmailResponse(name));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getIdByEmail")
	public ResponseEntity<WorkerGetIdByEmailResponse> getIdByEmail(@RequestBody WorkerGetNameByEmailRequest request){
		if(request.isValid()) {
			if(serviceWorker.getIdByEmail(request.getEmail()) == 0) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				long id = serviceWorker.getIdByEmail(request.getEmail());
				return ResponseEntity.status(HttpStatus.OK).body(new WorkerGetIdByEmailResponse(id));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getNameById")
	public ResponseEntity<WorkerGetNameByIdResponse> getNameById(@RequestBody WorkergGetNameByIdRequest request){
		if(serviceWorker.getNameById(request.getId()) == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			String name = serviceWorker.getNameById(request.getId());
			return ResponseEntity.status(HttpStatus.OK).body(new WorkerGetNameByIdResponse(name));
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getEmailById")
	public ResponseEntity<WorkerGetEmailByIdResponse> getEmailById(@RequestBody WorkerGetEmailByIdRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			if(serviceWorker.getEmailById(request.getId()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				String email = serviceWorker.getEmailById(request.getId());
				return ResponseEntity.status(HttpStatus.OK).body(new WorkerGetEmailByIdResponse(email));
			}
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getObjectByIdRequest")
	public ResponseEntity<WorkerGetObjectByIdResponse> getObjectByIdRequest (@RequestBody WorkerGetObjectByIdRequest request){
		if(!request.isValid()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
		  if(serviceWorker.getObjectById(request.getId()) == null) {
			  return ResponseEntity.status(HttpStatus.CONFLICT).build();
		  }
		  else {
			  return ResponseEntity.status(HttpStatus.OK).body(new WorkerGetObjectByIdResponse(serviceWorker.getObjectById(request.getId())));
		  }
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, path = "/setDoorForWorkWorker")
	public ResponseEntity setDoorForWorkWorker() {
		if(serviceWorker.setDoorForWorkWorker() == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
}