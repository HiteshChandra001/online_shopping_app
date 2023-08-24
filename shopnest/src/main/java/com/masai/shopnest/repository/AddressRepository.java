package com.masai.shopnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.shopnest.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
