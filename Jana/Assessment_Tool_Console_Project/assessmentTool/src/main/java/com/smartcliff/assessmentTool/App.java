package com.smartcliff.assessmentTool;

//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
//import java.sql.Statement;
//import java.util.InputMismatchException;
import java.util.Scanner;

import com.courseDetail.Assessment;
import com.courseDetail.Course;
import com.courseDetail.VerifyData;
//import com.courseDetail.Course;
//import com.exceptionDetails.EmailException;
import com.exceptionDetails.InvalidOptionException;
//import com.exceptionDetails.PasswordException;
import com.exceptionDetails.UserNameException;
//import com.exceptionDetails.Validate;
import com.userDetail.Admin;
import com.userDetail.Authentication;
import com.userDetail.Educator;
import com.userDetail.Student;

public class App {
	static Scanner sc = new Scanner(System.in);

	static int user;

	public static void main(String[] args) {
		// ANSI escape codes for colors
		final String RESET = "\033[0m";
//        final String BLACK_BOLD = "\033[1;30m";  // BLACK
		final String RED_BOLD = "\033[1;31m"; // RED
//        final String GREEN_BOLD = "\033[1;32m";  // GREEN
//        final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
		final String BLUE_BOLD = "\033[1;34m"; // BLUE
//        final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
//        final String CYAN_BOLD = "\033[1;36m";   // CYAN
//        final String WHITE_BOLD = "\033[1;37m";  // WHITE

		System.out
				.println(RED_BOLD + "-----------------------------------------------------------------------" + RESET);
		System.out
				.println(BLUE_BOLD + "|                          ASSESSMENT TOOL                            |" + RESET);
		System.out
				.println(RED_BOLD + "-----------------------------------------------------------------------" + RESET);

		try {
			home();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidOptionException e) {
			e.printStackTrace();
		} catch (UserNameException e) {
			e.printStackTrace();
		}
	}

	// HOME MENU FOR LOGIN
	public static void home() throws SQLException, InvalidOptionException, UserNameException {
		// ANSI escape codes for colors
		final String RESET = "\033[0m";
		final String RED_BOLD = "\033[1;31m"; // RED
		final String GREEN_BOLD = "\033[1;32m"; // GREEN
		final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
		final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
//        final String CYAN_BOLD = "\033[1;36m";   // CYAN
//        final String WHITE_BOLD = "\033[1;37m";  // WHITE

		try {
			System.out.println(YELLOW_BOLD + "Log in as?" + RESET);
			System.out.println(GREEN_BOLD + "1. Admin" + RESET);
			System.out.println(GREEN_BOLD + "2. Educator" + RESET);
			System.out.println(GREEN_BOLD + "3. Student" + RESET);
			System.out.println(GREEN_BOLD + "4. Exit" + RESET);
			System.out.println(
					RED_BOLD + "----------------------------------------------------------------------" + RESET);

			int user = Integer.parseInt(sc.next());
			if (user == 4) {
				System.out.println(PURPLE_BOLD + "*** Exit Successful ***" + RESET);
				System.exit(0);
			} else if (user > 4) {
				System.out.println(RED_BOLD + "*** Please select an appropriate option! ***" + RESET);
				home();
			} else if (user < 4) {
				login(user);
			}
		} catch (NumberFormatException n) {
			System.out.println(RED_BOLD + "*** Only numbers are allowed! ***" + RESET);
			home();
		}
	}

	// LOGIN DRIVER

