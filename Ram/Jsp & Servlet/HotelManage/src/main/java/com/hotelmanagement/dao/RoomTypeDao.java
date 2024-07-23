package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.utilities.DbUtil;

public class RoomTypeDao {
    
    public RoomTypeDao() {
        
    }

    public void addRoomType(RoomType roomType) {
        String sql = "INSERT INTO rt (type_id, room_name, bed_capacity, amenity, no_of_room, rent) VALUES (?, ?, ?, ?, ?, ?)";

        try {
        	Connection con = DbUtil.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, roomType.getTypeId());
            preparedStatement.setString(2, roomType.getRoomName());
            preparedStatement.setInt(3, roomType.getBedCapacity());
            preparedStatement.setString(4, roomType.getAmenity());
            preparedStatement.setInt(5, roomType.getNoOfRooms());
            preparedStatement.setInt(6, roomType.getRent());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper exception handling
        }
    }

    // Retrieve all room types from the database
    public List<RoomType> getAllRoomTypes() {
        List<RoomType> roomTypes = new ArrayList<>();
        String sql = "SELECT * FROM rt";

        try {
        	Connection con = DbUtil.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                RoomType roomType = new RoomType();
                roomType.setTypeId(resultSet.getInt("type_id"));
                roomType.setRoomName(resultSet.getString("room_name"));
                roomType.setBedCapacity(resultSet.getInt("bed_capacity"));
                roomType.setAmenity(resultSet.getString("amenity"));
                roomType.setNoOfRooms(resultSet.getInt("no_of_room"));
                roomType.setRent(resultSet.getInt("rent"));
                roomTypes.add(roomType);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper exception handling
        }
        return roomTypes;
    }

    // Update room type details in the database
    public void updateRoomType(RoomType roomType) {
        String sql = "UPDATE rt SET room_name=?, bed_capacity=?, amenity=?, no_of_room=?, rent=? WHERE type_id=?";

        try  {
        	Connection con = DbUtil.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, roomType.getRoomName());
            preparedStatement.setInt(2, roomType.getBedCapacity());
            preparedStatement.setString(3, roomType.getAmenity());
            preparedStatement.setInt(4, roomType.getNoOfRooms());
            preparedStatement.setInt(5, roomType.getRent());
            preparedStatement.setInt(6, roomType.getTypeId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper exception handling
        }
    }

    // Delete a room type from the database
    public void deleteRoomType(String typeId) {
        String sql = "DELETE FROM rt WHERE type_id=?";

        try  {
        	Connection con = DbUtil.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, typeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper exception handling
        }
    }
    
    public int getTypeIdByRoomName(String roomName) {
        int typeId = 0;
        
        String query = "SELECT type_id FROM rt WHERE room_name = ?";
        try {
            Connection con =DbUtil.openConnection();
        	PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, roomName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                typeId = rs.getInt("type_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeId;

}
    public RoomType getRoomTypeByName(String roomName) {
        RoomType roomType = null;
        String query = "SELECT * FROM rt WHERE ROOM_NAME = ?";

        try  {
        	Connection conn = DbUtil.openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, roomName);
           ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    roomType = new RoomType();
                    roomType.setTypeId(rs.getInt("TYPE_ID"));
                    roomType.setRoomName(rs.getString("ROOM_NAME"));
                    roomType.setBedCapacity(rs.getInt("BED_CAPACITY"));
                    roomType.setAmenity(rs.getString("AMENITY"));
                    roomType.setNoOfRooms(rs.getInt("NO_OF_ROOM"));
                    roomType.setRent(rs.getInt("RENT"));
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomType;
    }
    
    private int getTypeIdByRoomId(int roomId) throws SQLException {
        int typeId = 0;
        String sql = "SELECT r.type_id, rt.room_name FROM allroom r JOIN rt rt ON r.type_id = rt.type_id WHERE r.room_id = ? AND rt.room_name = ?";


        try  {
        	Connection conn = DbUtil.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roomId);

            try  {
            	ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    typeId = rs.getInt("type_id");
                }
            }
            catch(Exception e)
            {
            	e.getMessage();
            }
            
        }
        catch(Exception e)
        {
        	e.getMessage();
        }
        return typeId;
    }
    
    public int getRoomRentByRoomName(String roomName) throws SQLException {
        int roomRent = 0;
        String sql = "SELECT rent FROM rt WHERE room_name = ?";

        try (Connection conn = DbUtil.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, roomName);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    roomRent = rs.getInt("rent");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Propagate the exception to the caller
        }

        return roomRent;
    }

    
}
