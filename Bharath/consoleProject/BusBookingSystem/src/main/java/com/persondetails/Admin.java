package com.persondetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import com.adminutility.Route;
import com.customexception.DistanceException;
import com.customexception.DurationException;
import com.customexception.EndLocationException;
import com.customexception.SerialNumberException;
import com.customexception.StartLocationException;
import com.customexception.Validation;
import com.databaseconnection.DbConnection;
import com.locationsearch.Direction;
import com.primarykeyid.PrimaryKey;


//Admin class extending person class 
public class Admin extends Person {
	int adminId;

	public Admin() {
		super();
	}

	public Admin(int adminId, String email, String password, String firstName, String lastName, String phoneNumber,
			String userName, String gender) {
		super(email, password, firstName, lastName, phoneNumber, userName, gender);
		this.adminId = adminId;
	}

	public Admin(String email, String password, String firstName, String lastName, String phoneNumber, String userName,
			String gender) {
		super(email, password, firstName, lastName, phoneNumber, userName, gender);
	}

	public Admin(String userName, String password) {
		super(userName, password);
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// USER TYPE : ADMIN- Admin will add new route details 
	public Route addRoute() {
		Route route = new Route();
		do {
			try {
				System.out.print(" Staring Location :");
				String start = Validation.validateStartLocation(in.readLine());
				System.out.print(" Destination :");
				String end = Validation.validateDestinationLocation(in.readLine());
				System.out.print(" Distance[in km] :");
				String far = Validation.validateDistance(in.readLine());
				int distance=Integer.parseInt(far);
				System.out.print(" Estimated Duration[in hrs] :");
				String time = Validation.validateDuration(in.readLine());
				int duration=Integer.parseInt(time);
				route.setRoute_id(PrimaryKey.keys("route"));
				route.setStartingLocation(start);
				route.setDestination(end);
				route.setEstimatedDuration(duration);
				route.setDistance(distance);
				Connection con = DbConnection.getDBConnection();
				if (con == null) {
					System.out.println("Failed to establish database connection.");
					return null;
				}
				String sqlRegbus = "INSERT INTO ROUTE VALUES(?,?,?,?,?,'Y')";
				PreparedStatement statement = con.prepareStatement(sqlRegbus);
				statement.setInt(1, route.getRoute_id());
				statement.setString(2, route.getStartingLocation());
				statement.setString(3, route.getDestination());
				statement.setInt(4, route.getDistance());
				statement.setInt(5, route.getEstimatedDuration());
				// statement.setDate(6, new java.sql.Date(rs.getDay().getTime()));
				int row = statement.executeUpdate();
				if (row > 0) {
					System.out.println(" Added location successfully!\n");
					return route;
				}
			} catch (SQLException | IOException | StartLocationException | EndLocationException | DistanceException | DurationException e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}

	// USER TYPE : ADMIN - Admin will Delete existing route details
	public void deleteRoute() {
		LinkedHashMap<Integer, Route> routeMap = viewRoute();
		boolean result=true;
		while(result) {
		System.out.print("\n Enter the SNo to delete the route:");
		try {
			int sno = Validation.validateSerialNumber(in.readLine());
			result=false;
			String deleteQuery = "Update route set Route_Availability = 'N' where route_id = ?";
			PreparedStatement statement = DbConnection.getDBConnection().prepareStatement(deleteQuery);
			statement.setInt(1, routeMap.get(sno).getRoute_id());
			if (statement.executeUpdate() > 0) {
				System.out.println(" Removed Successfully");
			}
		} catch (SQLException | NumberFormatException | IOException | SerialNumberException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	// USER TYPE : ADMIN  - Admin will view Route details in existing records
	public LinkedHashMap<Integer, Route> viewRoute() {
//		Connection con = null;
//		PreparedStatement statement = null;
		LinkedHashMap<Integer, Route> routeMap = new LinkedHashMap<>();
		try {
			int i = 0;
			System.out.printf(" +" + "-".repeat(86) + "+" + "\n");
			System.out.printf(" | %-2s | %-20s | %-20s | %-10s | %-10s |%n", "S.NO", "Source", "Destination",
					"Distance", "Estimated Duration");
			System.out.printf(" +" + "-".repeat(86) + "+");
			System.out.println();
			for (Route route : Direction.routeList()) {
				if (route.getAvailability().equalsIgnoreCase("Y")) {
					routeMap.put(++i, route);
					System.out.printf(" |  %-2d  | %-20s | %-20s |%-10d  | %-18s |%n", i, route.getStartingLocation(),
							route.getDestination(), route.getDistance(), route.getEstimatedDuration());
				}
			}
			System.out.printf(" +" + "-".repeat(86) + "+");
			return routeMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
