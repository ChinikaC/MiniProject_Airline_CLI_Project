import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Flight {

    private String destination;
    private final UUID flightID;
    private String plane;
    private Set<Passenger> passengers;

    public Flight(String destination, String plane) {
        this.destination = destination;
        this.flightID = UUID.randomUUID();
        this.plane = plane;
        this.passengers = new HashSet<>();
    }


    // Getters
    public String getDestination() {
        return destination;
    }

    public UUID getFlightID() {
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

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Methods
    public void addPassengerToFlight(Passenger passenger){
        this.passengers.add(passenger);
    }


}
