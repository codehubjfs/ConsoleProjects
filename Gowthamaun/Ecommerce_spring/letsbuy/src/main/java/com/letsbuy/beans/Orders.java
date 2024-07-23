package com.letsbuy.beans;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Orders {
	private List<Order> customerOrders;
	
	public Orders() {
		
	}

	public List<Order> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<Order> order) {
		this.customerOrders = order;
	}
	
	
}
