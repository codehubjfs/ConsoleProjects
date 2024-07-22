package com.ungalkadai.components;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.users.Customer;
import com.ecommerce.users.DbConnection;
import com.ecommerce.users.DbmsConnection;

public class Card extends Payment{
	
	private String cardNumber;
	private String cardHolderName;
	private String cardExpiryDate;
	private int cvv;
	
	public Card() {
		
	}
	public Card(Customer customer, Order order, double amount, String paymentType, PaymentStatus paymentStatus,
			String cardNumber, String cardHolderName, String cardExpiryDate, int cvv) {
		super(customer, order, amount, paymentType, paymentStatus);
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cardExpiryDate = cardExpiryDate;
		this.cvv = cvv;
	}
	
	
	public Card(Customer customer, Order order, double amount, String paymentType, PaymentStatus paymentStatus,
			String cardNumber, String cardHolderName, int cvv) {
		super(customer, order, amount, paymentType, paymentStatus);
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
	public boolean makePayment(Card card) {
		String sql = "insert into payment values(payment_sequence.nextval,?,SYSDATE,?,?,?)";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, card.getOrder().getOrderId());
			statement.setString(2, card.getPaymentType());
			statement.setString(3, card.getPaymentStatus().toString());
			statement.setDouble(4, card.getAmount());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Payment has been done sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
//	public Card(Customer customer, Order order, double amount, String paymentType, PaymentStatus paymentStatus) {
//		super(customer, order, amount, paymentType, paymentStatus);
//
//	}

}
