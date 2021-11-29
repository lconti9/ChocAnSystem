import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Group Member: Caroline Johnson
Class: Member.java
Description: Holds attributes and get/set methods for Member
Status: Complete
*/

public class Member {

    // private variables to hold member data
    private String memberName;
    private int memberNumber;
    private String memberStatus;
    private String memberAddressStreet;
    private String memberAddressCity;
    private int memberAddressZipCode;
    private String memberAddressState;

    // initialize the variables to null
    public Member(int num) {
        memberName = null;
        memberNumber = num;
        memberStatus = null;
        memberAddressStreet = null;
        memberAddressCity = null;
        memberAddressZipCode = 0;
        memberAddressState = null;
    }

    public void saveToFile() throws IOException {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Member"
                + Integer.toString(this.memberNumber) + ".txt";
        try {
            File myObj = new File(filename);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter fWriter = new FileWriter(filename);
        String fileString = this.memberName + "," + Integer.toString(this.memberNumber) + "," + this.memberStatus + ","
                + this.memberAddressStreet + "," + this.memberAddressCity + ","
                + Integer.toString(this.memberAddressZipCode) + "," + this.memberAddressState;
        fWriter.write(fileString);
        fWriter.close();
    }

    public void openFromFile() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Member"
                + Integer.toString(this.memberNumber) + ".txt";
        if (checkMemberExistence()) {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            myReader.close();
            String[] info = data.split(",");
            this.setMemberName(info[0]);
            this.setMemberNumber(Integer.parseInt(info[1]));
            this.setMemberStatus(info[2]);
            this.setMemberAddressStreet(info[3]);
            this.setMemberAddressCity(info[4]);
            this.setMemberAddressZipCode(Integer.parseInt(info[5]));
            this.setMemberAddressState(info[6]);

        }
        return;
    }

    public void deleteMemberFile() {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Member"
                + Integer.toString(this.memberNumber) + ".txt";
        if (checkMemberExistence()) {
            File providerFile = new File(filename);
            providerFile.delete();
        }
        return;
    }

    public boolean checkMemberExistence() {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Member"
                + Integer.toString(this.memberNumber) + ".txt";
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                myObj.delete();
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    // method to get name
    public String getMemberName() {
        return memberName;
    }

    // method to get number
    public int getMemberNumber() {
        return memberNumber;
    }

    // method to get status
    public String getMemberStatus() {
        return memberStatus;
    }

    // method to get street address
    public String getMemberAddressStreet() {
        return memberAddressStreet;
    }

    // method to get city address
    public String getMemberAddressCity() {
        return memberAddressCity;
    }

    // method to get zip code address
    public int getMemberAddressZipCode() {
        return memberAddressZipCode;
    }

    // method to get state address
    public String getMemberAddressState() {
        return memberAddressState;
    }

    // method to set name
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // method to set number
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    // method to set status
    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    // method to set street address
    public void setMemberAddressStreet(String memberAddressStreet) {
        this.memberAddressStreet = memberAddressStreet;
    }

    // method to set city address
    public void setMemberAddressCity(String memberAddressCity) {
        this.memberAddressCity = memberAddressCity;
    }

    // method to set zip code address
    public void setMemberAddressZipCode(int memberAddressZipCode) {
        this.memberAddressZipCode = memberAddressZipCode;
    }

    // method to set state address
    public void setMemberAddressState(String memberAddressState) {
        this.memberAddressState = memberAddressState;
    }

}