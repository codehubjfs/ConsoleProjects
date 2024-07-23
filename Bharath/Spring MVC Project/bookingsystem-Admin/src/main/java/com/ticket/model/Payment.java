package com.ticket.model;

public class Payment {
	int payId;
	int accountNumber;
	String paymentMethod;
	int totalAmount;
	BookingBean book;
	String paymentStatus;
	public Payment() {
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BookingBean getBook() {
		return book;
	}
	public void setBook(BookingBean book) {
		this.book = book;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", accountNumber=" + accountNumber + ", paymentMethod=" + paymentMethod
				+ ", totalAmount=" + totalAmount + ", book=" + book + ", paymentStatus=" + paymentStatus + "]";
	}
	
}
