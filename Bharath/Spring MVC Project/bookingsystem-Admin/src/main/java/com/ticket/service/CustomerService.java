package com.ticket.service;

import java.util.List;

import com.ticket.model.Customer;

public interface CustomerService {
	    List<Customer> viewCustomer();
	      void updateCustomerStatus(int id, String status);
	}
