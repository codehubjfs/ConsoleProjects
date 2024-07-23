package com.access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import com.exception.DateValidator;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.exception.PhoneNumberException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.Customer;
import com.person.DbmsConnection;
import com.person.HouseKeeper;
import com.person.Receptionist;

public class AccessMain {

    private Customer cus = new Customer();
    private static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    private int customer_id;
    private String password;
    private int newUsername;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String username1;
    private String password1;
    private String name;

    public Object login(String email, String password, int p) {
        switch (p) {
            case 1:
                try {
                    String sql = "select * from customer where email='" + email + "'";
                    Connection con = DbmsConnection.getConnection();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        if (rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
                            firstName = rs.getString("f_name");
                            cus.setCustomer_id(rs.getInt("customer_id"));
                            cus.setEmail(rs.getString("email"));
                            cus.setfName(rs.getString("f_name"));
                            return cus;
                        } else {
                            System.out.println("Invalid username or Password. Please Try again");
                            return null;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case 3:
                try {
                    Receptionist receptionist = new Receptionist();
                    PreparedStatement st = DbmsConnection.getConnection().prepareStatement("select * from receptionist where email=? and password=?");
                    st.setString(1, email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        if (rs.getString("email").equalsIgnoreCase(email) && rs.getString("password").equalsIgnoreCase(password)) {
                            name = rs.getString("name");
                            receptionist.setEmployee_id(rs.getInt("employee_id"));
                            receptionist.setEmail(rs.getString("email"));
                            receptionist.setName(rs.getString("name"));
                            System.out.println("Login Successful!!!");
                            return receptionist;
                        } else {
                            System.out.println("Invalid username or password. Please Try Again !");
                            return null;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                try {
                    HouseKeeper hk = new HouseKeeper();
                    PreparedStatement st = DbmsConnection.getConnection().prepareStatement("select * from housekeeper where email=? and password=?");
                    st.setString(1, email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        if (rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
                            name = rs.getString("NAME");
                            hk.setKeeper_id(rs.getInt("keeper_id"));
                            hk.setEmail(rs.getString("email"));
                            hk.setName(rs.getString("NAME"));
                            System.out.println("Login Successful!!!");
                            return hk;
                        } else {
                            System.out.println("Invalid username or password. Please Try Again !");
                            return null;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
        }

        return null;
    }

    public boolean registerCustomer() throws NumberFormatException, IOException, SQLException, EmailException, PasswordException {
        boolean success = false;
        while (!success) {
            try {
                // Email validation
                do {
                    System.out.print("Enter your email: ");
                    email = sc.readLine();
                    try {
                        if (!isValidEmail(email)) {
                            throw new EmailException("Invalid email format. Please enter a valid email address.");
                        }
                    } catch (EmailException e) {
                        System.out.println(e.getMessage());
                    }
                } while (!isValidEmail(email));

                // Password validation
                String newPassword;
                do {
                    displayPasswordRequirements();
                    System.out.println("Enter your new password: ");
                    newPassword = sc.readLine();
                    try {
                        if (!isValidPassword(newPassword)) {
                            throw new PasswordException("Password does not meet requirements. Please choose a stronger password.");
                        }
                    } catch (PasswordException e) {
                        System.out.println(e.getMessage());
                    }
                } while (!isValidPassword(newPassword));

                // Getting other details
                firstName = getValidatedName("first name");
                lastName = getValidatedName("last name");

                // Phone number validation
                String phoneNumberStr;
                long phoneNumber = 0;
                boolean isPhoneNumberValid = false;
                do {
                    System.out.print("Enter phone number: ");
                    phoneNumberStr = sc.readLine();
                    try {
                        phoneNumber = Long.parseLong(phoneNumberStr);
                        contactNumberValidate(phoneNumberStr);
                        isPhoneNumberValid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format. Please enter a valid phone number.");
                    } catch (PhoneNumberException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Please enter 10 digits only.");
                    }
                } while (!isPhoneNumberValid);

                // Address validation
                String address = getValidatedCity("city");

                // CUSTOMER OBJECT 
                Customer cus = new Customer(customer_id, firstName, lastName, email, phoneNumber, address, newPassword);
                String insertQuery = "INSERT INTO customer (CUSTOMER_ID, F_NAME, L_NAME, EMAIL, PHONE_NO, ADDRESS, PASSWORD) VALUES (cusid.nextval, ?, ?, ?, ?, ?, ?)";

                PreparedStatement insertStatement = DbmsConnection.getConnection().prepareStatement(insertQuery);
                insertStatement.setString(1, cus.getfName());
                insertStatement.setString(2, cus.getlName());
                insertStatement.setString(3, cus.getEmail());
                insertStatement.setLong(4, cus.getPhoneNo());
                insertStatement.setString(5, cus.getAddress());
                insertStatement.setString(6, cus.getPassword());

                int rowsAffected = insertStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Customer account created successfully!");
                    success = true; // Set success to true to break out of the loop
                } else {
                    System.out.println("Failed to create customer account. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number format. Please enter a valid number.");
            } catch (SQLException | IOException e) {
                System.out.println("Error occurred: " + e.getMessage());
                do {
                System.out.println("Failed to register customer. Do you want to try again? (yes/no)");
                String choice = sc.readLine();
                if (choice.equalsIgnoreCase("yes")) {
                    registerCustomer(); // Exit the loop if the user chooses not to try again
                }else if(choice.equalsIgnoreCase("no")){
                	try {
						App.menu();
					} catch (NumberFormatException | IOException | SQLException | EmailException | PasswordException
							| DateValidator e1) {
						e1.printStackTrace();
					}
                }else {
                	continue;
                }
                break;
                }while(true);
            }
        }
        return success;
    }

    private boolean isValidPassword(String password) {
    	
//        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
        
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        
        // Check if the password matches the regular expression and its length is within the allowed limit
        return password.length() <= 30 && password.matches(passwordRegex);
    }

    public static boolean isValidEmail(String email) {
        String emailRegex1 = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$";

        // Check if the email matches the regular expression and its length is within the allowed limit
        return email.length() <= 50 && email.matches(emailRegex1);
        
    }

    public static String contactNumberValidate(String contactNumber) throws PhoneNumberException {
        if (!contactNumber.matches("^[9876]\\d{9}$")) {
            throw new PhoneNumberException("Invalid Phone Number. Please Enter 10 digits ");
        }
        return contactNumber;
    }
    private String getValidatedName(String fieldName) throws IOException {
        String name;
        while (true) {
            System.out.print("Enter " + fieldName + ": ");
            name = sc.readLine();
            if (name.matches("[a-zA-Z]+") && name.length() <= 25) {
                break;
            } 
            else if (name.length() > 25) {
                System.out.println(fieldName + " must not exceed 25 characters.");
            } 
            else {
                System.out.println("Please enter a valid " + fieldName + " (only alphabetic characters).");
            }
        }
        return name;
    }

    private String getValidatedCity(String fieldName) throws IOException {
        String address;
        while (true) {
            System.out.print("Enter " + fieldName + ": ");
            address = sc.readLine();
            if (address.length() <= 100 && address.matches("[a-zA-Z0-9\\s,.-]+")) {
                break;
            } 
            else if (address.length() > 100) {
                System.out.println(fieldName + " must not exceed 100 characters.");
            } 
            else {
                System.out.println("Please enter a valid " + fieldName + " (only letters, numbers, spaces, commas, periods, and hyphens are allowed).");
            }
        }
        return address;
    }

    private void displayPasswordRequirements() {
        int boxWidth = 60;
        String horizontalLine = "+" + "-".repeat(boxWidth - 2) + "+";
        String emptyLine = "|" + " ".repeat(boxWidth - 2) + "|";

        System.out.println(horizontalLine);
        System.out.println(emptyLine);
        System.out.println("|" + " ".repeat(22) + "Password Requirements" + " ".repeat(22) + "|");
        System.out.println(emptyLine);
        System.out.println("| Password length should be minimum length of 8 |");
        System.out.println("| Password should contain at least one digit and one special character includes [@$!%*#?&] |");
        System.out.println("| Password should contain at least one lowercase and uppercase character [a and A] |");
        System.out.println(emptyLine);
        System.out.println(horizontalLine);
    }
}
