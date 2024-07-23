package com.hallbookingsystem.persondetails;

import com.hallbookingsystem.dbconnection.DBConnection;
import com.hallbookingsystem.halldetails.Amenity;
import com.hallbookingsystem.halldetails.Hall;
import com.hallbookingsystem.bookingdetails.Book;
import com.hallbookingsystem.bookingdetails.BookingStatus;
import com.hallbookingsystem.customexception.*;
import com.hallbookingsystem.primarykey.PrimaryKeyProvider;
import com.hallbookingsystem.searchdetails.HallDirectory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Person class implements the attributes and the methods which are related to the class
* @author Sanjai P
* @since 14-May-2024
* */


public class Person {
    private int userId;
    private String name;
    private Account account; //Aggregation or composition
    private Gender gender;
    private String email;
    private String mobileNumber;
    private Address address;
    // Person Constructor to initialize the filed members
    public Person(int userId, String name, Account account, Gender gender, String email, String mobileNumber, Address address) {
        this.userId= userId;
        this.name = name;
        this.account = account;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public Person(int userId, String name, Gender gender, String email, String mobileNumber, Address address) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }
    public Person(String name, Gender gender, String email, String mobileNumber, Address address) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }
    public Person() {
    }
    // getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // getter and setter for Gender enum
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    // getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //getter and setter for mobileNumber

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    //getter setter for Address object
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    /**
     * showAllHall methods used to show all halls, and their amenities and it stores in map
     * @return Map<Integer,Hall> which holds serial-no as key and Hall object as Values for future uses
     * */
    public static Map<Integer,Hall> showAllHall() {
                List<Hall> list = new HallDirectory().listHall();
                int[]i ={0};
                Map<Integer,Hall> hallMap = new HashMap<>();
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("|                                                               Hall Detail                                                                        |");
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
                hallMap = list.stream().filter(Hall::isAvail).peek(hall -> System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n",++i[0],hall.getHallName(), hall.getPrice(), hall.getCapacity(),
                hall.getIsAcHall() ? "Yes" : "No",hall.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1, str2)->str1+","+str2)))
                .collect(Collectors.toMap(hall -> i[0], hall -> hall));
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
                return hallMap;
    }

    /**
     * changePassword methods used to change the password of the person and their derived class like admin and also customer
     * @param person
     */
    public <T extends Person> void changePassword(T person) {
        boolean exitFlag = true;
        byte count = 0; // Moved count outside the loop to count attempts
        do {
            try {
                System.out.println("Enter the old user Password :");
                String oldPassword = sc.readLine().trim();//getting the password
                if (oldPassword.equals(person.getAccount().getPassword())) {// getting the old password and comparing with the above input
                    boolean passwordFlag = false;
                    String newPassword = "";
                    do {
                        try {
                            System.out.print("Enter the new password :");
                            newPassword = Validate.validatePassword(sc.readLine().trim());
                            if (oldPassword.equals(newPassword)) { // checks the old password equals to the new password
                                passwordFlag = true;
                                System.out.println("New password should not be the same as the old password.");
                            } else {
                                String updateQuery = "UPDATE users SET password = ? WHERE user_id = ?";// update the password with new password by using user_id
                                PreparedStatement updateStatement = DBConnection.getConnection().prepareStatement(updateQuery);
                                updateStatement.setString(1, newPassword);
                                updateStatement.setInt(2, person.getUserId());
                                int rowsAffected = updateStatement.executeUpdate();
                                if (rowsAffected > 0) {
                                    System.out.println("Password updated successfully.");
                                    return;
                                } else {
                                    System.out.println("Failed to update password.");
                                }
                            }
                        } catch (PasswordException e) {
                            passwordFlag = true;
                            System.out.println(e.getMessage());
                        }
                    } while (passwordFlag);

                } else {
                    count++;
                    System.out.println("Old password does not match.");
                    System.out.printf("Remaining number of attempts: %d%n", 4 - count);
                }
                if (count == 4) {
                    DBConnection.getConnection().close();
                    System.out.println("Password attempt limit exceeded.");
                    System.exit(0);
                }



            } catch (SQLException | IOException ex) {
                System.out.println(ex.getMessage());
            }
            boolean optionFlag = false;
            do {
                try {
                    System.out.println("1. To Continue\n2. Back"); //asking options to user to continue or back
                    byte option = Validate.validateOption(sc.readLine().trim());
                    if (option == 1) {
                        exitFlag = true;
                    } else if (option == 2) {
                        exitFlag = false;
                        break;
                    } else {
                        optionFlag = true;
                        System.out.println("Enter valid input");
                    }
                } catch (NumberInputException | IOException e) {
                    optionFlag = true;
                    System.out.println(e.getMessage());
                }
            } while (optionFlag);
        } while (exitFlag);
    }


/**
 * changeMailAddress method is allowed to change the email-address of the users
 * @param user
 * */
    public  <T extends  Person> void changeMailAddress(T user) {
            boolean exitFlag = false;
            do {
                try {
                    System.out.println("Enter the new email address:");
                    String newEmail = sc.readLine().trim();
                    if(newEmail.equals(user.getEmail())){
                        System.out.println("Error: The current email ID and the new email ID are the same.");
                        continue;
                    }

                    String updateQuery = "UPDATE users SET email_id = ? WHERE user_id = ?";
                    PreparedStatement updateStatement =DBConnection.getConnection().prepareStatement(updateQuery);
                    updateStatement.setString(1, newEmail);
                    updateStatement.setInt(2,user.getUserId());

                    int rowsAffected = updateStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Email address updated successfully.");
                    } else {
                        System.out.println("Failed to update email address.");
                    }

                    System.out.println("1. To Continue\n2. Back");
                    boolean optionFlag = false;
                    do {
                        try {
                            byte option = Validate.validateOption(sc.readLine().trim());
                            if (option == 1) {
                                exitFlag = true;
                            } else if (option == 2) {
                                exitFlag = false;
                            }
                        } catch (NumberInputException e) {
                            optionFlag = true;
                            System.out.println(e.getMessage());
                        }
                    } while (optionFlag);
                } catch (IOException | SQLException e) {
                    System.out.println(e.getMessage());
                }
            } while (exitFlag);

    }

}
