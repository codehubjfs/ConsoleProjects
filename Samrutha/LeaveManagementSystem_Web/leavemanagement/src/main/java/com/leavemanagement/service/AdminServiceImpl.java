package com.leavemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.mapper.AdminMapper;
import com.leavemanagement.model.Employee;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminMapper adminMapper;

	@Override
	public void insertUser(Employee emp) {
		adminMapper.insertUser(emp);
	}

}
