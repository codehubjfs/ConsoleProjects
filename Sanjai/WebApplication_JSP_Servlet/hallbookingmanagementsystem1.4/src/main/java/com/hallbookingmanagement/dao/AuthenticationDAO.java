package com.hallbookingmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.hallbookingmanagement.beans.Customer;

public class AuthenticationDAO {
	public AuthenticationDAO(){
		
	}
    public static Customer register(Customer guest) throws SQLException {
		boolean isUniqueUsername = uniqueUserNameChecker(guest.getUserName());
		boolean isUniqueNumber = uniqueNumberChecker(guest.getNumber());
		boolean isUniqueMail = uniqueMailChecker(guest.getEmailId());
		if(isUniqueUsername && isUniqueNumber && isUniqueMail ){
			boolean isAdded = new CustomerDAO().add(guest);
			if(isAdded){
				System.out.println("Added Success fully");
				return guest;
			}
			else {
				System.out.println("Not added");
			}
		}
		return null;
    }

	public static boolean uniqueMailChecker(String mail) throws SQLException {
		List<Customer> list = new CustomerDAO().getAll();
		for(Customer customer: list){
			if (customer.getEmailId().equals(mail)){
				System.out.println("duplicate occur mail");
				return false;
			}
		}
		return true;
	}

	public static boolean uniqueNumberChecker(String number) throws SQLException {
		List<Customer> list = new CustomerDAO().getAll();
		for(Customer customer: list){
			if (customer.getNumber().equals(number)){
				System.out.println("duplicate occur number");
				return false;
			}
		}
		return true;
	}

	public static boolean uniqueUserNameChecker(String userName) throws SQLException {
		List<Customer> list = new CustomerDAO().getAll();
		for(Customer customer: list){
			if (customer.getUserName().equals(userName)){
				System.out.println("duplicate occur userName");
				return false;
			}
		}
		return true;
	}

	public Customer login(Customer guest) throws SQLException {
	        List<Customer> list = new CustomerDAO().getAll();
	        for(Customer customer : list) {
	        	if(customer.getUserName().equals(guest.getUserName()) 
	        			&& customer.getPassword().equals(guest.getPassword())) {
	        		System.out.println("Valid Credentials");
	        		return customer;
	        	}
	        }
	        return null;
	    }
}
