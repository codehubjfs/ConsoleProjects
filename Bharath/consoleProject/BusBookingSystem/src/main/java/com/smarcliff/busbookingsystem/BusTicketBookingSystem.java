package com.smarcliff.busbookingsystem;

/*
 * The BusTicketBookingSystem class implements an application that
 * to facilitate the booking of bus tickets for passengers.
 * @author Bharath S
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.adminutility.Route;
import com.bookingbus.Booking;
import com.bookingbus.Bus;
import com.customexception.OptionException;
import com.customexception.Validation;
import com.persondetails.Admin;
import com.persondetails.BusOperator;
import com.persondetails.Customer;
import com.persondetails.Person;
import com.persondetails.UserAuthentication;

public class BusTicketBookingSystem {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 /**
	   * This is the main method which makes use of BusTicketBookingSystem method.
	   * @param args Unused.
	   * @return Nothing.
	   * @exception IOException On input error.
	   * @see IOException
	   */
	public static void main(String args[]) {
		String message = "W E L C O M E   T O   B U S   T I C K E T   B O O K I N G   S Y S T E M";
		Thread openMsg = new Thread(new Animation(10,message));//150
		openMsg.start();
		try {
			openMsg.join();
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		BusTicketBookingSystem bus = new BusTicketBookingSystem();
		bus.consoleBusMenu();
	}

	// Display the main menu for the Bus Ticket Booking System
	private void consoleBusMenu() {
		do {
		try {
			System.out.println(" +-----------------------------------------------------+");
			System.out.println(" |              Bus Ticket Booking System              |");
			System.out.println(" +-----------------------------------------------------+");
			System.out.println(" +-----------------------------------------------------+");
			System.out.println(" | 1.Admin  |  2.Customer  |  3.Bus Operator  | 4.Exit |");
			System.out.println(" +-----------------------------------------------------+");
			System.out.print("\n Enter Your Option:");
			int option = Validation.validateOption(in.readLine().trim());
			switch (option) {
			case 1:
				adminLoginMenu();
				break;
			case 2:
				customerLoginMenu();
				break;
			case 3:
			    busOperatorLoginMenu();
				break;
			case 4:
				System.out.print(" Thank You for Visiting. Have a Great Day!");
				System.exit(0);
				break;
			default:
				System.out.println(" Invalid Choice.Please Enter the Valid Option");
				break;
			}
		} catch (IOException | OptionException e) {
			System.out.println(e.getMessage());
		}
	}while(true);
	}
	// Display the admin login menu for Bus Ticket Booking System
		private void adminLoginMenu() {
			do {
				try {
					System.out.println(" +-----------------------------------------------------+");
					System.out.println(" |     1.Login    |        2.Back        |     3.Exit  |");
					System.out.println(" +-----------------------------------------------------+");
					System.out.print(" Enter Your Option: ");
					int option = Validation.validateOption(in.readLine().trim());
					UserAuthentication authenticate = new UserAuthentication();
					switch (option) {
					case 1:
						Admin admin = authenticate.loginAsAdmin();
						if (admin != null) {
							//routeDetails(admin);
							adminUser(admin);
						} else {
							continue;
						}
						break;
					case 2:
						consoleBusMenu();
						break;
					case 3:
						System.out.print(" Thank You for Visiting. Have a Great Day!");
						System.exit(0);
						break;
					default:
						System.out.println(" Invalid Choice.Please Enter the Valid Option");
						break;
					}
				} catch (IOException | OptionException e) {
					System.out.println(e.getMessage());
				}
			} while (true);
		}
	private void adminUser(Admin admin) {
		do {
			try {
				System.out.println(" +--------------------------------------------------------------------------------------------------------------------+");
				System.out.println(" |                                             A D M I N     M E N U                                                  |");
				System.out.println(" +--------------------------------------------------------------------------------------------------------------------+");
				System.out.println(" |     1.Bus Management    |     2.Report Management   |    3. User Management    |    4.Logout    |    5.Exit	      |");
				System.out.println(" +--------------------------------------------------------------------------------------------------------------------+");
				System.out.print(" Enter Your Option: ");
				int option = Validation.validateOption(in.readLine().trim());
				switch(option) {
				case 1:{
						routeDetails(admin);
						break;
				}
				case 2:{
						System.out.print(" The function is under construction \n");
						break;
				}
				case 3:{
					usersDetails(admin);
					break;
				}
				case 4:{
					System.out.println(" Logout Successfully");
					adminLoginMenu();
					break;
				}
				case 5:
					System.out.print(" Thank You for Visiting. Have a Great Day!");
					System.exit(0);
					break;
				default:{
					System.out.println(" Invalid option");
					break;
			}
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
	}
	
	private void usersDetails(Admin admin) {
		do {
			try {
				  System.out.println(" +----------------------------------- +");
				  System.out.println(" |            User Management         |");
			      System.out.println(" +------------------------------------+");
		          System.out.println(" | 1. Register New User               |");
		          System.out.println(" | 2. List All Users                  |");
		          System.out.println(" | 3. Update User                     |");
		          System.out.println(" | 4. Delete User                     |");
		          System.out.println(" | 5. Back to Admin Menu              |");
		          System.out.println(" | 6. Exit                            |");
		          System.out.println(" +------------------------------------+");
		          System.out.print(" Enter your choice: ");
		          int option = Integer.parseInt(in.readLine());
		          UserAuthentication authenticate = new UserAuthentication();
		          BusOperator busOperator=new BusOperator();
		          Customer customer=new Customer();
		          Person user=null;
		          switch(option) {
		          case 1:{
		        	  System.out.println(" Which User You want to register[customer/busoperator]: ");
		        	  String newUser =in.readLine();
		        	  if(newUser.equalsIgnoreCase("Customer")) {
		        		  user=authenticate.registerAsCustomer();
							if(user!=null) {
								authenticate.registerAsCustomer();
							} 
							else {
								continue;
							}
							break;
		        	  }
		        	  else if(newUser.equalsIgnoreCase("BusOperator")) {
		        		  user=authenticate.registerAsBusOperator();
		        		  if(user!=null) {
		        			  authenticate.loginAsBusOperator();
		        		  }
		        		  else {
		        			  continue;
		        		  }
		        		  break;
		        	  }
		        	  break;
		          }
		          case 2:
		          {
		        	  System.out.print(" Which User You want to List[Customer/BusOperator]: ");
		        	  String newUser =in.readLine();
		        	  if(newUser.equalsIgnoreCase("Customer")) {
		        	  customer.allCustomer();
		        	  }
		        	  else if(newUser.equalsIgnoreCase("Busoperator")) {
		        	  busOperator.allOperator();
		        	  }
		        	  break;
		          }
		          case 3:{
		        	  System.out.println(" Which User You want to update[Customer/BusOperator]: ");
		        	  String newUser =in.readLine();
		        	  if(newUser.equalsIgnoreCase("Customer")) {
		        		  Customer.updateCustomer();
		        	  }
		        	  else if(newUser.equalsIgnoreCase("busoperator")) {
		        		  busOperator.updateBusOperator();
		        	  }
		        	  break;
		          }
		          case 4:{
		        	  System.out.println(" Which User You want to delete[Customer/Busoperator: ");
		        	  String newUser=in.readLine();
		        	  if(newUser.equalsIgnoreCase("customer")) {
		        		  customer.deleteCustomer();
		        	  }
		        	  else if(newUser.equalsIgnoreCase("Busoperator")) {
		        		//  busOperator.deleteBusOperator();
		        	  }
		        	  break;
		          }
		          case 5:{
		        	  adminUser(admin);
		        	  break;
		          }
		          case 6:
		          {
						System.out.print(" Thank You for Visiting. Have a Great Day!");
						System.exit(0);
						break;
		          }
		          default:
		          {
		        	  System.out.println(" Invalid option");
		        	  break;
		          }
		        	 
		          }
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
	}

	private void routeDetails(Admin admin) {
		do {
			try {
				System.out.println("\n");
				System.out.println(" +-------------------------------------------------+");
				System.out.println(" |                   BUS MANAGEMENT                |");
				System.out.println(" +-------------------------------------------------+");
				System.out.println(" | 1. Add Bus Route Details                        |");
				System.out.println(" | 2. Delete Bus Route                             |");
				System.out.println(" | 3. View Route Detils                            |");
				System.out.println(" | 4. Back to Admin Menu                           |");
				System.out.println(" | 5. Exit                                         |");
				System.out.println(" +-------------------------------------------------+");
				System.out.print(" Enter Your Option: ");
				int option = Validation.validateOption(in.readLine().trim());
				Route location = new Route();
				switch (option) {
				case 1:
					location = admin.addRoute();
					if (location != null) {
						break;
					} else {
						continue;
					}
				case 2:
					admin.deleteRoute();
					break;
			/*	case 3://because if update the record means it will change the already booked person location then issues
					//if only linking to update means then seperataly link to booking person but how it  means we will add more column in existing table
					System.out.println("Updating Bus Details...");
					admin.updateRoute();
					break;*/
				case 3:
					admin.viewRoute(); 
					break;
				case 4:
					//adminLoginMenu();
					adminUser(admin);
					break;
				case 5:
					System.out.print(" Thank You for Visiting. Have a Great Day!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice! Please Enter a Valid Option.");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		
	}

	//Display the customer login menu
	private void customerLoginMenu() {
		do {
			try {
				System.out.println(" Welcome to access as Customer!");
				System.out.println(" +--------------------------------------------------+");
				System.out.println(" |  1.Login  |  2.Register   |   3.Back   |  4.Exit |");
				System.out.println(" +--------------------------------------------------+");
				System.out.print("\n Enter Your Option: ");
				int option = Validation.validateOption(in.readLine().trim());
				UserAuthentication authenticate = new UserAuthentication();
				Customer customer =null; 
				switch(option) {
				case 1:	
					customer=authenticate.loginAsCustomer();
					if(customer!=null) {
//						customer.bookTicket();
						applyTravel(customer);
					}
					else {
						continue;
					}
					break;
				case 2:
					//System.out.println(" Welcome to Customer Registration!");
					customer=authenticate.registerAsCustomer();
					if(customer!=null) {
						authenticate.registerAsCustomer();
					}
					break;
				case 3:
					consoleBusMenu();
					break;
				case 4:
					System.out.println(" Thank You for Visiting. Have a Great Day! ");
					System.exit(0);
					break;
				default:
					System.out.println(" Invalid Choice.Please Enter the Valid Option");
			}
			}catch(OptionException | IOException e){
				System.out.println(e.getMessage());
			}
		}while(true);
	}

	public void applyTravel(Customer customer) {
		do {
			try {
				Booking book=new Booking();
					System.out.println(" +----------------------------+");
					System.out.println(" |  Bus Ticket Booking System |");
					System.out.println(" +----------------------------+");
					System.out.println(" | 1. Book Bus Ticket         |");
					System.out.println(" | 2. Cancel Bus Ticket       |");
					System.out.println(" | 3. Refund Request          |");
					System.out.println(" | 4. View Booked Status      |");
					System.out.println(" | 5. Back                    |");
					System.out.println(" | 6. Exit                    |");
					System.out.println(" +----------------------------+");
					System.out.print(" Enter Your Option: ");
					int option = Validation.validateOption(in.readLine().trim());
									switch(option) {
										case 1:
											customer.bookTicket();	
											break;
										case 2:
											customer.cancelTicket();
											break;
										case 3:
											customer.requestRefund();
											break;
										case 4:
											customer.viewBookStatus();
											break;
										case 5:
											consoleBusMenu();
											break;
										case 6:
											System.out.println(" Thank You for Visiting. Have a Great Day! ");
											System.exit(0);
											break;
										default:
											System.out.println(" Invalid Input.Enter Valid Input");
											break;
										}
									}catch(NumberFormatException | OptionException | IOException e) {
										System.out.println(e.getMessage());
									}
								}while(true);
							}


//	// Display the admin login menu for Bus Ticket Booking System
//	private void adminLoginMenu() {
//		do {
//			try {
//				System.out.println(" +-----------------------------------------------------+");
//				System.out.println(" |     1.Login    |        2.Back        |     3.Exit  |");
//				System.out.println(" +-----------------------------------------------------+");
//				System.out.print(" Enter Your Option: ");
//				int option = Validation.validateOption(in.readLine().trim());
//				UserAuthentication authenticate = new UserAuthentication();
//				switch (option) {
//				case 1:
//					Admin admin = authenticate.loginAsAdmin();
//					if (admin != null) {
//						routeDetails(admin);
//					} else {
//						continue;
//					}
//					break;
//				case 2:
//					consoleBusMenu();
//					break;
//				case 3:
//					System.out.print(" Thank You for Visiting. Have a Great Day!");
//					System.exit(0);
//					break;
//				default:
//					System.out.println(" Invalid Choice.Please Enter the Valid Option");
//					break;
//				}
//			} catch (IOException | OptionException e) {
//				System.out.println(e.getMessage());
//			}1
//		} while (true);
//	}
	private void busOperatorLoginMenu() {
		do {
			try {
				System.out.println(" +------------------------------------------------------------------------+");
				System.out.println(" |     1.Login     |     2.Register     |     3.Back     |     4.Exit     |");
				System.out.println(" +------------------------------------------------------------------------+");
				System.out.print(" Enter Your Option: ");
				int option = Validation.validateOption(in.readLine().trim());
				UserAuthentication authenticate = new UserAuthentication();
				BusOperator operator;
				switch (option) {
				case 1:
					operator=authenticate.loginAsBusOperator();
					if (operator != null) {
						busUser(operator);
						//busDetails(operator);
					} else {
						continue;
					}
					break;
				case 2:
					operator=authenticate.registerAsBusOperator();
					if(operator!=null) {
						authenticate.registerAsBusOperator();
					}
					break;
				case 3:
					consoleBusMenu();
					break;
				case 4:
					System.out.print(" Thank You for Visiting. Have a Great Day!");
					System.exit(0);
					break;
				default:
					System.out.println(" Invalid Choice.Please Enter the Valid Option");
					break;
				}
			} catch (IOException | OptionException e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}

	private void busUser(BusOperator operator) {
		do {
		try {
		System.out.println(" +---------------------------------------+");
		System.out.println(" |              Bus Operator             |");
		System.out.println(" +---------------------------------------+");
		System.out.println(" | 1. Bus Service Management	         |");
		System.out.println(" | 2. Booking Management                 |");
		System.out.println(" | 3. Back                               |");
		System.out.println(" | 4. Exit                               |");
		System.out.println(" +---------------------------------------+");
		System.out.print(" Enter Your Option:");
		int option=Integer.parseInt(in.readLine().trim());
		switch(option) {
		case 1:{
			busDetails(operator);
			break;
		}
		case 2:
		{
			bookedDetails(operator);
			break;
		}
		case 3:
			{
				busOperatorLoginMenu();
				break;		
			}
		case 4:{
			System.out.println(" Thank You for Visiting. Have a Great Day!");
			System.exit(0);
		}
		default:
		{
			System.out.println("Invalid Choice .choose correct option");
			break;
		}
		}
		
		}catch(Exception e) {
			System.out.println();
		}
		}while(true);
		
	}

	private void bookedDetails(BusOperator operator) {
		do {
			System.out.println(" +-------------------------+");
			System.out.println(" |   Booking Management    |");
			System.out.println(" +-------------------------+");
			System.out.println(" |  1.Booked Tickets       |");
			System.out.println(" |  2.Requested Refund     |");
			System.out.println(" |  3.Cancelled Ticket     |");
			System.out.println(" |  4.Back                 |");
			System.out.println(" |  5.Exit                 |");
			System.out.println(" +-------------------------+");
			System.out.print(" Enter Your Option:");
			int option;
			try {
				option = Integer.parseInt(in.readLine().trim());
			
			switch(option) {
			case 1:{
				operator.viewBookedTickets(operator);
				break;
			}
			case 2:{
				operator.requestedRefund(operator);
				break;
			}
			case 3:{
				//operator.viewCancelledTickets();
				break;
			}
			case 4:{
				busUser(operator);
				break;
			}
			case 5:{
				System.out.println(" Thank You for Visiting. Have a Great Day!");
				break;
			}
			default:{
				System.out.println(" Entered option is not in choice");
				break;
			}
		}
			}catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}while(true);
	} 

	/**
	 * This method displays the admin menu for managing bus route details. The admin
	 * can choose to add, delete, update, or view bus route details, go back to the
	 * previous menu, or exit the program.
	 */
//	private void routeDetails(Admin admin) {
//		do {
//			try {
//				System.out.println("\n");
//				System.out.println(" +-------------------------------------------------+");
//				System.out.println(" |                   ADMIN                         |");
//				System.out.println(" +-------------------------------------------------+");
//				System.out.println(" | 1. Add Bus Route Details                        |");
//				System.out.println(" | 2. Delete Bus Route                             |");
//				System.out.println(" | 3. View Route Detils                            |");
//				System.out.println(" | 4. Back                                         |");
//				System.out.println(" | 5. Exit                                         |");
//				System.out.println("+--------------------------------------------------+");
//				System.out.print(" Enter Your Option: ");
//				int option = Validation.validateOption(in.readLine().trim());
//				Route location = new Route();
//				switch (option) {
//				case 1:
//					location = admin.addRoute();
//					if (location != null) {
//						break;
//					} else {
//						continue;
//					}
//				case 2:
//					admin.deleteRoute();
//					break;
//			/*	case 3://because if update the record means it will change the already booked person location then issues
//					//if only linking to update means then seperataly link to booking person but how it  means we will add more column in existing table
//					System.out.println("Updating Bus Details...");
//					admin.updateRoute();
//					break;*/
//				case 3:
//					admin.viewRoute(); 
//					break;
//				case 4:
//					adminLoginMenu();
//					break;
//				case 5:
//					System.out.print(" Thank You for Visiting. Have a Great Day!");
//					System.exit(0);
//					break;
//				default:
//					System.out.println("Invalid Choice! Please Enter a Valid Option.");
//					break;
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		} while (true);
//	} 
	//bus operator
	private void busDetails(BusOperator operator) {
		do {
			try {
				System.out.println("\n");
				System.out.println(" +-----------------------------------------------------+");
				System.out.println(" |               2.Bus Service Management              |");
				System.out.println(" +-----------------------------------------------------+");
				System.out.println(" | 1. Add Bus Details                                  |");
				System.out.println(" | 2. Delete Bus Details                               |");
				System.out.println(" | 3. Update Bus Fares and Route                       |");
				System.out.println(" | 4. View Bus Details                                 |");
				System.out.println(" | 5. Back                                             |");
				System.out.println(" | 6. Exit                                             |");
				System.out.println(" +-----------------------------------------------------+");
				System.out.print(" Enter Your Option: ");
					int option = Validation.validateOption(in.readLine().trim());
					Bus bus=new Bus();
					switch (option) {
					//Add Bus
					case 1:
						operator.addBus();
						if (bus != null) {
							break;
						} 
					//Delete Bus
					case 2:
						operator.deleteBus();
						break;
					//Update Bus routes and fares
					case 3:
						System.out.print(" Enter the bus Name: ");
						String busName = in.readLine();
						bus = new Bus(busName);
						operator.updateBusFare(bus);
						break;
					//view Bus
					case 4:
						operator.viewBus(); 
						break;
					//go back
					case 5:
						busOperatorLoginMenu();
						break;
					//exit
					case 6:
						System.out.println("Thank You for Visiting..");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice.Enter a valid option.");
						break;
					}
				}catch(OptionException | IOException e) {
				System.out.println(e.getMessage());
				}	
	}while(true);
	}
}
