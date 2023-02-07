import java.util.Scanner;

public class Main {
    private static Scanner reader;
    private static AirportCustomerServices acs;
    public static void main(String[] args) {
        reader = new Scanner(System.in);
        acs  = new AirportCustomerServices("This Airport");

        // boolean to determine running/not running of program
        boolean runner = true;
        ListReader.readPassengers(acs);

        while(runner) {
        // take input
        String input = reader.nextLine();

            switch (input) {
                case "help":
                    System.out.println("The commands are as follows:\n\nhelp - shows list of commands" +
                            "\nexit - exits the program\naddFlight - adds flight to airport" +
                            "\nlistAllFlights - displays information for all flights" +
                            "\naddPassenger - adds passenger to airport\nbookPassenger - books passenger onto flight" +
                            "\ncancelFlight - cancels flight and returns passenger(s) to airport" +
                            "\nsearchFlight - searches flights to a destination" +
                            "\nlistAllPassengers - displays information for all passengers" +
                            "\ntakeOff - departs a flight from the airport");
                    break;
                case "exit":
                    runner = false;
                    ListWriter.writePassengersToFile(acs);
                    break;
                case "addFlight":
                    addFlight();
                    break;
                case "listAllFlights":
                    listFlights();
                    break;
                case "addPassenger":
                    addPassenger();
                    break;
                case "bookPassenger":
                    bookPassenger();
                    break;
                case "cancelFlight":
                    cancelFlight();
                    break;
                case "searchFlight":
                    searchFlight();
                    break;
                case "listAllPassengers":
                    listPassengers();
                    break;
                case "takeOff":
                    flightTakeOff();
                    break;
                default:
                    System.out.println("Error - unrecognised command!");

            }

        }


    }

    //add a new flight - need string for destination and string for plane
    public static void addFlight() {
        System.out.println("\nWhere should the plane go?");
        String inputDestination = reader.nextLine();
        System.out.println("Please enter the type of plane:");
        String inputPlane = reader.nextLine();
        Flight flight = new Flight(inputDestination, inputPlane);
        acs.addFlight(flight);
        System.out.println("Added new flight to " + flight.getDestination()
                + " with Unique Identifier: " + flight.getFlightID());
    }

    //take-off command
    public static void flightTakeOff(){
        System.out.println("Please enter below the flight details that you would like to depart:");
        System.out.println("Destination:");
        String inputDestination = reader.nextLine();
        System.out.println("Type of plane:");
        String inputPlane = reader.nextLine();
        Flight flightToTakeOff = null;
        for (Flight flight : acs.getListOfFlights()) {
            if (flight.getDestination().equals(inputDestination) && flight.getPlane().equals(inputPlane)) {
                flightToTakeOff = flight;
                break;
            }
        }
        try{
            System.out.println("Goodmorning this is your captain speaking, we will get to " + flightToTakeOff.getDestination() + " soon!");
            acs.takeOffFlight(flightToTakeOff);
        }
        catch(Exception e){
            System.out.println("That flight doesn't exist");
        }
    }

    //display all available flights
    public static void listFlights() {
        System.out.println("\nPlease see below all available flight from " + acs.getName()+":");
        for (Flight flight : acs.getListOfFlights())
            System.out.println("There is a flight to " + flight.getDestination() + ". It is operated on a "
                    + flight.getPlane() + ". There are " + flight.getPassengers().size() + " passengers on this flight.");
    }

    //list all passengers in the airport
    public static void listPassengers(){
        System.out.println("\nPlease see below all passengers in " + acs.getName()+":");
        for (Passenger pass : acs.getListOfPassengers())
            System.out.println("There is a passenger called " + pass.getName() + ". They have the unique ID: "
                    + pass.getUniqueID() + ".");
    }

    //add a new passenger to the airport system
    public static void addPassenger(){
        System.out.println("\nPlease enter the details of the passenger you would like to add below:\nName:");
        String inputName = reader.nextLine();
        System.out.println("Phone Number:");
        String inputNumber = reader.nextLine();
        System.out.println("Email address:");
        String inputEmail = reader.nextLine();
        Passenger passenger = new Passenger(inputName,inputNumber,inputEmail);
        acs.addPassenger(passenger);
        System.out.println("Added new passenger to " + acs.getName()
                + " called " + passenger.getName()
                + " with Unique Identifier: " + passenger.getUniqueID());
    }

    //booking a passenger onto a flight
    public static void bookPassenger() {
        System.out.println("\nPlease enter below the passenger's details that you would like to book onto a flight:\nName:");
        String inputName = reader.nextLine();
        System.out.println("Phone Number:");
        String inputNumber = reader.nextLine();
        System.out.println("Email address:");
        String inputEmail = reader.nextLine();
        Passenger passToAdd = null;
        for (Passenger pass : acs.getListOfPassengers()) {
            if (pass.getName().equals(inputName) && pass.getPhoneNum().equals(inputNumber)
                    && pass.getEmailAddress().equals(inputEmail)) {
                passToAdd = pass;
                break;
            }
        }
        System.out.println("Please enter below the flight details that you would like to book the passenger onto:");
        System.out.println("Destination:");
        String inputDestination = reader.nextLine();
        System.out.println("Type of plane:");
        String inputPlane = reader.nextLine();
        Flight flightToAddTo = null;
        for (Flight flight : acs.getListOfFlights()) {
            if (flight.getDestination().equals(inputDestination) && flight.getPlane().equals(inputPlane)) {
                flightToAddTo = flight;
                break;
            }
        }
        try {
            acs.addPassengerToFlight(passToAdd, flightToAddTo);
            System.out.println(passToAdd.getName() + " has been added to the flight to " + flightToAddTo.getDestination());
        } catch (Exception e) {
            System.out.println("Please enter the right plane and passenger info!");
        }
    }

    //cancel a flight
    public static void cancelFlight(){
        System.out.println("\nPlease enter below the flight details that you would like to cancel:");
        System.out.println("Destination:");
        String inputDestination = reader.nextLine();
        System.out.println("Type of plane:");
        String inputPlane = reader.nextLine();
        Flight flightToCancel = null;
        for(Flight flight : acs.getListOfFlights()) {
            if (flight.getDestination().equals(inputDestination) && flight.getPlane().equals(inputPlane)) {
                flightToCancel = flight;
                break;
            }
        }
        try {
            acs.cancelFlight(flightToCancel);
            System.out.println("The plane to " + flightToCancel.getDestination() + " has been canceled.");
        }
        catch(Exception e){
            System.out.println("Please enter the right plane info!");
        }
    }

    // adding search functionality
    public static void searchFlight(){
        System.out.println("\nPlease enter the destination you would like to search flight(s) for: ");
        int numberOfFlights = 0;
        String destination = reader.nextLine();

        for(Flight flight: acs.getListOfFlights()){
            if (flight.getDestination().equals(destination)){
                System.out.println("There is a flight to " + flight.getDestination()
                        + " with Unique Identifier: " + flight.getFlightID() +
                        " operated on a " + flight.getPlane());
                numberOfFlights++;
            }
        }
        if(numberOfFlights == 0){
            System.out.println("There are no flights to " + destination);
        }

    }



}
