package com.hallbookingmanagement.beans;

import java.security.PublicKey;
import java.time.LocalDateTime;

public class Payment {

  private int paymentId;
  private Booking book;
  private LocalDateTime paymentTime;
  private String paidStatus;
  private double price;
  public Payment(){

  }
  public int getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(int paymentId) {
    this.paymentId = paymentId;
  }

  public Booking getBook() {
    return book;
  }

  public void setBook(Booking book) {
    this.book = book;
  }

  public LocalDateTime getPaymentTime() {
    return paymentTime;
  }

  public void setPaymentTime(LocalDateTime paymentTime) {
    this.paymentTime = paymentTime;
  }

  public String getPaidStatus() {
    return paidStatus;
  }

  public void setPaidStatus(String paidStatus) {
    this.paidStatus = paidStatus;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
@Override
public String toString() {
	return "Payment [paymentId=" + paymentId + ", book=" + book + ", paymentTime=" + paymentTime + ", paidStatus="
			+ paidStatus + ", price=" + price + "]";
}
  
  
}