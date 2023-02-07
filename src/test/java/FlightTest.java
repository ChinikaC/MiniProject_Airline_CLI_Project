import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {

    Flight flight;
    Flight flight2;
    Passenger passenger;


    @BeforeEach
            public void setUp() {
        flight = new Flight("London", "Cessna 152");
        passenger = new Passenger("Chinika", "07785612348", "cccohorteight@bnta.com");
    }

    @Test
    public void canAddPassenger(){
        flight.addPassengerToFlight(passenger);
        assertThat(flight.getPassengers().size()).isEqualTo(1);
    }

    @RepeatedTest(10000)
    public void canGenUUID(){
        flight = new Flight("Abu Dhabi","777");
        flight2 = new Flight("New York","A380");
        assertThat(flight.getFlightID()).isNotEqualTo(flight2.getFlightID());
    }


}
