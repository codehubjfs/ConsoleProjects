package com.primarykeyid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.databaseconnection.DbConnection;

public class PrimaryKey {
	//Generates the next primary key value for the given table.
	public static int keys(String tableName) {
        int Number = 0;
        try {
            String insert = "";
            if(tableName.equalsIgnoreCase("customer")) {
                insert = "customer_id";
            }
            else if(tableName.equalsIgnoreCase("Admin")) {
                insert = "admin_id";
            }
            else if(tableName.equalsIgnoreCase("Busoperator")) {
                insert = "oper_id";
            }
            else if(tableName.equalsIgnoreCase("Route")){
                insert = "route_id";
            }
            else if(tableName.equalsIgnoreCase("Bus")) {
            	insert="bus_id";
            }
            else if(tableName.equalsIgnoreCase("Book")) {
            	insert="BOOKINGID";
            }
            else if(tableName.equalsIgnoreCase("payment")) {
            	insert="pay_id";
            }
            String query = "Select Max("+insert+") from "+tableName;
            Statement statement = DbConnection.getDBConnection().createStatement();
            ResultSet set = statement.executeQuery(query);
             if(set.next()) {
                 Number =set.getInt(1);
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Number+1;
    }

}


