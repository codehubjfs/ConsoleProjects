package com.hallbookingsystem.searchdetails;
import com.hallbookingsystem.bookingdetails.Book;
import com.hallbookingsystem.customexception.NumberInputException;
import com.hallbookingsystem.dbconnection.DBConnection;
import com.hallbookingsystem.halldetails.Amenity;
import com.hallbookingsystem.halldetails.Events;
import com.hallbookingsystem.halldetails.Hall;
import com.hallbookingsystem.customexception.IntegerException;
import com.hallbookingsystem.customexception.Validate;
import com.hallbookingsystem.halldetails.Seats;
import com.hallbookingsystem.persondetails.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

class SortByPrice implements Comparator<Hall> {

    @Override
    public int compare(Hall hall1, Hall hall2) {
        return Float.compare(hall1.getPrice(),hall2.getPrice());
    }

}
class  SortByName implements Comparator<Hall>{
    @Override
    public int compare(Hall hall1, Hall hall2) {
        return hall1.getHallName().compareTo(hall2.getHallName());
    }
}
/**
 * Class HallDirectory implements the Search  interface , it has hall list, Event List and Amenities List,
 * and more sorting and searching  hall by capacity and exit
 * @author Sanjai
 * @since 08-May-2024
* */
public class HallDirectory implements Search{
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void searchByName(Customer customer) {
        int[] i = {0};
        Map<Integer,Hall> hallMap= null;
        try{
            System.out.println("Enter the Name of Hall :" );
            String name = sc.readLine().trim();
            List<Hall> list = listHall();
            System.out.println("+-------------------------------------------------------------------+");
            System.out.printf("│ %-7s │ %-20s │ %-16s │ %-10s │ %-10s │%n","SNO","Hall Name", "Price per Day", "Capacity", "AC");
            System.out.println("+-------------------------------------------------------------------+");
            hallMap = list.stream()
                    .filter(x -> x.getHallName().equalsIgnoreCase(name) && x.isAvail())
                    .peek(hall -> System.out.printf("| %-7d | %-20s | %-16.2f | %-10d | %-10s | %-80s |%n",
                            ++i[0], hall.getHallName(), hall.getPrice(), hall.getCapacity(), hall.getIsAcHall() ? "Yes" : "No",hall.getAmenities()
                                    .stream().map(Amenity::getAmenityType).reduce((str1,str2)->str1+","+str2).orElse("")))
                    .collect(Collectors.toMap(hall -> i[0], hall -> hall));
            System.out.println("+-------------------------------------------------------------------+");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        boolean optionFlag = false ;
        do{
            try{
                System.out.println("1. Book Hall \n2. Back ");
                String option = sc.readLine().trim();
                if(option.matches("1")){
                    customer.bookingHall(hallMap.get(1));
                }
                else if(option.matches("2")){
                    return;
                }
                else{
                    optionFlag = true;
                    System.out.println("Enter valid Input");
                }
            } catch (IOException e) {
                optionFlag = true;
                System.out.println(e.getMessage());
            }
        }while (optionFlag);
    }

// searchByPrice method used to show the hall according to user maximum budget
    @Override
    public void searchByPrice(Customer customer) {

        System.out.println("Enter the Max Budget per day :");
        float maxPrice =0.0f;
        boolean flag = false;
        int [] i={0};
        do{
            try{
                maxPrice = Validate.validInteger(sc.readLine().trim());
            }
            catch (IOException | IntegerException e) {
                flag =true;
                System.out.println(e.getMessage());
            }
        }while (flag);

        float finalMaxPrice = maxPrice;
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                             Sorted By Price                                                                      |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        Map<Integer, Hall> hallMap = listHall().stream()
                .filter(hall -> hall.getPrice() <= finalMaxPrice && hall.isAcHall())
                .peek(hall -> System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n",
                        ++i[0], hall.getHallName(), hall.getPrice(), hall.getCapacity(), hall.getIsAcHall() ? "Yes" : "No",hall.getAmenities()
                                .stream().map(Amenity::getAmenityType).reduce((str1,str2)->str1+","+str2).orElse("")))
                .collect(Collectors.toMap(hall -> i[0], hall -> hall));
        System.out.println("+-------------------------------------------------------------------+");
       boolean optionFlag = false;
        do {
            try{
                System.out.println("Enter the Hall number to book or 'B' to go back:");

                String input = sc.readLine().trim();
                if (input.equalsIgnoreCase("B")) {
                    return; // Exit the method if the user chooses to go back
                } else {
                    try {
                        int hallKey = Integer.parseInt(input);
                        Hall selectedHall = hallMap.get(hallKey);
                        if (selectedHall != null) {
                            customer.bookingHall(selectedHall);
                        } else {
                            System.out.println("Invalid Hall number. Please try again.");
                            optionFlag = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Hall number.");
                        optionFlag = true;
                    }
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (optionFlag);

    }
    //searchByCapacity method used to display the details of the hall by capacity
    @Override
    public void searchByCapacity(Customer customer) {
        // Prompt user to enter the minimum capacity
        System.out.println("Enter the Min Capacity :" );
        boolean flag = false;
        int [] index = {0};
        int minCapacity = 0;
        do {
            try {
                // Validate and parse the input for minimum capacity
                minCapacity = Validate.validInteger(sc.readLine().trim());
                flag = false; // Set flag to false if no exception occurs
            } catch (IOException | IntegerException e) {
                flag = true; // Set flag to true if an exception occurs
                System.out.println(e.getMessage());
            }
        } while (flag); // Loop until a valid minimum capacity is entered

        // Prompt user to enter the maximum capacity
        System.out.println("Enter the Max Capacity :");
        int maxCapacity = 0;
        do {
            try {
                // Validate and parse the input for maximum capacity
                maxCapacity = Validate.validInteger(sc.readLine().trim());
                flag = false; // Set flag to false if no exception occurs
            } catch (IOException | IntegerException e) {
                flag = true; // Set flag to true if an exception occurs
                System.out.println(e.getMessage());
            }
        } while (flag); // Loop until a valid maximum capacity is entered

        // Filter halls based on capacity range and if the hall has AC
        float finalMinCapacity = minCapacity;
        float finalMaxCapacity = maxCapacity;
        List<Hall> filteredHalls = listHall().stream()
                .filter(hall -> hall.getCapacity() >= finalMinCapacity && hall.getCapacity() <= finalMaxCapacity && hall.isAcHall())
                .toList();

        // Display the filtered halls in a formatted table
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                             Sorted By Capacity                                                                   |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n", "Sno", "Hall Name", "Price", "Capacity", "AC", "Amenities");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        Map<Integer, Hall> hallMap = filteredHalls.stream().filter(Hall::isAvail)
                .peek(hall -> System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n",
                        ++index[0], hall.getHallName(), hall.getPrice(), hall.getCapacity(), hall.getIsAcHall() ? "Yes" : "No",
                        hall.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1, str2) -> str1 + "," + str2).orElse("")))
                .collect(Collectors.toMap(hall -> index[0], hall -> hall));
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");

        // Prompt user to select a hall to book or go back
        boolean optionFlag = false;
        do {
            try {
                System.out.println("Enter the Hall number to book or 'B' to go back:");
                String input = sc.readLine().trim();
                if (input.equalsIgnoreCase("B")) {
                    return; // Exit the method if the user chooses to go back
                } else {
                    try {
                        int hallKey = Integer.parseInt(input);
                        Hall selectedHall = hallMap.get(hallKey);
                        if (selectedHall != null) {
                            customer.bookingHall(selectedHall); // Proceed to book the selected hall
                        } else {
                            System.out.println("Invalid Hall number. Please try again.");
                            optionFlag = true; // Continue prompting if an invalid hall number is entered
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Hall number.");
                        optionFlag = true; // Continue prompting if the input is not a valid number
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (optionFlag); // Loop until a valid hall number is entered or user chooses to go back
    }

    public void suggestedHalls(Customer customer) {
        List<Hall> halls = listHall();
        int index[] ={0};
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                             Sorted By Suggested Halls                                                            |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        Map<Integer,Hall> hallMap= halls.stream().filter(Hall::isAvail)
                .sorted(Comparator.comparingDouble(hall -> hall.getPrice() / hall.getCapacity()))
                .peek(hall -> System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n",++index[0],hall.getHallName(), hall.getPrice(), hall.getCapacity(),
                        hall.getIsAcHall() ? "Yes" : "No",hall.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1,str2)->str1+","+str2).orElse("")))
                .collect(Collectors.toMap(hall -> index[0], hall -> hall));
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        boolean optionFlag = false;
        do {
            try{
                System.out.println("Enter the Hall number to book or 'B' to go back:");

                String input = sc.readLine().trim();
                if (input.equalsIgnoreCase("B")) {
                    return; // Exit the method if the user chooses to go back
                } else {
                    try {
                        int hallKey = Integer.parseInt(input);
                        Hall selectedHall = hallMap.get(hallKey);
                        if (selectedHall != null) {
                            customer.bookingHall(selectedHall);

                        } else {
                            System.out.println("Invalid Hall number. Please try again.");
                            optionFlag = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Hall number.");
                        optionFlag = true;
                    }
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (optionFlag);

    }

    public  static void shortByPrice(Customer customer){
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                               Sorted By Price                                                                    |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");

        HallDirectory  hallDirectory = new HallDirectory();
        List<Hall> halls = hallDirectory.listHall();
        Map<Integer,Hall> hallMap = new HashMap<>();

        halls.sort(new SortByPrice());

        int i = 0;
        for (Hall list : halls) {
            String amenities = list.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1, str2) -> str1 + ", " + str2).orElse("");
            System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n", ++i,list.getHallName(), list.getPrice(), list.getCapacity(), list.getIsAcHall() ? "Yes" : "No",amenities);
            hallMap.put(i,list);
        }
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");

        boolean optionFlag = false;
        do {
            try{
                System.out.println("Enter the Hall number to book or 'B' to go back:");

                String input = sc.readLine().trim();
                if (input.equalsIgnoreCase("B")) {
                    return; // Exit the method if the user chooses to go back
                } else {
                    try {
                        int hallKey = Integer.parseInt(input);
                        Hall selectedHall = hallMap.get(hallKey);
                        if (selectedHall != null) {
                            customer.bookingHall(selectedHall);

                        } else {
                            System.out.println("Invalid Hall number. Please try again.");
                            optionFlag = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Hall number.");
                        optionFlag = true;
                    }
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (optionFlag);

    }
    public static void shortByCapacity(Customer customer){

    HallDirectory  hallDirectory = new HallDirectory();
    List<Hall> halls = hallDirectory.listHall();
    Map<Integer,Hall> hallMap = new HashMap<>();
    Collections.sort(halls);// it sorts the capacity with use of comparable functional interface implemented on halls
    System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
    System.out.println("|                                                               Sorted By Capacity                                                                 |");
    System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
    System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
    System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
    int i =0;
    for (Hall list : halls) {
        String amenities = list.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1, str2) -> str1 + ", " + str2).orElse("");
        System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n", ++i,list.getHallName(), list.getPrice(), list.getCapacity(), list.getIsAcHall() ? "Yes" : "No",amenities);
        hallMap.put(i,list);
    }
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        boolean optionFlag = false;
        do {
            try{
                System.out.println("Enter the Hall number to book or 'B' to go back:");

                String input = sc.readLine().trim();
                if (input.equalsIgnoreCase("B")) {
                    return; // Exit the method if the user chooses to go back
                } else {
                    try {
                        int hallKey = Integer.parseInt(input);
                        Hall selectedHall = hallMap.get(hallKey);
                        if (selectedHall != null) {
                            customer.bookingHall(selectedHall);

                        } else {
                            System.out.println("Invalid Hall number. Please try again.");
                            optionFlag = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Hall number.");
                        optionFlag = true;
                    }
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (optionFlag);
    }
        public static void shortByName(Customer customer){
            HallDirectory  hallDirectory = new HallDirectory();
            Map<Integer,Hall> hallMap = new HashMap<>();
            List<Hall> halls = hallDirectory.listHall();
            halls.sort(new SortByName());//it sorts the capacity with use of Comparator functional interface implemented on halls
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                               Sorted By Name                                                                    |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            int i =0;
            for (Hall list : halls) {
                String amenities = list.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1, str2) -> str1 + ", " + str2).orElse("");
                System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n", ++i,list.getHallName(), list.getPrice(), list.getCapacity(), list.getIsAcHall() ? "Yes" : "No",amenities);
                hallMap.put(i,list);
            }
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            boolean optionFlag = false;
            do {
                try{
                    System.out.println("Enter the Hall number to book or 'B' to go back:");

                    String input = sc.readLine().trim();
                    if (input.equalsIgnoreCase("B")) {
                        return; // Exit the method if the user chooses to go back
                    } else {
                        try {
                            int hallKey = Integer.parseInt(input);
                            Hall selectedHall = hallMap.get(hallKey);
                            if (selectedHall != null) {
                                customer.bookingHall(selectedHall);

                            } else {
                                System.out.println("Invalid Hall number. Please try again.");
                                optionFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid Hall number.");
                            optionFlag = true;
                        }
                    }
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } while (optionFlag);
        }

    public void searchByEvent(Customer customer) {
        try {
            List<Events> eventName = eventList();
            int i = 0;
            LinkedHashMap<Integer, Integer> eventMap = new LinkedHashMap<>();
            System.out.println("------------------------------------------");
            System.out.printf("| %-5s | %-20s | %n", "SNo", "Events Type");
            System.out.println("------------------------------------------");
            for (Events event : eventName) {
                System.out.printf("| %-5d | %-20s | %n", ++i, event.getEventName());
                eventMap.put(i, event.getEventId());
            }
            System.out.println("------------------------------------------");
            int optionEent = -1;
            do {
                try {
                    System.out.println("Enter the option :");
                    optionEent = Validate.validateOption(sc.readLine().trim());
                    if (optionEent > eventMap.size() && optionEent < 0) {
                        System.out.println("Invalid input enter the valid Input");
                    } else {
                        break;
                    }
                } catch (IOException | NumberInputException e) {
                    System.out.println(e.getMessage());
                }

            } while (true);

            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");

            // Get the selected event ID from the map
            int selectedEventId = eventMap.get(optionEent);

            // Filter halls based on the selected event ID
            List<Hall> filteredHalls = listHall().stream()
                    .filter(hall -> hall.getEvents().stream()
                            .anyMatch(event -> event.getEventId() == selectedEventId))
                    .toList();
            int k[] = {0};
            // Display details of filtered halls
            Map<Integer,Hall> hallMap= filteredHalls.stream().peek(hall -> System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n",++k[0],hall.getHallName(), hall.getPrice(), hall.getCapacity(),
                            hall.getIsAcHall() ? "Yes" : "No",hall.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1,str2)->str1+","+str2).orElse("")))
                    .collect(Collectors.toMap(hall -> k[0], hall -> hall));;

            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            boolean optionFlag = false;
            do {
                try{
                    System.out.println("Enter the Hall number to book or 'B' to go back:");

                    String input = sc.readLine().trim();
                    if (input.equalsIgnoreCase("B")) {
                        return; // Exit the method if the user chooses to go back
                    } else {
                        try {
                            int hallKey = Integer.parseInt(input);
                            Hall selectedHall = hallMap.get(hallKey);
                            if (selectedHall != null) {
                                customer.bookingHall(selectedHall);

                            } else {
                                System.out.println("Invalid Hall number. Please try again.");
                                optionFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid Hall number.");
                            optionFlag = true;
                        }
                    }
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } while (optionFlag);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void searchByArrangement(Customer customer) {
        try{
            List<Seats> seatArrangementNames = new Seats().arrangementList();
            int i = 0;
            LinkedHashMap<Integer, Integer> seatMap = new LinkedHashMap<>();
            System.out.println("--------------------------------");
            System.out.printf("| %-5s | %-20s | %n", "SNo", "Seat Type");
            System.out.println("--------------------------------");
            for (Seats seat : seatArrangementNames ) {
                System.out.printf("| %-5d | %-20s | %n", ++i, seat.getArrangementType());
                seatMap.put(i, seat.getSeatId());
            }
            System.out.println("--------------------------------");
            int optionSeatType = -1;
            do {
                try {
                    System.out.println("Enter the option :");
                    optionSeatType = Validate.validateOption(sc.readLine().trim());
                    if (optionSeatType > seatMap.size() && optionSeatType < 0) {
                        System.out.println("Invalid input enter the valid Input");
                    } else {
                        break;
                    }
                } catch (IOException | NumberInputException e) {
                    System.out.println(e.getMessage());
                }

            } while (true);

            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-7s | %-20s | %-8s | %-10s | %-4s | %-80s |%n","Sno","Hall Name", "Price", "Capacity", "AC","Amenities");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            int selectSeatId = seatMap.get(optionSeatType);
            List<Hall> filteredHalls = listHall().stream().filter(hall -> hall.getSeat().stream().anyMatch(seat -> seat.getSeatId() == selectSeatId)).toList();
            Map<Integer,Hall> hallMap = new HashMap<>();
            i = 0;
            for (Hall hall : filteredHalls) {
                for (Seats seat : hall.getSeat()) {
                    if (seat.getSeatId() == selectSeatId) {
                        String amenities = hall.getAmenities().stream().map(Amenity::getAmenityType).reduce((str1, str2) -> str1 + ", " + str2).orElse("");
                        System.out.printf("| %-7d | %-20s | %-8.2f | %-10d | %-4s | %-80s |%n", ++i,hall.getHallName(), hall.getPrice(), hall.getCapacity(), hall.getIsAcHall() ? "Yes" : "No",amenities);
                        hallMap.put(i,hall);
                    }
                }
            }
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
            boolean optionFlag = false;
            do {
                try{
                    System.out.println("Enter the Hall number to book or 'B' to go back:");

                    String input = sc.readLine().trim();
                    if (input.equalsIgnoreCase("B")) {
                        return; // Exit the method if the user chooses to go back
                    } else {
                        try {
                            int hallKey = Integer.parseInt(input);
                            Hall selectedHall = hallMap.get(hallKey);
                            if (selectedHall != null) {
                                customer.bookingHall(selectedHall);
                            } else {
                                System.out.println("Invalid Hall number. Please try again.");
                                optionFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid Hall number.");
                            optionFlag = true;
                        }
                    }
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } while (optionFlag);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // eventList() method  store all events in an arrayList and return the arraylist
    public List<Events> eventList() throws SQLException {
        List<Events> eventList = new ArrayList<>();
        String query = "select * from event";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
        ResultSet set = statement.executeQuery();
        int eventId = -1;
        String eventName =null;
        while(set.next()){
            eventName = set.getString("event_name");
            eventId = set.getInt("event_id");

            eventList.add(new Events(eventId,eventName));
        }
        return eventList;
    }

    public ArrayList<Amenity> amenitiesList() {
        ArrayList<Amenity> amenitiesList = new ArrayList<>();
        try {
            String query = "SELECT amenity_id, amenity_name FROM amenities";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                amenitiesList.add(new Amenity(resultSet.getInt("amenity_id"), resultSet.getString("amenity_name")));
            }

            // Close ResultSet and PreparedStatement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return amenitiesList;
    }


    //listHall() method used to store all hall objects in list and return the list for manipulation
    public List<Hall>listHall(){
        List<Hall> listHall = new ArrayList<>();
        try{
            String hallQuery = "Select hall_id,hall_name,HALL_PRICE,IS_AC,HALLCAPACITY,HALLAVAIL from halls ";
            String eventsQuery ="SELECT e.event_id, e.event_name FROM event e JOIN book_event be ON e.event_id = " +
                    "be.event_id WHERE be.hall_id = ?";
            String seatQuery = "SELECT sa.ARRANGEMENT_ID, sa.arrangement_type, hs.capacity FROM Hall_Seating hs JOIN Seating_Arrangement sa ON hs.arrangement_id = sa.arrangement_id WHERE hs.hall_id = ?";
            String amenityQuery = "SELECT a.amenity_id, a.amenity_name, h.hall_id FROM amenities a JOIN amenties_hall" +
                    " ah ON a.amenity_id = ah.amenity_id JOIN halls h ON ah.hall_id = h.hall_id WHERE h.hall_id = ?";
            PreparedStatement hallStatement = DBConnection.getConnection().prepareStatement(hallQuery);
            ResultSet hallSet = hallStatement.executeQuery();
            while (hallSet.next()){
                int hallId = hallSet.getInt("hall_id");
                String hallName= hallSet.getString("hall_name");
                float hallPrice = hallSet.getFloat("HALL_PRICE");
                boolean isAc = hallSet.getString("IS_AC").equals("Yes");
                boolean isAvail = hallSet.getString("HALLAVAIL").equals("A");
                int hallCapacity =hallSet.getInt("HALLCAPACITY");
                // Statement to select the event
                PreparedStatement  eventStatement = DBConnection.getConnection().prepareStatement(eventsQuery);
                eventStatement.setInt(1,hallId);
                ResultSet eventSet = eventStatement.executeQuery();
                int eventId = -1;
                String eventName = null;
                LinkedHashSet<Events> eventHashSet = new LinkedHashSet<>();
                while(eventSet.next()){
                    eventId =eventSet.getInt("event_id");
                    eventName = eventSet.getString("event_name");
                    eventHashSet.add(new Events(eventId,eventName));
                }
                // Statement to select the seat
                PreparedStatement seatStatement  = DBConnection.getConnection().prepareStatement(seatQuery);
                seatStatement.setInt(1,hallId);
                ResultSet seatSeat = seatStatement.executeQuery();
                int arrangementId = -1;
                String arrangementType = null;
                int arrangementCapacity = -1;
                LinkedHashSet<Seats> seatHashSet = new LinkedHashSet<>();
                while(seatSeat.next()){
                    arrangementId = seatSeat.getInt("ARRANGEMENT_ID");
                    arrangementType =seatSeat.getString("arrangement_type");
                    arrangementCapacity = seatSeat.getInt("capacity");
                    seatHashSet.add(new Seats(arrangementId,arrangementType,arrangementCapacity));
                }
                //statement to select amenities

                PreparedStatement amenityStatement = DBConnection.getConnection().prepareStatement(amenityQuery);
                amenityStatement.setInt(1, hallId);
                ResultSet setResultAmenities = amenityStatement.executeQuery(); // Corrected to amenityStatement

                int amenityId = -1;
                String amenityType = null;
                LinkedHashSet<Amenity> amenitySet = new LinkedHashSet<>();

                while (setResultAmenities.next()) {
                    amenityId = setResultAmenities.getInt("AMENITY_ID");
                    amenityType = setResultAmenities.getString("AMENITY_NAME");
                    amenitySet.add(new Amenity(amenityId, amenityType));
                }

                listHall.add(new Hall(hallId,hallName,hallPrice,isAc,isAvail,hallCapacity,amenitySet,seatHashSet,eventHashSet));
            }
            return listHall;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listHall;
    }

}
