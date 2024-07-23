package com.hallbookingsystem.halldetails;


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
    private float price;
    private boolean isAcHall;
    private int capacity;
    private boolean isAvail;
    private HashSet<Amenity> amenities;


    private HashSet<Seats> seat;
    private HashSet<Events> events;

    // Constructor with all parameters (including seat and event sets)
    public Hall(int hallKey,String hallName, float price, boolean isAcHall, boolean isAvail, int capacity, LinkedHashSet<Amenity> amenities,  LinkedHashSet<Seats> seat, LinkedHashSet<Events> events) {
        this.hallId = hallKey;
        this.hallName = hallName;
        this.price = price;
        this.isAcHall = isAcHall;
        this.isAvail = isAvail;
        this.capacity = capacity;
        this.amenities=amenities;
        this.seat = seat;
        this.events = events;
    }
    // Empty constructor (for potential object initialization)
    public Hall(){};

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public Hall(int hallId, String hallName, float price, boolean isAcHall, int capacity, boolean isAvail) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.price = price;
        this.isAcHall = isAcHall;
        this.capacity = capacity;
        this.isAvail = isAvail;
    }

    public Hall(String hallName, float price, int capacity, boolean isAcHall) {
        this.hallName = hallName;
        this.price = price;
        this.isAcHall = isAcHall;
        this.capacity = capacity;
    }

    public void setAvail(boolean avail) {
        isAvail = avail;
    }

    public Hall(String hallName, float price, int capacity, boolean isAcHall, boolean isAvail) {
        this.hallName = hallName;
        this.price = price;
        this.isAcHall = isAcHall;
        this.capacity = capacity;
        this.isAvail = isAvail;
    }

    // Getters and setters for all member variables

    public boolean isAcHall() {
        return isAcHall;
    }

    public void setAcHall(boolean acHall) {
        isAcHall = acHall;
    }

    public boolean isAvail() {
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


    public float getPrice() {
        return  price;
    }

    public void setPrice(float price) {
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

    public HashSet<Events> getEvents() {
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

    public void setEvents(HashSet<Events> events) {
        this.events = events;
    }


    public void setEvents(LinkedHashSet<Events> events) {
        this.events = events;
    }
    // Implements Comparable interface for sorting halls based on capacity (descending order)
    @Override
    public int compareTo(Hall hall) {
        return hall.getCapacity()-this.getCapacity();
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
