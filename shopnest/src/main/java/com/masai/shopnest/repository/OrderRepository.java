package com.masai.shopnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.shopnest.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	

}