	public static void login(int user) throws SQLException, InvalidOptionException, UserNameException {
		Authentication a = new Authentication();
		boolean validated = false;

		do {
			System.out.println("Please enter your Email ID: ");
			String email = sc.next().trim();

			System.out.println("Please enter your password(Ex:Password@123)");
			String password = sc.next().trim();

			switch (user) {

			case 1:
				if (email.equals("admin") && password.equals("123")) {
					System.out.println("Welcome Admin");
					validated = true;
					adminMenu();
				} else {
					System.out.println("Invalid Credentials!");
					confirmation(user);
				}

			case 2:
				Educator e = a.validateEducatorLogin(email, password);
				// boolean validated =false;

				if (e != null) {
					System.out.println("Login Successfull!");
					System.out.println("Welcome " + e.getEfirstName() + " " + e.getelastName());
					validated = true;
					educatorHome(e);
					break;
				} else {
					System.out.println("Invalid credentials! Please Try Again");
					validated = false;
					confirmation(user);
				}

			case 3:
				Student s = a.validateStudentLogin(email, password);
				if (s != null) {
					System.out.println("Login Successfull!");
					System.out.println("Welcome " + s.getSfirstName() + " " + s.getSlastName());
					validated = true;
					studentMenu(s);
					break;
				} else {
					System.out.println("Invalid credentials! Please Try Again");
					validated = false;
					confirmation(user);

				}

			}
		} while (!validated);

	}

	// Ensuring User Confirmation when given Invalid Credentials

	public static void confirmation(int user) throws SQLException, InvalidOptionException, UserNameException {
		boolean check = true;
		while (check) {
			int n = 0;
			System.out.println("Do you want to try again?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			try {
				n = Integer.parseInt(sc.next());
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				confirmation(user);
			}
			if (n == 1) {
				check = false;
				login(user);
			} else if (n == 2) {
				home();
			} else if (n > 2) {
				new InvalidOptionException("Please select appropriate Option!");
				confirmation(user);
			}

		}
	}
	
	//ADMIN MENU

	public static void adminMenu() throws InvalidOptionException, SQLException, UserNameException {

		System.out.println("1.Educator Management");
		System.out.println("2.Student Management");
		System.out.println("3.Course Management");
		System.out.println("4.Logout");
		System.out.println("5.Exit");
		System.out.println("-----------------------------------------------------------------------");
		int admMenu = 0;
		try {
			admMenu = Integer.parseInt(sc.next());
		} catch (NumberFormatException nf) {
			System.out.println("Only Numbers are allowed!");
			adminMenu();
		}
		switch (admMenu) {
		case 1:
			adminFunctionalities(admMenu);
			break;
		case 2:
			adminFunctionalities(admMenu);
			break;
		case 3:
			adminFunctionalities(admMenu);
			break;
		case 4:
			System.out.println("Successfully Logged Out!");
			home();
			break;
		case 5:
			System.out.println("Exit Successfull!");
			break;
		default:
			System.out.println("Please select valid Option!(1-5)");
			adminMenu();
		}

	}
	
	//FUNCTIONALITIES FOR ADMIN

