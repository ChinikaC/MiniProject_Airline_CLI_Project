import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class FileReader {

    static Scanner passengerReader;
    //static Scanner flightReader = new Scanner("src/main/flightList.txt");

    public static void main(String[] args) {
        File text = new File("src/main/passengers.txt");
        try{
            passengerReader = new Scanner(text);
        }
        catch(Exception e){
            System.out.println("error");
        }
        Passenger guy = readPassenger();
        System.out.println(guy.getName()+ guy.getUniqueID().toString());

    }

    public static Passenger readPassenger(){
        String name = passengerReader.nextLine();
        String number = passengerReader.nextLine();
        String email = passengerReader.nextLine();
        UUID uniqueID = UUID.fromString(passengerReader.nextLine());
        return new Passenger(name,number,email,uniqueID);
    }

}
