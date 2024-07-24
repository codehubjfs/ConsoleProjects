package com.hallbookingmanagement.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hallbookingmanagement.beans.Customer;


@Repository
public interface CustomerMapper {
	public List<Customer> getAllCustomer();
	public boolean getCustomer(int i);
	public int changePassword(Customer customer);
	public int addCustomer(Customer customer);
	public int updateStatus(Customer customer);
}
