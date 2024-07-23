package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Login;
import com.letsbuy.util.DbConnection;

public class RegisterDAO {
	
	public boolean registerCustomer(Customer customer) {
		
		String sql = "insert into customer values(customer_sequence.nextval,?,?,?,?,?,?,?,?,?,?)";
	      try{
	    	  //System.out.println("I am inside try");
	          PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
	          //statement.setInt(1,customer.getCustomerId());
	          statement.setString(1,customer.getAccount().getUserName());
	          statement.setString(2,customer.getAccount().getPassword());
	          statement.setString(3, customer.getFirstName());
	          statement.setString(4,customer.getLastName());
	          statement.setString(5,customer.getAddress());
	          statement.setString(6,customer.getGender().toString());
	          statement.setLong(7,customer.getMobileNumber());
	          statement.setString(8,customer.getEmail());
	          statement.setString(9,customer.getAccount().getAccountType());
	          statement.setString(10,customer.getAccount().getAccountStatus());
	          int rowsAffected = statement.executeUpdate();
	          //System.out.println("After the executeUpdate query");
	          if(rowsAffected>=1) {
	        	  System.out.println("Registered as Customer Successfully!!");
	        	  System.out.println("Welcome "+customer.getFirstName()+ " to my ecommerce platform");
	        	  return true;
	          }else {
	        	  System.out.println("There is some error occured");
	          }
	      }catch (Exception e){
	    	  if(e.getMessage().contains("unique constraint")) {
	    		  System.out.println("Provided email/Mobile Number is already exist");
	    	  }else {
	          System.out.println(e.getMessage());
	    	  }
	      }
		return false;
	}
}
