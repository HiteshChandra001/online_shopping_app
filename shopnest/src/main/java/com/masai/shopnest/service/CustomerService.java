package com.masai.shopnest.service;

import java.util.List;

import com.masai.shopnest.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer removeCustomer(Customer customer);
	
	public Customer viewCustomer(int custId);
	
	public List<Customer> viewAllCustomer(String location);
	
  public Customer getCustomerByUserID(String userId);

}
