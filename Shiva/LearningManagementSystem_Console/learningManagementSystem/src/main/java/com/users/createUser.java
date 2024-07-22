package com.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.courses.Courses;
import com.courses.nonIntegerException;
import com.exceptions.ContainsNumberException;
import com.exceptions.ExceptionHandler;
import com.exceptions.exceptionHandlers;
import com.exceptions.InvalidEmailException;
import com.exceptions.InvalidPasswordException;
import com.exceptions.IsNumberException;
import com.exceptions.LengthException;
import com.exceptions.NotIntegerException;
import com.exceptions.SpecialCharacterException;

public class createUser {
	public static void createUser(Statement st) throws SQLException, NotIntegerException, IOException
	{
		System.out.println("Courses Table");
		Admin admin=new Admin();
		ArrayList<Courses>courseList=admin.viewCourse(st);
		System.out.println("Instructor Table");
		ArrayList<Instructor>instructorList=admin.viewInstructors(st);
		Scanner sc=new Scanner(System.in);
		System.out.println("Create user for admin,instructor,student\n1.Admin\n2.Instructor\n3.Student\n4.Back");
		int choice2=sc.nextInt();
		switch(choice2)
		{
		case 1:
		{
			System.out.println("Enter username");
			String username1="";
			while(true)
			{
				try
				{
			username1=sc.next();
			ExceptionHandler.containsSpecialCharacters(username1);
			ExceptionHandler.isLengthEnough(username1);
			ExceptionHandler.isNumber(username1);
				}
				catch(IsNumberException e)
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
					continue;
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			System.out.println("Enter password");
			String password1=sc.next();
			while(true)
			{
				try
				{
				ExceptionHandler.isLengthEnough(password1);
				ExceptionHandler.passwordValidation(password1);
				}
				catch(LengthException e)
				{
					System.out.println(e.getMessage());
				}
				catch(InvalidPasswordException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			st.executeUpdate("insert into admin(username,password) values('"+username1+"','"+password1+"')");
			System.out.println("Admin User created successfully");
			break;
		}
		case 2:
		{
			System.out.println("Hi");
			//System.out.println("Enter instructorid");
			//int instructorid=sc.nextInt();
			Scanner fc=new Scanner(System.in);
			System.out.println("Enter FirstName");
			String firstname="";
			while(true)
			{
			firstname=fc.next();
			try
			{
				ExceptionHandler.containsNumber(firstname);
				ExceptionHandler.containsSpecialCharacters(firstname);
			}
			catch(ContainsNumberException e)
			{
				System.out.println("Do not Enter number");
				continue;
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
			}
			System.out.println("Enter last name");
			String lastname="";
			while(true)
			{
			lastname=fc.next();
			try
			{
				ExceptionHandler.containsNumber(lastname);
				ExceptionHandler.containsSpecialCharacters(lastname);
			}
			catch(ContainsNumberException e)
			{
				System.out.println("Do not Enter number");
				continue;
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
			}
			fc.nextLine();
			String email="";
			while(true)
			{
			System.out.println("Enter email");
			email=fc.next();
			try
			{
			ExceptionHandler.isValidEmail(email);
			}
			catch(InvalidEmailException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
			}
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter department");
			String department="";
			while(true)
			{
			try
			{
			department=bf.readLine();
			ExceptionHandler.isLengthEnough(department);
			ExceptionHandler.containsNumber(department);
			ExceptionHandler.containsSpecialCharacters(department);
			}
			catch(ContainsNumberException e)
			{
				System.out.println("Do not Enter Number");
				continue;
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
			break;
			}
			String username1="";
			while(true)
			{
				System.out.println("Enter username");
				username1=fc.next();
				try
				{
					ExceptionHandler.isLengthEnough(username1);
					ExceptionHandler.containsSpecialCharacters(username1);
					ExceptionHandler.isNumber(username1);
				}
				catch(LengthException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(IsNumberException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(Exception e)
				{
					System.out.println("Enter valid username");
					continue;
				}
				break;
			}
			String password1="";
			while(true)
			{
				try
				{
			System.out.println("Enter password");
			password1=fc.next();
			ExceptionHandler.isLengthEnough(password1);
			ExceptionHandler.containsSpecialCharacters(password1);
				}
				catch(LengthException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(SpecialCharacterException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				catch(Exception e)
				{
					System.out.println("Password Invalid.\nEnter Valid Password");
					continue;
				}
				break;
			}
			int courseid=0;
			while(true)
			{
				System.out.println("Enter Course id");
				try
				{
				courseid=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				int ctr=0;
				for(Courses c:courseList)
				{
					if(c.getCourseID()==courseid)
					{
						ctr++;
					}
				}
				if(ctr==0)
				{
					System.out.println("course id not found.Enter valid course id");
					continue;
				}
				break;
			}
			st.executeUpdate("insert into instructor(instructorid,firstname,lastname,email,department,username,password,courseid) values(instructorseq.nextval,'"+firstname+"','"+lastname+"','"+email+"','"+department+"','"+username1+"','"+password1+"',"+courseid+")");
			System.out.println("User created successfully");
			break;
		}
		case 3:
		{
			Scanner fc=new Scanner(System.in);
			//System.out.println("Enter Student id");
			//int student_id=fc.nextInt();
			//fc.nextLine();
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			String name="";
			while(true)
			{
			System.out.println("Enter Name");
			name=bf.readLine();
			try
			{
				ExceptionHandler.isLengthEnough(name);
				ExceptionHandler.containsSpecialCharacters(name);
				ExceptionHandler.isNumber(name);
			}
			catch(LengthException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(IsNumberException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(Exception e)
			{
				System.out.println("Enter valid Name");
				continue;
			}
			break;
			}
			System.out.println("Enter DOB");
			String dob=fc.next();
			int grade=0;
			while(true)
			{
			System.out.println("Enter grade between 1 to 10");
			try
			{
			grade=Integer.parseInt(fc.next());
			}
			catch(Exception e)
			{
				System.out.println("Enter valid Number 1 to 10");
				continue;
			}
			break;
			}
			fc.nextLine();
			String username1="";
			while(true)
			{
				System.out.println("Enter username");
			try
			{
			username1=fc.next();
			ExceptionHandler.containsSpecialCharacters(username1);
			ExceptionHandler.isNumber(username1);
			}
			catch(SpecialCharacterException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(IsNumberException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(Exception e)
			{
				System.out.println("Enter valid input");
				continue;
			}
			break;
			}
			String password1="";
			while(true)
			{
				System.out.println("Enter pasword");
				try
				{
				password1=fc.next();
				ExceptionHandler.passwordValidation(password1);
				}
				catch(InvalidPasswordException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
				break;
			}
			String email="";
			while(true)
			{
			System.out.println("Enter email");
			email=fc.next();
			try
			{
				ExceptionHandler.isValidEmail(email);;
			}
			catch(InvalidEmailException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
			}
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
			}
			int ctr=0;
			for(Courses c:courseList)
			{
				if(c.getCourseID()==courseId)
				{
					ctr++;
				}
			}
			if(ctr==0)
			{
				System.out.println("Course id not found.Enter valid Course ID");
				continue;
			}
			break;
			}
			fc.nextLine();
			String major="";
			while(true)
			{
			System.out.println("Enter Major");
			major=bf.readLine();
			try
			{
			ExceptionHandler.isNumber(major);
			ExceptionHandler.isLengthEnough(major);
			}
			catch(IsNumberException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(LengthException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			break;
			}
			st.executeUpdate("insert into student(student_id,name,dob,grade,username,password,email,courseid,major) values(studentseq.nextval,'"+name+"','"+dob+"',"+grade+",'"+username1+"','"+password1+"','"+email+"',"+courseId+",'"+major+"')");
			System.out.println("User created successfully");
			break;
		}
		case 4:
		{
			break;
		}
		default:
		{
			System.out.println("Enter valid choice");
			createUser(st);
		}
		}
	}
}
