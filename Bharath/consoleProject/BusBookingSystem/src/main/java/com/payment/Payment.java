package com.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bookingbus.Booking;
import com.bookingbus.Bus;

public class Payment {
	private int payId;
	private String cardNumber;
    private double totalAmount;
    private String paymentMethod;
    Booking book;
	
	public Payment(int payId, String cardNumber, double totalAmount, String paymentMethod, Bus bus, Booking book) {
		super();
		this.payId = payId;
		this.cardNumber = cardNumber;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.book = book;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getAccountNumber() {
		return cardNumber;
	}
	public void setAccountNumber(String cardNumber) {
		this.cardNumber=cardNumber;
		
	}

	public Booking getBook() {
		return book;
	}

	public void setBook(Booking book) {
		this.book = book;
	}

	public Payment() {
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	 public void selectPaymentMethod() {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Select payment method:");
	        System.out.println("1. Credit/Debit Card");
	        System.out.println("2. UPI");
	        System.out.println("3. Net Banking");//Integrate with various banks to allow users to pay through their online banking accounts.
	        int choice;
			try {
				choice = Integer.parseInt(in.readLine());
				switch (choice) {
	            case 1:
	                paymentMethod = "Credit/Debit Card";
	                break;
	            case 2:
	                paymentMethod = "UPI";
	                break;
	            case 3:
	                paymentMethod = "Net Bank";
	                break;
	            default:
	                System.out.println("Invalid payment method.");
	                selectPaymentMethod();
	        }

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	    public void processPayment() {
	        System.out.println("Processing payment using " + paymentMethod);
	        
	        System.out.println("Payment successful!");
	    }

		@Override
		public String toString() {
			return "Payment [payId=" + payId + ", cardNumber=" + cardNumber + ", totalAmount=" + totalAmount
					+ ", paymentMethod=" + paymentMethod + ", book=" + book + "]";
		}
}