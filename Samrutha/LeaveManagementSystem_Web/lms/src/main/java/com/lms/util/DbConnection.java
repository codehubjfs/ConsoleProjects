package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	private static Connection conn;
	
	//Create connection
	public DbConnection() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Leavemanagement", "oracle123");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//getConnection
	private static DbConnection dbConnection;
	public  Connection getConnection() {
		return conn;
	}
	public static DbConnection getInstance() {
		if(dbConnection == null) {
			dbConnection = new DbConnection();
		}
		return dbConnection;
	}
	
	//Close connection
	public static void closeConnection() {
		try {
			if(dbConnection!=null) {
				conn.close();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
