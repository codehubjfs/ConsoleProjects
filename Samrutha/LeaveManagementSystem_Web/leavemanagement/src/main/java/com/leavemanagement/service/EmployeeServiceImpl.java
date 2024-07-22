package com.leavemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.mapper.EmployeeMapper;
import com.leavemanagement.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public Employee getEmployeeDetail(String username) {
		Employee emp = employeeMapper.getEmployeeDetail(username);
		return emp;
	}

	@Override
	public void updatePassword(String password, int id) {
		System.out.println("Service");
		System.out.println(password);
		System.out.println(id);
		employeeMapper.updatePassword(password, id);
	}
	
}
