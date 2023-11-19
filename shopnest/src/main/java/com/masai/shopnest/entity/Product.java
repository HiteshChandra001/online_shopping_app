package com.masai.shopnest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(unique=true,nullable=false)
	private String productName;

	@Column(nullable=false)
	private double price;
	
	private String color;
	
	private String dimension;
	
	private String specification;

	@Column(nullable=false)
	private int quantity;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	@JsonIgnore
	@ManyToOne
	private Cart cart;
	
	@JsonIgnore
	@ManyToOne
	private Order order;
	
}
