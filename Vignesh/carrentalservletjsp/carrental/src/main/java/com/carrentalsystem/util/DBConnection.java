package com.carrentalsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String USERNAME="carrentalsystem";
	private static final String PASSWORD="oracle123";
	private static Connection connection=null;
	
	public static Connection openConnection() {
		if(connection!=null) {
			return connection;
		}
		else {
			try {
				Class.forName(DRIVER);
				connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return connection;
	}
	
}
