package com.ticket.model;

public class BusStop {
	private int stopId;
    private String pickupPoint;
    private String droppingPoint;
    private RoutesBean route;
    private Bus bus;
	
	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}
	

	public RoutesBean getRoute() {
		return route;
	}

	public void setRoute(RoutesBean route) {
		this.route = route;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusStop [stopId=" + stopId + ", pickupPoint=" + pickupPoint + ", droppingPoint=" + droppingPoint
				+ ", route=" + route + ", bus=" + bus + "]";
	}



	
}