	public static void adminFunctionalities(int admMenu)
			throws SQLException, InvalidOptionException, UserNameException {

		Admin a = new Admin("Admin", "123");
		int choice = 0;
		switch (admMenu) {

		case 1:
			System.out.println("----------------------EDUCATOR MANAGEMENT------------------------------");
			System.out.println("1.Add Educator");
			System.out.println("2.Edit Educator");
			System.out.println("3.Assign Course to Educator");
			System.out.println("4.View Educators Detail");
			System.out.println("5.Back");
			System.out.println("6.Exit");
			System.out.println("-----------------------------------------------------------------------");

			try {
				choice = Integer.parseInt(sc.next());
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				adminFunctionalities(admMenu);
			}

			switch (choice) {
			case 1:
				a.addEducator();
				break;
			case 2:
				System.out.println("Enter Educator id");
				int id = 0;
				try {
					id = Integer.parseInt(sc.next());
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
					adminFunctionalities(admMenu);
				}
				Educator e = VerifyData.validateEducator(id);

				if (e != null) {
					System.out.println("1.Edit email");
					System.out.println("1.Edit Password");
					System.out.println("2.Edit First Name");
					System.out.println("3.Edit Last Name");
					System.out.println("4.Edit City");
					System.out.println("5.Edit Country");
					System.out.println("6.Edit course Id");
					System.out.println("7.Back");
					System.out.println("-----------------------------------------------------------------------");
				} else {
					System.out.println("Educator ID doesn't Exist!");
					adminFunctionalities(admMenu);
				}
				int opt = 0;

				try {
					opt = Integer.parseInt(sc.next());
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
					adminFunctionalities(admMenu);
				}
				id = e.getEid();
				switch (opt) {
				case 1:
					Admin.editEmail(id);
					break;
				case 2:
					a.editPassword(id);
					break;
				case 3:
					a.editFirstName(id);
					break;
				case 4:
					a.editLastName(id);
					break;
				case 5:
					a.editCity(id);
					break;
				case 6:
					a.editCountry(id);
					break;
				case 7:
					a.editCid(id);
					break;
				case 8:
					adminMenu();
					break;
				default:
					System.out.println("Please Select Valid Option!(1-7)");
					adminFunctionalities(admMenu);
					break;

				}
				break;
			case 3:

				int assign = 0;

				try {
					System.out.println("Enter Employee Id to assign Course:");
					assign = Integer.parseInt(sc.next());
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
					adminFunctionalities(admMenu);
				}

				Educator edObj = VerifyData.validateEducator(assign);
				if (edObj != null) {
					a.assignEducatorCourse(edObj);
					break;
				} else {
					System.out.println("Educator ID Not Found!");
					adminFunctionalities(admMenu);
				}
				break;
			case 4:
				a.showEducators();
				break;
			case 5:
				adminMenu();
				break;
			case 6:
				System.out.println("Exit Success!");
				System.exit(0);
			default:
				System.out.println("Please Select Valid Option!(1-6)");
				adminFunctionalities(admMenu);
				break;

			}
		case 2:
			System.out.println("----------------------STUDENT MANAGEMENT------------------------------");
			System.out.println("1.Add Student");
			System.out.println("2.Edit Student");
			System.out.println("3.Assign Course to Student");
			System.out.println("4.View Students Detail");
			System.out.println("5.Back");
			System.out.println("6.Exit");
			System.out.println("-----------------------------------------------------------------------");
			try {
				choice = Integer.parseInt(sc.next());
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				adminFunctionalities(admMenu);
			}

			switch (choice) {
			case 1:
				a.addStudent();
				break;
			case 2:
				System.out.println("Enter Student ID");
				int id = 0;
				try {
					id = Integer.parseInt(sc.next());
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
					adminFunctionalities(admMenu);
				}

				if (VerifyData.validateStudent(id) != null) {

					System.out.println("1.Edit email");
					System.out.println("2.Edit Password");
					System.out.println("3.Edit First Name");
					System.out.println("4.Edit Last Name");
					System.out.println("5.Edit City");
					System.out.println("6.Edit Country");
					System.out.println("7.Edit course Id");
					System.out.println("8.Back ");
					System.out.println("-----------------------------------------------------------------------");
				} else {
					System.out.println("Student ID not Found!");
					adminFunctionalities(2);
					break;
				}
				int opt = 0;
				try {
					opt = Integer.parseInt(sc.next());
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
					adminFunctionalities(admMenu);
				}
				switch (opt) {
				case 1:
					a.editStuEmail(id);
					break;
				case 2:
					a.editStuPassword(id);
					break;
				case 3:
					a.editStuFirstName(id);
					break;
				case 4:
					a.editStuLastName(id);
					break;
				case 5:
					a.editStuCity(id);
					break;
				case 6:
					a.editStuCountry(id);
					break;
				case 7:
					a.editStuCid(id);
					break;
				case 8:
					adminFunctionalities(2);
					break;
				default:
					System.out.println("Please select valid option(1-8)");
					adminFunctionalities(2);
					break;
				}
				break;
			case 3:
//				System.out.println("Enter student Id to remove:");
//				int delete = 0;
//				try {
//					delete = Integer.parseInt(sc.next());
//				} catch (NumberFormatException nf) {
//					System.out.println("Only Numbers are allowed!");
//					adminFunctionalities(admMenu);
//				}
				a.assignCourse();
//				if (Admin.checkStudent(delete)) {
//					Admin.removeStudent(delete);
//				} else {
//					System.out.println("Student ID not Found!");
//					adminFunctionalities(2);
//					break;
//				}
			case 4:
				a.showStudents();
				break;
			case 5:
				adminMenu();
				break;
			case 6:
				System.out.println("Exit Success!");
				System.exit(0);
			default:
				System.out.println("Please Select Valid Option!(1-6)");
				adminFunctionalities(admMenu);
				break;

			}

		case 3:
			System.out.println("----------------------COURSE MANAGEMENT------------------------------");
			System.out.println("1.Add Course");
			System.out.println("2.Edit Course");
			System.out.println("3.Remove Course");
			System.out.println("4.View Course Details");
			System.out.println("5.Back");
			System.out.println("6.Exit");
			System.out.println("-----------------------------------------------------------------------");
			try {
				choice = Integer.parseInt(sc.next());
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				adminFunctionalities(admMenu);
			}

			switch (choice) {

			case 1:
				a.addCourse();
				break;
			case 2:

				int cid = 0;
				while (true) {
					try {
						System.out.println("Enter Course ID");
						cid = Integer.parseInt(sc.next());
						break;
					} catch (NumberFormatException nf) {
						System.out.println("Only Numbers are allowed!");
					}
				}
				a.editCourseName(cid);
				break;
			case 3:

				int delete = 0;
				while (true) {
					try {
						System.out.println("Enter course Id to remove:");
						delete = Integer.parseInt(sc.next());
						break;
					} catch (NumberFormatException nf) {
						System.out.println("Only Numbers are allowed!");
					}
				}

				if (VerifyData.validateCourse(delete) != null) {
					a.removeCourse(delete);
				} else {
					System.out.println("Course ID not Found!");
					adminFunctionalities(admMenu);
					break;
				}
			case 4:
				a.ViewCourses();
				break;
			case 5:
				adminMenu();
				break;
			case 6:
				System.out.println("Exit Successfull!");
				System.exit(0);
			default:
				System.out.println("Please Select Valid Option!(1-6)");
				adminFunctionalities(admMenu);
				break;

			}
		case 4:
			home();
			break;
		case 5:
			System.out.println("Exit Successfull!");
			System.exit(0);

		default:
			new InvalidOptionException("Please Select Valid Option!(1-5)");
			adminFunctionalities(admMenu);
			break;
		}

	}

