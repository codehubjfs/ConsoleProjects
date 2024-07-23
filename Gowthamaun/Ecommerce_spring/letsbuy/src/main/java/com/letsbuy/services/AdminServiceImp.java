package com.letsbuy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Category;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.beans.Vendor;
import com.letsbuy.mappers.AdminMapper;
import com.letsbuy.mappers.CategoryMapper;
import com.letsbuy.mappers.CustomerMapper;
import com.letsbuy.mappers.OrderMapper;
import com.letsbuy.mappers.ProductMapper;
import com.letsbuy.mappers.SubCategoryMapper;
import com.letsbuy.mappers.VendorMapper;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	CustomerMapper customerMapper;
	@Autowired
	VendorMapper vendorMapper;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	SubCategoryMapper subCategoryMapper;
	@Autowired
	Admin admin;

	@Override
	public int validateLogin(Admin admin) {
		// TODO Auto-generated method stub
		System.out.println("Inside admin validate Login Service");
		List<Admin> adminList = adminMapper.getAllAdmin();
		List<Admin> filtered = adminList.stream()
				.filter(a->a.getPassowrd().equals(admin.getPassowrd()) && a.getUserName().equals(admin.getUserName()))
				.collect(Collectors.toList());
		return filtered.size()>0?filtered.get(0).getAdminId():-1;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = customerMapper.getAllCustomers();
		return customers;
	}
	
	public List<Vendor> getAllVendors(){
		List<Vendor> vendors = vendorMapper.getAllVendors();
		return vendors;
	}
	
	public long countOfOrders() {
		long count = orderMapper.getOrdersCount();
		return count;
	}
	
	@Override
	public boolean deleteCustomer(Customer customer) {
		Account account = customer.getAccount();
		account.setAccountStatus("DELETED");
		customer.setAccount(account);
		boolean status = customerMapper.changeCustomerStatus(customer);
		return status;
	}

	@Override
	public boolean editCustomer(Customer customer,String status) {
		Account account = customer.getAccount();
		account.setAccountStatus(status);
		customer.setAccount(account);
		boolean updateStatus = customerMapper.changeCustomerStatus(customer);
		return updateStatus;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productsList = productMapper.getAllProduct();
		return productsList;
	}

	@Override
	public boolean editVendor(Vendor vendor, String status) {
		Account account = vendor.getAccount();
		account.setAccountStatus(status);
		vendor.setAccount(account);
		boolean flag = vendorMapper.updateStatus(vendor);
		return flag;
	}

	@Override
	public boolean editProduct(Product product, String status) {
		product.setVerificationStatus(status);
		boolean flag = productMapper.updateProductStatus(product);
		return flag;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categoryList = categoryMapper.getAllCategory();
		return categoryList;
	}

	@Override
	public boolean editCategory(Category category) {
		System.out.println("Edit actegory : "+category.getVerificationStatus());
		boolean flag = categoryMapper.editCategorystatus(category);
		return flag;
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		List<SubCategory> subCategoryList = subCategoryMapper.getAllSubCategories();
		return subCategoryList;
	}

	@Override
	public boolean editSubCategory(SubCategory subCategory) {
		boolean flag = subCategoryMapper.updateSubCategory(subCategory);
		return flag;
	}

	@Override
	public boolean addSubCategory(SubCategory subCategory) {
		boolean flag = subCategoryMapper.addSubCategory(subCategory);
		return false;
	}

	@Override
	public boolean addCategory(Category category) {
		boolean flag = categoryMapper.addCategory(category);
		return flag;
	}

	@Override
	public boolean editAdminPassword(Admin admin) {
		boolean flag = adminMapper.updatePassword(admin);
		return flag;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> adminList = adminMapper.getAllAdmin();
		return adminList;
	}

	@Override
	public boolean addAdmin(String userName) {
		admin.setUserName(userName);
		boolean flag = adminMapper.addAdmin(admin);
		return flag;
	}
	
	


}
