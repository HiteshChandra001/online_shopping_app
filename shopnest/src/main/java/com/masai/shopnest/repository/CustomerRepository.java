package com.masai.shopnest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.shopnest.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	Optional<Customer> findByEmail(String email);
	
}
	