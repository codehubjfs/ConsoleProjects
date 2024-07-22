package com.carrentalsystem.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;

import com.carrentalsystem.car.CarManagement;
import com.carrentalsystem.exception.InvalidEmailException;
import com.carrentalsystem.exception.NumberException;
import com.carrentalsystem.exception.PasswordException;
import com.carrentalsystem.exception.UsernameException;
import com.carrentalsystem.exception.Validate;
import com.carrentalsystem.rental.RentalPackageManagement;

public class UserDriver {
	static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	//this method is the index of the application
     public static void mainMenu() {
    	 
    	 boolean flag=true;
 		while(flag) {
 			System.out.println("=".repeat(200));
 			System.out.println(" ".repeat(60)+"WELCOME TO கோTRIP");
 			System.out.println("=".repeat(200));
 			System.out.println("1.ADMIN\n2.USER\n3.GUEST\n4.REGISTER\n5.EXIT\n ENTER A OPTION:");
 			System.out.println(".".repeat(200));
 			Account account=new Account();
 			try {
				int option=Validate.ValidateNumber(sc.readLine());
				switch(option) {
				case 1:
					Admin();
					break;
				case 2:
					User();
					break;
				case 3:
					guest();
					break;
				case 4:
					
					account.reg();
					break;
				case 5:
					System.out.println("Thank You For Visiting");
					System.exit(0);
				default:
					System.out.println("Enter a Valid Number");
					mainMenu();
					break;
				}
				
	
			} catch (NumberException e) {
				System.out.println(e.getMessage());
			}catch (IOException e) {
				e.printStackTrace();
			}catch(PasswordException e) {
				System.out.println(e.getMessage());
				mainMenu();
			} catch (SQLException e) {
				
			} catch (UsernameException e) {
				System.out.println(e.getMessage());
				mainMenu();
			}
 		}
     }
     //this method has the functionalities of guest
     private static void guest() {
    	 int option;
		try {
			String[] options = {"1. VIEW CARS", "2. SEARCH CARS", "3. VIEW RENTAL PACKAGES", "4. GO BACK"};
			int width = 26; // Set a fixed width for the box
			System.out.println("-".repeat(width) + "\n" + String.join("\n", Arrays.stream(options).map(s -> String.format("| %-23s |", s)).toArray(String[]::new)) + "\n" + "-".repeat(width));

			option = Validate.ValidateNumber(sc.readLine());
			switch(option) {
			case 1:
				CarManagement.showGuest();
				guest();
				break;
			case 2:
				CarManagement.search();
				guest();
				break;
			case 3:
				RentalPackageManagement rent= new RentalPackageManagement();
				rent.viewrental();
				guest();
				break;
			case 4:
				mainMenu();
				break;
//				System.out.println("Thank You For Visiting");
//				System.exit(0);
			default:
				System.out.println("Enter a Valid Number");
				guest();
				break;
			}
		} catch (NumberException e) {
			System.out.println("Enter a Valid Number:");
			guest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			guest();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			}
     
	//it has the functionalities of customer
	private static void User() {
		String[] options = {"1. Login", "2. Go Back", "3. Exit"};
		int width = 13; // Set a fixed width for the box
		System.out.println("USER\n" + "-".repeat(width) + "\n" 
		+ String.join("\n", Arrays.stream(options).map(s -> String.format("| %-10s |", s)).toArray(String[]::new)) +
		"\n" + "-".repeat(width));

		boolean flag=false;
		do
		{
		try {
			int option=Validate.ValidateNumber(sc.readLine());
			Account account=new Account();
			switch(option) {
			case 1:
				 try {
					if(account.login("Customer")) {
						userOperation();
					}    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case 2:
				mainMenu();
				break;
			case 3:
				System.out.println("Thank You For Visiting");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a Valid Number");
				User();
				break;
		}
		}catch (NumberException e) {
			
			System.out.println(e.getMessage());
			flag = true;
			}
			 catch (IOException e) {
					flag = true;
			System.out.println(e.getMessage());
			 }
		}while(flag);
		
		
	}
	//it has the customers functionalities
	private static void userOperation() {
		String[] options = {"1. BOOK CAR", "2. SEARCH", "3. View Cars", "4. VIEW RENTAL PACKAGES", "5. BOOK RENTAL PACKAGES", "6. HISTORY", "7. GO BACK"};
		int width = 23; // Set a fixed width for the box
		System.out.println("MENU\n" + "-".repeat(width) + "\n" + 
		String.join("\n", Arrays.stream(options).map(s -> String.format("| %-20s |", s)).toArray(String[]::new))
		+ "\n" + "-".repeat(width));
//option to choose option for user
		 int userOption;
		try {
			userOption = Validate.ValidateNumber(sc.readLine());
			 RentalPackageManagement rent= new RentalPackageManagement();
			 switch(userOption) {
			 case 1:
				try {
					CarManagement.showCars();
					userOperation();
				} catch (SQLException e){
					System.out.println("Enter Valid Details:");
				}catch(DateTimeParseException e) {
					System.out.println("Enter valid details:");
					userOperation();
					
				}userOperation();
			 break;
			 case 2:
				 try {
					CarManagement.search();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				userOperation();
				 break;
			 case 3:
				 try {
					CarManagement.view();
					userOperation();
				}
				 catch (SQLException e) {
					
				}userOperation();
				 break;
			 case 4:
				 RentalPackageManagement rental= new RentalPackageManagement();
				try {
					rent.viewrental();
				} catch (SQLException e) {
					System.out.println("Enter Valid Details:");
					userOperation();
				}
				userOperation();
			 case 5:
				 RentalPackageManagement bookRental= new RentalPackageManagement();
				 try {
					bookRental.bookrental();
				} catch (SQLException e) {
					System.out.println("Enter Valid Input: " +e.getMessage());
					userOperation();
				}catch(Exception e) {
					System.out.println("Enter Valid details:");
					userOperation();
				}userOperation();
				 break;
			 case 6:
				 try {
					 System.out.println("Booking Details:");
				 rent.viewBooking();
				 System.out.println("viewed");
				 userOperation();
				 }catch(Exception e) {
					 System.out.println("Not Booked");
					 userOperation();
				 }userOperation();
				 break;
			 case 7:
				 User();
				 break;
			 default:
				 System.out.println("Enter Valid Option:");
				 userOperation();
				 break;
			 }
			 
				 
		} catch (NumberException e) {
			System.out.println(e.getMessage());
			userOperation();
		} catch (IOException e) {
			
		}
		
	}
	//this method has the admin login
	private static void Admin() {
		String[] options = {"1. Login", "2. Go Back", "3. Exit"};
		int width = 13; // Set a fixed width for the box
		System.out.println("USER\n" + "-".repeat(width) + "\n" 
		+ String.join("\n", Arrays.stream(options).map(s -> String.format("| %-10s |", s)).toArray(String[]::new)) +
		"\n" + "-".repeat(width));
		try {
			int option=Validate.ValidateNumber(sc.readLine());
			Account account=new Account();
			switch(option) {
			case 1:{
				try {
					 //=account.login("Admin");
					if(account.login("Admin")) {
						adminManagement();
					}
				} catch (SQLException e) {
					System.out.println("Please Valid Input:");
				}
				break;				
			}
			case 2:{
				mainMenu();
				break;
			}case 3:{
				System.out.println("Thank You For Visiting");
				System.exit(0);
			}default:
				System.out.println("Enter a Valid Number");
				Admin();
				break;
				
			}
			
			
			
		
		} catch (NumberException e) {
			System.out.println(e.getMessage());
			Admin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	//admin main functionalities are in this method
	private static void adminManagement() {
		String[] options = {"1. CAR MANAGEMENT", "2. RENTAL PACKAGE MANAGEMENT", "3. USER MANAGEMENT", "4. Go Back", "5. Exit"};
		int width = 30; // Set a fixed width for the box
		System.out.println("MENU\n" + "-".repeat(width) + 
				"\n" + String.join("\n", Arrays.stream(options).map(s -> String.format("| %-27s |", s)).toArray(String[]::new)) 
				+ "\n" + "-".repeat(width));

		int carOption;
		
			try {
				carOption = Validate.ValidateNumber(sc.readLine());
				switch(carOption) {
				case 1:
			     carManagement();				
				break;
				case 2:
				packageManagement();
				break;
				case 3:
				userManagement();
				break;				
				case 4:
				Admin();
				break;
				case 5:
					System.out.println("Thank You For Visiting");
				System.exit(0);
				break;
				default:
					System.out.println("Enter Valid Option");
					adminManagement();
				}
			}catch (NumberException e) {
				System.out.println(e.getMessage());
				adminManagement();
			} catch (IOException e) {
				adminManagement();
			}
		
		
		
	    
		
		
	}
    //Modifying the user is functionality in this method
	private static void userManagement() {
		String[] options = {"1. Modify user", "2. Go back", "3. Exit"};
		int width = 18; // Set a fixed width for the box
		System.out.println("-".repeat(width) + "\n" + String.join("\n", Arrays.stream(options).map(s -> String.format("| %-15s |", s)).toArray(String[]::new)) + "\n" + "-".repeat(width));

		int userOption;
		
		try {
			userOption = Validate.ValidateNumber(sc.readLine());
			UserManagement user=new UserManagement();
			switch(userOption) {
			case 1:	
				try {
					user.manageuser();
					userManagement();
				} catch (SQLException e) {
					System.out.println("Enter Valid Id:");
					try {
						user.manageuser();
						userManagement();
					} catch (SQLException e1) {
						
					}
					
				}catch(NumberException e) {
					System.out.println("Enter Valid Input:");
					try {
						user.manageuser();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
				}
			break;
			case 2:
			adminManagement();
			break;
			case 3:
				System.out.println("Thank You For Visiting");
			System.exit(0);
			break;
			default:
				System.out.println("Enter valid Number");
				userManagement();
				break;
			}
		} catch (NumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	//all car functionalities are in this method
	public static void carManagement() {
		
		int carOption;		
		try {
			String[] options = {"1. View car", "2. AddCar", "3. Delete Car", "4. Update Car", "5. Go Back", "6. Exit"};
			int width = 20; // Set a fixed width for the box
			System.out.println("-".repeat(width) + "\n" + String.join("\n", Arrays.stream(options).map(s -> String.format("| %-15s |", s)).toArray(String[]::new)) + "\n" + "-".repeat(width));

			carOption = Validate.ValidateNumber(sc.readLine());
			CarManagement carmanage=new CarManagement();
			switch(carOption) {
			case 1:
				
				try {
					carmanage.showGuest();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				carManagement();
				break;
			case 2:
				try {
					carmanage.addcar();
					carManagement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					if(carmanage.deletecar())
					carManagement();
					else
					carmanage.deletecar();
				} catch(SQLException e){
					System.out.println("Enter valid Id:");
					try {
						carmanage.deletecar();
					} catch (SQLException e1) {
						System.out.println("Enter valid input:");
						//carmanage.deletecar();
					}
				}
				break;
			case 4:
				try {
					carmanage.updatecar();
					carManagement();
					break;
				} catch (NumberException e) {
					System.out.println("Enter Valid Number:");
					
					try {
						carmanage.updatecar();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						
					}
				}catch(SQLException e) {
					System.out.println("Give Valid Input");
					try {
						carmanage.updatecar();
					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
					}
				}
				
				break;
			case 5:
				adminManagement();
				break;
			case 6:
				System.out.println("Thank You For Visiting");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid Number:");
				carManagement();
				break;
				
			}
		} 
		
		catch (NumberException e) {
			System.out.println(e.getMessage());
			carManagement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	//all rental packages functionalities are in the method
	private static void packageManagement() {
		String[] options = {"1. AddRent", "2. Delete Rent", "3. Update Rent", "4. View Rent", "5. Go Back", "6. Exit"};
		int width = 20; 
		System.out.println("-".repeat(width) + "\n" + String.join("\n", Arrays.stream(options).map(s -> String.format("| %-15s |", s)).toArray(String[]::new)) + "\n" + "-".repeat(width));

		int rentOption;
		try {
			rentOption = Validate.ValidateNumber(sc.readLine());
			RentalPackageManagement rentmanage=new RentalPackageManagement();
			switch(rentOption) {
			case 1:
				try {
					rentmanage.addrental();
					packageManagement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				try {
					rentmanage.deleterental();
				} catch (SQLException e1) {
					System.out.println("Enter Valid Id:");
					try {
						rentmanage.deleterental();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
				}catch(NumberException e) {
					System.out.println("Enter a Number");
					try {
						rentmanage.deleterental();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				packageManagement();
				break;
			case 3:
				try {
					rentmanage.updaterental();
					packageManagement();
				} catch (Exception e) {
					try {
						System.out.println("Enter Valid Input:");
						try {
							rentmanage.updaterental();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							System.out.println("Enter  Valid Input:");
						}
					}catch(Exception val) {
						
					}
				}
				break;
			case 4:
				try {
					rentmanage.viewrental();
				} catch (SQLException e) {
					System.out.println("Enter Valid Id");
					
				}
				packageManagement();
				break;
			case 5:
				adminManagement();
				break;
			case 6:
				System.out.println("Thank You For Visiting");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid Number:");
				packageManagement();
				break;
				
			}
		} catch (NumberException e) {
			System.out.println(e.getMessage());
			packageManagement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	//calling main method to run the application
	public static void main(String[] args) {
		mainMenu();

	}

}
