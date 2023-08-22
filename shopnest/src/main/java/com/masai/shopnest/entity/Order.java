package com.masai.shopnest.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_entity")
public class Order {

	private int orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	
}
