package com.ecommerce.users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.menu.SellerActivity;
import com.ecommerce.users.account.Account;
import com.ecommerce.users.account.AccountStatus;
import com.ecommerce.users.authentication.Authentication;
import com.ungalkadai.components.Order;
import com.ungalkadai.components.Product;
import com.ungalkadai.components.ProductStatus;
import com.ungalkadai.components.SubCategory;
import com.ungalkadai.tester.UngalKadaiTester;

public class Vendor extends Person implements Authentication{
	private int vendorId;
	private String registeredNumber;
	private Account account;
	private long aadharNumber;
	
	public Vendor() {
		super();
	}
	
	public Vendor(int vendorId,String registeredNumber,Account account,long aadharNumber,String email,long mobileNumber,String address) {
		super(address,email,mobileNumber);
		this.vendorId = vendorId;
		this.registeredNumber = registeredNumber;
		this.account = account;
		this.aadharNumber = aadharNumber;
	}
	
	public Vendor(String registeredNumber,Account account,long aadharNumber,String email,long mobileNumber,String address) {
		super(address,email,mobileNumber);
		this.registeredNumber = registeredNumber;
		this.account = account;
		this.aadharNumber = aadharNumber;
	}
	
	
	
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

//	public String getVendorName() {
//		return vendorName;
//	}

//	public void setVendorName(String vendorName) {
//		this.vendorName = vendorName;
//	}

	public String getRegisteredNumber() {
		return registeredNumber;
	}

