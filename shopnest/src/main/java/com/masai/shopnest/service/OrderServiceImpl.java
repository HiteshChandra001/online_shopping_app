package com.masai.shopnest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Customer;
import com.masai.shopnest.entity.Order;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.exception.ShopnestException;
import com.masai.shopnest.repository.CustomerRepository;
import com.masai.shopnest.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
		
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order removeOrder(int id) {
		Order order = orderRepository.findById(id).orElseThrow(()->new ShopnestException("no order found with id:"+id));
		orderRepository.deleteById(id);
		return order;
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) {
		List<Order> list = orderRepository.findByOrderDate(date);
		if(list.size()==0)throw new NotFoundException("no order found");
		return list;
	}

	@Override
	public List<Order> viewAllOrderByLocation(String loc) {
		List<Order> list=new ArrayList<>();
		List<Order> orders = orderRepository.findAll();
		for(Order o:orders) {
			if(o.getAddress().getCity().equalsIgnoreCase(loc)) list.add(o);
		}
		
		if(list.size()==0)throw new NotFoundException("no order found for city : "+loc);
		
		return list;
	}

	@Override
	public List<Order> viewAllOrderByUserId(int userId) {
		Customer customer = customerRepository.findById(userId).orElseThrow(()->new ShopnestException("no order found with id:"+userId));
		List<Order> list = orderRepository.findByCustomer(customer);
		if(list.size()==0)throw new NotFoundException("no order found");
		return list;
	}

}
