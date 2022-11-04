package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
	@Query("SELECT w FROM Worker w WHERE w.email = ?1 AND w.password = ?2 AND w.codWorker = ?3")
	public Worker loginWorker(String email, String password, String codWorker);
	
	@Query("SELECT w.name FROM Worker w WHERE w.email = ?1")
	public String getNameByEmail(String email);
	
	@Query("SELECT w.id FROM Worker w WHERE w.email = ?1")
	public long getIdByEmail(String email);
	
	@Query("SELECT w FROM Worker w WHERE w.id = ?1")
	public Worker getIdByObject(long id);
	
	@Query("SELECT w.name FROM Worker w WHERE w.id = ?1")
	public String getNameById(long id);
	
	@Query("SELECT w.email FROM Worker w WHERE w.id = ?1")
	public String getEmailById(long id);
	
	@Query("SELECT w FROM Worker w WHERE w.work = true AND w.free = true AND w.door.id IS NOT NULL")
	public List<Worker> searchWorkerFree();
	
	@Query("SELECT w.door.id FROM Worker w WHERE w.id = ?1")
	public long getIdDoorByIdWorker(long id);
}