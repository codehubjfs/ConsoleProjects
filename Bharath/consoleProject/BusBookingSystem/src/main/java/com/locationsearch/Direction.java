package com.locationsearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.adminutility.Route;
import com.bookingbus.Bus;
import com.databaseconnection.DbConnection;

public class Direction {
	public static LinkedList<Route> routeList() {
		LinkedList<Route> routList = new LinkedList<>();
		Route route = null;
			try {
				Connection con = DbConnection.getDBConnection();
				String sql = "SELECT ROUTE_ID,STARTLOCATION,ENDLOCATION,DISTANCE,ESTIMATEDDURATION,ROUTE_AVAILABILITY FROM ROUTE";
				PreparedStatement statement = con.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery(); 
	            while(resultSet.next()) {
	            	route=new Route(resultSet.getInt("ROUTE_ID"),resultSet.getString("STARTLOCATION"),
	            			resultSet.getString("ENDLOCATION"),resultSet.getInt("DISTANCE"),resultSet.getInt("ESTIMATEDDURATION"),resultSet.getString("ROUTE_AVAILABILITY"));
	            	routList.add(route);
	            }
	            return routList;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return routList;
	}
	//busoperator-buslist
	public static LinkedList<Bus> busList(){
		LinkedList<Bus> busList=new LinkedList<>();
		Bus bus=null;
		try {
			Connection con = DbConnection.getDBConnection();
			String sql="SELECT BUS_ID,BUSNAME,BUSTYPE,BUSCAPACITY,FARE,DAYOFROUTE,DEPARTURETIME,ARRIVALTIME,BUS_AVAILABILITY FROM BUS";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(); 
            while(resultSet.next()) {
            	bus=new Bus(resultSet.getInt("Bus_id"),resultSet.getString("BUSNAME"),
            			resultSet.getString("BUSTYPE"),resultSet.getInt("BUSCAPACITY"),resultSet.getInt("FARE"),resultSet.getDate("DAYOFROUTE").toLocalDate(),resultSet.getTime("DEPARTURETIME").toLocalTime(),resultSet.getTime("ARRIVALTIME").toLocalTime(),resultSet.getString("BUS_AVAILABILITY"));
            	busList.add(bus);
            }
            return busList;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return busList;
}
}
//	public static LinkedList<Bus> busList() {
//	    LinkedList<Bus> busList = new LinkedList<>();
//	    Bus bus = null;
//	    try {
//	        Connection con = DbConnection.getDBConnection();
//	        String sql = "SELECT BUSNAME,BUSTYPE,BUSCAPACITY,FARE,DAYOFROUTE,DEPARTURETIME,ARRIVALTIME FROM BUS";
//	        PreparedStatement statement = con.prepareStatement(sql);
//	        ResultSet resultSet = statement.executeQuery(); 
//	        while (resultSet.next()) {
//	            Timestamp departureTime = resultSet.getTimestamp("DEPARTURETIME");
//	            Timestamp arrivalTime = resultSet.getTimestamp("ARRIVALTIME");
//	            bus = new Bus(resultSet.getString("BUSNAME"),
//	                    resultSet.getString("BUSTYPE"), resultSet.getInt("BUSCAPACITY"), resultSet.getInt("FARE"),
//	                    resultSet.getDate("DAYOFROUTE").toLocalDate(), departureTime, arrivalTime);
//	            busList.add(bus);
//	        }
//	        return busList;
//	    } catch (Exception e) {
//	        System.out.println(e.getMessage());
//	    }
//	    return busList;
//	}
//}
//	