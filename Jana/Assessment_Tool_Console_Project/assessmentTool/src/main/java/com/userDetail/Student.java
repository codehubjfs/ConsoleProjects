package com.userDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.courseDetail.Assessment;
import com.courseDetail.Course;
import com.courseDetail.Question;
import com.courseDetail.VerifyData;
//import com.exceptionDetails.EmailException;
import com.exceptionDetails.InvalidOptionException;
import com.exceptionDetails.UserNameException;
import com.exceptionDetails.Validate;
import com.smartcliff.assessmentTool.App;
import com.smartcliff.assessmentTool.DbmsConnection;

public class Student {

	private String email;
	private String password;
	private int sid;
	private String sfirstName;
	private String slastName;
	private String dob;
	private String sGender;
	private String sCity;
	private String sCountry;
	private int courseId;
	List<Course> registeredCourses = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public Student(int sid, String email, String password, String sfirstName, String slastName, String sGender,
			String sCity, String sCountry) {
		super();
		this.email = email;
		this.password = password;
		this.sfirstName = sfirstName;
		this.slastName = slastName;
		this.sGender = sGender;
		this.sCity = sCity;
		this.sCountry = sCountry;
		// this.courseId = courseId;
		this.sid = sid;
	}

	public Student(String email, String password, String sfirstName, String slastName, String sGender, String sCity,
			String sCountry) {
		this.email = email;
		this.password = password;
		this.sfirstName = sfirstName;
		this.slastName = slastName;
		this.sGender = sGender;
		this.sCity = sCity;
		this.sCountry = sCountry;
	}

	// TO LIST QUESTIONS AND GET ANSWERS FROM STUDENT

