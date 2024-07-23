package com.carrentalsystem.dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.carrentalsystem.beans.CarTemp;
import com.carrentalsystem.util.DBConnection;

	public class CarTempDao {
	    // Database connection parameters
	   // private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //dont know
	    //private static final String USERNAME = "your_username"; //set ur name
	    //private static final String PASSWORD = "your_password"; //set password

	    // SQL queries
		
	    private static final String SELECT_CARS_BY_TYPE = "SELECT * FROM cars WHERE car_type = ?";
	    private static final String SELECT_AVAILABLE_CARS_BY_TYPE = "SELECT * FROM cars WHERE car_type = ? AND available = 'yes'";

	    // Method to fetch cars by type
	    public List<CarTemp> getCarsByType(String carType) throws SQLException {
	    	
	        List<CarTemp> cars = new ArrayList<>();
	     
	        		Connection conn=DBConnection.openConnection();
	             PreparedStatement stmt = conn.prepareStatement(SELECT_CARS_BY_TYPE);
	            stmt.setString(1, carType);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                CarTemp car = mapResultSetToCar(rs);
	               
	                cars.add(car);
	            }
	        
	        return cars;
	    }

	    // Method to fetch available cars by type
	    public List<CarTemp> getAvailableCarsByType(String carType) throws SQLException {
	        List<CarTemp> cars = new ArrayList<>();
	        Connection conn=DBConnection.openConnection();
	             PreparedStatement stmt = conn.prepareStatement(SELECT_AVAILABLE_CARS_BY_TYPE);
	            stmt.setString(1, carType);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                CarTemp car = mapResultSetToCar(rs);
	                cars.add(car);
	            }
	       
	        return cars;
	    }
	    
	    public boolean isCarAvailable(String vehicleNo) throws SQLException {
	        String query = "SELECT AVAILABLE FROM CARS WHERE VEHICLE_NO = ? AND AVAILABLE = 'yes'";
	        try {PreparedStatement preparedStatement = DBConnection.openConnection().prepareStatement(query);
	            preparedStatement.setString(1, vehicleNo);
	        
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                return resultSet.next();
	            }
	    }catch(Exception e){
	    	
	    }
			return false;
	    }

	    // Helper method to map ResultSet to Car object
	    private CarTemp mapResultSetToCar(ResultSet rs) throws SQLException {
	        CarTemp car = new CarTemp();
	        System.out.print("carvisible");
	        car.setCar_id(rs.getInt("car_id"));
	        car.setCar_name(rs.getString("car_name"));
	        car.setVehicle_no(rs.getString("vehicle_no"));
	        car.setAvailable(rs.getString("available"));
	        car.setRental_rate(rs.getInt("rental_rate"));
	        car.setSeat_count(rs.getInt("seat_count"));
	        car.setFuel_type(rs.getString("fuel_type"));
	        car.setCar_type(rs.getString("car_type"));
	        car.setBags(rs.getInt("bags"));
	        car.setCar_image_url(rs.getString("car_image_url"));
	        return car;
	        //return car;
	    }
	}


