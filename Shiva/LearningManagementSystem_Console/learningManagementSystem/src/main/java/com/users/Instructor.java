package com.users;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.courses.Content;
import com.courses.Courses;
import com.courses.Module;
import com.courses.Topic;
import com.exceptions.ExceptionHandler;
import com.exceptions.InvalidFileException;
import com.exceptions.SpecialCharacterException;
public class Instructor {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String department;
	private int courseId;
	public Instructor(int id, String username, String password, String email, int courseId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.courseId = courseId;
	}
	public Instructor(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Instructor(int id, String firstname,String lastname,String department,String username, String password, String email ,int courseId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.courseId = courseId;
		this.firstname=firstname;
		this.lastname=lastname;
		this.department=department;
	}
	public Instructor()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "instructor [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getEmail()=" + getEmail() + "]";
	}
	public ArrayList<Courses> viewCourses(Statement st,Instructor instructor) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from courses where instructorid="+instructor.getId()+"");
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
		System.out.printf("| %-15s| %-10s | %-10s | %-30s |%n","instructorid","username","password","email");
		System.out.println("-----------------------------------------------------------------------------+");
		instructorList.stream().filter((x)->x.getUsername()!=null).sorted((x1,x2)->Integer.compare(x1.getId(), x2.getId())).forEach((x)->System.out.printf("|  %1d| %-10s | %-10s | %-30s |%n",x.getId(),x.getUsername(),x.getPassword(),x.getEmail()));
		System.out.println("-----------------------------------------------------------------------------+");
		return instructorList;
	}
	public ArrayList<Module> viewModules(Statement st,Instructor instructor) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from module where instructorid="+instructor.getId()+"");
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
	public void addModule(Statement st,Instructor instructor) throws IOException, SQLException
	{
		System.out.println("Courses Table");
		ArrayList<Courses>courseList=viewCourses(st,instructor);
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
		Module module=new Module(moduleName,instructor.getId(),courseid);
		
		try {
			st.executeQuery("insert into module values(moduleseq.nextval,'"+module.getModuleName()+"',"+module.getInstructorId()+","+module.getCourseId()+")");
			System.out.println("Module Insertion Successfully Executed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid input .Enter valid input");
			addModule( st,instructor);
		}
	}
	public void editModule(Statement st,Instructor instructor) throws SQLException, IOException
	{
		ArrayList<Courses>course=viewCourses(st,instructor);
		ArrayList<Instructor>instructors=viewInstructors(st);
		ArrayList<Module>moduleList=viewModules(st,instructor);
		System.out.println("Edit\n1.ModuleName\n2.instructorId\n3.Back");
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
					editModule(st,instructor);
				}
				viewModules(st,instructor);
			//} 
			
			break;
		}
		case 2:
		{
			Module module=new Module();
			//Instructor instructor=new Instructor();
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
				System.out.println("Module id not found");
				continue;
			}
			break;
			}
			module=new Module(module.getModuleId(),module.getModuleName(),instructorId,moduleId);
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
					editModule(st,instructor);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Instructor Id not Found");
					editModule(st,instructor);
				}
			//} 
				viewModules(st,instructor);
			break;
		}
		
		case 3:
		{
			break;
		}
		default:
		{
			editModule(st,instructor);
		}
		}
	}
	public void deleteModule(Statement st,Instructor instructor) throws SQLException
	{
		ArrayList<Module>moduleList=viewModules(st,instructor);
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
				deleteModule(st,instructor);
			}
			}
			catch(Exception e)
			{
				System.out.println("Module id not Found");
				deleteModule(st,instructor);
			}
			break;
		}
		case 2:
		{
			break;
		}
		default:
			System.out.println("Enter valid number");
			deleteModule(st,instructor);
			break;
		}
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
		Scanner sc=new Scanner(System.in);
		//System.out.println("Topic Table");
		//ArrayList<Topic>topicList=viewTopic(st);
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
	public void instructorChoices(Statement st,Instructor instructor) throws SQLException, IOException, SpecialCharacterException
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			int flg=0;
		System.out.println("Enter \n1.View Courses\n2.Module Management\n3.Content Management\n4.Back");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			viewCourses(st,instructor);
			break;
		}
		case 2:
		{
			System.out.println("Enter\n1.Add Modules\n2.Edit Module\n3.Delete Module\n4.Back");
			int ch=0;
			while(true)
			{
				System.out.println("Enter your choice");
				try
				{
				ch=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			
			switch(ch)
			{
			case 1:
			{
				addModule(st,instructor);
				instructorChoices(st,instructor);
				break;
			}
			case 2:
			{
				editModule(st,instructor);
				instructorChoices(st,instructor);

				break;
			}
			case 3:
			{
				deleteModule(st,instructor);
				instructorChoices(st,instructor);

				break;
			}
			case 4:
			{
				instructorChoices(st,instructor);
				break;
			}
			}
			
			
			break;
		}
		case 3:
		{
			System.out.println("Enter\n1.Add Content\n2.Edit Content\n3.Delete Content\n4.back");
			int ch=0;
			while(true)
			{
				try
				{
				ch=Integer.parseInt(sc.next());
				}
				catch(Exception e)
				{
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}
			switch(ch)
			{
			case 1:
			{
				addContent(st);
				break;
			}
			case 2:
			{
				editContent(st);
				break;
			}
			case 3:
			{
				deleteContent(st);
				break;
			}
			case 4:
			{
				break;
			}
			}
			break;
		}
		case 4:
		{
			flg++;
			System.out.println("Successfully logged out");
			break;
		}
		default:
		{
			instructorChoices(st,instructor);
			break;
		}
	}
		if(flg>0)
		{
			break;
		}
		}
		}
}
