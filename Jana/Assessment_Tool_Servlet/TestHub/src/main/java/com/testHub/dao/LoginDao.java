package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.testHub.bean.User;
import com.testHub.utilities.DbConnection;

public class LoginDao {

	public boolean validateLogin(User user){
		
		 String sql="";
	        if ("Student".equals(user.getUser())){
	            sql = "SELECT * FROM student WHERE email = ? and password=?";
	        } else if ("Admin".equals(user.getUser())) {
	            sql = "SELECT * FROM Admin WHERE email = ? and password=?";
	        } else if ("Instructor".equals(user.getUser())) {
	            sql = "SELECT * FROM educator WHERE email = ? and password=?";
	        } 
	        
		 try {
			 Connection con = DbConnection.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
		        pstmt.setString(1, user.getEmail());
		        pstmt.setString(2, user.getPassword());
		        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            	return true;
              
            }
            
            
    } catch (SQLException e) {
        e.printStackTrace();
        
    }
		 
		 return false;
	}

}
