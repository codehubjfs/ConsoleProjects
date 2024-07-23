package com.jobportal.dao;





import com.jobportal.bean.JobSeekers;
import com.jobportal.database.DbConnection;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object (DAO) for Admin entity.
 */
public class JobsSeekersDao {

    // Method to authenticate admin login
    public JobSeekers login(String email, String password) throws Exception {
    	System.out.println("hi job Seekers "+" "+email+" "+password);
        String query = "SELECT * FROM job_seekers WHERE email = ? AND password = ?";
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
   
    public JobSeekers createSeeker(JobSeekers seeker) throws Exception {
        String queryCheck = "SELECT COUNT(*) FROM job_seekers WHERE EMAIL = ?";
        String queryInsert = "INSERT INTO job_seekers (JOB_SEEKER_ID, FNAME, EMAIL, PASSWORD, PHONENUMBER) VALUES (job_see_seq.NEXTVAL, ?, ?, ?, ?)";
        
        try (Connection con = DbConnection.connectdatabase();
             PreparedStatement pstCheck = con.prepareStatement(queryCheck);
             PreparedStatement pstInsert = con.prepareStatement(queryInsert)) {
             
            // Check if the email already exists
            pstCheck.setString(1, seeker.getEmail());
            ResultSet rs = pstCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
            	return null;
            }
          
            // Insert the new record
            pstInsert.setString(1, seeker.getName());
            pstInsert.setString(2, seeker.getEmail());
            pstInsert.setString(3, seeker.getPassword());
            pstInsert.setString(4, seeker.getPhone());
            
            int rowsInserted = pstInsert.executeUpdate();
            if (rowsInserted == 0) {
                throw new SQLException("Failed to create job seeker. No rows affected.");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return seeker;
    }

    // Method to create a new admin
//    public JobSeekers createSeeker(JobSeekers seeker) throws Exception {
//        String query = "INSERT INTO job_seekers (JOB_SEEKER_ID, FNAME, EMAIL,PASSWORD, PHONENUMBER) VALUES (job_see_seq.NEXTVAL, ?, ?, ?, ?)";
//        try (Connection con = DbConnection.connectdatabase();
//             PreparedStatement pst = con.prepareStatement(query)) {
//
//            pst.setString(1, seeker.getName());
//            pst.setString(2, seeker.getEmail());
//            pst.setString(3, seeker.getPassword());
//            pst.setString(4, seeker.getPhone());
//            int rowsInserted = pst.executeUpdate();
//            if (rowsInserted == 0) {
//                throw new SQLException("Failed to create admin. No rows affected.");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        }
//		return seeker;
//    }

//    public static void registerJobSeeker( JobSeekers jobseeker) throws SQLException, ClassNotFoundException {
//    	Connection con = null;
//        PreparedStatement statement = null;
//		try {
//			 con = DbConnection.connectdatabase();
//			 String sql = "INSERT INTO Job_Seekers (JOB_SEEKER_ID,USERNAME,PASSWORD, EMAIL) VALUES (job_see_seq.NEXTVAL, ?, ?, ?)";
//			 statement = con.prepareStatement(sql);
//		     statement.setString(1, jobseeker.getName());
//	         statement.setString(2, jobseeker.getPassword());
//	         statement.setString(3, jobseeker.getEmail());
//	         int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//				System.out.println(ConsoleColors.GREEN+"Your registered successfully."+ConsoleColors.RESET);
//			} else {
//				System.out.println(ConsoleColors.RED+"Failed to register job seeker."+ConsoleColors.RESET);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
    
    
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
    public boolean updateStatus(String email, String status) throws Exception {
        String query = "UPDATE job_seekers SET status = ? WHERE email = ?";
        Connection con = DbConnection.connectdatabase();
        PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, status);
            pst.setString(2, email);
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        }
    	   
	   
   
    // Method to change admin password based on old password
    public void changePassword(String email, String oldPassword, String newPassword) throws Exception {
        String query = "UPDATE Job_Seekers SET password = ? WHERE email = ? AND password = ?";
        try (Connection con = DbConnection.connectdatabase();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newPassword);
            pst.setString(2, email);
            pst.setString(3, oldPassword);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to change password. Incorrect old password.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public JobSeekers updateSeeker(JobSeekers seeker, String email) throws ClassNotFoundException {
        String query = 
            "UPDATE job_Seekers SET " +
            "FNAME = ?, DATEOFBIRTH = ?, STATE = ?, DISTRICT = ?, PINCODE = ?, GENDER = ?, EDUCATION = ?, " +
            "COURSE = ?, SPECIALIZATION = ?, PASSINGYEAR = ?, INSTITUTE = ?, CGPA = ?, COURSETYPE = ?, " +
            "EXPERIENCE = ?, DESIGNATION = ?, LANGUAGE = ?, PROFICIENCYREAD = ?, PROFICIENCYWRITE = ?, " +
            "PROFICIENCYSPEAK = ?, CERTIFICATION = ?, CERTIFICATIONYEAR = ?, CERTIFICATIONINSTITUTE = ? " +
            "WHERE email= ?";
        System.out.println("Welcome retriver");
        try (Connection con = DbConnection.connectdatabase();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, seeker.getName());
            preparedStatement.setString(2, seeker.getDob());
            preparedStatement.setString(3, seeker.getState());
            preparedStatement.setString(4, seeker.getDistrict());
            preparedStatement.setString(5, seeker.getPincode());
            preparedStatement.setString(6, seeker.getGender());
            preparedStatement.setString(7, seeker.getEduQualification());
            preparedStatement.setString(8, seeker.getCourse());
            preparedStatement.setString(9, seeker.getSpecialization());
            preparedStatement.setString(10, seeker.getPassingYear());
            preparedStatement.setString(11, seeker.getInstitute());
            preparedStatement.setString(12, seeker.getCgpa());
            preparedStatement.setString(13, seeker.getCourseType());
            preparedStatement.setString(14, seeker.getYearsExperience());
            preparedStatement.setString(15, seeker.getDesignation());
            preparedStatement.setString(16, seeker.getLanguage());
            preparedStatement.setString(17, seeker.getProficiencyRead());
            preparedStatement.setString(18, seeker.getProficiencyWrite());
            preparedStatement.setString(19, seeker.getProficiencySpeak());
            preparedStatement.setString(20, seeker.getCertification());
            preparedStatement.setString(21, seeker.getCertificationYear());
            preparedStatement.setString(22, seeker.getCertificationInstitute());
            preparedStatement.setString(23, email);
//           System.out.printl);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or log the exception appropriately
            return null; // Consider returning null if there's an exception
        }
        return seeker;
    }

    public JobSeekers retrieveSeeker(String email) throws ClassNotFoundException {
        String query = "SELECT FNAME, DATEOFBIRTH, STATE, DISTRICT, PINCODE, GENDER, EDUCATION, COURSE, " +
                       "SPECIALIZATION, PASSINGYEAR, INSTITUTE, CGPA, COURSETYPE, EXPERIENCE, DESIGNATION, " +
                       "LANGUAGE, PROFICIENCYREAD, PROFICIENCYWRITE, PROFICIENCYSPEAK, CERTIFICATION, " +
                       "CERTIFICATIONYEAR, CERTIFICATIONINSTITUTE FROM job_Seekers WHERE email = ?";
        
        JobSeekers seeker = null;
        
        try (Connection con = DbConnection.connectdatabase();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                seeker = new JobSeekers();
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
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or log the exception appropriately
            return null; // Consider returning null if there's an exception
        }
		return seeker;
        
       
    }


    // Delete seeker
    
//    public void deleteseeker(int id) {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_JOB_APPLICATION_SQL)) {
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }

    public JobSeekers forgetPassword(JobSeekers seeker) {
    	String query ="select * from job_seekers where email = ?";
    	
    	Connection con =null;
    	try {
    	     con =DbConnection.connectdatabase();
    	     PreparedStatement pst = con.prepareStatement(query);
    	     pst.setString(1, seeker.getEmail());
    	    ResultSet rs = pst.executeQuery();
    	    
    	    if (rs.next() && rs.getInt(1) > 0) {
            	return seeker;
            }
    	    
    	    else {
    	    	
    	    	return null;
    	    }	
    	    
    	
		
    	}
    	catch(Exception e) {
    		
    	}
		return null;
		
    	
    }
    // Helper method to map ResultSet to Admin object
    private JobSeekers mapResultSetToAdmin(ResultSet rs) throws SQLException {
        JobSeekers seekers = new JobSeekers();
//        admin.setName(rs.getString("name"));
        seekers.setName(rs.getString("FNAME"));
        seekers.setSeeker_id(rs.getInt("JOB_SEEKER_ID"));
        seekers.setEmail(rs.getString("email"));
        seekers.setPassword(rs.getString("password"));
       seekers.setGender(rs.getString("gender"));
        return seekers;
    }

	
//    public JobSeekers addJobSeeker(String email,JobSeekers jobSeeker) throws ClassNotFoundException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        
//        try {
//            conn = DbConnection.connectdatabase(); // Get a connection to the database
//            String sql = "UPDATE job_seekers SET 	DOB=?, GENDER=?, ADDRESS=?, 	COURSE=?, SPECIALIZATION=?, INSTITUTE=?, 	PASSINGYEAR=?, 	CGPA=?, COMPANY_NAME=?, EXPERIENCE=?, DESIGNATION=?, 	RESUME=? " +
//                         "WHERE email=?";
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, jobSeeker.getDob());
//            stmt.setString(2, jobSeeker.getGender());
//            stmt.setString(3, jobSeeker.getAddress());
//            stmt.setString(4, jobSeeker.getCourse());
//            stmt.setString(5, jobSeeker.getSpecialization());
//            stmt.setString(6, jobSeeker.getInstitute());
//            stmt.setString(7, jobSeeker.getPassingYear());
//            stmt.setString(8, jobSeeker.getCgpa());
//            stmt.setString(9, jobSeeker.getCompanyName());
//            stmt.setString(10, jobSeeker.getYearsExperience());
//            stmt.setString(11, jobSeeker.getDesignation());
//            stmt.setString(12, jobSeeker.getResumeFileName());
//            stmt.setString(13, email); // Assuming email uniquely identifies the job seeker
//            
//            stmt.executeUpdate(); // Execute the SQL statement
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle SQL exceptions
//            return null;
//        }
//		return jobSeeker; 
//    }
    public boolean updateJobSeekerResumeAndDOB(String email,JobSeekers jobSeeker, InputStream resumeStream, long resumeLength) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DbConnection.connectdatabase(); // Get a connection to the database