	//HOME MENU FOR EDUCATOR
	public static void educatorHome(Educator e) throws InvalidOptionException, UserNameException, SQLException {
		System.out.println("1.Courses");
		System.out.println("2.Logout");
		System.out.println("3.Exit");

		int choice = 0;
		try {
			choice = Integer.parseInt(sc.next());
		} catch (NumberFormatException nf) {
			System.out.println("Only Numbers are allowed!");
			educatorHome(e);
		}

		switch (choice) {
		case 1:
			e.chooseCourse();
			break;
		case 2:
			System.out.println("Successfully Logged Out!!");
			home();
		case 3:
			System.out.println("Exit Successfull!!!");
			System.exit(0);
			default:
				System.out.println("Please enter valid Option(1-3)");
				educatorHome(e);
		}

	}
	
	//EDUCATOR SUB MENU

	public static void educatorMenu(int cid, Educator e)
			throws SQLException, InvalidOptionException, UserNameException {

		System.out.println("----------------------EDUCATOR MENU--------------------------------");
		System.out.println("1.Assessment Management");
		System.out.println("2.Question Management");
		System.out.println("3.Logout");
		System.out.println("4.Exit");
		int eduChoice = 0;
		try {
			eduChoice = Integer.parseInt(sc.next());
		} catch (NumberFormatException nf) {
			System.out.println("Only Numbers are allowed!");
			educatorMenu(cid, e);
		}

		if (eduChoice == 1 || eduChoice == 2) {
			educatorFunctionalities(cid, eduChoice, e);
		}
		if (eduChoice == 3) {
			System.out.println("Successfully Logged Out!");
			home();
		}
		if (eduChoice == 4) {
			System.out.println("Exit Successfull!");
			System.exit(0);
		}

		else {
			System.out.println("Please Select Valid Option!(1-4)");
			educatorMenu(cid, e);
		}
	}

