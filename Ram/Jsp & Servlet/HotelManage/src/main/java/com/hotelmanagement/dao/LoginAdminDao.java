package com.hotelmanagement.dao;

import java.sql.Connection;

import com.hotelmanagement.utilities.DbUtil;

public class LoginAdminDao {
	
	public boolean validateAdmin()
	{
		
		boolean status = false;
		try {
			Connection conn = DbUtil.openConnection();
			String sql = "SELECT * from ";
		}
		return false;
		
		
	}
	
}
