package com.hallbookingmanagement.controller;

import com.hallbookingmanagement.beans.Amenity;
import com.hallbookingmanagement.beans.Event;
import com.hallbookingmanagement.beans.Seats;
import com.hallbookingmanagement.dao.AmenityDAO;
import com.hallbookingmanagement.dao.EventDAO;
import com.hallbookingmanagement.dao.HallDAO;
import com.hallbookingmanagement.dao.SeatDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hallbookingmanagement.beans.Hall;

/**
 * Servlet implementation class AddHallServlet
 */


public class AddHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	String hallName = request.getParameter("hallName");
	        boolean isAc = request.getParameter("isAc").equals("yes");
	        double pricePerDay = Double.parseDouble(request.getParameter("pricePerDay"));
	        int  floatingCapacity = Integer.parseInt(request.getParameter("floatingCapacity"));
	        String location = request.getParameter("location");
	        String locationLink = request.getParameter("locationLink");
	        String[] amenities = request.getParameterValues("amenities");
	        String[] events = request.getParameterValues("events");
			int  theater = Integer.parseInt(request.getParameter("theater"));
	        int  cluster = Integer.parseInt(request.getParameter("cluster"));
	        int banquet = Integer.parseInt(request.getParameter("banquet"));
	        int uShaped = Integer.parseInt(request.getParameter("uShaped"));
	        int hallowSquare = Integer.parseInt(request.getParameter("hallowSquare"));
	        int cabaretStyle = Integer.parseInt(request.getParameter("cabaretStyle"));
	        
	        Hall hall = new Hall();

			//setting values to the hall object
	        hall.setHallName(hallName);
	        hall.setAcHall(isAc);
			hall.setPrice(pricePerDay);
			hall.setCapacity(floatingCapacity);
			hall.setLocation(location);
			hall.setLocationLink(locationLink);

			HashSet<Event> eventHashSet = new HashSet<>();
			EventDAO eventDAO = new EventDAO();
	        List<Event> eventList = null;
	        try {
	            eventList = eventDAO.getAll();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        
	        for(String event:events) {
	        	int eventId = -1;
	        	for(Event temp:eventList) {
	        		if(temp.getEventName().equals(event)) {
	        			Event eventObj = new Event();
	        			eventId=temp.getEventId();
	        			eventObj.setEventId(eventId);
	        			eventObj.setEventName(event);
	        			eventHashSet.add(eventObj);
	        			break;
	        		}
	        	}
	        }
	        hall.setEvents(eventHashSet);
			HashSet<Seats> seatList = new HashSet<>();
			Seats seat1 = new Seats();
			seat1.setSeatId(1);
			seat1.setArrangementType("Theater Style");
			seat1.setCapacity(theater);
			if(seat1.getCapacity()!=0) {
				seatList.add(seat1);
			}
			
			Seats seat2 = new Seats();
			seat2.setSeatId(10);
			seat2.setArrangementType("Cluster Style");
			seat2.setCapacity(cluster);
			
			if(seat2.getCapacity()!=0) {
				seatList.add(seat2);
			}
			Seats seat3 = new Seats();
			seat3.setSeatId(3);
			seat3.setArrangementType("Banquet Style");
			seat3.setCapacity(banquet);
			if(seat3.getCapacity()!=0) {
				seatList.add(seat3);
			}
			Seats seat4 = new Seats();
			seat4.setSeatId(4);
			seat4.setArrangementType("U-Shape Style");
			seat4.setCapacity(uShaped);
			if(seat4.getCapacity()!=0) {
				seatList.add(seat4);
			}
			Seats seat5 = new Seats();
			seat5.setSeatId(7);
			seat5.setArrangementType("Hollow Square Style");
			seat5.setCapacity(hallowSquare);
			if(seat5.getCapacity()!=0) {
				seatList.add(seat5);
			}
			Seats seat6 = new Seats();
			seat6.setSeatId(6);
			seat6.setArrangementType("Cabaret Style");
			seat6.setCapacity(cabaretStyle);
			if(seat6.getCapacity()!=0) {
				seatList.add(seat6);
			}
			
			hall.setSeat(seatList);// Setting Seats
			HashSet<Amenity> amenitiesList = new HashSet<>();
			try {
			for(String amenity:amenities){
                    for(Amenity amenityObj: new AmenityDAO().getAll()){
                        if(amenityObj.getAmenityType().equals(amenity)){
							amenitiesList.add(amenityObj);
						}
                    }
                }
            }catch (SQLException e) {
				throw new RuntimeException(e);
			}
			hall.setAmenities(amenitiesList);// Setting  amenties List
	        try {
	            boolean isAdded = new HallDAO().add(hall);
				if(isAdded){
					System.out.println("Added success fully");
					request.getRequestDispatcher("HallManagementServlet").forward(request, response);			
					}
				else{
					System.out.println("Not Added successfully");
				}
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	    }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
