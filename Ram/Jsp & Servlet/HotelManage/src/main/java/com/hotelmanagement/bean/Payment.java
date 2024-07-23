package com.hotelmanagement.bean;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable{
	private int paymentId;
    private int bookingId;
    private double paymentAmt;
    private Date paymentDate;
    private String paymentMethod;
    private String paymentStatus;

    // Default constructor
    public Payment() {}

    // Parameterized constructor
    public Payment(int paymentId, int bookingId, double paymentAmt, Date paymentDate, String paymentMethod, String paymentStatus) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentAmt = paymentAmt;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
