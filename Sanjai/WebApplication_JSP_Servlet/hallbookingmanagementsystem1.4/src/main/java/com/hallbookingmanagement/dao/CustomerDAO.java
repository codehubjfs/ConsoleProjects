package com.hallbookingmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Customer;

public class CustomerDAO implements DAO<Customer> {
	
	public List<Customer> getAll() throws SQLException{
			String  sqlQuery = "select * from users";
			PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sqlQuery);
			ResultSet resultSet =  statement.executeQuery();
			List<Customer> list = new ArrayList<>();
			while(resultSet.next()) {
			
				Customer customer = new Customer();
				customer.setUserId(resultSet.getInt("user_id"));
				customer.setName(resultSet.getString("Name"));
				customer.setGender(resultSet.getString("Gender"));
				customer.setEmailId(resultSet.getString("EMAIL_ID"));
				customer.setNumber(resultSet.getString("PHONE_NUMBER"));
				customer.setAddress(resultSet.getString("Address"));
				customer.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
				customer.setAccountStatus(resultSet.getString("ACCOUNT_STATUS"));
				customer.setUserName(resultSet.getString("USERNAME"));
				customer.setPassword(resultSet.getString("PASSWORD"));
				list.add(customer);				}
			return list;
	}
	public boolean updateStatus(Customer customer) throws SQLException {
		String updateQuery = "Update users set ACCOUNT_STATUS=? where USER_ID=?";
		PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(updateQuery);
		statement.setString(1,customer.getAccountStatus());
		statement.setInt(2,customer.getUserId());
		return statement.executeUpdate()>0?true:false;
	}
	public boolean add(Customer customer) throws SQLException {
		String insertQuery ="INSERT INTO users (user_id, name, gender, email_id, phone_number, address, account_type, account_status, username, password)\n" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement  = DBConnection.getInstance().getConnection().prepareStatement(insertQuery);
		statement.setInt(1,customer.getUserId());
		statement.setString(2, customer.getUserName());
		statement.setString(3,customer.getGender());
		statement.setString(4,customer.getEmailId());
		statement.setString(5,customer.getNumber());
		statement.setString(6,customer.getAddress());
		statement.setString(7,customer.getAccountType());
		statement.setString(8,customer.getAccountStatus());
		statement.setString(9,customer.getUserName());
		statement.setString(10,customer.getPassword());
		return statement.executeUpdate()>0?true:false;
	}
	public boolean delete(Customer customer) throws SQLException {
		String deleteQuery = "Update users set account_status= ? where user_id = ?";
		PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
		statement.setInt(1,customer.getUserId());
		return statement.executeUpdate()>0?true:false;
	}
}
