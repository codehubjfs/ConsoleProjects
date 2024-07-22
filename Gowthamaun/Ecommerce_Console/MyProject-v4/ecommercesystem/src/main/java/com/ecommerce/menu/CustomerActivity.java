package com.ecommerce.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.ecommerce.customizedexceptions.InvalidEmailException;
import com.ecommerce.customizedexceptions.InvalidLengthException;
import com.ecommerce.customizedexceptions.InvalidMenuChoiceException;
import com.ecommerce.customizedexceptions.InvalidMobileNumberException;
import com.ecommerce.customizedexceptions.InvalidPasswordException;
import com.ecommerce.customizedexceptions.InvalidStringException;
import com.ecommerce.customizedexceptions.InvalidUserNameException;
import com.ecommerce.customizedexceptions.Validation;
import com.ecommerce.users.Customer;
import com.ecommerce.users.DbConnection;
import com.ecommerce.users.DbmsConnection;
import com.ecommerce.users.Gender;
import com.ecommerce.users.account.Account;
import com.ecommerce.users.account.AccountStatus;
import com.ecommerce.users.account.AccountType;
import com.ungalkadai.components.Cart;
import com.ungalkadai.components.Order;
import com.ungalkadai.components.Orders;
import com.ungalkadai.components.Product;
import com.ungalkadai.tester.UngalKadaiTester;


public class CustomerActivity {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static final String ANSI_RED = "\u001B[31m";
    // ANSI escape code to reset color
    public static final String ANSI_RESET = "\u001B[0m";
	
	static StringBuilder exitBox = new StringBuilder();
	static {
        exitBox.append("+----------------------------------+\n");
        exitBox.append("|      Are you sure to Exit?       |\n");
        exitBox.append("|         (1-yes | 0-no)           |\n");
        exitBox.append("+----------------------------------+\n");
	}
	
