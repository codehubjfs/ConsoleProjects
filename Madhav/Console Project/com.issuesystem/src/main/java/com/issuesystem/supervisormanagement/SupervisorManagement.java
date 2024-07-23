package com.issuesystem.supervisormanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.issuesystem.dbconnection.DBConnection;
import com.issuesystem.userdefinedxception.EmailException;
import com.issuesystem.userdefinedxception.InvalidInputException;
import com.issuesystem.userdefinedxception.InvalidNumberException;
import com.issuesystem.users.Person;
import com.issuesystem.users.Profile;
import com.issuesystem.wardenmanagement.IssueManage;

public class SupervisorManagement {
	
	public static void chooseMenu(Scanner sc,Person person) throws SQLException, InvalidInputException, EmailException {
		boolean menuFlag=true;
		
		while(menuFlag) {
			System.out.println("1.Issue Assigned for you "+"\n2.History of Issue"+"\n3.Allocate the issue"+"\t4.Update the Status to Completed"
			+"\n5.Edit Profile"+"\n6.To back");
			System.out.print("Enter your choice: ");
			String status=null;
			try {
				int click=Integer.parseInt(sc.next());
				if(click!=1 && click!=2 && click!=3 && click!=4 &&click !=5 &&click!=6) {
				   throw new InvalidNumberException("You have entered invalid number");
				
				}
				else {		
					switch(click){
					
					case 1:
						System.out.println("+------------------------------------+");
						System.out.println("|       Issue Assigned for you       |");
						System.out.println("+------------------------------------+");
						
						
						newIssue(sc,person);
						
						
						break;
					case 2:
						System.out.println("+----------------------------+");
						System.out.println("|     History of Issue       |");
						System.out.println("+----------------------------+");
						workHistory(sc,person);
						break;
						
					case 3:
						System.out.println("+----------------------------+");
						System.out.println("|      Issue Allocation      |");
						System.out.println("+----------------------------+");
						editIssue(sc,person);
						
						break;
						
					case 4:
						System.out.println("+---------------------------------------------+");
						System.out.println("|        Update the Status to Completed       |");
						System.out.println("+---------------------------------------------+");
						statusUpdate(sc,person);
						break;
						
					case 5:
						System.out.println("+------------------------+");
						System.out.println("|     Profile change     |");
						System.out.println("+------------------------+");
//						Profile.editProfile(sc,username,role);
						break;
					case 6:
						menuFlag=false;
						break;
				
					}
				}
		
			
		}
			catch (NumberFormatException e) {
				System.out.println("--------------------------------------------------------");
                System.out.println("   !You have enter a character,Please enter a number!  ");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                sc.nextLine(); 
			}
			catch (InvalidNumberException e) {
				System.out.println("--------------------------------------------------------");
                System.out.println("!"+e.getMessage()+"! ");
                System.out.println("--------------------------------------------------------");
            }
	
		}
	}
	
	
	//New issue is raised
	public static void newIssue(Scanner sc,Person person) throws SQLException, InvalidInputException, EmailException {
		String r="Assigned";
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		String sql1="select * from issues where status=? and allocated_to=?";
		PreparedStatement stmt1=DBConnection.getDBConnextion().prepareStatement(sql1);
		stmt1.setString(1,r);
		stmt1.setString(2,person.getName());
		ResultSet rs=stmt1.executeQuery();

		List<IssueManage> issueList = new ArrayList<>();
		int back=0;
		boolean rowsFetched = false;
			while(rs.next()) {
				rowsFetched = true;
				
			}
			
			if (rowsFetched) {
				String sql2="select * from issues where status=? and allocated_to=?";
				PreparedStatement stmt2=DBConnection.getDBConnextion().prepareStatement(sql2);
				stmt2.setString(1,r);
				stmt2.setString(2,person.getName());
				ResultSet rs1=stmt1.executeQuery();
				
				while(rs1.next()) {
		            IssueManage issuemanage = new IssueManage(
		                    rs1.getInt("ISSUE_ID"),rs1.getString("ISSUE_TITLE"), rs1.getString("DESCRIPTION"),
		                    rs1.getDate("TICKET_RAISED_DATE").toLocalDate(), rs1.getInt("CATEGORY_ID"), rs1.getString("RAISED_BY"),
		                    rs1.getString("ALLOCATED_TO"), rs1.getString("PRIORITY"), 
		                    rs1.getDate("ISSUE_DATE").toLocalDate(), rs1.getString("STATUS")
		            );
		            
		            issueList.add(issuemanage);
		        }
				
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(String.format("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s",
				        "ISSUE_ID", "ISSUETITLE","DESCRIPTION", "TICKET_RAISED_DATE",
				        "CATEGORY_ID", "RAISED_BY", "ALLOCATED_TO", "PRIORITY", 
				        "ISSUE_DATE", "STATUS"));

				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
				Collections.sort(issueList);
				//Using Stream printing 
				issueList.stream().forEach(issuemanage -> {
			    	System.out.printf("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s%n",
			                issuemanage.getIssueId(), issuemanage.getIssueTitle(), issuemanage.getDescription(),
			                issuemanage.getTicketRaisedDate(), issuemanage.getCategoryId(), issuemanage.getRaisedBy(),
			                issuemanage.getAllocatedTo(), issuemanage.getPriority(), issuemanage.getIssueDate(),issuemanage.getStatus());
			        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			    });
				System.out.println();
				
			}
			else {
				System.out.println("  ╔════════════════════════════════════════════════════════════════════════════╗");
				System.out.println("  ║                                                                            ║");
				System.out.println("  ║                        No New issues Assigned                              ║");
				System.out.println("  ║                                                                            ║");
				System.out.println("  ╚════════════════════════════════════════════════════════════════════════════╝");
			}
			
			int input=goBack(sc);
	}
	
	
	
