package com.taskmanagement.role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartcliff.TaskManagementSystem.DbmsConnection;
import com.taskmanagement.authentication.Validate;
import com.taskmanagement.exception.InvalidNumberException;
import com.taskmanagement.exception.NumberInputException;
import com.taskmanagement.exception.UserNameException;

public class RoleCorrection {

	public static int editCheck(int op1, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println("Enter your choice: ");
				op1 = Integer.parseInt(sc.next());
				System.out.println();

				if (op1 != 1 && op1 != 2 && op1 != 3 && op1 != 4 && op1 != 5) {
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
		return op1;
	}

	public static int EditCheck(int Editop1, Scanner sc) {

		boolean inputflag = true;
		while (inputflag) {
			try {
				System.out.println("Enter your choice: ");
				Editop1 = Integer.parseInt(sc.next());
				System.out.println();

				if (Editop1 != 1 && Editop1 != 2 && Editop1 != 3) {
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
		return Editop1;
	}

	public static boolean Editop(Scanner sc) {
		boolean flag = true;
		while (flag) {
			System.out.println("*".repeat(200));
			System.out.println("1.Edit For Employee");
			System.out.println("2.Edit For Manager");
			System.out.println("3.Back");
			System.out.println("*".repeat(200));
			int op1 = 0;

			op1 = EditCheck(op1, sc);

			switch (op1) {
			case 1:
				// for employee
				RoleCorrection.editemp(sc);

				break;

			case 2:
				// for manager
				RoleCorrection.editMag(sc);
				break;

			case 3:
				flag = false;

				System.out.println("Getting back to Menu");

				break;
			default:
				System.out.println("Invalid Option");
			}
		}

		return false;

	}

	public static boolean editemp(Scanner sc) {
		boolean flag = true;
		while (flag) {
			// editing employee
			System.out.println("*".repeat(200));
			System.out.println("Editing Employee: ");
			System.out.println("1. Edit Name");
			System.out.println("2. Edit Phone Number");
			System.out.println("3. Edit Role");
			System.out.println("4. Edit City");
			System.out.println("5. Back");
			System.out.println("*".repeat(200));
			int op1 = 0;

			op1 = editCheck(op1, sc);

			switch (op1) {
			case 1:
				int id = getValidEmployeeId(sc);
				if (id == -1)
					break;

				String name = null;
				boolean validName = false;
				while (!validName) {
					System.out.println("Enter New Name: ");
					name = sc.next();
					try {
						Validate.userNameValidate(name);
						validName = true;
						if (confirmChanges(sc)) {
							Admin.editNameEmp(id, name);
						} else {
							System.out.println("Changes discarded.");
						}
					} catch (UserNameException e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case 2:
				int id2 = getValidEmployeeId(sc);
				if (id2 == -1)
					break;

				String phone = null;
				boolean validPhone = false;
				while (!validPhone) {
					System.out.println("Enter New Phone Number: ");
					phone = sc.next();
					try {
						Validate.numberValidate(phone);
						validPhone = true;
						if (confirmChanges(sc)) {
							Admin.editPhoneEmp(id2, phone);
						} else {
							System.out.println("Changes discarded.");
						}
					} catch (NumberInputException e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case 3:
				int id3 = getValidEmployeeId(sc);
				if (id3 == -1)
					break;

				String role = EmployeeManagement.roleCheck(null, sc);
				if (confirmChanges(sc)) {
					Admin.editRoleEmp(id3, role);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 4:
				int id4 = getValidEmployeeId(sc);
				if (id4 == -1)
					break;

				System.out.println("Enter New City: ");
				String city = sc.next();
				if (confirmChanges(sc)) {
					Admin.editCityEmp(id4, city);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 5:
				flag = false;
				System.out.println("Getting back to Menu");
				break;

			default:
				System.out.println("Invalid Option");
			}
		}

		return false;
	}

	private static int getValidEmployeeId(Scanner sc) {
		int id = 0;
		boolean valid = false;
		while (!valid) {
			Admin.showemp();
			System.out.println("Enter Employee Id: ");
			try {
				id = Integer.parseInt(sc.next());
				if (isEmployeeIdValid(id)) {
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

	private static boolean isEmployeeIdValid(int id) {
		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
					.prepareStatement("SELECT COUNT(*) FROM employee WHERE emp_id = ? AND role = 'employee'");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean confirmChanges(Scanner sc) {
		System.out.println("Do you want to save the changes? (yes/no): ");
		String response = sc.next();
		return response.equalsIgnoreCase("yes");
	}

	public static boolean editMag(Scanner sc) {
		boolean flag = true;
		while (flag) {
			// editing manager
			System.out.println("*".repeat(200));
			System.out.println("Editing Manager: ");
			System.out.println("1. Edit Name");
			System.out.println("2. Edit Phone Number");
			System.out.println("3. Edit Role");
			System.out.println("4. Edit City");
			System.out.println("5. Back");
			System.out.println("*".repeat(200));
			int op1 = 0;

			op1 = editCheck(op1, sc);

			switch (op1) {
			case 1:
				int id = getValidManagerId(sc);
				if (id == -1)
					break;

				String name = null;
				boolean validName = false;
				while (!validName) {
					System.out.println("Enter New Name: ");
					name = sc.next();
					try {
						Validate.userNameValidate(name);
						validName = true;
						if (confirmChanges(sc)) {
							Admin.editNameMag(id, name);
						} else {
							System.out.println("Changes discarded.");
						}
					} catch (UserNameException e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case 2:
				int id2 = getValidManagerId(sc);
				if (id2 == -1)
					break;

				String phone = null;
				boolean validPhone = false;
				while (!validPhone) {
					System.out.println("Enter New Phone Number: ");
					phone = sc.next();
					try {
						Validate.numberValidate(phone);
						validPhone = true;
						if (confirmChanges(sc)) {
							Admin.editPhoneMag(id2, phone);
						} else {
							System.out.println("Changes discarded.");
						}
					} catch (NumberInputException e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case 3:
				int id3 = getValidManagerId(sc);
				if (id3 == -1)
					break;

				String role = EmployeeManagement.roleCheck(null, sc);
				if (confirmChanges(sc)) {
					Admin.editRoleMag(id3, role);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 4:
				int id4 = getValidManagerId(sc);
				if (id4 == -1)
					break;

				String city = null;
				System.out.println("Enter New City: ");
				city = sc.next();
				if (confirmChanges(sc)) {
					Admin.editCityMag(id4, city);
				} else {
					System.out.println("Changes discarded.");
				}
				break;

			case 5:
				flag = false;
				System.out.println("Getting back to Menu");
				break;

			default:
				System.out.println("Invalid Option");
			}
		}

		return false;
	}

	private static int getValidManagerId(Scanner sc) {
		int id = 0;
		boolean valid = false;
		while (!valid) {
			Admin.showmag();
			System.out.println("Enter Manager Id: ");
			try {
				id = Integer.parseInt(sc.next());
				if (isManagerIdValid(id)) {
					valid = true;
				} else {
					System.out.println("Manager ID not found. Please enter a valid Manager ID.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid Manager ID.!");
			}
		}
		return id;
	}

	private static boolean isManagerIdValid(int id) {
		try {
			PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
					.prepareStatement("SELECT COUNT(*) FROM employee WHERE emp_id = ? AND role = 'manager'");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
