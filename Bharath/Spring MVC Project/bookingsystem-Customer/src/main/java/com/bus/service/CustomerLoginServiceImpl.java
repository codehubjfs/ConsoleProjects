package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.mapper.MapperCustomer;
import com.bus.model.CustomersNew;


@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	    @Autowired
	    private MapperCustomer mapperCustomer;

	    @Override
	    public CustomersNew loginAsAdmin(String email, String password) {
	        return mapperCustomer.findByEmailAndPassword(email, password);
	    }

		@Override
		public List<CustomersNew> viewCustomer() {
			// TODO Auto-generated method stub
			return null;
		}
	}
