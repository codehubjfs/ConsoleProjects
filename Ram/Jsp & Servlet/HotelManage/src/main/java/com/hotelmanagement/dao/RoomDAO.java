package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Room;
import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.utilities.DbUtil;

public class RoomDAO {
	
	 public boolean typeIdExists(int typeId) {
	        String sql = "SELECT COUNT(*) FROM rt WHERE type_id = ?";
	        try  {
	        	Connection con = DbUtil.openConnection();
	             PreparedStatement preparedStatement = con.prepareStatement(sql);
	            preparedStatement.setInt(1, typeId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	                if (resultSet.next()) {
	                    return resultSet.getInt(1) > 0;
	                }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return false;
	    }
	 
	 public List<Room> getAvailableRoomsByType(int typeId) {
	        List<Room> rooms = new ArrayList<>();
	        String sql = "SELECT room_id FROM allroom WHERE type_id = ? AND room_status = 'Available'";
	        try {
	        	Connection con = DbUtil.openConnection();
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            preparedStatement.setInt(1, typeId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Room room = new Room();
	                room.setRoomId(resultSet.getInt("room_id"));
	                rooms.add(room);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return rooms;
	    }
	 
	 public void updateRoomStatusToBooked(int roomId) {
	        String sql = "UPDATE allroom SET room_status = 'Booked' WHERE room_id = ?";
	        
	        try  {
	        	Connection con = DbUtil.openConnection();
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            preparedStatement.setInt(1, roomId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }
	 

	 
    public void addRoom(Room room) throws SQLException {
    	 if (!typeIdExists(room.getTypeId())) {
             throw new SQLException("Type ID does not exist in rt table");
         }
        String sql = "INSERT INTO allroom (room_id, type_id, room_status, room_condition) VALUES (?, ?, ?, ?)";
        
        try { 
        	Connection con = DbUtil.openConnection();
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        	preparedStatement.setInt(1,room.getRoomId());
            preparedStatement.setInt(2, room.getTypeId());
            
            preparedStatement.setString(3, room.getRoomStatus());
            preparedStatement.setString(4, room.getRoomCondition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void updateRoom(Room room) {
        String sql = "UPDATE allroom SET type_id = ?, room_status = ?, room_condition = ? WHERE room_id = ?";
        
        try {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        	
            preparedStatement.setInt(1, room.getTypeId());
            preparedStatement.setString(2, room.getRoomStatus());
            preparedStatement.setString(3, room.getRoomCondition());
            preparedStatement.setInt(4, room.getRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void deleteRoom(int roomId) {
        String sql = "DELETE FROM allroom WHERE room_id = ?";
        
        try {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
       
            preparedStatement.setInt(1, roomId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Room> listRooms() {
        List<Room> rooms = new ArrayList<>();
        
        try {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM allroom"); 
        	ResultSet resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomId(resultSet.getInt("room_id"));
                room.setTypeId(resultSet.getInt("type_id"));
              
                room.setRoomStatus(resultSet.getString("room_status"));
                room.setRoomCondition(resultSet.getString("room_condition"));
                rooms.add(room);
                System.out.println("Processing row: " + room);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println("Total rooms fetched: " + rooms.size());
        return rooms;
    }

    public Room getRoomById(int roomId) {
        Room room = null;
        String sql = "SELECT room_id, type_id, room_status, room_condition FROM allroom WHERE room_id = ?";
        
        try (Connection con = DbUtil.openConnection(); PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, roomId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    room = new Room();
                    room.setRoomId(resultSet.getInt("room_id"));
                    room.setTypeId(resultSet.getInt("type_id"));
                
                    room.setRoomStatus(resultSet.getString("room_status"));
                    room.setRoomCondition(resultSet.getString("room_condition"));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return room;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public List<Room> getRoomsByTypeId(int typeId) {
        List<Room> rooms = new ArrayList<>();
      
        String query = "SELECT * FROM allroom WHERE type_id = ?";
        try {
        	Connection connection = DbUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, typeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("room_id")); // Assuming room_id is an integer, adjust type as per your database
                //room.setRoomNo(rs.getString("room_no")); // Assuming room_no is a string, adjust type as per your database
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return rooms;

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
    
    
    public List<String> getAvailableRooms(String roomType) {
        List<String> availableRooms = new ArrayList<>();
        String sql = "SELECT ar.ROOM_ID " +
    			"FROM allroom ar, rt r " +
    			"WHERE ar.TYPE_ID = r.TYPE_ID " +
    			"AND r.ROOM_NAME = ? " +
    			"AND ar.ROOM_STATUS = 'Available'";
        try {
        	
            Connection conn = DbUtil.openConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setString(1, roomType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                availableRooms.add(rs.getString("ROOM_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception as needed
        }
        return availableRooms;
    
    
}
}
