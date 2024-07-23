package com.access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
import java.util.Scanner;

import com.exception.DateValidator;
import com.exception.DefaultException;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.exception.PhoneNumberException;
import com.exception.RoomCreationException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.Customer;
import com.person.DbmsConnection;
import com.person.HouseKeeper;
import com.person.Receptionist;
import com.room.ManageRooms;

public class AccessStaff {
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	int employee_id1;
	String newUsername;
	String newPassword;
	String Name;
	String email1;
	long phoneNumber;
	// HOUSEKEEPER FIELDS
	int id;
	public boolean addReceptionist() throws NumberFormatException, PasswordException, EmailException, DefaultException, DateValidator {
	    try {
	    	String username = null;

	        while (true) {
	        	
	        	String horizontalLine = "+--------------------------------------------+";
	        	String optionHeader = "|           Receptionist Management         |";
	        	String option1 = "| 1. Add Receptionist                       |";
	        	String option2 = "| 2. Delete Receptionist                    |";
	        	String option3 = "| 3. Update Receptionist                    |";
	        	String option4 = "| 4. View Receptionist                      |";
	        	String option5 = "| 5. Back to Admin Menu                     |";

	        	System.out.println(horizontalLine);
	        	System.out.println(optionHeader);
	        	System.out.println(horizontalLine);
	        	System.out.println(option1);
	        	System.out.println(option2);
	        	System.out.println(option3);
	        	System.out.println(option4);
	        	System.out.println(option5);
	        	System.out.println(horizontalLine);
	        	System.out.print("Choose an action: ");

	        	int action;
	        	try {
	        	    action = Integer.parseInt(sc.readLine());
	        	    if (action < 1 || action > 5) {
	        	        throw new NumberFormatException("Error Occur");
	        	    }
	        	} catch (NumberFormatException | IOException ex) {
	        	    System.out.println("Invalid input. Please enter a number.");
	        	    continue; // Repeat the loop to ask for input again
	        	}

	        	if (action == 1) {
	        	    String email;
	        	    do {
	        	        System.out.print("Enter your email: ");
	        	        email = sc.readLine();
	        	        try {
	        	            if (!isValidEmail(email)) {
	        	                throw new EmailException("Invalid email format. Please enter a valid email address.");
	        	            }
	        	        } catch (EmailException e) {
	        	            System.out.println(e.getMessage());
	        	        }
	        	    } while (!isValidEmail(email));
	        	   
	        	    isReceptionistExists(email);
	        	   
	        	    System.out.print("Enter Name: ");
	        	    String name = sc.readLine();

	        	    // Phone number validation
	        	    String phoneNumberStr;
	        	    long phoneNumber = 0;
	        	    boolean isPhoneNumberValid = false;
	        	    do {
	        	        System.out.print("Enter phone number: ");
	        	        phoneNumberStr = sc.readLine();
	        	        try {
	        	            phoneNumber = Long.parseLong(phoneNumberStr);
	        	            contactNumberValidate(phoneNumberStr);
	        	            isPhoneNumberValid = true;
	        	        } catch (NumberFormatException e) {
	        	            System.out.println("Invalid input format. Please enter a valid phone number.");
	        	        } catch (PhoneNumberException e) {
	        	            System.out.println(e.getMessage());
	        	        } catch (Exception e) {
	        	            System.out.println("Please enter 10 digits only.");
	        	        }
	        	    } while (!isPhoneNumberValid);

	        	    // Password validation
	        	    String password=null;
	        	    do {
	        	        System.out.println("\nPassword length should be minimum length of 8\n" +
	        	                           "Password should contain at least one digit and one special character\n" +
	        	                           "Password should contain at least one lowercase or uppercase character [a or A]");
	        	        System.out.println("Enter your new password: ");
	        	        password = sc.readLine();
	        	        try {
	        	            if (!isValidPassword(password)) {
	        	                throw new PasswordException("Password does not meet requirements. Please choose a stronger password.");
	        	            }
	        	        } catch (PasswordException e) {
	        	            System.out.println(e.getMessage());
	        	        }
	        	    } while (!isValidPassword(password));

	                Receptionist obj = new Receptionist(email, password, name ,phoneNumber);
	                
	                // Insert receptionist details into the database
	                String insertQuery = "INSERT INTO receptionist (name, employee_id, password, email, phone_no) VALUES (?, empid.nextval, ?, ?, ?)";
	                PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(insertQuery);
	                ps.setString(1, obj.getName());
//	                ps.setInt(2, obj.getEmployee_id());
	                ps.setString(2, obj.getPassword());
	               
	                ps.setString(3, obj.getEmail());
	                ps.setLong(4, obj.getPhone_no());
	               
	                int rowsAffected = ps.executeUpdate();

	                if (rowsAffected > 0) {
	                    System.out.println("Receptionist added successfully!");
	                } else {
	                    System.out.println("Failed to add receptionist.");
	                }
	            } else if (action == 2) {
	                deleteReceptionist();
	            }
	            else if(action==3)
	            {
	            	updateReceptionist();
	            }
	            else if(action==4)
	            {
	            	viewReceptionist();
	            }
	            else if (action == 5) {
	            	App.adminMenu();
	                break; // Exit the loop and return to the main menu
	            } else {
	                System.out.println("Invalid action choice!");
	            }
	        }
	    } catch (IOException | SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	private boolean isValidEmail(String email) {
		String emailRegex1 = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
//	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    return email.matches(emailRegex1);
	}
	public static String contactNumberValidate(String contactNumber) throws PhoneNumberException {
	    if(!contactNumber.matches("^[9876]\\d{9}$")) {
	        throw new PhoneNumberException("Invalid Phone Number. Please Enter 10 digits ");
	    }
	    return contactNumber;
	}
	private boolean isValidPassword(String password) {
	    return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
	}

	//IsRECEPTIONIST EXIST :
	
	private boolean isReceptionistExists(String email) {
        try {
            String query = "SELECT * FROM receptionist WHERE email = ?";
            PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Returns true if the receptionist exists, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public static void viewReceptionist() {
	    try {
	        // SQL query to select all receptionists
	        String selectQuery = "SELECT * FROM receptionist";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(selectQuery);
	        ResultSet rs = ps.executeQuery();

	        // Create a list to hold Receptionist objects
	        List<Receptionist> receptionists = new ArrayList<>();

	        // Iterate over the result set and populate the list with Receptionist objects
	        while (rs.next()) {
	            String email = rs.getString("EMAIL");
	            String name = rs.getString("NAME");
	            int employeeId = rs.getInt("EMPLOYEE_ID");
	            String password = rs.getString("PASSWORD");
	            long phoneNumber = rs.getLong("PHONE_NO");

	            // Create a new Receptionist object and add it to the list
	            Receptionist receptionist = new Receptionist(email, password, name, phoneNumber);
	            receptionist.setEmployee_id(employeeId);
	            receptionist.setName(name);
	            receptionists.add(receptionist);
	        }

	        System.out.println("Receptionists:");

            // Print the header
            System.out.println("+-----------------------------------------------------------------------------------+");
            System.out.println("| Email          | Name           | Employee ID | Password      | Phone Number |");
            System.out.println("+-----------------------------------------------------------------------------------+");

            // Print each Receptionist's details using forEach and the toString() method
            receptionists.forEach(System.out::println);

            // Print the footer
            System.out.println("+-----------------------------------------------------------------------------------+");

	        // Iterate over the list and print each Receptionist's details
//	        System.out.println("+-----------------------------------------------------------------------------------+");
//	        System.out.println("| Email          | Name           | Employee ID | Password      | Phone Number |");
//	        System.out.println("+------------------------------------------------------------------------------------+");
//	        for (Receptionist receptionist : receptionists) {
//	            System.out.printf("| %-15s | %-14s | %-11d | %-12s | %-12s |\n",
//	                              receptionist.getEmail(),
//	                              receptionist.getName(),
//	                              receptionist.getEmployee_id(),
//	                              receptionist.getPassword(),
//	                              receptionist.getPhone_no());
//	        }
//	        System.out.println("+---------------------------------------------------------------------------------------+");


	        // Close resources
	        rs.close();
	        ps.close();

	    } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

		 
//
//		public boolean isEmployeeIdExists(String email) throws SQLException {
//		    String query = "SELECT * FROM receptionist WHERE email = '"+email+"'";
//		    Statement ps = DbmsConnection.getConnection().createStatement();
////		    ps.setString(1, username);
//		    boolean accept =false;
//		    ResultSet rs = ps.executeQuery(query);
//		    while(rs.next())
//		    {
////		    	System.out.println(rs.getString("email"));
//		    	if(rs.getString("email").equalsIgnoreCase(email))
//			    {
//			    	accept = true;
//		    				// Returns true if the employee ID exists, false otherwise
//			    }
//		    }
//		    if(accept)
//		    {
//		    	System.out.println("Already Exists");
//		    	try {
//		    		addReceptionist();
//				} catch (NumberFormatException | PasswordException | InvalidUsernameExceptions e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		    }
//		    return accept;
//		    
//		}
		 
		 
// UPDATE RECEPTIONIST :
	    public boolean updateReceptionist() {
	        try {
	            System.out.println("Enter email of the receptionist to update: ");
	            String email = sc.readLine();

	            // Check if the receptionist with the provided email exists
	            if (!isReceptionistExists(email)) {
	                System.out.println("Receptionist with the provided email does not exist.");
	                return false;
	            }

	            System.out.println("Select attribute to update:");
	            System.out.println("1. Name");
	            System.out.println("2. Email");
	            System.out.println("3. Phone Number");
	            System.out.print("Enter option: ");
	            int option = Integer.parseInt(sc.readLine());

	            switch (option) {
	                case 1:
	                    System.out.println("Enter new name: ");
	                    String newName = sc.readLine();
	                    updateName(email, newName);
	                    break;
	                case 2:
	                    System.out.println("Enter new email: ");
	                    String newEmail = sc.readLine();
	                    updateEmail(email, newEmail);
	                    break;
	                case 3:
	                    System.out.println("Enter new phone number: ");
	                    long newPhoneNumber = Long.parseLong(sc.readLine());
	                    updatePhoneNumber(email, newPhoneNumber);
	                    break;
	                default:
	                    System.out.println("Invalid option. Please select a valid attribute to update.");
	                    return false;
	            }
	            return true;
	        } catch (IOException | NumberFormatException | SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	            return false;
	        }
	    }

	    private void updateName(String email, String newName) throws SQLException {
	        String updateQuery = "UPDATE receptionist SET NAME = ? WHERE EMAIL = ?";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	        ps.setString(1, newName);
	        ps.setString(2, email);
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Receptionist's name updated successfully!");
	        } else {
	            System.out.println("Failed to update receptionist's name.");
	        }
	    }

	    private void updateEmail(String oldEmail, String newEmail) throws SQLException {
	    	 String updateQuery = "UPDATE receptionist SET EMAIL = ? WHERE EMAIL = ?";
	    	    PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	    	    ps.setString(1, newEmail);
	    	    ps.setString(2, oldEmail);
	    	    int rowsAffected = ps.executeUpdate();
	    	    if (rowsAffected > 0) {
	    	        System.out.println("Receptionist's email updated successfully!");
	    	    } else {
	    	        System.out.println("Failed to update receptionist's email.");
	    	    }
	    }

	    private void updatePhoneNumber(String email, long newPhoneNumber) throws SQLException {
	    	 String updateQuery = "UPDATE receptionist SET PHONE_NO = ? WHERE EMAIL = ?";
	    	    PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	    	    ps.setLong(1, newPhoneNumber);
	    	    ps.setString(2, email);
	    	    int rowsAffected = ps.executeUpdate();
	    	    if (rowsAffected > 0) {
	    	        System.out.println("Receptionist's phone number updated successfully!");
	    	    } else {
	    	        System.out.println("Failed to update receptionist's phone number.");
	    	    }
	    }

//	    private boolean isReceptionistExists(String email) {
//	        try {
//	            String query = "SELECT * FROM receptionist WHERE email = ?";
//	            PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
//	            ps.setString(1, email);
//	            ResultSet rs = ps.executeQuery();
//	            return rs.next(); // Returns true if the receptionist exists, false otherwise
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            return false;
//	        }
//	    }


		public boolean deleteReceptionist() {
		    try {
		        while (true) {
		            System.out.print("Enter email of receptionist to delete: ");
		            String email = sc.readLine();

		            // Delete receptionist from database
		            String deleteQuery = "DELETE FROM receptionist WHERE email = ?";
		            PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(deleteQuery);
		            ps.setString(1, email);
		            int rowsAffected = ps.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                System.out.println("Receptionist deleted successfully!");
		                break; // Exit the loop if receptionist is deleted successfully
		            } else {
		                System.out.println("Failed to delete receptionist. Receptionist not found.");
		                System.out.println("Do you want to try again? (Y/N)");
		                String choice = sc.readLine();
		                if (!choice.equalsIgnoreCase("Y")) {
		                    break; // Exit the loop and return to main menu if user chooses not to try again
		                }
		            }
		        }
		    } catch (SQLException e) {
                System.out.println("Error deleting receptionist from the database: " + e.getMessage());
                System.out.println("Please try again later or contact support.");
                return false;
            }
        
     catch (IOException e) {
        System.out.println("Error reading input: " + e.getMessage());
        System.out.println("Please try again.");
        return false;
    }
    return true;
		}
		
		
		//INSERT AND DELETE HOUSEKEEPER :
		public boolean addHouseKeeper() throws PasswordException, EmailException, NumberFormatException, DefaultException, DateValidator {
		    try {
		        while (true) {
		        	System.out.println("+------------------------------------------+");
		        	System.out.println("|              HouseKeeper Menu            |");
		        	System.out.println("+------------------------------------------+");
		        	System.out.println("| 1. Add HouseKeeper                       |");
		        	System.out.println("| 2. Delete HouseKeeper                    |");
		        	System.out.println("| 3. Update HouseKeeper                    |");
		        	System.out.println("| 4. View HouseKeeper                      |");
		        	System.out.println("| 5. Back to Admin Menu                    |");
		        	System.out.println("+------------------------------------------+");
		        	System.out.print("Choose an action: ");

		            int action ;
		            try {
		                action = Integer.parseInt(sc.readLine());
		                if(action!=1 && action!=2 && action!=3 && action!=4 && action!=5 )
		                {
		                	throw new NumberFormatException("Error Occur");
		                }
		            } catch (NumberFormatException ex) {
		                System.out.println("Invalid input. Please enter a number given in the console.");
		                continue; 
		            }
		            catch(IOException ex)
		            {
		            	System.out.println("Invalid Input. Please enter number only!!!");
		            	continue;
		            }
		            if (action == 1) {
		                System.out.println("Enter Name :");
		                 String name = sc.readLine();
		                 
//		                 System.out.println("Enter Email : ");
//		                 String email = sc.readLine();
		                 String email;
			        	    do {
			        	        System.out.print("Enter your email: ");
			        	        email = sc.readLine();
			        	        try {
			        	            if (!isValidEmail(email)) {
			        	                throw new EmailException("Invalid email format. Please enter a valid email address.");
			        	            }
			        	        } catch (EmailException e) {
			        	            System.out.println(e.getMessage());
			        	        }
			        	    } while (!isValidEmail(email));
		                 
//		                 System.out.println("Enter Phone_no : ");
//		                 long phone = Long.parseLong(sc.readLine());
		                 String phoneNumberStr;
			        	    long phoneNumber = 0;
			        	    boolean isPhoneNumberValid = false;
			        	    do {
			        	        System.out.print("Enter phone number: ");
			        	        phoneNumberStr = sc.readLine();
			        	        try {
			        	            phoneNumber = Long.parseLong(phoneNumberStr);
			        	            contactNumberValidate(phoneNumberStr);
			        	            isPhoneNumberValid = true;
			        	        } catch (NumberFormatException e) {
			        	            System.out.println("Invalid input format. Please enter a valid phone number.");
			        	        } catch (PhoneNumberException e) {
			        	            System.out.println(e.getMessage());
			        	        } catch (Exception e) {
			        	            System.out.println("Please enter 10 digits only.");
			        	        }
			        	    } while (!isPhoneNumberValid);
		                 
//		                 System.out.println("Enter Password :");
//			                String pass = sc.readLine();
			             // Password validation
				            String pass;
				            do {
				                System.out.println("\nPassword length should be minimum length of 8\n" +
				                                   "Password should contain at least one digit and one special character\n" +
				                                   "Password should contain at least one lowercase or uppercase character [a or A]");
				                System.out.println("Enter your new password: ");
				                pass = sc.readLine();
				                try {
				                    if (!isValidPassword(pass)) {
				                        throw new PasswordException("Password does not meet requirements. Please choose a stronger password.");
				                    }
				                } catch (PasswordException e) {
				                    System.out.println(e.getMessage());
				                }
				            } while (!isValidPassword(pass));
			                
		                // If the housekeeper ID is unique, proceed with adding housekeeper details
//		                System.out.print("Enter Last Clean Date (YYYY-MM-DD): ");
//		                String lastCleanDateStr = sc.readLine().trim();
//		                LocalDate lastdate = LocalDate.parse(lastCleanDateStr);
//		               System.out.println(); 
//		                System.out.print("Enter Next Clean Date: ");
//		                String nextCleanDateStr = sc.readLine().trim();
//		                LocalDate nextdate = LocalDate.parse(nextCleanDateStr);
			                String lastdate = "";
				             String nextdate = "";
		                LocalDate checkinDate = null;
			             LocalDate checkoutDate = null;

			             do {
			                 // Prompt the user to enter the check-in date
			                 System.out.println("Enter Last Clean Date (YYYY-MM-DD): ");
			                 lastdate = sc.readLine();

			                 try {
			                     // Parse the input into a LocalDate object
			                     checkinDate = LocalDate.parse(lastdate);

			                     // Check if the check-in date is in the past
			                     if (checkinDate.isBefore(LocalDate.now().minusMonths(action))) {
			                         System.out.println("Cannot Clean rooms for the past. Please choose a future date to Clean!");
			                         continue; // Continue the loop to prompt the user again
			                     }

			                     // Prompt the user to enter the check-out date
			                     System.out.println("Enter Next Clean Date (yyyy-MM-dd): ");
			                     nextdate = sc.readLine();

			                     // Parse the input into a LocalDate object
			                     checkoutDate = LocalDate.parse(nextdate);

			                     // Check if the check-out date is before the check-in date
			                     if (checkoutDate.isBefore(checkinDate)) {
			                         System.out.println("Check-Out date must be after the Check-In date. Please enter a valid Check-Out date.");
			                         continue; // Continue the loop to prompt the user again
			                     }

			                 } catch (DateTimeParseException e) {
			                     // Handle parsing errors
			                     System.out.println("Please enter the date in the format: yyyy-MM-dd");
			                     continue; // Continue the loop to prompt the user again
			                 }

			                 // If the code reaches here, both dates are valid
			                 break; // Exit the loop

			             } while (true);
		                HouseKeeper hk = new HouseKeeper(name, email, phoneNumber, pass, checkinDate, checkoutDate);
		                // Insert receptionist details into the database
		                String insertQuery = "INSERT INTO housekeeper (name, keeper_id, email, phone_no, password, last_clean, next_clean) VALUES (?, hkid.nextval, ?, ?, ?, ?, ?)";
		                PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(insertQuery);
		                ps.setString(1, hk.getName());
		                ps.setString(2, hk.getEmail());
		                ps.setLong(3, hk.getPhone_no());
		                ps.setString(4, hk.getPassword());
		                ps.setDate(5, Date.valueOf(hk.getLast_clean()));
		                ps.setDate(6, Date.valueOf(hk.getNext_clean()));         
		                
		                int rowsAffected = ps.executeUpdate();
		                System.out.println(rowsAffected);
		                if (rowsAffected > 0) {
		                    System.out.println("HouseKeeper added successfully!");
		                } else {
		                    System.out.println("Failed to add HouseKeeper.");
		                }
		            } else if (action == 2) {
		                deleteHouseKeeper();
		            }
		            else if(action==3)
		            {
		            	updateHouseKeeper();
		            }
		            else if(action==4)
		            {
		            	viewHouseKeepers();
		            }
		            else if (action == 5) {
		            	App.adminMenu();
		                break; // Exit the loop and return to the main menu
		            } else {
		                System.out.println("Invalid action choice!");
		            }
		        }
		    } catch (IOException | SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		    return true;
		}
		

		// UPDATE HOUSEKEEPER 
		
		public boolean updateHouseKeeper() {
		    try {
		        System.out.print("Enter email of HouseKeeper to update: ");
		        String email = sc.readLine();

		        // Check if the housekeeper exists
		        if (!isIdExists(email)) {
		            System.out.println("HouseKeeper not found.");
		            return false;
		        }

		        System.out.println("Select the field to update:");
		        System.out.println("1. Name");
		        System.out.println("2. Phone No");
		        System.out.println("3. Last Clean Date");
		        System.out.println("4. Next Clean Date");
		        System.out.println("5. Cancel");

		        System.out.print("Choose an option: ");
		        int option = Integer.parseInt(sc.readLine());

		        String updateQuery = "";
		        PreparedStatement ps;
		        int rowsAffected;

		        switch (option) {
		            case 1:
		                System.out.println("Enter New Name:");
		                String newName = sc.readLine();
		                updateQuery = "UPDATE housekeeper SET name = ? WHERE email = ?";
		                ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
		                ps.setString(1, newName);
		                ps.setString(2, email);
		                rowsAffected = ps.executeUpdate();
		                break;
		            case 2:
		                System.out.println("Enter New Phone No:");
		                long newPhone = Long.parseLong(sc.readLine());
		                updateQuery = "UPDATE housekeeper SET phone_no = ? WHERE email = ?";
		                ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
		                ps.setLong(1, newPhone);
		                ps.setString(2, email);
		                rowsAffected = ps.executeUpdate();
		                break;
		            case 3:
		                System.out.println("Enter New Last Clean Date (YYYY-MM-DD):");
		                String newLastCleanDate = sc.readLine();
		                LocalDate lastCleanDate = LocalDate.parse(newLastCleanDate);
		                updateQuery = "UPDATE housekeeper SET last_clean = ? WHERE email = ?";
		                ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
		                ps.setDate(1, Date.valueOf(lastCleanDate));
		                ps.setString(2, email);
		                rowsAffected = ps.executeUpdate();
		                break;
		            case 4:
		                System.out.println("Enter New Next Clean Date (YYYY-MM-DD):");
		                String newNextCleanDate = sc.readLine();
		                LocalDate nextCleanDate = LocalDate.parse(newNextCleanDate);
		                updateQuery = "UPDATE housekeeper SET next_clean = ? WHERE email = ?";
		                ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
		                ps.setDate(1, Date.valueOf(nextCleanDate));
		                ps.setString(2, email);
		                rowsAffected = ps.executeUpdate();
		                break;
		            case 5:
		                return false;
		            default:
		                System.out.println("Invalid option.");
		                return false;
		        }

		        if (rowsAffected > 0) {
		            System.out.println("HouseKeeper updated successfully!");
		            return true;
		        } else {
		            System.out.println("Failed to update HouseKeeper.");
		            return false;
		        }
		    } catch (IOException | SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}


		public boolean deleteHouseKeeper() {
			
				try {
			        while (true) {
			            System.out.print("Enter email of HouseKeeper to delete: ");
			            String email = sc.readLine();
			            // Check if the housekeeper exists
			            if (!isIdExists(email)) {
			                System.out.println("HouseKeeper not found.");
			                System.out.println("Do you want to try again? (Y/N)");
			                String choice = sc.readLine();
			                if (!choice.equalsIgnoreCase("Y")) {
			                	
			                    break; // Exit the loop and return to main menu if user chooses not to try again
			                } else {
			                    continue; // Continue the loop to allow entering a new email
			                }
			            }

			            // Delete HouseKeeper from database
			            String deleteQuery = "DELETE FROM housekeeper WHERE email = ?";
			            PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(deleteQuery);
			            ps.setString(1, email);
			            int rowsAffected = ps.executeUpdate();

			            if (rowsAffected > 0) {
			                System.out.println("HouseKeeper deleted successfully!");
			                break; // Exit the loop if HouseKeeper is deleted successfully
			            } else {
			                System.out.println("Failed to delete HouseKeeper.");
			                System.out.println("Do you want to try again? (Y/N)");
			                String choice = sc.readLine();
			                if (!choice.equalsIgnoreCase("Y")) {
			                	System.out.println("Back to Housekeeper Menu");
			                    break; // Exit the loop and return to main menu if user chooses not to try again
			                }
			            }
			        }
		        }
				catch (SQLException e) {
	                System.out.println("Error deleting HouseKeeper from the database: " + e.getMessage());
	                System.out.println("Please try again later or contact support.");
	                return false;
	            }
		     catch (IOException e) {
		        System.out.println("Error reading input: " + e.getMessage());
		        System.out.println("Please try again.");
		        return false;
		    }
		    return true;
		}
			        
//			    }
//				catch (IOException | SQLException e) {
//			        e.printStackTrace();
//			        return false;
//			    }
//			    return true;
//			
//		}
		//VIEW HOUSEKEEPER 
		public boolean viewHouseKeepers() {
		    List<HouseKeeper> housekeepers = new ArrayList<>();
		    try {
		        String query = "SELECT * FROM housekeeper";
		        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            String name = rs.getString("name");
		            String email = rs.getString("email");
		            long phoneNo = rs.getLong("phone_no");
		            LocalDate lastCleanDate = rs.getDate("last_clean").toLocalDate();
		            LocalDate nextCleanDate = rs.getDate("next_clean").toLocalDate();
		            
		            HouseKeeper housekeeper = new HouseKeeper(name, email, phoneNo, lastCleanDate, nextCleanDate);
		            housekeepers.add(housekeeper);
		        }

		     // Iterate over the list and print each Receptionist's details
		        System.out.println("HouseKeeper :");
		        // Print the table header
	            System.out.println("+-----------------------------------------------------------------------------------+");
	            System.out.println("| Email          | Name           | Phone Number | Last Clean Date | Next Clean Date |");
	            System.out.println("+-----------------------------------------------------------------------------------+");

	            // Use streams to print each housekeeper's details in a formatted table
	            housekeepers.forEach(System.out::println);

	            // Print the table footer
	            System.out.println("+-----------------------------------------------------------------------------------+");

	        
		        
//		        System.out.println("+-----------------------------------------------------------------------------------+");
//		        System.out.println("| Email          | Name           | Employee ID | Password      | Phone Number 	|	  ");
//		        System.out.println("+------------------------------------------------------------------------------------+");
//		        for ( HouseKeeper housekeeper : housekeepers) {
//		            System.out.printf("| %-15s | %-14s | %-11d | %-12s | %-12s |\n",
//		            		housekeeper.getName(),
//		            		housekeeper.getEmail(),
//		            		housekeeper.getPhone_no(),
//		            		housekeeper.getLast_clean(),
//		            		housekeeper.getNext_clean());
//		        }
//		        System.out.println("+-----------------------------------------------------------------------------------+");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return false;
		    
		}


		public boolean isIdExists(String email) throws SQLException {
			String query = "SELECT * FROM housekeeper WHERE email = ?";
		    PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
		    ps.setString(1, email);
		    ResultSet rs = ps.executeQuery();
		    return rs.next(); // Returns true if the employee ID exists, false otherwise
		}
		
		public static boolean createRoom() throws SQLException, PasswordException, EmailException, DefaultException, NumberFormatException, IOException, DateValidator
		{
			System.out.println("-".repeat(500));
			System.out.println("\t\t\t\t\tManage Rooms");
			System.out.println("-".repeat(500));
			System.out.println("1. Create Room\n2. Modify Room\n3. Create Room-Type\n4. Modify Room-Type\n5. Delete Room-Type\n6. Cancel Reservation");
			System.out.println("7. Back To Admin Menu");
		    System.out.println("-".repeat(500));
		    int g = 0;
			try {
				 g = Integer.parseInt(sc.readLine());
				 if (g != 1 && g != 2 &&  g!=3 && g!=4 && g!=5 && g!=6 && g!=7) {
		                throw new RoomCreationException("Invalid choice. Please enter 1 or 2 or 3 or 4 or 5 or 6 or 7.");
		            }

				 switch(g)
				 {
				 case 1:
					  ManageRooms.createRoom();
					 
//						 App.adminMenu();
				        break;
				 case 2:
					 ManageRooms.modifyRoom();
					 break;
				 case 3:
					 ManageRooms.insertRoomType();
					 break;
				 case 4:
					 ManageRooms.modifyRoomType();
					 break;
				 case 5:
					 ManageRooms.deleteRoomType();
					 break;
				 case 6:
					 ManageRooms.cancelBookingByCustomerEmail();
					 break;
				 case 7:
					 App.adminMenu();
					 break;
				 }
			}
			catch(RoomCreationException e)
			 {
				 System.out.println("Invalid choice. Please enter 1 or 2 or 3 or 4 or 5 or 6 or 7");
				 createRoom();
			 }
			catch(IOException | NumberFormatException e)
			{
				System.out.println("Please Enter a number ");
				createRoom();
			}
			 
			return false;
			
		}

}