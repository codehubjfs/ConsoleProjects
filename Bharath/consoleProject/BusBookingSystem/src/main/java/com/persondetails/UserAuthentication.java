package com.persondetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.customexception.EmailException;
import com.customexception.GenderException;
import com.customexception.LastNameException;
import com.customexception.NameException;
import com.customexception.PasswordException;
import com.customexception.PhoneNumberException;
import com.customexception.UserNameException;
import com.customexception.Validation;
import com.databaseconnection.DbConnection;
import com.primarykeyid.PrimaryKey;

public class UserAuthentication {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/*
	 * This method allows an admin to log in by entering their username and
	 * password. It checks the credentials against the database and returns an Admin
	 * object if successful.
	 *
	 * @return Admin object if login is successful, otherwise null.
	 */
	public Admin loginAsAdmin() {
		System.out.println(" +--------------------------------------------------+");
		System.out.println(" |                        Login                     |");
		System.out.println(" +--------------------------------------------------+");
		boolean flag = true;
		int attempts = 0;
        boolean authenticated = false;
		System.out.println(" Welcome to Admin Login!");
		//do {
        while (!authenticated) {
            while (attempts < 3 && !authenticated) {
			try {
				System.out.print(" Enter the Username: ");
				String username = in.readLine();
				System.out.print(" Enter the Password: ");
				String password = in.readLine();
				System.out.println();
				Admin admin = new Admin();
				admin.setUserName(username);
				admin.setPassword(password);
				Connection con = DbConnection.getDBConnection();
				if (con == null) {
					System.out.println(" Failed to establish database connection.");
					return null;
				}
				String sql = "SELECT ADMIN_ID,USERNAME,PASSWORD FROM ADMIN WHERE USERNAME=? and PASSWORD=?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, admin.getUserName());
				statement.setString(2, admin.getPassword());
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					System.out.println(" Login Successfully ");
					admin.setAdminId(resultSet.getInt("ADMIN_ID"));
				     String userNames = resultSet.getString("USERNAME");
                     System.out.println(" Welcome, " + userNames+"! It's pleasure to see you");
					 authenticated = true;
					 return admin;
				 } else {
                     attempts++;
                     System.out.println(" Invalid username or password. Attempts left: " + (3 - attempts));
                 }
			} catch (SQLException | IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
	           if (!authenticated && attempts >= 3) {
	                System.out.println(" You have been locked out due to too many failed attempts. Please wait 10 seconds before trying again.");
	                try {
	                    Thread.sleep(10000); // Wait for 10 seconds
	                } catch (InterruptedException e) {
	                    System.out.println("Error: " + e.getMessage());
	                }
	                attempts = 0; // Reset the attempts counter after waiting

	                // Ask the user if they want to try again
	                System.out.print(" Do you want to try logging in again? (yes/no): ");
	                try {
	                    String response = in.readLine().trim().toLowerCase();
	                    if (!response.equals("yes")) {
	                    	  return null; 
	                    }
	                } catch (IOException e) {
	                    System.out.println(" Error reading input: " + e.getMessage());
	                    System.exit(1); // Exit with error code
	                }
	            }
	        }
	        return null; // In case the loop exits without authentication
	    }
		return null;
	}
		//} //while (true);
//            }
//        }
//	}
//    
			
