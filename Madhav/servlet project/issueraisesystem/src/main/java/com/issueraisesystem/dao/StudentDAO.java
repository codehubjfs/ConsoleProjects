package com.issueraisesystem.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.*;
import com.issueraisesystem.util.*;
public class StudentDAO {
	
	public  List<StudentDetails> studentDetails() throws SQLException{
		String sql="select * from students";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		List<StudentDetails>list=new ArrayList<>();
		
		
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()) {
			StudentDetails student=new StudentDetails();
			student.setStudid(rs.getInt("stud_id"));
			student.setMailid(rs.getString("mailid"));
			student.setPassword(rs.getString("password"));
			student.setDepartment(rs.getString("department"));
			student.setRoomno(rs.getInt("roomno"));
			student.setBlockno(rs.getString("blockno"));
			student.setPhonenumber(rs.getString("phonenumber"));
//			student.setStudid(rs.getInt("issueid"));
			list.add(student);
			
		}
		return list;
		
		
		
	}
	public void addStudent(StudentDetails student) throws SQLException {
	    String sql = "INSERT INTO students VALUES (studentseq.nextval,?,?,?,?,?,?,?,?)";
	    PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	    
	    stmt.setString(1, student.getMailid());
	    stmt.setString(2, student.getPassword());
	    stmt.setString(3, student.getDepartment());
	    stmt.setInt(4, student.getRoomno());
	    stmt.setString(5, student.getBlockno());
	    stmt.setString(6, student.getPhonenumber());
	    stmt.setString(7,"Student");
	    stmt.setString(8, student.getName());
	   
	   
	    
	  
	    stmt.executeUpdate();
	}
	

	
public boolean isMailIdUnique(String mailid) throws SQLException {
		
		int check=0;
		String sql = "SELECT * FROM students WHERE mailid=?";
	    PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	   System.out.println("phone number");
	        stmt.setString(1, mailid);
	        ResultSet rs = stmt.executeQuery(); 
	            if (rs.next()) {
	            	
	                return true;
	            }
	        
	            
	    return false;
	}
	
	
	//count of students
	public int getStudentCount() throws SQLException {
        String sql = "SELECT * FROM students";
        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int count=0;
       
        while(rs.next()) {
        	count++;
        }
        
        return count; 
    }
	
	public boolean deleteStudent(String id) throws SQLException {
		String deleteQuery="delete from students where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(deleteQuery);
		stmt.setString(1, id);
		return stmt.executeUpdate()>0?true:false;
	}
	
	public List<StudentDetails>profileOverview(String mailid) throws SQLException{
		List<StudentDetails>profile=new ArrayList<>();
		String sql="select * from students where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1,mailid);
		ResultSet rs=stmt.executeQuery();
		StudentDetails student=new StudentDetails();
		if(rs.next()) {
			student.setName(rs.getString("name"));
			student.setMailid(rs.getString("mailid"));
			student.setPhonenumber(rs.getString("phonenumber"));
			profile.add(student);
		}
		return profile;
		
		
		
	}
	
	public  List<StudentDetails> getAllStudent() throws SQLException{
		String sql="select * from students";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		List<StudentDetails>list=new ArrayList<>();
		
		
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()) {
			StudentDetails student=new StudentDetails();
			student.setStudid(rs.getInt("stud_id"));
			student.setMailid(rs.getString("mailid"));
			student.setPassword(rs.getString("password"));
			student.setDepartment(rs.getString("department"));
			student.setRoomno(rs.getInt("roomno"));
			student.setBlockno(rs.getString("blockno"));
			student.setPhonenumber(rs.getString("phonenumber"));
			student.setName(rs.getString("name"));

			list.add(student);
			
		}
		return list;
		
		
		
	}
	
	
	//ADMIN could access
	public void editStudent(StudentDetails student) throws SQLException {
		System.out.print("editdatabase");
		String sql="update students set name=?,roomno=?,blockno=? where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1,student.getName());
		stmt.setInt(2,student.getRoomno());
		stmt.setString(3,student.getBlockno());
		stmt.setString(4,student.getMailid());
		stmt.executeUpdate();
		
	}
	
	//Warden
	
	public void editRoom(StudentDetails student) throws SQLException {
		System.out.print("editroomdatabase");
		String sql="update students set roomno=?,blockno=? where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		
		stmt.setInt(1,student.getRoomno());
		stmt.setString(2,student.getBlockno());
		stmt.setString(3,student.getMailid());
		stmt.executeUpdate();
		
	}
	
	
	
	
	public void editProfile(StudentDetails student,String mailid) throws SQLException {
		System.out.print("editdatabase");
		String sql="update students set name=?,phonenumber=? where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1,student.getName());
		stmt.setString(2,student.getPhonenumber());
		
		stmt.setString(3,mailid);
		stmt.executeUpdate();
		
	}
	
	

}
