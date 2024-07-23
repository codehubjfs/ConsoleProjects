package com.issueraisesystem.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.issueraisesystem.beans.Login;
import com.issueraisesystem.util.*;
public class LoginDAO {

	
	 public boolean isValidUser(Login login,String role) throws SQLException {
	        
		  boolean isValid = false;
		  PreparedStatement stmt= null;
		  ResultSet rs=null;
		  
		       
	            // Get connection from DBUtil
	      if(role.equals("Student")) {     
				  try {
			            // Get connection from DBUtil
					  	String sql = "SELECT * FROM students WHERE mailid =? and password=? ";
			            stmt = DBUtil.openConnection().prepareStatement(sql);
			            stmt.setString(1, login.getMailid());
			            stmt.setString(2,login.getPassword());
			            
			            rs=stmt.executeQuery();
		
			            if (rs.next()) {
			               
			                isValid = true;
			            }
			        } finally {
			            // Close connections and resources
			            if (rs != null) {
			                rs.close();
			            }
			            if (stmt != null) {
			                stmt.close();
			            }
			            
			        }
		
			        return isValid;
	      	}
	      if(role.equals("Admin")) {
	    	  try {
		            // Get connection from DBUtil
				  	String sql = "SELECT * FROM admin WHERE mailid =? and password=? ";
		            stmt = DBUtil.openConnection().prepareStatement(sql);
		            stmt.setString(1, login.getMailid());
		            stmt.setString(2,login.getPassword());
		            rs=stmt.executeQuery();
	
		            if (rs.next()) {
		               
		                isValid = true;
		            }
		        } finally {
		            // Close connections and resources
		            if (rs != null) {
		                rs.close();
		            }
		            if (stmt != null) {
		                stmt.close();
		            }
		            
		        }
	
		        return isValid;
	    	  
	      }
	      
	      if(role.equals("Warden")) {
	    	  try {
		            // Get connection from DBUtil
				  	String sql = "SELECT * FROM warden WHERE mailid =? and password=? ";
		            stmt = DBUtil.openConnection().prepareStatement(sql);
		            stmt.setString(1, login.getMailid());
		            stmt.setString(2,login.getPassword());
		            rs=stmt.executeQuery();
	
		            if (rs.next()) {
		               
		                isValid = true;
		            }
		        } finally {
		            // Close connections and resources
		            if (rs != null) {
		                rs.close();
		            }
		            if (stmt != null) {
		                stmt.close();
		            }
		            
		        }
	
		        return isValid;
	    	  
	      }
	      if(isValid) {
	    	  return true;
	      }
	      return false;
	 }
	            

}