	//History of the issues that allocated for you
	public static void workHistory(Scanner sc,Person person) throws SQLException, InvalidInputException, EmailException {
		
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";

    	System.out.println(person.getName());
		List<IssueManage> issueList = new ArrayList<>();
		int back=0;

				String sql2="select * from issues where allocated_to=?";
				PreparedStatement stmt2=DBConnection.getDBConnextion().prepareStatement(sql2);
				stmt2.setString(1,person.getName());
				ResultSet rs1=stmt2.executeQuery();
				
				while(rs1.next()) {
		            IssueManage issuemanage = new IssueManage(
		                    rs1.getInt("ISSUE_ID"),rs1.getString("ISSUE_TITLE"), rs1.getString("DESCRIPTION"),
		                    rs1.getDate("TICKET_RAISED_DATE").toLocalDate(), rs1.getInt("CATEGORY_ID"), rs1.getString("RAISED_BY"),
		                    rs1.getString("ALLOCATED_TO"), rs1.getString("PRIORITY"), 
		                    rs1.getDate("ISSUE_DATE").toLocalDate(), rs1.getString("STATUS")
		            );
		            
		            issueList.add(issuemanage);
		        }
				
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(String.format("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s",
				        "ISSUE_ID", "ISSUETITLE","DESCRIPTION", "TICKET_RAISED_DATE",
				        "CATEGORY_ID", "RAISED_BY", "ALLOCATED_TO", "PRIORITY", 
				        "ISSUE_DATE", "STATUS"));

				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
				Collections.sort(issueList);
				//Using Stream printing 
				issueList.stream().forEach(issuemanage -> {
			    	System.out.printf("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s%n",
			                issuemanage.getIssueId(), issuemanage.getIssueTitle(), issuemanage.getDescription(),
			                issuemanage.getTicketRaisedDate(), issuemanage.getCategoryId(), issuemanage.getRaisedBy(),
			                issuemanage.getAllocatedTo(), issuemanage.getPriority(), issuemanage.getIssueDate(),issuemanage.getStatus());
			        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			    });
				System.out.println();
				

				int input=goBack(sc);
				
	
	}
	
	
	
	//Issue allocate for the workers 
	
