package com.ticket.model;

public class RoutesBean {
	private int index;
	private int route_id;
	private String startLocation;
	private String endLocation;
	private int estimatedDuration;
	private int distance;
	private int route_availabilty;
	
	public RoutesBean() {
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public int getEstimatedDuration() {
		return estimatedDuration;
	}
	public void setEstimatedDuration(int estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getRoute_availabilty() {
		return route_availabilty;
	}
	public void setRoute_availabilty(int route_availabilty) {
		this.route_availabilty = route_availabilty;
	}
}