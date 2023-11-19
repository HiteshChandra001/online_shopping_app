package com.masai.shopnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Address;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.exception.ShopnestException;
import com.masai.shopnest.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	

	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		Address up=addressRepository.findById(address.getAddressId()).orElseThrow(() -> new  ShopnestException("Address Doesnot Exist"));
		addressRepository.save(address);
		return up;
	}

	@Override
	public Address removeAddress(int id) {
		Address ad=addressRepository.findById(id).orElseThrow(() -> new  ShopnestException("Address Doesnot Exist"));
		addressRepository.deleteById(id);
		return ad;
	}

	
	@Override
	public Address viewAddress(Integer id) {
		Address up=addressRepository.findById(id).orElseThrow(() -> new  ShopnestException("Address Doesnot Exist"));
		return up;
	}

	@Override
	public List<Address> viewAllAddress(Integer id) {
		List<Address> list = addressRepository.findAll();
		if(list.size()==0) throw new NotFoundException("no address found");
		return list;
	}

}
