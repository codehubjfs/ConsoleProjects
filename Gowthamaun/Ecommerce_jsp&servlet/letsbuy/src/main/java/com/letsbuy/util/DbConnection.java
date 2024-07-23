package com.letsbuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "ecommercesystem";
    private static final String PASSWORD = "oracle123";
    
    private static Connection connection = null;

   public static Connection openConnection() {
	   if(connection!=null) {
//		   System.out.println("The inside if");
		   return connection;
	   }
	   else {
//		   System.out.println("The inside else");
		   try {
//			   System.out.println("The inside else0");
			  Class.forName(DRIVER);
//			  System.out.println("The inside else1");
			  connection = DriverManager.getConnection(URL, USER, PASSWORD);
//			  System.out.println("The inside else2");
		   }catch(SQLException | ClassNotFoundException e) {
//			   System.out.println(e.getMessage());
			   System.out.println("Conn Error: "+e);
		   }
	   }
	   return connection;
   }
}