	// Educator Functionalities

	public static void educatorFunctionalities(int cid, int eduChoice, Educator e)
			throws SQLException, InvalidOptionException, UserNameException {
		switch (eduChoice) {

		case 1:

			System.out.println("1.Add Assessment");
			System.out.println("2.Remove Assessment");
			System.out.println("3.Edit Assessment");
			System.out.println("4.Search By Assessment ID");
			System.out.println("5.View All Assessments");
			System.out.println("6.Back");
			System.out.println("7.Logout");
			System.out.println("8.Exit");
			int eduOpt1 = 0;
			try {
				eduOpt1 = Integer.parseInt(sc.next());
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				educatorFunctionalities(cid, eduChoice, e);
			}

			switch (eduOpt1) {

			case 1:
				e.addAssessment(cid);
				break;
			case 2:
				e.removeAssessment(cid);
				break;
			case 3:
				e.editAssessment(cid);
				break;
			case 4:

				int aId = 0;
				
				    try {
						System.out.println("Enter Assessment ID");
						aId = Integer.parseInt(sc.next());
						//break;
					} catch (NumberFormatException nf) {
						System.out.println("Only Numbers are allowed!");
						educatorFunctionalities(cid, eduChoice, e);
					}
//				System.out.println(aId);
				e.viewAssessmentById(aId, cid);
				break;
			case 5:
				e.viewAssessment(cid);
				break;
			case 6:
				educatorMenu(cid, e);
				break;
			case 7:
				System.out.println("Successfully Logged Out!");
				home();
				break;
			case 8:
				System.out.println("Exit Successfull!");
				System.exit(0);
				break;
			default:
				System.out.println("Please Select a Valid Option!(1-8)");
				educatorFunctionalities(cid, eduChoice, e);

			}
			break;
		case 2:
			System.out.println("1.Add Question to Question Bank");
			System.out.println("2.Add/Assign Questions to Assessment");
			System.out.println("3.Remove Question");
			System.out.println("4.Edit Question");
			System.out.println("5.View Question Bank");
			System.out.println("6.View Assignment Questions");
			System.out.println("7.View Student Performance");
			System.out.println("8.Back");
			System.out.println("9.Logout");
			System.out.println("10.Exit");
			int eduOpt2 = 0;
			try {
				eduOpt2 = Integer.parseInt(sc.next());
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				educatorFunctionalities(cid, eduChoice, e);
			}

			switch (eduOpt2) {

			case 1:
				e.addQuestion(cid);
				break;
			case 2:
				int aId = 0;
				while (true) {
					System.out.println("Enter Assessment ID");
					try {
						aId = Integer.parseInt(sc.next());
						break;
					} catch (NumberFormatException nf) {
						System.out.println("Only Numbers are allowed!");
						// educatorFunctionalities(eduChoice, e);
					}
				}
				Assessment a = VerifyData.checkAssessment(aId, cid);
				if (a != null) {
					e.assignQuestion(a, cid);
				} else {
					System.out.println("No such Assessment was Found!");
					educatorFunctionalities(cid, eduChoice, e);
				}

			case 3:
				e.removeQuestion(cid);
				break;
			case 4:
				e.editQuestions(cid);
				break;
			case 5:
				e.viewQuestions(cid);
				break;
			case 6:
				System.out.println("Enter Assessment ID");
				int assessId = 0;
				try {
					assessId = Integer.parseInt(sc.next());
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
					educatorFunctionalities(cid, eduChoice, e);
				}
				Assessment assessObj = VerifyData.checkAssessment(assessId, cid);
				if (assessObj != null) {
					e.viewAssessmentQuestions(assessObj, cid);
				} else {
					System.out.println("No Such Assessment was Found!");
					educatorFunctionalities(cid, eduChoice, e);
				}
				break;
			case 7:
				e.viewPerformance(cid);
				break;
			case 8:
				educatorMenu(cid, e);
				break;
			case 9:
				System.out.println("Successfully Logged Out!");
				home();
				break;
			case 10:
				System.out.println("Exit Successfull");

				System.exit(0);
			default:
				System.out.println("Please select valid Option(1-10)");
				educatorFunctionalities(cid, eduChoice, e);
				break;

			}
		}
	}

