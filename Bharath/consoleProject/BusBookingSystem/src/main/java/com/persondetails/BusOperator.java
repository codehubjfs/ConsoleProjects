package com.persondetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.bookingbus.Booking;
import com.bookingbus.Bus;
import com.customexception.InvalidNumberException;
import com.customexception.NameException;
import com.customexception.Validation;
import com.databaseconnection.DbConnection;
import com.locationsearch.Direction;
import com.primarykeyid.PrimaryKey;

public class BusOperator extends Person {
	int busOperatorId;
	String companyName;

	public BusOperator() {
		super();
	}

	public BusOperator(String companyName, String firstName, String lastName, String userName, String password,
			String email, String phoneNumber, String gender) {
		super(firstName, lastName, userName, password, email, phoneNumber, gender);
		this.companyName = companyName;
	}

	public BusOperator(int busOperatorId, String firstName, String lastName, String userName, String password,
			String email, String phoneNumber, String gender) {
		super(firstName, lastName, userName, password, email, phoneNumber, gender);
		this.busOperatorId = busOperatorId;
	}

	public BusOperator(String companyName, String firstName, String lastName, String userName, String password,
			String email, String phoneNumber) {
		super(firstName, lastName, userName, password, email, phoneNumber);
		this.companyName = companyName;
	}

	public int getBusOperatorId() {
		return busOperatorId;
	}

	public void setBusOperatorId(int busOperatorId) {
		this.busOperatorId = busOperatorId;
	}

