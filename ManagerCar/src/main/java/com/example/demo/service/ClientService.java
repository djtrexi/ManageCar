package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository cr;

	public Client LoginRental(Client c) {
		try {
			if(cr.LoginRental(c) == null) {
				cr.save(c);
				return c;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}
	
	
}