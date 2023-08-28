package com.masai.shopnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.service.CustomerService;
import com.masai.shopnest.user.CustomerDetails;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	CustomerService customerService;
	PasswordEncoder passwordEncoder;

	
     @Autowired
	public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder) {
		super();
		this.customerService = customerService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		String password = customer.getUser().getPassword();
	 String encoded = 	passwordEncoder.encode(password);
	     customer.getUser().setPassword(encoded);	
	     String role ="ROLE_"+customer.getUser().getRole().toUpperCase();
	     customer.getUser().setRole(role);
	 return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping("/customers")
	public ResponseEntity<Customer> removeCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.removeCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("/customers/{custId}")
	public ResponseEntity<Customer> viewCustomer(@Valid @PathVariable int custId) {
		return new ResponseEntity<Customer>(customerService.viewCustomer(custId), HttpStatus.OK);
	}

	@GetMapping("/customersbylocation/{loc}")
	public ResponseEntity<List<Customer>> viewCustomer(@Valid @PathVariable String loc) {
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomer(loc), HttpStatus.OK);
	}

	@GetMapping("/signIn")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
		

		System.out.println(auth); // this Authentication object having Principle object details

		Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		

		return new ResponseEntity<>(customer.getFirstName()+auth.getCredentials() + " Logged In Successfully", HttpStatus.ACCEPTED);
	}
}
