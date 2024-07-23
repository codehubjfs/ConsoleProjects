//package com.bookingbus;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import com.adminutility.Route;
//import com.persondetails.BusOperator;
//
//public class Bus {
//	private int busid;
//	private String busName;
//	private String busType;
//	private int busCapacity;
//	private int busFare;
//	private int routeId;
//	private int operId;
//	private LocalDate dateOfBus;
//	private LocalTime departureTime;
//	private LocalTime arrivalTime;
//	private String busAvailability;
//	private Route route; //Association
//
//	public Bus(int busid, String busName, String busType, int busCapacity, int busFare, int routeId, int operId,LocalDate dateOfBus,
//			LocalTime departureTime, LocalTime arrivalTime,String busAvailability) {
//		super();
//		this.busid = busid;
//		this.busName = busName;
//		this.busType = busType;
//		this.busCapacity = busCapacity;
//		this.busFare = busFare;
//		this.routeId = routeId;
//		this.operId = operId;
//		this.dateOfBus=dateOfBus;
//		this.departureTime = departureTime;
//		this.arrivalTime = arrivalTime;
//		this.busAvailability=busAvailability;
//	}
//
//	public Bus(int busid, String busName, String busType, int busCapacity, int busFare,LocalDate dateOfBus, Route route) {
//		super();
//		this.busid = busid;
//		this.busName = busName;
//		this.busType = busType;
//		this.busCapacity = busCapacity;
//		this.busFare = busFare;
//		this.route = route;
//		this.dateOfBus = dateOfBus;
//	}
//	
//	//for bus operator 
//	public Bus(int busid, String busName, String busType, int busCapacity, int busFare, Route route,
//			BusOperator operator) {
//		super();
//		this.busid = busid;
//		this.busName = busName;
//		this.busType = busType;
//		this.busCapacity = busCapacity;
//		this.busFare = busFare;
//		this.route = route;
//	}
//
//	public Bus(int busid, String busName, String busType, int busCapacity) {
//		super();
//		this.busid = busid;
//		this.busName = busName;
//		this.busType = busType;
//		this.busCapacity = busCapacity;
//	}
//
//	public Bus() {
//		// TODO Auto-generated constructor stub
//	}
//	public Bus(int busid, String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime, LocalTime arrivalTime) {
//		super();
//		this.busid = busid;
//		this.busName = busName;
//		this.busType = busType;
//		this.busCapacity = busCapacity;
//		this.busFare = busFare;
//		this.dateOfBus = dateOfBus;
//		this.departureTime=departureTime;
//		this.arrivalTime=arrivalTime;
//	}
//
//	public Bus(String busName) {
//			this.busName=busName;
//	}
//	public Bus(String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime,LocalTime arrivalTime) {
//		this.busName = busName;
//		this.busType = busType;
//		this.busCapacity = busCapacity;
//		this.busFare = busFare;
//		this.dateOfBus = dateOfBus;
//		this.departureTime=departureTime;
//		this.arrivalTime=arrivalTime;
//	}
//
//	public Route getRoute() {
//		return route;
//	}
//
//	public void setRoute(Route route) {
//		this.route = route;
//	}
//	public int getBusid() {
//		return busid;
//	}
//
//	public int getBusFare() {
//		return busFare;
//	}
//
//	public int getRouteId() {
//		return routeId;
//	}
//
//	public void setRouteId(int routeId) {
//		this.routeId = routeId;
//	}
//
//	public int getOperId() {
//		return operId;
//	}
//
//	public void setOperId(int operId) {
//		this.operId = operId;
//	}
//
//	public void setBusFare(int busFare) {
//		this.busFare = busFare;
//	}
//
//	public void setBusid(int busid) {
//		this.busid = busid;
//	}
//
//	public String getBusName() {
//		return busName;
//	}
//
//	public void setBusName(String busName) {
//		this.busName = busName;
//	}
//
//	public String getBusType() {
//		return busType;
//	}
//
//	public void setBusType(String busType) {
//		this.busType = busType;
//	}
//
//	public int getBusCapacity() {
//		return busCapacity;
//	}
//
//	public void setBusCapacity(int busCapacity) {
//		this.busCapacity = busCapacity;
//	}
//	
//	public LocalTime getDepartureTime() {
//		return departureTime;
//	}
//
//	public void setDepartureTime(LocalTime departureTime) {
//		this.departureTime = departureTime;
//	}
//
//	public LocalTime getArrivalTime() {
//		return arrivalTime;
//	}
//
//	public void setArrivalTime(LocalTime arrivalTime) {
//		this.arrivalTime = arrivalTime;
//	}
//	
//	public LocalDate getDateOfBus() {
//		return dateOfBus;
//	}
//
//	public void setDateOfBus(LocalDate dateOfBus) {
//		this.dateOfBus = dateOfBus;
//	}
//
//	public String getBusAvailability() {
//		return busAvailability;
//	}
//
//	public void setBusAvailability(String busAvailability) {
//		this.busAvailability = busAvailability;
//	}
//
//	@Override
//	public String toString() {
//		return "Bus [busid=" + busid + ", busName=" + busName + ", busType=" + busType + ", busCapacity=" + busCapacity
//				+ "]";
//	}
//
//	
//}
package com.bookingbus;
import java.time.LocalDate;
import java.time.LocalTime;

