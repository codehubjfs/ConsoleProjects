package com.bus.service;

import com.bus.model.CustomersNew;

public interface RegisterService {

		void registerCustomer(String firstname, String lastname, String username, String email, String gender,
				String password, String phonenumber);

//		boolean isEmailAlreadyInUse(String email);
//
//		void registerCustomer(CustomersNew customer);
	}

