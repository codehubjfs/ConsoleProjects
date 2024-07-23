package com.carrentalsystem.beans;

public class CarTemp {
     private int car_id; //1
     private String car_name; //audi
     private String vehicle_no; //TN99
     private String available; //yes or no
     private int rental_rate; //677
     private int seat_count;  //2 (enough)
     private String fuel_type; //petrol or diesel
     private String car_type;  //sedan,suv,luxury
     private int bags; //20
     private String car_image_url; //url of image 
	public int getCar_id() {
		return car_id;
	}
	public CarTemp() {
		super();
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_name() {
		return car_name;
	}
	public CarTemp(int car_id, String car_name, String vehicle_no, String available, int rental_rate, int seat_count,
			String fuel_type, String car_type, int bags, String car_image_url) {
		super();
		this.car_id = car_id;
		this.car_name = car_name;
		this.vehicle_no = vehicle_no;
		this.available = available;
		this.rental_rate = rental_rate;
		this.seat_count = seat_count;
		this.fuel_type = fuel_type;
		this.car_type = car_type;
		this.bags = bags;
		this.car_image_url = car_image_url;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public int getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(int rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getSeat_count() {
		return seat_count;
	}
	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public int getBags() {
		return bags;
	}
	public void setBags(int bags) {
		this.bags = bags;
	}
	public String getCar_image_url() {
		return car_image_url;
	}
	public void setCar_image_url(String car_image_url) {
		this.car_image_url = car_image_url;
	}
}
