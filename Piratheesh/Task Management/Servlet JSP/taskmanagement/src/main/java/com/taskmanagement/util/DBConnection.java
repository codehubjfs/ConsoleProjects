package com.taskmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
private static Connection connection;
	
	public DBConnection() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project1","oracle123");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static DBConnection dbConnection;
	
	public  Connection getConnection() {
		return connection;
	}
	
	public static DBConnection getInstance() {
		if(dbConnection == null) {
			dbConnection = new DBConnection();
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
