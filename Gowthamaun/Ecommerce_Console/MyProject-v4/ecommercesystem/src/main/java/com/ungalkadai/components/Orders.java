package com.ungalkadai.components;

import java.util.List;

public class Orders {
	private int c_id;
	private List<Order> orders;
	
	public Orders() {
		
	}
	
	public Orders(int c_id, List<Order> orders) {
		this.c_id = c_id;
		this.orders = orders;
	}
	
	public Orders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public List<Order> getOrderList() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
