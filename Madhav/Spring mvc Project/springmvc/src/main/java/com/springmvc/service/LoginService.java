package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Admin;
import com.springmvc.model.Login;

public interface LoginService {
		
	Login getUser(String email,String password,String role);
	
	
	
}
