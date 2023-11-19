package com.masai.shopnest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column(nullable=false)
	private String streetNo;

	@Column(nullable=false)
	private String buildingName;

	@Column(nullable=false,unique=true)
	private String city;

	@Column(nullable=false)
	private String state;

	@Column(nullable=false)
	private String country;

	@Column(nullable=false)
	private String pincode;

}
