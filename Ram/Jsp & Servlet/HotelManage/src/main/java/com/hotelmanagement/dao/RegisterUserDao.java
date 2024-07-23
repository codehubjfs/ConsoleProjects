package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.bean.LoginRegister;
import com.hotelmanagement.utilities.DbUtil;

public class RegisterUserDao {
	
	  public boolean registerCustomer(LoginRegister obj) {
		  boolean status = false;
	        Connection conn = null;
	        PreparedStatement ps = null;
	        try {
	        	 conn = DbUtil.openConnection();
	            String sql = "INSERT INTO users (id, first_name, last_name, age, gender, phone, address, state, email, password) VALUES (users_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, obj.getFirstName());
	            ps.setString(2, obj.getLastName());
	            ps.setInt(3, obj.getAge());
	            ps.setString(4, obj.getGender());
	            ps.setLong(5, obj.getPhoneNo());
	            ps.setString(6, obj.getAddress());
	            ps.setString(7, obj.getState());
	            ps.setString(8, obj.getEmail());
	            ps.setString(9, obj.getPassword());

	            int rowsAffected = ps.executeUpdate();
	            
	            status = rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
//	        finally {
//	            try {
//	                if (ps != null) ps.close();
//	                if (conn != null) conn.close();
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
	        return status;

	    }
}
