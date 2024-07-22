package com.taskmanagement.role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.smartcliff.TaskManagementSystem.DbmsConnection;
import com.taskmanagement.exception.InvalidNumberException;
import com.taskmanagement.task.managements.Task;

public class Employee {
	private String name;
	private String mail;
	private String gender;
	private String number;
	private String city;
	private String password;
	private String role;
	private int task_status;
	private String hiredate;
	private int mag_id;

	public Employee(String name, String mail, String gender, String number, String city, String password, String role,
			String hiredate, int mag_id) {
		super();
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.number = number;
		this.city = city;
		this.password = password;
		this.role = role;
		this.hiredate = hiredate;
		this.mag_id = mag_id;
	}

	public int getMag_id() {
		return mag_id;
	}

	public void setMag_id(int mag_id) {
		this.mag_id = mag_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTask_status() {
		return task_status;
	}

	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}

	public String getHireDate() {
		return hiredate;
	}

	public void setHireDate(String hiredate) {
		this.hiredate = hiredate;
	}

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

	public static boolean empuser(Scanner sc, String mail, int empid) {

		boolean flag = true;
		while (flag) {
			System.out.println("*".repeat(200));
			System.out.println("Employee Menu");
			System.out.println("1.View Assigned Task");
			System.out.println("2.Check Task Status");
			System.out.println("3.Create Personal Task");
			System.out.println("4.Update Personal Task");
			System.out.println("5.Delete Personal Task");
			System.out.println("6.Update Status");
			System.out.println("7.Back");
			System.out.println("*".repeat(200));
			int opt2 = 0;
			opt2 = opt1Check(opt2, sc);

			switch (opt2) {
			case 1:

				System.out.println("Assigned Tasks: ");
				assignedTask(mail);

				break;

			case 2:

				System.out.println("Check Task Status ");
				CheckStatus(empid);

				break;

			case 3:

				System.out.println("Creating Personal Task");
				addTask(sc);
				break;

			case 4:

				System.out.println("Enter Task Status (1-Not Assinged,2-Assigned,3-Started,4-Pending,5-Progress,6-Completed): ");
				int task=sc.nextInt();
				task=Manager.taskOp(task, sc);
				updatePersonalTask(mail,task);
				break;

			case 5:

				System.out.println("Delete Personal Task");
				System.out.println("Enter The Task ID: ");
				int task_id = sc.nextInt();

				deleteTask(task_id);

				break;

			case 6:
				assignedTask(mail);
				System.out.println("Change Task Status ");

				int taskid = 0;
				int task1 = 0;
				boolean flag2 = true;

				while (flag2) {
					try {
						System.out.println("Enter Task ID: ");
						taskid = Integer.parseInt(sc.next());
//						CheckStatus(empid);
						flag2 = false;
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invaid Character...!");
					}
				}

				TaskStatus(empid, taskid);
				task1 = Manager.taskOp(task1, sc);

				changeStatus(task1, taskid, empid);
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

	private static void updatePersonalTask(String mail2, int task) {
		// TODO Auto-generated method stub
		
	}

	private static void CheckStatus(int empid) {

		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection().prepareStatement(
					"SELECT t.task_id, t.task_name, s.status FROM employee e JOIN transcation ts ON e.emp_id = ts.emp_id  JOIN task t ON ts.task_id = t.task_id JOIN task_status s ON ts.status_id = s.id  WHERE e.emp_id = ?");
			stmt.setInt(1, empid);

			ResultSet rs = stmt.executeQuery();

			String format = "| %-8s | %-20s | %-10s |%n";
			System.out.format("+----------+----------------------+------------+%n");
			System.out.format("| Task ID  | Task Name            | Status     |%n");
			System.out.format("+----------+----------------------+------------+%n");

			boolean hasResults = false;
			while (rs.next()) {
				hasResults = true;
				// Print each row in the table format
				System.out.format(format, rs.getInt("task_id"), rs.getString("task_name"), rs.getString("status"));
			}

			if (!hasResults) {
				System.out.println("No results found.");
			}

			System.out.format("+----------+----------------------+------------+%n");

			rs.close();
			stmt.close();
		} catch (SQLException e) {

			e.getMessage();
		}

	}

	public static void addTask(Scanner sc) {

		String priority = null;

		try {
			System.out.println("Enter Requried detials fro Task Creation: ");

			sc.nextLine();
			System.out.println("Enter Task Name: ");
			String name = sc.nextLine();

			System.out.println("Enter Task Description: ");
			String des = sc.nextLine();

			// UPDATE STARTDATE AND ENDDATE :
			String startdate = "";
			String enddate = "";

			LocalDate startdateDate = null;
			LocalDate enddateDate = null;

			do {
				// Prompt the user to enter the check-in date
				System.out.println("Enter Task Start Date(yyyy-MM-dd): ");
				startdate = sc.next();

				try {
					// Parse the input into a LocalDate object
					startdateDate = LocalDate.parse(startdate);

					// Check if the check-in date is in the past
					if (startdateDate.isBefore(LocalDate.now())) {
						System.out.println("Cannot create task for the past. Please choose a future date for task!");
						continue; // Continue the loop to prompt the user again
					}

					// Prompt the user to enter the check-out date
					System.out.println("Enter Task End Date(yyyy-MM-dd): ");
					enddate = sc.next();

					// Parse the input into a LocalDate object
					enddateDate = LocalDate.parse(enddate);

					// Check if the check-out date is before the check-in date
					if (enddateDate.isBefore(startdateDate)) {
						System.out.println(
								"End date must be after the task start date. Please enter a valid Task-End date.");
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
			System.out.println("Task Start Date: " + startdate);
			System.out.println("Task End Date: " + enddate);

			priority = TaskPriCheck(priority, sc);

			Task t = new Task(name, des, startdate, enddate, priority);
			createTask(t);
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String TaskPriCheck(String priority, Scanner sc) {
		boolean flag = true;
		while (flag) {
			System.out.println("Task Priority (High/Medium/Low) : ");
			priority = sc.next().toLowerCase();
			if (priority.equalsIgnoreCase("low") || priority.equalsIgnoreCase("medium")
					|| priority.equalsIgnoreCase("high")) {
				flag = false;
			} else {
				System.out.println("Enter The Correct Priority...");
			}
		}
		return priority;

	}

	public static void createTask(Task t) {
		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection().prepareStatement(
					"INSERT INTO personal_task (task_id, task_name, task_desp, start_date, end_date, task_priority) VALUES (personalseq.nextval,?,?,?,?,?)");

			stmt.setString(1, t.getTaskName());
			stmt.setString(2, t.getDescription());
			stmt.setString(3, t.getStartDate());
			stmt.setString(4, t.getEndDate());
			stmt.setString(5, t.getPriority());

			int rows = stmt.executeUpdate();
			System.out.println(rows + "\t updated");

		} catch (SQLException e) {
			e.getMessage();
		}
	} 

	private static void deleteTask(int taskid) {

	}

	private static void changeStatus(int task, int task_id, int empid) {

		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
					.prepareStatement("update transcation set status_id=? where emp_id=? and task_id=?");
			stmt.setInt(1, task);
			stmt.setInt(2, empid);
			stmt.setInt(3, task_id);

			int rows = stmt.executeUpdate();
			System.out.println(rows + " Updated");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TaskStatus(int empid, int task) {

		try {

			PreparedStatement stmt = DbmsConnection.getInstance().getConnection().prepareStatement(
					"select e.emp_id,e.name,ts.task_id,ts.task_name,s.status from employee e join transcation t on t.emp_id=e.emp_id join task ts on ts.task_id=t.task_id join task_status s on t.status_id=s.id where e.emp_id=? and ts.task_id=?");

			stmt.setInt(1, empid);
			stmt.setInt(2, task);
			ResultSet rs = stmt.executeQuery();

			String format = "| %-11s | %-17s | %-8s | %-15s | %-13s |%n";
			System.out.format("+-------------+-------------------+----------+-----------------+---------------+%n");
			System.out.format("| Employee Id | Employee Name     | Task ID  | Task Name       | Status        |%n");
			System.out.format("+-------------+-------------------+----------+-----------------+---------------+%n");

			boolean hasResults = false;
			while (rs.next()) {
				hasResults = true;
				// Print each row in the table format
				System.out.format(format, rs.getInt("emp_id"), rs.getString("name"), rs.getInt("task_id"),
						rs.getString("task_name"), rs.getString("status"));
			}

			if (!hasResults) {
				System.out.println("Employee with ID " + empid + " not found for this " + task + " Task ID.");

			} else {
				System.out.format("+-------------+-------------------+----------+-----------------+---------------+%n");
			}

			// Close the ResultSet and the PreparedStatement
			rs.close();
			stmt.close();

		} catch (SQLException e) {

			e.getMessage();
		}
	}

	private static void assignedTask(String mail) {
		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection().prepareStatement(
					"select e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy "
							+ "from employee e " + "join transcation ts on e.emp_id = ts.emp_id "
							+ "join task t on t.task_id = ts.task_id where e.email = ?");
			stmt.setString(1, mail);

			ResultSet rs = stmt.executeQuery();

			// Print table header
			System.out.println(
					"+----------------------+---------+----------------------+-----------------------------------------------------------------+--------------+--------------+-----------------+");
			System.out.printf("| %-20s | %-7s | %-20s | %-63s | %-12s | %-12s | %-15s |%n", "Name", "Task ID",
					"Task Name", "Task Description", "Start Date", "End Date", "Task Priority");
			System.out.println(
					"+----------------------+---------+----------------------+-----------------------------------------------------------------+--------------+--------------+-----------------+");

			// Print table rows
			while (rs.next()) {
				System.out.printf("| %-20s | %-7d | %-20s | %-63s | %-12s | %-12s | %-15s |%n", rs.getString("name"),
						rs.getInt("task_id"), rs.getString("task_name"), rs.getString("task_desp"),
						rs.getDate("start_date"), rs.getDate("end_date"), rs.getString("task_priortiy"));
			}

			// Print table footer
			System.out.println(
					"+----------------------+---------+----------------------+-----------------------------------------------------------------+--------------+--------------+-----------------+");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}