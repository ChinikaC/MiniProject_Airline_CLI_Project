import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AirportCustomerServicesTest {

    Flight flight;
    Passenger passenger;

    AirportCustomerServices acs;


    @BeforeEach
    public void setUp() {
        flight = new Flight("London", "Cessna 152");
        passenger = new Passenger("Chinika", "07785612348", "cccohorteight@bnta.com");
        acs = new AirportCustomerServices("Booker");
    }

    @Test
    void canAddFlight(){
        acs.addFlight(flight);
        assertThat(acs.getListOfFlights().size()).isEqualTo(1);
    }

    @Test
    void canAddPassenger(){
        acs.addPassenger(passenger);
        assertThat(acs.getListOfPassengers().size()).isEqualTo(1);
    }

    @Test
    void canAddPassengerToFlight(){
        acs.addPassengerToFlight(passenger, flight);
        assertThat(acs.getListOfPassengers().size()).isEqualTo(0);
        assertThat(flight.getPassengers().size()).isEqualTo(1);
    }

    @Test
    void canCancelFlight(){
        acs.addFlight(flight);
        assertThat(acs.getListOfFlights().size()).isEqualTo(1);
        flight.addPassengerToFlight(passenger);
        acs.cancelFlight(flight);
        assertThat(acs.getListOfFlights().size()).isEqualTo(0);
        assertThat(acs.getListOfPassengers().size()).isEqualTo(1);
    }

}
