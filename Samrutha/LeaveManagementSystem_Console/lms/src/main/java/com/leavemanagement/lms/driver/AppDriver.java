package com.leavemanagement.lms.driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class AppDriver {
	
	private static Connection conn;
	public static Connection getConnection() {
		try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "LMS", "oracle123");
	    	return conn;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
