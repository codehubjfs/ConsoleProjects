package com.leavemanagement.lms.employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import com.leavemanagement.lms.department.Department;
import com.leavemanagement.lms.driver.AppDriver;
import com.leavemanagement.lms.exception.InvalidLastNameException;
import com.leavemanagement.lms.exception.InvalidMailException;

public class RegisterationForm {
	
	static Scanner sc = new Scanner(System.in);
	static String deptName;
	public static Employee readUserDetails(){
		System.out.print("Enter first name: ");
		String fname = sc.next();
		String lname; 
		while(true) {
        	try {
        		System.out.print("Enter last name: ");
        		lname= sc.next();
                if (!lname.matches(".*[a-zA-Z].*")) {
                    throw new InvalidLastNameException("Last name must contains at least one alphabet character.");
                }
                else {
                	break;
                }
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        }
		String mail;
		while(true) {
			try {
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				System.out.print("Enter email: ");
				mail = sc.next();
				if (!mail.matches(emailRegex)) {
		            throw new InvalidMailException("Invalid email address...! ");
		        }
				else {
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Enter department name: ");
		deptName = sc.next();
		int deptId = readDepartmentId();
		System.out.print("Enter managerId: ");
		int managerID = sc.nextInt();
		System.out.print("Enter hire date as 'YYYY MM DD': ");
		LocalDate hireDate = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.print("Enter salary: ");
		float salary = sc.nextInt();
		System.out.print("Enter job role: ");
		String role= sc.next();
		Department dept = new Department();
		dept.setDeptId(deptId);
		Employee emp = new Employee(fname, lname, mail,(fname+"_"+lname), "welcome123", dept , hireDate, salary, role, managerID);
		return emp;
	}
	
	public static int readDepartmentId() {
		int id=0;
		try {
			String sql = "select deptID from department where deptName = ?";
			PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
	        prst.setString(1, deptName);
	        ResultSet rs = prst.executeQuery();
	        if (rs.next()) {
	            id = rs.getInt("deptId");
	        }
	        //System.out.println(id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	public static void validateEmail(String email) throws InvalidMailException {
        
    }
}
