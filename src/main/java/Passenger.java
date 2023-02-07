import java.util.UUID;

public class Passenger {

    private String name;
    private String phoneNum;
    private final UUID uniqueID;
    private String emailAddress;

    public Passenger(String name, String phoneNum,String emailAddress){
        this.name=name;
        this.phoneNum=phoneNum;
        this.emailAddress=emailAddress;
        this.uniqueID = UUID.randomUUID();
    }

    public Passenger(String name, String phoneNum, String emailAddress, UUID uniqueID){
        this.name = name;
        this.phoneNum = phoneNum;
        this.emailAddress = emailAddress;
        this.uniqueID = uniqueID;
    }

    //Getters
    public String getName() {
        return name;
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
