import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {

    Flight flight;
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

    @Test
    public void canGenUUID(){
        assertThat(flight.getFlightID()).isNotEqualTo(null);
    }


}
