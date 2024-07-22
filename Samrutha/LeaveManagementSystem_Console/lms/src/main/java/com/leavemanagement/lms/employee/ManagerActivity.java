package com.leavemanagement.lms.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.leavemanagement.lms.Menu;
import com.leavemanagement.lms.driver.AppDriver;
import com.leavemanagement.lms.exception.ExceptionValidator;
import com.leavemanagement.lms.exception.InvalidInputException;
import com.leavemanagement.lms.leave.LeaveApplication;
import com.leavemanagement.lms.leave.Status;
import com.leavemanagement.lms.style.Border;

public class ManagerActivity {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static ExceptionValidator validators = new ExceptionValidator();
	static Border border = new Border();
	
	//Menu 
	public void managerActivity(Manager manager, ArrayList<LeaveApplication> leave) throws IOException, InvalidInputException {
		while(true) {
			System.out.println("MANAGER ACTIVITY: ");
			System.out.println("1. ViewTeam    2. ViewLeaveReport    3. Approve/Reject Leave    4. LeaveCalender   5. Log out    6. Exit");
			int choice;
			while (true) {
				System.out.println("Enter your choice: ");
	            try {
	            	String  input = bf.readLine().trim();
                	if(!validators.isNumeric(input)) {
                		throw new InputMismatchException("Input is not a valid number.");
                	}
                	else {
                		choice = Integer.parseInt(input); 
                		break;
                	}
	            } 
	            catch (InputMismatchException e) {
	            	System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
	            }
			}
			switch(choice) {
			case 1: viewTeam(manager);break;
			case 2: viewLeaveRequest(leave); break;
			case 3: updateLeaveStatus(manager, leave);break;
			case 4: leaveCalender(leave); break;
			case 5: border.applyNoteBorder("Successfylly logged out....!"); Menu.displayMainMenu();
			case 6: border.applyNoteBorder("Thank you for visiting...!"); System.exit(0); break;
			default: System.out.println("---------------------------------------------");
					 System.out.println("Please enter valid choice from [1 to 5]");
					 System.out.println("---------------------------------------------");
			}
		}
	}
	
	/*
	 * View the team members who is working under the manager
	 * 
	 * @param manager  :   Object that holds manager details
	 * 
	 */
	
	public static void viewTeam(Manager manager) {
		System.out.print("TEAM MEMBERS: ");
		String formats = "\n+--------+--------------------------------+\n";
		System.out.print(formats);
		System.out.printf("|%-6s  |%-30s  |", 
	            "EmpID", 
	            "Name"
	            );
		manager.getTeam().entrySet().stream().forEach((name)->System.out.printf("%s|%-6s  |%-30s  |",
				formats,
				name.getKey(),
				name.getValue()
				)
				);
		System.out.println(formats);
	}
	
	/*
	 * View all the leave request of the employee 
	 * 
	 * @param leaves   :   ArrayList that stores all the leaves from the database
	 * 
	 */
	
	public void viewLeaveRequest(ArrayList<LeaveApplication> leave) {
		ArrayList<LeaveApplication> pendingList = leave.stream().filter((leaves) -> (leaves.getStatus() == Status.WAITING_IN_QUEUE)).collect(Collectors.toCollection(ArrayList::new));
		String formats = "\n+--------+--------------------------------+------------+------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------+\n";
		System.out.print(formats);
		System.out.printf("|%-6s  |%-30s  |%-10s  |%-10s  |%-25s  |%-15s  |%-25s  |%-30s  |%-15s|", 
	            "EmpID", 
	            "Leave Type", 
	            "Start Date", 
	            "End Date", 
	            "Leave Reason", 
	            "Submit Date", 
	            "Status", 
	            "Rejection Reason", 
	            "Work Assigned");
		
		pendingList.forEach((leaves)->System.out.printf("%s| %-5s  |%-30s  |%-10s  |%-10s  |%-25s  |%-15s  |%-25s  |%-30s  |%-15d|", 
				formats,
	            leaves.getEmployee().getEmpId(), 
	            leaves.getLeavetype(), 
	            leaves.getStartDate(), 
	            leaves.getEndDate(), 
	            leaves.getLeaveReason(), 
	            leaves.getSubmitDate(), 
	            leaves.getStatus(), 
	            leaves.getRejectionReason(), 
	            leaves.getWorkAssigned()
	            )
				);
		System.out.println(formats);
	}
	
