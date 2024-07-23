package com.carrentalsystem.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.carrentalsystem.dao; //can u import the dbconnection cls 
import com.carrentalsystem.util.DBConnection;
import com.carrentalsystem.beans.CarTemp;
public class AdminCarDao {

	private static final String INSERT_CAR_SQL = "INSERT INTO cars (car_id,car_name,vehicle_no,available,rental_rate,seat_count,fuel_type,car_type,bags,car_image_url) VALUES(?,?,?,?,?,?,?,?,?,?)";
	 private static final String SELECT_ALL_CARS = "SELECT * FROM cars order by car_id ";
	 private static final String UPDATE_CAR_SQL ="UPDATE cars SET car_name=?,vehicle_no=?,available = ? ,rental_rate = ? , seat_count =?,fuel_type =? ,car_type=?, bags =? , car_image_url =? WHERE car_id =?  ";
	 private static final String DELETE_CAR_SQL ="DELETE FROM cars WHERE car_id = ?";

	    public AdminCarDao() {
	    }
	    

	    public void insertCar(CarTemp car) throws Exception {
	        
	        	System.out.print("ins1");
	        	Connection connection = DBConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_SQL);
	            preparedStatement.setInt(1,43);
	            preparedStatement.setString(2, car.getCar_name());
	            preparedStatement.setString(3, car.getVehicle_no());
	            preparedStatement.setString(4, car.getAvailable());
	            preparedStatement.setInt(5, car.getRental_rate());
	            preparedStatement.setInt(6, car.getSeat_count());
	            preparedStatement.setString(7, car.getFuel_type());
	            preparedStatement.setString(8, car.getCar_type());
	            preparedStatement.setInt(9, car.getBags());
	            preparedStatement.setString(10, car.getCar_image_url());
	            System.out.print("ins2");
	            preparedStatement.executeUpdate();
	            System.out.println("Inserted");
	            
	       
	    }
	    
	    
	    public void updateCar(CarTemp car) throws SQLException {
	           System.out.println("edit come");
	        	Connection connection =DBConnection.openConnection(); 
	            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_SQL);
	            preparedStatement.setString(1, car.getCar_name());
	            preparedStatement.setString(2, car.getVehicle_no());
	            preparedStatement.setString(3, car.getAvailable());
	            preparedStatement.setInt(4, car.getRental_rate());
	            preparedStatement.setInt(5, car.getSeat_count());
	            preparedStatement.setString(6, car.getFuel_type());
	            preparedStatement.setString(7, car.getCar_type());
	            preparedStatement.setInt(8, car.getBags());
	            preparedStatement.setString(9, car.getCar_image_url());
	            preparedStatement.setInt(10, car.getCar_id());
	            System.out.println("updated1");
	            preparedStatement.executeUpdate();
	            System.out.println("updated");
	        
	    }
	    
	   
	    public void deleteCar(int car_id) throws SQLException {
	        Connection connection = DBConnection.openConnection(); 
	             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_SQL);
	            preparedStatement.setInt(1, car_id);
	            preparedStatement.executeUpdate();
	        
	    }
	    
	    
	    public static List<CarTemp> listCars() throws SQLException {
	        List<CarTemp> cars = new ArrayList<>();
	        
	        	Connection connection = DBConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARS);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                int car_id = rs.getInt("car_id");
	                String car_name = rs.getString("car_name");
	                String vehicle_no = rs.getString("vehicle_no");
	                String available = rs.getString("available");
	                int rental_rate = rs.getInt("rental_rate");
	                int seat_count = rs.getInt("seat_count");
	                String fuel_type = rs.getString("fuel_type");
	                String car_type = rs.getString("car_type");
	                int bags = rs.getInt("bags");
	                String car_image_url = rs.getString("car_image_url");
	                cars.add(new CarTemp(car_id, car_name, vehicle_no, available, rental_rate, seat_count, fuel_type,car_type,bags,car_image_url));
	                System.out.println(car_id+" "+vehicle_no);
	            }
	        
	        return cars;
	    }

}

    


    

    

    
    

   


