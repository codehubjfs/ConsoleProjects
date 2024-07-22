package com.leavemanagement.lms.employee;

import java.time.LocalDate;
import java.util.TreeMap;

import com.leavemanagement.lms.department.Department;

public class Manager extends Employee{
	
	private TreeMap<Integer,String> team;
	
	public Manager() {
		
	}
	
	/*
	 * Update the leave of the employee whose leave had been approved
	 * 
	 * @param  fname     :  Stores the first name of the employee
	 * @param  lname     :  Stores the last name of the employee
	 * @param  empId     :  Stores the employeeId
	 * @param  email     :  Stores the email of the employee
	 * @param  userName  :  Stored the userName of the employee
	 * @param  password  :  Stores the password of the employee
	 * @param  department:  Stores all details of the department like deptId , deptName
	 * @param  joinDate  :  Stores the date on which the employee joined the organization
	 * @param  salary    :  Stores the salary earned by the employee
	 * @param  jobRole   :  Store the role of the employee as Employee, Admin, Manager etc.
	 * @param  managerId : Stores the managerId of that employee 
	 * @param team       : Stores the fname and lname of the team members
	 */
	public Manager(String fname, String lname, int empId, String email, String userName, String password,
			Department department, LocalDate joinDate, float salary, String jobRole, int managerId,
			AccountStatus empAccStatus, TreeMap<Integer, String> team) {
		super(fname, lname, empId, email, userName, password, department, joinDate, salary, jobRole, managerId, empAccStatus);
		this.team = team;
	}

	public TreeMap<Integer, String> getTeam() {
		return team;
	}

	public void setTeam(TreeMap<Integer, String> team) {
		this.team = team;
	}
	
	
	
	
	
	
	
}
