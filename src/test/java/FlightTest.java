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
        flight2 = new Flight("dksfj","fks");
        passenger = new Passenger("Chinika", "07785612348", "cccohorteight@bnta.com");
    }

    @Test
    public void canAddPassenger(){
        flight.addPassengerToFlight(passenger);
        assertThat(flight.getPassengers().size()).isEqualTo(1);
    }

    @RepeatedTest(100000)
    public void canGenUUID(){
        assertThat(flight.getFlightID()).isNotEqualTo(flight2.getFlightID());
    }


}
