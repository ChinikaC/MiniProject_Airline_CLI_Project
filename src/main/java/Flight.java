import java.util.Set;

public class Flight {

    private String destination;
    private int flightID;
    private String plane;
    private Set<Passenger> passengers;

    public Flight(String destination, int flightID, String plane, Set<Passenger> passengers) {
        this.destination = destination;
        this.flightID = flightID;
        this.plane = plane;
        this.passengers = passengers;
    }


    // Getters
    public String getDestination() {
        return destination;
    }

    public int getFlightID() {
        return flightID;
    }

    public String getPlane() {
        return plane;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    // Setters

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Methods
    public void addPassengerToFlight(Passenger passenger){

    }


}
