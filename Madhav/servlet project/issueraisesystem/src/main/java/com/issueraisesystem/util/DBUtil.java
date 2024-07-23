package com.issueraisesystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DRIVRER="oracle.jdbc.driver.OracleDriver";
	private static final String USERNAME="issueraisesystem";
	private static final String PASSWORD="oracle123";
	private static Connection connection=null;
	
	public static Connection openConnection() {
		if(connection!=null) {
			return connection;
		}
		else {
			try {
				Class.forName(DRIVRER);
				connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return connection;
	}
}
