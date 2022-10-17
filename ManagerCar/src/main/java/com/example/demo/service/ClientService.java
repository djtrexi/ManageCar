package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@Service
@Component
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

	public Client loginRental(String email, String password) {
		try {
			Client c = cr.loginRental(email, password);
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
			if(cr.byIdWithEmail(email) == 0) {
				return -1;
			}
			else {
				return cr.byIdWithEmail(email);
			}
		} catch(Exception e) {
			return -1;
		}
	}
	
	public String byNameWithEmail(String email) {
		try {
			if(cr.byNameWithEmail(email) == null) {
				return null;
			}
			else {
				return cr.byNameWithEmail(email);
			}
		} catch(Exception e) {
			return null;
		}
	}
}