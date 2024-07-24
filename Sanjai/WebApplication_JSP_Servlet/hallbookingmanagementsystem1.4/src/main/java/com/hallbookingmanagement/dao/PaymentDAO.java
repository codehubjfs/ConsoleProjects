package com.hallbookingmanagement.dao;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements DAO<Payment>{

    @Override
    public List<Payment> getAll() throws SQLException {
        List<Payment> list = new ArrayList<>();
        String query = "select * from Hallbooking.payment";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet resultset = statement.executeQuery();
        List<Booking> bookList = new BookDAO().getAll();
        while(resultset.next()){
        	Booking book = new Booking();
            Payment payment = new Payment();
            payment.setPaymentId(resultset.getInt("PAYMENT_ID"));
            int bookId = resultset.getInt("BOOK_ID");
            book =bookList.stream()
                    .filter(b -> b.getBookingId()== bookId)
                    .findFirst().orElse(null);
            payment.setBook(book);
            payment.setPaymentTime(resultset.getTimestamp("PAYMENT_TIME").toLocalDateTime());
            payment.setPaidStatus(resultset.getString("PAID_STATUS"));
            payment.setPrice(resultset.getDouble("price"));
            list.add(payment);
        }
        
        System.out.println("PaymentList :"+list);
        return list;
    }

    @Override
    public boolean add(Payment payment) throws SQLException {
    	payment.setPaymentId(PrimaryKeyProvider.primaryKey("Payment"));
       String insertQuery = "INSERT INTO Hallbooking.PAYMENT (PAYMENT_ID, BOOK_ID, PAYMENT_TIME, PAID_STATUS, PRICE)VALUES (?, ?, ?, ?, ?)";
       
       PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(insertQuery);
       statement.setInt(1,payment.getPaymentId());
       statement.setInt(2,payment.getBook().getBookingId());
       statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
       statement.setString(4,payment.getPaidStatus());
       statement.setDouble(5,payment.getPrice());
       if(statement.executeUpdate()>0) {
    	   System.out.println("in update"+payment);
    	   return true;
       }
       DBConnection.getInstance().getConnection().commit();
       return false;
       
    }

    @Override
    public boolean delete(Payment payment) throws SQLException {
       String deleteQuery = "delete Hallbooking.PAYMENT from where payment_ID = ?";
       PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
       return statement.executeUpdate()>0?true:false;
    }
    
    public boolean refund(Payment payment) throws SQLException{
    	  String deleteQuery = "delete Hallbooking.PAYMENT from where payment_ID = ?";
          PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
          return statement.executeUpdate()>0?true:false;
    }

}