//            String sql = "UPDATE job_seekers SET DOB=?, RESUME=? WHERE EMAIL=?";
            
            String sql = "UPDATE job_seekers SET 	DOB=?, GENDER=?, ADDRESS=?, 	COURSE=?, SPECIALIZATION=?, INSTITUTE=?, 	PASSINGYEAR=?, 	CGPA=?, COMPANY_NAME=?, EXPERIENCE=?, DESIGNATION=?, 	RESUME=? " +
                         "WHERE email=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, jobSeeker.getDob());
            stmt.setString(2, jobSeeker.getGender());
            stmt.setString(3, jobSeeker.getAddress());
            stmt.setString(4, jobSeeker.getCourse());
            stmt.setString(5, jobSeeker.getSpecialization());
            stmt.setString(6, jobSeeker.getInstitute());
            stmt.setString(7, jobSeeker.getPassingYear());
            stmt.setString(8, jobSeeker.getCgpa());
            stmt.setString(9, jobSeeker.getCompanyName());
            stmt.setString(10, jobSeeker.getYearsExperience());
            stmt.setString(11, jobSeeker.getDesignation());
            stmt.setBinaryStream(12, resumeStream, resumeLength);
            stmt.setString(13, email); // Assuming email uniquely identifies the job seeker
            // Set values in PreparedStatement
