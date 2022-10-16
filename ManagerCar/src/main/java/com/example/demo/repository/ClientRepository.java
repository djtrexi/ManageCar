package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("SELECT c FROM Client c WHERE c.email = ?1 AND c.password = ?2")
	public Client loginRental(String email, String password);
	
	@Query("SELECT c.id FROM Client c WHERE c.email = ?1")
	public long byIdWithEmail(String email);
}