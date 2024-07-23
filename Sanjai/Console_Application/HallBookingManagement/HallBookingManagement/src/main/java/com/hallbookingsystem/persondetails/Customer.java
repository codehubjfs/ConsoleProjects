package com.hallbookingsystem.persondetails;

import com.hallbookingsystem.bookingdetails.Book;
import com.hallbookingsystem.bookingdetails.BookingStatus;
import com.hallbookingsystem.customexception.DateValidator;
import com.hallbookingsystem.customexception.IntegerException;
import com.hallbookingsystem.customexception.NumberInputException;
import com.hallbookingsystem.customexception.Validate;
import com.hallbookingsystem.dbconnection.DBConnection;
import com.hallbookingsystem.halldetails.Events;
import com.hallbookingsystem.halldetails.Hall;
import com.hallbookingsystem.halldetails.Seats;
import com.hallbookingsystem.paymentdetails.Payment;
import com.hallbookingsystem.paymentdetails.UPI;
import com.hallbookingsystem.primarykey.PrimaryKeyProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Customer class extends the Person class and implements Comparable interface.
 * class has behavior of the customer in hall booking system.
 * @author Sanjai
 * @since 10-May-2024
 */

public class Customer extends Person implements Comparable<Customer>{
    public Customer(String name, Gender gender, String email, String mobileNumber, Address address) {
        super(name, gender, email, mobileNumber, address);
    }
    public Customer(){};
    public Customer(Person p){

    }
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


    public Customer(int userId, String name, Account account, Gender gender, String email, String mobileNumber, Address address) {
        super(userId, name, account, gender, email, mobileNumber, address);
    }

