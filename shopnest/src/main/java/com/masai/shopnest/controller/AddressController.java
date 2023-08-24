package com.masai.shopnest.controller;

import java.util.List;

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

	private AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping("/addresses")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address)
	{
		
		return new ResponseEntity<Address>(addressService.addAddress(address),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("addresses")
	public ResponseEntity<Address> deleteAddress(@RequestBody Address address)
	{
		return new ResponseEntity<Address>(addressService.removeAddress(address),HttpStatus.OK);
	}
	
	@PutMapping("/addresses")
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
