package com.letsbuy.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer extends Person{
	private int customerId;
    private String firstName;
    private String lastName;
    private String gender;
    private Cart myCart;
    @Autowired
    private Orders myOrders;
    private Account account;
    
    public Customer() {
    	super();
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Cart getMyCart() {
		return myCart;
	}

	public void setMyCart(Cart myCart) {
		this.myCart = myCart;
	}

	public Orders getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(Orders myOrders) {
		this.myOrders = myOrders;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", myCart=" + myCart + ", myOrders=" + myOrders + ", account=" + account + "] "+super.toString();
	}
	
	
}
