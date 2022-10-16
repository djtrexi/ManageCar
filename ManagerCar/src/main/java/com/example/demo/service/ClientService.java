package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository cr;

	public Client signClient(Client c) {
		try {
			cr.save(c); 
			return c;
		} catch(Exception e) {
			return null;
		}
	}

	public Client loginRental(String email, String phone) {
		try {
			Client c = cr.loginRental(email, phone);
			if(c != null) {
				return c;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}
	
	public long byIdWithEmail(String email) {
		try {
			if(cr.byIdWithEmail(email) == 0L) {
				return -1;
			}
			else {
				return cr.byIdWithEmail(email);
			}
		} catch(Exception e) {
			return -1;
		}
	}
}