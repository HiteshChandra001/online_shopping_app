package com.masai.shopnest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.shopnest.entity.Address;
import com.masai.shopnest.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address)
	{
		return new ResponseEntity<Address>(addressService.addAddress(address),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable int id)
	{
		return new ResponseEntity<Address>(addressService.removeAddress(id),HttpStatus.OK);
	}
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address)
	{
		return new ResponseEntity<Address>(addressService.updateAddress(address),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> viewAddressById(@PathVariable Integer id)
	{
		return new ResponseEntity<Address>(addressService.viewAddress(id),HttpStatus.OK);
//		return null;
	}
	
	
}
