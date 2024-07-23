package com.databaseconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {

	    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    private static final String userName = "TICKETBOOKING";
	    private static final String password = "root";
	    public static Connection getDBConnection() {
	        Connection con = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection(url, userName, password);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
}
