package com.hallbookingmanagement.dao;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Seats;
import com.hallbookingmanagement.beans.Seats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO implements  DAO<Seats>{

    @Override
    public List<Seats> getAll() throws SQLException {
        List<Seats> eventList = new ArrayList<>();
        String eventsQuery = "SELECT arrangement_id, arrangement_type FROM Seating_Arrangement ";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(eventsQuery);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Seats event = new Seats();
            event.setSeatId(resultSet.getInt("arrangement_id"));
            event.setArrangementType(resultSet.getString("arrangement_type"));
            eventList.add(event);
        }
        return eventList;
    }

    @Override
    public boolean add(Seats seat) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Seats seat) throws SQLException {
        return false;
    }
}
