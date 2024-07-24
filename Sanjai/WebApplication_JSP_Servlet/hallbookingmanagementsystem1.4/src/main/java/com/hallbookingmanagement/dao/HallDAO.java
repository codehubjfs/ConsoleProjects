package com.hallbookingmanagement.dao;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Amenity;
import com.hallbookingmanagement.beans.Event;
import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.beans.Seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class HallDAO implements DAO<Hall>{
    @Override
    public List<Hall> getAll() {
        List<Hall> listHall = new ArrayList<>();
        try {
            String hallQuery = "SELECT hall_id, hall_name, HALL_PRICE, IS_AC, HALLCAPACITY, HALLAVAIL, location,HALL_LINK FROM halls";
            String eventsQuery = "SELECT e.event_id, e.event_name FROM event e JOIN book_event be ON e.event_id = be.event_id WHERE be.hall_id = ?";
            String seatQuery = "SELECT sa.ARRANGEMENT_ID, sa.arrangement_type, hs.capacity FROM Hall_Seating hs JOIN Seating_Arrangement sa ON hs.arrangement_id = sa.arrangement_id WHERE hs.hall_id = ?";
            String amenityQuery = "SELECT a.amenity_id, a.amenity_name, h.hall_id FROM AMENITIES a JOIN AMENTIES_HALL ah ON a.amenity_id = ah.amenity_id JOIN HALLS h ON ah.hall_id = h.hall_id WHERE h.hall_id = ?";
            Connection connection = DBConnection.getInstance().getConnection();
            if (connection == null) {
                throw new SQLException("Failed to obtain database connection.");
            }

            PreparedStatement hallStatement = connection.prepareStatement(hallQuery);
            ResultSet hallSet = hallStatement.executeQuery();

            while (hallSet.next()) {
                int hallId = hallSet.getInt("hall_id");
                String hallName = hallSet.getString("hall_name");
                float hallPrice = hallSet.getFloat("HALL_PRICE");
                boolean isAc = hallSet.getString("IS_AC").equals("Yes");
                boolean isAvail = hallSet.getString("HALLAVAIL").equals("A");
                int hallCapacity = hallSet.getInt("HALLCAPACITY");
                String location = hallSet.getString("location");
                String locationLink = hallSet.getNString("HALL_LINK");

                // Statement to select the event
                PreparedStatement eventStatement = connection.prepareStatement(eventsQuery);
                eventStatement.setInt(1, hallId);
                ResultSet eventSet = eventStatement.executeQuery();
                LinkedHashSet<Event> eventHashSet = new LinkedHashSet<>();
                while (eventSet.next()) {
                    int eventId = eventSet.getInt("event_id");
                    String eventName = eventSet.getString("event_name");
                    Event event = new Event();
                    event.setEventId(eventId);
                    event.setEventName(eventName);
                    eventHashSet.add(event);
                }

                // Statement to select the seat
                PreparedStatement seatStatement = connection.prepareStatement(seatQuery);
                seatStatement.setInt(1, hallId);
                ResultSet seatSet = seatStatement.executeQuery();
                LinkedHashSet<Seats> seatHashSet = new LinkedHashSet<>();
                while (seatSet.next()) {
                    int arrangementId = seatSet.getInt("ARRANGEMENT_ID");
                    String arrangementType = seatSet.getString("arrangement_type");
                    int arrangementCapacity = seatSet.getInt("capacity");
                    seatHashSet.add(new Seats(arrangementId, arrangementType, arrangementCapacity));
                }

                // Statement to select amenities
                PreparedStatement amenityStatement = connection.prepareStatement(amenityQuery);
                amenityStatement.setInt(1, hallId);
                ResultSet amenitySet = amenityStatement.executeQuery();
                LinkedHashSet<Amenity> amenityHashSet = new LinkedHashSet<>();
                while (amenitySet.next()) {
                    int amenityId = amenitySet.getInt("amenity_id");
                    String amenityType = amenitySet.getString("amenity_name");
                    Amenity amenity = new Amenity();
                    amenity.setAmenityId(amenityId);
                    amenity.setAmenityType(amenityType);
                    amenityHashSet.add(amenity);
                }

                Hall hall = new Hall();
                hall.setAvail(isAvail);
                hall.setHallId(hallId);
                hall.setHallName(hallName);
                hall.setPrice(hallPrice);
                hall.setAcHall(isAc);
                hall.setCapacity(hallCapacity);
                hall.setLocation(location);
                hall.setAmenities(amenityHashSet);
                hall.setSeat(seatHashSet);
                hall.setEvents(eventHashSet);
                hall.setLocationLink(locationLink);
                listHall.add(hall);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return listHall;
    }
    
    
    @Override
    public boolean add(Hall hall) throws SQLException {
    	PrimaryKeyProvider primaryKey = new PrimaryKeyProvider();
        hall.setHallId(primaryKey.primaryKey("halls"));
        String insertQuery = "INSERT INTO halls (hall_id, hall_name, hall_price, is_Ac, hallAvail, hallCapacity,location,location_link) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(insertQuery);
        statement.setInt(1,hall.getHallId());
        statement.setString(2, hall.getHallName());
        statement.setDouble(3,hall.getPrice());
        statement.setString(4,hall.getIsAcHall()?"Yes":"No");
        statement.setString(5,"A");
        statement.setInt(6,hall.getCapacity());
        statement.setString(7,hall.getLocation());
        statement.setString(8,hall.getLocationLink());
        if(statement.executeUpdate()==0){
            return false;
        }

        String insertAmenities = "INSERT INTO amenties_hall (hall_id, amenity_id) VALUES (?, ?)";
        PreparedStatement amenitiesStatement = DBConnection.getInstance().getConnection().prepareStatement(insertAmenities);
        boolean amenityUpdate = false;
        for(Amenity amenity : hall.getAmenities()){
            amenitiesStatement.setInt(1,hall.getHallId());
            amenitiesStatement.setInt(2,amenity.getAmenityId());
            if(amenitiesStatement.executeUpdate()==0){
                return false;
            }
        }
        String insertEvents = "INSERT INTO book_event (hall_id, event_id) VALUES (?,?)";
        PreparedStatement eventsStatement = DBConnection.getInstance().getConnection().prepareStatement(insertEvents);

        for(Event event: hall.getEvents()){
            eventsStatement.setInt(1,hall.getHallId());
            eventsStatement.setInt(2,event.getEventId());
            if(eventsStatement.executeUpdate()==0){
                return false;
            }
        }
        String insertSeating = "Insert INTO HALL_SEATING (hall_id, ARRANGEMENT_ID, CAPACITY) values (?,?,?)";
        PreparedStatement seatingStatement = DBConnection.getInstance().getConnection().prepareStatement(insertSeating);
        for(Seats seats: hall.getSeat()){
            seatingStatement.setInt(1,hall.getHallId());
            seatingStatement.setInt(2,seats.getSeatId());
            seatingStatement.setInt(3,seats.getCapacity());
            if(seatingStatement.executeUpdate()==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delete(Hall hall) throws SQLException {
            String deleteQuery = "Update halls set HALLAVAIL = 'N' where hall_id = ?";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
            statement.setInt(1, hall.getHallId());
            return statement.executeUpdate()>0?true:false;
    }
    
    public boolean updateHall(Hall hall) throws SQLException  {
    	 String deleteQuery = "Update halls set HALL_NAME = ?,HALL_PRICE = ?,HALLCAPACITY =?,LOCATION = ?,LOCATION_LINK=? where hall_id = ?";
         PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
         statement.setString(1, hall.getHallName());
         statement.setDouble(2, hall.getPrice());
         statement.setInt(3,hall.getCapacity());
         statement.setString(4,hall.getLocation());
         statement.setString(5, hall.getLocationLink());
         statement.setInt(6, hall.getHallId());
         return statement.executeUpdate()>0?true:false;
    }
}
