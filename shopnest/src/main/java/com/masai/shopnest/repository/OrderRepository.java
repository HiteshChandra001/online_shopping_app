package com.masai.shopnest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findByOrderDate(LocalDate ld);
	List<Order> findByCustomer(Customer cust);
}
