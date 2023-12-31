package com.masai.shopnest.service;

import java.util.List;

import com.masai.shopnest.entity.Address;

public interface AddressService {

	public Address addAddress(Address address);
		
	public Address updateAddress(Address address);
	
	public Address removeAddress(int id);
	
	public List<Address> viewAllAddress(Integer id);
	
	public Address viewAddress(Integer id);
	
}
