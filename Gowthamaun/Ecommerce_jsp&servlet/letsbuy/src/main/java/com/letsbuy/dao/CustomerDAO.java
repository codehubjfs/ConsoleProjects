package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.util.DbConnection;

public class CustomerDAO {
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<>();
		String sql = "SELECT c.c_id, c.username, c.password, c.first_name, c.last_name, c.address, c.gender, c.mobile_no, c.email_id, c.account_type, c.account_status, ca.cart_id FROM customer c INNER JOIN cart ca ON c.c_id = ca.c_id";
//		String sql = "select * from customer";
		try {
		Statement statement = DbConnection.openConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			Customer customer = new Customer();
			Account account = new Account();
			Cart cart = new Cart();
			cart.setCart_id(resultSet.getInt("cart_id"));
			customer.setMyCart(cart);
			account.setAccountStatus(resultSet.getString("account_status"));
			account.setAccountType(resultSet.getString("account_type"));
			account.setPassword(resultSet.getString("password"));
			account.setUserName(resultSet.getString("username"));
			customer.setAccount(account);
			customer.setAddress(resultSet.getString("address"));
			customer.setCustomerId(resultSet.getInt("c_id"));
			customer.setEmail(resultSet.getString("email_id"));
			customer.setFirstName(resultSet.getString("first_name"));
			customer.setLastName(resultSet.getString("last_name"));
			customer.setMobileNumber(resultSet.getLong("mobile_no"));
			customer.setGender(resultSet.getString("gender"));
			customers.add(customer);
		}
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return customers;
	}
	
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
	
	public void updatePassword(String password,Customer customer) {
		String sql = "update customer set password=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, password);
			statement.setInt(2, customer.getCustomerId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your password has been changed sucessfully");
				customer.getAccount().setPassword(password);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateFirstName(String firstName,Customer customer) {
		String sql = "update customer set first_name=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setInt(2, customer.getCustomerId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your First Name has been changed sucessfully");
				customer.setFirstName(firstName);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateLastName(String lastName,Customer customer) {
		String sql = "update customer set last_name=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, lastName);
			statement.setInt(2, customer.getCustomerId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Last Name has been changed sucessfully");
				customer.setLastName(lastName);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateAddress(String address,Customer customer) {
		String sql = "update customer set address=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, address);
			statement.setInt(2, customer.getCustomerId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Address has been changed sucessfully");
				customer.setAddress(address);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateMobileNumber(long mobileNumber,Customer customer) {
		String sql = "update customer set mobile_no=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setLong(1, mobileNumber);
			statement.setInt(2, customer.getCustomerId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Mobile Number has been changed sucessfully");
				customer.setMobileNumber(mobileNumber);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void updateEmail(String email,Customer customer) {
			String sql = "update customer set email_id=? where c_id=?";
			try {
				PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
				statement.setString(1, email);
				statement.setInt(2, customer.getCustomerId());
				int rowsAffected = statement.executeUpdate();
				if(rowsAffected>0) {
					System.out.println("Your Email Id has been changed sucessfully");
					customer.setEmail(email);
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		
	}
	
	public void updateAccountStatus(Customer customer) {
		String sql = "update customer set account_status=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, customer.getAccount().getAccountStatus());
			statement.setInt(2, customer.getCustomerId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Account status has been changed sucessfully");
//				customer.setEmail(email);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
}
}
