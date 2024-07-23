package com.adminutility;

public class Route {
	private int route_id;
	private String startingLocation;
	private String destination;
	private int distance;
	private int estimatedDuration;
	private String availability;

	public Route() {
		super();
	}

	public Route(int route_id, String startingLocation, String destination, int distance, int estimatedDuration,
			String availability) {
		super();
		this.route_id = route_id;
		this.startingLocation = startingLocation;
		this.destination = destination;
		this.distance = distance;
		this.estimatedDuration = estimatedDuration;
		this.availability = availability;
	}

	public Route(int route_id, String startingLocation, String destination, int distance, int estimatedDuration) {
		super();
		this.route_id = route_id;
		this.startingLocation = startingLocation;
		this.destination = destination;
		this.distance = distance;
		this.estimatedDuration = estimatedDuration;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public String getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getEstimatedDuration() {
		return estimatedDuration;
	}

	public void setEstimatedDuration(int duration) {
		this.estimatedDuration = duration;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Route [route_id=" + route_id + ", startingLocation=" + startingLocation + ", destination=" + destination
				+ ", distance=" + distance + ", estimatedDuration=" + estimatedDuration + "]";
	}
}
