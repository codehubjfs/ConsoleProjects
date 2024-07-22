package com.leavemanagement.lms.employee;

import java.time.LocalDate;

import com.leavemanagement.lms.department.Department;

public class SystemAdmin extends Employee{
	
	//parameterized constructor
		public SystemAdmin(String fname, String lname, int empId, String email, String userName, String password,
				Department department, LocalDate joinDate, float salary, String jobRole, int managerId, AccountStatus empAccStatus) {
			super(fname, lname, empId, email, userName, password, department, joinDate, salary, jobRole, managerId, empAccStatus);
		}
		
		//Empty constructor
		public SystemAdmin() {
		}
		
}
