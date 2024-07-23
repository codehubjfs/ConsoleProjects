package com.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.mapper.AdminMapper;
import com.ticket.model.Admin;

@Service
public class LoginServiceImpl implements LoginService {

	    @Autowired
	    private AdminMapper adminMapper;

	    @Override
	    public Admin loginAsAdmin(String email, String password) {
	        return adminMapper.findByEmailAndPassword(email, password);
	    }
	}
