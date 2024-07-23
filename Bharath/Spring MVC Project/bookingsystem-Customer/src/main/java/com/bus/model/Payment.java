package com.bus.model;

import java.awt.print.Book;

public class Payment {
	private int pay_id;
	private String accountNumber;
	private String paymentMethod;
	private double totalAmount;
	private Booking book;

	private String paymentStatus;

	public Payment() {

	}

	public Payment(int pay_id, String accountNumber, String paymentMethod, int totalAmount, 
			Booking book,String paymentStatus) {
		super();
		this.pay_id = pay_id;
		this.accountNumber = accountNumber;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.book = book;
		this.paymentStatus = paymentStatus;
	}

	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	

	public Booking getBook() {
		return book;
	}

	public void setBook(Booking book) {
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
		return "Payment [pay_id1=" + pay_id + ", accountNumber=" + accountNumber + ", paymentMethod=" + paymentMethod
				+ ", totalAmount=" + totalAmount + ", \n Book1=" + book + ", paymentStatus="
				+ paymentStatus + "]\n";
	}

	
	
}