	public static void takeAssessment(Assessment a, Student s, int cId)
			throws InvalidOptionException, SQLException, UserNameException {

		String checkQuery = "SELECT * FROM studentmark WHERE aid=? AND sid=?";

		try (Connection connection = DbmsConnection.getConnection();
				PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {

			checkStmt.setInt(1, a.getaId());
			checkStmt.setInt(2, s.getSid());
			ResultSet rs1 = checkStmt.executeQuery();

			if (rs1.next()) {
				System.out.println("Assessment already taken!");
				App.studentMenu(s);
				return;
			}

			String sql1 = "SELECT * FROM question q join questionassessment a on q.qid=a.qid WHERE aid=? ORDER BY q.qid";
			try (PreparedStatement stmt = connection.prepareStatement(sql1)) {
				stmt.setInt(1, a.getaId());
				ResultSet rs = stmt.executeQuery();

				List<Question> questions = new ArrayList<>();
				while (rs.next()) {
					int qid = rs.getInt("qid");
					String questionText = rs.getString("questions");
					String optionA = rs.getString("c1");
					String optionB = rs.getString("c2");
					String optionC = rs.getString("c3");
					String optionD = rs.getString("c4");
					int mark = rs.getInt("mark");

					questions.add(new Question(qid, questionText, optionA, optionB, optionC, optionD, mark));
				}

				final String RESET = "\033[0m";
//		        final String BLACK_BOLD = "\033[1;30m";  // BLACK
//		        final String RED_BOLD = "\033[1;31m";    // RED
				final String GREEN_BOLD = "\033[1;32m"; // GREEN
				final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
				final String BLUE_BOLD = "\033[1;34m"; // BLUE
				final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
				final String CYAN_BOLD = "\033[1;36m"; // CYAN
//		        final String WHITE_BOLD = "\033[1;37m";  // WHITE

				System.out.println(CYAN_BOLD + "=========================================================" + RESET);
				System.out.println(BLUE_BOLD + "|                      QUESTION DETAILS                 |" + RESET);
				System.out.println(CYAN_BOLD + "=========================================================" + RESET);
				for (Question question : questions) {

					System.out.println(YELLOW_BOLD + "Question ID: " + RESET + question.getqId());
					System.out.println(YELLOW_BOLD + "Question   : " + RESET + question.getQuestion());
					System.out.println(YELLOW_BOLD + "Options:" + RESET);
					System.out.println(GREEN_BOLD + "  A. " + RESET + question.getChoice1());
					System.out.println(GREEN_BOLD + "  B. " + RESET + question.getChoice2());
					System.out.println(GREEN_BOLD + "  C. " + RESET + question.getChoice3());
					System.out.println(GREEN_BOLD + "  D. " + RESET + question.getChoice4());
					System.out.println(YELLOW_BOLD + "Mark       : " + RESET + question.getMark());
					System.out.println(CYAN_BOLD + "=======================================================" + RESET);

					String answer = "";
					boolean flag = true;

					while (flag) {

						System.out.println(PURPLE_BOLD + "Please give your answer (A/B/C/D)" + RESET);
						answer = sc.next().toUpperCase();
						try {
							Validate.validateAnswer(answer);
							flag = false;
						} catch (InvalidOptionException e) {

							System.out.println(e.getMessage());

						}
					}

					String insertAnswerSql = "INSERT INTO StudentAnswer (ansid, sid, qid, studanswer,aid) VALUES (ansseq.nextval, ?, ?, ?, ?)";
					try (PreparedStatement insertAnswerStmt = connection.prepareStatement(insertAnswerSql)) {
						insertAnswerStmt.setInt(1, s.getSid());
						insertAnswerStmt.setInt(2, question.getqId());
						insertAnswerStmt.setString(3, answer);
						insertAnswerStmt.setInt(4, a.getaId());
						int rows = insertAnswerStmt.executeUpdate();
						if (rows == 1) {
							System.out.println("Answer saved!");
						}
					}
				}

				calculateAndStoreTotalMarks(s.getSid(), a.getaId());
//				App.studentMenu(s);
				s.assessment(cId);
			}
		}
	}


	// TO CALCULATE AND STORE MARKS

	public static void calculateAndStoreTotalMarks(int studentId, int assessmentId) throws SQLException {

		String retrieveQuestionsQuery = "SELECT * FROM question q join questionassessment a on q.qid=a.qid WHERE a.aid=? order by q.qid";

		String retrieveStudentAnswersQuery = "SELECT QID, studAnswer " + "FROM StudentAnswer " + "WHERE SID = ? "
				+ "AND QID IN ( " + "    SELECT q.QID " + "    FROM Question q "
				+ "    JOIN questionassessment a ON q.QID = a.QID " + "    WHERE a.AID = ? " + ") " + "ORDER BY QID";

		int totalMarks = calculateTotalMarks(retrieveQuestionsQuery, retrieveStudentAnswersQuery, studentId,
				assessmentId);

		storeTotalMarks(studentId, assessmentId, totalMarks);
	}

	// TO CALCULATE TOTAL MARKS

	private static int calculateTotalMarks(String retrieveQuestionsQuery, String retrieveStudentAnswersQuery,
			int studentId, int assessmentId) {
		int totalMarks = 0;

		try (Connection connection = DbmsConnection.getConnection();
				PreparedStatement retrieveQuestionsStmt = connection.prepareStatement(retrieveQuestionsQuery);
				PreparedStatement retrieveStudentAnswersStmt = connection
						.prepareStatement(retrieveStudentAnswersQuery)) {

			retrieveQuestionsStmt.setInt(1, assessmentId);

			ResultSet questionsResult = retrieveQuestionsStmt.executeQuery();

			retrieveStudentAnswersStmt.setInt(1, studentId);
			retrieveStudentAnswersStmt.setInt(2, assessmentId);

			ResultSet studentAnswersResult = retrieveStudentAnswersStmt.executeQuery();

			while (questionsResult.next() && studentAnswersResult.next()) {
				String correctAnswer = questionsResult.getString("Answer");
				String studentAnswer = studentAnswersResult.getString("studAnswer");
				System.out.println();
				if (correctAnswer != null && correctAnswer.equals(studentAnswer)) {
					totalMarks += questionsResult.getInt("Mark");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalMarks;
	}

	// TO STORE TOTAL MARKS

	public static void storeTotalMarks(int studentId, int assessmentId, int totalMarks) throws SQLException {

		String insertMarkQuery = "INSERT INTO Studentmark (sid, aid, tot_mark) VALUES (?, ?, ?)";

		PreparedStatement insertMarkStmt = DbmsConnection.getConnection().prepareStatement(insertMarkQuery);
		insertMarkStmt.setInt(1, studentId);
		insertMarkStmt.setInt(2, assessmentId);
		insertMarkStmt.setInt(3, totalMarks);

		int rows = insertMarkStmt.executeUpdate();
		if (rows == 1) {
			System.out.println("Marks Evaluated!");
		}

	}

	// LIST MARKS TO STUDENTS

	public static void viewMarks(Student s,int aid) throws InvalidOptionException, UserNameException {
		try {

			String sql1 = "select * from studentmark where sid=? and aid=?";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
//			stmt.setInt(1, a.getaId());
			stmt.setInt(1, s.getSid());
			stmt.setInt(2, aid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				System.out.println("Assessment ID  :" + rs.getInt("aid"));
				System.out.println("Total Marks    :" + rs.getString("tot_mark"));
				System.out.println(
						"|---------------------------------------------------------------------------------------------------------------------------------------------------|");
			}
//			int rows = stmt.executeUpdate();
//			if (rows == 0) {
//				System.out.println("Assessment Not yet Taken!");
//			}
			App.studentMenu(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// TO LIST COURSE DETAILS IN WHICH THE PARTICULAR STUDENT HAVE ENROLLED

	public List<Course> courseDetails(Student s) throws InvalidOptionException, UserNameException {

		try {
			String sql1 = "select c.cid,c.cname from course c join studentcourse s on c.cid=s.cid where s.sid=?";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			// System.out.println(s.getSid());
			stmt.setInt(1, s.getSid());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int cId = rs.getInt("cid");
				String cName = rs.getString("cname");
				Course newCourse = new Course(cId, cName);

				// Check if the course is already in the list
				boolean courseExists = false;
				for (Course course : registeredCourses) {
					if (course.getcId() == cId) {
						courseExists = true;
						break;
					}
				}

				// Add the course only if it does not exist
				if (!courseExists) {
					registeredCourses.add(newCourse);
				}
			}
			return registeredCourses;

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public String getSfirstName() {
		return sfirstName;
	}

	public void setSfirstName(String sfirstName) {
		this.sfirstName = sfirstName;
	}

	public String getSlastName() {
		return slastName;
	}

	public void setSlastName(String slastName) {
		this.slastName = slastName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	public String getsCountry() {
		return sCountry;
	}

	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}

	// METHOD TO PRINT EDUCATOR/STUDENT DETAILS IN TABLE FORMAT

	public String toString() {
		String format = "| %-10s | %-15s | %-15s | %-30s | %-15s | %-10s | %-15s | %-15s |\n";
		String lineSeparator = "+------------+-----------------+-----------------+--------------------------------+-----------------+------------+-----------------+-----------------+";

		StringBuilder sb = new StringBuilder();
		sb.append(String.format(format, sid, sfirstName, slastName, email, password, sGender, sCity, sCountry));
		sb.append(lineSeparator);

		return sb.toString();
	}

	// LIST ASSESSMENT DETAILS

	public static void showAssessmentDetails(Student s) throws InvalidOptionException, UserNameException {
		try {
			String sql1 = "select * from assessment";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				System.out.println("Assessment ID  :" + rs.getInt("aid"));
				System.out.println("Assessment Name:" + rs.getString("aname"));
				System.out.println("Start Time     :" + rs.getString("sttime"));
				System.out.println("EndTime        :" + rs.getString("endtime"));
				System.out.println("Duration       :" + rs.getString("duration"));
				System.out.println("Tot_mark       :" + rs.getString("Tot_mark"));
				System.out.println("CID            :" + rs.getString("cid"));
				System.out.println("Adate          :" + rs.getString("adate"));
				System.out.println(
						"|---------------------------------------------------------------------------------------------------------------------------------------------------|");
			}
			int rows = stmt.executeUpdate();
			if (rows == 0) {
				System.out.println("No Assessments were Posted!");
				App.studentMenu(s);
			}
			System.out.println(rows + "Records found!");
			App.studentMenu(s);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// TO LIST PENDING ASSESSMENTS

	public void listPendingAssessments(int cId, Student s) throws InvalidOptionException, UserNameException {

		try {
			String sql1 = "SELECT * FROM assessment WHERE cid = ? AND aid NOT IN (SELECT aid FROM studentmark WHERE sid = ?)";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			stmt.setInt(1, cId);
			stmt.setInt(2, s.getSid());

			ResultSet rs = stmt.executeQuery();
			System.out.println(
					"|-----------------------------------------------PENDING ASSESSMENTS------------------------------------------------------------------------------------|");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s | %-30s | %-20s | %-20s | %-10s | %-10s | %-5s | %-19s |\n", "Assessment ID",
					"Assessment Name", "Start Time", "End Time", "Duration", "Total Marks", "CID", "Assessment Date");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------|");

			while (rs.next()) {
				System.out.printf("| %-15d | %-30s | %-20s | %-20s | %-10s | %-10s | %-5s | %-19s |\n",
						rs.getInt("aid"), rs.getString("aname"), rs.getString("sttime"), rs.getString("endtime"),
						rs.getString("duration"), rs.getString("Tot_mark"), rs.getString("cid"), rs.getString("adate"));
			}

			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------|");

			int rows = stmt.executeUpdate();
			if (rows == 0) {
				System.out.println("No Assessments were Pending!");
				App.studentMenu(this);
			}
			assessment(cId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ASSESSMENT MENU(WHETHER TO TAKE OR GO BACK)

	public void assessment(int cId) throws InvalidOptionException, SQLException, UserNameException {

		System.out.println("1.Take Assessment");
		System.out.println("2.Back");
		int choice = 0;
		while (true) {

			try {
				System.out.println("Enter Your Choice:");
				choice = Integer.parseInt(sc.next());
				if (choice != 1 && choice != 2) {
					System.out.println("Please select a valid Option(1-2)");
					continue;
				}
				break;
			} catch (NumberFormatException nf) {
				System.out.println("Only Numbers are allowed!");
			}
		}
		switch (choice) {

		case 1:
			int aID = 0;
			while (true) {
				try {
					System.out.println("Enter Assessment ID");
					aID = Integer.parseInt(sc.next());
					break;
				} catch (NumberFormatException nf) {
					System.out.println("Only Numbers are allowed!");
				}
			}
			Assessment aObj = VerifyData.checkAssessment(aID, cId);
			if (aObj != null) {
				if (showGuidelines()) {
					takeAssessment(aObj, this, cId);
					break;
				} else {
					assessment(cId);
					break;
				}
			} else {
				System.out.println("Assessment ID doen't exist!");
				assessment(cId);
			}

		case 2:
			App.assessmentMenu(this, cId);

		}
	}

	// TO SHOW GUIDELINES BEFORE ATTENDING ASSESSMENT

	private boolean showGuidelines() {
		System.out.println("==================================================================================");
		System.out.println("                           TEST GUIDELINES                        ");
		System.out.println("==================================================================================");
		System.out.println("1. You must use a functioning webcam and microphone");
		System.out.println("2. No cell phones or other secondary devices in the room or test area");
		System.out.println("3. Your desk/table must be clear of any materials except your test-taking device");
		System.out.println("4. No one else can be in the room with you");
		System.out.println("5. No talking");
		System.out.println("6. The testing room must be well-lit and you must be clearly visible");
		System.out.println("7. No dual screens/monitors");
		System.out.println("8. Do not leave the camera");
		System.out.println("9. No use of additional applications or internet");
		System.out.println("==================================================================================");
		System.out.println("Do you Agree to the Test Guidelines?");

		System.out.println("1. Confirm");
		System.out.println("2. Cancel");

		int confirm = 0;

		while (true) {
			try {
				System.out.print("Enter Your Choice: ");
				confirm = Integer.parseInt(sc.next());
				if (confirm != 1 && confirm != 2) {
					System.out.println("Please enter a valid option! (1-2)");
					continue;
				}
				break;
			} catch (NumberFormatException nf) {
				System.out.println("Only numbers are allowed!");
			}
		}

		return confirm == 1;
	}

	// TO LIST THE COMPLETED ASSESSMENTS

	public void listCompletedAssessments(int cId, Student s) throws InvalidOptionException, UserNameException {
		try {
			String sql1 = "SELECT * FROM assessment WHERE cid = ? AND aid IN (SELECT aid FROM studentmark WHERE sid = ?)";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			stmt.setInt(1, cId);
			stmt.setInt(2, s.getSid());

			ResultSet rs = stmt.executeQuery();
			System.out.println(
					"|-----------------------------------------------COMPLETED ASSESSMENTS------------------------------------------------------------------------------------|");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s | %-30s | %-20s | %-20s | %-10s | %-10s | %-5s | %-19s |\n", "Assessment ID",
					"Assessment Name", "Start Time", "End Time", "Duration", "Total Marks", "CID", "Assessment Date");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------|");

			while (rs.next()) {
				System.out.printf("| %-15d | %-30s | %-20s | %-20s | %-10s | %-10s | %-5s | %-19s |\n",
						rs.getInt("aid"), rs.getString("aname"), rs.getString("sttime"), rs.getString("endtime"),
						rs.getString("duration"), rs.getString("Tot_mark"), rs.getString("cid"), rs.getString("adate"));
			}

			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------|");

			int rows = stmt.executeUpdate();
			if (rows == 0) {
				System.out.println("No Assessments were Completed!");
				App.assessmentMenu(this,cId);
			} else {
				System.out.println("1.View Marks");
				System.out.println("2.Back");

				int m = 0;
				while (true) {
					try {
						System.out.println("Enter Your Choice:");
						m = Integer.parseInt(sc.next());
						if (m != 1 && m != 2) {
							System.out.println("Please Enter a valid Option!(1-2)");
							continue;
						}
						break;
					} catch (NumberFormatException nf) {
						System.out.println("Only Numbers are allowed!");
					}
				}

				if (m == 1) {
					System.out.println("Enter Assessment ID:");
					int aid = sc.nextInt();
					viewMarks(s,aid);
				} else if (m == 2) {
					App.assessmentMenu(this, cId);
				}

			}
			App.assessmentMenu(this, cId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