	/*
	 * This method allows an customer to log in by entering their username and
	 * password. It checks the credentials against the database and returns an
	 * customer object if successful.
	 *
	 * @return customer object if login is successful, otherwise null.
	 */
	public Customer loginAsCustomer() {
		System.out.println(" +--------------------------------------------------+");
		System.out.println(" |                        Login                     |");
		System.out.println(" +--------------------------------------------------+");
//		System.out.println(" Welcome to Customer Login!");
		int attempts = 0;
        boolean authenticated = false;
        while (!authenticated) {
            while (attempts < 3 && !authenticated) {
                try {
                    System.out.print(" Enter Username: ");
                    String userName = in.readLine();
                    System.out.print(" Enter Password: ");
                    String password = in.readLine();
                    Customer customer = new Customer();
                    customer.setUserName(userName);
                    customer.setPassword(password);
                    Connection con = DbConnection.getDBConnection();
                    if (con == null) {
                        System.out.println(" Failed to establish database connection.");
                        return null;
                    }
                    String sql = "SELECT CUSTOMER_ID, USERNAME, PASSWORD FROM CUSTOMER WHERE USERNAME=? AND PASSWORD=?";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1, customer.getUserName());
                    statement.setString(2, customer.getPassword());
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        System.out.println(" Login Successfully ");
                        customer.setCustid(resultSet.getInt("CUSTOMER_ID"));
                        String userNames = resultSet.getString("USERNAME");
                        System.out.println(" Welcome, " + userNames+"! It's pleasure to see you");
                        authenticated = true;
                        return customer;
                    } else {
                        attempts++;
                        System.out.println(" Invalid username or password. Attempts left: " + (3 - attempts));
                    }
                } catch (SQLException | IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (!authenticated && attempts >= 3) {
                System.out.println(" You have been locked out due to too many failed attempts. Please wait 10 seconds before trying again.");
                try {
                    Thread.sleep(10000); // Wait for 10 seconds
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                attempts = 0; // Reset the attempts counter after waiting

                // Ask the user if they want to try again
                System.out.print(" Do you want to try logging in again? (yes/no): ");
                try {
                    String response = in.readLine().trim().toLowerCase();
                    if (!response.equals("yes")) {
                    	  return null; 
                    }
                } catch (IOException e) {
                    System.out.println(" Error reading input: " + e.getMessage());
                    System.exit(1); // Exit with error code
                }
            }
        }
        return null; // In case the loop exits without authentication
    }
		//do {
//        while (attempts < 3 && !authenticated) {
//			try {
//				System.out.print(" Enter Username: ");
//				String userName = in.readLine();
//				System.out.print(" Enter Password: ");
//				String password = in.readLine();
//				Customer customer = new Customer();
//				customer.setUserName(userName);
//				customer.setPassword(password);
//				Connection con = DbConnection.getDBConnection();
//				if (con == null) {
//					System.out.println(" Failed to establish database connection.");
//					return null;
//				}
//				String sql = "SELECT CUSTOMER_ID,USERNAME,PASSWORD FROM CUSTOMER WHERE USERNAME=? and PASSWORD=?";
//				PreparedStatement statement = con.prepareStatement(sql);
//				statement.setString(1, customer.getUserName());
//				statement.setString(2, customer.getPassword());
//				ResultSet resultSet = statement.executeQuery();
//				if (resultSet.next()) {
//					System.out.println(" Login Successfully ");
//					customer.setCustid(resultSet.getInt("CUSTOMER_ID"));
//					return customer;
//				} else {
//	                attempts++;
//	                System.out.println(" Invalid username or password. Attempts left: " + (3 - attempts));
//				}
//			} catch (SQLException | IOException e) {
//				System.out.println("Error: " + e.getMessage());
//			}
//			 if (!authenticated) {
//	                System.out.println("You have been locked out due to too many failed attempts. Please wait 10 seconds before trying again.");
//	                try {
//	                    Thread.sleep(10000); // Wait for 10 seconds
//	                } catch (InterruptedException e) {
//	                    System.out.println("Error: " + e.getMessage());
//	                }
//	                attempts = 0; // Reset the attempts counter
//	            }
//	        }
//	        return null; // In case the loop exits without authentication
//	    }
//		} //while (true);
//		return null;
//}
//        while (!authenticated) {
//            while (attempts < 3 && !authenticated) {
//                try {
//                    System.out.print(" Enter Username: ");
//                    String userName = in.readLine();
//                    System.out.print(" Enter Password: ");
//                    String password = in.readLine();
//                    Customer customer = new Customer();
//                    customer.setUserName(userName);
//                    customer.setPassword(password);
//                    Connection con = DbConnection.getDBConnection();
//                    if (con == null) {
//                        System.out.println(" Failed to establish database connection.");
//                        return null;
//                    }
//                    String sql = "SELECT CUSTOMER_ID, USERNAME, PASSWORD FROM CUSTOMER WHERE USERNAME=? AND PASSWORD=?";
//                    PreparedStatement statement = con.prepareStatement(sql);
//                    statement.setString(1, customer.getUserName());
//                    statement.setString(2, customer.getPassword());
//                    ResultSet resultSet = statement.executeQuery();
//                    if (resultSet.next()) {
//                        System.out.println(" Login Successfully ");
//                        customer.setCustid(resultSet.getInt("CUSTOMER_ID"));
//                        authenticated = true;
//                        return customer;
//                    } else {
//                        attempts++;
//                        System.out.println("Invalid username or password. Attempts left: " + (3 - attempts));
//                    }
//                } catch (SQLException | IOException e) {
//                    System.out.println("Error: " + e.getMessage());
//                }
//            }
//
//            if (!authenticated && attempts >= 3) {
//                System.out.println("You have been locked out due to too many failed attempts. Please wait 10 seconds before trying again.");
//                try {
//                    Thread.sleep(10000); // Wait for 10 seconds
//                } catch (InterruptedException e) {
//                    System.out.println("Error: " + e.getMessage());
//                }
//                attempts = 0; // Reset the attempts counter after waiting
//            }
//        }
//        return null; // In case the loop exits without authentication
//    }
   

	// Customer Registration
	public Customer registerAsCustomer() {
		
		boolean flag = true;
		do {
			try {
				String firstName = " ", lastName = " ", emailId = " ", phoneNumber = " ", gender = " ", userName = " ",
						password = " ";
				while (true) {
					try {
						System.out.print(" Enter First Name: ");

						firstName = Validation.validateName(in.readLine().trim());
						break;
					} catch (NameException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Last Name : ");
						lastName = Validation.validateLastName(in.readLine().trim());
						break;
					} catch (LastNameException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Gender[male/female]: ");
						gender = Validation.validateGender(in.readLine().trim());
						break;
					} catch (GenderException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Email: ");
						emailId = Validation.validateEmail(in.readLine().trim());
						break;
					} catch (EmailException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Phone Number: ");
						phoneNumber = Validation.validatePhoneno(in.readLine().trim());
						break;
					} catch (PhoneNumberException e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print(" Create Your UserName: ");
						userName = Validation.validateUserName(in.readLine().trim());
						break;
					} catch (UserNameException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Create Your Password: ");
						password = Validation.validatePassword(in.readLine().trim());
						break;
					} catch (PasswordException e) {
						System.out.println(e.getMessage());
					}
				}
				int customerkey = PrimaryKey.keys("customer");
				Customer customer = new Customer();
				customer.setCustid(customerkey);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setGender(gender);
				customer.setEmail(emailId);
				customer.setUserName(userName);
				customer.setPassword(password);
				customer.setPhoneNumber(phoneNumber);
				Connection con = DbConnection.getDBConnection();
				if (con == null) {
					System.out.println(" Failed to establish database connection.");
					return null;
				}
				String sqlCustomer = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement statement = con.prepareStatement(sqlCustomer);
				statement.setInt(1, customerkey);
				statement.setString(2, customer.getFirstName());
				statement.setString(3, customer.getLastName());
				statement.setString(4, customer.getGender());
				statement.setString(5, customer.getEmail());
				statement.setString(6, customer.getUserName());
				statement.setString(7, customer.getPassword());
				statement.setString(8, customer.getPhoneNumber());
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println(" Registered successfully!\n");
					flag = false;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (flag == false) {
				break;
			}
		} while (true);
		return null;
	}

	/*
	 * Allows a bus operator to log in by entering their username and password.
	 * Verifies the credentials against the database and returns a BusOperator
	 * object if successful, otherwise returns null.
	 *
	 * @return BusOperator object if login is successful, otherwise null.
	 */
	public BusOperator loginAsBusOperator() {
		System.out.println(" +--------------------------------------------------+");
		System.out.println(" |                        Login                     |");
		System.out.println(" +--------------------------------------------------+");
		System.out.println(" Welcome to Bus Operator Login!");
		//do {
		int attempts = 0;
        boolean authenticated = false;
        while (!authenticated) {
            while (attempts < 3 && !authenticated) {
			try {
				System.out.print(" Enter Username: ");
				String userName = in.readLine();
				System.out.print(" Enter Password: ");
				String password = in.readLine();
				BusOperator operator = new BusOperator();
				operator.setUserName(userName);
				operator.setPassword(password);
				Connection con = DbConnection.getDBConnection();
				if (con == null) {
					System.out.println(" Failed to establish database connection.");
					return null;
				}
				String sqlBusOperator = "SELECT OPER_ID,USERNAME,PASSWORD FROM BUSOPERATOR WHERE USERNAME=? and PASSWORD=?";
				PreparedStatement statement = con.prepareStatement(sqlBusOperator);
				statement.setString(1, operator.getUserName());
				statement.setString(2, operator.getPassword());
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					System.out.println(" Login Successfully ");
					operator.setBusOperatorId(resultSet.getInt("oper_id"));
                    String userNames = resultSet.getString("USERNAME");
                    System.out.println(" Welcome, " + userNames+"! It's pleasure to see you");
                    authenticated=true;
                    return operator;
				}else {
                    attempts++;
                    System.out.println(" Invalid username or password. Attempts left: " + (3 - attempts));
                }
            } catch (SQLException | IOException e) {
//                System.out.println("Error: " + e.getMessage());
            	e.printStackTrace();
            }
        }

        if (!authenticated && attempts >= 3) {
            System.out.println(" You have been locked out due to too many failed attempts. Please wait 10 seconds before trying again.");
            try {
                Thread.sleep(10000); // Wait for 10 seconds
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            attempts = 0; // Reset the attempts counter after waiting

            // Ask the user if they want to try again
            System.out.print(" Do you want to try logging in again? (yes/no): ");
            try {
                String response = in.readLine().trim().toLowerCase();
                if (!response.equals("yes")) {
                	  return null; 
                }
            } catch (IOException e) {
                System.out.println(" Error reading input: " + e.getMessage());
                System.exit(1); // Exit with error code
            }
        }
    }
//				} else {
//					System.out.println(" Invalid Username or Password");
//				}
//			} catch (SQLException | IOException e) {
//				System.out.println("Error: " + e.getMessage());
//			}
//			return null;
		//} while (true);
		return null;
	}

	public BusOperator registerAsBusOperator() {
		boolean flag = true;
		do {
			System.out.println(" Welcome to Bus Operator Registration!");
			try {
				String firstName = " ", lastName = " ", emailId = " ", phoneNumber = " ", gender = " ", userName = " ",
						password = " ";
				while (true) {
					try {
						System.out.print(" Enter First Name: ");
						firstName = Validation.validateName(in.readLine());
						break;
					} catch (NameException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Last Name : ");
						lastName = Validation.validateName(in.readLine());
						break;
					} catch (NameException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Gender[male/female]: ");
						gender = Validation.validateGender(in.readLine());
						break;
					} catch (GenderException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Email: ");
						emailId = Validation.validateEmail(in.readLine());
						break;
					} catch (EmailException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Enter Phone Number: ");
						phoneNumber = Validation.validatePhoneno(in.readLine());
						break;
					} catch (PhoneNumberException e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print(" Create Your UserName: ");
						userName = Validation.validateUserName(in.readLine());
						break;
					} catch (UserNameException e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print(" Create Your Password: ");
						password = Validation.validatePassword(in.readLine());
						break;
					} catch (PasswordException e) {
						System.out.println(e.getMessage());
					}
				}
				int customerkey = PrimaryKey.keys("Busoperator");
				BusOperator operator=new BusOperator();
				operator.setBusOperatorId(customerkey);
				operator.setFirstName(firstName);
				operator.setLastName(lastName);
				operator.setGender(gender);
				operator.setEmail(emailId);
				operator.setUserName(userName);
				operator.setPassword(password);
				operator.setPhoneNumber(phoneNumber);
				Connection con = DbConnection.getDBConnection();
				if (con == null) {
					System.out.println(" Failed to establish database connection.");
					return null;
				}
				String sqlCustomer = "INSERT INTO BUSOPERATOR VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement statement = con.prepareStatement(sqlCustomer);
				statement.setInt(1, customerkey);
				statement.setString(2,operator.getFirstName());
				statement.setString(3,operator.getLastName());
				statement.setString(4,operator.getGender());
				statement.setString(5,operator.getEmail());
				statement.setString(6,operator.getUserName());
				statement.setString(7,operator.getPassword());
				statement.setString(8,operator.getPhoneNumber());
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println(" Registered successfully!\n");
					flag = false;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (flag == false) {
				break;
			}
		} while (true);
		return null;
	}
}