	// Student Functionalities

//	public static void studentFunctionalities(Student s)
//			throws InvalidOptionException, SQLException, UserNameException {
//		System.out.println("-----------------------------------------------------");
//		System.out.println("----------------------ASSESSMENT TOOL------------------------------");
//		System.out.println("1.View Assessments");
//		System.out.println("2.Take Assessment");
//		System.out.println("3.View Marks");
//		System.out.println("4.Logout");
//		System.out.println("5.Exit");
//
//		int stuOpt = 0;
//		try {
//			stuOpt = Integer.parseInt(sc.next());
//		} catch (NumberFormatException nf) {
//			System.out.println("Only Numbers are allowed!");
//			studentFunctionalities(s);
//		}
//
//		switch (stuOpt) {
//		case 1:
//			System.out.println("--------------------------------Available Assessments------------------------------");
//			Student.showAssessmentDetails(s);
//			break;
//		case 2:
//
//			int aId = 0;
//			while (true) {
//				try {
//					System.out.println("Enter Assessment ID");
//					aId = Integer.parseInt(sc.next());
//					break;
//				} catch (NumberFormatException nf) {
//					System.out.println("Only Numbers are allowed!");
//				}
//			}
//			Assessment a = Educator.checkAssessment(aId);
//			if (a != null) {
//				Student.takeAssessment(a, s);
//			} else {
//				System.out.println("No such Assessment were Found!");
//				studentFunctionalities(s);
//				break;
//			}
//			break;
//		case 3:
//			// System.out.println("Enter Assessment ID");
//			int assessId = 0;
//			while (true) {
//				try {
//					System.out.println("Enter Assessment ID");
//					assessId = Integer.parseInt(sc.next());
//					break;
//				} catch (NumberFormatException nf) {
//					System.out.println("Only Numbers are allowed!");
////					studentFunctionalities(s);
//				}
//			}
//			Assessment aObj = Educator.checkAssessment(assessId);
//			if (aObj != null) {
//				Student.ViewMarks(s, aObj);
//				break;
//			} else {
//				System.out.println("No such Assessments were Found!");
//				App.studentFunctionalities(s);
//			}
//			break;
//		case 4:
//			System.out.println("Successfully Logged Out!");
//			home();
//			break;
//		case 5:
//			System.out.println("Exit Successfull");
//			System.exit(0);
//		default:
//			System.out.println("Please Select valid Option)(0-5)");
//			studentFunctionalities(s);
//		}
//	}

