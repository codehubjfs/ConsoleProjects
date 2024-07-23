package com.ecommerce.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecommerce.customizedexceptions.InvalidCreditCardNumberException;
import com.ecommerce.customizedexceptions.InvalidCvvException;
import com.ecommerce.customizedexceptions.InvalidStringException;
import com.ecommerce.customizedexceptions.Validation;
import com.ecommerce.users.Customer;
import com.ecommerce.users.DbConnection;
import com.ecommerce.users.DbmsConnection;
import com.ungalkadai.components.Card;
import com.ungalkadai.components.Cart;
import com.ungalkadai.components.Order;
import com.ungalkadai.components.Orders;
import com.ungalkadai.components.PaymentStatus;
import com.ungalkadai.components.Product;

public class CartAndOrderManager {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void updateProductTable(Product p) {
		String sql = "update product set p_quantity=p_quantity-? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, p.getQuantity());
			statement.setInt(2, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				//System.out.println("Cart table updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int getSequenceNumber() {
		String sql= "select order_sequence.nextval from dual";
		try {
		Statement statement = DbConnection.getInstance().getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			int id = rs.getInt("nextval");
			return id;
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public static void makeOrder(Order order,Product p) {
		String sql = "insert into order_product values(?,?,?)";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1,order.getOrderId());
			statement.setInt(2, p.getProductId());
			statement.setInt(3, p.getQuantity());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
//				Card card = new Card();
//				card.setOrder(order);
//				card.setAmount(p.getProductPrice()*p.getQuantity());
//				makePayments(card);
				System.out.println("Order has been placed sucessfully");
			}else {
				System.out.println("Error occured!!");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Product> getCustomerCart(Customer customer) {
		//String sql = "
		List<Product> myProducts = new ArrayList<>();
		//int i =1;
		String sql = "select p.warranty,p.p_brand,p.p_description,p.p_id,p.p_name,p.p_subtitle,p.p_price,cd.quantity \r\n"
				+ "from product p,cart_detail cd,cart ca,customer c\r\n"
				+ "where c.c_id=ca.c_id and c.c_id=? and cd.cart_id=ca.cart_id and cd.p_id=p.p_id";
		try {
		PreparedStatement st = DbConnection.getInstance().getConnection().prepareStatement(sql);
		st.setInt(1, customer.getCustomerId());
		ResultSet rs = st.executeQuery();
		//Product(String productName, int productId, double productPrice, String brand, int quantity, String subtitle
		//,String description,String warranty)
		while(rs.next()) {
			myProducts.add( new Product(
					rs.getString("p_name"),
					rs.getInt("p_id"),
					rs.getDouble("p_price"),
					rs.getString("p_brand"),
					rs.getInt("quantity"),
					rs.getString("p_subtitle"),
					rs.getString("p_description"),
					rs.getString("warranty")
					));
			//i++;
		}
		//Map<Integer, Product> myProducts2 = myProducts;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return myProducts;
	}
	
	public static boolean makePayments(Card card) {
		boolean flag = true;
		//int choice = 0,confirmation = 0;
		String cardNumber = "";
		String cardHolderName ="";
		int cvv = 0;
		try {
		do {
		System.out.println("Enter your credit card number in(XXXX XXXX XXXX XXXX (OR) XXXXXXXXXXXXXXXX)");
		try {
		cardNumber = reader.readLine();
		cardNumber = Validation.isCreditCardNumberValid(cardNumber);
		}catch(InvalidCreditCardNumberException e) {
			System.out.println(e.getMessage());
			continue;
		}
		flag = false;
		}while(flag);
		flag = true;
		do {
			System.out.println("Enter the credit card holder name");
			try {
			cardHolderName = reader.readLine();
			cardHolderName = Validation.isFirstNameValid(cardHolderName);
			}catch(InvalidStringException e) {
				System.out.println(e.getMessage());
				continue;
			}
			
			flag = false;
		}while(flag);
		flag = true;
		do {
			System.out.println("Enter the cvv of the credit card");
			try {
				cvv = Integer.parseInt(reader.readLine().trim());
				cvv = Validation.isCvvValid(cvv);
			}catch( InvalidCvvException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(NumberFormatException e) {
				System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
				continue;
			}
			flag = false;
		}while(flag);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		card.setCardHolderName(cardHolderName);
		card.setCardNumber(cardNumber);
		card.setCvv(cvv);
		//System.out.println("")
		return card.makePayment(card);
		
	}
	
	public  Orders getCustomerOrders(Customer customer) {
		List<Order> myOrders = new ArrayList<>();
		
		String sql = "select p.p_name,p.p_id,pa.amount,p.p_brand,p.warranty,o.order_status,o.order_id,o.order_date,o.address,op.quantity from product p,customer c,orders o,order_product op,payment pa where o.c_id=c.c_id and c.c_id=? and op.order_id=o.order_id and op.p_id=p.p_id and pa.order_id=o.order_id";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, customer.getCustomerId());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				Product p = new Product();
				order.setOrderId(resultSet.getInt("order_id"));
				order.setOrderStatus(resultSet.getString("order_status"));
				order.setAddress(resultSet.getString("address"));
				order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
				order.setAmount(resultSet.getLong("amount"));
				p.setProductId(resultSet.getInt("p_id"));
				p.setProductName(resultSet.getString("p_name"));
				p.setBrand(resultSet.getString("p_brand"));
				p.setWarranty(resultSet.getString("warranty"));
				p.setQuantity(resultSet.getInt("quantity"));
				order.setProduct(p);
				myOrders.add(order);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return new Orders(customer.getCustomerId(),myOrders);
	}
	
	public boolean deleteProduct(Product p,Customer customer) {
//		System.out.println("p.id : "+p.getProductId());
//		System.out.println("name : "+p.getProductName());
//		System.out.println("Crt id : "+customer.getCart().getCart_id());
//		System.out.println("Customer id : "+customer.getCustomerId());
		String sql = "delete from cart_detail where cart_id=? and p_id=?";
		try {
			PreparedStatement  statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, customer.getCart().getCart_id());
			statement.setInt(2, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Product has been removed from cart sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean deleteCartQuantity(Product p,Customer customer,int quantity) {
//		System.out.println("p.id : "+p.getProductId());
//		System.out.println("Cart id : "+customer.getCart().getCart_id());
//		System.out.println("name : "+p.getProductName());
		String sql = "update cart_detail set quantity=quantity-? where cart_id=? and p_id=?";
		try {
			PreparedStatement  statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, quantity);
			statement.setInt(2, customer.getCart().getCart_id());
			statement.setInt(3, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Product Quantity has been updated in the cart");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public  boolean checkOutAllProduct(Customer customer,String address) {
		//boolean flag = true;
		//boolean flag = true;
		//int choice = 0,confirmation = 0;
		String cardNumber = "";
		String cardHolderName ="";
		int cvv = 0;
		try {
		do {
		System.out.println("Enter your credit card number in(XXXX XXXX XXXX XXXX (OR) XXXXXXXXXXXXXXXX)");
		try {
		cardNumber = reader.readLine();
		cardNumber = Validation.isCreditCardNumberValid(cardNumber);
		}catch(InvalidCreditCardNumberException e) {
			System.out.println(e.getMessage());
			continue;
		}
		break;
		}while(true);
		do {
			System.out.println("Enter the credit card holder name");
			try {
			cardHolderName = Validation.isFirstNameValid(reader.readLine());
			}catch(InvalidStringException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}while(true);
		do {
			System.out.println("Enter the cvv of the credit card");
			try {
				cvv = Integer.parseInt(reader.readLine().trim());
				cvv = Validation.isCvvValid(cvv);
			}catch( InvalidCvvException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(NumberFormatException e) {
				System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
				continue;
			}
			break;
		}while(true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		List<Product> mycart = customer.getCart().getMyCart();
		Card card = new Card();
		card.setCardNumber(cardNumber);
		card.setCardHolderName(cardHolderName);
		card.setCvv(cvv);
		for(Product p:mycart) {
			int orderId = CartAndOrderManager.getSequenceNumber();
			Order order = new Order();
        	order.setCustomer(customer);
        	order.setOrderDate(LocalDate.now());
        	order.setOrderId(orderId);
        	order.setAddress(address);
        	order.setOrderStatus("PLACED");
        	//boolean status = customer.makeOrder(order);
        	//if(status) {
        		
        		
        		card.setOrder(order);
        		card.setAmount(p.getProductPrice()*p.getQuantity());
        		card.setPaymentStatus(PaymentStatus.COMPLETED);
        		card.setPaymentType("CREDIT CARD");
        		//System.out.println("Total amount to be paid : "+(p.getProductPrice()*choosen.getQuantity()));
        		customer.makeOrder(order);
        		if(card.makePayment(card)) {
        		//customer.makeOrder(order);
        		CartAndOrderManager.updateProductTable(p);
        		CartAndOrderManager.makeOrder(order, p);
        		//System.out.println("Total rs : "+choosen.getProductPrice()*choosen.getQuantity());
        		//showFunctionalMenu(customer,filtered);
        		}
		}
		return clearMyCart(customer);
	}
	
	private boolean clearMyCart(Customer customer) {
		String sql = "delete from cart_detail where cart_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, customer.getCart().getCart_id());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Cart has been updated sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
