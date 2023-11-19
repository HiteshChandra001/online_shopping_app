package com.masai.shopnest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.exception.ShopnestException;
import com.masai.shopnest.repository.AddressRepository;
import com.masai.shopnest.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		addressRepository.save(customer.getAddress());
		return customerRepository.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = customerRepository.findById(customer.getId()).orElseThrow(()->new ShopnestException("no customer found for id:"+customer.getId()));
		return customerRepository.save(cust);
	}

	@Override
	public Customer removeCustomer(int id) {
		Customer cust = customerRepository.findById(id).orElseThrow(()->new ShopnestException("no customer found for id:"+id));
		customerRepository.deleteById(id);
		return cust;
	}

	@Override
	public Customer viewCustomer(int custId) {
		 return customerRepository.findById(custId).orElseThrow(() -> new NotFoundException("Invalid Customer ID"));
	}

	@Override
	public List<Customer> viewAllCustomerByCity(String city) {
		List<Customer> customer = customerRepository.findAll();
		List<Customer> list = new ArrayList<>();

		for (Customer cust : customer) {

			if (cust.getAddress().getState().equalsIgnoreCase(city)) {
				list.add(cust);
			}
		}

		if(list.size()==0)throw new NotFoundException("No customer found with city: "+city);
		return list;

	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) {
		
		return customerRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("User Not Found"));
		
	}

}
