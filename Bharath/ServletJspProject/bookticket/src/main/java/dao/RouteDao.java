package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BusStop;
import bean.RoutesBean;
import util.Database;

public class RouteDao {
	  public void addRoute(RoutesBean route) {
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            con = Database.getConnection();
	            String maxIdQuery = "SELECT MAX(route_id) AS max_id FROM route";
	            ps = con.prepareStatement(maxIdQuery);
	            rs = ps.executeQuery();
	            int newRouteId = 1;

	            if (rs.next()) {
	                int maxId = rs.getInt("max_id");
	                newRouteId = maxId + 1;
	            }

	            String insertQuery = "INSERT INTO route (route_id, startlocation, endlocation, distance, estimatedduration, ROUTE_AVAILABILITY) VALUES (?, ?, ?, ?, ?, ?)";
	            ps = con.prepareStatement(insertQuery);
	            ps.setInt(1, newRouteId);
	            ps.setString(2, route.getSource());
	            ps.setString(3, route.getDestination());
	            ps.setInt(4, route.getDistance());
	            ps.setInt(5, route.getDuration());
	            ps.setString(6, "Y");

	            if (ps.executeUpdate() > 0) {
	                System.out.println("updated successfully");
	            } else {
	                System.out.println("not updated successfully");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	    }

	    public List<RoutesBean> getAllRoutes() {
	        List<RoutesBean> routes = new ArrayList<>();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            con = Database.getConnection();
	            String query = "SELECT * FROM route where ROUTE_AVAILABILITY='Y'";
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                RoutesBean route = new RoutesBean();
	                route.setIndex(rs.getInt("route_id"));
	                route.setSource(rs.getString("startlocation"));
	                route.setDestination(rs.getString("endlocation"));
	                route.setDistance(rs.getInt("distance"));
	                route.setDuration(rs.getInt("estimatedduration"));
	                routes.add(route);
	            }
	            
//	            System.out.println(routes);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 

	        return routes;
	    }
	    
	public List<BusStop> getAllStop(){
			List<BusStop> busStop=new ArrayList<>();
			 Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;

		        try {
		            con = Database.getConnection();
		            String query = "SELECT * FROM Stopping_details";
		            ps = con.prepareStatement(query);
		            rs = ps.executeQuery();

		            while (rs.next()) {
		                BusStop stop = new BusStop();
		                stop.setStopId(rs.getInt("stop_id"));
		                stop.setPickupPoint(rs.getString("pickuppoint"));
		                stop.setDroppingPoint(rs.getString("droppingpoint"));
		                		
		                busStop.add(stop);
		            }
		            
		            System.out.println(busStop);

		        } catch (Exception e) {
		            e.printStackTrace();
		        } 

		        return busStop;
		    }

    public RoutesBean getRouteById(int id) {
        RoutesBean route = null;
        try {
            Connection con = Database.getConnection();
            String query = "SELECT * FROM routesoftable WHERE ROUTEID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                route = new RoutesBean();
                route.setIndex(rs.getInt("ROUTEID"));
                route.setSource(rs.getString("SOURCE"));
                route.setDestination(rs.getString("DESTINATION"));
                route.setDistance(rs.getInt("DISTANCE"));
                route.setDuration(rs.getInt("DURATION"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }

    public boolean updateRoute(RoutesBean route) {
        try {
            Connection con = Database.getConnection();
            String query = "UPDATE route SET STARTLOCATION = ?, ENDLOCATION = ?, DISTANCE = ?, ESTIMATEDDURATION = ? WHERE route_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, route.getSource());
            ps.setString(2, route.getDestination());
            ps.setInt(3, route.getDistance());
            ps.setInt(4, route.getDuration());
            ps.setInt(5, route.getIndex());
            if(ps.executeUpdate()>0) {
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
		
    
    }

    public boolean deleteRoute(int routeId) {
    	boolean deleted = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Database.getConnection();
            
            String sql = "Update route set ROUTE_AVAILABILITY='N' WHERE route_id =?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, routeId);
            
            int rowsDeleted = stmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                deleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return deleted; 
    }

//	public void updateRoute(RoutesBean route) {
//		  try {Connection conn = Database.getConnection();
//      	String updates="UPDATE route SET STARTLOCATION = ?, ENDLOCATION = ?, DISTANCE = ?, ESTIMATEDDURATION = ? WHERE routeid = ?";
//           PreparedStatement stmt = conn.prepareStatement(updates);
//
//          stmt.setString(1, source);
//          stmt.setString(2, destination);
//          stmt.setString(3, distance);
//          stmt.setString(4, duration);
//          stmt.setString(5, sNo);
//
//          int rowsUpdated = stmt.executeUpdate();
//          return rowsUpdated > 0;
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//      return false;
//		
//	}
}