import com.adminutility.Route;
import com.persondetails.BusOperator;

public class Bus {
    private int busid;
    private String busName;
    private String busType;
    private int busCapacity;
    private int busFare;
    private int routeId;
    private int operId;
    private LocalDate dateOfBus;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String busAvailability;
    private Route route; // Association
    public Bus(int busid, String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime,
			LocalTime arrivalTime, String busAvailability) {
    	 this.busid = busid;
         this.busName = busName;
         this.busType = busType;
         this.busCapacity = busCapacity;
         this.busFare = busFare;
//         this.routeId = routeId;
//         this.operId = operId;
         this.dateOfBus = dateOfBus;
         this.departureTime = departureTime;
         this.arrivalTime = arrivalTime;
         this.busAvailability = busAvailability;
	}

    public Bus(int busid, String busName, String busType, int busCapacity, int busFare, int routeId, int operId, LocalDate dateOfBus,
               LocalTime departureTime, LocalTime arrivalTime, String busAvailability) {
        this.busid = busid;
        this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.routeId = routeId;
        this.operId = operId;
        this.dateOfBus = dateOfBus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busAvailability = busAvailability;
    }

    public Bus(int busid, String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, Route route) {
        super();
        this.busid = busid;
        this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.route = route;
        this.dateOfBus = dateOfBus;
    }

    // For bus operator 
    public Bus(int busid, String busName, String busType, int busCapacity, int busFare, Route route, BusOperator operator) {
        super();
        this.busid = busid;
        this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.route = route;
    }

    public Bus(int busid, String busName, String busType, int busCapacity) {
        super();
        this.busid = busid;
        this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
    }
    public Bus(int busid, String busName, int busFare, String busType) {
      
        this.busid = busid;
        this.busName = busName;
        this.busFare = busFare;
        this.busType = busType;
    }
    public Bus() {
        // Default constructor
    }
   
    public Bus(int busid, String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime, LocalTime arrivalTime) {
        super();
        this.busid = busid;
        this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.dateOfBus = dateOfBus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Bus(String busName) {
        this.busName = busName;
    }

//    public Bus(String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime, LocalTime arrivalTime) {
//        this.busName = busName;
//        this.busType = busType;
//        this.busCapacity = busCapacity;
//        this.busFare = busFare;
//        this.dateOfBus = dateOfBus;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//    }


	public Bus(String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus) {
		// TODO Auto-generated constructor stub
		this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.dateOfBus = dateOfBus;
	}

	public Bus(String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime,
			LocalTime arrivalTime) {
	 	this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.dateOfBus = dateOfBus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
	}

	public Bus(String busName, String busType, int busCapacity, int busFare, LocalDate dateOfBus, LocalTime departureTime,
			LocalTime arrivalTime, String busAvailability) {
		this.busName = busName;
        this.busType = busType;
        this.busCapacity = busCapacity;
        this.busFare = busFare;
        this.dateOfBus = dateOfBus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busAvailability=busAvailability;
	}

	
	// Getters and setters
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getOperId() {
        return operId;
    }

    public void setOperId(int operId) {
        this.operId = operId;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getDateOfBus() {
        return dateOfBus;
    }

    public void setDateOfBus(LocalDate dateOfBus) {
        this.dateOfBus = dateOfBus;
    }

    public String getBusAvailability() {
        return busAvailability;
    }

    public void setBusAvailability(String busAvailability) {
        this.busAvailability = busAvailability;
    }

    @Override
    public String toString() {
        return "Bus [busid=" + busid + ", busName=" + busName + ", busType=" + busType + ", busCapacity=" + busCapacity + "]";
    }
}
