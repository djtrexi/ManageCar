package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Door;

public interface DoorRepository extends JpaRepository<Door, Long> {
	@Query("SELECT d FROM Door d WHERE d.isAvailable = true")
	public List<Door> getDoorAvailable();
	
	@Query("SELECT d FROM Door d WHERE d.id = ?1")
	public Door getObjectWithId(long id);
	
	@Query("SELECT d.numberDoor FROM Door d WHERE d.id = ?1")
	public String getNumberDoorById(long id);
}