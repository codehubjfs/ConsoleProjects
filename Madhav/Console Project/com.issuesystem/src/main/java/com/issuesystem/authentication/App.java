package com.issuesystem.authentication;
import java.util.*;
import com.issuesystem.users.*;
import com.issuesystem.wardenmanagement.WardenManagement;
import com.issuesystem.adminmanagement.Register;
import com.issuesystem.subcategory.IssueRaise;
import com.issuesystem.supervisormanagement.SupervisorManagement;
import com.issuesystem.userdefinedxception.*;
import java.sql.*;
public class App {
	public static int rollCheck(Scanner sc) {
		
		int role=0;
		boolean inputflag=true;
		while (inputflag) {
            try {
                System.out.println();
    			System.out.println("******************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");
                System.out.println("                                                             Welcome to IssueRaise System for Hostel Management                                                              ");
                System.out.println("******************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");
                System.out.println(" 1. Student                                                            ");
                System.out.println(" 2. Warden                                                             ");
                System.out.println(" 3. SuperVisor                                                         ");
                System.out.println(" 4. Admin                                                              ");
                System.out.println(" 5. Exit                                                               ");
                System.out.println("******************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");
                System.out.print("Enter your choice: ");
    			role = Integer.parseInt(sc.next()); 
                
                if (role != 1 && role != 2 && role != 3 && role!=4 && role!=5) {
                    throw new InvalidNumberException("Please enter a valid number");
                }
                
                inputflag = false; 
            } catch (NumberFormatException e) {
            	System.out.println("--------------------------------------------------------");
                System.out.println("   !You have enter a character,Please enter a number!   ");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                sc.nextLine(); 
            } catch (InvalidNumberException e) {
            	System.out.println("--------------------------------------------------------");
                System.out.println("!"+e.getMessage()+"! ");
                System.out.println("--------------------------------------------------------");
            }
        }
		return role;

	}
	
	

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);

		//Checks the role of the users
		 int role=0;
		 role=rollCheck(sc);
		
		
		 //Getting the username and password from user
		 String username=null;
		 String password=null;
			boolean menuFlag=true;
			int count=3;
				while(menuFlag) {
					
						if (role==1 ||role==2||role==3 ||role==4) {	
					    sc.nextLine();
						System.out.print("Enter the username:");
						username=sc.next().trim();
						System.out.println();
						 
						System.out.print("Enter the password:");
						password=sc.next().trim();
						System.out.println();
						}
						String GREEN = "\u001B[32m";
						  String RESET = "\u001B[0m";
						switch(role) {
						case 1:
							String authorizeStudent=Students.authenticateStudent(username,password);
							
							if(authorizeStudent.equals("Wrong") ||authorizeStudent.equals("User not found")) {
									if(count>1) {
										count=count-1;
										if(authorizeStudent.equals("Wrong")) {
												System.out.println("!!!!!!!!You have entered wrong passowrd!!!!!!!!");
												System.out.println();
												System.out.println("---------Still you having "+count+"chance---------");
												break;	
										}
										
										if(authorizeStudent.equals("User not found")) {
											System.out.println("User not found!!!");
											System.out.println();
											
											
											System.out.println("---------Still you having "+count+" chance---------");
											break;
											
										}
									}
							
									else {
											System.out.println("You have entered wrong username and password for 3 times");
											System.out.println("So you could not enter into the system");
											String cyan=" \u001B[46m";
											System.out.println(""+cyan+"-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-THANKS FOR VISITING-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-"+RESET+"");
											
											menuFlag=false;
											break;
											
										
									}
							}
								
								
								
								
								System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
								System.out.println("║                                                                      ║");
								System.out.println("║                    "+GREEN+" Login Successfully "+RESET+"                              ║");
								System.out.println("║                                                                      ║");
								System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
								count=3;
								
							
							
								
							
				
							System.out.println(authorizeStudent);
							IssueRaise.chooseMenu(sc,username,role);
							role=rollCheck(sc);
							
							break;
						case 2:
							String authorizeWarden=Warden.authenticateWarden(username, password);
							if(authorizeWarden.equals("Wrong") ||authorizeWarden.equals("User not found")) {
								if(count>1) {
									count=count-1;
									if(authorizeWarden.equals("Wrong")) {
											System.out.println("!!!!!!!!You have entered wrong passowrd!!!!!!!!");
											System.out.println();
											System.out.println("---------Still you having "+count+"chance---------");
											break;	
									}
									
									if(authorizeWarden.equals("User not found")) {
										System.out.println("User not found!!!");
										System.out.println();
										
										
										System.out.println("---------Still you having "+count+" chance---------");
										break;
										
									}
								}
						
								else {
										System.out.println("You have entered wrong username and password for 3 times");
										System.out.println("So you could not enter into the system");
										String cyan=" \u001B[46m";
										System.out.println(""+cyan+"-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-THANKS FOR VISITING-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-"+RESET+"");
										
										menuFlag=false;
										break;
										
									
								}
						}
							
							
							
							
							System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
							System.out.println("║                                                                      ║");
							System.out.println("║                    "+GREEN+" Login Successfully "+RESET+"                              ║");
							System.out.println("║                                                                      ║");
							System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
							count=3;
			
							System.out.println(authorizeWarden);
							WardenManagement.chooseMenu(sc, username, role);
							role=rollCheck(sc);
							break;
						case 3:
							String authorizeSupervisor=Supervisor.authenticateSupervisor(username, password);
							if(authorizeSupervisor.equals("Wrong") ||authorizeSupervisor.equals("User not found")) {
									if(count>1) {
										count=count-1;
										if(authorizeSupervisor.equals("Wrong")) {
												System.out.println("!!!!!!!!You have entered wrong passowrd!!!!!!!!");
												System.out.println();
												System.out.println("---------Still you having "+count+"chance---------");
												break;	
										}
										
										if(authorizeSupervisor.equals("User not found")) {
											System.out.println("User not found!!!");
											System.out.println();
											
											
											System.out.println("---------Still you having "+count+" chance---------");
											break;
											
										}
									}
							
									else {
											System.out.println("You have entered wrong username and password for 3 times");
											System.out.println("So you could not enter into the system");
											String cyan=" \u001B[46m";
											System.out.println(""+cyan+"-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-THANKS FOR VISITING-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-"+RESET+"");
											
											menuFlag=false;
											break;
									}
							}
							
							System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
							System.out.println("║                                                                      ║");
							System.out.println("║                  "+GREEN+" Login Successfully "+RESET+"                                ║");
							System.out.println("║                                                                      ║");
							System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
							count=3;
							
							Person person=Supervisor.gettingSuperVisorName(username,password);
							
							System.out.println(authorizeSupervisor);
							SupervisorManagement.chooseMenu(sc,person);
							role=rollCheck(sc);
							break;
						case 4:
							String authorize_Admin=Admin.authenticate_Admin(username, password);
							if(authorize_Admin.equals("Wrong") ||authorize_Admin.equals("User not found")) {
								if(count>1) {
									count=count-1;
									if(authorize_Admin.equals("Wrong")) {
											System.out.println("!!!!!!!!You have entered wrong passowrd!!!!!!!!");
											System.out.println();
											System.out.println("---------Still you having "+count+"chance---------");
											break;	
									}
									
									if(authorize_Admin.equals("User not found")) {
										System.out.println("User not found!!!");
										System.out.println();
										
										
										System.out.println("---------Still you having "+count+" chance---------");
										break;
										
									}
								}
						
								else {
										System.out.println("You have entered wrong username and password for 3 times");
										System.out.println("So you could not enter into the system");
										String cyan=" \u001B[46m";
										System.out.println(""+cyan+"-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-THANKS FOR VISITING-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-"+RESET+"");
										
										menuFlag=false;
										break;
								}
						}
							System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
							System.out.println("║                                                                      ║");
							System.out.println("║                  "+GREEN+" Login Successfully "+RESET+"                                ║");
							System.out.println("║                                                                      ║");
							System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
							count=3;
							System.out.println(authorize_Admin);
							Register.toRegister();
							role=rollCheck(sc);
							break;
						case 5:
							String cyan=" \u001B[46m";
							System.out.println(""+cyan+"-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-THANKS FOR VISITING-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-"+RESET+"");
							menuFlag=false;
							break;
				
						}
					
			}
		
			
		   
		}
		
	}


