package com.letsbuy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Category;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.beans.Vendor;


public interface AdminService {
	int validateLogin(Admin admin);
	List<Customer> getAllCustomers();
	List<Vendor> getAllVendors();
	List<Product> getAllProducts();
	List<Category> getAllCategory();
	List<SubCategory> getAllSubCategory();
	List<Admin> getAllAdmin();
	long countOfOrders();
	boolean deleteCustomer(Customer customer);
	boolean editCustomer(Customer customer,String status);
	boolean editVendor(Vendor vendor,String status);
	boolean editProduct(Product product,String status);
	boolean editCategory(Category category);
	boolean editSubCategory(SubCategory subCategory);
	boolean editAdminPassword(Admin admin);
	boolean addSubCategory(SubCategory subCategory);
	boolean addCategory(Category category);
	boolean addAdmin(String userName);
}
