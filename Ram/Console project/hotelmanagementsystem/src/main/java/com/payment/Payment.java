package com.payment;

public class Payment {
	private int payment_id;
	private int booking_id;
	private int payment_amt;
	private String payment_date;
	private Payment_method p_method;
	private String payment_status;
	public Payment(int payment_id, int booking_id, int payment_amt, String payment_date, Payment_method p_method, String payment_status) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.payment_amt = payment_amt;
		this.payment_date = payment_date;
		this.p_method = p_method;
		this.payment_status=payment_status;
	}
	public Payment()
	{
		
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getPayment_amt() {
		return payment_amt;
	}
	public void setPayment_amt(int payment_amt) {
		this.payment_amt = payment_amt;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public Payment_method getP_method() {
		return p_method;
	}
	public void setP_method(Payment_method p_method) {
		this.p_method = p_method;
	}
	
}
