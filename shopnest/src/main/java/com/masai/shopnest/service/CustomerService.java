package com.masai.shopnest.service;

import java.util.List;

import com.masai.shopnest.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer removeCustomer(int id);
	
	public Customer viewCustomer(int custId);
	
	public List<Customer> viewAllCustomerByCity(String city);
  
  public Customer getCustomerDetailsByEmail(String email);

}
