package com.masai.shopnest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.repository.CustomerRepository;
import com.masai.shopnest.user.CustomerDetails;

@Service
public class CustomerDetailsService implements UserDetailsService {

	CustomerRepository customerRepository;

	public CustomerDetailsService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Customer customer = customerRepository.findByuserId(username)
				.orElseThrow(() -> new NotFoundException("User Not FOUND"));
		return new CustomerDetails(customer);
	}

}
