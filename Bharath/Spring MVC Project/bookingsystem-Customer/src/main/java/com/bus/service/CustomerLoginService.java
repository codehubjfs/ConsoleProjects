package com.bus.service;

import java.util.List;

import com.bus.model.CustomersNew;


public interface CustomerLoginService {
	public CustomersNew loginAsAdmin(String email, String password);

	public List<CustomersNew> viewCustomer();	
}
