package com.leavemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.mapper.LoginMapper;
import com.leavemanagement.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public Login getLogin(String username) {
		
		Login login = loginMapper.getLogin(username);
		System.out.println("service login: " + login.getRole());
		return login;
	}

}
