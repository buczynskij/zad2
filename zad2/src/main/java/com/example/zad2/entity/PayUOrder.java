package com.example.zad2.entity;

import java.util.ArrayList;
import java.util.List;

public class PayUOrder {

	private String customerIp;
	private Integer merchantPosId;
	private String description;
	private String currencyCode;
	private Integer totalAmount;
	private List<Products> products;

	public PayUOrder() {
		this.customerIp = "127.0.0.1";
		this.merchantPosId = 300746;
		this.description = "RTV market";
		this.currencyCode = "PLN";
		this.totalAmount = 21000;
		this.products = new ArrayList<>();
		this.products.add(new Products("Wireless mouse", 15000, 1));
		this.products.add(new Products("HDMI cable", 6000, 1));
	}

	public String getCustomerIp() {
		return customerIp;
	}

	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}

	public Integer getMerchantPosId() {
		return merchantPosId;
	}

	public void setMerchantPosId(Integer merchantPosId) {
		this.merchantPosId = merchantPosId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

}
