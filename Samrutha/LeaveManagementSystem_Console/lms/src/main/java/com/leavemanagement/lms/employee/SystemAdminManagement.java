package com.leavemanagement.lms.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

import com.leavemanagement.lms.Menu;
import com.leavemanagement.lms.department.Department;
import com.leavemanagement.lms.driver.AppDriver;
import com.leavemanagement.lms.exception.ExceptionValidator;
import com.leavemanagement.lms.exception.InvalidDateException;
import com.leavemanagement.lms.exception.InvalidLastNameException;
import com.leavemanagement.lms.exception.InvalidMailException;
import com.leavemanagement.lms.style.Border;

public class SystemAdminManagement {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static ExceptionValidator validators = new ExceptionValidator();
	static Border border = new Border();
	
	//Menu to choose the admin functionality
	public void systemAdminActivity(SystemAdmin admin) throws Exception {
		while(true) {
			System.out.println("System Admin Activity: ");
			System.out.println("1. CreateUser    2.DeleteUser    3. AddDepartment    4.DeleteDepartment    5. Logout    6. Exit");
			int choice;
			while (true) {
				System.out.println("Enter your choice: ");
	            try {
	            	String  input = bf.readLine().trim();
                	if(!validators.isNumeric(input)) {
                		throw new InputMismatchException("Input is not a valid number.");
                	}
                	else {
                		choice = Integer.parseInt(input); 
                		break;
                	}
	            } 
	            catch (InputMismatchException e) {
	            	System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
	            }
			}
			switch(choice) {
			case 1: createUser();break;
			case 2: deleteUser();break;
			case 3: addDepartment(); break;
			case 4: deleteDepartment(); break;
			case 5: Menu.displayMainMenu(); break;
			case 6: border.applyNoteBorder("Thank you for visiting...!");
					System.exit(0); break;
			default: System.out.println("---------------------------------------------");
					 System.out.println("Please enter valid choice from 1 to 6...");
					 System.out.println("---------------------------------------------");
			}
		}
	}
	
