package com.bus.service;

import java.util.List;

import com.bus.model.CustomersNew;


public interface CustomerService {
	    List<CustomersNew> viewCustomer();
	      void updateCustomerStatus(int id, String status);
	}
