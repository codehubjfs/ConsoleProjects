package com.issuesystem.wardenmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.issuesystem.category.Category;
import com.issuesystem.issue.ViewIssue;
import com.issuesystem.userdefinedxception.EmailException;
import com.issuesystem.userdefinedxception.InvalidInputException;
import com.issuesystem.userdefinedxception.InvalidNumberException;
import com.issuesystem.users.Profile;
import com.issuesystem.dbconnection.DBConnection;
import com.issuesystem.issue.*;

public class WardenManagement{
	
	public static void chooseMenu(Scanner sc,String username,int role) throws SQLException, InvalidInputException, EmailException {
		boolean menuFlag=true;
		
		while(menuFlag) {
			System.out.println("1.See a New Issue "+"\n2.History of Issue"+"\n3.Allocate the issue"+"\n4.Edit Profile"+"\n5.To back");
			System.out.print("Enter your choice: ");
			String status=null;
			try {
				int click=Integer.parseInt(sc.next());
				if(click!=1 && click!=2 && click!=3 && click!=4 &&click !=5) {
				   throw new InvalidNumberException("You have entered invalid number");
				
				}
				else {		
					switch(click){
					
					case 1:
						System.out.println("+--------------------------+");
						System.out.println("|     Open New Issue       |");
						System.out.println("+--------------------------+");
						
						if(click==1) {
							 status="Opened";
						}
						newIssue(status,sc,username,role);
						
						
						break;
					case 2:
						System.out.println("+----------------------------+");
						System.out.println("|     History of Issue       |");
						System.out.println("+----------------------------+");
						viewissue(sc);
						break;
						
					case 3:
						System.out.println("+----------------------------+");
						System.out.println("|      Issue Assign          |");
						System.out.println("+----------------------------+");
						editIssue(sc);
						
						break;
						
					case 4:
						System.out.println("+------------------------+");
						System.out.println("|     Profile change     |");
						System.out.println("+------------------------+");
						Profile.editProfile(sc,username,role);
						break;
					case 5:
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
	
	
	
	
	
	//New Issue 
	
	public static void newIssue(String status,Scanner sc,String username,int role) throws SQLException, InvalidInputException, EmailException {
		String r="Raised";
		String red = "\u001B[31m";
		String green = "\u001B[32m";
    	String reset = "\u001B[0m";
		String sql1="select * from issues where status=?";
		PreparedStatement stmt1=DBConnection.getDBConnextion().prepareStatement(sql1);
		stmt1.setString(1,r);
		ResultSet rs=stmt1.executeQuery();
		
		List<IssueManage> issueList = new ArrayList<>();
		int back=0;
		boolean rowsFetched = false;
			while(rs.next()) {
				rowsFetched = true;
				rs.getInt("Issue_id");
			}
			
			if (rowsFetched) {
				String sql2="select * from issues";
				PreparedStatement stmt2=DBConnection.getDBConnextion().prepareStatement(sql2);
				stmt1.setString(1,r);
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
			    .filter(issue -> issue.getStatus().equals("Raised"))
			    .forEach(issuemanage -> {
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
				System.out.println("  ║                        No New issues raised                                ║");
				System.out.println("  ║                                                                            ║");
				System.out.println("  ╚════════════════════════════════════════════════════════════════════════════╝");
				 back=goBack(sc);
				
	
			}
		 
		
			String sql="update issues set status=? where status=?";
			PreparedStatement stmt=DBConnection.getDBConnextion().prepareStatement(sql);
			stmt.setString(1, "Opened");
			stmt.setString(2, "Raised");
			int rs4=stmt.executeUpdate();

	}
	
	

	// History of issue
	public static void viewissue(Scanner sc)throws SQLException {
		
		Statement stmt1=DBConnection.getDBConnextion().createStatement();
		ResultSet rs=stmt1.executeQuery("select * from issues");
		
		List<IssueManage> issueList = new ArrayList<>();
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s",
		        "ISSUE_ID", "ISSUETITLE","DESCRIPTION", "TICKET_RAISED_DATE",
		        "CATEGORY_ID", "RAISED_BY", "ALLOCATED_TO", "PRIORITY", 
		        "ISSUE_DATE", "STATUS"));

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		while(rs.next()) {
	            IssueManage issuemanage = new IssueManage(
	                    rs.getInt("ISSUE_ID"), rs.getString("ISSUE_TITLE"),rs.getString("DESCRIPTION"),
	                    rs.getDate("TICKET_RAISED_DATE").toLocalDate(), rs.getInt("CATEGORY_ID"), rs.getString("RAISED_BY"),
	                    rs.getString("ALLOCATED_TO"), rs.getString("PRIORITY"), 
	                    rs.getDate("ISSUE_DATE").toLocalDate(), rs.getString("STATUS")
	            );
	            
	            issueList.add(issuemanage);
	     }
			
		Collections.sort(issueList);
			
		issueList.forEach(issuemanage -> {
			 System.out.printf("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s%n",
		                issuemanage.getIssueId(), issuemanage.getIssueTitle(), issuemanage.getDescription(),
		                issuemanage.getTicketRaisedDate(), issuemanage.getCategoryId(), issuemanage.getRaisedBy(),
		                issuemanage.getAllocatedTo(), issuemanage.getPriority(), issuemanage.getIssueDate(),issuemanage.getStatus());
		        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		});
 
            
         	System.out.println(); 
   	 
         	int input=goBack(sc);
		
	
	}
	
	
	
	//check Input
	public static int checkInput(Scanner sc) {
		int input=0;
		boolean inputflag=true;
		while(inputflag) {
		
			try {
				
				input=Integer.parseInt(sc.next());
				if(input!=1 && input!=2) {
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
	
	
	
	
	//Go back
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
	
		
		
		
	
	//Edit Issue
	
	public static void editIssue(Scanner sc) throws SQLException {
		boolean menuFlag=true;
		
		while(menuFlag) {
			System.out.println("1.Assign the issue "+"\n2.To back");
			System.out.print("Enter your choice: ");
			String status=null;
			try {
				int click=Integer.parseInt(sc.next());
				if(click!=1 && click!=2 ) {
				   throw new InvalidNumberException("You have entered invalid number");
				
				}
				else {		
					switch(click){
					
					case 1:
						System.out.println("+------------------------+");
						System.out.println("|      Allocate To       |");
						System.out.println("+------------------------+");
						issueAllocation(sc);
						break;
					
						
					case 2:
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

	
	
	// Issue Allocation
	
	public static void issueAllocation(Scanner sc) throws SQLException {
	    String red = "\u001B[31m";
	    String green = "\u001B[32m";
	    String reset = "\u001B[0m";

	    System.out.println("-------------------Allocate the person for issue------------------------");

	    String r = "Opened";
	    boolean flag = false;

	    // Try-with-resources for the first query to check if there are issues with "Opened" status
	    try (Connection conn = DBConnection.getDBConnextion();
	         PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM issues WHERE status=?")) {

	        stmt1.setString(1, r);
	        try (ResultSet rs = stmt1.executeQuery()) {
	            flag = rs.next();
	        }
	    }

	    if (flag) {
	        List<IssueManage> issueList = new ArrayList<>();

	        // Try-with-resources for the second query to retrieve all issues
	        try (Connection conn = DBConnection.getDBConnextion();
	             PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM issues");
	             ResultSet rs1 = stmt2.executeQuery()) {

	            while (rs1.next()) {
	                IssueManage issuemanage = new IssueManage(
	                        rs1.getInt("ISSUE_ID"), rs1.getString("ISSUE_TITLE"), rs1.getString("DESCRIPTION"),
	                        rs1.getDate("TICKET_RAISED_DATE").toLocalDate(), rs1.getInt("CATEGORY_ID"), rs1.getString("RAISED_BY"),
	                        rs1.getString("ALLOCATED_TO"), rs1.getString("PRIORITY"),
	                        rs1.getDate("ISSUE_DATE").toLocalDate(), rs1.getString("STATUS")
	                );
	                issueList.add(issuemanage);
	            }
	        }

	        // Print the issue details
	        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	        System.out.println(String.format("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s",
	                "ISSUE_ID", "ISSUETITLE", "DESCRIPTION", "TICKET_RAISED_DATE",
	                "CATEGORY_ID", "RAISED_BY", "ALLOCATED_TO", "PRIORITY",
	                "ISSUE_DATE", "STATUS"));
	        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	        issueList.stream()
	                .filter(issue -> "Opened".equals(issue.getStatus()))
	                .sorted()
	                .forEach(issueManage -> {
	                    System.out.printf("%-10s%-30s%-75s%-55s%-25s%-20s%-25s%-20s%-20s%-20s%n",
	                            issueManage.getIssueId(), issueManage.getIssueTitle(), issueManage.getDescription(),
	                            issueManage.getTicketRaisedDate(), issueManage.getCategoryId(), issueManage.getRaisedBy(),
	                            issueManage.getAllocatedTo(), issueManage.getPriority(),
	                            issueManage.getIssueDate(), issueManage.getStatus());
	                });

	        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	        boolean isValid = true;
	        while (isValid) {
	            System.out.println();

	            int id = 0;
	            while (true) {
	                try {
	                    System.out.println("Enter the id that you are going to assign: ");
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
	                String sqlCheck = "SELECT * FROM issues WHERE issue_id=?";
	                try (PreparedStatement stmt3 = conn.prepareStatement(sqlCheck)) {
	                    stmt3.setInt(1, id);

	                    try (ResultSet rs2 = stmt3.executeQuery()) {
	                        if (rs2.next()) {
	                            // Get the title of the issue;
	                            String title = rs2.getString("issue_title");

	                            String superVisorRole = null;
	                            if (title.equals("Furniture")) {
	                                superVisorRole = "furnituresupervisor";
	                            }
	                            if (title.equals("Electricity")) {
	                                superVisorRole = "electricsupervisor";
	                            }
	                            if (title.equals("Cleaning")) {
	                                superVisorRole = "cleaningsupervisor";
	                            }
	                            if (title.equals("Food")) {
	                                superVisorRole = "foodsupervisor";
	                            }

	                            String name = null;
	                            boolean flag1 = true;
	                            int input = 0;
	                            while (flag1) {
	                                System.out.println("Enter 1 or 2 to see the supervisor available");

	                                input = checkInput(sc);
	                                if (input == 1 || input == 2) {
	                                    String sqlSupervisor = "SELECT * FROM supervisor WHERE role=?";
	                                    try (PreparedStatement stmt4 = DBConnection.getDBConnextion().prepareStatement(sqlSupervisor)) {
	                                        stmt4.setString(1, superVisorRole);
	                                        try (ResultSet rs = stmt4.executeQuery()) {
	                                            System.out.println("This is our supervisor:");
	                                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	                                            System.out.println(String.format("%-25s", "SupervisorName"));
	                                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	                                            while (rs.next()) {
	                                                System.out.println(rs.getString("name"));
	                                                name = rs.getString("name");
	                                            }
	                                        }
	                                    }
	                                    System.out.println();
	                                    boolean flag2 = true;
	                                    while (flag2) {
	                                        System.out.println("Enter 1 or 2 to allocate the issue to a particular supervisor:");

	                                        input = checkInput(sc);
	                                        if (input == 1 || input == 2) {
	                                            flag1 = false;
	                                            flag2 = false;
	                                            break;
	                                        }
	                                    }
	                                }
	                            }

	                            String assignName = name;
	                            // Update the allocated_to column
	                            String sql3 = "UPDATE issues SET allocated_to=?, status='Assigned' WHERE issue_id=?";
	                            try (PreparedStatement stmt4 = conn.prepareStatement(sql3)) {
	                                stmt4.setString(1, assignName);
	                                stmt4.setInt(2, id);
	                                int rowsAffected = stmt4.executeUpdate();
	                                if (rowsAffected > 0) {
	                                    System.out.println();
	                                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	                                    System.out.println("┃'" + green + "'Assigned Successfully '" + reset + "'          ┃");
	                                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	                                    isValid = false;
	                                    break;
	                                }
	                            }
	                        } else {
	                            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	                            System.out.println("┃'" + red + "'Please enter an available ID. '" + reset + "'                      ┃");
	                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	                        }
	                    }
	                }
	            }
	        }
	    } else {
	        System.out.println("Already all issues are Assigned");
	        System.out.println("  ╔═══════════════════════════════════════════════════════════════════════════════════╗");
	        System.out.println("  ║                                                                                   ║");
	        System.out.println("  ║                        Already all issues are Assigned                            ║");
	        System.out.println("  ║                                                                                   ║");
	        System.out.println("  ╚═══════════════════════════════════════════════════════════════════════════════════╝");
	    }
	}
	
	
	
	
	
	
}
