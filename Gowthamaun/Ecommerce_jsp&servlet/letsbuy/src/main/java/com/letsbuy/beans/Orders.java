package com.letsbuy.beans;

import java.io.Serializable;
import java.util.List;

public class Orders implements Serializable {
	private int c_id;
	private List<Order> orders;
	
	public Orders() {
		
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
