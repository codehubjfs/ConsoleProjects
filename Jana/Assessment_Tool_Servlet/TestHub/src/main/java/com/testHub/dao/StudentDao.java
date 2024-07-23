package com.testHub.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testHub.bean.Student;
import com.testHub.utilities.DbConnection;

public class StudentDao {
	

    private static final String INSERT_STUDENT_SQL = "INSERT INTO student (sid, email, password, fname, lname, gender, city, country) VALUES (StuSeq.nextval,?, ?, ?, ?, ?, ?,?)";
    private static final String UPDATE_STUDENT_SQL = "UPDATE student SET email = ?, fname = ?, lname = ?, gender = ?, city = ?, country = ? WHERE sid = ?";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM student WHERE sid = ?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM student order by sid desc";

    public StudentDao() {
    }

    

    public void insertStudent(Student student) throws Exception {
        try  {
        	Connection connection = DbConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
            preparedStatement.setString(1, student.getEmail());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getFname());
            preparedStatement.setString(4, student.getLname());
            preparedStatement.setString(5, student.getGender());
            preparedStatement.setString(6, student.getCity());
            preparedStatement.setString(7, student.getCountry());
            preparedStatement.executeUpdate();
            System.out.println("Inserted");
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error inserting student: " + e.getMessage());
        }
    }
    
    public void updateStudent(Student student) throws SQLException {
        try  {
        	Connection connection =DbConnection.openConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);
            preparedStatement.setString(1, student.getEmail());
            preparedStatement.setString(2, student.getFname());
            preparedStatement.setString(3, student.getLname());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getCity());
            preparedStatement.setString(6, student.getCountry());
            preparedStatement.setInt(7, student.getSid());
            preparedStatement.executeUpdate();
            System.out.println("updated");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteStudent(int sid) throws SQLException {
        try (Connection connection = DbConnection.openConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1, sid);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
        	Connection connection = DbConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String gender = rs.getString("gender");
                students.add(new Student(sid, email, password, fname, lname, city, country,gender));
                System.out.println(students.size()+"number of rows");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
