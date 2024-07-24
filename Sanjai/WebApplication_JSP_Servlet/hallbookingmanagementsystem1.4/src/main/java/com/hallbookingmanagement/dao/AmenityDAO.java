package com.hallbookingmanagement.dao;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Amenity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmenityDAO implements DAO<Amenity>{
    @Override
    public List<Amenity> getAll() throws SQLException {
        List<Amenity> list = new ArrayList<>();
        String query = "select * from amenities";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Amenity amenity = new Amenity();
            amenity.setAmenityId(set.getInt("amenity_id"));
            amenity.setAmenityType(set.getString("amenity_name"));
            list.add(amenity);
        }
        return list;
    }

    @Override
    public boolean add(Amenity amenity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Amenity amenity) throws SQLException {
        return false;
    }
}
