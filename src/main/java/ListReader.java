import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class ListReader {

    static Scanner passengerReader;
    //static Scanner flightReader = new Scanner("src/main/flightList.txt");

//    public static void main(String[] args) {
//        File text = new File("src/main/passengers.txt");
//        try{
//            passengerReader = new Scanner(text);
//        }
//        catch(Exception e){
//            System.out.println("error");
//        }
//        Passenger guy = readPassenger();
//        System.out.println(guy.getName()+ guy.getUniqueID().toString());
//
//    }

    public static HashSet<Passenger> readPassengers(AirportCustomerServices acs){
        File text = new File("src/main/passengers.txt");
        try{
            passengerReader = new Scanner(text);
        }
        catch(Exception e){
            System.out.println("error");
        }
        int length = passengerReader.nextInt();
        passengerReader.nextLine();
        HashSet<Passenger> passengerList = new HashSet<>();
        for (int i = 0; i<length;i++){
            String name = passengerReader.nextLine();
            String number = passengerReader.nextLine();
            String email = passengerReader.nextLine();
            UUID uniqueID = UUID.fromString(passengerReader.nextLine());
            acs.addPassenger(new Passenger(name, number, email, uniqueID));
        }

        return passengerList;
    }

}
