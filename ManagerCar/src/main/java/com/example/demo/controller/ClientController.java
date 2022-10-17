package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.request.client.ClientGetIdByEmailRequest;
import com.example.demo.request.client.ClientGetNameByEmailRequest;
import com.example.demo.request.client.ClientLoginRentalRequest;
import com.example.demo.request.client.ClientSignRequest;
import com.example.demo.response.car.ClientGetNameByEmailResponse;
import com.example.demo.response.client.ClientGetIdByEmailResponse;
import com.example.demo.response.client.ClientLoginRentalResponse;
import com.example.demo.response.client.ClientSignResponse;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService serviceClient;

	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.POST, path = "/signClient")
	public ResponseEntity<ClientSignResponse> signClient(@RequestBody ClientSignRequest request){
		if(!request.isValidValue()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			Client c = new Client(request.getName(), request.getSurname(), request.getEmail(), request.getPhone(), request.getPassword());
			if(serviceClient.signClient(c) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(new ClientSignResponse(c));
			}
		}
	}
 
	@CrossOrigin(origins =  "*")
	@RequestMapping(method = RequestMethod.POST, path = "/loginClient")
	public ResponseEntity<ClientLoginRentalResponse> loginRental(@RequestBody ClientLoginRentalRequest request) {
		if(!request.isValidValue()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else { 
			Client c = serviceClient.loginRental(request.getEmail(), request.getPassword());
			if(c == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(new ClientLoginRentalResponse(c));
			}
		} 
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getIdByEmail")
	public ResponseEntity<ClientGetIdByEmailResponse> getIdByEmail(@RequestBody ClientGetIdByEmailRequest request){
		if(request.isValid()) {
			long id = serviceClient.byIdWithEmail(request.getEmail());
			System.out.println(id);
			if(id <= 0) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(new ClientGetIdByEmailResponse(id));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/getNameByEmail")
	public ResponseEntity<ClientGetNameByEmailResponse> getNameByEmail(@RequestBody ClientGetNameByEmailRequest request){
		if(request.isValid()) {
			if(serviceClient.byNameWithEmail(request.getEmail()) == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			else {
				String nameClient = serviceClient.byNameWithEmail(request.getEmail());
				return ResponseEntity.status(HttpStatus.OK).body(new ClientGetNameByEmailResponse(nameClient));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}