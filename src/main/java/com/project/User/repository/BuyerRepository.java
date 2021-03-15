package com.project.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.User.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

	public Buyer findByPhoneNumber(String phoneNumber);
	public Buyer findByEmail(String email);
	
	
	
	
}
