package com.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.mapper.CustomerMapper;
import com.ticket.model.Customer;

@Service
	public class CustomerServiceImpl implements CustomerService {

	    @Autowired
	    private CustomerMapper customerMapper;

	    @Override
	    public List<Customer> viewCustomer() {
	        return customerMapper.viewCustomer();
	    }

	    @Override
	    public void updateCustomerStatus(int id, String status) {
	        customerMapper.updateCustomerStatus(id, status);
	    }
		}
	