	/*
	 * Approve or Reject the leave request
	 * 
	 * @param manager  :   Object that holds manager details
	 * 
	 * @param leaves   :   ArrayList that stores all the leaves from the database
	 * 
	 * @exception InputMismatchException : Thrown when the entered number is not an integer value
	 * 
	 * @throws IOException               : Occurs when the input is read using the Buffered Reader
	 */
	public void updateLeaveStatus(Manager manager, ArrayList<LeaveApplication> leaves) throws IOException {
		while(true) {
			ArrayList<LeaveApplication> pendingLeaveList = leaves.stream()
		            .filter(leave -> leave.getStatus() == Status.WAITING_IN_QUEUE)
		            .collect(Collectors.toCollection(ArrayList::new));
			
			//Comparator to sort the list based on the start date
			Collections.sort(pendingLeaveList, Comparator.comparing(LeaveApplication::getStartDate));
			
			//Storing it to map to retrieve the data based on index
			Map<Integer, LeaveApplication> filteredLeaveMap = new LinkedHashMap<>();
	        int serialNumber = 1;
	        for (LeaveApplication leave : pendingLeaveList) {
	            filteredLeaveMap.put(serialNumber++, leave);
	        }
	        if(serialNumber==0) {
	        	System.out.println("---------------------------------------------");
				System.out.println("No leaves available..."); 
				System.out.println("---------------------------------------------");
				break;
			}
	        else {
	        	String formats = "\n+-----+--------+--------------------------------+------------+------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------+\n";
	    		System.out.print(formats);
	    		System.out.printf("|%-3s|%-6s  |%-30s  |%-10s  |%-10s  |%-25s  |%-15s  |%-25s  |%-30s  |%-15s|", 
	    				"S.No.",
	    	            "EmpID", 
	    	            "Leave Type", 
	    	            "Start Date", 
	    	            "End Date", 
	    	            "Leave Reason", 
	    	            "Submit Date", 
	    	            "Status", 
	    	            "Rejection Reason", 
	    	            "Work Assigned");
	        	for(Map.Entry<Integer, LeaveApplication> val : filteredLeaveMap.entrySet()) {
	        		System.out.printf("%s|%-3s  | %-5s  |%-30s  |%-10s  |%-10s  |%-25s  |%-15s  |%-25s  |%-30s  |%-15d|", 
	        				formats,
	        				val.getKey(),
	        	            val.getValue().getEmployee().getEmpId(), 
	        	            val.getValue().getLeavetype(), 
	        	            val.getValue().getStartDate(), 
	        	            val.getValue().getEndDate(), 
	        	            val.getValue().getLeaveReason(), 
	        	            val.getValue().getSubmitDate(), 
	        	            val.getValue().getStatus(), 
	        	            val.getValue().getRejectionReason(), 
	        	            val.getValue().getWorkAssigned()
	        				);
				}
	        	System.out.println(formats);
	        	int choice;
				while (true) {
					System.out.println("Enter the leave request id that you want to see [1 -" + (serialNumber-1) +"]. To exit enter " + (serialNumber) +": ");
		            try {
		            	String  input = bf.readLine().trim();
	                	if(!validators.isNumeric(input)) {
	                		throw new InputMismatchException("Input is not a valid number.");
	                	}
	                	else {
	                		choice = Integer.parseInt(input); 
	                		break;
	                	}
		            } 
		            catch (InputMismatchException e) {
		            	System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
		            }
				}
				if(choice == serialNumber) {
					border.applyNoteBorder("Thank you for visiting...!");
					break;
				}
				else if(choice > serialNumber) {
					int continueStatus = 0;
					System.out.println("---------------------------------------------");
					System.out.println("Invalid choice...!");
					System.out.println("---------------------------------------------");
					 while (true) {
						    System.out.println("Do you want to continue....? (yes-1 / no-0): ");
						    try {
						        String input = bf.readLine().trim();
						        if (!validators.isNumeric(input)) {
						            throw new InputMismatchException("Input is not a valid number.");
						        } else {
						            continueStatus = Integer.parseInt(input);
						            if (continueStatus == 0) {
						            	border.applyNoteBorder("Thank you...!");
						                break;
						            } else if (continueStatus > 1) {
						                throw new InputMismatchException("Enter 0 or 1");
						            }
						            else {
						            	updateLeaveStatus(manager, leaves);
						            }
						        }
						        break;
						    } catch (Exception e) {
						    	System.out.println("---------------------------------------------");
				                System.out.println("\n" + e.getMessage() + "\n");
				                System.out.println("---------------------------------------------");
						    }
						}
						break;
				}
				else {
					for(Map.Entry<Integer, LeaveApplication> val : filteredLeaveMap.entrySet()) {
						if(choice == val.getKey()) {
							updateStatusMenu(manager, val.getValue());
						}
					}
				}
	        }
		}
	}
	
