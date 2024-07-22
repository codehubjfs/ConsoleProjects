package com.leavemanagement.lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.TreeMap;

import com.leavemanagement.lms.driver.Account;
import com.leavemanagement.lms.driver.AppDriver;
import com.leavemanagement.lms.employee.AccountStatus;
import com.leavemanagement.lms.employee.Employee;
import com.leavemanagement.lms.employee.EmployeeManagement;
import com.leavemanagement.lms.employee.Manager;
import com.leavemanagement.lms.employee.ManagerActivity;
import com.leavemanagement.lms.employee.SystemAdmin;
import com.leavemanagement.lms.employee.SystemAdminManagement;
import com.leavemanagement.lms.exception.InvalidInputException;
import com.leavemanagement.lms.leave.LeaveApplication;
import com.leavemanagement.lms.style.Border;

public class Menu {
	
	public static void displayMainMenu() throws InvalidInputException{
		Border border = new Border();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
        try {
            while(true) {
            	int choice;
            	System.out.println("Login as: 1. Employee    2. Manager    3. System Admin    4. Exit");
                System.out.print("Enter your choice: ");
                    
                    try {
                        String input = reader.readLine().trim();
                        if (!isNumeric(input)) {
                            throw new InputMismatchException("Input is not a valid number.");
                        }
                        else {
                        	choice = Integer.parseInt(input);
                        	int status=0;
                    		switch(choice) {
                    		
                    		case 1: Employee emp = Account.accountStatus();
                    				if(emp==null) {
                    					System.out.println("---------------------------------------------");
                    					System.out.println("Invalid user...!");
                    					System.out.println("---------------------------------------------");
                    				}
                    				else {
                    					EmployeeManagement management = new EmployeeManagement();
                    					status = Account.accountLogin(emp);
                    					if(AccountStatus.INACTIVE == emp.getEmpAccStatus()) {
                    						System.out.println("---------------------------------------------");
                    						System.out.println("Inactive User");
                    						System.out.println("---------------------------------------------");
                    					}
                    					else if((AccountStatus.ACTIVE == emp.getEmpAccStatus()) && status == 1) {
                        					if(Account.checkEmployeeRole(emp).equalsIgnoreCase("Employee")) {
                        						border.applyNoteBorder("Successfylly logged in....!");
                        						management.employeeActivity(emp);
                        					}
                        					else if(Account.checkEmployeeRole(emp).equalsIgnoreCase("Manager")) {
                        						border.applyNoteBorder("Successfylly logged in....!");
                        						management.employeeActivity(emp);
                        					}
                        					else if(Account.checkEmployeeRole(emp).equalsIgnoreCase("System Admin")) {
                        						border.applyNoteBorder("Successfylly logged in....!");
                        						management.employeeActivity(emp);
                        					}
                        					else {
                        						System.out.println("-----------------------------------------------------");
		                						System.out.println("Employee login is not applicable for this user...!");
		                						System.out.println("-----------------------------------------------------");
		                					}
                        				}
                    					else {
                    						border.applyNoteBorder("Thank you for visiting...!");
                    						System.exit(0);
                    					}
                    				}
                    				break;
                    		case 2: emp = Account.accountStatus();
				    				if(emp==null) {
				    					System.out.println("---------------------------------------------");
				    					System.out.println("Invalid user...!");
				    					System.out.println("---------------------------------------------");
				    				}
				    				else {
				    					TreeMap<Integer,String> team = new TreeMap<Integer,String>();
				    					try {
				    						int deptNo = 0;
				    						String sql1= "select deptID from employee where userName = ?";
				    						PreparedStatement pst = AppDriver.getConnection().prepareStatement(sql1);
				    						pst.setString(1, emp.getUserName());
				    						ResultSet rs = pst.executeQuery();
				    						if(rs.next()) {
				    							deptNo = rs.getInt("DEPTID");
				    						}
				    						
				    						String sql = "select empId, (fname || ' ' || lname) as name from employee where ROLE = 'EMPLOYEE' and deptId = ? and empAccStatus = 'ACTIVE'";
				    						pst = AppDriver.getConnection().prepareStatement(sql);
				    						pst.setInt(1, deptNo);
				    						rs = pst.executeQuery();
				    						while(rs.next()) {
				    							
				    							int id = rs.getInt("empId");
				    							String name = rs.getString("name");
				    							team.put(id,name);
				    						}
				    					}
				    					catch(Exception e) {
				    						System.out.println("---------------------------------------------");
				    						System.out.println(e.getMessage());
				    						System.out.println("---------------------------------------------");
				    					}
				    					Manager manager = new Manager(emp.getFname(),emp.getLname(),emp.getEmpId(),emp.getEmail(),emp.getUserName(),emp.getPassword(), emp.getDepartment(), emp.getJoinDate(), emp.getSalary(), emp.getJobRole(), emp.getManagerId(), emp.getEmpAccStatus() ,team);
				    					LeaveApplication leave = new LeaveApplication();
				    					ManagerActivity manage = new ManagerActivity();
				    					ArrayList<LeaveApplication> leaveList= leave.showAllLeaves();
				    					status = Account.accountLogin(emp);
				    					if(AccountStatus.INACTIVE == emp.getEmpAccStatus()) {
                    						System.out.println("---------------------------------------------");
                    						System.out.println("Inactive User");
                    						System.out.println("---------------------------------------------");
                    					}
				    					else if(status == 1 && (AccountStatus.ACTIVE == emp.getEmpAccStatus())) {
		            						
		                					if(Account.checkEmployeeRole(emp).equalsIgnoreCase("Manager")) {
		                						border.applyNoteBorder("Successfylly logged in....!");
		                						manage.managerActivity(manager, leaveList);
		                					}
		                					else {
		                						System.out.println("---------------------------------------------------");
		                						System.out.println("Manager login is not applicable for this user...!");
		                						System.out.println("---------------------------------------------------");
		                					}
		                				}
		            					else {
		            						border.applyNoteBorder("Thank you for visiting...!");
		            						System.exit(0);
		            					}
				    				}
				    				break;
                    		case 3: emp = Account.accountStatus();
		            				if(emp==null) {
		            					System.out.println("---------------------------------------------");
		            					System.out.println("Invalid user...!");
		            					System.out.println("---------------------------------------------");
		            				}
		            				else {
		            					SystemAdminManagement adminActivity = new SystemAdminManagement();
		            					SystemAdmin admin = new SystemAdmin();
		            					status = Account.accountLogin(emp);
		            					if(AccountStatus.INACTIVE == emp.getEmpAccStatus()) {
                    						System.out.println("---------------------------------------------");
                    						System.out.println("Inactive User");
                    						System.out.println("---------------------------------------------");
                    					}
		            					else if(status == 1 && (AccountStatus.ACTIVE == emp.getEmpAccStatus())) {
		                					if(Account.checkEmployeeRole(emp).equalsIgnoreCase("System Admin")) {
		                						border.applyNoteBorder("Successfylly logged in....!");
		                						adminActivity.systemAdminActivity(admin);
		                					}
		                					else {
		                						System.out.println("---------------------------------------------------");
		                						System.out.println("Employee login is not applicable for this user...!");
		                						System.out.println("---------------------------------------------------");
		                					}
		                				}
		            					else {
		            						border.applyNoteBorder("Thank you for visiting...!");
		            						System.exit(0);
		            					}
		            				}
		            				break;
                    		case 4: border.applyNoteBorder("Thank you for visiting...!"); System.exit(0);
                    		default: System.out.println("---------------------------------------------");
                    				 System.out.println("Enter your choice from [1 to 4]");
                    				 System.out.println("---------------------------------------------");
                    		}
                        	//break;
                        }
                        
                    } catch (InputMismatchException e) {
                    	System.out.println("---------------------------------------------");
                        System.out.println(e.getMessage());
                        System.out.println("---------------------------------------------");
                    } 
            }
        }
        catch(Exception e) {
        	System.out.println("---------------------------------------------");
        	 System.out.println(e.getMessage());
        	System.out.println("---------------------------------------------");
        }
	}
	
	private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
