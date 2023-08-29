package com.masai.shopnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		System.out.println("reached here");
		Optional<Customer> opt= customerRepository.findByEmail(username);
		System.out.println("reached after finding");

		Customer customer=	  opt.orElseThrow(()-> new NotFoundException("User Details not found with this username: "+username));
	
			List<GrantedAuthority> authorities= new ArrayList<>();	
			
			SimpleGrantedAuthority sga= new SimpleGrantedAuthority(customer.getUser().getRole());
			authorities.add(sga);
	            	
			return new User(customer.getEmail(), customer.getUser().getPassword(), authorities);
		
	}

}