	public static void showCustomerMenu(Customer customer) {
		//System.out.println(customer.getCart().getCart_id());
		Cart customerCart = new Cart(customer.getCart().getCart_id(),new CartAndOrderManager().getCustomerCart(customer));
		customer.setCart(customerCart);
//		List<Product> mycart = customer.getCart().getMyCart();
		List<Product> cart = customer.getCart().getMyCart();
		Map<Integer, Product> mycart = IntStream.range(0, cart.size())
                .boxed()
                .collect(Collectors.toMap(
                    i -> i + 1, // Serial numbers starting from 1
                    i -> cart.get(i)
                ));
		int choice = 0,confirmation = 0;
		do {
		System.out.println("+----------------------------------+");
        System.out.println("|          CUSTOMER MENU           |");
        System.out.println("+----------------------------------+");
        System.out.println("| 1. Search                        |");
        System.out.println("| 2. Cart                          |");
        System.out.println("| 3. Profile                       |");
        System.out.println("| 4. Orders                        |");
        System.out.println("| 5. Previous Menu                 |");
        System.out.println("| 6. Exit                          |");
        System.out.println("+----------------------------------+");
		System.out.println("Enter your choice");
		try {
			choice = Integer.parseInt(reader.readLine().trim());
			choice = Validation.isOptionValid(1, 6, choice);
		} catch (NumberFormatException e) {
			System.out.println("Input should be a number.The letter or symbols are not allowed");
			continue;
		} catch (InvalidMenuChoiceException  | IOException e) {
			System.out.println(e.getMessage());
			continue;
		}
		switch(choice) {
			case 1:{
				System.out.println("You have chosen to search");
				showSearchMenu(customer);
				break;
			}
			case 2:{
				System.out.println("You are heading to cart");
				if(mycart.isEmpty()) {
					System.out.println("Your cart is empty!!!!!!!!");
					showCustomerMenu(customer);
				}
//		        System.out.printf("| %-2d | %-12s | %-35s | %-10s | %-8d | %-57s | %-10s | %-8d |%n"
			       // mycart.forEach((p)->Product.display(p, (mycart.indexOf(p)+1)));
				//mycart.forEach((p)->System.out.println("S.no : "+((mycart.indexOf(p))+1)+" "+p+"| Quantity : "+p.getQuantity()+" |"+"\n"+"-".repeat(200)));
				showCartMenu(customer);
				break;
			}
			case 3:{
				System.out.println("You are heading to profile menu");
				showProfileMenu(customer);
				//System.out.println("Page under developement........we will get back to you soon");
				break;
			}
			case 4:{
				System.out.println("Your orders are : ");
				showCustomerOrders(customer);
				break;
			}
			case 5:{
				System.out.println("You are heading to previous menu");
				doAuthentication();
				break;
			}
			case 6:{
				do {
					System.out.println("You have choosen to exit!!!");
					System.out.println(exitBox);
					System.out.println("Enter your choice");
					try {
						confirmation = Integer.parseInt(reader.readLine().trim());
						confirmation = Validation.isOptionValid(0, 1, confirmation);
					}catch(NumberFormatException e) {
						System.out.println("Input should be a number.The letter or symbols are not allowed");
						continue;
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
					if(confirmation==1) {
						DbConnection.closeConnection();
						System.out.println("Thanks for visiting "+customer.getFirstName()+" Have a Nice day :)");
						System.exit(0);
					}else if(confirmation==0) {
						break;
					}
					
			}while(true);
			break;
			}
				
		}
		
		}while(true);
	}
	
	public static void showSearchMenu(Customer customer) {
		int choice = 0;
		int confirmation = 0;
		String productName = "";
		do {
		System.out.println("+----------------------------------+");
        System.out.println("|           SEARCH MENU            |");
        System.out.println("+----------------------------------+");
        System.out.println("| 1. Search by category            |");
        System.out.println("| 2. Search by subcategory         |");
        System.out.println("| 3. Search by productName         |");
        System.out.println("| 4. Go Back                       |");
        System.out.println("| 5. Exit                          |");
        System.out.println("+----------------------------------+");
        System.out.println("Enter your choice");
        try {
        	choice = Integer.parseInt(reader.readLine().trim());
        	choice = Validation.isOptionValid(1, 5, choice);
        }catch (NumberFormatException e) {
			System.out.println("Input should be a number.The letter or symbols are not allowed.");
			continue;
		} catch (InvalidMenuChoiceException  | IOException e) {
			System.out.println(e.getMessage());
			continue;
		}
        switch(choice) {
        case 1:{
        	SearchAndSortManager.searchByCategory(customer);
        	break;
        }
        case 2:{
        	SearchAndSortManager.searchBySubCategory(customer);
        	break;
        }
        case 3:{
        	System.out.println("You have chosen to search the product by product name");
        	do {
        		System.out.println("Enter the product Name you need to search");
        		try {
        			productName = Validation.isFirstNameValid(reader.readLine());
        		}catch(InvalidStringException | IOException e) {
        			System.out.println(e.getMessage());
        			continue;
        		}
        		break;
        	}while(true);
        	SearchAndSortManager.searchByProductName(customer, productName);
			break;
        }
        case 4:{
        	System.out.println("You are heading to previous page.");
        	showCustomerMenu(customer);
        	break;
        }
        case 5:{
//        	boolean flag = true;
			do {
				System.out.println("You have choosen to exit!!!");
				System.out.println(exitBox);
				System.out.println("Enter your choice");
				try {
					confirmation = Integer.parseInt(reader.readLine().trim());
					confirmation = Validation.isOptionValid(0, 1, confirmation);
				}catch(NumberFormatException e) {
					System.out.println("Input should be a number.The letter or symbols are not allowed.");
					continue;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				if(confirmation==1) {
					System.out.println("Thanks for visiting "+customer.getFirstName()+" Have a Nice day :)");
					DbConnection.closeConnection();
					System.exit(0);
				}else if(confirmation==0) {
					break;
				}
			}while(true);
			break;
        }
        }
		}while(true);
	}
	
	public static void showCartMenu(Customer customer) {
		int choice = 0,confirmation = 0,quantity = 0;
		//boolean flag = true;
//		customer = CartAndOrderManager.getCart(customer);
		List<Product> cart = customer.getCart().getMyCart();
		Map<Integer, Product> mycart = IntStream.range(0, cart.size())
                .boxed()
                .collect(Collectors.toMap(
                    i -> i + 1, // Serial numbers starting from 1
                    i -> cart.get(i)
                ));
		do {
			System.out.println("+--------------------+------------------------------------+--------------------------------------+------------+----------+------------------------------------------------------------------------------------------------------+-----------------+------------+");
	        System.out.printf("| %-18s | %-34s | %-36s | %-10s | %-8s | %-100s | %-15s | %-10s |%n", "Product Number", "Product Name", "Subtitle", "Brand", "Price", "Description", "Warranty", "Quantity");
	        System.out.println("+--------------------+------------------------------------+--------------------------------------+------------+----------+------------------------------------------------------------------------------------------------------+-----------------+------------+");
	        mycart.forEach((k,v)->new Cart().printCartDetails(k, v));
			System.out.println("+--------------------- Cart Menu ---------------------+");
			System.out.println("| 1. Check out all product                            |");
			System.out.println("| 2. Delete a product from cart                       |");
			System.out.println("| 3. Go Back                                          |");
			System.out.println("| 4. Exit                                             |");
			System.out.println("+-----------------------------------------------------+");
			System.out.println("Enter your choice");
		try {
			choice = Integer.parseInt(reader.readLine().trim());
			choice = Validation.isOptionValid(1, 4, choice);
		}catch(IOException |InvalidMenuChoiceException e) {
			System.out.println(e.getMessage());
			continue;
		}catch(NumberFormatException e) {
			System.out.println("Numbers are only allowed.Letter or symbols are not allowed.");
			continue;
		}
		
		switch(choice) {
		case 1:{
			System.out.println("you have choosen to check out all product from cart.");
			Double total = mycart.values().stream().map(p->p.getProductPrice()*p.getQuantity()).reduce(0.0,Double::sum);
			System.out.println("Total is rs."+total);
			String address = "";
			do {
		        	System.out.println("Your address : "+customer.getAddress());
		        	System.out.println("+-----------------------------------+");
		        	System.out.println("| 1. Continue with your address     |");
		        	System.out.println("| 2. New Address                    |");
		        	System.out.println("+-----------------------------------+");
		        	//System.out.println("1.Continue with your address/n2.new Address");
	        	try {
	        		confirmation = Integer.parseInt(reader.readLine().trim());
	        		confirmation = Validation.isOptionValid(1, 2, confirmation);
	        	}catch(InvalidMenuChoiceException | IOException  e) {
	        		System.out.println(e.getMessage());
	        		continue;
	        	}catch(NumberFormatException e) {
	        		System.out.println("Numbers only allowed.Letters or symbols are not allowed");
	        		continue;
	        	}
	        		break;        	
	        	}while(true);
	        	if(confirmation==2) {
	        		System.out.println("Enter your new Shipping address");
	        		do {
		        		try {
							address = Validation.isInputLengthValid(reader.readLine());
						} catch (IOException | InvalidLengthException e) {
							System.out.println(e.getMessage());
							continue;
						}
		        		break;
	        		}while(true);
	        	}else {
	        		address = customer.getAddress();
	        	}
			new CartAndOrderManager().checkOutAllProduct(customer, address);
			CustomerActivity.showCustomerMenu(customer);
			break;
		}
		case 2:{
			//flag = true;
			System.out.println("You have choosen to delete a product from cart.");
			do {
				System.out.println("+--------------------+------------------------------------+--------------------------------------+------------+----------+------------------------------------------------------------------------------------------------------+-----------------+------------+");
		        System.out.printf("| %-18s | %-34s | %-36s | %-10s | %-8s | %-100s | %-15s | %-10s |%n", "Product Number", "Product Name", "Subtitle", "Brand", "Price", "Description", "Warranty", "Quantity");
		        System.out.println("+--------------------+------------------------------------+--------------------------------------+------------+----------+------------------------------------------------------------------------------------------------------+-----------------+------------+");
		        mycart.forEach((k,v)->new Cart().printCartDetails(k, v));
			System.out.println("Enter the s.no of the product which you need to delete from cart");
			try {
				choice = Integer.parseInt(reader.readLine().trim());
				choice = Validation.isOptionValid(1, mycart.size(), choice);
			}catch(IOException | InvalidMenuChoiceException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(NumberFormatException e) {
				System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
				continue;
			}
			break;
			}while(true);
			do {
				System.out.println("Please enter the number of quantity you need to delete");
				try {
					quantity = Integer.parseInt(reader.readLine().trim());
					quantity = Validation.isOptionValid(1, mycart.get(choice).getQuantity(), quantity);
				}catch(IOException | InvalidMenuChoiceException e) {
					System.out.println(e.getMessage());
					continue;
				}catch(NumberFormatException e) {
					System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
					continue;
				}
				break;
			}while(true);
			boolean confirm = false;
			Product p = mycart.get(choice);
			System.out.println(p.getQuantity());
			if(quantity==p.getQuantity()) {
				confirm = new CartAndOrderManager().deleteProduct(p, customer);
				System.out.println(confirm);
				if(confirm) {
					mycart.remove(choice);
				}
			}else {
				confirm = new CartAndOrderManager().deleteCartQuantity(mycart.get(choice), customer, quantity);
				System.out.println(confirm);
				p.setQuantity(p.getQuantity()-quantity);
				if(confirm) {
					mycart.put(choice, p);
				}
			}
			System.out.println(p.getQuantity());
//			boolean confirm = new CartAndOrderManager().deleteProduct(mycart.get(choice-1), customer);
//			if(confirm) {
//				mycart.remove(choice-1);
//			}
			break;
		}
		case 3:{
			System.out.println("You are heading towards the previous menu.");
			showCustomerMenu(customer);
			break;
		}
		case 4:{
			do {
			System.out.println("You have choosen to exit!!!");
			System.out.println(exitBox);
			System.out.println("Enter your choice");
			try {
				confirmation = Integer.parseInt(reader.readLine().trim());
				confirmation = Validation.isOptionValid(0, 1, confirmation);
			}catch(NumberFormatException e) {
				System.out.println("Input should be a number.The letter or symbols are not allowed.");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			if(confirmation==1) {
				System.out.println("Thanks for visiting "+customer.getFirstName()+" Have a Nice day :)");
				DbConnection.closeConnection();
				System.exit(0);
			}else if(confirmation==0) {
				break;
			}
			}while(true);
			break;
		}
		}
		}while(true);
	}
	
//	private static void showProduct() {
//		
//	}
	
//	public static void showUsersCart() {
//		
//	}
	
	public static void doAuthentication() {
		int confirmation = 0;
		int choice = 0;
		//boolean loop = true,flag=true;
		//BufferedReader reader = null;
		try{
			//reader = new BufferedReader(new InputStreamReader(System.in));
		do {
		System.out.println("+--------------------------------+");
        System.out.println("|            MENU                |");
        System.out.println("+--------------------------------+");
        System.out.println("| 1. Login                       |");
        System.out.println("| 2. Registration                |");
        System.out.println("| 3. Go Back                     |");
        System.out.println("| 4. Exit                        |");
        System.out.println("+--------------------------------+");
        System.out.println("Enter your choice");
		try {
			choice = Integer.parseInt(reader.readLine().trim());
			choice = Validation.isOptionValid(1, 4, choice);
		}catch(InvalidMenuChoiceException e) {
			System.out.println(e.getMessage());
			continue;
		}catch(NumberFormatException e) {
			System.out.println("Input should be a number.The letter or symbols are not allowed.");
			continue;
		}
		switch(choice) {
		case 1:{
			loginCustomer();
			break;
		}
		case 2:{
			registerCustomer();
			break;
		}
		case 3:{
			UngalKadaiTester.startMenu();
			break;
			//break;
		}
		case 4:{
			do {
			System.out.println("You have choosen to exit!!!");
			System.out.println(exitBox);
			System.out.println("Enter your choice");
			try {
				confirmation = Integer.parseInt(reader.readLine().trim());
				confirmation = Validation.isOptionValid(0, 1, confirmation);
			}catch(NumberFormatException e) {
				System.out.println("Input should be a number.The letter or symbols are not allowed");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			if(confirmation==1) {
				System.out.println("Thanks for visiting  Have a Nice day :)");
				DbConnection.closeConnection();
				System.exit(0);
			}
			else if(confirmation==0) {
				break;
			}
			}while(true);
			break;
		}
//		default:{
//			System.out.println("You have entered a invalid input");
//			doAuthentication();
//		}
		}
		}while(true);
		}catch(NumberFormatException e) {
			System.out.println("Numbers are only allowed between(1-4)");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void loginCustomer() {
		//BufferedReader reader = null;
		//boolean flag = true;
		long mobileNumber = 0L;
		int retries = 4;
		int choice = 0;
		String password = "";
		int confirmation = 0;
		try{
			//reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("You have choosen to Login as a Customer");
			System.out.println("+---------------------------------------------------+");
			System.out.println("|                    "+ANSI_RED+"Note"+ANSI_RESET+"                           |");
			System.out.println("+---------------------------------------------------+");
			System.out.println("|  !!!!You can have maximum of 3 retries only!!!!   |");
			System.out.println("+---------------------------------------------------+");
			do {	
			
				do {
					System.out.println("Enter your mobileNumber");
					try {
						mobileNumber = Long.parseLong(Validation.isMobileNumberValid(reader.readLine().trim()));
					}catch(InvalidMobileNumberException |NumberFormatException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
			
				do {
					System.out.println("Enter your password");
					try {
						password = reader.readLine();
						password = Validation.isPasswordValid(password);
					}catch(InvalidPasswordException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
				Customer customer = new Customer().loginUser(mobileNumber, password);
				if(customer!=null) {
					//System.out.println(c_id);
					showCustomerMenu(customer);
					
					//return;
				}else {
					System.out.println("provided mobile number and password not matched");
					retries--;
					if(retries==0) {
						System.out.println("!!You cannot retry more than 3 time!!So heading to the previous menu");
						doAuthentication();
					}
					do {
					System.out.println("Would you like to try again(0-yes|1-No)");
					try {
					confirmation = Integer.parseInt(reader.readLine().trim());
					}catch(NumberFormatException e) {
						System.out.println("You can enter only number(0 or 1)");
						continue;
					}
					if(confirmation==1) {
						doAuthentication();
						//return;
					}else if(confirmation<0 || confirmation>1) {
						System.out.println("you have provided a invalid option try again");
						do {
							System.out.println("+--------------------+");
						    System.out.println("| 1. Go back         |");
						    System.out.println("| 2. Exit            |");
						    System.out.println("+--------------------+");
						try {
							choice = Integer.parseInt(reader.readLine().trim());
							choice = Validation.isOptionValid(1, 2, choice);
						}catch(NumberFormatException e) {
							System.out.println("You are allowed to enter only numbers.letters or symbols are not alloweded");
							continue;
						}catch(InvalidMenuChoiceException e) {
							System.out.println(e.getMessage());
							continue;
						}
						if(choice==1) {
							loginCustomer();
						}else if(choice==2) {
							DbConnection.closeConnection();
							System.out.println("Thanks for visiting  Have a Nice day :)");
							System.exit(0);
						}
						break;
						}while(true);
					}
					break;
				}while(true);
					System.out.println("There is still more "+ANSI_RED+retries+ANSI_RESET+" retries");
				}
			}while(confirmation==0 && retries>0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//	private static Customer getData(int c_id) {
//		Customer customer = null;
//		String sql = "select ca.cart_id,c.first_name,c.address,c.email_id,c.mobile_no,c.username,c.password from customer c,cart ca "
//				+ "where c.c_id=? and ca.c_id=?";
//		try {
//		PreparedStatement statement = DbmsConnection.getConnection().prepareStatement(sql);
//		statement.setInt(1,c_id);
//		statement.setInt(2, c_id);
//		ResultSet resultSet = statement.executeQuery();
//		//Customer(String firstName, String lastName, int customerId,String address,String email,long mobileNumber)
//		if(resultSet.next()) {
//			customer = new Customer(
//					resultSet.getString("first_name"),
//					//resultSet.getString("last_name"),
//					c_id,
//					resultSet.getString("address"),
//					resultSet.getString("email_id"),
//					resultSet.getLong("mobile_no"),
//					new Account(resultSet.getString("username"),resultSet.getString("password"))
//					);
//			customer.setCart(new Cart(resultSet.getInt("cart_id")));
//		}
//		}catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("Cart id : "+customer.getCart().getCart_id()+" "+customer.getCustomerId());
//		return customer;
//	}
	
//	private static Customer getMyCart(Customer customer) {
//		
//		return customer;
//	}
	
	public static void registerCustomer() {
		//BufferedReader reader = null;
		//boolean flag = true;
		String password = "";
		int choice = 0;
		String userName = "";
		String firstName = "",lastName = "";
		String address = "";
		Gender gender = null;
		Long mobileNumber = 0L;
		String emailId = "";
		//boolean loop=true;
		AccountType accountType;
		AccountStatus accountStatus = AccountStatus.ACTIVE;  
		System.out.println("You have choosen to register as a Customer");
		do {
			
			try{
				//reader = new BufferedReader(new InputStreamReader(System.in));
//				System.out.println("Enter your id");
//				id = Integer.parseInt(reader.readLine());
				do {
					System.out.println("Enter your username");
					try {
					userName = Validation.isUserNameValid(reader.readLine());
					}catch(InvalidUserNameException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
				System.out.println("+---------------------------------------------------------------------+");
				System.out.println("|                         Password Constraints                        |");
				System.out.println("+---------------------------------------------------------------------+");
				System.out.println("|    ->password should containt atleast one small or capital letter.  |\n"
								 + "|    ->password should contain atleast one number.                    |\n"
								 + "|    ->password should contain atleast one special symbol[!@$%#?&].   |\n"
								 + "|    ->password length should be minimum of 8 and max of 20.          |");
				System.out.println("+---------------------------------------------------------------------+");
				do {
//					System.out.println("->password should containt atleast one small or capital letter.\n"
//							+ "->password should contain atleast one number.\n"
//							+ "->password should contain atleast one special symbol.\n"
//							+ "->password length should be minimum of 8.");
					System.out.println("Enter your password");
					try {
						password = reader.readLine().trim();
						password = Validation.isPasswordValid(password);
					}catch(InvalidPasswordException e) {
						System.out.println("Invalid Input Password the unmatched Constraints are : ");
						if(!password.matches("^.*[a-zA-Z].*$")) {
							System.out.println(ANSI_RED+"-> password should containt atleast one small or capital letter."+ANSI_RESET);
						}
						if(!password.matches("^.*[0-9].*$")) {
							System.out.println(ANSI_RED+"-> password should contain atleast one number."+ANSI_RESET);
						}
						if(!password.matches(".*[!@$%#?&].*")) {
							System.out.println(ANSI_RED+"-> password should contain atleast one special symbol [!@$%#?&]."+ANSI_RESET);
						}
						if(!password.matches("[A-Za-z\\d@$!%*#?&]{1,20}")) {
							System.out.println(ANSI_RED+"-> password should not contain other symbols except[@$!%*#?&]."+ANSI_RESET);
						}
						if(password.length()<8 || password.length()>20) {
							System.out.println(ANSI_RED+"-> password length should not be less than 8 or greater than 20"+ANSI_RESET);
						}
						continue;
					}
					break;
				}while(true);
				do {
					System.out.println("Enter your firstName");
					try {
					firstName = reader.readLine();
					firstName = Validation.isFirstNameValid(firstName);
					}catch(InvalidStringException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
				do {
					System.out.println("Enter your lastName");
					try {
						lastName = reader.readLine();
						lastName = Validation.isLastNameValid(lastName);
					}catch(InvalidStringException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
//				System.out.println("Enter your lastName");
//				lastName = reader.readLine();
				do {
					System.out.println("Enter your address");
					try {
						address = Validation.isInputLengthValid(reader.readLine());
					}catch(InvalidLengthException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
				System.out.println("Choose the gender");
				do {
				System.out.println("1.Male\t\t2.Female\t\t3.Transgender");
				try {
				choice = Integer.parseInt(reader.readLine());
				choice = Validation.isOptionValid(1, 3, choice);
				}catch(NumberFormatException  e) {
					System.out.println("You should enter only the numbers between(1-3)");
					continue;
				}catch(InvalidMenuChoiceException e) {
					System.out.println(e.getMessage());
					continue;
				}
				switch(choice) {
					case 1:{
						gender = Gender.MALE;
						break;
					}
					case 2:{
						gender = Gender.FEMALE;
						break;
					}
					case 3:{
						gender = Gender.TRANSGENDER;
						break;
					}
				}
				break;
				}while(true);				
				do {
					System.out.println("Enter your mobileNumber");
					try {
						mobileNumber = Long.parseLong(Validation.isMobileNumberValid(reader.readLine().trim()));
					}catch(InvalidMobileNumberException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;//Once the mobile Number is a valid one then the loop breaks here.//
				}while(true);
				do {
					System.out.println("Enter your emailId");
					try {
						emailId = reader.readLine();
						emailId  = Validation.isEmailIdValid(emailId.trim());
					}catch(InvalidEmailException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}while(true);
				accountType = AccountType.CUSTOMER;
				Customer customer = new Customer();
				//Customer(String firstName, String lastName, String customerName,Gender gender, int customerId,Address address,String email,String mobileNumber,Account account)
				boolean status = customer.registerUser(new Customer(firstName,lastName,gender,address,emailId,mobileNumber,new Account(userName,password,accountType,accountStatus)));
				if(status) {
					registerCart(mobileNumber);
					while(true) {
						System.out.println("Would you like to continue (1-yes|0-no)");
						try {
						choice = Integer.parseInt(reader.readLine());
						}catch(NumberFormatException e) {
							System.out.println("You are allowed to enter only numbers.No letters or special characters are allowed");
							continue;
						}
						if(choice==1) {
							loginCustomer();
							//return;
						}
						else if(choice<0 || choice>1) {
							System.out.println("You have chosen a invalid option");
						}else
							doAuthentication();
					}
					
				}else {
					System.out.println("Would you like to try again (1-yes|0-no)");
					choice = Integer.parseInt(reader.readLine());
					if(choice>1 || choice<0) {
						System.out.println("You have provided a invalid input");
						doAuthentication();
					}else if(choice==0)
						return;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(true);
	}
	
	private static void registerCart(long mobileNumber) {
		int c_id = 0;
		String sql  = "select c_id from customer where mobile_no=?";
		//System.out.println("I am inside");
		try {
			//System.out.println("I am inside try 1");
		PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
		statement.setLong(1, mobileNumber);
		ResultSet resultSet = statement.executeQuery();
		//System.out.println("I am inside try 2");
		if(resultSet.next()) {
			//System.out.println("I am inside if");
			c_id = resultSet.getInt("c_id");
			statement = DbConnection.getInstance().getConnection().prepareStatement("insert into cart values(cart_sequence.nextval,?)");
			statement.setInt(1, c_id);
			int r= statement.executeUpdate();
			System.out.println(r);
			//registerOrder(c_id);
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void showProfileMenu(Customer customer) {
		int choice = 0,confirmation = 0;
		boolean flag = true;
		do {
			System.out.println("+----------------------- Profile Menu -----------------------+");
			System.out.println("| 1. Show profile                                            |");
			System.out.println("| 2. Update profile                                          |");
			System.out.println("| 3. Go Back                                                 |");
			System.out.println("| 4. Exit                                                    |");
			System.out.println("+------------------------------------------------------------+");


		try {
			choice = Integer.parseInt(reader.readLine().trim());
			choice = Validation.isOptionValid(1, 4, choice);
		}catch(IOException | InvalidMenuChoiceException e) {
			System.out.println(e.getMessage());
			continue;
		}catch(NumberFormatException e) {
			System.out.println("Numbers are only allowed.Letters or symbols are not allowed");
			continue;
		}
		switch(choice) {
		case 1:{
			System.out.println("You have choosen the show profile option");
			System.out.println("-".repeat(200));
			System.out.println(customer);
			System.out.println("-".repeat(200));
			break;
		}
		case 2:{
			System.out.println("You have choosen to update profile option");
			showUpdateProfileMenu(customer);
			break;
		}
		case 3:{
			System.out.println("You are heading to the previous menu");
			showCustomerMenu(customer);
			break;
		}
		case 4:{
			do {
			System.out.println("You have choosen to exit!!!");
			System.out.println(exitBox);
			System.out.println("Enter your choice");
			try {
				confirmation = Integer.parseInt(reader.readLine().trim());
				confirmation = Validation.isOptionValid(0, 1, confirmation);
			}catch(NumberFormatException e) {
				System.out.println("Input should be a number.The letter or symbols are not allowed");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			if(confirmation==1) {
				DbConnection.closeConnection();
				System.out.println("Thanks for visiting "+customer.getFirstName()+"  Have a Nice day :)");
				System.exit(0);
			}else if(confirmation==0) {
				flag = false;
			}
			}while(flag);
			break;
		}
		}
		}while(true);
		
		
	}
	


	//return type:void 
	//This method consist of the CustomerProfileMenu based operations
	public static void showUpdateProfileMenu(Customer customer) {
		int choice = 0,confirmation = 0;
		boolean match = false;
		String firstName = "",lastName = "",emailId = "";
		long mobileNumber=0;
		String address = "";
		String password = "";
		int retries=3;
		boolean flag = true;
		try {
		do {
			System.out.println("+------------------------- Profile Update Menu --------------------------+");
			System.out.println("| 1. Update password                                                     |");
			System.out.println("| 2. Update First name                                                   |");
			System.out.println("| 3. Update Last name                                                    |");
			System.out.println("| 4. Update address                                                      |");
			System.out.println("| 5. Update Mobile Number                                                |");
			System.out.println("| 6. Update Email Id                                                     |");
			System.out.println("| 7. Go Back                                                             |");
			System.out.println("| 8. Exit                                                                |");
			System.out.println("+------------------------------------------------------------------------+");


			try {
				choice = Integer.parseInt(reader.readLine().trim());
				choice = Validation.isOptionValid(1, 8, choice);
			}catch(IOException | InvalidMenuChoiceException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(NumberFormatException e) {
				System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
				continue;
			}
			
			switch(choice) {
			case 1:{
				System.out.println("You have choosen to update your password.");
				System.out.println("You should enter your existing password to update your password.");
				flag = true;
				do {
					System.out.println("Enter your current password");
					password = reader.readLine();
					if(customer.getAccount().getPassword().equals(password)) {
						System.out.println("Your entered password has been matched So you can change");
						match = true;
					}else {
						System.out.println("Entered password does not match with current password");
						retries--;
						if(retries<=0)
							return;
						System.out.println("Still there is "+retries+" more");
						//retries--;
						continue;
					}
					flag = false;
					//retries--;
				}while(flag && retries!=0);
				flag = true;
				if(match) {
					do {
					System.out.println("Enter your new password");
					try {
					password = reader.readLine();
					password = Validation.isPasswordValid(password); 
					}catch(InvalidPasswordException e) {
						System.out.println("Invalid Input Password");
						continue;
					}
					customer.updatePassoword(password);
					//System.out.println(customer.getAccount().getPassword());
					flag = false;
					}while(flag);
				}
				
				break;
			}
			case 2:{
				System.out.println("You have choosen to update your first name");
				
				flag = true;
				do {
					System.out.println("Enter your new First name : ");
				try {
					firstName = reader.readLine();
					firstName = Validation.isFirstNameValid(firstName);
				}catch(IOException | InvalidStringException e) {
					System.out.println(e.getMessage());
					continue;
				}
				customer.updateFirstName(firstName);
				flag = false;
				}while(flag);
				break;				
			}
			case 3:{
				System.out.println("You have choosen to update your Last name");
				//System.out.println("Enter your new Last name : ");
				flag = true;
				do {
					System.out.println("Enter your new Last name : ");
				try {
					lastName = reader.readLine();
					lastName = Validation.isLastNameValid(lastName);
				}catch(IOException | InvalidStringException e) {
					System.out.println(e.getMessage());
					continue;
				}
				customer.updateLastName(lastName);
				flag = false;
				}while(flag);
				break;
			}
			case 4:{
				System.out.println("You have choosen to update your Address");
				
				flag = true;
				do {
					System.out.println("Enter your new Address : ");
				try {
					address = reader.readLine();
				}catch(IOException e) {
					System.out.println(e.getMessage());
					continue;
				}
				customer.updateAddress(address);
				flag = false;
				}while(flag);
				break;
			}
			case 5:{
				System.out.println("You have choosen to update your Mobile Number");
				
				flag = true;
				do {
					System.out.println("Enter your new Mobile Number : ");
				try {
					mobileNumber = Long.parseLong(Validation.isMobileNumberValid(reader.readLine()));
				}catch(IOException | InvalidMobileNumberException e) {
					System.out.println(e.getMessage());
					continue;
				}catch(NumberFormatException e) {
					System.out.println("Numbers are only allowed.Letters or symbols are not allowed");
					continue;
				}
				customer.updateMobileNumber(mobileNumber);
				flag = false;
				}while(flag);
				break;
			}
			case 6:{
				System.out.println("You have choosen to update Email Id : ");
				
				flag = true;
				do {
					System.out.println("Enter your new Email Id : ");
				try {
					emailId = reader.readLine();
					emailId = Validation.isEmailIdValid(emailId);
				}catch(IOException |InvalidEmailException e) {
					System.out.println(e.getMessage());
					continue;
				}
				customer.updateEmail(emailId);
				flag = false;
				}while(flag);
				break;
			}
			case 7:{
				System.out.println("You are heading to previous menu");
				showProfileMenu(customer);
				break;
			}
			case 8:{
				flag = true;
				do {
				System.out.println("You have choosen to exit!!!");
				System.out.println(exitBox);
				System.out.println("Enter your choice");
				try {
					confirmation = Integer.parseInt(reader.readLine().trim());
					confirmation = Validation.isOptionValid(0, 1, confirmation);
				}catch(NumberFormatException e) {
					System.out.println("Input should be a number.The letter or symbols are not allowed.");
					continue;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				if(confirmation==1) {
					DbConnection.closeConnection();
					System.out.println("Thanks for visiting "+customer.getFirstName()+" Have a Nice day :)");
					System.exit(0);
				}else if(confirmation == 0) {
					flag = false;
				}
				}while(flag);
				break;
			}
			}
			
		}while(flag);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//return type:void.
	//This method consist of the provision to showCustomer Orders.
	public static void showCustomerOrders(Customer customer) {
		boolean flag = true;
		String shippingAddress = "";
		int choice = 0,confirmation = 0;
		customer.setOrders(new CartAndOrderManager().getCustomerOrders(customer));
		List<Order> myorder = customer.getOrders().getOrderList();
		if(myorder.size()==0) {
			System.out.println("!".repeat(50)+"There is no orders"+"!".repeat(50));
			showCustomerMenu(customer);
		}
		Collections.sort(myorder);
		Map<Integer,Order> orders = IntStream.range(0, myorder.size())
				.boxed()
				.collect(Collectors.toMap(
						i->i+1, 
						i-> myorder.get(i)));
		do {
		    System.out.println("+-------------+--------------------------+------------+------------+----------------------+------------+-----------------+-----------------+---------------------------------------------------------------------+-----------------+");
	        System.out.printf("|Order Number | Product Name             | Brand      | Price      | Warranty             | Quantity   | Order Date      | Total Amount    | Shipped Address                                                     | Order Status    |%n");
	        System.out.println("+-------------+--------------------------+------------+------------+----------------------+------------+-----------------+-----------------+---------------------------------------------------------------------+-----------------+");

	   // System.out.printf("|%-15s | %-10s | %-10d | %-10s | %-10d | %-15s | %-15d | %-50s|%n",
			orders.forEach((k,v)->v.printOrderDetails(k));
			System.out.println("+--------------------------------------+");
	        System.out.println("|             Order Menu               |");
	        System.out.println("+--------------------------------------+");
	        System.out.println("| 1. Cancel a order                    |");
	        System.out.println("| 2. Change a Orders Shipping Address  |");
	        System.out.println("| 3. Go Back                           |");
	        System.out.println("| 4. Exit                              |");
	        System.out.println("+--------------------------------------+");
	        System.out.println("Enter your choice");
        try {
        	choice = Integer.parseInt(reader.readLine().trim());
        	choice = Validation.isOptionValid(1, 4, choice);
        }catch(IOException | InvalidMenuChoiceException e) {
        	System.out.println(e.getMessage());
        	continue;
        }catch(NumberFormatException e) {
        	System.out.println("Numbers are only allowed.Letters or Symbols are not allowed");
        	continue;
        }
        flag = false;
        switch(choice) {
	        case 1:{
	        	System.out.println("You have chosen to Cancel a order.");
	        	flag = true;
	        	do {
	        		System.out.println("Enter the Order Number to cancel the order");
	        		try {
	        			choice = Integer.parseInt(reader.readLine().trim());
	        			choice = Validation.isOptionValid(1, orders.size(), choice);
	        		}catch(IOException | InvalidMenuChoiceException e) {
	        			System.out.println(e.getMessage());
	        			continue;
	        		}catch(NumberFormatException e) {
	        			System.out.println("Numbers are only allowed.Letters or symbols are not allowed");
	        			continue;
	        		}
	        		do {
		        		System.out.println("Do you really need to cancel your order (1 to Yes | 0 to No)");
		        		try {
		        			confirmation = Integer.parseInt(reader.readLine());
		        			confirmation = Validation.isOptionValid(0, 1, confirmation);
		        		}catch(IOException | InvalidMenuChoiceException e) {
		        			System.out.println(e.getMessage());
		        			continue;
		        		}catch(NumberFormatException e) {
		        			System.out.println("Numbers are only allowed.Letters or Symbols are not allowed");
		                	continue;
		        		}
		        		if(confirmation == 1) {
			        			if(cancelOrder(orders.get(choice))) {
			        				System.out.println("Your order has been cancelled sucessfully");
			        				System.out.println("The refund amount of rs."+orders.get(choice).getAmount()+" will be debit to your account in 2 business days.");
			        				showCustomerOrders(customer);
			        			}else {
			        				System.out.println("There is some problem");
			        			}
		        		}
		        		//flag = false;
		        		break;
		        	}while(true);
	        		break;
	        	}while(true);
	        	break;
	        }
	        case 2:{
	        	System.out.println("You have chosen to Change the Orders Shipping Address");
	        	Order order = new Order();
	        	do {
	        		System.out.println("Enter the Order Number to change the shipping Address");
		        	try {
		        		choice = Integer.parseInt(reader.readLine());
		        		choice = Validation.isOptionValid(1, orders.size(), choice);
		        	}catch(InvalidMenuChoiceException  | IOException e) {
		        		System.out.println(e.getMessage());
		        		continue;
		        	}catch(NumberFormatException e) {
		        		System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
		        		continue;
		        	}
		        	order = orders.get(choice);
	        		break;
	        	}while(true);
	        	do {
	        		System.out.println("Enter the new Shipping Address : ");
	        		try {
						shippingAddress = reader.readLine();
						shippingAddress = Validation.isInputLengthValid(shippingAddress);
					} catch (IOException | InvalidLengthException e) {
						System.out.println(e.getMessage());
						continue;
					}
	        		order.setAddress(shippingAddress);
	        		break;
	        	}while(true);
	        	if(order.changeShippingAddress()) {
	        		System.out.println("You have successfully Changed the Shipping Address");
	        	}
	        	break;
	        }
	        case 3:{
	        	System.out.println("you are heading towards the previous menu.");
	        	showCustomerMenu(customer);
	        	break;
	        }
	        case 4:{
	        	do {
					System.out.println("You have chosen to exit!!!");
					System.out.println(exitBox);
					System.out.println("Enter your choice");
					try {
						confirmation = Integer.parseInt(reader.readLine().trim());
						confirmation = Validation.isOptionValid(0, 1, confirmation);
					}catch(NumberFormatException e) {
						System.out.println("Input should be a number.The letter or symbols are not allowed");
						continue;
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
					if(confirmation==1) {
						DbConnection.closeConnection();
						System.out.println("Thanks for visiting "+customer.getFirstName()+" Have a Nice day :)");
						System.exit(0);
					}else if(confirmation==0) {
						break;
					}
					
	        	}while(true);
	        break;
	       }
      }
	}while(true);
	//cancelOrder(customer);
}
	//return type:void 
	//This method consist of the operation to cancelOrders
	private static boolean cancelOrder(Order order) {
		if(updateOrderProduct(order)) {
			//System.out.println("Order has been cancelled sucessfully!!");
			return true;
		}else {
			return false;
		}
	}
	
	//return type:void 
	//This method consist of the operations to updateProduct.
	private static boolean updateOrderProduct(Order order) {
		String sql = "delete order_product where order_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				updatePayment(order);
				return true;
			}
		}catch(SQLException e) {
			System.out.println("Inside update order product : "+e.getMessage());
		}
		return false;
	}
	
	private static boolean updatePayment(Order order) {
		String sql = "delete payment where order_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				updateOrders(order);
				return true;
			}
		}catch(SQLException e) {
			System.out.println("Inside payment order product : "+e.getMessage());
		}
		return false;
	}
	
	private static boolean updateOrders(Order order) {
		//System.out.println(order.getOrderId());
		String sql = "delete orders where order_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				updateProduct(order);
				return true;
			}
		}catch(SQLException e) {
			System.out.println("In update orders : "+e.getMessage());
		}
		return false;
	}
	
	private static boolean updateProduct(Order order) {
		String sql = "update product set p_quantity=p_quantity+? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setInt(1, order.getProduct().getQuantity());
			statement.setInt(2, order.getProduct().getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				//System.out.println("The product table has updated sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println("In update product : "+e.getMessage());
		}
		return false;
	}
	

	
	

}
