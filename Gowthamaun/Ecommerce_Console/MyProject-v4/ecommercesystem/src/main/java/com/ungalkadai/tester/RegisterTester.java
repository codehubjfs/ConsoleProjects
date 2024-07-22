package com.ungalkadai.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.ecommerce.customizedexceptions.InvalidEmailException;
import com.ecommerce.customizedexceptions.Validation;
import com.ecommerce.menu.SearchAndSortManager;
import com.ecommerce.menu.SellerActivity;
import com.ecommerce.users.Address;
import com.ecommerce.users.Customer;
import com.ecommerce.users.CustomerType;
import com.ecommerce.users.DbConnection;
import com.ecommerce.users.DbmsConnection;
import com.ecommerce.users.Gender;
import com.ecommerce.users.Vendor;
import com.ecommerce.users.account.Account;
import com.ecommerce.users.account.AccountStatus;
import com.ecommerce.users.account.AccountType;
import com.ungalkadai.components.Cart;
import com.ungalkadai.components.Category;
import com.ungalkadai.components.Product;
import com.ungalkadai.components.ProductStatus;
import com.ungalkadai.components.SubCategory;

public class RegisterTester {
	public static void main(String[] args) {
		Vendor vendor = new Vendor();
		vendor.setVendorId(41);
		SellerActivity.getMyProductOrders(vendor).forEach((k,v)->System.out.println("S.no : "+k+"\n"+v));
		//public Product(String productName, String brand, int quantity, String subtitle, String description, String warranty,
		//Category category, SubCategory subCategrory, ProductStatus productStatus)
//		Product p = new Product("laptop","hP",30,"Gaming laptop","This is a laptop","1 year",new SubCategory("Laptops",new Category("Electronics")),ProductStatus.VERIFIED);
//		System.out.println(p);
		//System.out.println(getNum());
//		String regexx = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
//		System.out.println("hari@gmail.com".matches(regexx));
//		
////		String s = "This is working";
////		Double d = 90.00;
////		String columnName = "";
//		Cart cart = new Cart();
//		
//		Map<Integer,Product> products = getMyCart(82);
		
		//products.forEach((k,v)->System.out.println(k+" "+v+" Quantity : "+v.getQuantity()));
//		 Product.displayTableHeader();
//		getAllProduct().forEach((k,v)->Product.display(v,k));
//		System.out.println("&&".repeat(200));
//		 Map<Integer, Product> products = getAllProduct();
//	        String search = "t-shirt";
////
////	        Map<Integer, Product> filteredProducts = products.entrySet().stream()
////	            .filter(entry -> entry.getValue().toString().toLowerCase().contains(search.toLowerCase()))
////	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
////
////	        filteredProducts.forEach((k, v) -> System.out.println(k + ": " + v));
//	        
//	        List<Map.Entry<Integer,Product>> filteredEntries = products.entrySet().stream()
//	                .filter(entry -> entry.getValue().getProductName().toLowerCase().contains(search.toLowerCase()))
//	                .collect(Collectors.toList());
//
//	            // Generate new serial numbers and collect into a map
//	            Map<Integer, Product> filteredProducts = IntStream.range(0, filteredEntries.size())
//	                .boxed()
//	                .collect(Collectors.toMap(
//	                    i -> i + 1, // Serial numbers starting from 1
//	                    i -> filteredEntries.get(i).getValue()
//	                ));
//	            Product.displayTableHeader();
//	            filteredProducts.forEach((k,v)->Product.display(v,k));
	            // Print the filtered products with new serial numbers
	            //filteredProducts.forEach((k, v) -> System.out.println("Product code : "+k + " " + v));
//		DbConnection s = DbConnection.getDbConnection();
//		DbConnection s1 = DbConnection.getDbConnection();
//		DbConnection s2 = new DbConnection();
//		System.out.println(s==s1);
//		getMyCartList(81).forEach((i)->System.out.println(i+"Quantity : "+i.getQuantity()));
//		update(s,columnName);
//		update(d);
//		LocalDate d = LocalDate.now();
//		test(d);
//		String s = "electronics";
//		Map<Integer,Product> products = SearchAndSortManager.getAllProduct();
//		SearchAndSortManager.getAllProduct().entrySet().stream()
//		.filter(v->v.getValue().getSubCategrory().getCategory().getCategoryName().equalsIgnoreCase(s))
//		.forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
//		System.out.println("-".repeat(200));
//		System.out.println(products.get(2));
//		//SearchManager.searchByCategory( null);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
//		System.out.println("sanjaisanjai561@gmail.com".matches(regex));
//		SellerActivity.getAllProductMap().forEach((k,v)->System.out.println(k+" "+v));
//		SellerActivity.getAllProductMap().values().stream().filter(p->p.getBrand().equalsIgnoreCase("Dell")).forEach(System.out::println);
		//SellerActivity.getAllProductMap().values().stream().toList().forEach((p)->System.out.println(p.getSubCategrory().getSubCategoryName()));
//		int choice = 0;
//		List<String> l = new ArrayList<>();
//		l.add("Mobile NUmber");
//		l.add("Name");
//		l.add("Cell Phone");
//		l.add("MY Cell Phone");
//		l.add("your Cell Phone");
//		l.forEach((i)->System.out.println((l.indexOf(i)+1)+" "+i+" "));
//		try {
//			choice = Integer.parseInt(reader.readLine());
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(l.get(choice-1));
//		l.stream().filter(s->s.contains("Cell Phone")).forEach(System.out::println);
//	    .map(Product::getBrand)
//	    .collect(Collectors.toList())
//	    .forEach(System.out::println);

		//SellerActivity.getAllProductMap().entrySet().stream().map(Product::getBrand).collect(Collectors.toList()).forEach(System.out::println);;
		//getAllCategory().stream().collect(Collectors.toMap(Stream.generate(1), null));
//		getAllCategoryMap().forEach((k,v)->System.out.println(k+" "+v));
//		getAllSubCategoryMap().forEach((k,v)->System.out.println(k+" "+v));
		//getAllSubCategoryMap().entrySet().stream().flatMap((k,v)->Integer,);
//		List<String> categoryNames = getAllSubCategoryMap().entrySet().stream()
//	    .flatMap(entry -> entry.getValue().stream()) // FlatMap to stream over the subcategories
//	    .collect(Collectors.toList());
//		
//		List<String> categoryNames = getAllSubCategoryMap().entrySet().stream()
//			    .flatMap(entry -> entry.getValue().stream()) // FlatMap to stream over the subcategories
//			    .collect(Collectors.toList());
		List<String> categoryNames = getAllSubCategoryMap().values().stream()
			    .map(SubCategory::getCategory) 
			    .map(Category::getCategoryName)
			    .distinct()
			    .collect(Collectors.toList());
		
		categoryNames.forEach((p)->System.out.println((categoryNames.indexOf(p)+1)+" "+p));
		String i = "electronics";
		System.out.println("-".repeat(100));
		categoryNames.stream().filter(p->p.equalsIgnoreCase(i)).forEach(System.out::println);

		//String regex = "^(?=.*[A-Za-z])(?=.\\d)(?=.*[@$!%#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		String email = "2k2gowtharefrewfewrerwrererer@kiot.ac";
		System.out.println("2k2gowtharefrewfewqrerwrererer".length());
		try {
			System.out.println(Validation.isEmailIdValid(email));
		} catch (InvalidEmailException e) {
			System.out.println(e.getMessage());
		}
		
		int v_id = 41;
		SellerActivity.getData(v_id);
		System.out.println(SellerActivity.getData(v_id));
		getAllSubCategoryMap().forEach((k,v)->System.out.println(k+" "+v));
		Map<Integer, String> convertedMap = getAllSubCategoryMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getCategory().getCategoryName(),
                        (existingValue, newValue) -> existingValue));

        // Print the converted map
        //convertedMap.forEach((key, value) -> System.out.println(key + ": " + value));
