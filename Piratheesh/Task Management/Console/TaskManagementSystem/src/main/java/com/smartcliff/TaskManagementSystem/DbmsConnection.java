package com.smartcliff.TaskManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//public class DbmsConnection {
//	private static Connection connection;
//	
//	public static Connection getConnection() throws SQLException {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project1","oracle123");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
//
//}

public class DbmsConnection {
	private static Connection connection;
	
	public DbmsConnection() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project1","oracle123");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static DbmsConnection dbConnection;
	
	public  Connection getConnection() {
		return connection;
	}
	
	public static DbmsConnection getInstance() {
		if(dbConnection == null) {
			dbConnection = new DbmsConnection();
		}
		return dbConnection;
	}
	
	public static void closeConnection() {
		try {
			if(dbConnection!=null) {
				connection.close();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}