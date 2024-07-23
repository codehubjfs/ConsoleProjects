package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testHub.bean.Educator;
import com.testHub.utilities.DbConnection;

public class TeacherDAO {
	
	private static final String INSERT_TEACHER_SQL = "INSERT INTO educator (eid, email, password, fname, lname, gender, city, country) VALUES (EduSeq.nextval,?, ?, ?, ?, ?, ?,?)";
    private static final String UPDATE_TEACHER_SQL = "UPDATE educator SET email = ?, fname = ?, lname = ?, gender = ?, city = ?, country = ? WHERE eid = ?";
    private static final String DELETE_TEACHER_SQL = "DELETE FROM educator WHERE eid = ?";
    private static final String SELECT_ALL_educators = "SELECT * FROM educator order by eid desc";
    
    public TeacherDAO() {
    }
    
    Connection connection =DbConnection.openConnection();

    

    public void insertTeacher(Educator educator) throws Exception {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER_SQL);
            preparedStatement.setString(1, educator.getEmail());
            preparedStatement.setString(2, educator.getPassword());
            preparedStatement.setString(3, educator.getFname());
            preparedStatement.setString(4, educator.getLname());
            preparedStatement.setString(5, educator.getGender());
            preparedStatement.setString(6, educator.getCity());
            preparedStatement.setString(7, educator.getCountry());
            preparedStatement.executeUpdate();
            System.out.println("Inserted");
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error inserting TEACHER: " + e.getMessage());
        }
    }
    
    public void updateTeacher(Educator educator) throws SQLException {
        try  {
        	 
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEACHER_SQL);
            preparedStatement.setString(1, educator.getEmail());
            preparedStatement.setString(2, educator.getFname());
            preparedStatement.setString(3, educator.getLname());
            preparedStatement.setString(4, educator.getGender());
            preparedStatement.setString(5, educator.getCity());
            preparedStatement.setString(6, educator.getCountry());
            preparedStatement.setInt(7, educator.getEid());
            preparedStatement.executeUpdate();
            System.out.println("updated");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTeacher(int eid) throws SQLException {
        try  { 
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEACHER_SQL);
            preparedStatement.setInt(1, eid);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Educator> selectAllTeachers() {
        List<Educator> educators = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_educators);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int eid = rs.getInt("eid");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String gender = rs.getString("gender");
                educators.add(new Educator(eid, email, password, fname, lname, city, country,gender));
                System.out.println(educators.size()+"number of rows in teachers");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return educators;
    }


}
