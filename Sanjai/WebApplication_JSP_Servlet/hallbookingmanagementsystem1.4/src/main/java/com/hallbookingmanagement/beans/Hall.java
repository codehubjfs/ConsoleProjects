package com.hallbookingmanagement.beans;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents a hall in the hall booking system.
 * A hall has properties like hall ID, name, price, AC availability,
 * capacity, availability status, a set of seats it contains,
 * and a set of events associated with it.
 * @author Sanjai
 * @since 13-May-2024
 */
public class Hall implements Comparable<Hall>{
    public  int hallId;
    private String hallName;
    private double price;
    private boolean isAcHall;
    private int capacity;
    private boolean isAvail;
    public String location;
    private String locationLink;
	private HashSet<Amenity> amenities;
    private HashSet<Seats> seat;
    private HashSet<Event> events;


    // Empty constructor (for potential object initialization)
    public Hall(){};

    public void setAvail(boolean avail) {
        isAvail = avail;
    }


    // Getters and setters for all member variables
    public boolean isAcHall() {
        return isAcHall;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setAcHall(boolean acHall) {
        isAcHall = acHall;
    }

    public boolean getIsAvail() {
        return isAvail;
    }

    public void setiSavail(boolean iSavail) {
        this.isAvail = iSavail;
    }

    public String getHallName() {
        return hallName;
    }

    public boolean getIsAcHall() {
        return isAcHall;
    }

    public void setIsAcHall(boolean airCooler) {
        isAcHall = airCooler;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }


    public double getPrice() {
        return  price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public HashSet<Seats> getSeat() {
        return seat;
    }

    public void setSeat(LinkedHashSet<Seats> seat) {
        this.seat = seat;
    }

    public HashSet<Event> getEvents() {
        return events;
    }

    public HashSet<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(HashSet<Amenity> amenities) {
        this.amenities = amenities;
    }

    public void setSeat(HashSet<Seats> seat) {
        this.seat = seat;
    }

    public void setEvents(HashSet<Event> events) {
        this.events = events;
    }


    public void setEvents(LinkedHashSet<Event> events) {
        this.events = events;
    }
    // Implements Comparable interface for sorting halls based on capacity (descending order)
    @Override
    public int compareTo(Hall hall) {
        return hall.getCapacity()-this.getCapacity();
    }
    
    public String getLocationLink() {
		return locationLink;
	}

	public void setLocationLink(String locationLink) {
		this.locationLink = locationLink;
	}

    @Override
    public String toString() {
        return "Hall{" +
                "hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                ", isAcHall=" + isAcHall +
                ", capacity=" + capacity +
                ", isAvail=" + isAvail +
                ", seat=" + seat +
                ", events=" + events +
                '}';
    }
}
