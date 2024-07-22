package com.persondetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import com.adminutility.Route;
import com.bookingbus.Booking;
import com.bookingbus.Bus;
import com.customexception.CardNumberException;
import com.customexception.EndLocationException;
import com.customexception.InvalidNumberException;
import com.customexception.OptionException;
import com.customexception.StartLocationException;
import com.customexception.Validation;
import com.databaseconnection.DbConnection;
import com.payment.Payment;
import com.primarykeyid.PrimaryKey;
import com.smarcliff.busbookingsystem.BusTicketBookingSystem;

public class Customer extends Person {
	int customerid;

	public Customer(int customerid, String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, String gender) {
		super(firstName, lastName, userName, password, email, phoneNumber, gender);
		this.customerid = customerid;
	}

	public Customer(String userName, String password) {
		super(userName, password);
	}

	public Customer(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, String gender) {
		super(firstName, lastName, userName, password, email, phoneNumber, gender);
	}

	public Customer() {
		super();
	}

	public Customer(int customerid, String firstName, String lastName) {
		super(firstName, lastName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerid = customerid;
	}

	public int getCustid() {
		return customerid;
	}

	public void setCustid(int customerid) {
		this.customerid = customerid;
	}

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	 /**
	   * This method is used for customer to booking the ticket. To search source, 
	   * destination and day of travel based on this to choose the bus
	   * to book and choose seat to book the tickets and payment for ticket
	   * @param unused
	   * @return int This returns the chosen bus number
	   */
	
	public void bookTicket() {
		boolean exitFlag = false;
		do {
			String start = " ", end = " ", cardNumber = " ";
			try {
				while (true) {
					try {
						System.out.print(" Enter Start Location: ");
						start = Validation.validateStartLocation(in.readLine().trim());
						break;
					} catch (StartLocationException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Destination: ");
						end = Validation.validateDestinationLocation(in.readLine().trim());
						if (end.equalsIgnoreCase(start)) {
							System.out.println(" +" + "-".repeat(45) + "+");
							System.out.println(" | Source and Destination city cannot be same. |");// End location  cannot be the  same as start location.repeat(52)												
							System.out.println(" +" + "-".repeat(45) + "+");
						} else {
							break;
						}
					} catch (EndLocationException e) {
						System.out.println(e.getMessage());
					}
				}
				
				LocalDate date;
				while (true) {
					System.out.print(" Enter a date after (dd/MM/yyyy): ");
					String input = in.readLine().trim();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate currentDate = LocalDate.now();
					try {
						date = LocalDate.parse(input, formatter);
						if (!date.isEqual(currentDate) && !date.isAfter(currentDate)) {
							System.out.println(" +" + "-".repeat(55) + "+");
							System.out.println(" |The date must be after the " + currentDate.format(formatter)
									+ " Please try again |");
							System.out.println(" +" + "-".repeat(55) + "+");
						} else {
							break;
						}
					} catch (DateTimeParseException e) {
						System.out.println(" *" + "*".repeat(69) + "*");
						System.out.println(" | Invalid date format. Please enter the date in the format dd/MM/yyyy |");
						System.out.println(" *" + "*".repeat(69) + "*");
					}
				}

				HashMap<Integer, Bus> routeBusMap = new HashMap<>();
				int i = 0;
				boolean isBusExited = false;
				boolean validInput = false;
				boolean headerPrinted = false;
				for (Bus bus : viewBusList()) {
					if (bus.getRoute().getStartingLocation().equalsIgnoreCase(start)
							&& bus.getRoute().getDestination().equalsIgnoreCase(end)
							&& bus.getDateOfBus().isEqual(date)) {// && bus.getDateOfBus().equals(date)
						if (!headerPrinted) {
							System.out.println("+" + "-".repeat(94) + "+");
							System.out.printf("| %-10s | %-30s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name",
									"Bus Type", "Bus Fare", "Distance[km]");
							System.out.println("+" + "-".repeat(94) + "+");
							headerPrinted = true;
						}
//						System.out.println("+" + "-".repeat(84) + "+");
//						System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name", "Bus Type", "Bus Fare", "Distance[km]");
//						System.out.println("+" + "-".repeat(84) + "+");
						System.out.printf("| %-10d | %-30s | %-10s | %-10d | %-20d |\n", (++i), bus.getBusName(),
								bus.getBusType(), bus.getBusFare(), bus.getRoute().getDistance());
						System.out.println("+" + "-".repeat(94) + "+");
						routeBusMap.put(i, bus);
						isBusExited = true;

					}
				}
				if (!isBusExited) {
					System.out.println(" +" + "-".repeat(20) + "+");
					System.out.println(" | Bus not available. |");
					System.out.println(" +" + "-".repeat(20) + "+");
				} else {
					boolean filterRoutes = true;
					int filteredChoosedNumber = 0;

//					do {
						do {
							String filter = null;
							System.out.print(" Are you want to apply sort/filter[y/n]: ");
							try {
								filter = in.readLine().trim();
								if (filter.equalsIgnoreCase("y")) {
									filteredChoosedNumber = filterBus(routeBusMap);
									System.out.println(filteredChoosedNumber);
									filterRoutes = true;
								} else if (filter.equalsIgnoreCase("n")) {
									filterRoutes = false;
								} else {
									System.out.println(" Invalid input. Please enter 'y' or 'n'.");
									continue; // Continue the loop to ask for input again
								}
								validInput = true; // Input is valid, exit the loop
							} catch (IOException e) {
								System.out.println(e.getMessage());
								//e.printStackTrace();
							}
							int busNumber;
							if (filterRoutes == true) {
								busNumber = filteredChoosedNumber;
							} else {
								System.out.print(" Enter the Bus Number: ");
								busNumber = Integer.parseInt(in.readLine());
							}

							boolean s=false;

		                        try {
		                            if (filterRoutes==true) {
		                                busNumber = filteredChoosedNumber;
		                            } else {
		                                System.out.print(" Enter the Bus Number: ");
		                                busNumber = Integer.parseInt(in.readLine());
		                                s=true;
		                            }

		                            if (s && !routeBusMap.containsKey(busNumber)) {
		                                System.out.println(" Invalid bus number. Please try again.");
		                                busNumber = -1; // Reset busNumber to prompt again
		                            }
		                        } catch (NumberFormatException e) {
		                            System.out.println(" Invalid input. Please enter a valid integer for the bus number.");
		                        }
		                    
							
							if (routeBusMap.size() > 0 && busNumber <= routeBusMap.size()) {
								int busId = routeBusMap.get(busNumber).getBusid();
								ArrayList<Integer> seatsBooked = new ArrayList<>();
								Booking booking = new Booking();
								ArrayList<Booking> bookings = booking.bookList();
								for (Booking book : bookings) {
									if (book.getBookingStatus().equalsIgnoreCase("Confirmed")
											&& book.getBus().getDateOfBus().isEqual(date)) {
										seatsBooked.add(book.getSeatNumber());
									}
								}
								for (int k = 0; k < 10; k++) {
									for (int j = 0; j < 4; j++) {
										int seatNumber = (j * 10) + k + 1;
										if (seatsBooked.contains(seatNumber)) {
											System.out.printf("%3d - U ", seatNumber);
										} else {
											System.out.printf("%3d - A ", seatNumber);
										}
									}
									System.out.println();
								}

//							}catch(WordException e) {
//								System.out.println(e.getMessage());
//							}
								HashSet<Integer> seatSelected = new HashSet<>();
								do {
									try {
										System.out.print(" Select seat to book (E to complete): ");
										String seatNumber = in.readLine();
										if (seatNumber.equalsIgnoreCase("E")) {
											break;
										}
										int seatNum = Integer.parseInt(seatNumber);
										if (seatsBooked.contains(seatNum)) {
											System.out.println(" Entered seat is Unavailable");
										} else if (seatSelected.contains(seatNum)) {
											System.out.println(" Entered seat is already selected");
										} else if (seatNum < 1 || seatNum > 40) {// total seat i need
											throw new NumberFormatException(
													"Invalid seat number. Please enter a seat number between 1 and 44.");
										} else {
											seatSelected.add(seatNum);
										}
										// System.out.println(seatSelected);
									} catch (NumberFormatException e) {
										System.out.println(" Invalid seat number. Please enter a valid seat number.");
									}
								} while (true);

								System.out.println("+" + "-".repeat(44) + "+");
								System.out.printf("|%11s | %15s | %9s |\n", " Bus Fare ", "NO of Tickets",
										"Total Price");
								System.out.println("+" + "-".repeat(44) + "+");
								float totalAmount = routeBusMap.get(busNumber).getBusFare() * seatSelected.size();
								System.out.printf("| % -10d | %-15d | %-11d |\n",
										routeBusMap.get(busNumber).getBusFare(), seatSelected.size(),
										routeBusMap.get(busNumber).getBusFare() * seatSelected.size());
								System.out.println("+" + "-".repeat(44) + "+");
								if (seatSelected.size() > 0) {
									System.out.println(" 1.Continue Booking \n 2.Back");
									System.out.print(" Enter the option: ");
									int option = Validation.validateOption(in.readLine().trim());
									if (option == 1) {
										// Bus bus = null;
										Booking book = null;
										// here the above program after insert into booked table here check
										for (int seat : seatSelected) {
											try {
												Connection con = DbConnection.getDBConnection();
												String sqlSeat = "INSERT INTO Book (BOOKINGID, customer_Id, seatNumber, bookingStatus, BOOKEDDATE, busId) VALUES (?, ?, ?, ?, ?, ?)";
												PreparedStatement stmt = con.prepareStatement(sqlSeat);
												int bookId = PrimaryKey.keys("book");
												book = new Booking();
												book.setBookingId(bookId);
												stmt.setInt(1, book.getBookingId());
												stmt.setInt(2, this.getCustid());
												// System.out.println(this.customerid);
												stmt.setInt(3, seat);
												stmt.setString(4, "Confirmed");
												stmt.setDate(5, Date.valueOf(LocalDate.now()));
												stmt.setInt(6, busId);
												int row = stmt.executeUpdate();
												if (row > 0) {
													System.out.println(" Seat " + seat + " booked!");
												}
											} catch (Exception e) {
												System.err.println(e.getMessage());
											}
										}

										while (true) {
											try {
												System.out.print(" Enter the Card Number: ");
												cardNumber = Validation.validateCardNumber(in.readLine());
												break;
											} catch (CardNumberException e) {
												System.out.println(e.getMessage());
											}
										}
										Payment payment = new Payment();
										int payId = PrimaryKey.keys("payment");
										payment.setPayId(payId);
										payment.setAccountNumber(cardNumber);
										payment.setTotalAmount(totalAmount);
										payment.setBook(book);
										String paymentQuery = "Insert into payment(PAY_ID,ACCOUNTNUMBER,PAYMENTMETHOD,TOTALAMOUNT,BOOKING_ID) values (?,?,?,?,?)";
										PreparedStatement statement = DbConnection.getDBConnection()
												.prepareStatement(paymentQuery);
										statement.setInt(1, payment.getPayId());
										statement.setString(2, payment.getAccountNumber());
										statement.setString(3, "Card");
										statement.setFloat(4, totalAmount);
										statement.setInt(5, book.getBookingId());
										int row = statement.executeUpdate();
										if (row > 0) {
											System.out.println(" Paid Successfully");
											exitFlag = false;
											break;
										}
									} else {
										return;// outside of method
									}
								} else {
									System.out.println(" No Seats are selected..");
									BusTicketBookingSystem bus = new BusTicketBookingSystem();
									bus.applyTravel(this);
									break;
								}
							}
							else {
	                            System.out.println(" Invalid bus number. Please try again.");
	                        }
						} while (true);
						
//					} while (!validInput);
				}
			} catch (Exception e) {
				exitFlag = true;
				System.out.println(e.getMessage());
			}

		} while (exitFlag);
	}

	/**
	 * This method apply the filters and selects a bus from the provided routeBusMap based on user input.
	 *
	 * @param routeBusMap A HashMap containing bus routes with bus numbers as keys and Bus objects as values.
	 * @return The serial number (S.No) of the chosen bus if a valid selection is made, otherwise returns 0.
	 */
	
	private int filterBus(HashMap<Integer, Bus> routeBusMap) {	
		Map<Integer, Bus> busMap = new HashMap<>();
		int option;
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int chosenBusNo = 0, value = 0;
		boolean verify=true;
		try {
			boolean flag = false;
			do {
				verify=true;
				System.out.println(" +----------------------------+");
				System.out.println(" | 1.Search by Ac Bus         |");
				System.out.println(" | 2.Search by Non Ac Bus     |");
				System.out.println(" | 3.Sort by Fare             |");
				System.out.println(" | 4.Back                     |");
				System.out.println(" +----------------------------+");
				System.out.print(" Enter Your Option: ");
			option = Validation.validateOption(in.readLine().trim());
			
			int i[] = { 0 };
			switch (option) {
			case 1:
				// Filter AC buses
//				System.out.println(" +" + "-".repeat(84) + "+");
//				System.out.printf(" | %-10s | %-20s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name", "Bus Type", "Bus Fare",
//						"Distance[km]");
//				System.out.println(" +" + "-".repeat(84) + "+");
//				busMap = routeBusMap.values().stream().filter(bus -> bus.getBusType().equalsIgnoreCase("AC"))
//						.peek(bus -> System.out.printf(" | %-10d | %-20s | %-10s | %-10d | %-20d |\n", (++i[0]),
//								bus.getBusName(), bus.getBusType(), bus.getBusFare(), bus.getRoute().getDistance()))
//						.collect(Collectors.toMap(bus -> i[0], bus -> bus));
//				System.out.println(" +" + "-".repeat(84) + "+");
//				flag = false;
//				break;
				 if (routeBusMap.size() > 1) {
			            System.out.println(" +" + "-".repeat(84) + "+");
			            System.out.printf(" | %-10s | %-20s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name", "Bus Type", "Bus Fare", "Distance[km]");
			            System.out.println(" +" + "-".repeat(84) + "+");

			            busMap = routeBusMap.values().stream().filter(bus -> bus.getBusType().equalsIgnoreCase("AC"))
								.peek(bus -> System.out.printf(" | %-10d | %-20s | %-10s | %-10d | %-20d |\n", (++i[0]),
										bus.getBusName(), bus.getBusType(), bus.getBusFare(), bus.getRoute().getDistance()))
								.collect(Collectors.toMap(bus -> i[0], bus -> bus));

			            System.out.println(" +" + "-".repeat(84) + "+");
			        } else {
			            System.out.println("No AC buses available for the given criteria.");
			            filterBus(routeBusMap);
			        }
			case 2:
				// Filter NON AC buses
//				System.out.println(" +" + "-".repeat(84) + "+");
//				System.out.printf(" | %-10s | %-20s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name", "Bus Type", "Bus Fare",
//						"Distance[km]");
//				System.out.println(" +" + "-".repeat(84) + "+");
//				busMap = routeBusMap.values().stream().filter(bus -> bus.getBusType().equalsIgnoreCase("NONAC"))
//						.peek(bus -> System.out.printf(" | %-10d | %-20s | %-10s | %-10d | %-20d |\n", (++i[0]),
//								bus.getBusName(), bus.getBusType(), bus.getBusFare(), bus.getRoute().getDistance()))
//						.collect(Collectors.toMap(bus -> i[0], bus -> bus));
//				System.out.println(" +" + "-".repeat(84) + "+");
//				flag = false;
//				break;

		        // Only print the table if there is more than one bus
		        if (routeBusMap.size() > 1) {
		            System.out.println(" +" + "-".repeat(84) + "+");
		            System.out.printf(" | %-10s | %-20s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name", "Bus Type", "Bus Fare", "Distance[km]");
		            System.out.println(" +" + "-".repeat(84) + "+");

		            System.out.println(" +" + "-".repeat(84) + "+");
					busMap = routeBusMap.values().stream().filter(bus -> bus.getBusType().equalsIgnoreCase("NONAC"))
							.peek(bus -> System.out.printf(" | %-10d | %-20s | %-10s | %-10d | %-20d |\n", (++i[0]),
									bus.getBusName(), bus.getBusType(), bus.getBusFare(), bus.getRoute().getDistance()))
							.collect(Collectors.toMap(bus -> i[0], bus -> bus));

		            System.out.println(" +" + "-".repeat(84) + "+");
		        } else {
		            System.out.printf("Non AC buses not available for the given criteria.\n");
		            filterBus(routeBusMap);
		        }
			case 3:
				// Sort buses by fare
				System.out.println(" +" + "-".repeat(84) + "+");
				System.out.printf(" | %-10s | %-20s | %-10s | %-10s | %-20s |\n", "S.No", "Bus Name", "Bus Type", "Bus Fare",
						"Distance[km]");
				System.out.println(" +" + "-".repeat(84) + "+");
				busMap = routeBusMap.values().stream()
						.sorted((bus1, bus2) -> Integer.compare(bus1.getBusFare(), bus2.getBusFare()))
						.peek(bus -> System.out.printf(" | %-10d | %-20s | %-10s | %-10d | %-20d |\n", (++i[0]),
								bus.getBusName(), bus.getBusType(), bus.getBusFare(), bus.getRoute().getDistance()))
						.collect(Collectors.toMap(bus -> i[0], bus -> bus));
				System.out.println(" +" + "-".repeat(84) + "+");
				flag = false;
				break;
				//sort by descending order
			case 4:
				// Exit the filter menu
	                	busMap = routeBusMap.values().stream().collect(Collectors.toMap(bus->++i[0],bus->bus));
				break;
			default:
				// Handle invalid options
				System.out.println(" Invalid option. Please try again.");
				verify=false;
				flag = true;
				break;
			}
			}while(flag);
			if(verify==true) {
				if ( busMap.isEmpty()) {
				System.out.println(" No buses found for the selected filter.");
				filterBus(routeBusMap);
				} else {
				boolean b = true;
				while (b) {
					System.out.print(" Enter the S.No of the bus you want to choose: ");
					String chosenNumber=Validation.validateNumber(in.readLine());
					chosenBusNo = Integer.parseInt(chosenNumber);
//					System.out.println("Chosen S.No: " + chosenBusNo); 

//					// Print the current state of the busMap for debugging
//					busMap.forEach((key, value) -> {
//						System.out.println("Key: " + key + ", Bus: " + value.getBusName());
//					});
					Bus chosenBus = busMap.get(chosenBusNo);
					if (chosenBus != null) {
						value = chosenBusNo;
						b = false;
					} else {
						System.out.println(" Invalid S.No. Please try again.");
					}
				}
				
				}

			}
		} catch (NumberFormatException | OptionException|IOException | InvalidNumberException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public static Customer getCustomerDetails(int custId) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM Customer WHERE custId = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, custId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Customer customer = new Customer();
				customer.setCustid(rs.getInt("custId"));
				customer.setFirstName(rs.getString("name"));
				customer.setLastName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNumber(rs.getString("phone"));
				return customer;
			} else {
				System.out.println(" Customer not found.");
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	// for display the route based on routeSearch() method
	/**
	 * Retrieves the list of buses along with their routes from the database.
	 *
	 * @return An ArrayList of Bus objects containing bus and route details.
	 */
	public ArrayList<Bus> viewBusList() {
		Connection con = null;
//		String booksql = "select * from BUSES B join ROUTE R ON B.BUSID=R.BUS_ID WHERE R.START_LOCATION=? AND R.DESTINATION=?";
		do {
			try {
				String sql = "Select * from bus b Join route r on b.route_id=r.route_Id";
				Route route = null;
				Bus bus = null;
				con = DbConnection.getDBConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				ArrayList<Bus> listBus = new ArrayList<>();
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					route = new Route(rs.getInt("ROUTE_ID"), rs.getString("STARTLOCATION"), rs.getString("ENDLOCATION"),
							rs.getInt("DISTANCE"), rs.getInt("ESTIMATEDDURATION"));
					LocalDate busDate = rs.getDate("DAYOFROUTE").toLocalDate();
					bus = new Bus(rs.getInt("BUS_ID"), rs.getString("BUSNAME"), rs.getString("BUSTYPE"),
							rs.getInt("BUSCAPACITY"), rs.getInt("FARE"), busDate, route);
					listBus.add(bus);
				}
				return listBus;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}
	
	
	/**
	 * Allows the customer to cancel a booked ticket.
	 * This method lists all confirmed bookings for the customer that are scheduled for future dates.
	 * The customer can then select a booking to cancel.
	 */

	public void cancelTicket() {
		do {
			HashMap<Integer, Integer> cancelMap = new HashMap<>();
			try {
				int i = 0;
				String queryCancel = "select bk.bookingid,bs.busname,bk.seatNumber,bk.bookingStatus,bk.bookeddate,"
						+ "bs.dayofroute from book bk join bus bs on bk.busid=bs.bus_id where bookingStatus='Confirmed'and customer_id=? "
						+ "and bs.dayofroute>sysdate";
				PreparedStatement statement = DbConnection.getDBConnection().prepareStatement(queryCancel);
				statement.setInt(1, this.getCustid());
				ResultSet resultSet = statement.executeQuery();
				System.out.println(" +" + "-".repeat(101) + "+");
				System.out.printf(" | %-3s | %-30s | %-10s | %-12s | %-12s | %-10s |\n", "S.No", "Bus Name",
						"Seat Number", "Booking Status", "Booked Date", "Day of Travel");
				System.out.println(" +" + "-".repeat(101) + "+");
				while (resultSet.next()) {
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate bookedDate = resultSet.getDate("bookeddate").toLocalDate();
					String bookedDateString = bookedDate.format(dateFormatter);

					LocalDate bookedBusDate = resultSet.getDate("dayofroute").toLocalDate();
					String bookedBusDateString = bookedBusDate.format(dateFormatter);

					System.out.printf(" | %-4d | %-30s | %-11d | %-14s | %-12s | %-13s |\n", (++i),
							resultSet.getString("busname"), resultSet.getInt("Seatnumber"),
							resultSet.getString("BookingStatus"), bookedDateString, bookedBusDateString);

					cancelMap.put(i, resultSet.getInt(1));
					System.out.println(" +" + "-".repeat(101) + "+");
				}
				if (cancelMap.isEmpty()) {
					System.out.println("You are not yet booked..");
					break;
				} else {
//				System.out.println("How many");
					System.out.print(" Enter the Sno:");
					int busSno = Integer.parseInt(in.readLine());
					if (busSno > 0 && busSno <= cancelMap.size()) {
						String sqlUpdate = "update Book set BookingStatus='Cancelled' where Bookingid=?";
						PreparedStatement stmt = DbConnection.getDBConnection().prepareStatement(sqlUpdate);
						stmt.setInt(1, cancelMap.get(busSno));
						int row = stmt.executeUpdate();
						if (row > 0) {
							System.out.println(" Cancelled Successfully");
							break;
						}
					}
				}
			} catch (SQLException | NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} while (true);
	}
	
	/**
	 * Calculates the refund amount for a given booking based on the time remaining until the departure.
	 * The refund policy is as follows:
	 * - 100% refund if more than 24 hours before departure.
	 * - 50% refund if between 12 and 24 hours before departure.
	 * - No refund if less than 12 hours before departure.
	 *
	 * @param bookingId The ID of the booking for which the refund is to be calculated.
	 * @return The refund amount based on the time remaining until departure.
	 */
	
	private double calculateRefund(int bookingId) {
		try {
			String query = "select bs.fare, bs.dayofroute from book bk join bus bs on bk.busid=bs.bus_id where bk.bookingid=?";
			PreparedStatement statement = DbConnection.getDBConnection().prepareStatement(query);
			statement.setInt(1, bookingId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				double fare = resultSet.getDouble("fare");
				LocalDate busDate = resultSet.getDate("dayofroute").toLocalDate();
				LocalDateTime now = LocalDateTime.now();
				LocalDateTime busDateTime = busDate.atStartOfDay();

				long hoursUntilDeparture = java.time.Duration.between(now, busDateTime).toHours();

				// Refund policy: 100% refund if more than 24 hours before departure, 50% refund
				// if between 12 and 24 hours, no refund if less than 12 hours
				if (hoursUntilDeparture > 24) {
					return fare;
				} else if (hoursUntilDeparture >= 12) {
					return fare * 0.5;
				} else {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * Allows the customer to request a refund for a cancelled ticket.
	 * This method retrieves cancelled tickets for the customer and provides options to select a ticket for refund request.
	 * Upon selecting a ticket, the method calculates the refund amount and updates the booking status to 'Refund Requested'.
	 */
	public void requestRefund() {
		try {
			HashMap<Integer, Integer> refundMap = new HashMap<>();
			String queryRefund = "select bk.bookingid, bs.busname, bk.seatNumber, bk.bookingStatus, bk.bookeddate, "
					+ "bs.dayofroute from book bk join bus bs on bk.busid=bs.bus_id where bookingStatus='Cancelled' and customer_id=?";
			PreparedStatement statement = DbConnection.getDBConnection().prepareStatement(queryRefund);
			statement.setInt(1, this.getCustid());
			ResultSet resultSet = statement.executeQuery();
			int i = 0;
			System.out.println(" +" + "-".repeat(92) + "+");
			System.out.printf(" | %-4s | %-20s | %-10s | %-15s | %-12s | %-13s |\n", "S.No", "Bus Name", "Seat Number",
					"Booking Status", "Booked Date", "Day of Travel");
			System.out.println(" +" + "-".repeat(92) + "+");
			while (resultSet.next()) {
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate bookedDate = resultSet.getDate("bookeddate").toLocalDate();
				String bookedDateString = bookedDate.format(dateFormatter);

				LocalDate bookedBusDate = resultSet.getDate("dayofroute").toLocalDate();
				String bookedBusDateString = bookedBusDate.format(dateFormatter);

				System.out.printf(" | %-4d | %-20s | %-11d | %-15s | %-12s | %-13s |\n", (++i),
						resultSet.getString("busname"), resultSet.getInt("seatNumber"),
						resultSet.getString("bookingStatus"), bookedDateString, bookedBusDateString);

				refundMap.put(i, resultSet.getInt(1));
			}
			System.out.println(" +" + "-".repeat(92) + "+");
			if (refundMap.isEmpty()) {
				System.out.println(" No cancelled tickets eligible for refund.");
				return;
			}
//	        } else {
//	            System.out.println("Enter the sno of the ticket to request refund: ");
//	            int sno = Integer.parseInt(in.readLine().trim());
//	            if (sno > 0 && sno <= refundMap.size()) {
//	                int bookingId = refundMap.get(sno);
//	                double refundAmount = calculateRefund(bookingId);
//	                System.out.println("Refund Amount: $" + refundAmount);
//	            } 
			else {
				System.out.print(" Enter the sno of the ticket to request for refund: ");
				int sno = Integer.parseInt(in.readLine().trim());
				if (sno > 0 && sno <= refundMap.size()) {
					int bookingId = refundMap.get(sno);
					double refundAmount = calculateRefund(bookingId);
					System.out.println(" Refund Amount: Rs." + refundAmount);

					// Update the booking status to 'Refund Requested'
					String updateQuery = "update book set bookingStatus = 'Refund Requested' where bookingid = ?";
					PreparedStatement updateStmt = DbConnection.getDBConnection().prepareStatement(updateQuery);
					updateStmt.setInt(1, bookingId);
					int rowsUpdated = updateStmt.executeUpdate();

					if (rowsUpdated > 0) {
						System.out.println(" Refund request submitted successfully.");
					} else {
						System.out.println(" Failed to submit refund request.");
					}
				} else {
					System.out.println(" Invalid selection.");
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	// viewing booked status
//	public void viewBookStatus() {
//			try {
//				String statusForBook="select bs.busname,bk.seatNumber,bk.bookingStatus,bk.bookeddate,bs.dayofroute from book bk join bus bs on bk.busid=bs.bus_id where customer_id=? AND bookingstatus='Confirmed'";
//				PreparedStatement stmt=DbConnection.getDBConnection().prepareStatement(statusForBook);
//				stmt.setInt(1, this.getCustid());
//				ResultSet rs=stmt.executeQuery();
//				while(rs.next()) {
//					System.out.println(rs.getInt("seatnumber")+" "+rs.getString("bookingStatus")+" "+rs.getDate("bookeddate").toLocalDate());
//				}
//			}catch(Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}

	// viewing booked status
	public void viewBookStatus() {
		try {
			String statusForBook = "select bs.busname,bk.seatNumber,bk.bookingStatus,bk.bookeddate,bs.dayofroute from book bk join bus bs on bk.busid=bs.bus_id where customer_id=? AND bookingstatus='Confirmed'";
			PreparedStatement stmt = DbConnection.getDBConnection().prepareStatement(statusForBook);
			stmt.setInt(1, this.getCustid());
			ResultSet rs = stmt.executeQuery();
			System.out.println(" +" + "-".repeat(45) + "+");
			System.out.printf(" | %-3s | %-15s | %-11s |\n", "Seat Number", "Booking Status", "Booked Date");
			System.out.println(" +" + "-".repeat(45) + "+");
			while (rs.next()) {
				System.out.printf(" | %-11d | %-15s | %-11s |\n", rs.getInt("seatnumber"),
						rs.getString("bookingStatus"), rs.getDate("bookeddate").toLocalDate());
			}
			System.out.println(" +" + "-".repeat(45) + "+");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//
	public void allCustomer() {
		try {
			ArrayList<Customer> customerList = new ArrayList<>();
			Connection con = DbConnection.getDBConnection();
			String customerSql = "SELECT firstname, lastname, gender, email, username, password, phonenumber FROM customer WHERE available = 'ACTIVE'";
			PreparedStatement stmt = con.prepareStatement(customerSql);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getString("firstname"), resultSet.getString("lastname"),
						resultSet.getString("phonenumber"), resultSet.getString("gender"), resultSet.getString("email"),
						resultSet.getString("username"), resultSet.getString("password"));
			
				customerList.add(customer);
			}	
			System.out.println(" ------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf(" | %-15s | %-15s | %-15s | %-11s | %-30s | %-16s | %-16s |\n", 
                    " First Name ", "Last Name", "Phone Number", "Gender", "Email", "Username", "Password");
			System.out.println(" ------------------------------------------------------------------------------------------------------------------------------------------");

  for (Customer cust : customerList) {
      System.out.printf(" | %-15s | %-15s | %-15s | %-10s | %-30s | %-15s | %-15s |\n", 
                        cust.getFirstName(), cust.getLastName(), cust.getPhoneNumber(), 
                        cust.getGender(), cust.getEmail(), cust.getUserName(), cust.getPassword());
  }
  System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//	public void updateCustomer() {
//			HashMap<Integer,Customer> updateCustmerList=new HashMap<>();
//			String customerModify="update firstname,lastname,gender,email,username,password,phonenumber from customer where customer_id=?";
//			Connection con=DbConnection.getDBConnection();
//			try {
//			int sno=Integer.parseInt(in.readLine());
//			PreparedStatement stmt=con.prepareStatement(customerModify);
//			stmt.setInt(1, updateCustmerList.get(sno).getCustid());
//			int row=stmt.executeUpdate();
//			if(row>0) {
//				
//			}
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		}
	// updation
//	public void updateCustomer() {
//        HashMap<Integer, Customer> updateCustomerList = new HashMap<>();
//
//        // Fetch customers from the database and populate the updateCustomerList
//        populateCustomerList(updateCustomerList);
//
//        // Display the customer table
//        displayCustomerTable(updateCustomerList);
//
//        String customerModify = "UPDATE customer SET firstname = ?, lastname = ?, gender = ?, email = ?, username = ?, password = ?, phonenumber = ? WHERE customer_id = ?";
//        Connection con = DbConnection.getDBConnection();
//
//        try {
//            // Read the serial number (key) from the input
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Enter the serial number:");
//            int sno = Integer.parseInt(in.readLine());
//
//            // Retrieve the customer object from the hashmap
//            Customer customerToUpdate = updateCustomerList.get(sno);
//
//            if (customerToUpdate != null) {
//                // Prepare the SQL statement
//                PreparedStatement stmt = con.prepareStatement(customerModify);
//
//                // Set the parameters in the SQL statement
//                stmt.setString(1, customerToUpdate.getFirstName());
//                stmt.setString(2, customerToUpdate.getLastName());
//                stmt.setString(3, customerToUpdate.getGender());
//                stmt.setString(4, customerToUpdate.getEmail());
//                stmt.setString(5, customerToUpdate.getUserName());
//                stmt.setString(6, customerToUpdate.getPassword());
//                stmt.setString(7, customerToUpdate.getPhoneNumber());
//                stmt.setInt(8, customerToUpdate.getCustid());
//
//                // Execute the update
//                int row = stmt.executeUpdate();
//
//                if (row > 0) {
//                    System.out.println("Customer updated successfully.");
//                } else {
//                    System.out.println("Customer update failed.");
//                }
//            } else {
//                System.out.println("Customer not found for the given serial number.");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private static void populateCustomerList(HashMap<Integer, Customer> updateCustomerList) {
//        Connection con = DbConnection.getDBConnection();
//        String fetchCustomers = "SELECT * FROM customer";
//        
//        try (Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(fetchCustomers)) {
//            
//            int serialNumber = 1;
//            while (rs.next()) {
//                Customer customer = new Customer();
//                customer.setCustid(rs.getInt("customer_id"));
//                customer.setFirstName(rs.getString("firstname"));
//                customer.setLastName(rs.getString("lastname"));
//                customer.setGender(rs.getString("gender"));
//                customer.setEmail(rs.getString("email"));
//                customer.setUserName(rs.getString("username"));
//                customer.setPassword(rs.getString("password"));
//                customer.setPhoneNumber(rs.getString("phonenumber"));
//                
//                updateCustomerList.put(serialNumber, customer);
//                serialNumber++;
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private static void displayCustomerTable(HashMap<Integer, Customer> updateCustomerList) {
//        System.out.println("Serial No | Customer ID | First Name | Last Name | Gender | Email | Username | Phone Number");
//        System.out.println("----------------------------------------------------------------------------------------------");
//        for (Integer serialNumber : updateCustomerList.keySet()) {
//            Customer customer = updateCustomerList.get(serialNumber);
//            System.out.printf("%-10d | %-11d | %-11s | %-10s | %-6s | %-20s | %-10s | %-12s\n",
//                    serialNumber, customer.getCustid(), customer.getFirstName(), customer.getLastName(),
//                    customer.getGender(), customer.getEmail(), customer.getUserName(), customer.getPhoneNumber());
//        }
//    }
	// update 2
//	public static void updateCustomer() {
//        HashMap<Integer, Customer> updateCustomerList = new HashMap<>();
//
//        // Fetch customers from the database and populate the updateCustomerList
//        populateCustomerList(updateCustomerList);
//
//        // Display the customer table
//        displayCustomerTable(updateCustomerList);
//
//        Connection con = DbConnection.getDBConnection();
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            // Read the serial number (key) from the input
//            System.out.println("Enter the serial number:");
//            int sno = Integer.parseInt(in.readLine());
//
//            // Retrieve the customer object from the hashmap
//            Customer customerToUpdate = updateCustomerList.get(sno);
//
//            if (customerToUpdate != null) {
//                // Display the selected customer's current data
//                displayCustomerDetails(customerToUpdate);
//
//                // Prepare to update the fields
//                System.out.println("Enter new first name (leave blank to keep current):");
//                String newFirstname = in.readLine();
//                System.out.println("Enter new last name (leave blank to keep current):");
//                String newLastname = in.readLine();
//                System.out.println("Enter new gender (leave blank to keep current):");
//                String newGender = in.readLine();
//                System.out.println("Enter new email (leave blank to keep current):");
//                String newEmail = in.readLine();
//                System.out.println("Enter new username (leave blank to keep current):");
//                String newUsername = in.readLine();
//                System.out.println("Enter new password (leave blank to keep current):");
//                String newPassword = in.readLine();
//                System.out.println("Enter new phone number (leave blank to keep current):");
//                String newPhoneNumber = in.readLine();
//
//                // Prepare the SQL statement
//                String customerModify = "UPDATE customer SET firstname = ?, lastname = ?, gender = ?, email = ?, username = ?, password = ?, phonenumber = ? WHERE customer_id = ?";
//                PreparedStatement stmt = con.prepareStatement(customerModify);
//
//                // Set the parameters in the SQL statement, keeping current values if inputs are blank
//                stmt.setString(1, newFirstname.isEmpty() ? customerToUpdate.getFirstName() : newFirstname);
//                stmt.setString(2, newLastname.isEmpty() ? customerToUpdate.getLastName() : newLastname);
//                stmt.setString(3, newGender.isEmpty() ? customerToUpdate.getGender() : newGender);
//                stmt.setString(4, newEmail.isEmpty() ? customerToUpdate.getEmail() : newEmail);
//                stmt.setString(5, newUsername.isEmpty() ? customerToUpdate.getUserName() : newUsername);
//                stmt.setString(6, newPassword.isEmpty() ? customerToUpdate.getPassword() : newPassword);
//                stmt.setString(7, newPhoneNumber.isEmpty() ? customerToUpdate.getPhoneNumber() : newPhoneNumber);
//                stmt.setInt(8, customerToUpdate.getCustid());
//
//                // Execute the update
//                int row = stmt.executeUpdate();
//
//                if (row > 0) {
//                    System.out.println("Customer updated successfully.");
//                } else {
//                    System.out.println("Customer update failed.");
//                }
//            } else {
//                System.out.println("Customer not found for the given serial number.");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private static void populateCustomerList(HashMap<Integer, Customer> updateCustomerList) {
//        Connection con = DbConnection.getDBConnection();
//        String fetchCustomers = "SELECT * FROM customer";
//
//        try (Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(fetchCustomers)) {
//
//            int serialNumber = 1;
//            while (rs.next()) {
//                Customer customer = new Customer();
//                customer.setCustid(rs.getInt("customer_id"));
//                customer.setFirstName(rs.getString("firstname"));
//                customer.setLastName(rs.getString("lastname"));
//                customer.setGender(rs.getString("gender"));
//                customer.setEmail(rs.getString("email"));
//                customer.setUserName(rs.getString("username"));
//                customer.setPassword(rs.getString("password"));
//                customer.setPhoneNumber(rs.getString("phonenumber"));
//
//                updateCustomerList.put(serialNumber, customer);
//                serialNumber++;
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private static void displayCustomerTable(HashMap<Integer, Customer> updateCustomerList) {
//        System.out.println("Serial No | Customer ID | First Name | Last Name | Gender | Email | Username | Phone Number");
//        System.out.println("----------------------------------------------------------------------------------------------");
//        for (Integer serialNumber : updateCustomerList.keySet()) {
//            Customer customer = updateCustomerList.get(serialNumber);
//            System.out.printf("%-10d | %-11d | %-11s | %-10s | %-6s | %-20s | %-10s | %-12s\n",
//                    serialNumber, customer.getCustid(), customer.getFirstName(), customer.getLastName(),
//                    customer.getGender(), customer.getEmail(), customer.getUserName(), customer.getPhoneNumber());
//        }
//    }
//
//    private static void displayCustomerDetails(Customer customer) {
//        System.out.println("Customer ID: " + customer.getCustid());
//        System.out.println("First Name: " + customer.getFirstName());
//        System.out.println("Last Name: " + customer.getLastName());
//        System.out.println("Gender: " + customer.getGender());
//        System.out.println("Email: " + customer.getEmail());
//        System.out.println("Username: " + customer.getUserName());
//        System.out.println("Password: " + customer.getPassword());
//        System.out.println("Phone Number: " + customer.getPhoneNumber());
//    }
//
//	}
	public static void updateCustomer() {
		HashMap<Integer, Customer> updateCustomerList = new HashMap<>();

		// Fetch customers from the database and populate the updateCustomerList
		populateCustomerList(updateCustomerList);

		// Display the customer table
		displayCustomerTable(updateCustomerList);

		Connection con = DbConnection.getDBConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			// Read the serial number (key) from the input
			System.out.println("Enter the serial number:");
			int sno = Integer.parseInt(in.readLine());

			// Retrieve the customer object from the hashmap
			Customer customerToUpdate = updateCustomerList.get(sno);

			if (customerToUpdate != null) {
				// Display the selected customer's current data
				displayCustomerDetails(customerToUpdate);

				// Prepare to update the fields
				System.out.println("Enter new first name (enter '-' to keep current):");
				String newFirstname = sanitizeInput(in.readLine());
				System.out.println("Enter new last name (enter '-' to keep current):");
				String newLastname = sanitizeInput(in.readLine());
				System.out.println("Enter new gender (enter '-' to keep current):");
				String newGender = sanitizeInput(in.readLine());
				System.out.println("Enter new email (enter '-' to keep current):");
				String newEmail = sanitizeInput(in.readLine());
				System.out.println("Enter new username (enter '-' to keep current):");
				String newUsername = sanitizeInput(in.readLine());
				System.out.println("Enter new password (enter '-' to keep current):");
				String newPassword = sanitizeInput(in.readLine());
				System.out.println("Enter new phone number (enter '-' to keep current):");
				String newPhoneNumber = sanitizeInput(in.readLine());

				// Prepare the SQL statement
				String customerModify = "UPDATE customer SET firstname = ?, lastname = ?, gender = ?, email = ?, username = ?, password = ?, phonenumber = ? WHERE customer_id = ?";
				PreparedStatement stmt = con.prepareStatement(customerModify);

				// Set the parameters in the SQL statement, keeping current values if inputs are
				// '-'
				stmt.setString(1, newFirstname.equals("-") ? customerToUpdate.getFirstName() : newFirstname);
				stmt.setString(2, newLastname.equals("-") ? customerToUpdate.getLastName() : newLastname);
				stmt.setString(3, newGender.equals("-") ? customerToUpdate.getGender() : newGender);
				stmt.setString(4, newEmail.equals("-") ? customerToUpdate.getEmail() : newEmail);
				stmt.setString(5, newUsername.equals("-") ? customerToUpdate.getUserName() : newUsername);
				stmt.setString(6, newPassword.equals("-") ? customerToUpdate.getPassword() : newPassword);
				stmt.setString(7, newPhoneNumber.equals("-") ? customerToUpdate.getPhoneNumber() : newPhoneNumber);
				stmt.setInt(8, customerToUpdate.getCustid());

				// Execute the update
				int row = stmt.executeUpdate();

				if (row > 0) {
					System.out.println("Customer updated successfully.");
				} else {
					System.out.println("Customer update failed.");
				}
			} else {
				System.out.println("Customer not found for the given serial number.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static String sanitizeInput(String input) {
		return input.trim().isEmpty() ? "-" : input.trim();
	}

	private static void populateCustomerList(HashMap<Integer, Customer> updateCustomerList) {
		Connection con = DbConnection.getDBConnection();
		String fetchCustomers = "SELECT * FROM customer";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(fetchCustomers)) {

			int serialNumber = 1;
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustid(rs.getInt("customer_id"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setLastName(rs.getString("lastname"));
				customer.setGender(rs.getString("gender"));
				customer.setEmail(rs.getString("email"));
				customer.setUserName(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
				customer.setPhoneNumber(rs.getString("phonenumber"));

				updateCustomerList.put(serialNumber, customer);
				serialNumber++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void displayCustomerTable(HashMap<Integer, Customer> updateCustomerList) {
		System.out
				.println("Serial No | Customer ID | First Name | Last Name | Gender | Email | Username | Phone Number");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		for (Integer serialNumber : updateCustomerList.keySet()) {
			Customer customer = updateCustomerList.get(serialNumber);
			System.out.printf("%-10d | %-11d | %-11s | %-10s | %-6s | %-20s | %-10s | %-12s\n", serialNumber,
					customer.getCustid(), customer.getFirstName(), customer.getLastName(), customer.getGender(),
					customer.getEmail(), customer.getUserName(), customer.getPhoneNumber());
		}
	}

	private static void displayCustomerDetails(Customer customer) {
		System.out.println(" +------------------------------------------+");
		System.out.println(" Customer ID :   " +customer.getCustid());
		System.out.println("  First Name :   " + customer.getFirstName());
		System.out.println("   Last Name :   " + customer.getLastName());
		System.out.println("      Gender :   " + customer.getGender());
		System.out.println("       Email :   " + customer.getEmail());
		System.out.println("    Username :   " + customer.getUserName());
		System.out.println("    Password :   " + customer.getPassword());
		System.out.println(" Phone Number:   " + customer.getPhoneNumber());
		System.out.println(" +----------------------------------------------");
	}

	public void deleteCustomer() {
		HashMap<Integer, Customer> deleteCustomerMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// Step 1: Fetch and display the list of customers
			conn = DbConnection.getDBConnection();
			String fetchCustomersQuery = "SELECT Customer_id, firstname,lastname FROM Customer WHERE available = 'D'";
			stmt = conn.prepareStatement(fetchCustomersQuery);
			rs = stmt.executeQuery();

			int counter = 1;
			while (rs.next()) {
				int customerId = rs.getInt("Customer_id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastName");
				deleteCustomerMap.put(counter, new Customer(customerId, firstName, lastName));
				System.out.println(counter + ". " + firstName + ". " + lastName);
				counter++;
			}

			if (deleteCustomerMap.isEmpty()) {
				System.out.println("No customers available for deletion.");
				return;
			}

			// Step 2: Allow the user to select a customer for deletion
			System.out.println("Enter the s.no to delete:");
			int sno = Integer.parseInt(in.readLine());
			Customer customerToDelete = deleteCustomerMap.get(sno);

			if (customerToDelete == null) {
				System.out.println("Invalid selection.");
				return;
			}

			// Step 3: Proceed with the deletion
			String deleteCustomerQuery = "UPDATE Customer SET available = 'Y' WHERE Customer_id = ?";
			PreparedStatement deleteStmt = conn.prepareStatement(deleteCustomerQuery);
			deleteStmt.setInt(1, customerToDelete.getCustid());

			if (deleteStmt.executeUpdate() > 0) {
				System.out.println("Removed Successfully");
			}

		} catch (SQLException | NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public String toString() {
		return "Customer [Custid=" + customerid + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", Email=" + email + ", phoneNumber=" + phoneNumber
				+ ", gender=" + gender + "]";
	}
}