package com.example.zad2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.zad2.controller.OrderController;

@SpringBootApplication
public class Zad2Application {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	OrderController orderController;

	public static void main(String[] args) {
		SpringApplication.run(Zad2Application.class, args);
	}

}
