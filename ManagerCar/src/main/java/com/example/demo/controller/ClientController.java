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
import com.example.demo.response.client.ClientLoginRentalResponse;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService serviceClient;

	@RequestMapping(method = RequestMethod.POST, path = "/loginClient")
	public ResponseEntity<ClientLoginRentalResponse> loginRental(@RequestBody ClientLoginRentalRequest request) {
		Client c = new Client(request.getName(), request.getSurname(), request.getEmail(), request.getPhone());
		if(c == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(new ClientLoginRentalResponse(c));
		}
	}
}