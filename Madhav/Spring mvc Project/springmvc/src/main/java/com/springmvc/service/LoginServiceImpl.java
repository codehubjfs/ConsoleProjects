package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.AdminMapper;
import com.springmvc.mapper.LoginMapper;
import com.springmvc.model.Admin;
import com.springmvc.model.Login;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	
	
	@Override
	public Login getUser(String email, String password, String role) {
        return loginMapper.getUser(email, password, role);
    }
	
	
	
	
	
	
	
	

	

	
	
	

}
