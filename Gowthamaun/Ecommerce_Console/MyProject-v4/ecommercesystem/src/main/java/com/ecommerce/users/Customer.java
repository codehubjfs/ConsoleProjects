package com.ecommerce.users;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecommerce.menu.CartAndOrderManager;
import com.ecommerce.users.account.Account;
import com.ecommerce.users.account.AccountStatus;
import com.ecommerce.users.authentication.Authentication;
import com.ungalkadai.components.Cart;
import com.ungalkadai.components.Order;
import com.ungalkadai.components.Orders;
import com.ungalkadai.components.Product;
import com.ungalkadai.tester.UngalKadaiTester;

public class Customer extends Person implements Authentication{
	private int customerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Cart myCart;
    private Orders myOrders;
    private Account account;
    //private CustomerType customerType;

    public Customer() {
    	super();
    }
    
    public Customer(String firstName, int customerId,String address,String email,long mobileNumber,Account account) {
        super(address,email,mobileNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        //this.age = age;
        //this.customerName = customerName;
        this.customerId = customerId;
        this.myCart = new Cart();
        this.myOrders = new Orders();
        this.account = account;
       // this.gender = gender;
        //this.customerType = customerType;
    }

    public Customer(String firstName, String lastName,Gender gender, int customerId,String address,String email,long mobileNumber,Account account) {
        super(address,email,mobileNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        //this.age = age;
        //this.customerName = customerName;
        this.customerId = customerId;
        this.account = account;
        this.gender = gender;
        //this.customerType = customerType;
    }
    
    public Customer(String firstName, String lastName,Gender gender,String address,String email,long mobileNumber,Account account) {
        super(address,email,mobileNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        //this.age = age;
        //this.customerName = customerName;
        this.account = account;
        this.gender = gender;
        //this.customerType = customerType;
    }


    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public byte getAge() {
//        return age;
//    }

//    public String getCustomerName() {
//        return customerName;
//    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setCart(Cart myCart) {
    	this.myCart = myCart;
    }
    
    public Cart getCart() {
    	return myCart;
    }
    
    public void setOrders(Orders myOrders) {
    	this.myOrders = myOrders;
    }
    
    public Orders getOrders() {
    	return myOrders;
    }

//    public void setAge(byte age) {
//        this.age = age;
//    }

//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    @Override
    public String toString() {
    	return "First Name : "+firstName+"\nLast Name : "+lastName+"\n"+super.toString();
    }

	@Override
	public <T extends Person> T loginUser(long mobileNumber, String password){
		Customer customer = new Customer();
		try {
			String sql = "select ca.cart_id,c.first_name,c.last_name,c.address,c.email_id,c.mobile_no,c.username,c.password,c.account_status,c.c_id from customer c,cart ca "
					+ "where c.c_id=c.c_id and ca.c_id=c.c_id and mobile_no=? and password=?";
			PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(sql);
			stmt.setLong(1, mobileNumber);
			stmt.setString(2, password);
			ResultSet resulSet = stmt.executeQuery();
			if(resulSet.next()) {
				if(resulSet.getString("account_status").equals(AccountStatus.BLOCKED.toString())) {
					System.out.println("!".repeat(200));
					System.out.println("Your account has been blocked by Admin");
					System.out.println("!".repeat(200));
					UngalKadaiTester.startMenu();
				}else {
					System.out.println("#".repeat(250));
					System.out.println(" ".repeat(80)+"Welcome Customer "+resulSet.getString("first_name")+" to my Ecommerce Store");
					System.out.println("#".repeat(250));
					customer.setAccount(new Account(resulSet.getString("username"),resulSet.getString("password")));
					customer.setCart(new Cart(resulSet.getInt("cart_id")));
					customer.setFirstName(resulSet.getString("first_name"));
					customer.setLastName(resulSet.getString("last_name"));
					customer.setAddress(resulSet.getString("address"));
					customer.setEmail(resulSet.getString("email_id"));
					customer.setMobileNumber(resulSet.getLong("mobile_no"));
					customer.setCustomerId(resulSet.getInt("c_id"));
					return (T) customer;
				}
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	

	@Override
	public <T extends Person> boolean registerUser(T user) {
		
		Customer customer = (Customer) user;
		
		String sql = "insert into customer values(customer_sequence.nextval,?,?,?,?,?,?,?,?,?,?)";
      try{
    	  //System.out.println("I am inside try");
          PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
          //statement.setInt(1,customer.getCustomerId());
          statement.setString(1,customer.getAccount().getUserName());
          statement.setString(2,customer.getAccount().getPassword());
          statement.setString(3, customer.getFirstName());
          statement.setString(4,customer.getLastName());
          statement.setString(5,customer.getAddress());
          statement.setString(6,customer.getGender().toString());
          statement.setLong(7,customer.getMobileNumber());
          statement.setString(8,customer.getEmail());
          statement.setString(9,customer.getAccount().getAccountType().toString());
          statement.setString(10,customer.getAccount().getAccountStatus().toString());
          int rowsAffected = statement.executeUpdate();
          //System.out.println("After the executeUpdate query");
          if(rowsAffected>=1) {
        	  System.out.println("Registered as Customer Successfully!!");
        	  System.out.println("Welcome "+customer.getFirstName()+ " to my ecommerce platform");
        	  return true;
          }else {
        	  System.out.println("There is some error occured");
          }
      }catch (Exception e){
    	  if(e.getMessage().contains("unique constraint")) {
    		  System.out.println("Provided email/Mobile Number is already exist");
    	  }else {
          System.out.println(e.getMessage());
    	  }
      }
      return false;
		
	}
	
	public boolean addProductToCart(Product p) {
		String sql = "insert into cart_detail values(?,?,?)";
		try {
		PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
		statement.setInt(1, this.getCart().getCart_id());
		statement.setInt(2, p.getProductId());
		statement.setInt(3,p.getQuantity());
		int rowsAffected = statement.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Item has been inserted into cart sucessfully");
			return true;
			//CartAndOrderManager.updateCartTable(p);
		}else {
			System.out.println("Some error occured");
		}
		}catch(SQLException e) {
			if(e.getMessage().contains("unique constraint")) {
				if(this.updateQuantity(p)) {
					System.out.println("Item has been inserted into cart sucessfully");
					return true;
				}
			}
			System.out.println(e.getMessage());
		}
		return false;
		
	}
	
	private boolean updateQuantity(Product p) {
		String sql = "update cart_detail set quantity = quantity+? where cart_id=? and p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, p.getQuantity());
			statement.setInt(2, this.getCart().getCart_id());
			statement.setInt(3, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean makeOrder(Order order) {
		String sql = "insert into orders values(?,?,?,?,?)";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getCustomer().getCustomerId());
			statement.setDate(3,Date.valueOf(order.getOrderDate()));
			statement.setString(4, order.getAddress());
			statement.setString(5, order.getOrderStatus());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0)
			{
				
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	
	public void updatePassoword(String password) {
		String sql = "update customer set password=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, password);
			statement.setInt(2, this.customerId);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your password has been changed sucessfully");
				this.account.setPassword(password);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateFirstName(String firstName) {
		String sql = "update customer set first_name=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setInt(2, this.customerId);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your First Name has been changed sucessfully");
				this.setFirstName(firstName);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateLastName(String lastName) {
		String sql = "update customer set last_name=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, lastName);
			statement.setInt(2, this.customerId);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Last Name has been changed sucessfully");
				this.setLastName(lastName);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateAddress(String address) {
		String sql = "update customer set address=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, address);
			statement.setInt(2, this.customerId);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Address has been changed sucessfully");
				this.setAddress(address);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateMobileNumber(long mobileNumber) {
		String sql = "update customer set mobile_no=? where c_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setLong(1, mobileNumber);
			statement.setInt(2, this.customerId);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Your Mobile Number has been changed sucessfully");
				this.setMobileNumber(mobileNumber);
			}
		}catch(SQLException e) {
			if(e.getMessage().contains("unique constraint"))
				System.out.println("Sorry!! Mobile Number already exist");
			else
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void updateEmail(String email) {
			String sql = "update customer set email_id=? where c_id=?";
			try {
				PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
				statement.setString(1, email);
				statement.setInt(2, this.customerId);
				int rowsAffected = statement.executeUpdate();
				if(rowsAffected>0) {
					System.out.println("Your Email Id has been changed sucessfully");
					this.setEmail(email);
				}
			}catch(SQLException e) {
				if(e.getMessage().contains("unique constraint"))
					System.out.println("Sorry!!Entered Email Id already exist");
				else
				System.out.println(e.getMessage());
			}
		
	}
}
