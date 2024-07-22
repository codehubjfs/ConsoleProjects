package com.leavemanagement.lms.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.leavemanagement.lms.Menu;
import com.leavemanagement.lms.driver.AppDriver;
import com.leavemanagement.lms.exception.ExceptionValidator;
import com.leavemanagement.lms.exception.InvalidDateException;
import com.leavemanagement.lms.exception.InvalidInputException;
import com.leavemanagement.lms.exception.InvalidPasswordException;
import com.leavemanagement.lms.exception.InvalidReasonException;
import com.leavemanagement.lms.leave.LeaveApplication;
import com.leavemanagement.lms.leave.LeaveType;
import com.leavemanagement.lms.leave.Status;
import com.leavemanagement.lms.style.Border;

public class EmployeeManagement {
	
	//Empty constructor
		public EmployeeManagement() {
		}
		
		//Employee management methods are implemented here
		static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		static ExceptionValidator validators = new ExceptionValidator();
		static Border border = new Border();
		
		//Activities that employee can do
			public void employeeActivity(Employee emp) throws IOException, InvalidInputException{
				while(true) {
					System.out.println("Employee Activity: ");
					System.out.println("1. ViewProfile\n2. UpdateProfile\n3. ApplyLeave\n4. UpdateLeaveApplication\n5. CancelLeave\n6. ViewLeaveBalance\n7. ViewHistory\n8. Log out\n9. Exit");
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
						case 1: viewProfile(emp); break; 
						case 2: updateProfile(emp); break; 
						case 3: applyLeave(emp); break; 
						case 4: updateLeaveApplication(emp);break;
						case 5: updateStatus(emp); break;
						case 6: viewBalanceLeave(emp); break;
						case 7: viewHistory(emp); break;
						case 8: border.applyNoteBorder("Successfylly logged out....!"); Menu.displayMainMenu();
						case 9: border.applyNoteBorder("Thank you for visiting...!"); System.exit(0); break;
						default: System.out.println("---------------------------------------------");
								 System.out.println("\nPlease enter valid choice from [1 to 9]\n");
								 System.out.println("---------------------------------------------");
					}
				}
			}
			
			
			/*
			 * It provides the functionality to the employee to view their profile
			 * 
			 * @param <emp>  This contains the particular leave request of the employee with all the informations
			 */
			public void viewProfile(Employee emp) {
				try {
					String sql = "select * from employee where username = ?";
					PreparedStatement pst = AppDriver.getConnection().prepareStatement(sql);
					pst.setString(1, emp.getUserName());
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						 border.displayEmployeeInfo(rs);
					}
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			/*
			 * It shows the functionality to the employee and make them to select their choices based on their requirements
			 * 
			 * @param <emp>  This contains the particular leave request of the employee with all the informations
			 */
			public static void updateProfile(Employee emp) throws IOException, InvalidInputException {
				while(true) {
					System.out.println("1. ChangePassword    2. Back    3. Log out    4. Exit");
					int choice;
					while (true) {
						System.out.println("Enter your choice: ");
			            try {
			            	String input = bf.readLine().trim();
			                if (!validators.isNumeric(input)) {
			                	throw new InputMismatchException("Input is not a valid number.");
			                } else {
			                    choice = Integer.parseInt(input);
			                    break;
			                }
			            } catch (InputMismatchException e) {
			            	System.out.println("---------------------------------------------");
			                System.out.println("\n" + e.getMessage() + "\n");
			                System.out.println("---------------------------------------------");
			            }
			        }
					EmployeeManagement management = new EmployeeManagement();
					switch(choice) {
					case 1: changePassword(emp); break;
					case 2: management.employeeActivity(emp); break;
					case 3: Menu.displayMainMenu(); break;
					case 4: border.applyNoteBorder("Thank you for visiting...!"); System.exit(0); break;
					default: System.out.println("---------------------------------------------");
							 System.out.println("\nEnter valid option [1 to 4]\n"); 
							 System.out.println("---------------------------------------------");break;
					}
					
				}
			}
			
			/*
			 * It provides the functionality to the employee to change the password after creating the account at the initial stage or when it is required
			 * 
			 * @param <emp>  This contains the particular leave request of the employee with all the informations
			 */
			//Change the password
			public static void changePassword(Employee emp) throws IOException{
				try {
					String password;
				    while (true) {
				    	System.out.println("Enter new password: ");
				        password = bf.readLine(); 
				        if (validators.isValidPassword(password)) {
				            String sql = "UPDATE employee SET password = ? WHERE username = ?";
				            PreparedStatement pl = AppDriver.getConnection().prepareStatement(sql);
				            pl.setString(1, password);
				            pl.setString(2, emp.getUserName());
				            int result = pl.executeUpdate();
				            if (result > 0) {
				                border.applyNoteBorder("Password updated successfully...!");
				            } else {
				                System.out.println("Something went wrong...");
				            }
				            break; // Exit the loop after updating the password
				        } else {
				            throw new InvalidPasswordException("Password is invalid. Please try again.");
				        }
				    }
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			/*
			 * It provides the functionality to the employee to apply the leave
			 * 
			 * @param <emp>  This contains the particular leave request of the employee with all the informations
			 */
			public static void applyLeave(Employee emp) throws IOException {
				
				//Read leave type
				LeaveType leaveType = null;
				System.out.println("Enter leave type: ");
				while(true) {
					int choice ;
					while (true) {
						System.out.println("1. Sick leave\t2. Casual leave\t3. Vacation leave\t4. Maternity leave\t5. Marriage leave");
						System.out.println("Enter your choice[1 to 5]: ");
			            //Read the input number
						try {
			            	String input = bf.readLine();
			                if (!validators.isNumeric(input)) {
			                	throw new InputMismatchException("Input is not a valid number.");
			                } else {
			                    choice = Integer.parseInt(input);
			                    break;
			                }
			            } catch (InputMismatchException e) {
			            	System.out.println("---------------------------------------------");
			                System.out.println(e.getMessage());
			                System.out.println("---------------------------------------------");
			            }
					}
					switch(choice) {
						case 1: leaveType = LeaveType.SICK_LEAVE; break;
						case 2: leaveType = LeaveType.CASUAL_LEAVE; break;
						case 3: leaveType = LeaveType.VACATION_LEAVE; break;
						case 4: leaveType = LeaveType.MATERNITY_LEAVE; break;
						case 5: leaveType = LeaveType.MARRIAGE_LEAVE; break;
						default: System.out.println("---------------------------------------------"); 
								 System.out.println("\nEnter choice from [1 to 5]...!\n");
								 System.out.println("---------------------------------------------");
					} 
					if(choice>=1 &&choice<=5) {
						break;
					}
				}
				
				//Read the startDate
				LocalDate startDate;
				while(true) {
		        	System.out.print("Enter start date as 'YYYY-MM-DD': ");
		            try {
		            	String date = bf.readLine();
		                startDate = validators.validateDate(date); break;
		            } catch (InvalidDateException e) {
		            	System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
		            }
		        }
				
				//Read end date
				LocalDate endDate;
				while(true) {
		        	System.out.print("Enter end date as 'YYYY-MM-DD': ");
		            try {
		            	String date = bf.readLine();
		                endDate = validators.validateDate(date); 
		                if(endDate.isBefore(startDate)) {
		                	throw new InvalidDateException("End date should be the future date...!");
		                }
		                else {
		                	break;
		                }
		            } catch (InvalidDateException e) {
		            	System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
		            }
		        }
				
				//Read the leave reason
				String leaveReason;
				while(true) {
					System.out.println("Enter leave reason: ");
					leaveReason = bf.readLine();
		        	try {
		        		if(leaveReason.length()<10) {
		            		throw new InvalidReasonException("Please enter atleast 10 character");
		            	}
		            	else {
		            		break;
		            	}
		        	}
		        	catch(Exception e) {
		        		System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
		        	}
		        }
				
				//Suggest the employee id to assign the work
				Map<Integer, Employee> employeeList = new TreeMap<Integer, Employee>();
				try {
					int i=0;
					String sql = "select * from employee where deptId = ? and empAccStatus = 'ACTIVE'";
					PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
					prst.setInt(1, emp.getDepartment().getDeptId());
					ResultSet rs = prst.executeQuery();
					while(rs.next()) {
						Employee employee = new Employee(rs.getString("fname"), rs.getString("lname"), rs.getInt("empId"));
						employeeList.put(++i, employee);
					}
					
					//Collections.sort(employeeList, Comparator.comparingInt(Employee::getEmpId));
				}
				catch (Exception e){
					System.out.println("---------------------------------------------");
	                System.out.println(e.getMessage());
	                System.out.println("---------------------------------------------");
				}
				
				int alterEmp;
				
		        // Display the table rows
				while (true) {
					String formats = "\n+-----------+----------------+---------------+\n";
					System.out.print(formats);
					System.out.printf("|%-10s |%-15s |%-15s|","EmpId", "Fname", "Lname");
					for(Map.Entry<Integer, Employee> val : employeeList.entrySet()) {
						System.out.printf("%s|%-10d |%-15s |%-15s|",formats,val.getValue().getEmpId(), val.getValue().getFname(), val.getValue().getLname());
					}
					System.out.print(formats);
		            System.out.println("Suggest employee id to alter your work: ");
		            String input = bf.readLine().trim();

		            try {
		                if (!validators.isNumeric(input)) {
		                    throw new InputMismatchException("Input is not a valid number.");
		                } else {
		                    alterEmp = Integer.parseInt(input);

		                    boolean validEmpId = false;
		                    for (Map.Entry<Integer, Employee> val : employeeList.entrySet()) {
		                        if (alterEmp == val.getValue().getEmpId()) {
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
		                System.out.println(e.getMessage());
		                System.out.println("---------------------------------------------");
		            }
		        }
				
		        LeaveApplication leave = new LeaveApplication(emp, leaveType, startDate, endDate, leaveReason, LocalDate.now(), Status.WAITING_IN_QUEUE, null, alterEmp);
		        leave.insertLeave(leave);
		    }
			
			/*
			 * It provides the functionality to the employee to view all the leaves that has been applied by them
			 * 
			 * @param <emp>  This contains the particular leave request of the employee with all the informations
			 */
			public static void viewBalanceLeave(Employee emp) {
				try {
					String sql = "select LEAVEBALANCE, LEAVETAKEN from leave where empID = (select empID from employee where userName = ?)";
					PreparedStatement prs = AppDriver.getConnection().prepareStatement(sql);
					prs.setString(1, emp.getUserName());
					ResultSet rs = prs.executeQuery();
					if(rs.next()) {
						System.out.println();
						System.out.println("Leave taken = " + rs.getInt("LEAVETAKEN"));
						System.out.println("Balance leave = " + rs.getInt("LEAVEBALANCE"));
						System.out.println();
					}
					
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println(e.getMessage());
	                System.out.println("---------------------------------------------");
				}
			}
			
			//View History
			public static void viewHistory(Employee emp) {
				try {
					LeaveApplication leaves = new LeaveApplication();
					String sql = "select * from leaveapplication where empID = (select empID from employee where userName = ?)";
					PreparedStatement prs = AppDriver.getConnection().prepareStatement(sql);
					prs.setString(1, emp.getUserName());
					ResultSet rs = prs.executeQuery();
					String formats = "\n+-------+-------------+------------+------------+---------------------------+-------------+--------------------------+----------------------+--------------+\n";
					System.out.print(formats);
					System.out.printf("|%-5s  |%-11s  |%-10s  |%-10s  |%-25s  |%-10s  |%-24s  |%-20s  |%-12s |", 
				            "EmpID", 
				            "Leave Type", 
				            "Start Date", 
				            "End Date", 
				            "Leave Reason", 
				            "Submit Date", 
				            "Status", 
				            "Rejection Reason", 
				            "Work Assigned");
					while(rs.next()) {
						LeaveType type = leaves.mapToEnum(rs.getString("leaveType"));
						Date sdate = rs.getDate("startDate");
						Date edate = rs.getDate("endDate");
						Status status = leaves.mapToStatus(rs.getString("status"));
						Date submitDate = rs.getDate("SUBMITDATE");
						leaves = new LeaveApplication(emp, type, sdate.toLocalDate() , edate.toLocalDate(), rs.getString("leaveReason"), submitDate.toLocalDate(), status, rs.getString("rejectionReason"),rs.getInt("workAssigned"));
				        System.out.printf("%s|%-5s  |%-11s  |%-10s  |%-10s  |%-25s  |%-10s   |%-24s  |%-20s  |%-12s  |", 
				        	formats,
				            leaves.getEmployee().getEmpId(), 
				            leaves.getLeavetype(), 
				            leaves.getStartDate(), 
				            leaves.getEndDate(), 
				            leaves.getLeaveReason(), 
				            leaves.getSubmitDate(), 
				            leaves.getStatus(), 
				            leaves.getRejectionReason(), 
				            leaves.getWorkAssigned());
					}
					System.out.print(formats);
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println(e.getMessage());
	                System.out.println("---------------------------------------------");
				}
			}
			
			
			/*
			 * It provides the functionality to the employee to cancel their leave request before it gets approved or rejected by the manager
			 * 
			 * @param <emp>  This contains the particular leave request of the employee with all the informations
			 */
			public static void updateStatus(Employee emp) {
					LeaveApplication leaves = new LeaveApplication();
					Set<Integer> processedIds = new HashSet<>();
					Map<Integer, LeaveApplication> leaveReqList = new HashMap<Integer, LeaveApplication>();
					try {
						String sql = "SELECT * FROM leaveApplication l JOIN employee e ON e.empId = l.empId JOIN department d ON e.DEPTID = d.DEPTID WHERE e.username = ? and l.status = ?";
						PreparedStatement prs = AppDriver.getConnection().prepareStatement(sql);
						while(true) {
							prs.setString(1, emp.getUserName());
							prs.setString(2, Status.WAITING_IN_QUEUE.toString());
							int i=1;
							ResultSet rs = prs.executeQuery();
							while(rs.next()) {
								LeaveType type = leaves.mapToEnum(rs.getString("LeaveType"));
								Date sdate = rs.getDate("startDate");
								Date edate = rs.getDate("endDate");
								Date submitDate = rs.getDate("SUBMITDATE");
								Status status = leaves.mapToStatus(rs.getString("status"));
								leaves = new LeaveApplication(emp, type, sdate.toLocalDate() , edate.toLocalDate(), rs.getString("leaveReason"), submitDate.toLocalDate(),status, rs.getString("rejectionReason") ,rs.getInt("workAssigned"));
								//System.out.println(leaves);
								leaveReqList.put(i++,leaves);
							}
							
							if((i-1)==0) {
								border.applyNoteBorder("No leaves available..."); break;
							}
							else {
								
								String formats = "\n+-------+-------+-------------+------------+------------+---------------------------+-------------+--------------------------+\n";
						        String format = "|%-5s  |%-5s  |%-11s  |%-10s  |%-10s  |%-25s  |%-10s  |%-24s  |";
						        System.out.print(formats);
						        System.out.printf(format, "S.No", "EmpId", "Leave Type", "Start Date", "End Date", "Leave Reason", "Submit Date", "Status");
						        
						        // Assign new keys and display the leave requests
						        
						        
						        for (Map.Entry<Integer, LeaveApplication> val : leaveReqList.entrySet()) {
						          
						            System.out.printf("%s|%-5s  |%-5s  |%-11s  |%-10s  |%-10s  |%-25s  |%-10s   |%-24s  |", 
								        	formats,
								        	val.getKey(),
								            val.getValue().getEmployee().getEmpId(), 
								            val.getValue().getLeavetype(), 
								            val.getValue().getStartDate(), 
								            val.getValue().getEndDate(), 
								            val.getValue().getLeaveReason(), 
								            val.getValue().getSubmitDate(), 
								            val.getValue().getStatus()
								            );
								            
						        }
						        System.out.print(formats);
//								int choice = sc.nextInt();
								int choice;
								while (true) {
									System.out.println("Enter the leave request id that you want to see [1 -" + (i-1) +"]. To exit enter " + (i) +": ");
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
								if(choice == i) {
									border.applyNoteBorder("Thank you for visiting...!");
									break;
								}
								else if(choice > i) {
									int continueStatus;
									System.out.println("Invalid choice...!");
									
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
									            	leaveReqList.clear();
													updateStatus(emp);
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
									for(Map.Entry<Integer, LeaveApplication> val : leaveReqList.entrySet()) {
										if(choice == val.getKey()) {
											cancelLeave(val.getValue());
										}
									}
								}
								
							}	
						}
					}
					catch(Exception e){
						System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
					}
				}
					
			//Cancel the applied leave 
			public static void cancelLeave(LeaveApplication leave) {
				try {
					String sql = "Update leaveapplication set status = ? where empID = ? and startDate = ?" ;
					PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
					prst.setString(1, Status.CANCELLED.toString());
					prst.setInt(2, leave.getEmployee().getEmpId());
					prst.setDate(3, Date.valueOf(leave.getStartDate()));
					int  res = prst.executeUpdate();
				    if(res == 0) {
				        System.out.println("Something went wrong...!");
				    } else {
				    	leave.setStatus(Status.CANCELLED);
				        border.applyNoteBorder("Leave request cancelled successfully...!");
				    }
				} 
		
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			//Update the leave application	
			public static void updateLeaveApplication(Employee emp) {
				LeaveApplication leaves = new LeaveApplication();
				HashMap<Integer, LeaveApplication> leaveReqList = new HashMap<Integer, LeaveApplication>();
				try {
					String sql = "SELECT * FROM leaveApplication l JOIN employee e ON e.empId = l.empId JOIN department d ON e.DEPTID = d.DEPTID WHERE e.username = ? and l.status = ?";
					PreparedStatement prs = AppDriver.getConnection().prepareStatement(sql);
					while(true) {
						prs.setString(1, emp.getUserName());
						prs.setString(2, Status.WAITING_IN_QUEUE.toString());
						int i=1;
						ResultSet rs = prs.executeQuery();
						while(rs.next()) {
							LeaveType type = leaves.mapToEnum(rs.getString("LeaveType"));
							Date sdate = rs.getDate("startDate");
							Date edate = rs.getDate("endDate");
							Date submitDate = rs.getDate("SUBMITDATE");
							Status status = leaves.mapToStatus(rs.getString("status"));
							leaves = new LeaveApplication(emp, type, sdate.toLocalDate() , edate.toLocalDate(), rs.getString("leaveReason"), submitDate.toLocalDate(),status, rs.getString("rejectionReason") ,rs.getInt("workAssigned"));
							//System.out.println(leaves);
							leaveReqList.put(i++,leaves);
						}
						
						if((i-1)==0) {
							border.applyNoteBorder("No leaves available..."); break;
						}
						else {
							
							String formats = "\n+-------+-------+-------------+------------+------------+---------------------------+-------------+--------------------------+\n";
					        String format = "|%-5s  |%-5s  |%-11s  |%-10s  |%-10s  |%-25s  |%-10s  |%-24s  |";
					        System.out.print(formats);
					        System.out.printf(format, "S.No", "EmpId", "Leave Type", "Start Date", "End Date", "Leave Reason", "Submit Date", "Status");
					        
					        // Assign new keys and display the leave requests
					        
					        
					        for (Map.Entry<Integer, LeaveApplication> val : leaveReqList.entrySet()) {
					          
					            System.out.printf("%s|%-5s  |%-5s  |%-11s  |%-10s  |%-10s  |%-25s  |%-10s   |%-24s  |", 
							        	formats,
							        	val.getKey(),
							            val.getValue().getEmployee().getEmpId(), 
							            val.getValue().getLeavetype(), 
							            val.getValue().getStartDate(), 
							            val.getValue().getEndDate(), 
							            val.getValue().getLeaveReason(), 
							            val.getValue().getSubmitDate(), 
							            val.getValue().getStatus()
							            );
							            
					        }
					        System.out.print(formats);
//							int choice = sc.nextInt();
							int choice;
							while (true) {
								System.out.println("Enter the leave request id that you want to see [1 -" + (i-1) +"]. To exit enter " + (i) +": ");
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
							if(choice == i) {
								border.applyNoteBorder("Thank you for visiting...!");
								break;
							}
							else if(choice > i) {
								int continueStatus;
								System.out.println("Invalid choice...!");
								
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
								            	leaveReqList.clear();
												updateLeaveApplication(emp);
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
								for(Map.Entry<Integer, LeaveApplication> val : leaveReqList.entrySet()) {
									if(choice == val.getKey()) {
										updateLeaveMenu(val.getValue());
									}
								}
							}
							
						}	
					}
				}
				catch(Exception e){
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			//Update Leave option
			public static void updateLeaveMenu(LeaveApplication leaves) throws IOException {
				System.out.println("Enter the attribute to be updated: ");
				while(true) {
					int ch;
					while (true) {
						System.out.println("1. StartDate\t2. EndDate\t3. LeaveReason\t4. LeaveType");
						System.out.println("Enter your choice[1 to 4]: ");
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
					case 1: updateStartDate(leaves); break;
					case 2: updateEndDate(leaves); break;
					case 3: updateLeaveReason(leaves); break;
					case 4: updateLeaveType(leaves); break;
					default: System.out.println("Enter the correct value [1 or 4]");
					}
					if(ch>=1 && ch<=4) {
						break;
					}
				}
			}
			
			//Update the startDate
			public static void updateStartDate(LeaveApplication leave) throws IOException {
				LocalDate newStartDate;
				while(true) {
		        	System.out.print("Enter start date as 'YYYY-MM-DD': ");
		            try {
		            	String date = bf.readLine();
		                newStartDate = validators.validateDate(date); break;
		            } catch (InvalidDateException e) {
		            	System.out.println("---------------------------------------------");
		                System.out.println("\n" + e.getMessage() + "\n");
		                System.out.println("---------------------------------------------");
		            }
		        }
				
				//System.out.println(leave.getEmpId());
				String sql = "Update leaveapplication set startDate = ? where empID = ? and startDate = ?";
				try {
					PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
					prst.setDate(1, Date.valueOf(newStartDate));
					prst.setInt(2, leave.getEmployee().getEmpId());
					prst.setDate(3, Date.valueOf(leave.getStartDate()));
					int  res = prst.executeUpdate();
					if(res==1) {
						border.applyNoteBorder("Start date updated successfully...!");
					}
					else {
						System.out.println("Something went wrong...!");
					}
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			//Update the endDate
			public static void updateEndDate(LeaveApplication leave) throws IOException {
				//Read end date
				LocalDate endDate;
				while(true) {
				     System.out.print("Enter end date as 'YYYY-MM-DD': ");
				     try {
				        String date = bf.readLine();
				        endDate = validators.validateDate(date); break;
				      } catch (InvalidDateException e) {
				    	  System.out.println("---------------------------------------------");
			                System.out.println("\n" + e.getMessage() + "\n");
			                System.out.println("---------------------------------------------");
				      }
				}
				String sql = "Update leaveapplication set endDate = ? where empID = ? and startDate = ?";
				try {
					PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
					prst.setDate(1, Date.valueOf(endDate));
					prst.setInt(2, leave.getEmployee().getEmpId());
					prst.setDate(3, Date.valueOf(leave.getStartDate()));
					int  res = prst.executeUpdate();
					if(res==1) {
						border.applyNoteBorder("End date updated successfully...!");
					}
					else {
						System.out.println("Something went wrong...!");
					}
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			//Update the LeaveReason
			public static void updateLeaveReason(LeaveApplication leave) throws IOException {
				System.out.print("Enter the leave reason: ");
				String leaveReason = bf.readLine(); 
				String sql = "Update leaveapplication set leaveReason = ? where empID = ? and startDate = ?";
				try {
					PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
					prst.setString(1, leaveReason);
					prst.setInt(2, leave.getEmployee().getEmpId());
					prst.setDate(3, Date.valueOf(leave.getStartDate()));
					int  res = prst.executeUpdate();
					if(res==1) {
						border.applyNoteBorder("Leave reason updated successfully...!");
					}
					else {
						System.out.println("Something went wrong...!");
					}
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
			
			//Update the LeaveType
			public static void updateLeaveType(LeaveApplication leave) throws IOException {
				
				String leaveTypes="";
				while(true) {
					int type;
					while (true) {
						System.out.println("1. Sick leave\t2. Casual leave\t3. Vacation leave\t4. Maternity leave\t5. Marriage leave");
						System.out.println("Enter your choice[1 to 5]: ");
						try {
			            	String input = bf.readLine().trim();
			                if (!validators.isNumeric(input)) {
			                	throw new InputMismatchException("Input is not a valid number.");
			                } else {
			                    type = Integer.parseInt(input);
			                    break;
			                }
			            } catch (InputMismatchException e) {
			            	System.out.println("---------------------------------------------");
			                System.out.println("\n" + e.getMessage() + "\n");
			                System.out.println("---------------------------------------------");
			            }
			        }
					if(type > 5) {
						System.out.println("Invalid Choice...!");
					}
					else 
					{
						if(type==1) {
							leaveTypes = LeaveType.SICK_LEAVE.toString();
						}
						else if(type == 2) {
							leaveTypes = LeaveType.CASUAL_LEAVE.toString();
						}
						else if(type == 3) {
							leaveTypes = LeaveType.VACATION_LEAVE.toString();
						}
						else if(type == 4) {
							leaveTypes = LeaveType.MATERNITY_LEAVE.toString();
						}
						else {
							leaveTypes = LeaveType.MARRIAGE_LEAVE.toString();
						}
						break;
					}
				}
				String sql = "Update leaveapplication set leaveType = ? where empID = ? and startDate = ?";
				try {
					PreparedStatement prst = AppDriver.getConnection().prepareStatement(sql);
					prst.setString(1,leaveTypes);
					prst.setInt(2, leave.getEmployee().getEmpId());
					prst.setDate(3, Date.valueOf(leave.getStartDate()));
					int  res = prst.executeUpdate();
					if(res==1) {
						border.applyNoteBorder("Status updated successfully...!"); 
					}
					else {
						System.out.println("Something went wrong...!");
					}
				}
				catch(Exception e) {
					System.out.println("---------------------------------------------");
	                System.out.println("\n" + e.getMessage() + "\n");
	                System.out.println("---------------------------------------------");
				}
			}
}
