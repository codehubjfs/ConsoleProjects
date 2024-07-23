package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.mapper.CustomerMapperRegister;
import com.bus.model.CustomersNew;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private CustomerMapperRegister customerMapperRegister;


	    public void registerCustomer(String firstname, String lastname, String username, String email, String gender, String password, String phonenumber) {
	    	customerMapperRegister.insertCustomer(firstname, lastname, username, email, gender, password, phonenumber);
	    }
//	    public boolean isEmailAlreadyInUse(String email) {
//	        CustomersNew existingCustomer = customerMapperRegister.findByEmail(email);
//	        return existingCustomer != null;
//	    }

}
