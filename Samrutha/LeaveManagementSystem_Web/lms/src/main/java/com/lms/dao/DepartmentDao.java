package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lms.bean.Department;
import com.lms.bean.Employee;
import com.lms.util.DbConnection;

public class DepartmentDao {
	public static List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        Department department = null;

        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "SELECT * FROM department";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                department = new Department();
                department.setDeptId(rs.getInt("DEPTID"));
                department.setDeptName(rs.getString("DEPTNAME"));
                department.setLocation(rs.getString("location"));
                departments.add(department);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
	
	public static Department getDepartmentById(Employee emp) {
	    Department department = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = DbConnection.getInstance().getConnection();
	        String sql = "SELECT * FROM department WHERE deptId = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, emp.getDept().getDeptId());
	        rs = statement.executeQuery();  // Execute the prepared statement without passing the SQL query again

	        if (rs.next()) {
	            department = new Department();
	            department.setDeptId(rs.getInt("DEPTID"));
	            department.setDeptName(rs.getString("DEPTNAME"));
	            department.setLocation(rs.getString("location"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	        
	    return department;
	}
}
