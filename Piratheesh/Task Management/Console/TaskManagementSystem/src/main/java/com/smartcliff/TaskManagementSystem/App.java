package com.smartcliff.TaskManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;
import com.taskmanagement.authentication.UserAuthentication;
import com.taskmanagement.exception.InvalidNumberException;
import com.taskmanagement.role.Admin;
import com.taskmanagement.role.Employee;
import com.taskmanagement.role.Manager;


public class App {

	// Method to get the role from the user
	public static int getRole(Scanner sc) {
		while (true) {
			try {
				System.out.println("*".repeat(200));
				System.out.println("Press 1 to login as Admin...");
				System.out.println("Press 2 to login as Manager...");
				System.out.println("Press 3 to login as Employee...");
				System.out.println("Press 4 to exit..");
				System.out.println("*".repeat(200));

				System.out.println("Enter your choice: ");
				int role = Integer.parseInt(sc.next());

				if (role != 1 && role != 2 && role != 3 && role != 4) {
					throw new InvalidNumberException("Please enter a valid number");
				}

				return role;
			} catch (NumberFormatException e) {
				System.out.println("You have entered a character!!!... Please enter a number!");
				System.out.println();
			} catch (InvalidNumberException e) {
				System.out.println("!" + e.getMessage() + "!");
			}
		}
	}

	// Main method
	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("*".repeat(200));
		System.out.println("---------Effective Task Management System--------");

		int role;

		while (true) {
			role = getRole(sc); // Get the role from the user

			if (role == 4) { // Exit if the user chooses to
				DbmsConnection.closeConnection();
				System.out.println("Thank you...");
				System.out.println("----------------------Exit----------------------");
				break;
			}

			UserAuthentication log = new UserAuthentication(); // Create an instance of UserAuthentication

			switch (role) {

			case 1: // Admin login
				boolean adminLoginSuccess = false;
				for (int i = 3; i > 0; i--) {
					System.out.println("Enter the Admin Email: ");
					String adminEmail = sc.next().trim();

					System.out.println("Enter the password: ");
					String adminPassword = sc.next().trim();

					adminLoginSuccess = log.loginadmin(adminEmail, adminPassword); // Authenticate admin
					if (adminLoginSuccess) {
						Admin.adminuser(sc); // Direct to admin interface
						break;
					} else {
						System.out.println("Incorrect email or password. Attempts left: " + (i - 1));
					}
				}
				if (!adminLoginSuccess) {
					System.out.println("Maximum attempts reached. Returning to main menu.");
				}
				break;

			case 2: // Manager login
				String manEmail = "";
				int manId = 0;
				boolean manLoginSuccess = false;
				for (int i = 3; i > 0; i--) {
					System.out.println("Enter the Manager Email: ");
					manEmail = sc.next().trim();

					System.out.println("Enter the password: ");
					String manPassword = sc.next().trim();

					manLoginSuccess = log.loginman(manEmail, manPassword); // Authenticate manager
					if (manLoginSuccess) {
						manId = UserAuthentication.manager(manEmail);
						Manager.maguser(sc, manEmail, manId); // Direct to manager interface
						break;
					} else {
						System.out.println("Incorrect email or password. Attempts left: " + (i - 1));
					}
				}
				if (!manLoginSuccess) {
					System.out.println("Maximum attempts reached. Returning to main menu.");
				}
				break;

			case 3: // Employee login
				String empEmail = "";
				int empId = 0;
				boolean empLoginSuccess = false;
				for (int i = 3; i > 0; i--) {
					System.out.println("Enter the Employee Email: ");
					empEmail = sc.next().trim();

					System.out.println("Enter the password: ");
					String empPassword = sc.next().trim();

					empLoginSuccess = log.loginemp(empEmail, empPassword); // Authenticate employee
					if (empLoginSuccess) {
						empId = UserAuthentication.employee(empEmail);
						Employee.empuser(sc, empEmail, empId); // Direct to employee interface
						break;
					} else {
						System.out.println("Incorrect email or password. Attempts left: " + (i - 1));
					}
				}
				if (!empLoginSuccess) {
					System.out.println("Maximum attempts reached. Returning to main menu.");
				}
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
}