	public void setRegisteredNumber(String registeredNumber) {
		this.registeredNumber = registeredNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	

	@Override
	public String toString() {
		super.toString();
		return "Vendor [vendorId=" + vendorId + ", registeredNumber=" + registeredNumber + ", account=" + account.toString()
				+ ", aadharNumber=" + aadharNumber + "]"+" ";
	}

	//Product(double productPrice,String productName, String brand, int quantity, String subtitle, String description, String warranty,
	//Vendor vendor, SubCategory subCategrory, ProductStatus productStatus)
	public boolean addProduct(Product product) {
		String sql = "insert into product values(product_sequence.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
		PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setString(2, product.getBrand());
		statement.setInt(3, product.getQuantity());
		statement.setString(4, product.getSubtitle());
		statement.setString(5, product.getDescription());
		statement.setString(6, product.getWarranty());
		statement.setInt(7, product.getSubCategrory().getSubCategoryId());
		statement.setInt(8, product.getSubCategrory().getCategory().getCategoryId());
		statement.setString(9, product.getProductStatus().toString());
		statement.setInt(10, product.getVendor().getVendorId());
		statement.setDouble(11, product.getProductPrice());
		statement.setString(12, product.getVerificationStatus().toString());
		int rowsAffected = statement.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Product has been added sucessfully");
			return true;
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public <T extends Person>T loginUser(long mobileNumber, String password) {
		Vendor vendor = new Vendor();
		String sql = "select * from vendor where mobile_no=? and password=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setLong(1, mobileNumber);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				if(rs.getString("account_status").equals(AccountStatus.BLOCKED.toString())) {
					System.out.println("!".repeat(200));
					System.out.println("Your account has been blocked by Admin");
					System.out.println("!".repeat(200));
					UngalKadaiTester.startMenu();
				}else if(rs.getString("account_status").equals(AccountStatus.NOT_VERIFIED.toString())){
					System.out.println("+-------------------------------------------------------------------------------------------------+");
					System.out.println("| Your account is not verified by admin.You can only login after the verification is completed.   |");
					System.out.println("+-------------------------------------------------------------------------------------------------+");
					SellerActivity.doSellerAuthentication();
				}else {
				System.out.println(" ".repeat(75)+"+--------------------------------------------------------------+");
				System.out.println(" ".repeat(75)+"|          Welcome Vendor "+rs.getString("username")+" to  Ecommerce Store           |");
				System.out.println(" ".repeat(75)+"+--------------------------------------------------------------+");
//				System.out.println("#".repeat(200));
				vendor.setVendorId(rs.getInt("v_id"));
				vendor.setRegisteredNumber(rs.getString("reg_no"));
				vendor.setMobileNumber(rs.getLong("mobile_no"));
				vendor.setAadharNumber(rs.getLong("aadhar_no"));
				vendor.setEmail(rs.getString("email"));
				vendor.setAddress(rs.getString("address"));
				vendor.setAccount(new Account(rs.getString("username"),password));
				return (T) vendor;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}

	@Override
	public <T extends Person> boolean registerUser(T user) {
			// TODO Auto-generated method stub
			Vendor vendor = (Vendor) user;
			
//			System.out.println(vendor.getAccount().getUserName());
//			System.out.println(vendor.getAccount().getPassword());
//			System.out.println(vendor.getRegisteredNumber());
//			System.out.println(vendor.getAddress());
//			System.out.println(vendor.getMobileNumber());
//			
//			System.out.println(vendor.getEmail());
//			System.out.println(vendor.getAccount().getAccountType().toString());
//			System.out.println(vendor.getAccount().getAccountStatus().toString());
			
			String sql = "insert into vendor values(vendor_sequence.nextval,?,?,?,?,?,?,?,?,?)";
	      try{
	          PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
	          //statement.setInt(1,vendor.getVendorId());
	          statement.setString(1,vendor.getAccount().getUserName());
	          statement.setString(2,vendor.getRegisteredNumber());
	          statement.setString(3, vendor.getAddress());
	          statement.setLong(4,vendor.getMobileNumber());
	          statement.setString(5,vendor.getAccount().getPassword());
	          statement.setLong(6,vendor.getAadharNumber());
	          statement.setString(7,vendor.getEmail());
	          statement.setString(8, vendor.getAccount().getAccountType().toString());
	          statement.setString(9, vendor.getAccount().getAccountStatus().toString());
	          int rowsAffected = statement.executeUpdate();
	          if(rowsAffected>=1) {
	        	  System.out.println("Registered as Vendor Successfully!!");
	        	  System.out.println("Welcome "+vendor.getAccount().getUserName()+" to my ecommerce platform");
	        	  return true;
	          }
	      }catch (Exception e){
	          System.out.println(e.getMessage());
	      }
	      return false;
			
		}
		
	public void updateProductQuantity(Product product,int quantity) {
		String sql = "update product set p_quantity=p_quantity+? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, quantity);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Quantity has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductPrice(Product product,double price) {
		String sql = "update product set p_price=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setDouble(1, price);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Price has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductBrand(Product product,String brand) {
		String sql = "update product set p_brand=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, brand);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Brand has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductName(Product product,String productName) {
		String sql = "update product set p_name=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, productName);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Name has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductSubtitle(Product product,String subTitle) {
		String sql = "update product set p_subtitle=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, subTitle);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Subtitle has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductDescription(Product product,String description) {
		String sql = "update product set p_description=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, description);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Description has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void makeShipment(Order order) {
		String sql = "update orders set order_status='SHIPPED' where order_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1,order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("The order has been shipped sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void confirmOrder(Order order) {
		String sql = "update orders set order_status='CONFIRMED' where order_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1,order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("The order has been Confirmed sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayProduct(Product product,int serialNumber) {
		System.out.printf("| %-3d | %-12s | %-36s | %-10s | %-8.2f | %-83s | %-10s | %-9d |%n",
                serialNumber, product.getProductName(), product.getSubtitle(), product.getBrand(),
                product.getProductPrice(), product.getDescription(), product.getWarranty(),
                product.getQuantity());
		 System.out.println("+----+--------------+-------------------------------------+------------+----------+-----------------------------------------------------------+------------+------------+--------------+-------------+");
		//System.out.println("+-----+--------------+-------------------------------------+------------+----------+-----------------------------------------------------------+------------+----------+");
	}
	
	public void displayVendorHeader() {
		 System.out.println("+----------------+------------+-----------------+-----------------+-----------------+--------------------------------+------------------------------------------------------+-----------------+-----------------+-----------------+");
		 System.out.printf("| %-14s | %-10s | %-15s | %-15s | %-15s | %-30s | %-52s | %-15s | %-15s | %-15s |\n", 
		            "Vendor Number","Vendor ID", "Reg Number", "Mobile Number", "Aadhar Number", "Email", "Address", "Username", "Password", "Account Status");

		  // Print table header separator using + characters
		 System.out.println("+----------------+------------+-----------------+-----------------+-----------------+--------------------------------+------------------------------------------------------+-----------------+-----------------+-----------------+");
	}
	
	public void displayVendorDetail(int serialNumber) {
		System.out.printf("| %-14d | %-10d | %-15s | %-15d | %-15d | %-30s | %-52s | %-15s | %-15s | %-15s |\n", 
                serialNumber,this.getVendorId(), this.getRegisteredNumber(), this.getMobileNumber(), this.getAadharNumber(), 
                this.getEmail(), this.getAddress(), this.getAccount().getUserName(), this.getAccount().getPassword(), 
                this.getAccount().getAccountStatus());
		System.out.println("+----------------+------------+-----------------+-----------------+-----------------+--------------------------------+------------------------------------------------------+-----------------+-----------------+-----------------+");
	}
	
	
		
	
	
}
