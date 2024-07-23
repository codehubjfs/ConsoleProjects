package com.leavemanagement.service;

import java.util.List;

import com.leavemanagement.model.Employee;

public interface ManagerService {
	
	List<Employee> getTeams(int id);
}
