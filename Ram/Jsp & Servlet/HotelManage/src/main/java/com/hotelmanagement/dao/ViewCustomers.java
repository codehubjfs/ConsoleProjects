package com.hotelmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Customer;
import com.hotelmanagement.utilities.DbUtil;

public class ViewCustomers {
	

    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT CUSTOMER_ID, F_NAME, L_NAME, EMAIL, PHONE_NO, ADDRESS FROM CUSTOMER";
        try {
        	PreparedStatement statement = DbUtil.openConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
                customer.setFirstName(resultSet.getString("F_NAME"));
                customer.setLastName(resultSet.getString("L_NAME"));
                customer.setEmail(resultSet.getString("EMAIL"));
                customer.setPhoneNo(resultSet.getLong("PHONE_NO"));
                customer.setAddress(resultSet.getString("ADDRESS"));
                customers.add(customer);
            }
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        return customers;
    }

    public Customer getCustomerById(int customerId) throws Exception {
        Customer customer = null;
        String query = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        try  {
        	PreparedStatement statement = DbUtil.openConnection().prepareStatement(query);
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
                    customer.setFirstName(resultSet.getString("F_NAME"));
                    customer.setLastName(resultSet.getString("L_NAME"));
                    customer.setEmail(resultSet.getString("EMAIL"));
                    customer.setPhoneNo(resultSet.getLong("PHONE_NO"));
                    customer.setAddress(resultSet.getString("ADDRESS"));
                    customer.setPassword(resultSet.getString("PASSWORD"));
                }
            }
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        return customer;
    }

}
