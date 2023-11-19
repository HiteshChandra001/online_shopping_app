package com.masai.shopnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<Customer> opt= customerRepository.findByEmail(username);

		Customer customer= opt.orElseThrow(()-> new NotFoundException("User Details not found with this username: "+username));
	
			List<GrantedAuthority> auths= new ArrayList<>();	
			
			SimpleGrantedAuthority sga= new SimpleGrantedAuthority(customer.getRole());
			auths.add(sga);
	            	
			return new User(customer.getEmail(),customer.getPassword(),auths);
		
	}

}