//            stmt.setString(1, dob); // Assuming DOB is a String in the correct format
//            stmt.setBinaryStream(2, resumeStream, resumeLength); // Handling resume file upload
//            stmt.setString(3, email); // Assuming email uniquely identifies the job seeker
//            
            int rowsUpdated = stmt.executeUpdate(); // Execute the SQL statement
            
            return rowsUpdated > 0; // Return true if rows were updated, false otherwise
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exceptions
            return false;
        } finally {
            // Close resources in finally block
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    public boolean updateJobSeekerDetails(int id, JobSeekers jobSeeker, InputStream resumeStream, long resumeLength) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        System.out.println(id);
        try {
            conn = DbConnection.connectdatabase(); // Get a connection to the database
System.out.println("welcome1");
            String sql = "UPDATE job_seekers SET FNAME=?, COURSETYPE=?, OBJECTIVE=?, EMAIL=?, CONTACT_DETAILS=?, DOB=?, GENDER=?, ADDRESS=?, COURSE=?, SPECIALIZATION=?, INSTITUTE=?, PASSINGYEAR=?, CGPA=?, COMPANY_NAME=?, EXPERIENCE=?, DESIGNATION=?, RESUME=? " +
                         "WHERE JOB_SEEKER_ID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, jobSeeker.getName());
            stmt.setString(2, jobSeeker.getCourseType());
            stmt.setString(3, jobSeeker.getObjective());
            stmt.setString(4, jobSeeker.getEmail());
            stmt.setString(5, jobSeeker.getPhone());
            stmt.setString(6, jobSeeker.getDob());
            stmt.setString(7, jobSeeker.getGender());
            stmt.setString(8, jobSeeker.getAddress());
            stmt.setString(9, jobSeeker.getCourse());
            stmt.setString(10, jobSeeker.getSpecialization());
            stmt.setString(11, jobSeeker.getInstitute());
            stmt.setString(12, jobSeeker.getPassingYear());
            stmt.setString(13, jobSeeker.getCgpa());
            stmt.setString(14, jobSeeker.getCompanyName());
            stmt.setString(15, jobSeeker.getYearsExperience());
            stmt.setString(16, jobSeeker.getDesignation());
            stmt.setBinaryStream(17, resumeStream, resumeLength);
            stmt.setInt(18, id); // Assuming ID uniquely identifies the job seeker

            int rowsUpdated = stmt.executeUpdate(); // Execute the SQL statement

            return rowsUpdated > 0; // Return true if rows were updated, false otherwise
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("welcom2");
            // Handle SQL exceptions
            return false;
        } finally {
            // Close resources in finally block
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public JobSeekers getJobSeekerDetails(int id) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DbConnection.connectdatabase(); // Get a connection to the database

            String sql = "SELECT * FROM job_seekers WHERE JOB_SEEKER_ID	=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery(); // Execute the SQL query
            
            if (rs.next()) {
                JobSeekers jobSeeker = new JobSeekers();
                jobSeeker.setName(rs.getString("FNAME"));
                jobSeeker.setCourseType(rs.getString("COURSETYPE"));
                jobSeeker.setObjective(rs.getString("OBJECTIVE"));
                jobSeeker.setEmail(rs.getString("EMAIL"));
                jobSeeker.setPhone (rs.getString("PHONENUMBER"));                   
                jobSeeker.setDob(rs.getString("DOB"));
                jobSeeker.setGender(rs.getString("GENDER"));
                jobSeeker.setAddress(rs.getString("ADDRESS"));
                jobSeeker.setCourse(rs.getString("COURSE"));
                jobSeeker.setSpecialization(rs.getString("SPECIALIZATION"));
                jobSeeker.setInstitute(rs.getString("INSTITUTE"));
                jobSeeker.setPassingYear(rs.getString("PASSINGYEAR"));
                jobSeeker.setCgpa(rs.getString("CGPA"));
                jobSeeker.setCompanyName(rs.getString("COMPANY_NAME"));
                jobSeeker.setYearsExperience(rs.getString("EXPERIENCE"));
                jobSeeker.setDesignation(rs.getString("DESIGNATION"));
                Blob resumeBlob = rs.getBlob("RESUME");
                if (resumeBlob != null) {
                    jobSeeker.setResume(resumeBlob.getBytes(1, (int) resumeBlob.length()));
                }
                
                return jobSeeker;
            } else {
                return null; // No job seeker found with the given ID
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exceptions
            return null;
        } finally {
            // Close resources in finally block
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    
    public byte[] getResumeByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        byte[] resume = null;

        try {
            conn = DbConnection.connectdatabase();
            String sql = "SELECT RESUME FROM job_seekers WHERE EMAIL = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                resume = rs.getBytes("RESUME");
            }
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return resume;
    }

    public JobSeekers getJobSeekerByEmail(String email) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JobSeekers jobSeeker = null;
        
        try {
            conn = DbConnection.connectdatabase(); // Get a connection to the database
            
            String sql = "SELECT * FROM job_seekers WHERE email=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            
            rs = stmt.executeQuery();
            
            // If a record is found, populate the JobSeekers object
            if (rs.next()) {
                jobSeeker = new JobSeekers();
//                jobSeeker.setEmail(rs.getString("email"));
                jobSeeker.setName(rs.getString("FNAME"));
                jobSeeker.setDob(rs.getString("dob"));
                jobSeeker.setAddress(rs.getString("ADDRESS"));
                jobSeeker.setPhone(rs.getString("CONTACT_DETAILS"));
                jobSeeker.setEmail(rs.getString("email"));
                jobSeeker.setGender(rs.getString("gender"));
                jobSeeker.setAddress(rs.getString("address"));
                jobSeeker.setCourse(rs.getString("course"));
                jobSeeker.setSpecialization(rs.getString("specialization"));
                jobSeeker.setInstitute(rs.getString("institute"));
                jobSeeker.setPassingYear(rs.getString("PASSINGYEAR"));
                jobSeeker.setCourseType(rs.getString("COURSETYPE"));
                jobSeeker.setCgpa(rs.getString("cgpa"));
                jobSeeker.setObjective(rs.getString("OBJECTIVE"));
//                System.out.println(rs.getString("OBJECTIVE")+"hi");
//                jobSeeker.setCompanyName(rs.getString("COMPANY_NAME"));
                jobSeeker.setCompanyName(rs.getString("company_name"));
                jobSeeker.setYearsExperience(rs.getString("experience"));
                jobSeeker.setDesignation(rs.getString("designation"));
                // Assuming resume is stored as binary data in the database
                // jobSeeker.setResume(rs.getBytes("resume"));
                jobSeeker.setResumeFileName(rs.getString("resume_file_name"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exceptions
        } finally {
            // Close resources in finally block
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        
        return jobSeeker; // Return the JobSeekers object or null if not found
    }
}
