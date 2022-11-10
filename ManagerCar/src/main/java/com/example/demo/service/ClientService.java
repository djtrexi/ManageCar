package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.model.Door;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DoorRepository;

@Service
@Component
public class ClientService {
	@Autowired
	ClientRepository cr;

	@Autowired
	DoorRepository dr;

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

	public String setDoorClient(long id) {
		try {
			if(dr.getDoorAvailable() == null) {
				return null;
			}
			else {
				List<Door> doors = new ArrayList<>();
				doors = dr.getDoorAvailable();
				Door d = doors.get(0);
				Client c = cr.getReferenceById(id);
				if(c == null) {
					return null;
				}
				else {
					c.setDoor(d);
					dr.save(d);
					return d.getNumberDoor();
				}
			}
		} catch(Exception e) {
			return null;
		}
	}
	
	public Client byObjectGetId(long id) {
		try {
			return cr.byObjectGetId(id);
		} catch(Exception e) {
			return null;
		}
	}
}