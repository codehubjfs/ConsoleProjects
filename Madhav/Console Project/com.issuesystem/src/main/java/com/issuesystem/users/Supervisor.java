package com.issuesystem.users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.issuesystem.users.*;
import com.issuesystem.dbconnection.DBConnection;

public class Supervisor {
	public static String authenticateSupervisor(String username,String password) {
		try {
		    String sql = "SELECT username, password,name FROM supervisor WHERE username=?";
		    PreparedStatement stmt = DBConnection.getDBConnextion().prepareStatement(sql);
		    stmt.setString(1, username);
		    ResultSet result = stmt.executeQuery();
		    Person person=new Person(username,password);
		    if (result.next()) { // Check if ResultSet has any rows
		        String storedUsername = result.getString("username");
		        String storedPassword = result.getString("password");
		        String name = result.getString("name");
		       
		        if (storedUsername.equalsIgnoreCase(person.getUsername()) && storedPassword.equals(person.getPassword())) {
		            
		            return "......................welcome"+" "+name+"........................"+ "\nlogged as: SUPERVISOR";
		        } else {
		            
		            return "Wrong";
		        }
		    } 
		      
		  
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		  return "User not found";
		
	}
	
	public static Person gettingSuperVisorName(String username,String password) {
		
		Person obj = null;
		try {
		    String sql = "SELECT * FROM supervisor WHERE username=?";
		    PreparedStatement stmt = DBConnection.getDBConnextion().prepareStatement(sql);
		    stmt.setString(1, username);
		    ResultSet result = stmt.executeQuery();
		    
		    List<Person>superVisorDetails=new ArrayList<>();
		    
		    
		    while(result.next()) { // Check if ResultSet has any rows
		    	 obj=new Person(result.getString("name"),result.getString("role"),result.getInt("superid"));   
		    	superVisorDetails.add(obj);
		    } 
		      
		  
		} catch (SQLException e) {
		    e.getMessage();
		}
		return obj;
		
		
	}

}
