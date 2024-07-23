package com.taskmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.taskmanagement.beans.EditProfileBeans;
import com.taskmanagement.beans.EmployeeBeans;
import com.taskmanagement.beans.Transcation;
import com.taskmanagement.util.DBConnection;

public class EmployeeDAO {

    public static EmployeeBeans getUserDetails(String email) {
        EmployeeBeans emp = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet rs= null;
        List<Transcation> transcations = new ArrayList<>();

        try {
        	 connection = DBConnection.getInstance().getConnection();
             preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE email = ?");

             preparedStatement.setString(1, email);

          
            	rs = preparedStatement.executeQuery(); 
                if (rs.next()) {
                    emp = new EmployeeBeans();
                    emp.setEmp_id(rs.getInt("Emp_id"));
                    emp.setName(rs.getString("name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPassword(rs.getString("password"));
                    emp.setGender(rs.getString("gender"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setRole(rs.getString("role"));
                    emp.setCity(rs.getString("city"));
                    emp.setManger_id(rs.getInt("mag_id"));
                    emp.setHireDate(rs.getString("hiredate"));
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }
    
    public void updateProfile(EditProfileBeans editProfile) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("UPDATE employee SET city = ?, phone_number = ? WHERE email = ?");

            preparedStatement.setString(1, editProfile.getCity());
            preparedStatement.setString(2, editProfile.getPhone());
            preparedStatement.setString(3, editProfile.getEmail());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error updating profile", e);
        }
        
    }
}
