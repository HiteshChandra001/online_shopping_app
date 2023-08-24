package com.masai.shopnest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Address;
import com.masai.shopnest.exception.ShopnestException;
import com.masai.shopnest.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	
	public AddressServiceImpl(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	@Override
	public Address addAddress(Address address) {
		addressRepository.save(address);
		return null;
	}

	@Override
	public Address updateAddress(Address address) {
		Address up=addressRepository.findById(address.getAddressId()).orElseThrow(() -> new  ShopnestException("Address Doesnot Exist"));
		
		addressRepository.save(up);
		return up;
	}

	@Override
	public Address removeAddress(Address address) {
	Integer id=	address.getAddressId();
	addressRepository.delete(address);
		return address;
	}

	@Override
	public List<Address> viewAllAddress(Integer id) {
		
		return null;
	}

	@Override
	public Address viewAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
