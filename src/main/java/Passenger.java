public class Passenger {

    private String name;
    private long phoneNum;
    private int uniqueID;
    private String emailAddress;

    public Passenger(String name, long phoneNum,String emailAddress){
        this.name=name;
        this.phoneNum=phoneNum;
        this.emailAddress=emailAddress;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public long getPhoneNum() {
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

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
}
