package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lms.bean.BalanceLeaveBean;
import com.lms.bean.Department;
import com.lms.bean.Employee;
import com.lms.bean.Login;
import com.lms.bean.Role;
import com.lms.util.DbConnection;

public class EmployeeDao {
	
	public static Employee getUserDetails(String username) {
        Employee emp=new Employee();
        
        Department department = new Department(); // Assuming getAllDepartments() is a static method that returns an array

        try {
        	Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee e JOIN department d ON e.DEPTID = d.DEPTID WHERE username= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
              
                Role role = emp.mapToEnum(resultSet.getString("role"));
                emp.setEmpId(resultSet.getInt("empId"));
                emp.setFirstName(resultSet.getString("FIRSTNAME"));
                emp.setLastName(resultSet.getString("LASTNAME"));
                emp.setEmail(resultSet.getString("EMAIL"));
                emp.setManagerId(resultSet.getInt("MANAGERID"));
                emp.setJoinDate(resultSet.getDate("JOINDATE").toLocalDate());
                emp.setSalaray(resultSet.getInt("SALARY"));
                emp.setGender(emp.mapToGender(resultSet.getString("Gender")));
              
                department.setDeptId(resultSet.getInt("deptID"));
                department.setDeptName(resultSet.getString("deptName"));
                department.setLocation(resultSet.getString("location"));
                emp.setDept(department);
                emp.setRole(role);
                emp.setUserName(username);
                emp.setPassword(resultSet.getString("password"));
                emp.setStatus(emp.mapToStatus(resultSet.getString("STATUS")));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }
	
	public static void updatePassword(String password, Employee emp) {
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
            String sql = "Update employee set password = ? where empId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, emp.getEmpId());
            statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    } 
	
	
	public static BalanceLeaveBean displayLeave(Employee emp) {
		
		BalanceLeaveBean balanceLeave = new  BalanceLeaveBean();
		try {
        	Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM LeaveBalance where empId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, emp.getEmpId());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	balanceLeave.setLeaveTypeId(resultSet.getInt("LEAVETYPEID"));
            	balanceLeave.setEmp(emp);
            	balanceLeave.setSickLeave(resultSet.getInt("SICKLEAVE"));
            	balanceLeave.setCasualLeave(resultSet.getInt("CASUALLEAVE"));
            	balanceLeave.setVacationLeave(resultSet.getInt("VACATIONLEAVE"));
            	balanceLeave.setBalanceLeave(resultSet.getInt("BALACELEAVE"));
            	balanceLeave.setTotlaLeave(resultSet.getInt("TOTALLEAVE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return balanceLeave;
	}
	
	
	public static List<Employee> selectTeam(Employee manager){
		List<Employee> employees = new ArrayList<>();
		try {
        	Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee e JOIN department d ON e.DEPTID = d.DEPTID WHERE managerId= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, manager.getEmpId());
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	
            	Employee emp = new Employee();
            	
            	Department department = new Department();
                Role role = emp.mapToEnum(resultSet.getString("role"));
                emp.setEmpId(resultSet.getInt("empId"));
                emp.setFirstName(resultSet.getString("FIRSTNAME"));
                emp.setLastName(resultSet.getString("LASTNAME"));
                emp.setEmail(resultSet.getString("EMAIL"));
                emp.setManagerId(resultSet.getInt("MANAGERID"));
                emp.setJoinDate(resultSet.getDate("JOINDATE").toLocalDate());
                emp.setSalaray(resultSet.getInt("SALARY"));
                emp.setGender(emp.mapToGender(resultSet.getString("Gender")));
              
                department.setDeptId(resultSet.getInt("deptID"));
                department.setDeptName(resultSet.getString("deptName"));
                department.setLocation(resultSet.getString("location"));
                emp.setDept(department);
                emp.setRole(role);
                emp.setUserName(resultSet.getString("username"));
                emp.setPassword(resultSet.getString("password"));
                emp.setStatus(emp.mapToStatus(resultSet.getString("STATUS")));
                
                employees.add(emp);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return employees;
	}
}
