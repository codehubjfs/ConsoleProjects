package com.leavemanagement.lms.employee;

import java.time.LocalDate;

import com.leavemanagement.lms.department.Department;

public class Employee {
	
	private String fname;
	private String lname;
	private int empId;
	private String email;
	private String userName;
	private String password;
	private Department department;
	private LocalDate joinDate;
	private float salary;
	private String jobRole;
	private int managerId;
	private AccountStatus empAccStatus;
	
	
	//default constructor
	public Employee() {
		
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
	 */
	public Employee(String fname, String lname, int empId, String email, String userName, String password,
			Department department, LocalDate joinDate, float salary, String jobRole, int managerId,
			AccountStatus empAccStatus) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.empId = empId;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.department = department;
		this.joinDate = joinDate;
		this.salary = salary;
		this.jobRole = jobRole;
		this.managerId = managerId;
		this.empAccStatus = empAccStatus;
	}
	
	/*
	 * Update the leave of the employee whose leave had been approved
	 * 
	 * @param  fname     :  Stores the first name of the employee
	 * @param  lname     :  Stores the last name of the employee
	 * @param  empId     :  Stores the employeeId
	 * 
	 */
	public Employee(String fname, String lname, int empId) {
		this.fname = fname;
		this.lname = lname;
		this.empId = empId;
	}
	
	/*
	 * Update the leave of the employee whose leave had been approved
	 * 
	 * @param  fname     :  Stores the first name of the employee
	 * @param  lname     :  Stores the last name of the employee
	 * @param  email     :  Stores the email of the employee
	 * @param  userName  :  Stored the userName of the employee
	 * @param  password  :  Stores the password of the employee
	 * @param  department:  Stores all details of the department like deptId , deptName
	 * @param  joinDate  :  Stores the date on which the employee joined the organization
	 * @param  salary    :  Stores the salary earned by the employee
	 * @param  jobRole   :  Store the role of the employee as Employee, Admin, Manager etc.
	 * @param  managerId : Stores the managerId of that employee 
	 */
	
	public Employee(String fname, String lname, String email, String userName, String password, Department department,
			LocalDate joinDate, float salary, String jobRole, int managerId) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.department = department;
		this.joinDate = joinDate;
		this.salary = salary;
		this.jobRole = jobRole;
		this.managerId = managerId;
	}
	
	
	public Employee(String fname, String lname, String email, String userName, String password, Department department,
			LocalDate joinDate, float salary, String jobRole, int managerId, AccountStatus empAccStatus) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.department = department;
		this.joinDate = joinDate;
		this.salary = salary;
		this.jobRole = jobRole;
		this.managerId = managerId;
		this.empAccStatus = empAccStatus;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public String getJobRole() {
		return jobRole;
	}


	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public AccountStatus getEmpAccStatus() {
		return empAccStatus;
	}


	public void setEmpAccStatus(AccountStatus empAccStatus) {
		this.empAccStatus = empAccStatus;
	}


	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", empId=" + empId + ", email=" + email + ", userName="
				+ userName + ", password=" + password + ", department=" + department + ", joinDate=" + joinDate
				+ ", salary=" + salary + ", jobRole=" + jobRole + ", managerId=" + managerId + ", empAccStatus="
				+ empAccStatus + "]";
	}
	
}
