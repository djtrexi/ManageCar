package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DoorRepository;

@Service
public class DoorService {
	@Autowired
	DoorRepository dr;
	
	public String getNumberDoorById(long id) {
		try {
			return dr.getNumberDoorById(id);
		} catch(Exception e) {
			return null;
		}
	}
}