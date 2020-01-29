package com.example.zad2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zad2.entity.PayUOrder;
import com.example.zad2.rs.consumer.PayUConsumerRs;

@Service
public class OrderService {

	@Autowired
	PayUConsumerRs payUConsumerRs;

	public void makeOrder(PayUOrder payUOrder) {
		payUConsumerRs.makeOrder(payUOrder);
	}

}
