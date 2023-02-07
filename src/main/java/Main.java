import java.util.Scanner;

public class Main {
    private static Scanner reader;
    private static AirportCustomerServices acs;
    public static void main(String[] args) {
        reader = new Scanner(System.in);
        acs  = new AirportCustomerServices("This Airport");



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

    //display all available flights
    public static void listFlights() {
        System.out.println("\nPlease see below all available flight from " + acs.getName()+":");
        for (Flight flight : acs.getListOfFlights())
            System.out.println("There is a flight to " + flight.getDestination() + ". It is operated on a "
                    + flight.getPlane() + ". There are " + flight.getPassengers().size() + " passengers on this flight.");
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
}