	public BusOperator(String userName, String password) {
		super(userName, password);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// USER TYPE : BUS OPERATOR - Bus Operator will add
	// busnam,bustype,buscapacity,busfare,route of routeid,busoperator of
	// busoperatorid,day of route,departure time,arrival time
	public void addBus() {
		Bus bus = new Bus();
		do {
			try {
				Connection con = DbConnection.getDBConnection();
				String sqlRegbus = "INSERT INTO BUS (BUSNAME,BUSTYPE,BUSCAPACITY,FARE,ROUTE_ID,OPER_ID,DAYOFROUTE,DEPARTURETIME,ARRIVALTIME VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = con.prepareStatement(sqlRegbus);
				System.out.print(" Enter Bus Name: ");
				String busName = null;
				try {
					busName = Validation.validateName(in.readLine());
				} catch (NameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(" Enter Bus Type: ");
				String busType = in.readLine();
				System.out.print(" Enter Bus Capacity:");
				String capacity = Validation.validateNumber(in.readLine());
				int busCapacity=Integer.parseInt(capacity);
				System.out.print(" Enter Fare: ");
				String busFare=in.readLine();
				int fare = Integer.parseInt(in.readLine());		
//				System.out.print(" Enter Routeid:");
//				int route = Integer.parseInt(in.readLine());
				System.out.print(" Enter Busoperator id[1-3]:");
				int busOperator = Integer.parseInt(in.readLine());
				System.out.print(" Enter Day of Route: ");
				String dayOfRoute = in.readLine();
				DateTimeFormatter dateOfFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dateStr = LocalDate.parse(dayOfRoute, dateOfFormat);
				System.out.print(" Enter Departure Time:");
				String departureTime = in.readLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime departure = LocalTime.parse(departureTime, formatter);
				System.out.print(" Enter Arrival Time:");
				String arrivalTime = in.readLine();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime arrival = LocalTime.parse(arrivalTime, format);
				statement = con.prepareStatement(sqlRegbus);
				bus.setBusName(busName);
				bus.setBusType(busType);
				bus.setBusCapacity(busCapacity);
				bus.setBusFare(fare);
				bus.setBusid(PrimaryKey.keys("route"));
				bus.setOperId(busOperator);
				bus.setDateOfBus(dateStr);
				bus.setDepartureTime(departure);
				bus.setArrivalTime(arrival);
				statement.setInt(1, bus.getBusid());
				statement.setString(2, bus.getBusName());
				statement.setString(3, bus.getBusType());
				statement.setInt(4, bus.getBusCapacity());
				statement.setInt(5, bus.getBusFare());
				statement.setInt(6, bus.getOperId());
				statement.setInt(7, bus.getRouteId());
				statement.setDate(8, java.sql.Date.valueOf(bus.getDateOfBus()));
				statement.setTime(9, Time.valueOf(departure));
				statement.setTime(10, Time.valueOf(arrival));
				int row = statement.executeUpdate();
				if (row > 0) {
					System.out.println(" Bus Added Successfully!\n");
				}
			} catch (SQLException | IOException e) {
				System.out.println(e.getMessage());
			} catch (InvalidNumberException e) {
				e.printStackTrace();
			}
		} while (true);
	}
	//USER TYPE : BUS OPERATOR - Busoperator will update bus fare,route of route id,and busname
	public void updateBusFare(Bus bus) throws IOException {
		Connection con = null;
		con = DbConnection.getDBConnection();
		System.out.print(" Enter the new route id: ");
		int newRoute = Integer.parseInt(in.readLine());
		System.out.print(" Enter the new fare: ");
		int newFare = Integer.parseInt(in.readLine());
		String updateQuery = "Update bus set Fare=? , route_id=? where busname=?";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(updateQuery);
			statement.setInt(1, newFare);
			statement.setInt(2, newRoute);
			statement.setString(3, bus.getBusName()); // set the bus name from the Bus object

			if (statement.executeUpdate() > 0) {
				System.out.println(" Bus Details updates Successfully.");
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close(); // close the connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//USER TYPE : BUS OPERATOR - Bus operator will remove the bus details
	public void deleteBus() {
		LinkedHashMap<Integer, Bus> busMap = viewBus();
		System.out.println("\nEnter the SNo to delete the route:");
		try {
			int serialNo = Integer.parseInt(in.readLine());
			String deleteBusQuery = "update BUS set BUS_AVAILABILITY='N' where bus_id= ?";
			PreparedStatement statement = DbConnection.getDBConnection().prepareStatement(deleteBusQuery);
			int busId = busMap.get(serialNo).getBusid();
//	        System.out.println(busId);
			statement.setInt(1, busId);
			if (!busMap.containsKey(serialNo)) {
				System.out.println("The provided serial number does not exist.");
				return;
			}
			if (busId == 0) {
				System.out.println("Invalid busid. Cannot remove bus.");
				return;
			}
			if (statement.executeUpdate() <= 0) {
				System.out.println(
						"The bus could not be removed. Please check the provided serial number and try again.");
				return;
			}
			System.out.println("Removed Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("An error occurred while deleting the bus. Please check the error message and try again.");
		} catch (NumberFormatException e) {
			System.out.println("The provided input is not a valid number. Please enter a valid serial number.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("An error occurred while reading the user input. Please check the error message and try again.");
		}
	}

	//USER TYPE : BUS OPERATOR - Busoperator will view list of Bus
	public LinkedHashMap<Integer, Bus> viewBus() {
		Connection con = null;
		PreparedStatement statement = null;
		LinkedHashMap<Integer, Bus> routeMap = new LinkedHashMap<>();

		try {
			int i = 0;
			// System.out.printf(" +"+"-".repeat(120)+"+");
			System.out.println(" +" + "-".repeat(116) + "+");
			System.out.printf(" | %-5s | %-25s | %-10s | %-10s | %-10s | %-15s | %-10s | %-8s |%n", "S.No", "Bus Name",
					"Bus Type", "Capacity", "Fare", "Date", "Departure", "Arrival");
			System.out.println(" +" + "-".repeat(116) + "+");
			for (Bus bus : Direction.busList()) {
				if (bus.getBusAvailability().equalsIgnoreCase("Y")) {
					routeMap.put(++i, bus);
					System.out.printf(" | %-5s | %-25s | %-10s | %-10s | %-10s | %-15s | %-10s | %-8s |%n", i,
							bus.getBusName(), bus.getBusType(), bus.getBusCapacity(), bus.getBusFare(),
							bus.getDateOfBus(), bus.getDepartureTime(), bus.getArrivalTime());
					// System.out.println("| " + i + " | " + bus.getBusName() + " | " +
					// bus.getBusType() + " | " + bus.getBusCapacity() + " | " + bus.getBusFare() +
					// " | " + bus.getDateOfBus() + " | " + bus.getDepartureTime() + " | " +
					// bus.getArrivalTime() + " |");
				}
				System.out.println(" +" + "-".repeat(116) + "+");
			}
			return routeMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//Booking Management
//	public void viewBookedTickets(BusOperator operator) {
//		try {
//		ArrayList<Booking> operatorbookList=new ArrayList<>();
//		Connection con=DbConnection.getDBConnection();
//		String bookSql="SELECT BK.BOOKINGID, CS.CUSTOMER_ID,CS.FIRSTNAME,CS.LASTNAME, BK.SEATNUMBER, BK.BOOKINGSTATUS, BK.BOOKEDDATE,BS.BUS_ID, BS.BUSNAME, BS.BUSTYPE, BS.FARE, BS.DAYOFROUTE FROM BOOK BK JOIN BUS BS ON BK.BUSID = BS.BUS_ID JOIN CUSTOMER CS ON BK.CUSTOMER_ID = CS.CUSTOMER_ID WHERE BK.BOOKINGSTATUS = 'Confirmed'";
//		PreparedStatement statement;
//			statement = con.prepareStatement(bookSql);
//			ResultSet resultSet = statement.executeQuery();
//			
//			while(resultSet.next()) {
//				Booking book;
//				Customer customer=new Customer(resultSet.getInt("customer_id"),resultSet.getString("firstname"),resultSet.getString("lastName"));
//				
//				
//				Bus bus=new Bus(resultSet.getInt("bus_id"),resultSet.getString("busname"),resultSet.getInt("Fare"),resultSet.getString("busType"));
//				
//				
//				
//				book=new Booking(resultSet.getInt("bookingId"),customer,resultSet.getInt("seatnumber"),resultSet.getString("bookingstatus"),resultSet.getDate("bookeddate").toLocalDate(),bus);
//				operatorbookList.add(book);
//				System.out.println(" +------------------------------------------------------------------------------------------------------------------------------------------+");
//				System.out.println(" |Booking Id"+" "+"first name"+" "+"last name"+"seatnumber"+" "+"bookingstatus"+" "+"bookingdate"+" "+" busname"+" "+"bus fare"+" "+"bustype|");
//				System.out.println(" +------------------------------------------------------------------------------------------------------------------------------------------+");
//				for(Booking books:operatorbookList) {
//					System.out.println(books.getBookingId()+" "+customer.getFirstName()+" "+customer.getLastName()+" "+books.getSeatNumber()+" "+books.getBookingStatus()+" "+books.getBookedDate()+" "+bus.getBusName()+" "+bus.getBusFare()+" "+bus.getBusType());
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
	public void viewBookedTickets(BusOperator operator) {
	    try {
	        ArrayList<Booking> operatorbookList = new ArrayList<>();
	        Connection con = DbConnection.getDBConnection();
	        String bookSql = "SELECT BK.BOOKINGID, CS.CUSTOMER_ID, CS.FIRSTNAME, CS.LASTNAME, BK.SEATNUMBER, BK.BOOKINGSTATUS, BK.BOOKEDDATE, BS.BUS_ID, BS.BUSNAME, BS.BUSTYPE, BS.FARE, BS.DAYOFROUTE " +
	                         "FROM BOOK BK " +
	                         "JOIN BUS BS ON BK.BUSID = BS.BUS_ID " +
	                         "JOIN CUSTOMER CS ON BK.CUSTOMER_ID = CS.CUSTOMER_ID " +
	                         "WHERE BK.BOOKINGSTATUS = 'Confirmed'";
	        PreparedStatement statement = con.prepareStatement(bookSql);
	        ResultSet resultSet = statement.executeQuery();

	        System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------+");
	        System.out.println(" |Booking Id | First Name | Last Name | Seat Number | Booking Status | Booking Date |        Bus Name      | Bus Fare  | Bus Type |");
	        System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------+");

	        while (resultSet.next()) {
	            int customerId = resultSet.getInt("CUSTOMER_ID");
	            String firstName = resultSet.getString("FIRSTNAME");
	            String lastName = resultSet.getString("LASTNAME");
	            Customer customer = new Customer(customerId, firstName, lastName);

	            Bus bus = new Bus(resultSet.getInt("BUS_ID"), resultSet.getString("BUSNAME"), resultSet.getInt("FARE"), resultSet.getString("BUSTYPE"));

	            Booking book = new Booking(resultSet.getInt("BOOKINGID"), customer, resultSet.getInt("SEATNUMBER"), resultSet.getString("BOOKINGSTATUS"), resultSet.getDate("BOOKEDDATE").toLocalDate(), bus);
	            operatorbookList.add(book);
	        }

	        for (Booking books : operatorbookList) {
	            Customer customer = books.getCustomer();
	            Bus bus = books.getBus();
	            System.out.printf(" | %-9d | %-10s | %-9s | %-11d | %-14s | %-12s | %-20s | %-8d | %-9s |%n",
	                    books.getBookingId(), customer.getFirstName(), customer.getLastName(), books.getSeatNumber(),
	                    books.getBookingStatus(), books.getBookedDate(), bus.getBusName(), bus.getBusFare(), bus.getBusType());

	        }

	        System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------+");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
//	public void requestedRefund(BusOperator operator) {
	 public void requestedRefund(BusOperator operator) {
	        try {
	            ArrayList<Booking> operatorbookList = new ArrayList<>();
	            Connection con = DbConnection.getDBConnection();
	            String bookSql = "SELECT BK.BOOKINGID, CS.CUSTOMER_ID, CS.FIRSTNAME, CS.LASTNAME, BK.SEATNUMBER, BK.BOOKINGSTATUS, BK.BOOKEDDATE, BS.BUS_ID, BS.BUSNAME, BS.BUSTYPE, BS.FARE, BS.DAYOFROUTE " +
	                             "FROM BOOK BK " +
	                             "JOIN BUS BS ON BK.BUSID = BS.BUS_ID " +
	                             "JOIN CUSTOMER CS ON BK.CUSTOMER_ID = CS.CUSTOMER_ID " +
	                             "JOIN BUSOPERATOR BO ON BS.OPER_ID = BO.OPER_ID " +
	                             "WHERE BK.BOOKINGSTATUS = 'Refund Requested' AND BO.OPER_ID = ?";
	            PreparedStatement statement = con.prepareStatement(bookSql);
	            statement.setInt(1, operator.getBusOperatorId()); // Assuming BusOperator has a method getOperatorId()
	            ResultSet resultSet = statement.executeQuery();

	            System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------+");
	            System.out.println(" |Booking Id | First Name | Last Name | Seat Number | Booking Status | Booking Date |        Bus Name      | Bus Fare  | Bus Type |");
	            System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------+");

	            while (resultSet.next()) {
	                int customerId = resultSet.getInt("CUSTOMER_ID");
	                String firstName = resultSet.getString("FIRSTNAME");
	                String lastName = resultSet.getString("LASTNAME");
	                Customer customer = new Customer(customerId, firstName, lastName);

	                Bus bus = new Bus(resultSet.getInt("BUS_ID"), resultSet.getString("BUSNAME"), resultSet.getInt("FARE"), resultSet.getString("BUSTYPE"));

	                Booking book = new Booking(resultSet.getInt("BOOKINGID"), customer, resultSet.getInt("SEATNUMBER"), resultSet.getString("BOOKINGSTATUS"), resultSet.getDate("BOOKEDDATE").toLocalDate(), bus);
	                operatorbookList.add(book);
	            }

	            for (Booking books : operatorbookList) {
	                Customer customer = books.getCustomer();
	                Bus bus = books.getBus();
	                System.out.printf(" | %-9d | %-10s | %-9s | %-11d | %-14s | %-12s | %-20s | %-8d | %-9s |%n",
	                        books.getBookingId(), customer.getFirstName(), customer.getLastName(), books.getSeatNumber(),
	                        books.getBookingStatus(), books.getBookedDate(), bus.getBusName(), bus.getBusFare(), bus.getBusType());
	            }

	            System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------+");

	            // Get user input for booking IDs to confirm refund
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	            System.out.println("Enter the Booking Id(s) to confirm refund (comma-separated): ");
	            String input = in.readLine();
	            String[] bookingIds = input.split(",");

	            String updateSql = "UPDATE BOOK SET BOOKINGSTATUS = 'confirmed' WHERE BOOKINGID = ?";
	            PreparedStatement updateStatement = con.prepareStatement(updateSql);

	            for (String bookingId : bookingIds) {
	                updateStatement.setInt(1, Integer.parseInt(bookingId.trim()));
	                updateStatement.executeUpdate();
	            }

	            System.out.println("Selected bookings have been updated to 'confirmed' status.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

		public void allOperator() {
			try {
				 ArrayList<BusOperator> operatorList = new ArrayList<>();
				 Connection con=DbConnection.getDBConnection();
				 String operatorSql="Select BNAME,FIRSTNAME,LASTNAME,EMAIL,USERNAME,PASSWORD,PHONE_NUMBER from Busoperator";
				 PreparedStatement statement = con.prepareStatement(operatorSql);
				 ResultSet resultSet = statement.executeQuery();
				 BusOperator bus;
				 //BusOperator(String companyName,String firstName, String lastName, String userName, String password, String email,
					//String phoneNumber, String gender)
					while (resultSet.next()) {
						bus = new BusOperator(resultSet.getString("bname"),resultSet.getString("firstName"), resultSet.getString("lastName"),resultSet.getString("userName"), resultSet.getString("password"), resultSet.getString("email"),resultSet.getString("phone_number"));
	                   operatorList.add(bus);
					} 
	               System.out.println(" +---------------------------------------------------------------------------------------------------------------------------------------+");
	               System.out.println(" |Bus Name"+" "+"Fist Name"+" "+"last Name"+" "+"Email"+" "+"username"+" "+"password");
	               System.out.println(" +---------------------------------------------------------------------------------------------------------------------------------------+");
	               for (BusOperator operator : operatorList) {
	                   System.out.println(operator.getCompanyName()+"\t"+operator.getFirstName()+"\t"+operator.getLastName()+"\t"+operator.getEmail()+"\t"+operator.getUserName()+"\t"+operator.getPassword()+"\t"+operator.getPhoneNumber());
	               }
	               System.out.println("+-----------------------------------------------------------------------------------------------------+");
	           }
	           catch (SQLException e){
	               e.printStackTrace();
	           }
	   }
		public void updateBusOperator() {
			System.out.println("Under Construction");
			
		}
		public void deleteBusOperator() {
			System.out.println("Under Construction");
		}
	@Override
	public String toString() {
		return "BusOperator [busOperatorId=" + busOperatorId + ", companyName=" + companyName + "]";
	}
}