	//Read the employee info
	public static Employee readUserDetails() throws Exception {
	    Department dept = new Department();
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Enter first name: ");
	    String fname = bf.readLine();
	    String lname;

	    while (true) {
	        try {
	            System.out.print("Enter last name: ");
	            lname = bf.readLine();
	            if (!lname.matches(".*[a-zA-Z].*") || lname.length() < 1) {
	                throw new InvalidLastNameException("Last name must contain at least one alphabet character.");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("---------------------------------------------");
	            System.out.println(e.getMessage());
	            System.out.println("---------------------------------------------");
	        }
	    }

	    //Read mail id
	    String mail;
	    while (true) {
	        try {
	            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	            System.out.print("Enter email: ");
	            mail = bf.readLine();
	            if (!mail.matches(emailRegex)) {
	                throw new InvalidMailException("Invalid email address...! ");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("---------------------------------------------");
	            System.out.println(e.getMessage());
	            System.out.println("---------------------------------------------");
	        }
	    }

	    //Read the department id
	    int deptId = readDepartmentId();

	    //Read the manager id
	    int managerId;
	    while (true) {
	        try {
	            System.out.print("Enter managerId: ");
	            String input = bf.readLine();
	            if (!input.matches("\\d+")) {
	                throw new InputMismatchException("Input is not a valid number.");
	            } else {
	                managerId = Integer.parseInt(input);
	                break;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("---------------------------------------------");
	            System.out.println("\n" + e.getMessage() + "\n");
	            System.out.println("---------------------------------------------");
	        }
	    }

	    LocalDate hireDate;
		while(true) {
        	System.out.print("Enter hired date as 'YYYY-MM-DD': ");
            try {
            	String date = bf.readLine();
                hireDate = validators.validateHireDate(date); break;
            } catch (InvalidDateException e) {
            	System.out.println("---------------------------------------------");
                System.out.println("\n" + e.getMessage() + "\n");
                System.out.println("---------------------------------------------");
            }
        }
		
	    float salary;
	    while (true) {
	        try {
	            System.out.print("Enter salary: ");
	            String input = bf.readLine();
	            if (!input.matches("\\d+")) {
	                throw new InputMismatchException("Input is not a valid number.");
	            } else {
	                salary = Float.parseFloat(input);
	                break;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("---------------------------------------------");
	            System.out.println("\n" + e.getMessage() + "\n");
	            System.out.println("---------------------------------------------");
	        }
	    }

	    System.out.print("Roles [EMPLOYEE, SYSTEM ADMIN, MANAGER] \n Enter job role: ");
	    String role = bf.readLine();

	    dept.setDeptId(deptId);
	    return new Employee(fname, lname, mail, fname.toLowerCase() + "_" + lname.toLowerCase(), "welcome123", dept, hireDate, salary, role, managerId, AccountStatus.ACTIVE);
	}
	
	//Read department id and set to the employee
	public static int readDepartmentId() throws IOException {
		Department dept;
		int deptId=0;
		ArrayList<Department> departmentList = new ArrayList<>();
		Set<Integer> processedIds = new HashSet<>();
		try {
			String sql = "select * from department";
			PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
	        ResultSet rs = prst.executeQuery();
	        while (rs.next()) {
	        	
	        	if(!processedIds.contains(rs.getInt("deptId"))) {
	        		dept = new Department(rs.getInt("DeptId"), rs.getString("deptName"), rs.getString("Location"));
	 	            departmentList.add(dept);
	 	           processedIds.add(rs.getInt("deptID"));
	        	}
	           
	        } 
		}
		catch(Exception e) {
			System.out.println("---------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println("---------------------------------------------");
		}
		
		while (true) {
			String formats = "\n+-----------+--------------------------+---------------+\n";
			System.out.print(formats);
			System.out.printf("|%-10s |%-25s |%-15s|","DeptId", "DeptName", "Location");
			for(Department val: departmentList) {
				System.out.printf("%s|%-10d |%-25s |%-15s|",formats,val.getDeptId(), val.getDeptName(), val.getLocation());
			}
			System.out.print(formats);
            System.out.println("Enter the department Id : ");
            String input = bf.readLine().trim();
            
            try {
                if (!validators.isNumeric(input)) {
                    throw new InputMismatchException("Input is not a valid number.");
                } else {
                    deptId = Integer.parseInt(input);

                    boolean validEmpId = false;
                    for (Department val: departmentList) {
                        if (deptId == val.getDeptId()) {
                            validEmpId = true;
                            break;
                        }
                    }

                    if (validEmpId) {
                        break; // Break the outer loop if a valid employee ID is found
                    } else {
                    	System.out.println("---------------------------------------------");
                        System.out.println("Department ID not found. Please try again.");
                        System.out.println("---------------------------------------------");
                    }
                }
            } catch (InputMismatchException e) {
            	System.out.println("---------------------------------------------");
                System.out.println(e.getMessage());
                System.out.println("---------------------------------------------");
            }
        }
		return deptId;
	}
	
	//Create new User
	public static void createUser() throws Exception {
	    Employee emp = readUserDetails();
	    try {
	        String sql = "insert into employee values (empSeq.nextval,?,?,?,?,?,?,?,TO_DATE(?, 'YYYY-MM-DD'),?,?,?)";
	        PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
	        prst.setString(1, emp.getFname());
	        prst.setString(2, emp.getLname());
	        prst.setString(3, emp.getEmail());
	        prst.setInt(4, emp.getDepartment().getDeptId());
	        prst.setString(5, emp.getUserName());
	        prst.setString(6, emp.getPassword());
	        prst.setInt(7, emp.getManagerId());
	        prst.setString(8, emp.getJoinDate().toString());
	        prst.setFloat(9, emp.getSalary());
	        prst.setString(10, emp.getEmpAccStatus().toString());
	        prst.setString(11, emp.getJobRole());
	        
	        int i = prst.executeUpdate();
	        
	        //Read the inserted employee id
	        sql = "select empID from employee where userName = ?";
	        prst = AppDriver.getConnection().prepareStatement(sql);
	        prst.setString(1, emp.getUserName());
	        ResultSet rs = prst.executeQuery();
	        int id = 0 ;
	        while(rs.next()) {
	        	id = rs.getInt("empId");
	        }
	        
	        //Create a row for leave tracking
	        sql = "insert into leave values (leavesSeq.nextval, ?, 120, 0)";
	        prst = AppDriver.getConnection().prepareStatement(sql);
	        prst.setInt(1, id);
	        int j = prst.executeUpdate();
	        if (i == 1 && j==1) {
	            border.applyNoteBorder("Account Created Successfully...!");
	        } else {
	            System.out.println("---------------------------------------------");
	            System.out.println("Something went wrong...!");
	            System.out.println("---------------------------------------------");
	        }
	    } catch (Exception e) {
	        System.out.println("---------------------------------------------");
	        System.out.println(e.getMessage());
	        System.out.println("---------------------------------------------");
	    }
	}
	
	//Functionality to add new department
	public static void addDepartment() throws IOException {
		int id;
		while(true) {
			try {
				System.out.println("Enter department id: ");
	        	String input = bf.readLine();
	            if (!validators.isNumeric(input)) {
	            	throw new InputMismatchException("Input is not a valid number.");
	            } else {
	                id = Integer.parseInt(input);
	                break;
	            }
	        } catch (InputMismatchException e) {
	        	System.out.println("---------------------------------------------");
	            System.out.println(e.getMessage());
	            System.out.println("---------------------------------------------");
	        }
		}
		System.out.println("Enter department name: ");
		String deptName = bf.readLine();
		System.out.println("Enter location: ");
		String location = bf.readLine();

		try {
			String sql = "insert into department values (?,?,?)";
			PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
			prst.setInt(1, id);
			prst.setString(2, deptName);
			prst.setString(3, location);
			int i = prst.executeUpdate();
			if(i==1) {
				border.applyNoteBorder("Department added successfully...!");
			}
		}
		catch(Exception e) {
			System.out.println("---------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println("---------------------------------------------");
		}
	}
	
	//It provides the functionality to deactivate the user account
	public static void deleteUser() throws IOException {
		ArrayList<Employee> employeeList = new ArrayList<>();
		Set<Integer> processedIds = new HashSet<>();
		try {
			String sql = "SELECT * FROM employee where EMPACCSTATUS = 'ACTIVE'";
			PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("EmpId");
				if (!processedIds.contains(empId)) {
					//Department dept = new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("Location"));
					Employee emp = new Employee(rs.getString("fname"), rs.getString("lname"), rs.getInt("empId"));
					processedIds.add(empId);
					employeeList.add(emp);
				}
			}
			//pendingLeaveList, Comparator.comparing(LeaveApplication::getStartDate)
			Collections.sort(employeeList, Comparator.comparingInt(Employee::getEmpId) );
		}
		catch (Exception e){
			System.out.println("---------------------------------------------");
            System.out.println("\n" + e.getMessage() + "\n");
            System.out.println("---------------------------------------------");
		}
		int empId = 0;
		while(true) {
			String formats = "\n+-----------+----------------+---------------+\n";
			System.out.print(formats);
			System.out.printf("|%-10s |%-15s |%-15s|","EmpId", "Fname", "Lname");
			for(Employee val:employeeList) {
				System.out.printf("%s|%-10d |%-15s |%-15s|",formats,val.getEmpId(), val.getFname(), val.getLname());
			}
			System.out.print(formats);
			
			System.out.println("Enter the empId: ");
			String input = bf.readLine().trim();
            try {
                if (!validators.isNumeric(input)) {
                    throw new InputMismatchException("Input is not a valid number.");
                } else {
                    empId = Integer.parseInt(input);

                    boolean validEmpId = false;
                    for (Employee e: employeeList) {
                        if (empId == e.getEmpId()) {
                            validEmpId = true;
                            break;
                        }
                    }

                    if (validEmpId) {
                        break; // Break the outer loop if a valid employee ID is found
                    } else {
                    	System.out.println("---------------------------------------------");
                        System.out.println("Employee ID not found. Please try again.");
                        System.out.println("---------------------------------------------");
                    }
                }
            } 
            catch (InputMismatchException e) {
            	System.out.println("---------------------------------------------");
                System.out.println("\n" + e.getMessage() + "\n");
                System.out.println("---------------------------------------------");
            }
		}
		
		try {
			String sql = "update Employee set EMPACCSTATUS = ? where empId = ?";
			PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
			prst.setString(1, AccountStatus.INACTIVE.name());
			prst.setInt(2, empId);
			int i = prst.executeUpdate();
			if(i==1) {
				border.applyNoteBorder("Account deactivated successfully...!");
			}
		}
		catch(Exception e) {
			System.out.println("---------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println("---------------------------------------------");
		}
	}
	
	//Delete Department
	public static void deleteDepartment() throws IOException {
		int deptId = readDepartmentId();
		try {
			String sql = "update employee set deptID = null  where deptID = ?";
			PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
			prst.setInt(1, deptId);
			int j=prst.executeUpdate();
			
			sql = "delete from department where deptID = ?";
			prst = AppDriver.getConnection().prepareStatement(sql);
			prst.setInt(1, deptId);
			
			int i = prst.executeUpdate();
			if(i==1 && j>=0) {
				border.applyNoteBorder("Deleted successfully...!");
			}
		}
		catch(Exception e) {
			System.out.println("---------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println("---------------------------------------------");
		}
		
	}
	
}
