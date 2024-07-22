package com.ungalkadai.components;

import java.time.LocalDate;

import com.ecommerce.users.Customer;

public class Payment {
	private int id;
	private Customer customer;
	private Order order;
	private double amount;
	private String paymentType;
	private PaymentStatus paymentStatus;
	
	public Payment() {
		
	}
	
	public Payment(Customer customer, Order order, double amount, String paymentType,
			PaymentStatus paymentStatus) {
		this.customer = customer;
		this.order = order;
		this.amount = amount;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
	}
	
	public Payment(int id,Customer customer, Order order, double amount, String paymentType,
			PaymentStatus paymentStatus) {
		this.id = id;
		this.customer = customer;
		this.order = order;
		this.amount = amount;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
}
