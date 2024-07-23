package com.jobportal.dao;



import com.jobportal.bean.Employer;
import com.jobportal.database.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

///**
//* Data Access Object (DAO) for Employer entity.
//*/
public class EmployerDao {

//  /**
//   * Retrieves all employers from the database.
//   *
//   * @return A list of Employer objects.
//   */
  public List<Employer> getAllEmployers() {
      List<Employer> employers = new ArrayList<>();
      String query = "SELECT * FROM employers";
      try (Connection con = DbConnection.connectdatabase();
           PreparedStatement pst = con.prepareStatement(query)) {

          ResultSet rs = pst.executeQuery();
          while (rs.next()) {
              Employer employer = mapResultSetToEmployer(rs);
              employers.add(employer);
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return employers;
  }

  /**
   * Retrieves an Employer from the database based on the provided email.
   *
   * @param email The email of the employer.
   * @return An Employer object if found, null otherwise.
   */
  public Employer getEmployerByEmail(String email) {
      Employer employer = null;
      String query = "SELECT * FROM employers WHERE email = ?";
      try (Connection con = DbConnection.connectdatabase();
           PreparedStatement pst = con.prepareStatement(query)) {

          pst.setString(1, email);
          ResultSet rs = pst.executeQuery();
          if (rs.next()) {
              employer = mapResultSetToEmployer(rs);
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return employer;
  }

  /**
   * Inserts a new Employer into the database.
   *
   * @param employer The Employer object to be inserted.
   * @throws DuplicateEmailException if the email is already registered.
   */
  public void registerEmployer(Employer employer)  {
      String query = "INSERT INTO employers (name, email, password, company_name, number, gender, address, state, district, pincode, about_company, active) " +
              "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      try (Connection con = DbConnection.connectdatabase();
           PreparedStatement pst = con.prepareStatement(query)) {

          pst.setString(1, employer.getName());
          pst.setString(2, employer.getEmail());
          pst.setString(3, employer.getPassword());
          pst.setString(4, employer.getCompanyName());
//          pst.setLong(5, employer.getNumber());
          pst.setString(6, employer.getGender());
          pst.setString(7, employer.getAddress());
          pst.setString(8, employer.getState());
          pst.setString(9, employer.getDistrict());
          pst.setLong(10, employer.getPincode());
          pst.setString(11, employer.getAboutCompany());
//          pst.setBoolean(12, employer.isActive());

          int rowsInserted = pst.executeUpdate();
          if (rowsInserted == 0) {
              throw new SQLException("Failed to insert employer. No rows affected.");
          }
      } catch (ClassNotFoundException | SQLException e) {
          if (e.getMessage().contains("Duplicate entry")) {
//              throw new DuplicateEmailException("Email is already registered.");
          } else {
              e.printStackTrace();
          }
      }
  }

  /**
   * Updates the password of an Employer in the database.
   *
   * @param email       The email of the employer.
   * @param oldPassword The old password of the employer.
   * @param newPassword The new password to be set.
   * @return true if password update is successful, false otherwise.
   * @throws InvalidCredentialsException if the old password doesn't match the stored password.
   */
  public boolean updatePassword(String email, String oldPassword, String newPassword)  {
      boolean updated = false;
      String query = "UPDATE employers SET password = ? WHERE email = ? AND password = ?";
      try (Connection con = DbConnection.connectdatabase();
           PreparedStatement pst = con.prepareStatement(query)) {

          pst.setString(1, newPassword);
          pst.setString(2, email);
          pst.setString(3, oldPassword);

          int rowsUpdated = pst.executeUpdate();
          if (rowsUpdated > 0) {
              updated = true;
          } else {
//              throw new InvalidCredentialsException("Invalid old password.");
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return updated;
  }

  /**
   * Resets the password of an Employer in the database.
   *
   * @param email    The email of the employer.
   * @param password The new password to be set.
   * @return true if password reset is successful, false otherwise.
   */
  public boolean resetPassword(String email, String password) {
      boolean updated = false;
      String query = "UPDATE employers SET password = ? WHERE email = ?";
      try (Connection con = DbConnection.connectdatabase();
           PreparedStatement pst = con.prepareStatement(query)) {

          pst.setString(1, password);
          pst.setString(2, email);

          int rowsUpdated = pst.executeUpdate();
          if (rowsUpdated > 0) {
              updated = true;
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return updated;
  }

  /**
   * Updates the status (active or inactive) of an Employer in the database.
   *
   * @param email  The email of the employer.
   * @param active true to set the employer as active, false to set as inactive.
   * @return true if status update is successful, false otherwise.
   */
  public boolean updateStatus(String email, 	String status) {
      boolean updated = false;
      String query = "UPDATE employers SET status = ? WHERE email = ?";
      try (Connection con = DbConnection.connectdatabase();
           PreparedStatement pst = con.prepareStatement(query)) {

          pst.setString(1, status);
          pst.setString(2, email);

          int rowsUpdated = pst.executeUpdate();
          if (rowsUpdated > 0) {
              updated = true;
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return updated;
  }

  private Employer mapResultSetToEmployer(ResultSet rs) throws SQLException {
      Employer employer = new Employer();
      employer.setName(rs.getString("name"));
      employer.setEmail(rs.getString("email"));
      employer.setPassword(rs.getString("password"));
      employer.setCompanyName(rs.getString("company_name"));
//      employer.setNumber(rs.getLong("number"));
      employer.setGender(rs.getString("gender"));
      employer.setAddress(rs.getString("address"));
      employer.setState(rs.getString("state"));
      employer.setDistrict(rs.getString("district"));
      employer.setPincode(rs.getLong("pincode"));
      employer.setAboutCompany(rs.getString("about_company"));
//      employer.setActive(rs.getBoolean("active"));
      return employer;
  }

public List<Employer> getAllEmployers1() {
    List<Employer> employers = new ArrayList<>();
   
    String query = "SELECT * FROM employers";
    try (Connection con = DbConnection.connectdatabase();
         PreparedStatement pst = con.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
    	 System.out.println("hello1");
        while (rs.next()) {
        	Employer employer = new Employer();
        	 System.out.println("hello2");
           
            employer.setEmp_id(rs.getInt("ID"));
            employer.setName(rs.getString("USERNAME"));
            employer.setEmail(rs.getString("EMAIL"));
//            employer.setPassword(rs.getString(""));
            employer.setCompanyName(rs.getString("COMPANYNAME"));
            employer.setNumber(rs.getString("PHONE_NUMBER"));
            employer.setStatus(rs.getString("status"));
//            employer.setAddress(rs.getString("address"));
            employer.setState(rs.getString("state"));
            employer.setDistrict(rs.getString("district"));
            employer.setPincode(rs.getLong("pincode"));
            employer.setAboutCompany(rs.getString("about_company"));
//            employer.setActive(rs.getBoolean("active"));

            employers.add(employer);
            
        }
        System.out.println("hellodkdldkdl");
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        // Handle exception as per your application's requirements
    }

    return employers;
}
public static int getEmployerIdForJob(int jobId) throws ClassNotFoundException {
	Connection con = null;
	PreparedStatement statement = null;
	// ResultSet rs = null;
	int employerId = -1; // Default value if no employer found

	try {
		con = DbConnection.connectdatabase();
		String query = "SELECT EMPLOYER_ID FROM jobs WHERE job_id = ?";
		statement = con.prepareStatement(query);
		statement.setInt(1, jobId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			employerId = resultSet.getInt("EMPLOYER_ID");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return employerId;
}
}

