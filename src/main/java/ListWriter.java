import java.io.File;
import java.io.FileWriter;

public class ListWriter {
    static FileWriter writer;

    public static void writePassengersToFile(AirportCustomerServices acs){
        try {
            File passengers = new File("src/main/passengers.txt");
            writer = new FileWriter(passengers);
            writer.write(String.valueOf(acs.getListOfPassengers().size()) + "\n");
            for (Passenger pass : acs.getListOfPassengers()) {
                writer.write(pass.getName()+"\n");
                writer.write(pass.getPhoneNum()+"\n");
                writer.write(pass.getEmailAddress()+"\n");
                writer.write(pass.getUniqueID().toString()+"\n");
            }
            writer.close();
        }
        catch(Exception e){
            System.out.println("An error happened");
        }
    }
}
