package com.masai.shopnest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.shopnest.entity.Order;
import com.masai.shopnest.service.OrderService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class OrderContoller {

	@Autowired
	private OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}

	@PutMapping("/orders")
	public ResponseEntity<Order> updateOrder(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> removeOrder(@PathVariable int id) {
		return new ResponseEntity<Order>(orderService.removeOrder(id), HttpStatus.OK);
	}

	@GetMapping("/orderbydate/{date}")
	public ResponseEntity<List<Order>> viewAllOrdersbyDate( @PathVariable LocalDate date) {
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(date), HttpStatus.OK);
	}

	@GetMapping("/orderbylocation/{loc}")
	public ResponseEntity<List<Order>> viewAllOrderByLocation( @PathVariable String loc) {
		return new ResponseEntity<List<Order>>(orderService.viewAllOrderByLocation(loc), HttpStatus.OK);
	}
	
	@GetMapping("/orderbyuserID/{userId}")
	public ResponseEntity<List<Order>> viewAllOrderByUserId( @PathVariable int userId) {
		return new ResponseEntity<List<Order>>(orderService.viewAllOrderByUserId(userId), HttpStatus.OK);
	}



}