	/*
	 * Menu for updating the leave status 
	 * 
	 * Functionality: two:: Approve the leave, Reject the leave 
	 * 
	 * @param <manager>     Object that holds manager details
	 * 
	 * @param <leaves>      Object that stores the particular leave of the employee from the database
	 * 
	 * @exception InputMismatchException : Thrown when the entered number is not an integer value
	 * 
	 * @throws IOException               : Occurs when the input is read using the Buffered Reader
	 * 
	 */
		public void updateStatusMenu(Manager manager, LeaveApplication leave) throws IOException {
			System.out.println("Do you want to Approve / Reject the leave: ");
			System.out.println("1. Approve\t2. Reject");
			while(true) {
				int ch;
				while (true) {
					System.out.println("Enter your choice: ");
		            try {
		            	String  input = bf.readLine().trim();
	                	if(!validators.isNumeric(input)) {
	                		throw new InputMismatchException("Input is not a valid number.");
	                	}
	                	else {
	                		ch = Integer.parseInt(input); 
	                		break;
	                	}
		            } 
		            catch (InputMismatchException e) {
		            	System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
		            }
				}
				
				switch(ch) {
				case 1: approve(manager, leave); break;
				case 2: reject(manager, leave); break;
				default: System.out.println("Enter the correct value [1 or 2]"); 
				}
				if(ch==1 || ch==2) {
					break;
				}
			}
		}
		
