package com.example.zad2.rs.consumer;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.zad2.entity.PayUOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class PayUConsumerRs {

	@Autowired
	RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PayUConsumerRs.class);

	private ResourceBundle payUProperties;

	private void preparePayUProperties() {
		if (payUProperties == null) {
			try {
				payUProperties = ResourceBundle.getBundle("payU");
			} catch (Exception e) {
				logger.info("Resource bundle PayU not found" + e.getMessage());
			}
		}
	}

	private String getProperty(String property) {
		String payUProperty = null;
		if (payUProperties != null) {
			try {
				payUProperty = payUProperties.getString(property);
			} catch (Exception e) {
				logger.info(property + " Property not found in resource" + e.getMessage());
			}
		}
		return payUProperty;
	}

	private String createJson(PayUOrder order) {

		String json = "";
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			json = ow.writeValueAsString(order);
		} catch (Exception e) {
			logger.info("Json not created" + e.getMessage());
		}
		return json;
	}

	public void makeOrder(PayUOrder payUOrder) {

		preparePayUProperties();

		String uri = getProperty("uri");
		String order = createJson(payUOrder);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", getProperty("contentType"));
		headers.set("Authorization", getProperty("auth"));

		HttpEntity<String> orderCreateRequest = new HttpEntity<>(order, headers);

		ResponseEntity<String> orderCreateResponse = restTemplate.postForEntity(uri, orderCreateRequest, String.class);

		System.out.println("status: " + orderCreateResponse.getStatusCodeValue());
		System.out.println("headers: " + orderCreateResponse.getHeaders());
		System.out.println("body: " + orderCreateResponse.getBody());

	}

}