	public static void editIssue(Scanner sc,Person person) throws SQLException, InvalidInputException, EmailException {
		
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		
		String status="Assigned";
		String sql1="select * from issues where status=? and allocated_to=?";
		PreparedStatement stmt1=DBConnection.getDBConnextion().prepareStatement(sql1);
		stmt1.setString(1,status);
		stmt1.setString(2,person.getName());
		ResultSet rs=stmt1.executeQuery();
		
		List<IssueManage> issueList = new ArrayList<>();
		int back=0;
		boolean rowsFetched = false;
			while(rs.next()) {
				rowsFetched = true;
				rs.getInt("Issue_id");
			}
			
			if (rowsFetched) {
				String sql2="select * from issues ";
				PreparedStatement stmt2=DBConnection.getDBConnextion().prepareStatement(sql2);
				ResultSet rs1=stmt1.executeQuery();
				
				while(rs1.next()) {
		            IssueManage issuemanage = new IssueManage(
		                    rs1.getInt("ISSUE_ID"),rs1.getString("ISSUE_TITLE"), rs1.getString("DESCRIPTION"),
		                    rs1.getDate("TICKET_RAISED_DATE").toLocalDate(), rs1.getInt("CATEGORY_ID"), rs1.getString("RAISED_BY"),
		                    rs1.getString("ALLOCATED_TO"), rs1.getString("PRIORITY"), 
		                    rs1.getDate("ISSUE_DATE").toLocalDate(), rs1.getString("STATUS")
		            );
		            
		            issueList.add(issuemanage);
		        }
				
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(String.format("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s",
				        "ISSUE_ID", "ISSUETITLE","DESCRIPTION", "TICKET_RAISED_DATE",
				        "CATEGORY_ID", "RAISED_BY", "ALLOCATED_TO", "PRIORITY", 
				        "ISSUE_DATE", "STATUS"));

				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
				Collections.sort(issueList);
				//Using Stream printing 
				issueList.stream()
			    .filter(issue -> issue.getStatus().equals("Assigned"))
			    .forEach(issuemanage -> {
			    	System.out.printf("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s%n",
			                issuemanage.getIssueId(), issuemanage.getIssueTitle(), issuemanage.getDescription(),
			                issuemanage.getTicketRaisedDate(), issuemanage.getCategoryId(), issuemanage.getRaisedBy(),
			                issuemanage.getAllocatedTo(), issuemanage.getPriority(), issuemanage.getIssueDate(),issuemanage.getStatus());
			        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			    });
				System.out.println();
				
				
				
				boolean isValid = true;
	            while (isValid) {
	                System.out.println();
	                

	                int id = 0;
	                while (isValid) {
	                    System.out.println();
	                    while (true) {
	                        try {
	                        	System.out.println("Enter the id that you are going to allocate: ");
	                            id = Integer.parseInt(sc.next());
	                            break;
	                        } catch (NumberFormatException e) {
	                            System.out.println("--------------------------------------------------------");
	                            System.out.println("   !You have entered a character, Please enter a number!   ");
	                            System.out.println("--------------------------------------------------------");
	                            System.out.println();
	                        }
	                    }

	                    // Try-with-resources for checking and updating the issue status
	                    try (Connection conn = DBConnection.getDBConnextion()) {
	                        String sqlCheck = "SELECT * FROM issues WHERE issue_id=? AND status=?";
	                        try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
	                            stmt3.setInt(1, id);
	                            stmt3.setString(2, "Assigned");
	                            try (ResultSet rs2 = stmt3.executeQuery()) {
	                                if (rs2.next()) {
	                                	break;
	                                   
	                                } else {
	                                	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	    				            	System.out.println("┃'"+red+"'Please enter an available ID. '"+reset+"'                      ┃");
	    				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	                                }
	                            }
	                        }
	                    }
	                }
	                

			System.out.println("You can choose the workers from this table ");
			
			System.out.println("----------------------------------------");
			 System.out.printf("%-10s %-20s %-20s%n", "ID", "Name", "Role");
	        System.out.println("----------------------------------------");
			
			if(person.getRole().equals("electricsupervisor")) {
				
				String sql="select * from esupervisor";
				PreparedStatement stmt=DBConnection.getDBConnextion().prepareStatement(sql);
				ResultSet rs3=stmt.executeQuery();
				while(rs3.next()) {
					 	int id1 = rs3.getInt("e_sid");
		                String name = rs3.getString("name");
		                String role = rs3.getString("role");
		                System.out.printf("%-10d %-20s %-20s%n", id1, name, role);
				}
				chooseElectrician(sc,id);
				break;
			}
			if(person.getRole().equals("foodsupervisor")) {
				String sql="select * from fsupervisor";
				PreparedStatement stmt=DBConnection.getDBConnextion().prepareStatement(sql);
				ResultSet rs3=stmt.executeQuery();
				while(rs3.next()) {
					int id1 = rs3.getInt("fu_id");
	                String name = rs3.getString("name");
	                String role = rs3.getString("role");
	                System.out.printf("%-10d %-20s %-20s%n", id1, name, role);
				}
				chooseFoodMakers(sc,id);
				break;
			}
			if(person.getRole().equals("cleaningsupervisor")) {
				String sql="select * from csupervisor";
				PreparedStatement stmt=DBConnection.getDBConnextion().prepareStatement(sql);
				ResultSet rs3=stmt.executeQuery();
				while(rs3.next()) {
					int id1 = rs3.getInt("c_sid");
	                String name = rs3.getString("name");
	                String role = rs3.getString("role");
	                System.out.printf("%-10d %-20s %-20s%n", id1, name, role);
				}
				chooseCleaners(sc,id);
				break;
			}
			if(person.getRole().equals("furnituresupervisor")) {
				String sql="select * from fursupervisor";
				PreparedStatement stmt=DBConnection.getDBConnextion().prepareStatement(sql);
				ResultSet rs3=stmt.executeQuery();
				while(rs3.next()) {
					int id1 = rs3.getInt("fu_sid");
	                String name = rs3.getString("name");
	                String role = rs3.getString("role");
	                System.out.printf("%-10d %-20s %-20s%n", id1, name, role);
				}
				chooseCarpenters(sc,id);
				break;
			}
			System.out.println("----------------------------------------");
			
			
			
			
	            }
				
			}
			else {
				System.out.println("  ╔════════════════════════════════════════════════════════════════════════════╗");
				System.out.println("  ║                                                                            ║");
				System.out.println("  ║                        No issues is Assigned                               ║");
				System.out.println("  ║                                                                            ║");
				System.out.println("  ╚════════════════════════════════════════════════════════════════════════════╝");
				
				back=goBack(sc);
				
	
			}
	
	}
	
	
	//Choosing the electrician
	public static void chooseElectrician(Scanner sc,int issueId) throws SQLException {
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		boolean isValid = true;

        while (isValid) {
            
            int id = 0;
            try {
            	System.out.print("Enter the valid id of that person from above table , that you going to allocate: ");
                id = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("--------------------------------------------------------");
                System.out.println("   !You have entered a character, Please enter a number!   ");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                continue; // Re-prompt for ID
            }

            // Try-with-resources for checking and updating the issue status
            try (Connection conn = DBConnection.getDBConnextion()) {
                String sqlCheck = "SELECT * FROM esupervisor where e_sid=?";
                try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
                	stmt3.setInt(1, id);
                    try (ResultSet rs3 = stmt3.executeQuery()) {
                        if (rs3.next()) {
                            String sql3 = "UPDATE issues SET status=? WHERE issue_id=?";
                            try (PreparedStatement stmt4 = conn.prepareStatement(sql3)) {
                                stmt4.setString(1, "In_progress");
                                stmt4.setInt(2, issueId);
                                int rowsAffected = stmt4.executeUpdate();
                                if (rowsAffected > 0) {
                                	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
    				            	System.out.println("┃'"+green+"'Allocated  Successfully '"+reset+"'        ┃");
    				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                                    
                                    isValid = false;
                                    break;
                                }
                            }
                        } else {
                        	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			            	System.out.println("┃'"+red+"'Please enter an available ID. '"+reset+"'                      ┃");
			            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println();
                        }
                    }
                }
            }
        }
	}
	
	
	//Choose the Carpenters
	public static void chooseCarpenters(Scanner sc,int issueId) throws SQLException {
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		boolean isValid = true;

        while (isValid) {
            
            int id = 0;
            try {
            	System.out.print("Enter the valid id of that person from above table , that you going to allocate: ");
                id = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("--------------------------------------------------------");
                System.out.println("   !You have entered a character, Please enter a number!   ");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                continue; // Re-prompt for ID
            }

            // Try-with-resources for checking and updating the issue status
            try (Connection conn = DBConnection.getDBConnextion()) {
                String sqlCheck = "SELECT * FROM fursupervisor where fu_sid=?";
                try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
                	stmt3.setInt(1, id);
                    try (ResultSet rs3 = stmt3.executeQuery()) {
                        if (rs3.next()) {
                            String sql3 = "UPDATE issues SET status=? WHERE issue_id=?";
                            try (PreparedStatement stmt4 = conn.prepareStatement(sql3)) {
                                stmt4.setString(1, "In_progress");
                                stmt4.setInt(2, issueId);
                                int rowsAffected = stmt4.executeUpdate();
                                if (rowsAffected > 0) {
                                	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
    				            	System.out.println("┃'"+green+"'Allocated  Successfully '"+reset+"'        ┃");
    				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                                    
                                    isValid = false;
                                    break;
                                }
                            }
                        } else {
                        	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			            	System.out.println("┃'"+red+"'Please enter an available ID. '"+reset+"'                      ┃");
			            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println();
                        }
                    }
                }
            }
        }
	}
	
	
	
	//Choose the Cleaners
	public static void chooseCleaners(Scanner sc,int issueId) throws SQLException {
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		boolean isValid = true;

        while (isValid) {
            
            int id = 0;
            try {
            	System.out.print("Enter the valid id of that person from above table , that you going to allocate: ");
                id = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("--------------------------------------------------------");
                System.out.println("   !You have entered a character, Please enter a number!   ");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                continue; // Re-prompt for ID
            }

            // Try-with-resources for checking and updating the issue status
            try (Connection conn = DBConnection.getDBConnextion()) {
                String sqlCheck = "SELECT * FROM csupervisor where c_sid=?";
                try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
                	stmt3.setInt(1, id);
                    try (ResultSet rs3 = stmt3.executeQuery()) {
                        if (rs3.next()) {
                            String sql3 = "UPDATE issues SET status=? WHERE issue_id=?";
                            try (PreparedStatement stmt4 = conn.prepareStatement(sql3)) {
                                stmt4.setString(1, "In_progress");
                                stmt4.setInt(2, issueId);
                                int rowsAffected = stmt4.executeUpdate();
                                if (rowsAffected > 0) {
                                	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
    				            	System.out.println("┃'"+green+"'Allocated  Successfully '"+reset+"'        ┃");
    				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                                    
                                    isValid = false;
                                    break;
                                }
                            }
                        } else {
                        	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			            	System.out.println("┃'"+red+"'Please enter an available ID. '"+reset+"'                      ┃");
			            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println();
                        }
                    }
                }
            }
        }
	}
	
	
	
	//Choose the FoodMakers
	public static void chooseFoodMakers(Scanner sc,int issueId) throws SQLException {
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		boolean isValid = true;

        while (isValid) {
            
            int id = 0;
            try {
            	System.out.print("Enter the valid id of that person from above table , that you going to allocate: ");
                id = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("--------------------------------------------------------");
                System.out.println("   !You have entered a character, Please enter a number!   ");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                continue; // Re-prompt for ID
            }

            // Try-with-resources for checking and updating the issue status
            try (Connection conn = DBConnection.getDBConnextion()) {
                String sqlCheck = "SELECT * FROM fsupervisor where fu_id=?";
                try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
                	stmt3.setInt(1, id);
                    try (ResultSet rs3 = stmt3.executeQuery()) {
                        if (rs3.next()) {
                            String sql3 = "UPDATE issues SET status=? WHERE issue_id=?";
                            try (PreparedStatement stmt4 = conn.prepareStatement(sql3)) {
                                stmt4.setString(1, "In_progress");
                                stmt4.setInt(2, issueId);
                                int rowsAffected = stmt4.executeUpdate();
                                if (rowsAffected > 0) {
                                	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
    				            	System.out.println("┃'"+green+"'Allocated  Successfully '"+reset+"'        ┃");
    				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                                    
                                    isValid = false;
                                    break;
                                }
                            }
                        } else {
                        	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			            	System.out.println("┃'"+red+"'Please enter an available ID. '"+reset+"'                      ┃");
			            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println();
                        }
                    }
                }
            }
        }
	}
	
	
	
	public static void statusUpdate(Scanner sc,Person person) throws SQLException {
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
    	
    	
        String r = "In_progress";
        String name=person.getName();
        String sql1 = "SELECT * FROM issues WHERE status=? and allocated_to=?";
        boolean flag = false;

        // Try-with-resources for the first query to check if there are issues with "In_Progress" status
        try (Connection conn = DBConnection.getDBConnextion();
             PreparedStatement stmt1 = conn.prepareStatement(sql1)) {

            stmt1.setString(1, r);
            stmt1.setString(2, name);
            try (ResultSet rs = stmt1.executeQuery()) {
                flag = rs.next();
            }
        }

        if (flag) {
            List<IssueManage> issueList = new ArrayList<>();
            
            // Try-with-resources for the second query to retrieve issues with "In_Progress" status
            try (Connection conn = DBConnection.getDBConnextion();
                 PreparedStatement stmt2 = conn.prepareStatement(sql1)) {

                stmt2.setString(1, r);
                stmt2.setString(2, name);
                try (ResultSet rs1 = stmt2.executeQuery()) {
                    while (rs1.next()) {
                        IssueManage issueManage = new IssueManage(
                        		 rs1.getInt("ISSUE_ID"),rs1.getString("ISSUE_TITLE"), rs1.getString("DESCRIPTION"),
     		                    rs1.getDate("TICKET_RAISED_DATE").toLocalDate(), rs1.getInt("CATEGORY_ID"), rs1.getString("RAISED_BY"),
     		                    rs1.getString("ALLOCATED_TO"), rs1.getString("PRIORITY"), 
     		                    rs1.getDate("ISSUE_DATE").toLocalDate(), rs1.getString("STATUS")
                        );
                        issueList.add(issueManage);
                    }
                }
            }

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(String.format("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s",
			        "ISSUE_ID", "ISSUETITLE","DESCRIPTION", "TICKET_RAISED_DATE",
			        "CATEGORY_ID", "RAISED_BY", "ALLOCATED_TO", "PRIORITY", 
			        "ISSUE_DATE", "STATUS"));

			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			Collections.sort(issueList);
			//Using Stream printing 
			issueList.stream().forEach(issuemanage -> {
		    	System.out.printf("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s%n",
		                issuemanage.getIssueId(), issuemanage.getIssueTitle(), issuemanage.getDescription(),
		                issuemanage.getTicketRaisedDate(), issuemanage.getCategoryId(), issuemanage.getRaisedBy(),
		                issuemanage.getAllocatedTo(), issuemanage.getPriority(), issuemanage.getIssueDate(),issuemanage.getStatus());
		        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		    });
			System.out.println();

            boolean isValid = true;

            while (isValid) {
                
                int id = 0;
                try {
                	System.out.print("Enter the id that issues has completed: ");
                    id = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("   !You have entered a character, Please enter a number!   ");
                    System.out.println("--------------------------------------------------------");
                    System.out.println();
                    continue; // Re-prompt for ID
                }

                // Try-with-resources for checking and updating the issue status
                try (Connection conn = DBConnection.getDBConnextion()) {
                    String sqlCheck = "SELECT * FROM issues WHERE issue_id=? AND status=?";
                    try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
                        stmt3.setInt(1, id);
                        stmt3.setString(2, "In_progress");
                        try (ResultSet rs3 = stmt3.executeQuery()) {
                            if (rs3.next()) {
                                String sql3 = "UPDATE issues SET status=? WHERE issue_id=?";
                                try (PreparedStatement stmt4 = conn.prepareStatement(sql3)) {
                                    stmt4.setString(1, "Completed");
                                    stmt4.setInt(2, id);
                                    int rowsAffected = stmt4.executeUpdate();
                                    if (rowsAffected > 0) {
                                    	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        				            	System.out.println("┃'"+green+"'Status Updated Successfully '"+reset+"'    ┃");
        				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                                        
                                        isValid = false;
                                        break;
                                    }
                                }
                            } else {
                            	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				            	System.out.println("┃'"+red+"'Please enter an available ID. '"+reset+"'                      ┃");
				            	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                                System.out.println();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Already all issues are Assigned");
            System.out.println("  ╔═══════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("  ║                                                                                   ║");
            System.out.println("  ║                        Already all issues are Completed                           ║");
            System.out.println("  ║                                                                                   ║");
            System.out.println("  ╚═══════════════════════════════════════════════════════════════════════════════════╝");
        }
  }
		

			
			

	//Go back Method
	public static int goBack(Scanner sc) {
		int input=0;
		boolean inputflag=true;
		while(inputflag) {
		
			try {
				System.out.print("ENTER 1 TO GO_BACK : ");
				input=Integer.parseInt(sc.next());
				if(input!=1) {
					throw new InvalidNumberException("You have entered invalid number");
				}
				inputflag=false;
			}
			
			catch (NumberFormatException e) {
				System.out.println("---------------------------------------------------------");
	            System.out.println("   !You have enter a character,Please enter a number!  ");
	            System.out.println("---------------------------------------------------------");
	            System.out.println();
	            sc.nextLine(); 
			}
			catch (InvalidNumberException e) {
				System.out.println("--------------------------------------------------------");
	            System.out.println("!"+e.getMessage()+"! ");
	            System.out.println("--------------------------------------------------------");
	        }
		}
		return input;
		
	}

}