	//STUDENT MAIN MENU
	public static void studentMenu(Student s) throws InvalidOptionException, SQLException, UserNameException {

		String reset = "\u001B[0m";
		String cyan = "\u001B[36m";
		String yellow = "\u001B[33m";
		String green = "\u001B[32m";

		System.out.println(yellow + "-------------------------------------------------------------------" + reset);
		System.out.println(cyan + "                          ASSESSMENT TOOL                           " + reset);
		System.out.println(yellow + "-------------------------------------------------------------------" + reset);
		System.out.println(green + "1. Courses" + reset);
		System.out.println(green + "2. Logout" + reset);
		System.out.println(green + "3. Exit" + reset);
		System.out.println(yellow + "-------------------------------------------------------------------" + reset);

		int stuOpt = 0;
		while (true) {
			try {
				stuOpt = Integer.parseInt(sc.next());
				break;
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				studentMenu(s);
			}
		}
		studentFunctionalities(stuOpt, s);
	}

	//STUDENT SUB MENU(AFTER COURSE SELECTION)
	public static void studentFunctionalities(int stuOpt, Student s)
			throws InvalidOptionException, SQLException, UserNameException {

		switch (stuOpt) {

		case 1:
			int courseID = 0;
			List<Course> courses = s.courseDetails(s);
			boolean flag = true;
			while (flag) {

				if (courses != null && !courses.isEmpty()) {
					// Print box header
					System.out.println("---------------------AVAILABLE COURSES--------------------");
					System.out.println("╔═══════════════╦════════════════════════════════════════╗");
					System.out.println("║   Course ID   ║             Course Name                ║");
					System.out.println("╠═══════════════╬════════════════════════════════════════╣");

					// Print each course
					courses.stream().forEach(course -> System.out.println(formatCourse(course)));

					// Print box footer
					System.out.println("╚═══════════════╩════════════════════════════════════════╝");
				} else {
					System.out.println("No Course Found!!!");
					studentMenu(s);
					break;
				}

				// System.out.println("Please Select a Course ID:");

				while (true) {
					try {
						System.out.println("Select a Course ID to continue:");
						courseID = Integer.parseInt(sc.next());
						break;
					} catch (NumberFormatException nf) {
						System.out.println("Only Numbers are allowed!");
						continue;
					}
				}

				if (VerifyData.validateCourse(courseID) != null) {

					assessmentMenu(s, courseID);
					break;
				} else {
					System.out.println("Course ID doesn't exist!");

					int c = 0;
					while (true) {
						try {
							System.out.println("Do you want to continue?");
							System.out.println("1.Continue");
							System.out.println("2.Back");
							c = Integer.parseInt(sc.next());
							if (c != 1 && c != 2) {
								System.out.println("Please select a valid Option!");
								continue;
							}
							break;
						} catch (NumberFormatException nf) {
							System.out.println("Only Numbers are allowed!");

						}
					}
					if (c == 2) {
						studentMenu(s);
						break;

					}

				}

			}
			break;
		case 2:
			System.out.println("Successfully Logged Out!!!");
			home();
			break;
		case 3:
			System.out.println("Exit Successfull!!!");
			System.exit(0);
		default:
			System.out.println("Please Select valid Option)(1-3)");
			studentMenu(s);
		}
	}

	//ASSESSMENT SUB MENU
	public static void assessmentMenu(Student s, int cId)
			throws InvalidOptionException, UserNameException, SQLException {

		System.out.println("1.Pending Assessments");
		System.out.println("2.Completed Assessments");
		System.out.println("3.Back");

		int opt = 0;
		while (true) {
			try {
				System.out.println("Enter Your Choice:");
				opt = Integer.parseInt(sc.next());
				break;
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
				continue;
			}
		}
		switch (opt) {

		case 1:
			s.listPendingAssessments(cId, s);
			break;

		case 2:
			s.listCompletedAssessments(cId, s);
			break;

		case 3:
			studentMenu(s);
			break;
		default:
			System.out.println("Please select a valid Option(1-3");
			assessmentMenu(s, cId);
			break;

//	        else {
//	        	System.out.println("Course ID doesn't Exist!");
//	        	break;
//	        }
		}
	}

	private static String formatCourse(Course course) {
		return String.format("║ %-13d ║ %-38s ║", course.getcId(), course.getcName());
	}

}
