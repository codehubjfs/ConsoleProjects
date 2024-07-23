package com.hallbookingsystem.paymentdetails;

import com.hallbookingsystem.bookingdetails.Book;

import java.io.IOException;
import java.sql.SQLException;
/**
 * The Payment interface represents a payment method for booking a hall.
 * It defines the contract for processing payments.
 * @author Sanjai
 * @since 10-May-2024
 */
public interface Payment {
        boolean pay(Book book) throws SQLException, IOException;

}
