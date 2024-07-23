package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jobportal.bean.JobSeekers;
import com.jobportal.bean.Jobs;
import com.jobportal.database.DbConnection;




public class JobDao {

	public int countJobs() throws ClassNotFoundException, SQLException {
		
     Connection con =DbConnection.connectdatabase();
     String query ="Select count(*) from jobs";
          PreparedStatement psmt =con.prepareStatement(query);
        		boolean rs =psmt.execute();
		
		return 0;
		
		
		
		
	}
	public List<Jobs> viewApplicationStatus(int id) throws SQLException, ClassNotFoundException {
	    Connection con = null;
	    PreparedStatement statement = null;
	    PreparedStatement totalCountStatement = null;
	    List<Jobs> jobsList = new ArrayList<>();

	    
	        con = DbConnection.connectdatabase();

	        // Query to get the total number of jobs applied by the job seeker
	        String totalCountSql = "SELECT COUNT(*) AS total_applications FROM job_applications WHERE JOB_SEEKER_ID = ?";
	        totalCountStatement = con.prepareStatement(totalCountSql);
	        totalCountStatement.setInt(1, id);
	        int totalApplications = 0;

	        ResultSet totalCountResultSet = totalCountStatement.executeQuery();
	            if (totalCountResultSet.next()) {
	                totalApplications = totalCountResultSet.getInt("total_applications");
	            }
	       

	        // Query to fetch job application details including all required fields
	        String sql = "SELECT ja.APPLICATION_ID, ja.JOB_ID, ja.status, j.JOB_ID, j.EMPLOYER_ID, j.JOB_TITLE, j.JOB_DESCRIPTION, j.LOCATION, " +
	                     "j.REQUIRED_SKILLS, j.JOB_TYPE, j.EXPERIENCE_LEVEL, j.APPLICATION_DEADLINE, j.NUMBER_OF_OPENINGS, " +
	                     "j.EDUCATION_QUALIFICATION, j.EDUCATION_COURCE, j.GENDER, j.MINIMUM_AGE, j.ADDRESS, j.JOB_STATUS, e.COMPANYNAME, j.JOB_POSTED " +
	                     "FROM job_applications ja " +
	                     "JOIN jobs j ON ja.JOB_ID = j.JOB_ID " +
	                     "JOIN employers e ON j.EMPLOYER_ID = e.id " +
	                     "WHERE ja.JOB_SEEKER_ID = ?";

	        statement = con.prepareStatement(sql);
	        statement.setInt(1, id);

	        ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Jobs job = new Jobs();
	                job.setApplicationId(resultSet.getInt("APPLICATION_ID"));
	                job.setJobId(resultSet.getInt("JOB_ID"));
	                job.setEmployerId(resultSet.getInt("EMPLOYER_ID"));
	                job.setJobTitle(resultSet.getString("JOB_TITLE"));
	                job.setJobDescription(resultSet.getString("JOB_DESCRIPTION"));
	                job.setLocation(resultSet.getString("LOCATION"));
	                job.setRequiredSkills(resultSet.getString("REQUIRED_SKILLS"));
	                job.setJobType(resultSet.getString("JOB_TYPE"));
	                job.setExperienceLevel(resultSet.getString("EXPERIENCE_LEVEL"));
	                job.setApplicationDeadline(resultSet.getString("APPLICATION_DEADLINE"));;
	                job.setNumberOfOpenings(resultSet.getInt("NUMBER_OF_OPENINGS"));
	                job.setEducationQualification(resultSet.getString("EDUCATION_QUALIFICATION"));
	                job.setEducationQualification (resultSet.getString("EDUCATION_COURCE"));;
	                job.setGender(resultSet.getString("GENDER"));
//	                job.Ad  (resultSet.getInt("MINIMUM_AGE"));
	                job.setAddress(resultSet.getString("ADDRESS"));
	                job.setJobStatus(resultSet.getString("JOB_STATUS"));
	                job.setCompanyName(resultSet.getString("COMPANYNAME"));
	                job.setJobPosted(resultSet.getString("JOB_POSTED"));;

	                jobsList.add(job);
	            }

	           
	    