    public  void watchList() {
        boolean exit = false;
        Book book = null;
        do {
            try {

                String query = "Select b.book_id,h.hall_id,b.start_date,b.end_Date,h.hall_name,UPPER(b.BOOK_STATUS) as book_status from halls h join booking b on " +
                        "h.hall_id = b.hall_id where sysdate<start_date AND user_id =?";
                PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
                statement.setInt(1,super.getUserId());
                ResultSet set = statement.executeQuery();
                System.out.println("+-------+------------------------+-------------------+");
                System.out.println("| NO    |      Hall Name         |   Booking Status  |");
                System.out.println("+-------+------------------------+-------------------+");
                int i = 0;
                LinkedHashMap<Integer, Book> map = new LinkedHashMap<>();
                boolean replyFound = false;
                while (set.next()) {
                    replyFound = true;
                    String hallName = set.getString("hall_name");
                    String bookingStatus = set.getString("book_status");
                    i++;
                    System.out.printf("| %-4d | %-20s | %-18s |\n", i, hallName, bookingStatus);
                    book = new Book(); // Create a new Book object for each iteration
                    book.setBookId(set.getInt("book_id"));
                    book.setHallId(set.getInt("hall_id"));
                    book.setStartDate(set.getDate("start_date").toLocalDate());
                    book.setEndDate(set.getDate("end_date").toLocalDate());
                    book.setBookingStatus(BookingStatus.valueOf(bookingStatus));
                    map.put(i, book);
                }
                if (!replyFound){
                    System.out.println("                    No Reply Found                     ");
                }
                System.out.println("+-----+------------------------+-------------------+");

                if (!map.isEmpty()) {
                    boolean flag = true;
                    do {
                        try {
                            System.out.println("Enter 1 - " + map.size() + " for Confirmation or cancel of " +
                                    "respective hall (E to Exit)");
                            String choice = sc.readLine().trim();
                            if(choice.matches("[0-9]+")){
                                int option = Integer.parseInt(choice);
                                if (option >= 1 && option <= map.size()) {
                                    Book selectedBook = map.get(option);
                                    if (selectedBook.getBookingStatus().equals(BookingStatus.APPROVED)) {
                                        boolean flag1 = false;
                                        do{
                                            try{
                                                System.out.println("1. To Confirm\n2. To Cancel");
                                                int confirmDecision = Validate.validateOption(sc.readLine().trim());
                                                if(confirmDecision==1){
                                                    Payment payment = new UPI();
                                                    if(payment.pay(selectedBook)){
                                                        book.blockOtherBooking(selectedBook);
                                                    }
                                                    flag = false;
                                                    flag1 = false;
                                                }
                                                else if (confirmDecision == 2){
                                                    cancelRequest(selectedBook);
                                                    break;
                                                }
                                            } catch (NumberInputException e) {
                                                flag1 = true;
                                                System.out.println(e.getMessage());
                                            }
                                        }while(flag1);
                                    }
                                    else if (selectedBook.getBookingStatus().equals(BookingStatus.APPROVED)) {
                                        System.out.println("It is not in approved");
                                    }
                                    else {
                                        System.out.println("Selected option is not Approved");
                                    }
                                } else {
                                    System.out.println("Selected option is Invalid");
                                }
                            }
                            else if(choice.equalsIgnoreCase("E")){
                                return;
                            }
                            else{
                                flag = true;
                                System.out.println("Enter the valid input");
                            }

                        } catch (IOException e) {
                            flag = true;
                            System.out.println(e.getMessage());
                        }
                    } while (flag);
                }
                do{
                    System.out.println("1. Back ");
                    String input = sc.readLine().trim();
                    if (input.equals("1")) {
                        exit = false;
                        break;
                    } else {
                        System.out.println("Enter the valid input");
                    }
                }while (true);

            } catch (SQLException | IOException ex) {
                exit = true;
                System.out.println(ex.getMessage());
            }
        } while (exit);

    }
    /*cancelRequest method book The Book object representing the booking to be cancelled*/
    private void cancelRequest(Book book) {
        try{
            System.out.println(book.getBookId());
            String query = "Update Booking set book_status ='CANCELED' where book_id= ?";
            PreparedStatement statement =DBConnection.getConnection().prepareStatement(query);
            statement.setInt(1,book.getBookId());
            if(statement.executeUpdate()>0){
                System.out.println("Successfully canceled the approval of the booking.");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    /*paymentHistory method The Customer object for which the payment history is displayed.*/
    public void paymentHistory() {
        try {
            String query = "SELECT p.payment_time, h.hall_name, b.start_date, b.end_date - b.start_date AS duration, " +
                    "h.hall_price, h.hall_price * (b.end_date - b.start_date) AS total_price, p.paid_status " +
                    "FROM payment p " +
                    "JOIN booking b ON p.book_id = b.book_id " +
                    "JOIN halls h ON b.hall_id = h.hall_id " +
                    "WHERE b.user_id = ?";

            PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
            statement.setInt(1, this.getUserId());
            ResultSet set = statement.executeQuery();

            System.out.println("+---------------------+------------------+---------------------+------+-------------+--------+----------------+");
            System.out.println("|    Payment Time     |     Hall Date    |      Hall Name      | Days | Total Price | Price  | Payment Status |");
            System.out.println("+---------------------+------------------+---------------------+------+-------------+--------+----------------+");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            boolean foundPayment = false;

            while (set.next()) {
                foundPayment = true;
                System.out.printf("| %-20s | %-16s | %-20s | %-4d | %-11.2f | %-6.2f | %-14s |%n",
                        dateFormat.format(set.getTimestamp("payment_time")),
                        dateFormat.format(set.getDate("start_date")),
                        set.getString("hall_name"),
                        set.getInt("duration"),
                        set.getDouble("total_price"),
                        set.getDouble("hall_price"),
                        set.getString("paid_status"));
            }

            if (!foundPayment) {
                System.out.println("                        No payment history found                                    ");
            }

            System.out.println("+---------------------+------------------+---------------------+------+-------------+--------+----------------+");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*pay method implements to fetch the payment details*/
    public void pay() {
        try {
            String query = "SELECT p.payment_id,b.start_Date, h.hall_name, (b.end_date - b.start_date) AS Days, " +
                    "h.hall_price * (b.end_date - b.start_date) AS Total_Price, " +
                    "(h.hall_price * (b.end_date - b.start_date) - " +
                    "(SELECT MAX(price) FROM payment p JOIN booking b ON p.book_id = b.book_id)) AS payable " +
                    "FROM payment p " +
                    "JOIN booking b ON p.book_id = b.book_id " +
                    "JOIN halls h ON b.hall_id = h.hall_id " +
                    "WHERE b.user_id = ? AND p.paid_status = 'ADVANCED' AND start_DATE>sysdate ";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
            statement.setInt(1, this.getUserId()); // Set the user_id parameter
            ResultSet set = statement.executeQuery();
            System.out.println("+---------------------+------------------+------+-------------+-----------------+");
            System.out.println("|  SNO   |Start Date      |     Hall Name    | Days | Total Price | Payable     |");
            System.out.println("+---------------------+------------------+------+-------------+-----------------+");
            boolean isPayFound = false;
            double totalPrice= 0.0;
            float payAble = 0.0f;
            int paymentID = 0;
            LinkedHashMap<Integer,Integer> snoMap = new LinkedHashMap<>();
            int i = 0;
            while (set.next()) {
                isPayFound = true;
                System.out.printf("| %-5d | %-19s | %-16s | %-4d | %-11.2f | %-7.2f |\n",++i,
                        set.getString("start_Date"),
                        set.getString("hall_name"),
                        set.getInt("Days"),
                        set.getDouble("Total_Price"),
                        set.getFloat("payable"));
                totalPrice = set.getDouble("Total_Price");
                payAble = set.getFloat("payAble");
                paymentID = set.getInt("payment_id");
                snoMap.put(i,paymentID);// storing the paymentID in the values to get the id using keys.
            }
            if (!isPayFound) {
                System.out.println("|                  No payment is required at this time                           |");
            }
            System.out.println("+---------------------+------------------+------+-------------+-----------------+");
            boolean flag = false;
            int sno = 0;
            do{
                try{
                    System.out.println("1.Pay Money \n2.Back");
                    byte option = Validate.validateOption(sc.readLine().trim());
                     if(option==1 ){
                        boolean snoFlag = false;
                        do{
                            try{
                                System.out.println("Select number for payment :");
                                sno = Validate.validInteger(sc.readLine().trim());
                            }catch ( IntegerException e){
                                System.out.println(e.getMessage());
                            }

                        }while(snoFlag);
                        if(sno<= snoMap.size() && sno>0){
                            //Update query used to update
                            String paymentQuery = "UPDATE payment SET PAID_STATUS = 'PAID', PRICE = ? WHERE payment_id = ?";
                            PreparedStatement paymentStatement = DBConnection.getConnection().prepareStatement(paymentQuery);
                            paymentStatement.setDouble(1, totalPrice);
                            paymentStatement.setInt(2, snoMap.get(sno));
                            if(paymentStatement.executeUpdate()>0){
                                System.out.println("Paid success fully");
                            }
                        }
                        else {
                            System.out.println("Enter the Valid");
                        }

                    }
                    else if(option==2){
                        flag =false;
                    }
                    else{
                        System.out.println("Enter the valid Statement");
                    }
                }catch ( NumberInputException e){
                    flag = true;
                    System.out.println(e.getMessage());
                }
            }while(flag);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    //refund method implements to customer to raise the refund amount.
    public void refund() {
        try {
            String query = "SELECT p.payment_id, b.start_Date, h.hall_name, (b.end_date - b.start_date) AS Days, " +
                    "h.hall_price * (b.end_date - b.start_date) AS Total_Price, " +
                    "(h.hall_price * (b.end_date - b.start_date) - " +
                    "(SELECT NVL(SUM(price), 0) FROM payment p2 WHERE p2.book_id = b.book_id)) AS paid, " +
                    "p.paid_status " +
                    "FROM payment p " +
                    "JOIN booking b ON p.book_id = b.book_id " +
                    "JOIN halls h ON b.hall_id = h.hall_id " +
                    "WHERE b.user_id = ? AND b.start_Date > sysdate AND " +
                    "(p.paid_status = 'ADVANCED' OR p.paid_status = 'PAID' OR p.paid_status = 'REFUND REQUEST' OR p.paid_status = 'REFUNDED')";

            PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
            statement.setInt(1, this.getUserId()); // Set the user_id parameter
            ResultSet set = statement.executeQuery();

            System.out.println("+-----+---------------------+------------------+------+-------------+-------------+-----------------------+");
            System.out.println("| SNO |    Start Date       |    Hall Name     | Days | Total Price | Payable     |   Payment Status      |");
            System.out.println("+-----+---------------------+------------------+------+-------------+-------------+-----------------------+");

            boolean isPayFound = false;
            int i = 0;
            LinkedHashMap<Integer, Integer> snoMap = new LinkedHashMap<>(); // storing the paymentId as values and those serial numbers as key
            LinkedHashMap<Integer, String> statusMap = new LinkedHashMap<>(); // storing the paymentStatus as values and those serial numbers as key

            while (set.next()) {
                isPayFound = true;
                System.out.printf("| %-3d | %-19s | %-16s | %-4d | %-11.2f | %-11.2f | %-21s |\n",
                        ++i,
                        set.getDate("start_Date").toString(),
                        set.getString("hall_name"),
                        set.getInt("Days"),
                        set.getDouble("Total_Price"),
                        set.getDouble("paid"),
                        set.getString("paid_status"));
                snoMap.put(i, set.getInt("payment_id"));
                statusMap.put(i, set.getString("paid_status"));
            }

            if (!isPayFound) {
                System.out.println("| No payment is required at this time                                                               |");
            }

            System.out.println("+-----+---------------------+------------------+------+-------------+-------------+-----------------------+");

            if (isPayFound) {
                boolean flag = true;
                while (flag) {
                    try {
                        System.out.println("1. Request For Refund\n2. Back");
                        byte option = Validate.validateOption(sc.readLine().trim());
                        int sno = -1;

                        if (option == 1) {
                            boolean snoFlag = true;
                            while (snoFlag) {
                                try {
                                    System.out.println("Select number to raise request:");
                                    sno = Validate.validInteger(sc.readLine().trim());
                                    if (snoMap.containsKey(sno) && !statusMap.get(sno).equals("REFUNDED")) {
                                        snoFlag = false;
                                    } else {
                                        System.out.println("Selected payment is already refunded or invalid.");
                                        snoFlag = true;
                                    }
                                } catch (IntegerException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            if (!statusMap.get(sno).equals("REFUND REQUEST")) {
                                String paymentQuery = "UPDATE payment SET PAID_STATUS = 'REFUND REQUEST' WHERE payment_id = ?";
                                PreparedStatement paymentStatement = DBConnection.getConnection().prepareStatement(paymentQuery);
                                paymentStatement.setInt(1, snoMap.get(sno));
                                if (paymentStatement.executeUpdate() > 0) {
                                    System.out.println("Your request has been raised.");
                                }
                                paymentStatement.close();
                            } else {
                                System.out.println("Request already sent.");
                            }
                        } else if (option == 2) {
                            flag = false;
                        } else {
                            System.out.println("Enter a valid option.");
                        }
                    } catch (NumberInputException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            // Close the ResultSet and PreparedStatement to free resources
            set.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //bookingHall method used to book the hall by the customer
    public void bookingHall(Hall hall) {// User can able to book the hall
        boolean flag = false;
        do{
            try{
                Book book = new Book();
                book.setHallId(hall.hallId);
                int i = 0;
                System.out.println("Hall Apt for do : ");
                HashMap<Integer,Integer> eventMap = new HashMap<>();
                for(Events event : hall.getEvents()){
                    System.out.println((++i)+" . "+event.getEventName());
                    eventMap.put(i,event.getEventId());
                }
                int eventId = -1;
                do{
                    try{
                        System.out.print("Select an Event (enter number) or 'E' to exit: ");
                        String option = sc.readLine().trim();
                        if (option.equalsIgnoreCase("E")) {
                            System.out.println("Exiting the selection.");
                            return;
                        }

                        int temp = Integer.parseInt(option);
                        if(eventMap.containsKey(temp) && (eventMap.size()>=temp && temp>0)){
                            eventId = eventMap.get(temp);
                            break;
                        }
                        else {
                            System.out.println("Invalid Input, Give input between 1 to "+eventMap.size());                    }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                while(true);


                /*Showing the arrangement type to select for the hall*/
                HashMap<Integer,Integer> arrangementMap = new HashMap<>();//Stored in the ID as SNO
                i = 0;
                System.out.println("+------+-------------------------+------------+");
                System.out.println("|SNO   |    Arrangement Type     |   Capacity |");
                System.out.println("+------+-------------------------+------------+");
                for(Seats arrangement : hall.getSeat()){
                    System.out.printf("| %-5d | %-24s | %-10d |\n", ++i, arrangement.getArrangementType(),arrangement.getCapacity() );
                    arrangementMap.put(i,arrangement.getSeatId());
                }
                System.out.println("+------+-------------------------+------------+");
                int arrangementTypeID = -1;
                do{
                    try {
                        System.out.print("Select an Arrangement (enter number) or 'E' to exit: ");
                        String input = sc.readLine().trim();

                        if (input.equalsIgnoreCase("E")) {
                            System.out.println("Exiting the selection.");
                            return; // Exit the loop and method if 'E' is entered
                        }

                        int temp = Validate.validInteger(input); // Assuming validInteger handles validation

                        if ((temp <= arrangementMap.size() && temp > 0) && arrangementMap.containsKey(temp)) {
                            arrangementTypeID = arrangementMap.get(temp);
                            break; // Break the loop if a valid arrangement is selected
                        } else {
                            System.out.println("Invalid Input. Please enter a number between 1 and " + arrangementMap.size());
                        }
                    } catch (IntegerException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                }while (true);
                flag = false;
                LocalDateTime requestedTime = LocalDateTime.now();

                DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String formattedDateTime = requestedTime.format(formatterTime);


                LocalDate startDate = null;
                do{
                    try{
                        System.out.println("Enter the date to reserve (dd/MM/yyyy) :");
                        String strdate = Validate.validateDate(sc.readLine().trim());// getting input as start date
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        startDate = LocalDate.parse(strdate,formatter);

                        if(startDate.isBefore(LocalDate.now())){
                            System.out.println("Please enter the booking date in the future.");
                        }
                        else{
                            break;
                        }
                    }catch (DateValidator | IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }while (true);
                int  duriation = 0;
                flag =false;
                do{
                    try{
                        System.out.println("Enter the number of days");
                        duriation = Validate.validInteger(sc.readLine().trim());
                        break;
                    } catch (IntegerException | IOException e) {
                        flag = true;
                        System.out.println(e.getMessage());
                    }
                }while(flag);
                LocalDate endDate = startDate.plusDays(duriation);
                int bookId = PrimaryKeyProvider.primaryKey("Booking");
                book.setPersonId(this.getUserId());
                book.setBookId(bookId);
                book.setRequested(requestedTime);
                book.setStartDate(startDate);
                book.setEndDate(endDate);
                book.setBookingStatus(BookingStatus.PENDING);
                String bookingQuery = "INSERT INTO Booking values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement bookingStatement = DBConnection.getConnection().prepareStatement(bookingQuery);
                bookingStatement.setInt(1,book.getBookId());
                bookingStatement.setInt(2,book.getPersonId());
                bookingStatement.setInt(3,book.getHallId());
                bookingStatement.setInt(4,eventId);
                bookingStatement.setInt(5,arrangementTypeID);
                bookingStatement.setTimestamp(6, Timestamp.valueOf(requestedTime));
                bookingStatement.setDate(7, java.sql.Date.valueOf(startDate));
                bookingStatement.setDate(8,java.sql.Date.valueOf(endDate));
                bookingStatement.setString(9,book.getBookingStatus().toString());
                if(bookingStatement.executeUpdate()>0){
                    System.out.println("*******************************************");
                    System.out.println("*                                         *");
                    System.out.println("*           ---Requested Sent---          *");
                    System.out.println("*                                         *");
                    System.out.println("*******************************************");
                }
            }catch (SQLException ex){
                flag = true;
                System.out.println(ex.getMessage());
            }
        }while (flag);
    }

    @Override
    public int compareTo(Customer customer) {
        return this.getName().compareTo(customer.getName());
    }
}