		/*
		 * Approve the leave request and assign the work to the other employee
		 * 
		 * @param <manager>     Object that holds manager details
		 * 
		 * @param <leaves>      Object that stores the particular leave of the employee from the database
		 * 
		 * @exception InputMismatchException : Thrown when the entered number is not an integer value
		 * 
		 * @exception SQLException           : Occurs when returning the ResultEet
		 * 
		 */
		public void approve(Manager manager, LeaveApplication leave) {
			System.out.println("The work is assigned to the employee Id '" + leave.getWorkAssigned()+ "'");
			System.out.println("Do you like to reAssign the word to different employee? Yes-1/No-0: ");
			int empId = leave.getWorkAssigned();
			int continueValue;
			try {
		        String input = bf.readLine().trim();
		        if (!validators.isNumeric(input)) {
		            throw new InputMismatchException("Input is not a valid number.");
		        } else {
		        	continueValue = Integer.parseInt(input);
					if(continueValue==1) {
//						System.out.println("Enter the empId: ");
//						input = bf.readLine().trim();
//				        if (!validators.isNumeric(input)) {
//				            throw new InputMismatchException("Input is not a valid number.");
//				        }
//				        else {
//				        	empId = Integer.parseInt(input);
//				        }
						
						
						while (true) {
							System.out.print("TEAM MEMBERS: ");
							String formats = "\n+--------+--------------------------------+\n";
							System.out.print(formats);
							System.out.printf("|%-6s  |%-30s  |", 
						            "EmpID", 
						            "Name"
						            );
							manager.getTeam().entrySet().stream().forEach((name)->System.out.printf("%s|%-6s  |%-30s  |",
									formats,
									name.getKey(),
									name.getValue()
									)
									);
							System.out.println(formats);
							System.out.println("Enter the empId to assign the work: ");
							input = bf.readLine().trim();
				            try {
				                if (!validators.isNumeric(input)) {
				                    throw new InputMismatchException("Input is not a valid number.");
				                } else {
				                    empId = Integer.parseInt(input);

				                    boolean validEmpId = false;
				                    for (Map.Entry<Integer, String> val : manager.getTeam().entrySet()) {
				                        if (empId == val.getKey()) {
				                            validEmpId = true;
				                            break;
				                        }
				                    }

				                    if (validEmpId) {
				                        break; // Break the outer loop if a valid employee ID is found
				                    } else {
				                    	System.out.println("---------------------------------------------");
				                        System.out.println("Employee ID not found. Please try again.");
				                        System.out.println("---------------------------------------------");
				                    }
				                }
				            } catch (InputMismatchException e) {
				            	System.out.println("---------------------------------------------");
				                System.out.println("\n" + e.getMessage() + "\n");
				                System.out.println("---------------------------------------------");
				            }
				        }
					}
		        }
			}
		    catch(Exception e) {
		    	System.out.println("---------------------------------------------");
		        System.out.println(e.getMessage());
		        System.out.println("---------------------------------------------");
		    }
			try {
				String sql = "Update leaveapplication set status = ?, WORKASSIGNED = ? where empID = ? and startDate = ?" ;
				String sql2 = "UPDATE leave SET LEAVETAKEN = LEAVETAKEN + ?, LEAVEBALANCE = LEAVEBALANCE - ? WHERE empId = ?";

				int daysCount = (int) ChronoUnit.DAYS.between(leave.getStartDate(), leave.getEndDate()) + 1;

				System.out.println("Days count = " + daysCount);

				PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql2);
				prst.setInt(1, daysCount); // LEAVETAKEN = LEAVETAKEN + ?
				prst.setInt(2, daysCount); // LEAVEBALANCE = LEAVEBALANCE - ?
				prst.setInt(3, leave.getEmployee().getEmpId());     // WHERE empId = ?

				int lv = prst.executeUpdate();
				
				prst = AppDriver.getConnection().prepareStatement(sql);
				prst.setString(1, Status.APPROVED.toString());
				prst.setInt(2, empId);
				prst.setInt(3, leave.getEmployee().getEmpId());
				prst.setDate(4, Date.valueOf(leave.getStartDate()));
				int  res = prst.executeUpdate();
				System.out.println("LV" + lv);
				
				if(res==1 && lv == 1) {
					leave.setStatus(Status.APPROVED);
					border.applyNoteBorder("Status updated successfully...!");
					updateLeaveTable(leave);
				}
				else {
					System.out.println("---------------------------------------------");
					System.out.println("Something went wrong...!");
					System.out.println("---------------------------------------------");
				}
			}
			catch(Exception e) {
				System.out.println("---------------------------------------------");
				System.out.println(e.getMessage());
				System.out.println("---------------------------------------------");
			}
		}
		
		/*
		 * Reject the leave request and notifying the employee with valid reason
		 * 
		 * @param manager :Object that holds manager details
		 * 
		 * @param leaves  : ArrayList that stores all the leaves from the database
		 * 
		 * @exception InputMismatchException : Thrown when the entered number is not an integer value
		 * 
		 * @exception SQLException           : Occurs when returning the ResultEet
		 * 
		 */
		public void reject(Manager manager, LeaveApplication leave) {
			String reason=null;
			System.out.println("Do you want to send a reason? Yes-1/ No-0");
			try {
		        String input = bf.readLine().trim();
		        if (!validators.isNumeric(input)) {
		            throw new InputMismatchException("Input is not a valid number.");
		        } else {
		        	int continueValue = Integer.parseInt(input);
		        	reason = null;
					if(continueValue==1) {
						System.out.println("Enter the reason for Rejection: ");
						reason = bf.readLine();
					}
		        }
			}
		    catch(Exception e) {
		    	System.out.println("---------------------------------------------");
		        System.out.println(e.getMessage());
		        System.out.println("---------------------------------------------");
		    }
			
			try {
				String sql = "Update leaveapplication set status = ?, rejectionreason = ? where empID = ? and startDate = ? and leaveReason = ?" ;
				PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
				prst.setString(1, Status.REJECTED.toString());
				prst.setString(2, reason);
				prst.setInt(3, leave.getEmployee().getEmpId());
				prst.setDate(4, Date.valueOf(leave.getStartDate()));
				prst.setString(5, leave.getLeaveReason());
				int  res = prst.executeUpdate();
				if(res==1) {
					leave.setStatus(Status.REJECTED);
					border.applyNoteBorder("Status updated successfully...!");
				}
				else {
					System.out.println("---------------------------------------------");
					System.out.println("Something went wrong...!");
					System.out.println("---------------------------------------------");
				}
			}
			catch(Exception e) {
				System.out.println("---------------------------------------------");
				System.out.println(e.getMessage());
				System.out.println("---------------------------------------------");
			}
		}
		
		/*
		 * Update the leave of the employee whose leave had been approved
		 * 
		 * @param <leaves>  This contains the particular leave request of the employee with all the informations
		 * 
		 */
		public void updateLeaveTable(LeaveApplication leave) {
			int days = (int) ChronoUnit.DAYS.between(leave.getStartDate(), leave.getEndDate());
			String sql = "Update leave set leavetaken = leaveTaken + ? , LEAVEBALANCE= LEAVEBALANCE-? where empID = (select empID from employee where userName = ?)";
			try {
				PreparedStatement stm = AppDriver.getConnection().prepareStatement(sql);
				stm.setInt(1, days);
				stm.setInt(2, days);
				stm.setString(3, leave.getEmployee().getUserName());
				stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("---------------------------------------------");
				System.out.println(e.getMessage());
				System.out.println("---------------------------------------------");
			}
		}
		
		/*
		 * The leave request report is generated for all the employees of the team
		 * 
		 * @param <leave>  This contains the list of leave request of all the employee under their team
		 * 
		 */
		public void leaveCalender(ArrayList<LeaveApplication> leave) {
		    System.out.print("LEAVE CALENDER:");
		    String formats = "\n+--------+------------+------------+--------------+\n";
		    System.out.print(formats);
		    System.out.printf("|%-6s  |%-10s  |%-10s  |%-12s  |", 
		            "EmpID", 
		            "StartDate",
		            "EndDate",
		            "No of days"
		            );
		    List<LeaveApplication>leaveApp = leave.stream().filter(val->val.getStartDate().equals(LocalDate.now())).collect(Collectors.toList());
		    
		    if(leaveApp.size()==0) {
		    	System.out.print(formats);
		    	System.out.print("| No leaves available for today                   |");
		    }
		    else {
		    	leaveApp.forEach(val -> {
			        System.out.printf("%s|%-6d  |%-10s  |%-10s  |%-12d  |",
			        		formats,
			                val.getEmployee().getEmpId(),
			                val.getStartDate(),
			                val.getEndDate(),
			                ChronoUnit.DAYS.between(val.getStartDate(), val.getEndDate())
			        );
			    }); 
		    }
		    System.out.print(formats);
		}
}
