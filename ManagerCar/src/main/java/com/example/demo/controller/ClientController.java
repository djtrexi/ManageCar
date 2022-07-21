package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.request.client.ClientLoginRentalRequest;
import com.example.demo.request.client.ClientSignRequest;
import com.example.demo.response.client.ClientSignResponse;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService serviceClient;

	@RequestMapping(method = RequestMethod.POST, path = "/loginClient")
	public ResponseEntity<ClientSignResponse> loginRental(@RequestBody ClientSignRequest request) {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/signClient")
	public ResponseEntity<ClientLoginRentalRequest> signClient(@RequestBody ClientLoginRentalRequest request){
		
	}
}