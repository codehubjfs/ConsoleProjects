package com.carrentalsystem.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.beans.Car;
import com.carrentalsystem.util.DBConnection;


public class CarDao {

    public List<Car> getAllCars() throws SQLException {
        List<Car> listCar = new ArrayList<>();

        String sql = "SELECT * FROM CARS";

       
        	Connection connection = DBConnection.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	System.out.print("car card");
                int id = resultSet.getInt("CAR_ID");
                String carName = resultSet.getString("CAR_NAME");
                String vehicleNo = resultSet.getString("VEHICLE_NO");
                String available = resultSet.getString("AVAILABLE");
                double rentalRate = resultSet.getDouble("RENTAL_RATE");
                int seatCount = resultSet.getInt("SEAT_COUNT");
                String fuelType = resultSet.getString("FUEL_TYPE");
                String carType = resultSet.getString("CAR_TYPE");
                int bags = resultSet.getInt("BAGS");
                String carImageUrl = resultSet.getString("CAR_IMAGE_URL");

                Car car = new Car(id, carName, vehicleNo, available, rentalRate, seatCount, fuelType, carType, bags, carImageUrl);
                listCar.add(car);
            }

        

        return listCar;
    }
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
    public Car getCar(int id) throws SQLException {
        Car car = null;
               Connection connection = DBConnection.openConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CAR_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String carName = rs.getString("carName");
                String vehicleNo = rs.getString("vehicleNo");
                String available = rs.getString("available");
                double rentalRate = rs.getDouble("rentalRate");
                int seatCount = rs.getInt("seatCount");
                String fuelType = rs.getString("fuelType");
                String carType = rs.getString("carType");
                int bags = rs.getInt("bags");
                String carImageUrl = rs.getString("carImageUrl");
                //System.out.print("hhgi"+available);
                car = new Car(id, carName, vehicleNo, available, rentalRate, seatCount, fuelType, carType, bags, carImageUrl);
            }
       
        return car;
    }

    public void saveCar(Car car) throws SQLException {
        String sql = "INSERT INTO CARS (CAR_NAME, VEHICLE_NO, AVAILABLE, RENTAL_RATE, SEAT_COUNT, FUEL_TYPE, CAR_TYPE, BAGS, CAR_IMAGE_URL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Validate the input
       
        validateInput(car);

       
        	Connection connection = DBConnection.openConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.print("work2");
            statement.setString(1, car.getCarName());
            statement.setString(2, car.getVehicleNo());
            statement.setString(3, car.getAvailable());
            statement.setDouble(4, car.getRentalRate());
            statement.setInt(5, car.getSeatCount());
            statement.setString(6, car.getFuelType());
            statement.setString(7, car.getCarType());
            statement.setInt(8, car.getBags());
            statement.setString(9, car.getCarImageUrl());
            System.out.print("work3");
            statement.executeUpdate();
            System.out.print("work4");

       
    }

    private void validateInput(Car car) throws IllegalArgumentException {
        if (car.getCarName() == null || car.getCarName().isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty");
        }
        if (car.getVehicleNo() == null || car.getVehicleNo().isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be null or empty");
        }
        if (car.getAvailable() == null || (!car.getAvailable().equalsIgnoreCase("true") && !car.getAvailable().equalsIgnoreCase("false"))) {
            throw new IllegalArgumentException("Available must be 'true' or 'false'");
        }
        if (car.getRentalRate() <= 0) {
            throw new IllegalArgumentException("Rental rate must be greater than zero");
        }
        if (car.getSeatCount() <= 0) {
            throw new IllegalArgumentException("Seat count must be greater than zero");
        }
        if (car.getFuelType() == null || car.getFuelType().isEmpty()) {
            throw new IllegalArgumentException("Fuel type cannot be null or empty");
        }
        if (car.getCarType() == null || car.getCarType().isEmpty()) {
            throw new IllegalArgumentException("Car type cannot be null or empty");
        }
        if (car.getBags() < 0) {
            throw new IllegalArgumentException("Bags cannot be negative");
        }
        if (car.getCarImageUrl() == null || car.getCarImageUrl().isEmpty()) {
            throw new IllegalArgumentException("Car image URL cannot be null or empty");
        }
    }



    public void updateCar(Car car) throws SQLException {
        String sql = "UPDATE CARS SET CAR_NAME = ?, VEHICLE_NO = ?, AVAILABLE = ?, RENTAL_RATE = ?, SEAT_COUNT = ?, FUEL_TYPE = ?, CAR_TYPE = ?, BAGS = ?, CAR_IMAGE_URL = ? WHERE CAR_ID = ?";
        Connection connection = DBConnection.openConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, car.getCarName());
            statement.setString(2, car.getVehicleNo());
            statement.setString(3, car.getAvailable());
            statement.setDouble(4, car.getRentalRate());
            statement.setInt(5, car.getSeatCount());
            statement.setString(6, car.getFuelType());
            statement.setString(7, car.getCarType());
            statement.setInt(8, car.getBags());
            statement.setString(9, car.getCarImageUrl());
            statement.setInt(10, car.getCarId());
            statement.executeUpdate();     
    }

    public void deleteCar(int carId) throws SQLException {
             String sql = "DELETE FROM CARS WHERE CAR_ID = ?";
             Connection connection = DBConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, carId);
             statement.executeUpdate();       
    }
}
