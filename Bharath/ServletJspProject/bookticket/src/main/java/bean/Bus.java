package bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Bus {
	private int busid;
	private String busName;
	private String busType;
	private int busCapacity;
	private int busFare;
	private LocalDate dateOfBus;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private RoutesBean route;
	  private String formattedDepartureDate;
	    private String formattedDepartureTime;
	    private String formattedArrivalDate;
	    private String formattedArrivalTime;
	    public String getFormattedDepartureDate() {
	        return formattedDepartureDate;
	    }

	    public void setFormattedDepartureDate(String formattedDepartureDate) {
	        this.formattedDepartureDate = formattedDepartureDate;
	    }

	    public String getFormattedDepartureTime() {
	        return formattedDepartureTime;
	    }

	    public void setFormattedDepartureTime(String formattedDepartureTime) {
	        this.formattedDepartureTime = formattedDepartureTime;
	    }

	    public String getFormattedArrivalDate() {
	        return formattedArrivalDate;
	    }

	    public void setFormattedArrivalDate(String formattedArrivalDate) {
	        this.formattedArrivalDate = formattedArrivalDate;
	    }

	    public String getFormattedArrivalTime() {
	        return formattedArrivalTime;
	    }

	    public void setFormattedArrivalTime(String formattedArrivalTime) {
	        this.formattedArrivalTime = formattedArrivalTime;
	    }

	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getBusCapacity() {
		return busCapacity;
	}
	public void setBusCapacity(int busCapacity) {
		this.busCapacity = busCapacity;
	}
	public int getBusFare() {
		return busFare;
	}
	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}

	public LocalDate getDateOfBus() {
		return dateOfBus;
	}
	public void setDateOfBus(LocalDate dateOfBus) {
		this.dateOfBus = dateOfBus;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public RoutesBean getRoute() {
		return route;
	}
	public void setRoute(RoutesBean route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "\nBus [busid=" + busid + ", busName=" + busName + ", busType=" + busType + ", busCapacity=" + busCapacity
				+ ", busFare=" + busFare + ", dateOfBus=" + dateOfBus + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", route=" + route + "]";
	}	
}
		