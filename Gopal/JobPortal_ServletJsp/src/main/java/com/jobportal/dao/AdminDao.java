package com.jobportal.dao;







import com.jobportal.bean.Admin;
import com.jobportal.bean.JobSeekers;
import com.jobportal.database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Data Access Object (DAO) for Admin entity.
 */
public class AdminDao {

    // Method to authenticate admin login
	  private static final String UPDATE_ADMIN_SQL = "UPDATE admins SET name = ?, email = ?, password = ? WHERE ADMIN_ID = ?";
	    private static final String INSERT_ADMIN_SQL = "INSERT INTO admins (name, email, password) VALUES (?, ?, ?);";
	
		public List<JobSeekers> JobSeekers() throws ClassNotFoundException, SQLException {
			JobSeekers seeker =null;
		    ArrayList<JobSeekers> al = new ArrayList<>();
		    String query = "select * from job_seekers";
		    
		    try (Connection con = DbConnection.connectdatabase();
		         PreparedStatement pst = con.prepareStatement(query)) {
		        
		        ResultSet resultSet = pst.executeQuery();
		        
		        while (resultSet.next()) {
		            seeker = new JobSeekers();
		            seeker.setEmail(resultSet.getString("Email"));
		            seeker.setPhone(resultSet.getString("PHONENUMBER"));
		            seeker.setStatus(resultSet.getString("STATUS"));
		           
		            seeker.setName(resultSet.getString("FNAME"));
		            seeker.setDob(resultSet.getString("DATEOFBIRTH"));
		            seeker.setState(resultSet.getString("STATE"));
		            seeker.setDistrict(resultSet.getString("DISTRICT"));
		            seeker.setPincode(resultSet.getString("PINCODE"));
		            seeker.setGender(resultSet.getString("GENDER"));
		            seeker.setEduQualification(resultSet.getString("EDUCATION"));
		            seeker.setCourse(resultSet.getString("COURSE"));
		            seeker.setSpecialization(resultSet.getString("SPECIALIZATION"));
		            seeker.setPassingYear(resultSet.getString("PASSINGYEAR"));
		            seeker.setInstitute(resultSet.getString("INSTITUTE"));
		            seeker.setCgpa(resultSet.getString("CGPA"));
		            seeker.setTechnicalSkills(resultSet.getString("SKILLS"));
		            seeker.setCourseType(resultSet.getString("COURSETYPE"));
		            seeker.setYearsExperience(resultSet.getString("EXPERIENCE"));
		            seeker.setDesignation(resultSet.getString("DESIGNATION"));
		            seeker.setLanguage(resultSet.getString("LANGUAGE"));
		            seeker.setProficiencyRead(resultSet.getString("PROFICIENCYREAD"));
		            seeker.setProficiencyWrite(resultSet.getString("PROFICIENCYWRITE"));
		            seeker.setProficiencySpeak(resultSet.getString("PROFICIENCYSPEAK"));
		            seeker.setCertification(resultSet.getString("CERTIFICATION"));
		            seeker.setCertificationYear(resultSet.getString("CERTIFICATIONYEAR"));
		            seeker.setCertificationInstitute(resultSet.getString("CERTIFICATIONINSTITUTE"));
		            seeker.setObjective(resultSet.getString("OBJECTIVE"));
		          
		            
		            al.add(seeker);
		        }
		    }
		    
		    return al;
		}

		public Admin findAdminByEmail(String email)  {
	        String sql = "SELECT * FROM admins WHERE email = ?";
	        try (Connection conn = DbConnection.connectdatabase();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, email);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return mapRowToAdmin(rs);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        return null;
	    }

	    private Admin mapRowToAdmin(ResultSet rs) throws SQLException {
	        Admin admin = new Admin();
	        admin.setAdminId(rs.getInt("ADMIN_ID"));
	        admin.setName(rs.getString("name"));
	        admin.setEmail(rs.getString("email"));
	        admin.setPassword(rs.getString("password"));
//	        admin.setRole(rs.getString("role"));
//	        admin.setPhone(rs.getString("phone"));
	        return admin;
	    }

	
	
    public Admin login(String email, String password) throws Exception {
    	System.out.println("hi yyyyyyyyyy"+" "+email+" "+password);
        String query = "SELECT * FROM admins WHERE email = ? AND password = ?";
        try (Connection con = DbConnection.connectdatabase();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, email);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToAdmin(rs);
                } else {
                    return null;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    // Method to create a new admin
    public Admin createAdmin(Admin admin) throws Exception {
        String query = "INSERT INTO admins (ADMIN_ID ,name, email, password) VALUES (job_see_seq.NEXTVAL,?, ?, ?)";
        Connection con = DbConnection.connectdatabase();
             PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, admin.getName());
            pst.setString(2, admin.getEmail());
            pst.setString(3, admin.getPassword());

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted == 0) {
                throw new SQLException("Failed to create admin. No rows affected.");
            }
            return admin;
        } 
        
		
    
    public void updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {
   System.out.println(admin.getAdminId()+""+admin.getEmail()+""+admin.getPassword()+""+admin.getName());
        Connection connection = DbConnection.connectdatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMIN_SQL);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getEmail());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setInt(4, admin.getAdminId());
            preparedStatement.executeUpdate();
      
    }

    public void saveAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.connectdatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getEmail());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setString(4, "Admin");
            preparedStatement.executeUpdate();
            
            
        }
    }

    // Method to update admin password
    public void updatePassword(String email, String newPassword) throws Exception {
        String query = "UPDATE admins SET password = ? WHERE email = ?";
        try (Connection con = DbConnection.connectdatabase();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newPassword);
            pst.setString(2, email);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update password. No rows affected.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    // Method to change admin password based on old password
    public void changePassword(String email, String oldPassword, String newPassword) throws Exception {
        String query = "UPDATE admins SET password = ? WHERE email = ? AND password = ?";
        Connection con = DbConnection.connectdatabase();
             PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, newPassword);
            pst.setString(2, email);
            pst.setString(3, oldPassword);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to change password. Incorrect old password.");
            }
      
          
        }
    
    public  void updateJobStatus(int jobId ,int employee_Id,String status) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement statement = null;
		
		
			con =DbConnection.connectdatabase();
			String sql = "UPDATE jobs SET job_status = ? WHERE job_id = ? AND EMPLOYER_ID = ?";
			statement = con.prepareStatement(sql);


			statement.setString(1, status);
			statement.setInt(2, jobId);
			statement.setInt(3, employee_Id);

			int rowsUpdated = statement.executeUpdate();
			//System.out.println(rowsUpdated);

			
		
		}
	
    // Helper method to map ResultSet to Admin object
    private Admin mapResultSetToAdmin(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        admin.setAdminId(rs.getInt("ADMIN_ID"));
        admin.setName(rs.getString("name"));
        admin.setEmail(rs.getString("email"));
        admin.setPassword(rs.getString("password"));
        return admin;
    }
}
