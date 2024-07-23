package com.carrentalsystem.beans;

public class PackageDetails {
    private int packageDetailsId;
    private int duration;
    private String carType;
    private double amount;
    private int packageId;

    // Constructors

    public PackageDetails() {
        // Default constructor
    }

    // Getters and Setters

    public int getPackageDetailsId() {
        return packageDetailsId;
    }

    public void setPackageDetailsId(int packageDetailsId) {
        this.packageDetailsId = packageDetailsId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }
}
