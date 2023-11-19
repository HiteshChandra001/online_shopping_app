package com.masai.shopnest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private String firstName;

	@Column(nullable=false)
	private String lastName;

	@Column(nullable=false)
	private String mobileNumber;

	@Column(nullable=false,unique=true)
	private String email;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	@Column(nullable=false)
	private String role;
	
	@OneToOne
	private Address address;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
	private List<Order> orders;
	
	@JsonIgnore
	@OneToOne
	private Cart cart;

}
