package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Vendor;
import com.letsbuy.util.DbConnection;

public class SellerDAO {
	
	public List<Vendor> getAllSellers(){
		List<Vendor> sellers = new ArrayList<>();
		
		String sql = "select * from vendor";
		try {
		Statement statement = DbConnection.openConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			Vendor seller = new Vendor();
			Account account = new Account();
			account.setAccountStatus(resultSet.getString("account_status"));
			account.setAccountType(resultSet.getString("account_type"));
			account.setPassword(resultSet.getString("password"));
			account.setUserName(resultSet.getString("username"));
			seller.setAccount(account);
			seller.setAddress(resultSet.getString("address"));
			seller.setVendorId(resultSet.getInt("v_id"));;
			seller.setEmail(resultSet.getString("email"));
			seller.setRegisteredNumber(resultSet.getString("reg_no"));
			seller.setAadharNumber(resultSet.getLong("aadhar_no"));
			seller.setMobileNumber(resultSet.getLong("mobile_no"));
//			seller.setGender(resultSet.getString("gender"));
			sellers.add(seller);
		}
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return sellers;
	}
	
	public void updateAccountStatus(Vendor vendor) {
		String sql = "update vendor set account_status=? where v_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, vendor.getAccount().getAccountStatus());
			statement.setInt(2, vendor.getVendorId());
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
