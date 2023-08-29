package com.masai.shopnest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		customerRepository.delete(customer);
		return customer;
	}

	@Override
	public Customer viewCustomer(int custId) {
		return customerRepository.findById(custId).orElseThrow(() -> new NotFoundException("Invalid Customer ID"));
	}

	@Override
	public List<Customer> viewAllCustomer(String location) {
		List<Customer> customer = customerRepository.findAll();
		List<Customer> customerLoc = new ArrayList<>();

		for (Customer cust : customer) {

			if (cust.getAddress().getState().equalsIgnoreCase(location)) {
				customerLoc.add(cust);
			}
		}

		return customerLoc;

	}

	@Override
	public Customer getCustomerByUserID(String email) {
		return customerRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Invalid Customer ID"));

	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) {
		
		return customerRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("User Not Found"));
		
	}

	@Override
	public List<Customer> getAllCustomer() {
	return  customerRepository.findAll();
	}

}
