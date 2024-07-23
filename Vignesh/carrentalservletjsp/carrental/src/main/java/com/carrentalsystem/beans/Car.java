package com.carrentalsystem.beans;



public class Car {
    private int carId;
    private String carName;
    private String vehicleNo;
    private String available;
    private double rentalRate;
    private int seatCount;
    private String fuelType;
    private String carType;
    private int bags;
    private String carImageUrl;

    // Constructors, getters, and setters

    public Car() {}

    public Car(int carId, String carName, String vehicleNo, String available, double rentalRate, int seatCount, String fuelType, String carType, int bags, String carImageUrl) {
        this.carId = carId;
        this.carName = carName;
        this.vehicleNo = vehicleNo;
        this.available = available;
        this.rentalRate = rentalRate;
        this.seatCount = seatCount;
        this.fuelType = fuelType;
        this.carType = carType;
        this.bags = bags;
        this.carImageUrl = carImageUrl;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public String getCarImageUrl() {
        return carImageUrl;
    }

    public void setCarImageUrl(String carImageUrl) {
        this.carImageUrl = carImageUrl;
    }
}
