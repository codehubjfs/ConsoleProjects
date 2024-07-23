package com.leavemanagement.service;

import com.leavemanagement.model.Employee;

public interface EmployeeService {
	
	Employee getEmployeeDetail(String username);
	void updatePassword(String password, int id);
}
