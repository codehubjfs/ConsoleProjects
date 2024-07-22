package com.users;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.courses.Answer;
import com.courses.Assessment;
import com.courses.Content;
import com.courses.Courses;
import com.courses.Module;
import com.courses.Question;
import com.courses.Topic;
import com.courses.DbConnection;
import com.courses.Files;
import com.exceptions.ContainsNumberException;
import com.exceptions.ExceptionHandler;
import com.exceptions.exceptionHandlers;
import com.exceptions.InvalidDateException;
import com.exceptions.InvalidFileException;
import com.exceptions.IsNumberException;
import com.exceptions.LengthException;
import com.exceptions.NotIntegerException;
import com.exceptions.SpecialCharacterException;
import com.users.DBConnection;
public class Admin {
	Scanner sc=new Scanner(System.in);
	private String username;
	private String password;
	private String name;
	private String email;
	public Admin()
	{
		
	}
	public Admin(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + "]";
	}
	public static void adminChoices(Statement st) throws SQLException, ClassNotFoundException, NotIntegerException, IOException, SpecialCharacterException
	{
		Admin admin=new Admin();
		Scanner sc=new Scanner(System.in);
		int flg=0;
		while(true)
		{
		System.out.println("Enter\n1.Course Management\n2.Create User\n3.Module Management\n4.Topic Management\n5.Assessment Management\n6.Question Management\n7.View Details\n8.Content Management\n9.View Users\n11.Log Out");
		int choice3=0;
		while(true)
		{
			try
			{
		choice3=Integer.parseInt(sc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid choice");
				continue;
			}
			break;
		}
		switch(choice3)
		{
		case 1:
		{
			System.out.println("Instructor Table");
			ArrayList<Instructor>instructorList=admin.viewInstructors(st);
			int choices4=0;
			while(true)
			{
				try
				{
					System.out.println("Enter\n1.add course\n2.Rename course\n3.delete course\n4.Edit Start Date\n5.Edit End Date\n6.Back");
					choices4=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
		switch(choices4)
		{
		case 1:
		{
			System.out.println("Courses Table");
			ArrayList<Courses>courseList=admin.viewCourse(st);
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			Scanner f=new Scanner(System.in);
			//String courseName="";
			int instructorId=0;
			
			String courseName="";
			while(true)
			{
				try
				{
					System.out.println("Enter Course Name");
					courseName=bf.readLine();
					ExceptionHandler.containsSpecialCharacters(courseName);
					ExceptionHandler.isLengthEnough(courseName);
					ExceptionHandler.isNumber(courseName);
					ExceptionHandler.containsNumber(courseName);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(LengthException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(ContainsNumberException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(IsNumberException e)
				{
					System.out.println(e.getMessage());
					System.out.println("Do Not Enter Number");
					continue;
				}
				break;
			}
			//
			boolean flag=true;
			while(true)
			{
				int insId=0;
			try
			{
			System.out.println("Enter InstructorId");
			insId=Integer.parseInt(f.next());
			}
			catch(Exception e)
			{
				System.out.println("\nEnter valid Number");
				continue;
			}
			int ctr=0;
			for(Instructor i:instructorList)
			{
				if(i.getId()==insId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Instructor id not found");
				continue;
			}
			instructorId=insId;
			//f.close();
			break;
			}
			//LocalDate startDate=LocalDate.of(2002, 12,11);
			flag=true;
			//while(flag)
			//{
			//try
			//{
			LocalDate startDate=null;
			while(true)
			{
				//System.out.println("Enter year,month and day");
				DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY-MM-dd");
				try
				{
					System.out.print("Enter Start date (yyyy-mm-dd): ");
			        String dateString = sc.next();

			        // Define the formatter for the input and output date format
			        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			        try {
			            // Parse the input date string into a LocalDate object
			            LocalDate inputDate = LocalDate.parse(dateString, inputFormatter);

			            // Format the LocalDate object into the desired output format
			            //String formattedDate = inputDate.format(outputFormatter);

			            // Output the formatted date
			            //System.out.println("Formatted Date: " + formattedDate);
			            startDate=inputDate;
			        } catch (Exception e) {
			            System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
			            continue;
			        } 
					/*while(true)
					{
						String start=sc.next();
						try
						{
					startDate=LocalDate.parse(start, formatter);
					ExceptionHandler.isDate(start);
						}
						catch(InvalidDateException e)
						{
							System.out.println(e.getMessage());
							continue;
						}
						catch(Exception e)
						{
							System.out.println("Enter Valid Date Format (YYYY-MM-dd)");
							continue;
						}
						break;
					}*/
					/*while(true)
					{
					System.out.println("Enter Day");
					day=Integer.parseInt(sc.next());
					if(day>31)
					{
					System.out.println("Do not Enter Day greater than 31");
					continue;
					}
					break;
					}
					while(true)
					{
					System.out.println("Enter Month");
					month=Integer.parseInt(sc.next());
					if(month>12)
					{
						System.out.println("Enter Month lesser than or equal to 12");
						continue;
					}
					break;
					}
					System.out.println("Enter Year in 4 Charcter length eg.2024 (YYYY)");
					year=Integer.parseInt(sc.next());
					/*while(true)
					{
					System.out.println("Enter Year in 4 Charcter length eg.2024 (YYYY)");
					year=Integer.parseInt(sc.next());
					/*try
					{
					ExceptionHandler.isLengthEnough(year+"");
					}
					catch(LengthException e)
					{
						System.out.println(e.getMessage());
						continue;
					}*/
					//break;
					//}*/
			//ExceptionHandler.isDate(startDate.toString());
			if(startDate.isBefore(LocalDate.now()))
			{
				//throw new Exception("Do Not Enter Past Date");
				ExceptionHandler.isDateAfterStartDate(startDate,LocalDate.now().toString());
				System.out.println("Start Date should be greater than current date");
				continue;
			}
				}
				catch(InvalidDateException e)
				{
					System.out.println("Enter valid Date Format (YYYY-MM-dd)");
					continue;
				}
				catch(Exception e)
				{
					//System.out.println(e.getMessage());
					System.out.println("Enter valid Date Format (YYYY-MM-dd)");
					//System.out.println("Enter Valid Number");
					continue;
				}
				break;
			}
			//startDate=sDate;
			//}
			//catch(Exception e)
			//{
				//System.out.println(e.getMessage());
				//continue;
			//}
			//flag=false;
			//}
			//flag=true;
			
			/*System.out.println("End Date");
			int day2=0;
			int month2=0;
			int year2=0;
			System.out.println("Enter day");
			day2=Integer.parseInt(sc.next());
			System.out.println("Enter Month");
			month2=Integer.parseInt(sc.next());
			System.out.println("Enter Year");
			year2=Integer.parseInt(sc.next());*/
			LocalDate endDate=null;
			while(true)
			{
				System.out.print("Enter End date (yyyy-mm-dd): ");
		        String dateString = sc.next();

		        // Define the formatter for the input and output date format
		        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		        try {
		            // Parse the input date string into a LocalDate object
		            LocalDate inputDate = LocalDate.parse(dateString, inputFormatter);

		            // Format the LocalDate object into the desired output format
		            //String formattedDate = inputDate.format(outputFormatter);

		            // Output the formatted date
		            //System.out.println("Formatted Date: " + formattedDate);
		            if(inputDate.isBefore(startDate))
		            {
		            	System.out.println("End date should be lesser than start date");
		            	continue;
		            }
		            endDate=inputDate;
		        } catch (Exception e) {
		            System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
		            continue;
		        } 
				/*try {
					System.out.println("Enter EndDate");
			endDate=LocalDate.of(year2,month2,day2);
			//exceptionHandler.isDate(endDate.toString());
			ExceptionHandler.isDate(endDate.toString());
			if(!startDate.isBefore(endDate))
			{
				throw new InvalidDateException("Start Date Before ");
			}
				}
				catch(InvalidDateException e)
				{
					System.out.println("Enter valid number");
					continue;
				}*/
				break;
			}
			Courses courses=new Courses(courseName,instructorId,startDate,endDate);
			admin.addCourse(courses,st);
		    admin.viewCourse(st);
			break;
		}
		case 2:
		{
			ArrayList<Courses>courseList=admin.viewCourse(st);
			Scanner fc=new Scanner(System.in);
			boolean flag=true;
			String name="";
			while(flag)
			{
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			String cname="";
			while(true)
			{
				System.out.println("\nEnter Name to rename");
		     cname=bf.readLine();
		     try
		     {
		    	 ExceptionHandler.isLengthEnough(cname);
		    	 ExceptionHandler.isNumber(cname);
		    	 ExceptionHandler.containsSpecialCharacters(cname);
		    	 ExceptionHandler.containsNumber(cname);
		     }
		     catch(ContainsNumberException e)
		     {
		    	 System.out.println(e.getMessage());
		    	 continue;
		     }
		     catch(LengthException e)
		     {
		    	 System.out.println(e.getMessage());
		    	 continue;
		     }
		     catch(SpecialCharacterException e)
		     {
		    	 System.out.println(e.getMessage());
		     }
		     catch(IsNumberException e)
		     {
		    	 System.out.println(e.getMessage());
		    	 continue;
		     }
		     catch(Exception e)
		     {
		    	 System.out.println("\nEnter Valid Course Name");
		    	 continue;
		     }
		     break;
			}
			if(exceptionHandlers.isString(cname))
			{
				name=cname;
				break;
			}
			}
			int id=0;
			while(true)
			{
				int id_=0;
			System.out.println("\nEnter Course id");
			try
			{
			 id_=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Courses course:courseList)
			 {
				 if(course.getCourseID()==id_)
				 {
					 ctr++;
				 }
			 }
			if(ctr==0)
			{
				System.out.println("Course Not Found");
				continue;
			}
			id=id_;
			break;
			}
			ResultSet rs=st.executeQuery("select * from courses where courseid="+id+"");
			Courses courses;
			while(rs.next())
			{
				LocalDate startDate=rs.getDate("startdate").toLocalDate();
				LocalDate endDate=rs.getDate("enddate").toLocalDate();
			courses=new Courses(id,name,rs.getInt("instructorid"),startDate,endDate);
			System.out.println(courses.getCourseName()+" "+courses.getInstructorid()+" "+courses.getEndDate()+" "+courses.getStartDate());
			admin.renameCourse(courses,st);
			admin.viewCourse(st);
			}
			break;
		}
		case 3:
		{
			ArrayList<Courses> courseList=admin.viewCourse(st);
			Scanner fc=new Scanner(System.in);
			System.out.println("Delete course");
			int courseID=0;
			Courses courses=new Courses();
			while(true)
			{
				System.out.println("Enter Course Id");
				try
				{
			courseID=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				int ctr=0;
				for(Courses course:courseList)
				{
					if(course.getCourseID()==courseID)
					{
						courses=course;
						ctr++;
					}
				}
				if(ctr==0)
				{
					System.out.println("Course Not found");
					continue;
				}
				break;
			}
			/*ResultSet rs=st.executeQuery("select * from courses where courseid="+courseID+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("CourseId not Found");
				adminChoices(st);
			}*/
			//Courses courses;
			//while(rs.next())
			//{
				LocalDate startDate=courses.getStartDate();//rs.getDate("startdate").toLocalDate();
				LocalDate endDate=courses.getEndDate();//rs.getDate("enddate").toLocalDate();
			//courses=new Courses(courseID,rs.getString("coursename"),rs.getInt("instructorid"),startDate,endDate);
			//System.out.println(courses.getCourseName()+" "+courses.getInstructorid()+" "+courses.getEndDate()+" "+courses.getStartDate());
			admin.deleteCourse(courses,st);
			admin.viewCourse(st);
			//}
			break;
		}
		case 4:
		{
			Courses courses=new Courses();
			ArrayList<Courses> courseList=admin.viewCourse(st);
			//courseList.replaceAll(admin.viewCourse(st));
			Scanner fc=new Scanner(System.in);
			System.out.println("Enter course Id");
			int courseID=0;
			while(true)
			{
				System.out.println("Enter course Id");
				try
				{
					courseID=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				int ctr=0;
				for(Courses c:courseList)
				{
					if(c.getCourseID()==courseID)
					{
						courses=c;
						ctr++;
					}
				}
				if(ctr==0)
				{
					System.out.println("Course Id not found");
					continue;
				}
				break;
			}
			LocalDate start=LocalDate.now();
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Enter Date (YYYY-MM-dd)");
				try
				{
				String startD=bf.readLine();
				DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
				//start=LocalDate.parse(startD).format(formatter);
				start=LocalDate.parse(startD,formatter);
				//System.out.println(start);
				if(start.isAfter(courses.getEndDate()))
				{
					System.out.println("Enter Date before End Date");
					continue;
				}
				}
				catch(DateTimeParseException e)
				{
					System.out.println("Enter valid Date (YYYY-MM-dd)");
					continue;
				}
				break;
			}
			
				courses=new Courses(courseID,courses.getCourseName(),courses.getInstructorid(),start,courses.getEndDate());
				System.out.println(courses.getCourseName()+" "+courses.getInstructorid()+" "+courses.getEndDate()+" "+courses.getStartDate());
				admin.editstart(courses, st);
				admin.viewCourse(st);
			//}
			break;
		}
		case 5:
		{
			ArrayList<Courses> courseList=admin.viewCourse(st);
			Courses courses=new Courses();
			Scanner fc=new Scanner(System.in);
			System.out.println("Enter Course Id\n");
			int courseId=0;
			while(true)
			{
				try
				{
			courseId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				int ctr=0;
				for(Courses c:courseList)
				{
					if(c.getCourseID()==courseId)
					{
						courses=c;
						ctr++;
					}
				}
				if(ctr==0)
				{
					System.out.println("Course not found");
					continue;
				}
				break;
			}
			LocalDate end=LocalDate.now();
			System.out.println("Edit end date\n");
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("Enter a date (yyyy-mm-dd): ");
		        String dateString = sc.next();

		        // Define the formatter for the input and output date format
		        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		        try {
		            // Parse the input date string into a LocalDate object
		            LocalDate inputDate = LocalDate.parse(dateString, inputFormatter);

		            // Format the LocalDate object into the desired output format
		            //String formattedDate = inputDate.format(outputFormatter);

		            // Output the formatted date
		            //System.out.println("Formatted Date: " + formattedDate);
		            if(courses.getStartDate().isAfter(inputDate))
		            {
		            	System.out.println("End date should be greater than start date ");
		            	continue;
		            }
		            end=inputDate;
		        } catch (Exception e) {
		            System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
		            continue;
		        } 
				break;
			}
			
			//Courses courses;
			//while(rs.next())
			//{
				//LocalDate startDate=rs.getDate("startdate").toLocalDate();
				courses=new Courses(courseId,courses.getCourseName(),courses.getInstructorid(),courses.getStartDate(),end);
				//System.out.println(courses.getCourseName()+" "+courses.getInstructorid()+" "+courses.getEndDate()+" "+courses.getStartDate());
				admin.editend(courses, st);
				admin.viewCourse(st);
			//}
			//Courses.editend(new Courses(),st);
			break;
		}
		case 6:
		{
			break;
		}
		default:
			System.out.println("Enter valid number");
			break;
		}
		break;
		}

		case 2:
		{
			createUser.createUser(st);
			
		 break;
		}
		case 3:
		{
		//System.out.println("Enter \n1.Add Module\n2.Edit Module\n3.Delete Module");
		System.out.println("Instructor Table");
		ArrayList<Instructor> courseList=admin.viewInstructors(st);
		System.out.println("Courses Table");
		ArrayList<Courses>courses=admin.viewCourse(st);
		int choice5=0;
		while(true)
		{
			System.out.println("Enter \n1.Add Module\n2.Edit Module\n3.Delete Module\n4.Back");
			try
			{
			choice5=Integer.parseInt(sc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			break;
		}
		switch(choice5)
		{
		case 1:
		{
			/*BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter details to create a module");
			Scanner fc=new Scanner(System.in);
			//String moduleName="";
			
			System.out.println("Enter Module Name");
			String moduleName="";
			while(true)
			{
				try
				{
			ExceptionHandler.containsSpecialCharacters(moduleName=bf.readLine());
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			int instructorid=0;
			while(true)
			{
				int insid=0;
			System.out.println("Enter Instructor Id");
			try
			{
			insid=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			instructorid=insid;
			break;
			}
			int courseid=0;
			while(true)
			{
			System.out.println("Enter Course Id");
			int cid=0;
			try
			{
			cid=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				e.getMessage();
				continue;
			}
			courseid=cid;
			break;
			}
			Module module=new Module(moduleName,instructorid,courseid);*/
			admin.addModule(st);
			admin.viewModules(st);
			break;
		}
		case 2:
		{
			System.out.println("Courses Table");
			admin.viewCourse(st);
			System.out.println("Instructor Table");
			admin.viewInstructors(st);
			System.out.println("Module Table");
			admin.viewModules(st);
			admin.editModule(st);
			//admin.viewModules(st);
			break;
		}
		case 3:
		{
			System.out.println("Module Table");
			admin.viewModules(st);
			admin.deleteModule(st);
			break;
		}
		case 4:
		{
			break;
		}
		default:
		{
			System.out.println("Enter valid number");
			break;
		}
		}
		break;
		}
		case 4:
		{
			System.out.println("Modules Table");
			ArrayList<Module> moduleList=admin.viewModules(st);
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int choice=0;
			while(true)
			{
				System.out.println("\n1.Add Topic\n2.Edit Topic\n3.delete Topic\n4.Back");
				try
				{
				choice=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
		switch(choice)
		{
		case 1:
		{
			System.out.println("Module Table");
			//admin.viewModules(st);
			admin.addTopic(st);
			break;
		}
		case 2:
		{
			System.out.println("Modules Table");
			admin.viewModules(st);
			System.out.println("Topic Table");
			admin.viewTopic(st);
			admin.editTopic(st);
			break;
		}
		case 3:
		{
			admin.deleteTopic(st);
			break;
		}
		case 4:
		{
			break;
		}
		default:
		{
			System.out.println("Enter valid number");
			break;
		}
		}
		break;
		}
		case 5:
		{
			System.out.println("Topic Table");
			ArrayList<Topic> topicList=admin.viewTopic(st);
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter\n1.Add Assessment\n2.Edit Assessment\n3.Delete Assessment\n4.Back");
		int choice=0;
		while(true)
		{
			try
			{
				choice=Integer.parseInt(sc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			break;
		}
		switch(choice)
		{
		case 1:
		{
			admin.addAssessment(st,topicList);
			break;
		}
		case 2:
		{
			admin.editAssessment(st);
			break;
		}
		case 3:
		{
			System.out.println("Assessment Table");
			admin.viewAssessment(st);
			admin.deleteAssessment(st);
			break;
		}
		case 4:
		{
			break;
		}
		default:
		{
			System.out.println("Enter valid number");
			break;
		}
		}
		break;
		}
		case 6:
		{
			//System.out.println("Assessment Table");
			System.out.println("Assessment Table");
			admin.viewAssessment(st);
			System.out.println("Enter\n1.Add Question\n2.Edit Question\n3.Delete Question\n4.View Questions\n5.Back");
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int choice=0;
			while(true)
			{
				try
				{
				choice=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			switch(choice)
			{
		case 1:
		{
			admin.addQuestion(st);
			break;
		}
		case 2:
		{
			admin.editQuestion(st);
			break;
		}
		case 3:
		{
			admin.deleteQuestion(st);
			break;
		}
		case 4:
		{
			admin.viewQuestions(st);
		}
		case 5:
		{
			break;
		}
		default :
		{
			System.out.println("Enter valid number");
		}
		}
			break;
		}
		case 7:
		{
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter\n1.View Courses\n2.View Modules\n3.View Topic\n4.View Content\n5.view Assessment\n6.View Questions\n7.View Answers\n8.Back");
			int choice=0;
			while(true)
			{
				try
				{
				choice=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
		switch(choice)
		{
		case 1:
		{
			admin.viewCourse(st);
			break;
		}
		case 2:
		{
			admin.viewModules(st);
			break;
		}
		case 3:
		{
			admin.viewTopic(st);
			break;
		}
		case 4:
		{
			admin.viewContents(st);
			break;
		}
		case 5:
		{
			admin.viewAssessment(st);
			break;
		}
		case 6:
		{
			admin.viewQuestions(st);
			break;
		}
		case 7:
		{
			admin.viewAnswers(st);
			break;
		}
		case 8:
		{
			break;
		}
		default:
		{
			System.out.println("Enter valid option");
			break;
		}
		}
		break;
		}
		case 8:
		{
			System.out.println("Enter 1.View Content\n2.Add Content\n3.Edit Content\n4.Delete Content\n5.break");
			Scanner fc=new Scanner(System.in);
			int choice=0;
			while(true)
			{
				try
				{
				choice=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid Integer");
					continue;
				}
				break;
			}
			switch(choice)
			{
			case 1:
			{
			admin.viewContents(st);
			break;
			}
			case 2:
			{
				admin.addContent(st);
				break;
			}
			case 3:
			{
				admin.editContent(st);
				break;
			}
			case 4:
			{
				admin.deleteContent(st);
				break;
			}
			case 5:
			{
				break;
			}
			default:
			{
				System.out.println("Enter valid number");
				break;
			}
			}
			break;
		}
		case 9:
		{
			int choice=0;
			while(true)
			{
				System.out.println("Enter\n1.View Admin\n2.View Instructors\n3.View Students");
				try
				{
				choice=Integer.parseInt(sc.next());
				if(choice>3)
				{
					throw new Exception();
				}
				}
				catch(Exception e)
				{
					System.out.println("Enter valid Choice");
					continue;
				}
				break;
			}
			switch(choice)
			{
			case 1:
			{
				Admin Admin=new Admin();
				Admin.viewAdmins(st);
				break;
			}
			case 2:
			{
				admin.viewInstructors(st);
				break;
			}
			case 3:
			{
				admin.viewStudents(st);
				break;
			}
			default:
			{
				System.out.println("Enter options within 1-3");
				adminChoices(st);
			}
			}
			break;
		}
		case 10:
		{
			System.out.println("Enter 1.View Files\n2.Add Files\n3.Edit Files\n4.Delete Files\n5.break");
			Scanner fc=new Scanner(System.in);
			int choice=0;
			while(true)
			{
				try
				{
				choice=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid Integer");
					continue;
				}
				break;
			}
			switch(choice)
			{
			case 1:
			{
				
				break;
			}
			}
		}
		case 11:
		{
			flg=1;
			break;
		}
		case 12:
		{
			//admin.studentScores(st);
			break;
		}
		default:
		{
			System.out.println("Enter valid number");
			break;
		}
		}//This is it
		if(flg==1)
		{
			break;
		}
		}
	}//////
	public void viewAdmins(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from admin");
		Admin admin=new Admin();
		ArrayList<Admin>adminList=new ArrayList<Admin>();
		while(rs.next())
		{
			admin=new Admin(rs.getString("username"),rs.getString("password"), rs.getString("name"), rs.getString("email"));
			//System.out.println(/*"Admin Id "+rs.getInt("adminid")+*/" Admin username "+rs.getString("username")+" Admin Password "+rs.getString("password")/*+" Username "+rs.getString("username")+" Email "+rs.getString("email")*/);
			adminList.add(admin);
		}
		System.out.println("----------------------------------------------+");
		System.out.printf("| %-20s | %-20s |%n","Username","Password");
		System.out.println("----------------------------------------------+");
		adminList.stream().forEach((x)->System.out.printf("| %-20s | %-20s |%n",x.getUsername(),x.getPassword()));
		System.out.println("----------------------------------------------+");
	}
	public void addCourse(Courses courses,Statement st) throws SQLException
	{
		try {
			//Connection con=DBConnection.getconnection();
			//Statement st=con.createStatement();
			st.executeQuery("insert into courses values(id.nextval,'"+courses.getCourseName()+"',"+courses.getInstructorid()+",to_date('"+courses.getStartDate().toString()+"','YYYY-MM-dd'),to_date('"+courses.getEndDate().toString()+"','YYYY-MM-dd'))");
			System.out.println("Successfully Executed");
			ResultSet Rs=st.executeQuery("select * from courses");
			ArrayList<Courses>al=new ArrayList<Courses>();
			while(Rs.next())
			{
				System.out.println("Course Id "+Rs.getInt("courseid")+" Course name "+Rs.getString("coursename")+" "+" instructor id"+Rs.getString("instructorid")+" "+"start date"+Rs.getDate("startdate")+" "+"end date"+Rs.getDate("enddate"));
				Courses course=new Courses(Rs.getInt("courseid"),Rs.getString("coursename"),Rs.getInt("instructorid"),Rs.getDate("startdate").toLocalDate(),Rs.getDate("enddate").toLocalDate());
				al.add(course);
			}
			Collections.sort(al);
			//System.out.println(courses.getCal().size()); name = new ();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void renameCourse(Courses courses,Statement st) throws SQLException
	{
		
		//Connection con=DBConnection.getconnection();
		//Statement st;
		System.out.println("Courses Table");
	    viewCourse(st);
		int rows=0;
		try {
			//st = con.createStatement();
			rows=st.executeUpdate("update courses set coursename='"+courses.getCourseName().toLowerCase()+"' where courseid="+courses.getCourseID()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows==0)
		{
			System.out.println("No Course Found");
			renameCourse(courses, st);
		}
		else
		{
		System.out.println("Renamed Successfully");
		}
	}
	public void deleteCourse(Courses courses,Statement st) 
	{
		try
		{
		int rows=st.executeUpdate("delete from courses where courseid="+courses.getCourseID()+"");
		if(rows==0)
		{
			System.out.println("No Course Found");
			deleteCourse(courses, st);
		}
		else
		{
		System.out.println(rows+" rows Deleted Successfully ");
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			deleteCourse(courses, st);
		}
	}
	public void editstart(Courses courses,Statement st)
	{
		try
		{
		int rows=st.executeUpdate("update courses set startdate=to_date('"+courses.getStartDate().toString()+"','YYYY-MM-dd') where courseid="+courses.getCourseID()+"");
		if(rows>0)
		{
		System.out.println("Start Date Edited Successfully ");
		}
		else
		{
			System.out.println("Course Not Found");
			editstart(courses, st);
		}
		}
		catch(Exception e)
		{
			System.out.println("Invalid input.Enter valid input");
			editstart(courses, st);
		}
	}
	public void editend(Courses courses,Statement st)
	{
		try
		{
			int rows=st.executeUpdate("update courses set enddate=to_date('"+courses.getEndDate().toString()+"','YYYY-MM-dd') where courseid="+courses.getCourseID()+"");
			if(rows>0)
			{
			System.out.println("End date Edited Successfully ");
			}
			else
			{
				System.out.println("No course found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid input enter valid input");
			editend(courses, st);
		}
	}
	public ArrayList<Courses> viewCourse(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from courses");
		//System.out.println("  "+"Course Id"+"  "+"  "+"Course Name"+" "+"  "+"Instructor Id"+" "+"  "+"start date"+" "+"  "+"end date");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("| %-12s | %-30s | %-15s | %-12s | %-12s |%n","Course Id","Course Name","Instructor Id","Start date","end date");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		Courses courses = new Courses(0,"",0,LocalDate.now(),LocalDate.now());
		ArrayList<Courses>courseList=new ArrayList<Courses>();
		while(rs.next())
		{
			courses=new Courses(rs.getInt("courseid"),rs.getString("coursename"),rs.getInt("instructorid"),rs.getDate("startdate").toLocalDate(),rs.getDate("enddate").toLocalDate());
			//System.out.println("\t"+courses.getCourseID()+"\t\t"+courses.getCourseName()+"\t\t"+courses.getInstructorid()+"\t\t"+courses.getStartDate()+"\t"+courses.getEndDate());
			courseList.add(courses);
		}
		//courseList.stream().forEach((x)->System.out.println(x.getCourseID()+" "+x.getCourseName()+" "+x.getInstructorid()+" "+x.getStartDate()+" "+x.getEndDate()));
		courseList.stream().sorted((x1,x2)->Integer.compare(x1.getCourseID(), x2.getCourseID())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-12d | %-30s | %-15d | %-12s | %-12s |%n",x.getCourseID(),x.getCourseName(),x.getInstructorid(),x.getStartDate().toString(),x.getEndDate().toString()));
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		return courseList;
	}
	public void addModule(Statement st) throws IOException, SQLException
	{
		System.out.println("Courses Table");
		ArrayList<Courses>courseList=viewCourse(st);
		System.out.println("Instructor Table");
		ArrayList<Instructor>instructorsList=viewInstructors(st);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter details to create a module");
		Scanner fc=new Scanner(System.in);
		//String moduleName="";
		
		System.out.println("Enter Module Name");
		String moduleName="";
		while(true)
		{
			try
			{
		ExceptionHandler.containsSpecialCharacters(moduleName=bf.readLine());
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		int instructorid=0;
		while(true)
		{
			int insid=0;
		System.out.println("Enter Instructor Id");
		try
		{
		insid=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		int ctr=0;
		for(Instructor i:instructorsList)
		{
			if(i.getId()==insid)
			{
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Instructor Id not found");
			continue;
		}
		instructorid=insid;
		break;
		}
		/*ResultSet insrs=st.executeQuery("select * from instructor where instructorid="+instructorid+"");
		if(!insrs.isBeforeFirst())
		{
			System.out.println("Instructor Id not Found");
			addModule(st);
		}*/
		int courseid=0;
		while(true)
		{
		System.out.println("Enter Course Id");
		int cid=0;
		try
		{
		cid=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			e.getMessage();
			continue;
		}
		int ctr=0;
		for(Courses course:courseList)
		{
			if(course.getCourseID()==cid)
			{
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Course Id not found");
			continue;
		}
		courseid=cid;
		/*ResultSet coursers=st.executeQuery("select * from courses where courseid="+courseid+"");
		if(!coursers.isBeforeFirst())
		{
			System.out.println("Course Id not Found");
			addModule(st);
		}*/
		break;
		}
		Module module=new Module(moduleName,instructorid,courseid);
		
		try {
			st.executeQuery("insert into module values(moduleseq.nextval,'"+module.getModuleName()+"',"+module.getInstructorId()+","+module.getCourseId()+")");
			System.out.println("Module Insertion Successfully Executed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid input .Enter valid input");
			addModule( st);
		}
	}
	public ArrayList<Module> viewModules(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from module");
		//System.out.println("Module Id"+"  "+"Module Name");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("| %-10s | %-30s | %-15s | %-10s |%n","Module Id","Module Name","Instructor Id","Course Id");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		ArrayList<Module>moduleList=new ArrayList<Module>();
		while(rs.next())
		{
			Module module=new Module(rs.getInt("moduleid"),rs.getString("modulename"),rs.getInt("instructorid"),rs.getInt("courseid"));
			//System.out.println(module.getModuleId()+"  "+module.getModuleName()+" "+module.getInstructorId()+" "+module.getCourseId());
			moduleList.add(module);
		}
		Courses courses=new Courses();
		courses.setModuleList(moduleList);
		//System.out.println("+-----------------------------------------------------------------------------------------------+");
		courses.getModuleList().stream().sorted((x1,x2)->Integer.compare(x1.getModuleId(), x2.getModuleId())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-10d | %-30s | %-15d | %-10d |%n",x.getModuleId(),x.getModuleName(),x.getInstructorId(),x.getCourseId()));
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		return moduleList;

	}
	public void editModule(Statement st) throws SQLException, IOException
	{
		ArrayList<Courses>course=viewCourse(st);
		ArrayList<Instructor>instructors=viewInstructors(st);
		ArrayList<Module>moduleList=viewModules(st);
		System.out.println("Edit\n1.ModuleName\n2.instructorId\n3.courseId\n4.Back");
		Scanner fc=new Scanner(System.in);
		int choice=0;
		while(true)
		{
		try
		{
		choice=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		break;
		}
		switch(choice)
		{
		case 1:
		{
			Module module=new Module();
			int moduleId=0;
			while(true)
			{
			System.out.println("Enter module id");
			try
			{
			moduleId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Module m:moduleList)
			{
				if(m.getModuleId()==moduleId)
				{
					module=m;
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Module not found");
				continue;
			}
			break;
			}
			fc.nextLine();
			//String moduleName="";
			//boolean flag=true;
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter module name");
			String moduleName="";
			while(true)
			{
				moduleName=bf.readLine();
				try
				{
					ExceptionHandler.containsSpecialCharacters(moduleName);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			/*ResultSet rs=st.executeQuery("select * from module where moduleid="+moduleId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Module Id not found");
				editModule(st);
			}*/
			//Module module;
			//while(rs.next())
			//{
				//module=new Module(rs.getInt("moduleid"),moduleName,rs.getInt("instructorid"),rs.getInt("courseid"));
			System.out.println(module.toString());
				try {
					int rows=st.executeUpdate("update module set modulename='"+moduleName+"' where moduleid="+module.getModuleId()+"");
					System.out.println("Module Rename Successfully Executed");
					if(rows>0)
					{
						System.out.println(rows+" row affected");
					}
					else
					{
					System.out.println(rows+" rows affected");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid input.Enter valid input");
					editModule(st);
				}
				viewModules(st);
			//} 
			
			break;
		}
		case 2:
		{
			Module module=new Module();
			Instructor instructor=new Instructor();
			int instructorId=0;
			while(true)
			{
			System.out.println("Enter Instructor Id");
			try
			{
			instructorId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Instructor i:instructors)
			{
				if(i.getId()==instructorId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Instructor Id not found");
				continue;
			}
			break;
			}
			/*ResultSet insrs=st.executeQuery("select * from instructor where instructorid="+instructorId+"");
			if(!insrs.isBeforeFirst())
			{
				System.out.println("Instructor Id not found");
				editModule(st);
			}*/
			//fc.nextLine();
			int moduleId=0;
			while(true)
			{
			System.out.println("Enter Module Id");
			try
			{
			moduleId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			//module=moduleList.stream().filter((x)->x.getModuleId()==moduleId).toList().get(0);
			for(Module m:moduleList)
			{
				if(m.getModuleId()==moduleId)
				{
					module=m;
					ctr++;
				}
			}
			if(ctr==0)
			{
				continue;
			}
			break;
			}
			/*ResultSet rs=st.executeQuery("select * from module where moduleid="+moduleId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Module Id not Found");
				editModule(st);
			}*/
			//Module module;
			//while(rs.next())
			//{
				//module=new Module(rs.getInt("moduleid"),rs.getString("modulename"),instructorId,rs.getInt("courseid"));
				try {
					int rows=st.executeUpdate("update module set instructorid='"+module.getInstructorId()+"' where moduleid="+module.getModuleId()+"");
					System.out.println("Module Edit Successfully Executed");
					if(rows>0)
					{
						System.out.println(rows+" row affected");
					}
					else
					{
					System.out.println("Module Id not Found");
					editModule(st);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Instructor Id not Found");
					editModule(st);
				}
			//} 
				viewModules(st);
			break;
		}
		case 3:
		{
			ArrayList<Courses>courseList=viewCourse(st);
			ArrayList<Module> modules=new ArrayList<>();
			Courses courses=new Courses();
			Module module=new Module();
			int courseId=0;
			while(true)
			{
			System.out.println("Enter Course Id");
			try
			{
			courseId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Courses c:courseList)
			{
				if(c.getCourseID()==courseId)
				{
					courses=c;
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Course Id not found");
				continue;
			}
			break;
			}
			//fc.nextLine();
			/*for(Module m:moduleList)
			{
				if(m.getCourseId()==courseId)
				{
					modules.add(m);
				}
			}*/
			int moduleId=0;
			while(true)
			{
			System.out.println("Enter Module Id");
			try
			{
			moduleId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Module m:moduleList)
			{
				if(m.getModuleId()==moduleId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Module Id not found");
				continue;
			}
			break;
			}
			

			//while(rs.next())
			//{
				//module=new Module(rs.getInt("moduleid"),rs.getString("modulename"),rs.getInt("instructorid"),courseId);
				try {
					int rows=st.executeUpdate("update module set courseid="+courseId+" where moduleid="+module.getModuleId()+"");
					System.out.println("Module course id Renamed Successfully Executed");
					if(rows>0)
					{
						System.out.println(rows+" row affected");
					}
					else
					{
					System.out.println("Course Id not Found");
					editModule(st);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Course Id not Found");
					editModule(st);
				}
			//}
			break;
		}
		case 4:
		{
			break;
		}
		default:
		{
			editModule(st);
		}
		}
	}//edit module
	public void deleteModule(Statement st) throws SQLException
	{
		ArrayList<Module>moduleList=viewModules(st);
		Scanner fc=new Scanner(System.in);
		int moduleId=0;
		while(true)
		{
		System.out.println("Enter Module id to delete");
		try
		{
		moduleId=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			//e.getMessage();
			continue;
		}
		int ctr=0;
		for(Module m:moduleList)
		{
			if(m.getModuleId()==moduleId)
			{
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Module Id not found");
			continue;
		}
		break;
		}
		int choice=0;
		while(true)
		{
		System.out.println("Are you sure you want to delete it?\n 1.Yes \n2.Cancel");
		try
		{
		choice=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			//e.getMessage();
			continue;
		}
		break;
		}
		switch(choice)
		{
		case 1:
		{
			try
			{
			int rows=st.executeUpdate("delete from module where moduleid="+moduleId+"");
			if(rows>0)
			{
			System.out.println(rows+" Module rows Deleted Successfully");
			}
			else
			{
				System.out.println("Module id not found");
				deleteModule(st);
			}
			}
			catch(Exception e)
			{
				System.out.println("Module id not Found");
				deleteModule(st);
			}
			break;
		}
		case 2:
		{
			break;
		}
		default:
			System.out.println("Enter valid number");
			deleteModule(st);
			break;
		}
	}
	public ArrayList<Instructor> viewInstructors(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from instructor");
		Instructor instructorObject=new Instructor();
		ArrayList<Instructor>instructorList=new ArrayList<Instructor>();
		while(rs.next())
		{
			instructorObject=new Instructor(rs.getInt("instructorid"),rs.getString("username"),rs.getString("password"),rs.getString("email"));
			instructorList.add(instructorObject);
			//System.out.println("Instructor Id "+instructorObject.getId()+" instructor username "+instructorObject.getUsername()+" instructor Password "+instructorObject.getPassword()+" instructor email "+instructorObject.getEmail());
		}
		System.out.println("-----------------------------------------------------------------------------+");
		System.out.printf("| %-15s | %-10s | %-10s | %-30s |%n","instructorid","username","password","email");
		System.out.println("-----------------------------------------------------------------------------+");
		instructorList.stream().sorted((x1,x2)->Integer.compare(x1.getId(), x2.getId())).forEach((x)->System.out.printf("| %-15d | %-10s | %-10s | %-30s |%n",x.getId(),x.getUsername(),x.getPassword(),x.getEmail()));
		System.out.println("-----------------------------------------------------------------------------+");
		return instructorList;
	}
	public  void addTopic(Statement st) throws SQLException, IOException
	{
		Scanner fc=new Scanner(System.in);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Module>moduleList=viewModules(st);
		//System.out.println("Enter Topic Id");
		//int topicid=fc.nextInt();
		
		System.out.println("Enter Topic Name");
		String topicName="";
		while(true)
		{
			topicName=bf.readLine();
			try
			{
			ExceptionHandler.containsSpecialCharacters(topicName);
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		
		int moduleId=0;
		while(true)
		{
		System.out.println("Enter Module Id");
		try
		{
		moduleId=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		int ctr=0;
		for(Module m:moduleList)
		{
			if(m.getModuleId()==moduleId)
			{
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Module Id not found");
			continue;
		}
		break;
		}
		//ResultSet rs=st.executeQuery("select * from module");
		Topic topic=new Topic(topicName,moduleId);
		try
		{
		st.executeQuery("insert into topic values(topicseq.nextval,'"+topic.getTopicName()+"',"+topic.getModuleId()+")");
		}
		catch(Exception e)
		{
			System.out.println("Invalid module Id");
			addTopic(st);
		}
		System.out.println("Topic Added successfully");
	}
	public  void editTopic(Statement st) throws SQLException, IOException
	{
		ArrayList<Topic>topicList=viewTopic(st);
		ArrayList<Module>moduleList=viewModules(st);
		Scanner fc=new Scanner(System.in);
		int choice=0;
		while(true)
		{
		System.out.println("Enter choices to edit");
		System.out.println("1.Topic Name\n 2.Module Id \n3.Back");
		try
		{
		choice=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		break;
		}
		switch(choice)
		{
		case 1:
		{
			int topicId=0;
			while(true)
			{
			System.out.println("Enter to topic Id");
			try
			{
			topicId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			int ctr=0;
			for(Topic topic:topicList)
			{
				if(topic.getTopicId()==topicId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Topic id not found");
				continue;
			}
			break;
			}
			fc.nextLine();
			//String topicName="";
			
			System.out.println("Enter Topic Name To Edit");
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			String topicName="";
			while(true)
			{
				topicName=bf.readLine();
				try
				{
					ExceptionHandler.containsSpecialCharacters(topicName);;
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			Topic topic=new Topic(topicId,topicName);
			try
			{
			int rows=st.executeUpdate("update topic set topicname='"+topic.getTopicName()+"' where topicid="+topic.getTopicId()+"");
			if (rows>0)
			{
				System.out.println(rows+" row have been updated successfully");
			}
			else
			{
				System.out.println("Topic Id not Found.");
				editTopic(st);
			}
			}
			catch(Exception e)
			{
				System.out.println("Topic Id not Found");
				editTopic(st);
			}
			break;
		}
		case 2:
		{
			int moduleId=0;
			while(true)
			{
			System.out.println("Enter Module Id to edit");
			try
			{
			moduleId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Module m:moduleList)
			{
				if(m.getModuleId()==moduleId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Module id not found");
				continue;
			}
			break;
			}
			int topicId=0;
			while(true)
			{
			System.out.println("Enter Topic Id to Edit");
			try
			{
			topicId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Topic topic:topicList)
			{
				if(topic.getTopicId()==topicId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Topic Id not found");
				continue;
			}
			break;
			}
			Topic topic=new Topic(moduleId,topicId);
			try
			{
			int rows=st.executeUpdate("update topic set moduleid="+topic.getModuleId()+" where topicid="+topic.getTopicId()+"");
			if (rows>0)
			{
				System.out.println(rows+" row have been updated Successfully");
			}
			else
			{
			System.out.println("Invalid input.Topic Id or Module Id does not exist");
			editTopic(st);
			}
			}
			catch(Exception e)
			{
				System.out.println("Invalid input.Enter valid input");
				editTopic(st);
			}
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			editTopic(st);
		}
		}
	}
	public  void deleteTopic(Statement st) throws SQLException
	{
		//String topicName="";
		Topic topic=new Topic();
		Scanner fc=new Scanner(System.in);
		System.out.println("Topic Table");
		ArrayList<Topic> topicList=viewTopic(st);
		System.out.println("Enter Topic id to delete");
		int topicId=0;
		while(true)
		{
			try
			{
			topicId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid Number");
				continue;
			}
			int ctr=0;
			for(Topic t:topicList)
			{
				if(t.getTopicId()==topicId)
				{
					topic=t;
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Topic Id not found");
				continue;
			}
			break;
		}
		
		/*ResultSet rs=st.executeQuery("select * from topic where topicid="+topicId+"");
		if(!rs.isBeforeFirst())
		{
			System.out.println("Topic Id not Found");
			deleteTopic(st);
		}*/
		//while(rs.next())
		//{
			//Topic topic=new Topic(topicId,rs.getString("topicName"),rs.getInt("moduleid"));
			try
			{
			int rows=st.executeUpdate("delete from topic where topicid="+topic.getTopicId()+"");
			if(rows>0)
			{
			System.out.println(rows+" row(s) deleted");
			}
			else
			{
				System.out.println("Topic Id not Found");
				deleteTopic(st);
			}
			}
			catch(Exception e)
			{
				System.out.println("Topic Id not Found");
				deleteTopic(st);
			}
		//}
	}
	public  ArrayList<Topic> viewTopic(Statement st) throws SQLException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		ResultSet rs=st.executeQuery("select * from topic");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-8s | %-100s | %-8s |%n","Topic Id","Topic Name","Module Id");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------+");
		ArrayList<Topic>topicList=new ArrayList<Topic>();
		while(rs.next())
		{
			Topic topic=new Topic(rs.getInt("topicid"),rs.getString("topicname"),rs.getInt("moduleid"));
			topicList.add(topic);
			//System.out.println("Topic Id : "+topic.getTopicId()+" "+"Topic Name : "+topic.getTopicName()+" Module Id : "+topic.getModuleId());
		}
		Module module = new Module(0, null, 0, 0, null);
		module.setTal(topicList);
		module.getTal().stream().sorted((x1,x2)->Integer.compare(x1.getTopicId(), x2.getTopicId())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-8d | %-100s | %-8d |%n",x.getTopicId(),x.getTopicName(),x.getModuleId()));
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------+");
		return topicList;
	}
	public ArrayList<Content> viewContents(Statement st) throws SQLException
	{
		System.out.println("Topic Content");
		//viewTopic(st);
		/*System.out.println("Content Table");
		Content.viewContents(st);*/
		System.out.println("+-----------------------------------------------------------------------------------+");
		System.out.printf("| %-8s | %-55s   | %-8s |%n","Content Id","Content Name","Topic Id");
		System.out.println("+-----------------------------------------------------------------------------------+");
		ResultSet rs=st.executeQuery("select * from content");
		Topic topic=new Topic();
		while(rs.next())
		{
			//System.out.println(" Content Id "+" "+rs.getInt("contentid")+" ; "+"Content Name"+" "+rs.getString("contentName")+" ; "+"Topic Id  "+rs.getInt("topicId"));
			//System.out.printf("| %-8d | %-55s | %-8d |%n","Content Id","Content Name","Topic Id");
			Content c=new Content(rs.getInt("contentid"),rs.getString("contentName"),rs.getInt("topicId"));
			topic.pushContentList(c);
		}
		topic.getContentList().stream().sorted((x1,x2)->Integer.compare(x1.getContentid(), x2.getContentid())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-8d   | %-55s   | %-8d |%n",x.getContentid(),x.getContentName(),x.getTopicId()));
		System.out.println("+-----------------------------------------------------------------------------------+");
		return topic.getContentList();
	}
	public  void addContent(Statement st) throws SQLException, IOException, SpecialCharacterException
	{
		Admin admin=new Admin();
		ArrayList<Topic> topicList=admin.viewTopic(st);
		Scanner fc=new Scanner(System.in);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		/*System.out.println("Enter Content id (number)");
		int contentId=0;
		while(true)
		{
			try
			{
				contentId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			break;
		}*/
		String contentName="";
		while(true)
		{
			try
			{
				System.out.println("Enter Content Name");
			//exceptionHandler.containsSpecialCharacters(contentName=bf.readLine());
				contentName=bf.readLine();
			ExceptionHandler.hasValidExtension(contentName);
			}
			/*catch(specialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}*/
			catch(InvalidFileException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		int topicId=0;
		while(true)
		{
			try
			{
				System.out.println("Enter topic id");
			topicId=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Topic t:topicList)
			{
				if(t.getTopicId()==topicId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Topic id not found");
				continue;
			}
			break;
		}
		try
		{
		ResultSet rs1=st.executeQuery("insert into content values(contentseq.nextval,'"+contentName+"',"+topicId+")");
		}
		catch(Exception e)
		{
		
			System.out.println("Invalid Topic name");
			admin.addContent(st);
		}
		viewContents(st);;
	}
	public  void editContent(Statement st) throws IOException, SQLException
	{
		System.out.println("Topic Table");
		ArrayList<Topic>topicList=viewTopic(st);
		System.out.println("Content table");
		ArrayList<Content>contentList=viewContents(st);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int contentId=0;
		while(true)
		{
			System.out.println("Enter Content Id to rename");
			try
			{
				//ExceptionHandler.containsSpecialCharacters(contentName);
				//ExceptionHandler.hasValidExtension(contentId);
				contentId=Integer.parseInt(sc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Content c:contentList)
			{
				if(c.getContentid()==contentId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("content not found");
				continue;
			}
			break;
		}
		System.out.println("Enter New Content Name");
		String newContentName="";
		while(true)
		{
			newContentName=bf.readLine();
			try
			{
			ExceptionHandler.hasValidExtension(newContentName);
			}
			catch(InvalidFileException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		/*while(true)
		{
			try
			{
			System.out.println("Enter the name of the content you need to change");
			contentName=bf.readLine();
			//exceptionHandler.containsSpecialCharacters(contentName);
			}
			catch(Exception e)
			{
				System.out.println("Enter valid String");
				//System.out.println(e.getMessage());
				continue;
			}
			break;
		}*/
		//newContentName=bf.readLine();
		/*while(true)
		{
			try
			{
			System.out.println("Enter the name of the content you need to change");
			newContentName=bf.readLine();
			//exceptionHandler.containsSpecialCharacters(newContentName);
			}
			catch(Exception e)
			{
				System.out.println("Enter valid String");
				//System.out.println(e.getMessage());
				continue;
			}
			break;
		}*/
		try
		{
		int rows=st.executeUpdate("update content set contentname='"+newContentName+"' where contentid="+contentId+"");
		if(rows==0)
		{
			System.out.println("Content Not Found");
			editContent(st);
		}
		System.out.println(rows+" rows updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("Content not Found");
		}
	}
	public  void deleteContent(Statement st) throws IOException, SQLException
	{
		//System.out.println("Topic Table");
		//Topic.viewTopic(st);
		System.out.println("Content Table");
		ArrayList<Content>contentList=viewContents(st);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		Scanner fc=new Scanner(System.in);
		System.out.println("Enter Id of the content to delete");
		int contentId=0;
		while(true)
		{
			try
			{
				contentId=Integer.parseInt(fc.next());
				//exceptionHandler.containsSpecialCharacters(contentName);
			}
			catch(Exception e)
			{
				System.out.println("Enter valid String");
				continue;
			}
			int ctr=0;
			for(Content c:contentList)
			{
				if(c.getContentid()==contentId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Content not found");
				continue;
			}
			break;
		}
		try
		{
		int rows=st.executeUpdate("delete from content where contentid="+contentId+"");
		if(rows==0)
		{
			System.out.println("File Not Found");
			deleteContent(st);
		}
		System.out.println(rows+" rows deleted successfully");
		}
		catch(Exception e)
		{
			System.out.println("File not found");
			deleteContent(st);
		}
	}
	public ArrayList<Assessment> viewAssessment(Statement st) throws SQLException
	{
		
		ResultSet rs=st.executeQuery("select * from assessment");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-15s | %-35s | %-10s |%n","Assessment Id","Assessment Name","Topic Id");
		System.out.println("+--------------------------------------------------------------------+");
		ArrayList<Assessment>assessmentList=new ArrayList<Assessment>();
		//System.out.println(" Assessment Id "+" "+" Assessment Name "+" "+" Topic Id ");
		Assessment assessment=new Assessment();
		while(rs.next())
		{
		//	System.out.printf("| %-15d | %-35s | %-10d |%n",rs.getInt("assessmentid"),rs.getString("assessmentname"),rs.getInt("topicid"));
			assessment=new Assessment(rs.getInt("assessmentid"),rs.getString("assessmentname"),rs.getInt("topicid"));
			assessmentList.add(assessment);
		}
		assessmentList.stream().sorted((x1,x2)->Integer.compare(x1.getAssesmentid(), x2.getAssesmentid())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-15d | %-35s | %-10d |%n",x.getAssesmentid(),x.getAssessmentName(),x.getTopicId()));
		System.out.println("+--------------------------------------------------------------------+");
		Topic topic=new Topic();
		topic.setAssessmentList(assessmentList);
		return topic.getAssessmentList();
	}
	public  void addAssessment(Statement st,ArrayList<Topic> topicList) throws SQLException, IOException
	{
		Scanner fc=new Scanner(System.in);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		//String aname="";
		
		String aname="";
		while(true)
		{
			System.out.println("Enter Assesment name");
			aname=bf.readLine();
			try
			{
			ExceptionHandler.containsSpecialCharacters(aname);
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		
		int tid=0;
		while(true)
		{
		System.out.println("Enter Topic id");
		try
		{
		tid=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		int ctr=0;
		for(Topic t:topicList)
		{
			if(t.getTopicId()==tid)
			{
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Topic not found");
			continue;
		}
		break;
		}
		Assessment assessment=new Assessment(aname,tid);
		try
		{
		st.executeQuery("insert into assessment values(assessmentseq.nextval,'"+assessment.getAssessmentName()+"',"+assessment.getTopicId()+")");
		System.out.println("Assessment inserted successfully");
		}
		catch(Exception e)
		{
			System.out.println("Enter valid Topic id");
			addAssessment(st,topicList);
		}
	}
	public  void editAssessment(Statement st) throws SQLException, IOException
	{
		System.out.println("Assessment Table");
		ArrayList<Assessment> assessmentList=viewAssessment(st);
		System.out.println("Topic Id");
		ArrayList<Topic> topicList=viewTopic(st);
		Scanner fc=new Scanner(System.in);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int choice=0;
		while(true)
		{
		System.out.println("Enter\n 1.Assessment name\n 2.Topic Id\n 3.back");
		try
		{
		choice=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		break;
		}
		switch(choice)
		{
		case 1:
		{
			Assessment a=new Assessment();
			int id=0;
			while(true)
			{
			System.out.println("Enter Assessment Id");
			try
			{
			id=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Assessment as:assessmentList)
			{
				if(as.getAssesmentid()==id)
				{
					a=as;
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Assessment id not found");
				continue;
			}
			break;
			}
			fc.nextLine();
			System.out.println("Enter Assessment Name");
			String name="";
			while(true)
			{
				name=bf.readLine();
				try
				{
					ExceptionHandler.containsSpecialCharacters(name);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			/*ResultSet rs=st.executeQuery("select * from assessment where assessmentid="+id+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Assessment id not found");
				editAssessment(st);
			}*/
			//while(rs.next())
			//{
				//Assessment a=new Assessment(id,name,rs.getInt("topicid"));
				try
				{
				int rows=st.executeUpdate("update assessment set assessmentname='"+name+"' where assessmentid="+a.getAssesmentid()+"");
				if(rows>0)
				{
				System.out.println(rows+" row(s) updated successfully");
				}
				else
				{
					System.out.println("Assessment id not found");
					editAssessment(st);
				}
				}
				catch(Exception e)
				{
					System.out.println("Assessment Id not Found");
					editAssessment(st);
				}
			//}
			break;
		}
		case 2:
		{
			Assessment a=new Assessment();
			int id=0;
			while(true)
			{
			System.out.println("Enter Assessment Id");
			try
			{
			id=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Assessment as:assessmentList)
			{
				if(as.getAssesmentid()==id)
				{
					a=as;
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Assessment id not found");
				continue;
			}
			break;
			}
			//fc.nextLine();
			int topicid=0;
			while(true)
			{
			System.out.println("Enter Topic Id");
			try
			{
			topicid=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			int ctr=0;
			for(Topic topic:topicList)
			{
				if(topic.getTopicId()==topicid)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Topic id not found");
				continue;
			}
			break;
			}
			/*ResultSet rs=st.executeQuery("select * from assessment where assessmentid="+id+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Assessment Id not found");
				editAssessment(st);
			}*/
			//while(rs.next())
			//{
				//Assessment a=new Assessment(id,rs.getString("assessmentname",topicid);
				try
				{
				int rows=st.executeUpdate("update assessment set topicid="+topicid+" where assessmentid="+a.getAssesmentid()+"");
				if(rows>0)
				{
				System.out.println(rows+" row(s) updated successfully");
				}
				else
				{
					System.out.println("Topic id not found");
					editAssessment(st);
				}
				}
				catch(Exception e)
				{
					System.out.println("Topic Id not found");
					editAssessment(st);
				}
			//}
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			System.out.println("Invalid option");
			editAssessment(st);
		}
		}
	}
	public  void deleteAssessment(Statement st) throws SQLException
	{
		Scanner fc=new Scanner(System.in);
		Assessment a=new Assessment();
		ArrayList<Assessment>assessmentList=viewAssessment(st);
		int aid=0;
		while(true)
		{
		System.out.println("Enter Assessment id");
		try
		{
		aid=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		int ctr=0;
		for(Assessment as:assessmentList)
		{
			if(as.getAssesmentid()==aid)
			{
				a=as;
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Assessment not found");
			continue;
		}
		break;
		}
		/*ResultSet rs=st.executeQuery("select * from assessment where assessmentid="+aid+"");
		if(!rs.isBeforeFirst())
		{
			System.out.println("Assessment id not found");
			deleteAssessment(st);
		}*/
		//while(rs.next())
		//{
			//Assessment a=new Assessment(aid,rs.getString("assessmentname"),rs.getInt("topicid"));
			try
			{
			int rows=st.executeUpdate("delete from assessment where assessmentid="+a.getAssesmentid()+"");
			System.out.println(rows+" row(s) deleted successfully");
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input.Enter valid input");
				deleteAssessment(st);
			}
		//}
	}
	public void addQuestion(Statement st) throws SQLException
	{
		ArrayList<Assessment>assessmentList=viewAssessment(st);
		Scanner fc=new Scanner(System.in);
		System.out.println("Enter Question");
		String questions=fc.nextLine();
		System.out.println("Enter Option A");
		String optionA=fc.nextLine();
		System.out.println("Enter Option B");
		String optionB=fc.nextLine();
		System.out.println("Enter Option C");
		String optionC=fc.nextLine();
		System.out.println("Enter Option D");
		String optionD=fc.nextLine();
		System.out.println("Enter Answer");
		Character ans=fc.next().charAt(0);
		int assessmentId=0;
		while(true)
		{
		System.out.println("Enter Assessment ID");	
		try
		{
		assessmentId=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		int ctr=0;
		for(Assessment a:assessmentList)
		{
			if(a.getAssesmentid()==assessmentId)
			{
				ctr++;
			}
		}
		if(ctr==0)
		{
			System.out.println("Assessment id not found.Enter valid Assessment id");
			continue;
		}
		break;
		}
		try
		{
		Question question=new Question(questions,optionA,ans,assessmentId,optionB,optionC,optionD);
		st.executeQuery("insert into question values(questionseq.nextval,'"+question.getQuestion()+"','"+question.getOptionsA()+"','"+question.getAnswers()+"',"+question.getAssessmentId()+",'"+question.getOptionB()+"','"+question.getOptionC()+"','"+question.getOptionD()+"')");
		System.out.println("Question Inserted Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Assessment id not found");
			addQuestion(st);
		}
	}
	public void editQuestion(Statement st) throws SQLException, IOException 
	{
		Scanner fc=new Scanner(System.in);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Question>questionList=viewQuestions(st);
		System.out.println("Edit\n1.QUESTION "+"\n 2.OPTION A "+"\n 3. ANSWER "+"\n 4. ASSESSMENT ID "+"\n 5. OPTION B "+"\n 6. OPTION C "+"\n 7.OPTION D ");
		int choices=0;
		while(true)
		{
			try
			{
			choices=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number");
				continue;
			}
			break;
		}
		switch(choices)
		{
		case 1:
		{
			System.out.println("Enter Question id");
			
			int questionId=0;
			while(true)
			{
				try
				{
				questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				int ctr=0;
				for(Question q:questionList)
				{
					if(q.getQuestionId()==questionId)
					{
						ctr++;
					}
				}
				if(ctr==0)
				{
					System.out.println("Question Id not found");
					continue;
				}
				break;
			}
			fc.nextLine();
			String questions="";
			while(true)
			{
				System.out.println("Enter Question");
				try
				{
					questions=bf.readLine();
					ExceptionHandler.containsSpecialCharacters(questions);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question Id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question question=new Question(questions,rs.getString("optiona"),rs.getString("answer").charAt(0),rs.getInt("assessmentid"),rs.getString("optionb"),rs.getString("optionc"),rs.getString("optiond"));
				int rows=st.executeUpdate("update question set question='"+question.getQuestion()+"' where questionid="+question.getQuestionId()+"");
				System.out.println(rows+" rows updates");
				System.out.println("Question changed successfully");
			}
			break;
		}
		case 2:
		{
			System.out.println("Enter question id");
			int questionId=0;
			while(true)
			{
				try
				{
				questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				int ctr=0;
				for(Question q:questionList)
				{
					if(q.getQuestionId()==questionId)
					{
						ctr++;
					}
				}
				if(ctr==0)
				{
					System.out.println("Question id not found.Enter valid question id");
					continue;
				}
				break;
			}
			fc.nextLine();
			System.out.println("Enter option A");
			String optionA="";
			while(true)
			{
				try
				{
					optionA=bf.readLine();
					ExceptionHandler.containsSpecialCharacters(optionA);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question Id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question q=new Question(rs.getString("question"),optionA,rs.getString("answer").charAt(0),rs.getInt("assessmentid"),rs.getString("optionb"),rs.getString("optionc"),rs.getString("optionc"));
				int rows=st.executeUpdate("update question set optionA='"+q.getOptionsA()+"' where questionid="+questionId+"");
				System.out.println(rows+" rows Updated successfully");
			}
			break;
		}
		case 3:
		{
			System.out.println("Enter question id");
			int questionId=0;
			while(true)
			{
				try
				{
				questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			fc.nextLine();
			System.out.println("Enter Answer");
			Character ans="a".charAt(0);
			while(true)
			{
			ans=fc.next().charAt(0);
			try
			{
			ExceptionHandler.containsNumber(ans+"");
			ExceptionHandler.containsSpecialCharacters(ans+"");
			}
			catch(ContainsNumberException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question Id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question q=new Question(rs.getString("question"),rs.getString("optionA"),ans,rs.getInt("assessmentid"),rs.getString("optionb"),rs.getString("optionc"),rs.getString("optionc"));
				int rows=st.executeUpdate("update question set  answer='"+q.getAnswers()+"' where questionid="+questionId+"");
				System.out.println(rows+" rows Updated successfully");
			}
			break;
		}
		case 4:
		{
			System.out.println("Enter question id");
			int questionId=0;
			while(true)
			{
				try
				{
			questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
			break;
			}
			fc.nextLine();
			System.out.println("Enter Assessment id");
			int assessmentId=0;
			while(true)
			{
				try
				{
			assessmentId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question Id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question q=new Question(rs.getString("question"),rs.getString("optiona"),rs.getString("answer").charAt(0),assessmentId,rs.getString("optionb"),rs.getString("optionc"),rs.getString("optiond"));
				try
				{
				int rows=st.executeUpdate("update question set  assessmentid='"+q.getAssessmentId()+"' where questionid="+questionId+"");
				System.out.println(rows+" rows Updated successfully");
				}
				catch(Exception e)
				{
					System.out.println("Assessment Id not found");
				}
			}
			break;
		}
		case 5:
		{
			System.out.println("Enter question id");
			int questionId=0;
			while(true)
			{
				try
				{
				questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			fc.nextLine();
			System.out.println("Enter option B");
			String optionB="";//fc.nextLine();
			while(true)
			{
				optionB=bf.readLine();
				try
				{
					ExceptionHandler.containsSpecialCharacters(optionB);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question Id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question q=new Question(rs.getString("question"),rs.getString("optionA"),rs.getString("answer").charAt(0),rs.getInt("assessmentid"),optionB,rs.getString("optionc"),rs.getString("optiond"));
				int rows=st.executeUpdate("update question set optionB='"+q.getOptionB()+"' where questionid="+questionId+"");
				System.out.println(rows+" rows Updated successfully");
			}
			break;
		}
		case 6:
		{
			System.out.println("Enter question id");
			int questionId=0;
			while(true)
			{
				try
				{
				questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			fc.nextLine();
			System.out.println("Enter option C");
			String optionC="";
			while(true)
			{
				optionC=bf.readLine();
				try
				{
					ExceptionHandler.containsSpecialCharacters(optionC);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question Id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question q=new Question(rs.getString("question"),rs.getString("optionA"),rs.getString("answer").charAt(0),rs.getInt("assessmentid"),rs.getString("optionB"),optionC,rs.getString("optiond"));
				int rows=st.executeUpdate("update question set optionC='"+q.getOptionC()+"' where questionid="+questionId+"");
				System.out.println(rows+" rows Updated successfully");
			}
			break;
		}
		case 7:
		{
			System.out.println("Enter question id");
			int questionId=0;
			while(true)
			{
				try
				{
			questionId=Integer.parseInt(fc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			fc.nextLine();
			System.out.println("Enter option D");
			String optionD="";
			while(true)
			{
				optionD=bf.readLine();
				try
				{
				ExceptionHandler.containsSpecialCharacters(optionD);
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
			if(!rs.isBeforeFirst())
			{
				System.out.println("Question id not found");
				editQuestion(st);
			}
			while(rs.next())
			{
				Question q=new Question(rs.getString("question"),rs.getString("optionA"),rs.getString("answer").charAt(0),rs.getInt("assessmentid"),rs.getString("optionB"),rs.getString("optionC"),optionD);
				int rows=st.executeUpdate("update question set optionD='"+q.getOptionD()+"' where questionid="+questionId+"");
				System.out.println(rows+" rows Updated successfully");
			}
			break;
		}
		default :
		{
			System.out.println("Invalid option");
			editQuestion(st);
		}
		}
	}
	public  void deleteQuestion(Statement st) throws SQLException
	{
		Scanner fc=new Scanner(System.in);
		//System.out.println("Enter question id");
		int questionId=0;
		while(true)
		{
		System.out.println("Enter question id");
		try
		{
		questionId=Integer.parseInt(fc.next());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			continue;
		}
		break;
		}
		ResultSet rs=st.executeQuery("select * from question where questionid="+questionId+"");
		if(!rs.isBeforeFirst())
		{
			System.out.println("Question Id not found");
			deleteQuestion(st);
		}
		while(rs.next())
		{
			Question q=new Question(rs.getString("question"),rs.getString("optionA"),rs.getString("answer").charAt(0),rs.getInt("assessmentid"),rs.getString("optionB"),rs.getString("optionC"),rs.getString("optionD"));
			int rows=st.executeUpdate("delete from question where questionid="+questionId+"");
			System.out.println(rows+" rows Deleted successfully");
		}
	}
	public static  void viewStudents(Statement st) throws SQLException
	{
		Student student=new Student();
		ArrayList<Student> studentList=new ArrayList<Student>();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next())
		{
			student=new Student(rs.getInt("student_id"),rs.getString("name"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("major"));
			//System.out.println("Student Id "+rs.getInt("student_id")+" Student Name "+rs.getString("name")+" Student DOB "+rs.getString("DOB")+" Grade "+rs.getInt("grade")+" username "+rs.getString("username")+" password "+rs.getString("password")+" email "+rs.getString("email")+" ");
			studentList.add(student);
		}
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-15s | %-30s | %-30s | %-30s | %-30s | %-20s |%n ","Student Id","Student Name","Student Username","Student Password","Student Email","Student Major");
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		studentList.stream().sorted((x1,x2)->Integer.compare(x1.getStudentid(), x2.getStudentid())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-15s | %-30s | %-30s | %-30s | %-30s | %-20s |%n ",x.getStudentid(),x.getName(),x.getUsername(),x.getPassword(),x.getEmail(),x.getMajor()));
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

	}
	public ArrayList<Question> viewQuestions(Statement st) throws SQLException
	{
		Assessment assessment=new Assessment();
		Question question=new Question();
		ArrayList<Question> questionList=new ArrayList<Question>();
		ResultSet rs=st.executeQuery("select * from question");
		while(rs.next())
		{
			question=new Question(rs.getInt("questionId"),rs.getString("question"),rs.getString("optiona"),rs.getString("answer").charAt(0),rs.getInt("assessmentid"),rs.getString("optionb"),rs.getString("optionc"),rs.getString("optiond"));
			questionList.add(question);
			//System.out.println(question.toString());
		}
		System.out.printf("| %-10s | %-100s | %-50s | %-10s | %-15s | %-50s | %-50s | %-50s |%n","questionId","question","optiona","answer","assessmentid","optionb","optionc","optiond");
		questionList.stream().sorted((x1,x2)->Integer.compare(x1.getQuestionId(), x2.getQuestionId())).collect(Collectors.toList()).forEach((x)->System.out.printf("| %-10d | %-100s | %-50s | %-10s | %-15d | %-50s | %-50s | %-50s |%n",x.getQuestionId(),x.getQuestion(),x.getOptionsA(),x.getAnswers(),x.getAssessmentId(),x.getOptionB(),x.getOptionC(),x.getOptionD()));
		assessment.setQList(questionList);
		return assessment.getQList();
	}
	public void viewAnswers(Statement st) throws SQLException
	{
		Answer answer=new Answer();
		ArrayList<Answer> answerList=new ArrayList<Answer>(); 
		ResultSet rs=st.executeQuery("select * from answer");
		while(rs.next())
		{
			answer=new Answer(rs.getInt("answerid"),rs.getInt("studentid"),rs.getInt("questionid"),rs.getString("studentanswer").charAt(0),rs.getInt("assessmentid"));
			answerList.add(answer);
		}
		System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%n","Answer Id","StudentId","Question Id","Student Answer","Assessment Id");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		answerList.stream().sorted((x1,x2)->Integer.compare(x1.getAnswerId(), x2.getAnswerId())).collect(Collectors.toList()).forEach((x)->System.out.printf("|%-15d|%-15d|%-15d|%-15s|%-15d|%n",x.getAnswerId(),x.getStudentId(),x.getQuestionId(),x.getStudentAsnwer(),x.getAssessmentId()));
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
	}
	public void studentScores(Statement st) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter assessment Id");
		int aId=0;
		while(true)
		{
		try
		{
		aId=Integer.parseInt(sc.next());
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			continue;
		}
		break;
		}
		int score=0;
		int aid=0;
		ResultSet rs2=st.executeQuery("select * from assessment where assessmentid="+aId+"");
		ResultSet rs3=st.executeQuery("select a.studentid,s.name from answer a join student s on a.studentid=s.student_id;");
		if(!rs2.isBeforeFirst())
		{
			System.out.println("Assessment not found");
			studentScores(st);
		}
		while(rs2.next())
		{
			aid=rs2.getInt("assessmentid");
		}
	
		ResultSet rs1=st.executeQuery("SELECT a.ANSWERID, a.STUDENTID, a.QUESTIONID, a.STUDENTANSWER FROM answer a JOIN question q ON a.QUESTIONID = q.QUESTIONID WHERE a.STUDENTANSWER = q.ANSWER and q.assessmentid="+aid+" and a.studentid="+rs3.getInt("a.studentid")+"");
		while(rs1.next())
		{
			score++;
		}
		//System.out.println("Your Score is "+score);
		System.out.println("Id : "+rs3.getInt("studentid")+" Name : "+rs3.getString("name")+" Score : "+score);
		//score=0;
		//choices(student.getUsername(),student.getPassword(),st);
	}
}
