package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "TicketBooking";
        String password = "root";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, username, password);
    }

}
