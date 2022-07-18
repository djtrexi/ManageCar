package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;
import com.example.demo.model.Client;
import com.example.demo.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{
	@Query("SELECT w FROM Worker w WHERE w.email = ?1 AND w.password = ?2")
	public Client login(String email, String password);
}