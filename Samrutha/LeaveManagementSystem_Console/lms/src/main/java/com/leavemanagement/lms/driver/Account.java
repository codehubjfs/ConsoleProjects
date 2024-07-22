package com.leavemanagement.lms.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import com.leavemanagement.lms.department.Department;
import com.leavemanagement.lms.employee.AccountStatus;
import com.leavemanagement.lms.employee.Employee;

public class Account {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static Employee accountStatus() throws IOException {
		PreparedStatement prst;
		String userName;
		Employee emp = null;
		Department dept = null;
	    String sql1 = "SELECT * FROM employee e JOIN department d ON e.DEPTID = d.DEPTID WHERE username= ?";
	    try {
	        // Verifying userName
	        prst = AppDriver.getConnection().prepareStatement(sql1);
	        System.out.print("Enter userName: ");
	        userName = bf.readLine();
	        prst.setString(1, userName);
	        ResultSet rs = prst.executeQuery();
	        if (rs.next()) {
	        	AccountStatus status = AccountStatus.mapToStatus(rs.getString("empAccStatus")) ;
	        	dept = new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("Location"));
	            emp = new Employee(rs.getString("fName"), rs.getString("lName"),rs.getInt("empId") ,rs.getString("email"), rs.getString("userName"), rs.getString("password"), dept, rs.getDate("joinDate").toLocalDate(), rs.getFloat("salary"), rs.getString("role"), rs.getInt("managerId"), status );
	        }
	    } catch (SQLException e) {
	    	System.out.println("---------------------------------------------");
	        System.out.println(e.getMessage());
	        System.out.println("---------------------------------------------");
	    }
	    return emp;
	}
	
	
	public static int accountLogin(Employee emp) throws IOException {
        int f = 0;
        boolean continueOuterLoop = true;

        while (continueOuterLoop) {
            System.out.print("Enter password: ");
            String passwrd = bf.readLine();
            if (emp.getPassword().equals(passwrd)) {
                f = 1;
                break;
            } else {
            	System.out.println("---------------------------------------------");
                System.out.println("Invalid password...!");
                System.out.println("---------------------------------------------");
                
                while (true) {
                    System.out.print("Do you want to continue....? (yes-1 / no-0): ");
                    int continueStatus = 0;
                    try {
                        String input = bf.readLine().trim();
                        if (!isNumeric(input)) {
                            throw new InputMismatchException("Input is not a valid number.");
                        } else {
                            continueStatus = Integer.parseInt(input);
                            if (continueStatus == 0) {
                                f = 0;
                                continueOuterLoop = false; // Exit the outer loop
                                break;
                            } else if (continueStatus == 1) {
                                break; // Exit the inner loop and continue with the outer loop
                            } else {
                                throw new InputMismatchException("Enter 0 or 1");
                            }
                        }
                    } catch (Exception e) {
                    	System.out.println("---------------------------------------------");
                        System.out.println(e.getMessage());
                        System.out.println("---------------------------------------------");
                    }
                }
            }
        }
       return f;
    }
	
	public static String checkEmployeeRole(Employee emp) {
		String role="";
		if(emp.getJobRole().equalsIgnoreCase("employee")) {
			role = emp.getJobRole();
		}
		else if(emp.getJobRole().equalsIgnoreCase("manager")) {
			role = emp.getJobRole();
		}
		else if(emp.getJobRole().equalsIgnoreCase("HR")) {
			role = emp.getJobRole();
		}
		else if(emp.getJobRole().equalsIgnoreCase("system admin")) {
			role = emp.getJobRole();
		}
		return role;
	}
	
	private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
	
}
