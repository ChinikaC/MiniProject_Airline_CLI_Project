import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AirportCustomerServices {

    private String name;
    private List<Flight> listOfFlights;
    private Set<Passenger> listOfPassengers;

    public AirportCustomerServices(String name){
        this.name=name;
        this.listOfFlights = new ArrayList<>();
        this.listOfPassengers = new HashSet<>();
    }

    //Getters

    public String getName() {
        return name;
    }

    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public Set<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

    //Setter

    public void setNewName(String name) {
        this.name = name;
    }

    public void addFlight(Flight flight){
        listOfFlights.add(flight);
    }

    public void takeOffFlight(Flight flight) {
        listOfFlights.remove(flight);
    }

    public void addPassenger(Passenger passenger){
        listOfPassengers.add(passenger);
    }

    public void addPassengerToFlight(Passenger pass,Flight flight){
        this.listOfPassengers.remove(pass);
        flight.addPassengerToFlight(pass);
    }

    public void cancelFlight(Flight flight) {
//        for(Passenger passenger : flight.getPassengers()) {
//            listOfPassengers.add(passenger);
//        }
        listOfPassengers.addAll(flight.getPassengers());
        this.listOfFlights.remove(flight);
    }
}
