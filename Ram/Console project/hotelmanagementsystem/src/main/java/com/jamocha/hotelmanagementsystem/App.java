package com.jamocha.hotelmanagementsystem;

//import java.sql.PreparedStatement;
import java.util.Scanner;

import com.access.AccessMain;
import com.person.Customer;
import com.person.DbmsConnection;
import com.person.HouseKeeper;
import com.person.Receptionist;
import com.room.ManageRooms;
import com.room.*;
import oracle.security.crypto.util.InvalidInputException;

import com.access.AccessStaff;
import com.exception.DateValidator;
import com.exception.DefaultException;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.frontdeskstaff.CheckInOut;
import com.housekeeping.ManageHousekeep;
import com.bookrooms.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
/**
 * Hello world!
 *
 */
public class App 
{
	static boolean isLogin = false;
	static int p;
	String role=null;
	
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void main( String[] args ) 
    {
		System.out.println("*".repeat(200));
		System.out.println("\t\t\t\t\t|Welcome to RK HOTEL|");
		System.out.println("*".repeat(200));
			try {
				menu();
			} catch (NumberFormatException | IOException | SQLException | EmailException
					| PasswordException |DateValidator e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

    public static void menu() throws NumberFormatException, IOException, SQLException, EmailException, PasswordException, DateValidator {
	
    	String horizontalLine = "+---------------------------------------------+";
        String menuHeader = "|                   PROFILE                   |";
        String menuOption1 = "| 1. Customer                                 |";
        String menuOption2 = "| 2. Admin                                    |";
        String menuOption3 = "| 3. Receptionist                             |";
        String menuOption4 = "| 4. HouseKeeping                             |";
        String menuOption5 = "| 5. Exit the Hotel                           |";
        System.out.println(horizontalLine);
        System.out.println(menuHeader);
        System.out.println(horizontalLine);
        System.out.println(menuOption1);
        System.out.println(menuOption2);
        System.out.println(menuOption3);
        System.out.println(menuOption4);
        System.out.println(menuOption5);
        System.out.println(horizontalLine);
					
				 try {
					 System.out.println("\nEnter The Choice :");
					 p = readInt();
					 loginnow(p);
					}
				 catch(InvalidInputException e) {
//						System.out.println(e.getMessage());
					 menu();
					} catch (DefaultException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
	
}
	
	public static void loginnow(int p) throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DefaultException, DateValidator {
		AccessMain log = new AccessMain();
		Customer cus = new Customer();
		Receptionist receptionist = new Receptionist();
		HouseKeeper hk = new HouseKeeper();
		boolean flag=true;
//		AccessStaff staff = new AccessStaff();
		try {
			int opt1=0;
		if(p==1) {
			System.out.println("+-----------------------------------------------+");
			System.out.println("|              Menu Options                     |");
			System.out.println("+-----------------------------------------------+");
			System.out.println("| 1. Create New Account                         |");
			System.out.println("| 2. Already Existing Account                   |");
			System.out.println("| 3. Back To Main Menu                          |");
			System.out.println("+-----------------------------------------------+");
		System.out.println("\nEnter The Choice :");
		String input = sc.readLine().trim(); // Read input and trim whitespace
	     opt1 = Integer.parseInt(input);
		 if(opt1!=1 && opt1!=2 && opt1!=3)
		 {
			throw new IOException("Please Give Number between 1 and 3."); 
		 }
		}
		//System.out.println(p);
		if(p==1 && opt1==1)
		{
			 flag= log.registerCustomer();
			if(flag)
			{
				System.out.println("-".repeat(500));
				System.out.println("Log In Page");
				System.out.println("-".repeat(500));

				System.out.println("Enter your email : ");
				String email = sc.readLine();
				System.out.println("Enter your password : ");
				String password = sc.readLine();
				cus = (Customer) log.login(email, password, 1);
				if(cus!=null)
				{
					System.out.println("Login Sucessfull!!!");
					System.out.println("Welcome, "+cus.getfName());
					customerMenu(cus);
					return;
				}
				else
				{
					System.out.println("Invalid Credentials. Please Log in Again with your correct Email and password.");
					loginnow(1);
				}
			}
		}
		else if(p==1 && opt1==2)
		{
			String email = null;
			while (true) {
			    try {
			        System.out.println("Enter your email: ");
			        email = sc.readLine();

			        if (AccessMain.isValidEmail(email)) {
			            System.out.println("Email is valid!");
			            break; // Exit the loop if email is valid
			        } else {
			            System.out.println("Invalid email format or length. Please try again.");
			        }

			    } catch (IOException e) {
			        System.out.println("An error occurred while reading input.");
			        e.printStackTrace();
			        break; // Exit the loop in case of an error
			    }
			}
			System.out.println("Enter your password : ");
			String password = sc.readLine();
			
			
			cus = (Customer) log.login(email, password, p);
			if(cus!=null)
			{
				System.out.println("Login Sucessfull!!!");
				System.out.println("Welcome, "+cus.getfName());
				customerMenu(cus);
				return;
			}
			else {
				System.out.println("Invalid email or password. Please try again.");
				loginnow(p);
				
			}
			
		}
		else if(p==1 && opt1==3)
		{
			menu();
		}
		
		else if(p==5)
		{
			System.out.println("Thank you for using RK Hotel Management System. Have a great day!");
			System.exit(0);
		}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid input. Only Numbers Allowed!!!. Please enter a number");
			loginnow(p);
		}
		catch (IOException  e) {
		    System.out.println("Enter Numbers between 1 and 3. Otherwise The app will not accept");
		    
		    loginnow(p);
		}
		
		
		boolean validated=false;
		   do {
			System.out.println("Enter your email : ");
			String email = sc.readLine();
			System.out.println("Enter your password : ");
			String password = sc.readLine();
			
			switch(p) {
			
//			case 1: 
//				validated=log.login(email,password,p);
////				System.out.println(validated);
//				if(validated) {
//					System.out.println("Login Successfull!");
//					System.out.println("Welcome "+log.getFirstName());
//					//validated=true;
////					break;
//					customerMenu();
//				}
//				else {
//					System.out.println("Invalid credentials! Please Try Again");
//					validated=false;
//					
//					break;
//					//confirmation(p);
//				}
			
			case 2:
					if(email.equals("rk") && password.equals("ram@1998")) {		
						System.out.println("Welcome Admin");
						adminMenu();
						validated=true;
						break;
						
					}
					else {
						
						System.out.println("Invalid Credentials!");
						validated=false;
						break;
						
					}
					
			case 3:
				//REC
				receptionist = (Receptionist) log.login(email, password, p) ;
				if(receptionist!=null) {
//					System.out.println("Login Successfull!");
					System.out.println("Welcome Receptionist : "+receptionist.getName());
					validated=true;
					CheckInOut.checkinOut();
					break;
				}
				else {
					System.out.println("Invalid credentials! Please Try Again");
					//System.out.println("Login page,");
					validated=false;
					break;
					//confirmation(p);
					
				}
			case 4:
				HouseKeeper hk1 = (HouseKeeper) log.login(email, password, p);
				if(hk1!=null)
				{
					System.out.println("Welcome "+hk1.getName());
					validated=true;
					ManageHousekeep.manageHouseKeep();
					break;
				}
				else {
					System.out.println("Invalid Credentials! Please Try Again");
				}
			
		   
		   }}while(!validated);
		   }

	
	public static void customerMenu(Customer cus) throws NumberFormatException, IOException, SQLException, EmailException, PasswordException, DateValidator {
		RoomService rs = new RoomService();

		String horizontalLine = "+-----------------------------------------------+";
		String menuHeader = "| Customer Menu                               |";
		String menuOptions = "| 1. Show Room Types                          |\n" +
		                     "| 2. Book Rooms                               |\n" +
		                     "| 3. Show Available Rooms                     |\n" +
		                     "| 4. Show Previous Booked Rooms               |\n" +
		                     "| 5. Cancel Reservation                       |\n" +
		                     "| 6. Modify Reservation                       |\n" +
		                     "| 7. Request Service                          |\n" +
		                     "| 8. Back to Main Menu                        |";

		System.out.println(horizontalLine);
		System.out.println(menuHeader);
		System.out.println(horizontalLine);
		System.out.println(menuOptions);
		System.out.println(horizontalLine);

		
        try {
        System.out.println("\nEnter The Choice :");
        int choice = Integer.parseInt(sc.readLine());
        if (choice < 1 || choice > 8) {
            System.out.println("Invalid option. Please enter a number between 1 and 8.");
            App.customerMenu(cus);
            return;
        }
        switch (choice) {
            case 1:
                BookRoom.showTypeRooms(cus);
                break;
            case 2:
                BookRoom.bookRoomByModel(cus);
                break;
            case 3:
            	BookRoom.showAvailableRooms(cus);
            	break;
            
            case 4:
            	BookRoom.showBookedRooms(cus);
            	break;
            case 5:
            	BookRoom.cancelReservation(cus);
            	break;
            case 6:
               BookRoom.modifyReservation(cus);
                break;
            case 7:
            	RoomService.handleRoomServiceRequest(cus);
            case 8:
            	 menu();
            	break;
            default:
                System.out.println("Invalid choice. Please try again.");
                customerMenu(cus);
                break;
        }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input.Only Numbers are allowed!!!. Please enter a number.");
            customerMenu(cus); // Repeat the menu if the input is not a number
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
            // Handle other IO exceptions if needed
        }
						
		}

	public static void adminMenu() throws NumberFormatException, IOException, PasswordException, EmailException, SQLException, DefaultException, DateValidator {
		AccessStaff staff = new AccessStaff();
		String horizontalLine = "+--------------------------------------------+";
		String menuHeader = "|                Admin Menu                  |";
		String option1 = "| 1. Manage Receptionist                     |";
		String option2 = "| 2. Manage HouseKeeper                      |";
		String option3 = "| 3. Manage Rooms                            |";
		String option4 = "| 4. Generate Invoice                        |";
		String option5 = "| 5. Back To Main                            |";

		System.out.println(horizontalLine);
		System.out.println(menuHeader);
		System.out.println(horizontalLine);
		System.out.println(option1);
		System.out.println(option2);
		System.out.println(option3);
		System.out.println(option4);
		System.out.println(option5);
		System.out.println(horizontalLine);

//	    System.out.println(.getCustomer_id()+":"+cus.getfName());

	    try {
		int get2 = Integer.parseInt(sc.readLine());
		if (get2 < 1 || get2 > 5) {
            System.out.println("Invalid option. Please enter a number between 1 and 5.");
            adminMenu(); // Repeat the menu if the input is out of range
            return;
        }
		if(get2==1)
		{
			
			boolean s = staff.addReceptionist();
			if(!s)
			{
				staff.addReceptionist();
			}
			
		}
		else if(get2==2)
		{
			boolean h = staff.addHouseKeeper();
			if(!h)
			{
				staff.addHouseKeeper();
			}
			
		}
		else if(get2==3)
		{
			boolean h = staff.createRoom();
			
		}
		else if(get2==4)
		{
			 ManageRooms.generateInvoiceAndTrackPayment();
		}
		else if(get2==5)
		{
			menu();
//			isLogin=true;
			
		}
		}
		catch (NumberFormatException e) {
	        System.out.println("Invalid input. Only Numbers Allowed!!!. Please enter a number.");
	        adminMenu(); 
	    } catch (IOException e) {
	        System.out.println("Error reading input: " + e.getMessage());
	        adminMenu();
	        
	    }
	
	}


public static int readInt() throws IOException, NumberFormatException, SQLException, EmailException, PasswordException, DateValidator {
	String input = sc.readLine().trim();
    try {
        int p = Integer.parseInt(input);
        if (p < 1 || p > 5) {
        	System.out.println("Invalid profile number. Please enter a number between 1 and 5.");
            throw new InvalidInputException("Invalid profile number. Please enter a number between 1 and 5.");
            
        }
        return p;
    } catch (NumberFormatException e) {
       System.out.println("Invalid input. Only Numbers are allowed. Please enter a valid number.");
       menu();
    }
	return p;
}

}

	
	


