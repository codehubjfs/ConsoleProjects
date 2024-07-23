package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.mapper.CustomerMapper;
import com.bus.model.CustomersNew;



@Service
	public class CustomerServiceImpl implements CustomerService {

	    @Autowired
	    private CustomerMapper customerMapper;

	    @Override
	    public List<CustomersNew> viewCustomer() {
	        return customerMapper.viewCustomer();
	    }

		@Override
		public void updateCustomerStatus(int id, String status) {
			// TODO Auto-generated method stub
			
		}
}
	
