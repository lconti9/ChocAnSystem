/*
Group Member: Caroline Johnson
Class: Member.java
Description: Holds attributes and get/set methods for Member
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//method for main functionality
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

    //method to save member data to file
    public void saveToFile() throws IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "memberlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String filestring = "";
        if (checkMemberExistence()) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.split(",")[1].equals(Integer.toString(this.memberNumber))) {
                    filestring = filestring.concat(this.memberName + "," + Integer.toString(this.memberNumber) + ","
                            + this.memberStatus + ","
                            + this.memberAddressStreet + "," + this.memberAddressCity + ","
                            + Integer.toString(this.memberAddressZipCode) + "," + this.memberAddressState + "\n");
                } else {
                    filestring = filestring.concat(line + "\n");
                }
            }

        } else {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                filestring = filestring.concat(line + "\n");

            }
            filestring = filestring
                    .concat(this.memberName + "," + Integer.toString(this.memberNumber) + "," + this.memberStatus + ","
                            + this.memberAddressStreet + "," + this.memberAddressCity + "," +
                            Integer.toString(this.memberAddressZipCode) + "," + this.memberAddressState);
        }
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
        reader.close();
        return;
    }

    //method to open member data from file
    public void openFromFile() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "memberlist.txt";
        if (checkMemberExistence()) {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String line = myReader.nextLine();
            while (!line.split(",")[1].equals(Integer.toString(this.memberNumber))) {
                line = myReader.nextLine();
            }
            myReader.close();
            String[] info = line.split(",");
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

    //method to delete member data from file
    public void deleteMemberFile() throws IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "memberlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String filestring = "";
        if (checkMemberExistence()) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.split(",")[1].equals(Integer.toString(this.memberNumber))) {
                    continue;
                } else {
                    filestring = filestring.concat(line + "\n");
                }
            }
        }
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        reader.close();
        writer.close();
        return;
    }

    //method to check if member exists
    public boolean checkMemberExistence() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "memberlist.txt";
        File memberlist = new File(filename);
        Scanner reader = new Scanner(memberlist);
        while (reader.hasNextLine()) {
            String member = reader.nextLine();
            if (member.split(",")[1].equals(Integer.toString(this.memberNumber))) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }
    //adding constructor
    public Member(){
    
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