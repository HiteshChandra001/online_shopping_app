package com.masai.shopnest.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.shopnest.entity.Order;

public interface OrderService {
	
	public Order addOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public Order removeOrder(Order order);
	
	public List<Order> viewAllOrders(LocalDate date);
	
	public List<Order> viewAllOrderByLocation(String loc);

	public List<Order> viewAllOrderByUserId(int userId);
}
