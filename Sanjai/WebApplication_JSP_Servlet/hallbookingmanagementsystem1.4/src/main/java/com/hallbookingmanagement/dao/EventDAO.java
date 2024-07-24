package com.hallbookingmanagement.dao;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Event;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO implements DAO<Event> {

    @Override
    public List<Event> getAll() throws SQLException {
        List<Event> eventList = new ArrayList<>();
        String eventsQuery = "SELECT event_id, event_name FROM event";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(eventsQuery);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Event event = new Event();
            event.setEventId(resultSet.getInt("event_id"));
            event.setEventName(resultSet.getString("event_name"));
            eventList.add(event);
        }
        return eventList;
    }

    @Override
    public boolean add(Event event) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Event event) throws SQLException {
        return false;
    }
}
