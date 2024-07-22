package com.ecommerce.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.ecommerce.customizedexceptions.InvalidMenuChoiceException;
import com.ecommerce.customizedexceptions.Validation;
import com.ecommerce.users.Customer;
import com.ecommerce.users.DbConnection;
import com.ecommerce.users.DbmsConnection;
import com.ungalkadai.components.Card;
import com.ungalkadai.components.Category;
import com.ungalkadai.components.Order;
import com.ungalkadai.components.PaymentStatus;
import com.ungalkadai.components.Product;
import com.ungalkadai.components.SubCategory;

public class SearchAndSortManager {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder exitBox = new StringBuilder();
	
	static Map<Integer,SubCategory> subCategories = SellerActivity.getAllSubCategoryMap();
	
	static Map<Integer,Product> products = getAllProduct();
	 
	static {
        exitBox.append("+----------------------------------+\n");
        exitBox.append("|      Are you sure to Exit?       |\n");
        exitBox.append("|         (1-yes | 0-no)           |\n");
        exitBox.append("+----------------------------------+\n");
	}
	
	public static void showFunctionalMenu(Customer customer,Map<Integer,Product> filtered) {
		if(filtered.size()==0) {
			System.out.println("There is no product match found!!");
			CustomerActivity.showSearchMenu(customer);
		}
		int choice = 0,confirmation = 0;
		//System.out.println("Cart : "+customer.getCart().getCart_id());//		customer = CartAndOrderManager.getCart(customer);
		int orderId = CartAndOrderManager.getSequenceNumber();
		Product choosen = null;
		String address = "";
		int quantity = 0;
		try {
		do {
		System.out.println("+----------------------------------+");
        System.out.println("|        SHOPPING OPTIONS          |");
        System.out.println("+----------------------------------+");
        System.out.println("| 1. Buy a product                 |");
        System.out.println("| 2. Add a Product to Cart         |");
        System.out.println("| 3. Sort                          |");
        System.out.println("| 4. Go Back                       |");
        System.out.println("| 5. Exit                          |");
        //System.out.println("| 6. Exit                          |");
        System.out.println("+----------------------------------+");
        System.out.println("Enter your choice");
        try {
        	choice = Integer.parseInt(reader.readLine());
        	choice = Validation.isOptionValid(1, 5, choice);
        }catch(NumberFormatException e) {
        	System.out.println("Input should be a number.The letter or symbols are not allowed");
			continue;
        }catch(InvalidMenuChoiceException e) {
        	System.out.println(e.getMessage());
        	continue;
        }
        switch(choice) {
       
        case 1:{
        	System.out.println("you have choosen to buy a product");
        	 //filtered.forEach((k,v)->System.out.println(k+" "+v));
        	do {
	        	System.out.println("Enter the s.no of the product");
	        	try {
	    			choice = Integer.parseInt(reader.readLine());
	    			if(!filtered.containsKey(choice)) {
	    				System.out.println("Invalid product number");
	    				continue;
	    			}
	    			//choice = Validation.isOptionValid(1, categoryNames.size(), choice);
	    		}catch(NumberFormatException e) {
	    			System.out.println("Input should be a number.The letter or symbols are not allowed");
	    			continue;
	    		}catch(Exception e) {
	    			System.out.println(e.getMessage());
	    			continue;
	    		}
	        	break;
        	}while(true);
        	choosen = filtered.get(choice);
        	do {
        		System.out.println("Enter the number of quantity for the choosen product range(1-10)");
        		try {
        			quantity = Integer.parseInt(reader.readLine());
        			quantity = Validation.isOptionValid(1, 10,quantity);
        		}catch(NumberFormatException e) {
        			System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
        			continue;
        		}catch(InvalidMenuChoiceException e) {
        			System.out.println(e.getMessage());
        			continue;
        		}
        		choosen.setQuantity(quantity);
        		break;
        	}while(true);
        	
        	do {
        		System.out.println("Your address : "+customer.getAddress());
	        	System.out.println("+-----------------------------------+");
	        	System.out.println("| 1. Continue with your address     |");
	        	System.out.println("| 2. New Address                    |");
	        	System.out.println("+-----------------------------------+");
        	try {
        		confirmation = Integer.parseInt(reader.readLine().trim());
        		confirmation = Validation.isOptionValid(1, 2, confirmation);
        	}catch(InvalidMenuChoiceException | IOException  e) {
        		System.out.println(e.getMessage());
        		continue;
        	}catch(NumberFormatException e) {
        		System.out.println("Numbers are only allowed.Letters or symbols are not allowed.");
        		continue;
        	}
        	break;        	
        	}while(true);
        	if(confirmation==2) {
        		System.out.println("Enter your new Shipping address");
        		address = reader.readLine();
        	}else {
        		address = customer.getAddress();
        	}
        	confirmation = 0;
        	Order order = new Order();
        	order.setCustomer(customer);
        	order.setOrderDate(LocalDate.now());
        	order.setOrderId(orderId);
        	order.setAddress(address);
        	order.setOrderStatus("PLACED");
        	//boolean status = customer.makeOrder(order);
        	//if(status) {
        		
        		Card card = new Card();
        		card.setOrder(order);
        		card.setAmount(choosen.getProductPrice()*choosen.getQuantity());
        		card.setPaymentStatus(PaymentStatus.COMPLETED);
        		card.setPaymentType("CREDIT CARD");
        		System.out.println("Total amount to be paid : "+(choosen.getProductPrice()*choosen.getQuantity()));
        		boolean status = customer.makeOrder(order);
        		if(status) {
        			System.out.println("Your Order will placed sucessfully.Once you completed the payment process.");
        		}
        		if(CartAndOrderManager.makePayments(card)) {
        		//customer.makeOrder(order);
        		CartAndOrderManager.updateProductTable(choosen);
        		CartAndOrderManager.makeOrder(order, choosen);
        		System.out.println("Total rs."+choosen.getProductPrice()*choosen.getQuantity());
        		CustomerActivity.showCustomerOrders(customer);
        		}
        		//}
    
        	//System.out.println(filtered.get(choice));
        	break;
        }
        case 2:{
        	System.out.println("you have choosen to add a product to your cart");
        	 //filtered.forEach((k,v)->System.out.println(k+" "+v));
        	System.out.println("Enter the s.no of the product");
        	try {
    			choice = Integer.parseInt(reader.readLine());
    			if(!filtered.containsKey(choice)) {
    				System.out.println("Invalid product number");
    				continue;
    			}
    			//choice = Validation.isOptionValid(1, categoryNames.size(), choice);
    		}catch(NumberFormatException e) {
    			System.out.println("Input should be a number.The letter or symbols are not allowed");
    			continue;
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    			continue;
    		}
        	choosen = filtered.get(choice);
        	
        	//System.out.println(choosen);
        	do {
        		System.out.println("Enter the number of quantity for the choosen product range(1-10)");
        		try {
        			quantity = Integer.parseInt(reader.readLine());
        			quantity = Validation.isOptionValid(1, 10,quantity);
        		}catch(NumberFormatException e) {
        			System.out.println("Numbers are only allowed");
        			continue;
        		}catch(InvalidMenuChoiceException e) {
        			System.out.println(e.getMessage());
        			continue;
        		}
        		choosen.setQuantity(quantity);
        		break;
        	}while(true);
        	boolean status = customer.addProductToCart(choosen);
        	if(status) {
        		CustomerActivity.showCustomerMenu(customer);
        	}
        	break;
        }
        case 3:{
        	System.out.println("You have choosen to sort");
        	showSortOptions(customer,filtered);
        	break;
        }
        case 4:{
        	System.out.println("You are heading to the previous menu");
        	CustomerActivity.showSearchMenu(customer);
        	break;
        }
        case 5:{
        	do {
        	System.out.println("You have choosen to exit!!!");
			System.out.println(exitBox);
			System.out.println("Enter your choice");
			try {
				confirmation = Integer.parseInt(reader.readLine());
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
			}else if(confirmation == 0) {
				break;
			}
        	}while(true);
			break;
        }
        }
		}while(true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
        
	}
	
	public static void showSortOptions(Customer customer,Map<Integer,Product> filtered) {
		int choice = 0,confirmation = 0;
		List<Map.Entry<Integer, Product>> sortedEntries = new ArrayList<>(filtered.entrySet());
		try {
		do {
			System.out.println("+----------------------------------+");
	        System.out.println("|          SORT OPTIONS            |");
	        System.out.println("+----------------------------------+");
	        System.out.println("| 1. Sort by Price (Low to High)   |");
	        System.out.println("| 2. Sort by Price (High to Low)   |");
	        System.out.println("| 3. Sort by Name (A-Z)            |");
	        System.out.println("| 4. Go Back                       |");
	        System.out.println("| 5. Exit                          |");
	        System.out.println("+----------------------------------+");
	        try {
	        	choice = Integer.parseInt(reader.readLine());
	        	choice = Validation.isOptionValid(1, 5, choice);
	        }catch(NumberFormatException e) {
	        	System.out.println("Allowed to enter only number.No letter or symbols are aloowed");
	        	continue;
	        }catch(InvalidMenuChoiceException e) {
	        	System.out.println(e.getMessage());
	        	continue;
	        }
	        switch(choice) {
	        case 1:{
	        	System.out.println("You have choosen to sort the product by price(Low to High)");
	            sortedEntries.sort((entry1, entry2) -> Double.compare(entry1.getValue().getProductPrice(), entry2.getValue().getProductPrice()));
	            Map<Integer, Product> filteredProducts = IntStream.range(0, sortedEntries.size())
		                .boxed()
		                .collect(Collectors.toMap(
		                    i -> i + 1, // Serial numbers starting from 1
		                    i -> sortedEntries.get(i).getValue()
		                ));
		            Product.displayTableHeader();
		            filteredProducts.forEach((k,v)->Product.display(v,k));
	            //sortedEntries.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	            showFunctionalMenu(customer,filteredProducts);
	            break;
	        }
	        case 2:{
	        	System.out.println("You have choosen to sort the product by price(High to Low)");
	            sortedEntries.sort((entry1, entry2) -> Double.compare(entry2.getValue().getProductPrice(), entry1.getValue().getProductPrice()));
	            Map<Integer, Product> filteredProducts = IntStream.range(0, sortedEntries.size())
		                .boxed()
		                .collect(Collectors.toMap(
		                    i -> i + 1, // Serial numbers starting from 1
		                    i -> sortedEntries.get(i).getValue()
		                ));
		            Product.displayTableHeader();
		            filteredProducts.forEach((k,v)->Product.display(v,k));
		            showFunctionalMenu(customer,filteredProducts);
	           // sortedEntries.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	            break;
	        }
	        case 3:{
	        	System.out.println("You have choosen to sort the product by price(A-Z)");
	        	sortedEntries.sort((entry1,entry2)->entry1.getValue().getProductName().compareTo(entry2.getValue().getProductName()));
	        	Map<Integer, Product> filteredProducts = IntStream.range(0, sortedEntries.size())
		                .boxed()
		                .collect(Collectors.toMap(
		                    i -> i + 1, // Serial numbers starting from 1
		                    i -> sortedEntries.get(i).getValue()
		                ));
		            Product.displayTableHeader();
		            filteredProducts.forEach((k,v)->Product.display(v,k));
		            showFunctionalMenu(customer,filteredProducts);
	        	//sortedEntries.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	            break;
	        }
	        case 4:{
	        	System.out.println("You are heading to the previous menu");
	        	showFunctionalMenu(customer,filtered);
	        	break;
	        }
	        case 5:{
	        	//boolean flag = true;
	        	System.out.println("You have choosen to exit!!!");
	        	do {
					System.out.println(exitBox);
					System.out.println("Enter your choice");
					try {
						confirmation = Integer.parseInt(reader.readLine());
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
						System.out.println("Thanks for visiting "+customer.getAccount().getUserName()+" Have a Nice day :)");
						System.exit(0);
					}else if(confirmation==0) {
						break;
					}
				
	        	}while(true);
				break;
	        }
	        }
	        //showFunctionalMenu(customer,filtered);
		}while(true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	
	public static void searchByCategory(Customer customer) { 
		int choice = 0;
		List<String> categoryNames = subCategories.values().stream()
			    .map(SubCategory::getCategory) 
			    .map(Category::getCategoryName)
			    .distinct()
			    .collect(Collectors.toList());
		do {
		System.out.println("S.no\tCategoryName");
		categoryNames.forEach((c)->System.out.println((categoryNames.indexOf(c)+1)+"\t"+c));
		System.out.println("Enter your choice : ");
		try {
			choice = Integer.parseInt(reader.readLine());
			choice = Validation.isOptionValid(1, categoryNames.size(), choice);
		}catch(InvalidMenuChoiceException | IOException e) {
			System.out.println(e.getMessage());
			continue;
		}catch(NumberFormatException e) {
			System.out.println("Input should be a number.The letter or symbols are not allowed");
			continue;
		}
		String category = categoryNames.get(choice-1);
		
		System.out.println("You have chosen "+category+" Category");
		List<Entry<Integer,Product>> filteredEntries = products.entrySet().stream()
                .filter(entry -> entry.getValue().getSubCategrory().getCategory().getCategoryName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
		if(filteredEntries.size()==0) {
			System.out.println("There is no product found in chosen Category");
			CustomerActivity.showSearchMenu(customer);
		}

            // Generate new serial numbers and collect into a map
            Map<Integer, Product> filtered = IntStream.range(0, filteredEntries.size())
                .boxed()
                .collect(Collectors.toMap(
                    i -> i + 1, // Serial numbers starting from 1
                    i -> filteredEntries.get(i).getValue()
                ));
            Product.displayTableHeader();
            filtered.forEach((k,v)->Product.display(v,k));
		showFunctionalMenu(customer,filtered);
		}while(true);
	}
	
	public static void searchByProductName(Customer customer,String productName) {
		List<Entry<Integer,Product>> filteredEntries = products.entrySet().stream()
				.filter(entry->entry.getValue().getProductName().toLowerCase().contains(productName.toLowerCase()))
				.collect(Collectors.toList());
		if(filteredEntries.size()==0) {
			System.out.println("There is no product found with given product Name");
			CustomerActivity.showSearchMenu(customer);
		}
		 Map<Integer, Product> filtered = IntStream.range(0, filteredEntries.size())
	                .boxed()
	                .collect(Collectors.toMap(
	                    i -> i + 1, // Serial numbers starting from 1
	                    i -> filteredEntries.get(i).getValue()
	                ));
		 Product.displayTableHeader();
		 filtered.forEach((k,v)->Product.display(v, k));
		 showFunctionalMenu(customer,filtered);
	}
	
	public static void searchBySubCategory(Customer customer) { 
		int choice = 0;
		List<String> categoryNames = subCategories.values().stream()
			    .map(SubCategory::getSubCategoryName) 
			    .distinct()
			    .collect(Collectors.toList());
		do {
			System.out.println("S.no\tSubCategoryName");
			categoryNames.forEach((c)->System.out.println((categoryNames.indexOf(c)+1)+"\t"+c));
			System.out.println("Enter your choice : ");
			try {
				choice = Integer.parseInt(reader.readLine());
				choice = Validation.isOptionValid(1, categoryNames.size(), choice);
			}catch(InvalidMenuChoiceException | IOException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(NumberFormatException e) {
				System.out.println("Input should be a number.The letter or symbols are not allowed");
				continue;
			}
			String subCategory = categoryNames.get(choice-1);
			
			System.out.println("You have chosen "+subCategory+" SubCategory");
			
			List<Entry<Integer,Product>> filteredEntries = products.entrySet().stream()
	                .filter(entry -> entry.getValue().getSubCategrory().getSubCategoryName().equalsIgnoreCase(subCategory))
	                .collect(Collectors.toList());
			if(filteredEntries.size()==0) {
				System.out.println("There is no product found in chosen SubCategory");
				CustomerActivity.showSearchMenu(customer);
			}
	            // Generate new serial numbers and collect into a map
	        Map<Integer, Product> filtered = IntStream.range(0, filteredEntries.size())
                .boxed()
                .collect(Collectors.toMap(
                    i -> i + 1, // Serial numbers starting from 1
                    i -> filteredEntries.get(i).getValue()
                ));
            Product.displayTableHeader();
            filtered.forEach((k,v)->Product.display(v,k));
		showFunctionalMenu(customer,filtered);
		//}while(flag);
		}while(true);
	}
	
	
	public static Map<Integer,Product> getAllProduct(){
		Map<Integer,Product> products = new HashMap<>();
		int i = 1;
		String sql = "SELECT p.p_id,p.p_name,p.p_brand,p.p_subtitle,p.p_description,p.p_price,p.warranty,s.subcategory_id,s.category_id,"
				+ "s.subcategory_name,c.category_name "
				+ "FROM product p,subcategory s,category c WHERE p.category_id=c.category_id AND p.subcategory_id=s.subcategory_id";
		try {
			Statement statement = DbConnection.getInstance().getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				//Product(String productName, int productId, double productPrice, String brand, String subtitle,
				//String description, String warranty, SubCategory subCategrory)
				products.put(i, new Product(
						resultSet.getString("p_name"),
						resultSet.getInt("p_id"),
						resultSet.getDouble("p_price"),
						resultSet.getString("p_brand"),
						resultSet.getString("p_subtitle"),
						resultSet.getString("p_description"),
						resultSet.getString("warranty"),
						new SubCategory(
						resultSet.getInt("subcategory_id"),
						resultSet.getString("subcategory_name"),
						new Category(
						resultSet.getInt("category_id"),
						resultSet.getString("category_name")
						)
						)
						));
				i++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return products;
	}
}
