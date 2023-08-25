package com.masai.shopnest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Order;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	OrderRepository orderRepository;

	public OrderServiceImpl(@Autowired OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
		
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order removeOrder(Order order) {
		orderRepository.delete(order);
		return order;
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) {
		List<Order> orderList = orderRepository.findAll();
		List<Order> orderByDate = new ArrayList<>();
		for (Order order : orderList) {
			LocalDate orderDate = order.getOrderDate();

			if (orderDate != null && orderDate.equals(date)) {
				orderByDate.add(order);
			}
		}

		return orderByDate;

	}

	@Override
	public List<Order> viewAllOrderByLocation(String loc) {
		
		if(loc== null)
		{
			throw new NotFoundException("Location is Not Found");
		}
		List<Order> orderList = orderRepository.findAll();
		List<Order> orderByLoc = new ArrayList<>();
		for (Order order : orderList) {
			String Location = order.getAddress().getCity();

			if (Location != null && Location.equals(loc)) {
				orderByLoc.add(order);
			}
		}

		return orderByLoc;
	}

	@Override
	public List<Order> viewAllOrderByUserId(int userId) {
		if(userId==0)
		{
			throw new NotFoundException("User ID is Invalid");
		}
		List<Order> orderList = orderRepository.findAll();
		List<Order> orderByUserID = new ArrayList<>();
		for (Order order : orderList) {
			int id = order.getCustomer().getCustomerId();

			if (id == userId) {
				orderByUserID.add(order);
			}
		}

		return orderByUserID;

	}

}
