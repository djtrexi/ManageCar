package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
	@Query("SELECT w FROM Worker w WHERE w.email = ?1 AND w.password = ?2 AND w.codWorker = ?3")
	public Worker loginWorker(String email, String password, String codWorker);
}