	    return jobsList;
	}

	public List<Jobs> viewAllJobs() throws ClassNotFoundException, SQLException {
		ArrayList<Jobs> jobs = new ArrayList<Jobs>();
	
		PreparedStatement statement = null;
		ResultSet rs = null;

	
			// Establish database connection
			Connection con = DbConnection.connectdatabase();
			// SQL query to retrieve all jobs
			String sqlBuilder = "SELECT * FROM jobs ";
			 // Execute query
			statement = con.prepareStatement(sqlBuilder);

			rs = statement.executeQuery();

			 // Flag to check if any jobs are found

			while (rs.next()) {
				
				Jobs jb = new Jobs();
				// At least one job is found
				
			jb.setJobId(rs.getInt("job_id"));
			jb.setJobTitle(rs.getString("job_title"));
			jb.setEmployerId(rs.getInt("EMPLOYER_ID"));
			jb.setJobDescription(rs.getString("job_description"));
			jb.setLocation(rs.getString("location"));
		    jb.setRequiredSkills(rs.getString("required_skills"));
			jb.setJobType(rs.getString("job_type"));
		    jb.setExperienceLevel(rs.getString("experience_level"));
		    jb.setApplicationDeadline(rs.getString("application_deadline"));
		    jb.setJobPosted(rs.getString("JOB_POSTED"));
		    jb.setNumberOfOpenings( rs.getInt("number_of_openings"));
		    jb.setCompanyName( rs.getString("COMPANY_NAME"));
		    jb.setStatus(rs.getString("Job_status"));
				
				jobs.add(jb);
			}
			// Print a message if no jobs are found
			

		
		
		return jobs;
	}
	public List<Jobs> viewJobsByPage(int offset, int limit) throws SQLException, ClassNotFoundException {
	    List<Jobs> jobs = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;

	    try {
	        con = DbConnection.connectdatabase();
	        String sql = "SELECT * FROM ( " +
	                     "    SELECT j.*, ROWNUM AS rnum " +
	                     "    FROM ( " +
	                     "        SELECT * FROM jobs ORDER BY job_id " +
	                     "    ) j " +
	                     "    WHERE ROWNUM <= ? " +
	                     ") " +
	                     "WHERE rnum > ?";

	        statement = con.prepareStatement(sql);
	        statement.setInt(1, offset + limit); // Upper limit for pagination
	        statement.setInt(2, offset); // Lower limit for pagination

	        rs = statement.executeQuery();

	        while (rs.next()) {
	            Jobs jb = new Jobs();
	            jb.setJobId(rs.getInt("job_id"));
	            jb.setJobTitle(rs.getString("job_title"));
	            jb.setEmployerId(rs.getInt("EMPLOYER_ID"));
	            // Populate other job details
	            jobs.add(jb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        if (rs != null) {
	            rs.close();
	        }
	        if (statement != null) {
	            statement.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }

	    return jobs;
	}

	public void applyForJob(int jobId, JobSeekers seeker) throws ClassNotFoundException {
		// System.out.println(jobSeekerId);
		Connection con = null;
		PreparedStatement statement = null;
		int employerId = EmployerDao.getEmployerIdForJob(jobId);
//		if (isAlreadyApplied(jobId, seeker.getJobSeekerId())) {
//			System.out.println(ConsoleColors.RED + "You have already applied for this job." + ConsoleColors.RESET);
//			return;
//		}

		try {
			con =DbConnection.connectdatabase();
		
			String sql = "INSERT INTO job_applications (APPLICATION_ID, JOB_ID, JOB_SEEKER_ID, EMP_ID, APPLICATION_DATE) VALUES (app_id_seq.NEXTVAL, ?, ?, ?, CURRENT_DATE)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, jobId);
			statement.setInt(2, seeker.getSeeker_id());
			statement.setInt(3, employerId);

			int rowsInserted = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
