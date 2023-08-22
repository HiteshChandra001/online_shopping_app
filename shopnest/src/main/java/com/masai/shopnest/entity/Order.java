package com.masai.shopnest.entity;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_entity")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Map<Integer, Product> productList;
	
	@OneToOne
	private Address address;
	
	@OneToOne
	private Customer customer;
	
	
}
