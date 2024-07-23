package bean;

import java.time.LocalDate;

public class BusSearch {
    private String source;
    private String destination;
    private LocalDate travelDate;
    private Bus bus;
    private RoutesBean routes;
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

	public RoutesBean getRoutes() {
		return routes;
	}

	public void setRoutes(RoutesBean routes) {
		this.routes = routes;
	}
    
}
