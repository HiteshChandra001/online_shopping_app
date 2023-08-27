package com.masai.shopnest.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String userId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String role;

	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Customer> customers = new ArrayList<>();

}