//		 Map<Integer, String> convertedMap = getAllSubCategoryMap().entrySet().stream()
//	                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getCategory().getCategoryName())).entrySet().stream().distinct().collect(Collectors.toMap(Map.Entry::getKey, entry->entry.getValue()));
		// System.out.println(convertedMap);
//		getAllSubCategory().stream().collect(Collectors.toMap(Stream.iterate(1, (n)->n+1), null));
		//String regex = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$\r\n";
		//System.out.println("gowthamun".matches(regex));
//		boolean loop = true;
//		String password = "";
//		int choice = 0;
//		int id=0;
//		String registerNumber = "";
//		Long aadharNumber = 0L;
//		String userName = "";
//		String firstName = "",lastName = "";
//		String address = "";
//		Gender gender = null;
//		Long mobileNumber = 0L;
//		String emailId = "";
//		AccountType accountType;
//		AccountStatus accountStatus = AccountStatus.ACTIVE;  
//		//String password = "";
//		
//		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
//			while(loop) {
//				System.out.println("Select the user to login as");
//				System.out.println("1.Customer\t\t2.Seller\t\t3.Exit");
//				
//				choice = Integer.parseInt(reader.readLine());
//				switch(choice) {
//				case 1:{
//					System.out.println("You have choosen to register as a Customer");
//					System.out.println("Enter your id");
//					id = Integer.parseInt(reader.readLine());
//					System.out.println("Enter your username");
//					userName = reader.readLine();
//					System.out.println("Enter your password");
//					password = reader.readLine();
//					System.out.println("Enter your firstName");
//					firstName = reader.readLine();
//					System.out.println("Enter your lastName");
//					lastName = reader.readLine();
//					System.out.println("Enter your address");
//					address = reader.readLine();
//					System.out.println("Choose the gender");
//					System.out.println("1.Male\t\t2.Female\t\t3.Transgender");
//					choice = Integer.parseInt(reader.readLine());
//					switch(choice) {
//						case 1:{
//							gender = Gender.MALE;
//							break;
//						}
//						case 2:{
//							gender = Gender.FEMALE;
//							break;
//						}
//						case 3:{
//							gender = Gender.TRANSGENDER;
//							break;
//						}
//						default:{
//							System.out.println("You have entered a invalid input");
//							continue;
//						}
//					}
//					System.out.println("Enter your mobileNumber");
//					mobileNumber = Long.parseLong(reader.readLine());
//					if(mobileNumber.toString().length()!=10) {
//						System.out.println("Provided mobile Number is not a valid");
//						continue;
//					}
//					System.out.println("Enter your emailId");
//					emailId = reader.readLine();
//					accountType = AccountType.CUSTOMER;
//					Customer customer = new Customer();
//					//Customer(String firstName, String lastName, String customerName,Gender gender, int customerId,Address address,String email,String mobileNumber,Account account)
//					customer.registerUser(new Customer(firstName,lastName,gender,id,address,emailId,mobileNumber,new Account(userName,password,accountType,accountStatus)));
//					
//				}
//				case 2:{
//					System.out.println("You have chosen to Register as a Seller");
//					System.out.println("Enter the seller id");
//					id = Integer.parseInt(reader.readLine());
//					System.out.println("Enter your username");
//					userName = reader.readLine();
//					System.out.println("Enter your password");
//					password = reader.readLine();
//					System.out.println("Enter your registered Number");
//					registerNumber = reader.readLine();
//					System.out.println("Enter your address");
//					address = reader.readLine();
//					System.out.println("Enter your mobile Number");
//					mobileNumber = Long.parseLong(reader.readLine());
//					System.out.println("Enter your aadhar Number");
//					aadharNumber = Long.parseLong(reader.readLine());
//					if(aadharNumber.toString().length()!=12) {
//						System.out.println("Your aadhra number is invalid");
//						continue;
//					}
//					System.out.println("Enter your email");
//					emailId = reader.readLine();
//					Vendor vendor = new Vendor();
//					accountType = AccountType.SELLER;
//					
//					//Vendor(int vendorId,String vendorName,String registeredNumber,Account account,String aadharNumber,String email,long mobileNumber,String address)
//					vendor.registerUser(new Vendor(id,userName,registerNumber,new Account(userName,password,accountType,accountStatus),aadharNumber,emailId,mobileNumber,address));
//					break;
//				}
//				case 3:{
//					loop = false;
//					break;
//				}
//				default:{
//					System.out.println("You have provided a invalid input");
//				}
//				}
//			}
//	}catch(Exception e) {
//		System.out.println(e.getMessage());
//	}

}
	
	static Map<Integer,Product> getMyCart(int c_id) {
		//String sql = "
		Map<Integer,Product> myProducts = new HashMap<>();
		int i =1;
		String sql = "select p.warranty,p.p_brand,p.p_description,p.p_id,p.p_name,p.p_subtitle,p.p_price,cd.quantity \r\n"
				+ "from product p,cart_detail cd,cart ca,customer c\r\n"
				+ "where c.c_id=ca.c_id and c.c_id=81 and cd.cart_id=ca.cart_id and cd.p_id=p.p_id";
		try {
		Statement st = DbmsConnection.getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		//Product(String productName, int productId, double productPrice, String brand, int quantity, String subtitle
		//,String description,String warranty)
		while(rs.next()) {
			myProducts.put(i, new Product(
					rs.getString("p_name"),
					rs.getInt("p_id"),
					rs.getDouble("p_price"),
					rs.getString("p_brand"),
					rs.getInt("quantity"),
					rs.getString("p_subtitle"),
					rs.getString("p_description"),
					rs.getString("warranty")
					));
			i++;
		}
		//Map<Integer, Product> myProducts2 = myProducts;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return myProducts;
		
	}
	
	static List<Product> getMyCartList(int c_id) {
		DbConnection con = DbConnection.getInstance();
		//String sql = "
		List<Product> myProducts = new ArrayList<>();
		//int i =1;
		String sql = "select p.warranty,p.p_brand,p.p_description,p.p_id,p.p_name,p.p_subtitle,p.p_price,cd.quantity \r\n"
				+ "from product p,cart_detail cd,cart ca,customer c\r\n"
				+ "where c.c_id=ca.c_id and c.c_id=81 and cd.cart_id=ca.cart_id and cd.p_id=p.p_id";
		try {
		Statement st = con.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery(sql);
		//Product(String productName, int productId, double productPrice, String brand, int quantity, String subtitle
		//,String description,String warranty)
		while(rs.next()) {
			myProducts.add(new Product(
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return myProducts;
		
	}
	
	static void test(LocalDate d) {
		//Date date = Date.valueOf(d);
		String sql = "insert into demod values(?)";
		try {
			PreparedStatement statement = DbmsConnection.getConnection().prepareStatement(sql);
			statement.setDate(1, Date.valueOf(d));
			int r = statement.executeUpdate();
			if(r>0)
				System.out.println("Sucess");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	static int getSequenceNumber() {
		String sql= "select order_sequence.nextval from dual";
		try {
		Statement statement = DbmsConnection.getConnection().createStatement();
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
	
	static List<Category> getAllCategory(){
		List<Category> categoryList = new ArrayList<>();
		String sql  = "select * from category";
		try {
			Statement statement = DbConnection.getInstance().getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				categoryList.add(new Category(
						resultSet.getInt("category_id"),
						resultSet.getString("category_name")
						));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
	
	static Map<Integer,Category> getAllCategoryMap(){
		Map<Integer,Category> categoryList = new HashMap<>();
		String sql  = "select * from category";
		int i =1;
		try {
			Statement statement = DbmsConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				categoryList.put(i,new Category(
						resultSet.getInt("category_id"),
						resultSet.getString("category_name")
						));
				i++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
	
	static List<SubCategory> getAllSubCategory(){
		List<SubCategory> categoryList = new ArrayList<>();
		String sql  = "select s.subcategory_id,s.subcategory_name,c.category_name,c.category_id from subcategory s,category c where s.category_id=c.category_id";
		try {
			Statement statement = DbmsConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				categoryList.add(new SubCategory(
						resultSet.getInt("subcategory_id"),
						resultSet.getString("subcategory_name"),
						new Category(
								resultSet.getInt("category_id"),
								resultSet.getString("category_name")
								)
						));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
	
	static Map<Integer,SubCategory> getAllSubCategoryMap(){
		Map<Integer,SubCategory> categoryList = new HashMap<>();
		int i = 1;
		String sql  = "select s.subcategory_id,s.subcategory_name,c.category_name,c.category_id from subcategory s,category c where s.category_id=c.category_id";
		try {
			Statement statement = DbmsConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				categoryList.put(i,new SubCategory(
						resultSet.getInt("subcategory_id"),
						resultSet.getString("subcategory_name"),
						new Category(
								resultSet.getInt("category_id"),
								resultSet.getString("category_name")
								)
						));
				i++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
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
