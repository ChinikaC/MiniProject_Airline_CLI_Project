import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListWriterTest {

    AirportCustomerServices acs;
    Scanner scanner;

    @BeforeEach
    void setUp(){
        acs = new AirportCustomerServices("Heathrow");
    }

    @Test
    void canWritePassengersToFile(){
        acs.addPassenger(new Passenger("James","7438549","hskjdfhkjsf"));
        acs.addPassenger(new Passenger("sjdlkasd","7438549","hskjdfhkjsf"));
        assertThat(acs.getListOfPassengers().size()).isEqualTo(2);
        ListWriter.writePassengersToFile(acs);
        File file = new File("src/main/passengers.txt");
        try{
            scanner = new Scanner(file);
        }
        catch(Exception e){
            System.out.println("Error");
        }
        assertThat(scanner.nextLine()).isEqualTo("2");
    }
}
