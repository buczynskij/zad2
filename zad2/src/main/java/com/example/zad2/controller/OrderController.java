package com.example.zad2.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.zad2.entity.PayUOrder;
import com.example.zad2.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostConstruct
	public void run() {
		PayUOrder payUOrder = new PayUOrder();
		orderService.makeOrder(payUOrder);
	}

}
