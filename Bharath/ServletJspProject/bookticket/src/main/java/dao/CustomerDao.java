package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AdminBean;
import bean.Customer;
import util.Database;

public class CustomerDao {
	Connection con=null;
	
	public List<Customer> viewCustomer(){
		String sql="select * from customer";
		List<Customer> user=new ArrayList<>();
		try {
			PreparedStatement statement =Database.getConnection().prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setId(rs.getInt("Customer_Id"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setLastName(rs.getString("lastname"));
				customer.setGender(rs.getString("gender"));
				customer.setEmail(rs.getString("Email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
//				customer.setStatus(rs.getString("status"));
				String available = rs.getString("Available");
                if (available != null && (available.equalsIgnoreCase("Active"))) {
                    customer.setStatus("Active");
                } else {
                    customer.setStatus("Inactive");
                }

				customer.setPhoneNumber(rs.getString("phonenumber"));
				user.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
}
	
	 public Customer login(String email, String password) throws ClassNotFoundException {
	 Customer customers = null;
     
     String sql = "SELECT * FROM Customer WHERE email=? AND password=?";
     
     try (Connection conn = Database.getConnection();
          PreparedStatement statement = conn.prepareStatement(sql)) {
         
         statement.setString(1, email);
         statement.setString(2, password);
         ResultSet resultSet = statement.executeQuery();
         
         if (resultSet.next()) {
             customers = new Customer();
             customers.setUsername(email);
             customers.setPassword(password);
             customers.setId(resultSet.getInt("customer_id"));
             customers.setFirstName(resultSet.getString("firstName"));
             customers.setLastName(resultSet.getString("lastName"));
         }
         
     } catch (Exception ex) {
         ex.printStackTrace();
     }
     
     return customers;
 }


	public void updateCustomerStatus(int customerId, String newStatus) {
		// TODO Auto-generated method stub
		 Connection connection;
			try {
				connection = Database.getConnection();
				  String sql = "UPDATE customer SET AVAILABLE = ? WHERE CUSTOMER_ID = ?";
			        PreparedStatement statement = connection.prepareStatement(sql);
			        statement.setString(1, newStatus);
			        statement.setInt(2, customerId);
			        statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} 
	      
	}	

}
