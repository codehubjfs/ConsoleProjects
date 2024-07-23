package com.bus.model;
import java.time.LocalDate;

	public class BusSearch {
	    private String startlocation;
	    private String endlocation;
	    private LocalDate travelDate;
	    private Bus bus;
	    private Routes routes;
	   
	    public String getStartlocation() {
			return startlocation;
		}

		public void setStartlocation(String startlocation) {
			this.startlocation = startlocation;
		}

		public String getEndlocation() {
			return endlocation;
		}

		public void setEndlocation(String endlocation) {
			this.endlocation = endlocation;
		}

		public LocalDate getTravelDate() {
	        return travelDate;
	    }

	    public void setTravelDate(LocalDate travelDate) {
	        this.travelDate = travelDate;
	    }

	    public Bus getBus() {
	        return bus;
	    }

	    public void setBus(Bus bus) {
	        this.bus = bus;
	    }

		public Routes getRoutes() {
			return routes;
		}

		public void setRoutes(Routes routes) {
			this.routes = routes;
		}
	    
	}