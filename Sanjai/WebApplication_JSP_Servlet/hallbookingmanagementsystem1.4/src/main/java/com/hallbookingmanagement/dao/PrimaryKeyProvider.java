package com.hallbookingmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hallbookingmanagement.bdutil.DBConnection;

public class PrimaryKeyProvider {
    public static int primaryKey(String tableName){
        int primeNumber = 0;
        try {
            String insert = "";
            if(tableName.equalsIgnoreCase("users")) {
                insert = "user_id";
            }
            else if(tableName.equalsIgnoreCase("halls")) {
                insert = "hall_id";
            }
            else if(tableName.equalsIgnoreCase("Booking")) {
                insert = "Book_id";
            }
            else if(tableName.equalsIgnoreCase("Payment")){
                insert = "payment_id";
            }
            String query = "Select Max("+insert+") from "+tableName;
            Statement statement = DBConnection.getInstance().getConnection().createStatement();
            ResultSet set = statement.executeQuery(query);
             if(set.next()) {
                 primeNumber =set.getInt(1);
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return primeNumber+1;
    }
}
