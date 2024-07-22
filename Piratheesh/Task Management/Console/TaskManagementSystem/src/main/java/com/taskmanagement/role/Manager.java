package com.taskmanagement.role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartcliff.TaskManagementSystem.DbmsConnection;
import com.taskmanagement.exception.InvalidNumberException;
import com.taskmanagement.task.managements.*;

public class Manager {

	public static int opt1Check(int opt2, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println("Enter your choice: ");
				opt2 = Integer.parseInt(sc.next());
				System.out.println();

				if (opt2 != 1 && opt2 != 2 && opt2 != 3 && opt2 != 4 && opt2 != 5 && opt2 != 6 && opt2 != 7) {
					throw new InvalidNumberException("Please enter a valid number");
				}
				inputflag = false;
			} catch (NumberFormatException e) {
				System.out.println("You have entered a character!!!... Please enter a number!");
				System.out.println();
				sc.nextLine();

			} catch (InvalidNumberException e) {
				System.out.println("!" + e.getMessage() + "!");
			}

		}
		return opt2;
	}

	public static boolean maguser(Scanner sc, String mail, int empid) {

		boolean flag = true;
		while (flag) {
			System.out.println("*".repeat(200));
			System.out.println("Manager Menu");
			System.out.println("1.Create Task");
			System.out.println("2.View Task Description");
			System.out.println("3.Edit Task");
			System.out.println("4.View Employee");
			System.out.println("5.Assinge Task");
			System.out.println("6.Update Task");
			System.out.println("7.Back");
			System.out.println("*".repeat(200));
			int opt2 = 0;
			opt2 = opt1Check(opt2, sc);

			switch (opt2) {
			case 1:

				TaskManager.addTask(sc);
				break;

			case 2:

				TaskDescription(sc, empid);
				break;

			case 3:

				editTask(sc, empid);
				break;

			case 4:

				viewEmployee(sc, mail, empid);
				break;

			case 5:

				displayEmployee(mail, empid, sc);
				break;

			case 6:

				updateTask(mail, empid, sc);
				break;

			case 7:
				flag = false;
				
				System.out.println("Getting Back to Main Menu");
				break;

			default:
				System.out.println("Invalid Choice....");

			}
		}
		return false;

	}

	private static void viewEmployee(Scanner sc, String mail, int empid) {
		boolean flag1 = true;
		while (flag1) {
			System.out.println("*".repeat(200));
			System.out.println("1.View All Employee's Task");
			System.out.println("2.View Particular Employee's Task");
			System.out.println("3.Back To Manager Menu");

			System.out.println("*".repeat(200));

			int option1 = 0;
			option1 = option1Check(option1, sc);

			switch (option1) {
			case 1:
				System.out.println("Displaying All Employees Task: ");
				TaskManager.DisplayEmployee(mail, empid);
				break;

			case 2:
				TaskManager.DisplayEmployee(mail, empid);
				System.out.println("Enter Employee Id: ");
				int id = sc.nextInt();
				TaskManager.DisplayParticular(id, empid);
				break;

			case 3:
				flag1 = false;

				System.out.println("Getting Back to Manager Menu");
				break;
			}
		}

	}

	private static void displayEmployee(String mail, int empid, Scanner sc) {
		TaskManager.DisplayEmployee(mail, empid);
		int id1 = 0;
		int task_id = 0;
		boolean flag1 = true;
		while (flag1) {
			try {
				System.out.println("Enter Employee ID: ");
				id1 = Integer.parseInt(sc.next());
				TaskManager.DisplayParticular(id1, empid); // Moved here to confirm valid employee
				flag1 = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Character...!");
			}
		}

		flag1 = true;
		while (flag1) {
			try {
				TaskManager.DisplayAll(empid);
				System.out.println("Enter Task ID to Assign: ");
				task_id = Integer.parseInt(sc.next());
				flag1 = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Character...!");
			}
		}

		TaskManager.AssignTask(id1, task_id, empid);
	}

	private static void updateTask(String mail, int empid, Scanner sc) {
	    int id = 0;
	    int taskid = 0;
	    int task = 0;
	    
	    // Loop to get a valid Employee ID
	    id = getValidEmployeeId(sc, mail, empid);
	    
	    // Loop to get a valid Task ID
	    try {
            TaskManager.DisplayParticular(id, empid);
            System.out.println("Enter Task ID: ");
            taskid = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Character...!");
        }
	    
	    // Get the task operation based on user input
	    task = taskOp(task, sc);
	    
	    // Update the task with the provided Employee ID, task, and Task ID
	    TaskManager.updateTask(id, task, taskid);
	}

	private static int getValidEmployeeId(Scanner sc, String mail,int empid) {
		int id = 0;
		boolean valid = false;
		while (!valid) {
			TaskManager.DisplayEmployee(mail, empid);
			System.out.println("Enter Employee Id: ");
			try {
				id = Integer.parseInt(sc.next());
				if (isEmployeeIdValid(id,empid)) {
					valid = true;
				} else {
					System.out.println("Employee ID not found. Please enter a valid Employee ID.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid Employee ID.!");
			}
		}
		return id;
	}
	private static boolean isEmployeeIdValid(int id,int empid) {
		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
					.prepareStatement("SELECT COUNT(*) FROM employee WHERE emp_id = ? AND role = 'employee' and mag_id=?");
			stmt.setInt(1, id);
			stmt.setInt(2, empid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	private static int getValidtaskId(Scanner sc, int empid, int id) {
//	    boolean flag = true;
//	    int taskid = -1;
//	    while (flag) {
//	        try {
//	            TaskManager.DisplayParticular(id, empid);
//	            System.out.println("Enter Task ID: ");
//	            taskid = Integer.parseInt(sc.next());
//	            if (TaskManager.taskExistsemp(taskid, id, empid)) {
//	                flag = false;
//	            } else {
//	                System.out.println("Task ID not found. Please try again.");
//	            }
//	        } catch (NumberFormatException e) {
//	            System.out.println("Invalid Character...!");
//	        }
//	    }
//	    sc.nextLine(); // clear the buffer
//	    return taskid; // Return the task ID correctly
//	}

	public static int taskOp(int task, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println(
						"Enter Task Status (1-Not Assinged,2-Assigned,3-Started,4-Pending,5-Progress,6-Completed): ");
				task = Integer.parseInt(sc.next());
				System.out.println();

				if (task != 1 && task != 2 && task != 3 && task != 4 && task != 5 && task != 6) {
					throw new InvalidNumberException("Please enter a valid number");
				}
				inputflag = false;
			} catch (NumberFormatException e) {
				System.out.println("You have entered a character!!!... Please enter a number!");
				System.out.println();
				sc.nextLine();

			} catch (InvalidNumberException e) {
				System.out.println("!" + e.getMessage() + "!");
			}

		}
		return task;
	}

	private static int option1Check(int option1, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println("Enter your choice: ");
				option1 = Integer.parseInt(sc.next());
				System.out.println();

				if (option1 != 1 && option1 != 2 && option1 != 3) {
					throw new InvalidNumberException("Please enter a valid number");
				}
				inputflag = false;
			} catch (NumberFormatException e) {
				System.out.println("You have entered a character!!!... Please enter a number!");
				System.out.println();
				sc.nextLine();

			} catch (InvalidNumberException e) {
				System.out.println("!" + e.getMessage() + "!");
			}

		}
		return option1;
	}

	public static int optEditCheck(int optEdit, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println("Enter your choice: ");
				optEdit = Integer.parseInt(sc.next());
				System.out.println();

				if (optEdit != 1 && optEdit != 2 && optEdit != 3 && optEdit != 4 && optEdit != 5 && optEdit != 6
						&& optEdit != 7) {
					throw new InvalidNumberException("Please enter a valid number");
				}
				inputflag = false;
			} catch (NumberFormatException e) {
				System.out.println("You have entered a character!!!... Please enter a number!");
				System.out.println();
				sc.nextLine();

			} catch (InvalidNumberException e) {
				System.out.println("!" + e.getMessage() + "!");
			}

		}
		return optEdit;
	}

	private static boolean editTask(Scanner sc, int empid) {
		boolean flag = true;
		while (flag) {
			System.out.println("*".repeat(200));
			System.out.println("Task Edit Menu");
			System.out.println("1.Edit Task Name");
			System.out.println("2.Edit Task Description");
			System.out.println("3.Edit Start Date");
			System.out.println("4.Edit End Date");
			System.out.println("5.Edit Task Priority");
			System.out.println("6.Edit Employee Id");
			System.out.println("7.Back To Manager Menu");
			System.out.println("*".repeat(200));
			int optEdit = 0;
			optEdit = optEditCheck(optEdit, sc);

//			boolean flag1 = true;
			int id = 0;
			switch (optEdit) {
			case 1:
				id = getValidTaskId(sc, empid);
				if (id == -1)
					break;
				System.out.println("Enter New Task Name: ");
				String name = sc.nextLine();
				if (confirmChange(sc)) {
					TaskManager.editName(id, name);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 2:
				id = getValidTaskId(sc, empid);
				if (id == -1)
					break;
				sc.nextLine();
				System.out.println("Enter New Description: ");
				String desp = sc.nextLine();
				if (confirmChange(sc)) {
					TaskManager.editDesp(id, desp);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 3:
				id = getValidTaskId(sc, empid);
				if (id == -1)
					break;
				System.out.println("Enter The New Start Date(dd-MMM-yyyy): ");
				String sdate = sc.next();
				if (confirmChange(sc)) {
					TaskManager.editSDate(id, sdate);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 4:
				id = getValidTaskId(sc, empid);
				if (id == -1)
					break;
				System.out.println("Enter The New End Date(dd-MMM-yyyy): ");
				String edate = sc.next();
				if (confirmChange(sc)) {
					TaskManager.editEDate(id, edate);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 5:
				id = getValidTaskId(sc, empid);
				if (id == -1)
					break;
				System.out.println("Enter New Task Priority(High/Medium/Low): ");
				String pri = sc.next();
				if (confirmChange(sc)) {
					TaskManager.editTaskPriority(id, pri);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 6:
				id = getValidTaskId(sc, empid);
				if (id == -1)
					break;
				System.out.println("Enter New Employee Id: ");
				int empyid = sc.nextInt();
				if (confirmChange(sc)) {
					TaskManager.editAssign(id, empyid);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 7:
				flag = false;
				System.out.println("Getting Back to Main Menu");
				break;

			default:
				System.out.println("Invalid Choice....");
			}
		}
		return false;
	}

	private static int getValidTaskId(Scanner sc, int empid) {
		boolean flag = true;
		int id = -1;
		while (flag) {
			try {
				TaskManager.DisplayAll(empid);
				System.out.println("Enter Task ID: ");
				id = Integer.parseInt(sc.next());
				if (TaskManager.taskExists(id)) {
					flag = false;
				} else {
					System.out.println("Task ID not found. Please try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Character...!");
			}
		}
		sc.nextLine(); // clear the buffer
		return id;
	}

	private static boolean confirmChange(Scanner sc) {
		System.out.println("Are you sure you want to make this change? (yes/no)");
		String confirmation = sc.next();
		sc.nextLine(); // clear the buffer
		return confirmation.equalsIgnoreCase("yes");
	}

	private static int optCheck(int opt2, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println("Enter your choice: ");
				opt2 = Integer.parseInt(sc.next());
				System.out.println();

				if (opt2 != 1 && opt2 != 2 && opt2 != 3) {
					throw new InvalidNumberException("Please enter a valid number");
				}
				inputflag = false;
			} catch (NumberFormatException e) {
				System.out.println("You have entered a character!!!... Please enter a number!");
				System.out.println();
				sc.nextLine();

			} catch (InvalidNumberException e) {
				System.out.println("!" + e.getMessage() + "!");
			}

		}
		return opt2;
	}

	private static boolean TaskDescription(Scanner sc, int empid) {

		boolean flag = true;
		while (flag) {
			System.out.println("*".repeat(200));
			System.out.println("Task Description Menu");
			System.out.println("1.Display All Tasks");
			System.out.println("2.Display Particular Task Description");

			System.out.println("3.Back Manager Menu");
			System.out.println("*".repeat(200));
			int opt2 = 0;
			opt2 = optCheck(opt2, sc);

			boolean flag1 = true;
			int id = 0;
			switch (opt2) {
			case 1:

				TaskManager.DisplayAll(empid);
				break;

			case 2:

				while (flag1) {
					try {
						TaskManager.DisplayAll(empid);
						System.out.println("Enter the Task ID: ");
						id = Integer.parseInt(sc.next());
						TaskManager.DisplayOneTask(id);
						flag1 = false;
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invaid Character...!Enter the valid Task ID!");
					}
				}

				break;

			case 3:
				flag = false;

				System.out.println("Back to Manager Menu");

				break;

			default:
				System.out.println("Invalid Choice....");

			}
		}
		return false;

	}

}
