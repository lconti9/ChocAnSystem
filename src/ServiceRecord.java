import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServiceRecord {
    // private variables to hold member data
    private String currentDate;
    private String currentTime;
    private String serviceDate;
    private int providerNumber;
    private int memberNumber;
    private int serviceCode;
    private String comments;

    // initialize the variables to null
    public ServiceRecord() {
        currentDate = null;
        currentTime = null;
        serviceDate = null;
        providerNumber = 0;
        memberNumber = 0;
        serviceCode = 0;
        comments = null;
    }

    public void saveToFile() throws IOException {
        String filename = ".\\src" + File.separator + "database" + File.separator + "ServiceRecord"
                + Integer.toString(this.memberNumber) + ".txt";
        try {
            File myObj = new File(filename);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter fWriter = new FileWriter(filename);
        String fileString = this.currentDate + "," + this.currentTime + "," + this.serviceDate + ","
                + Integer.toString(this.providerNumber) + "," + Integer.toString(this.memberNumber) + ","
                + Integer.toString(this.serviceCode) + "," + this.comments;
        fWriter.write(fileString);
        fWriter.close();
    }

    public void openFromFile() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "database" + File.separator + "ServiceRecord"
                + Integer.toString(this.memberNumber) + ".txt";
        if (checkProviderExistence()) {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            myReader.close();
            String[] info = data.split(",");
            this.setCurrentDate(info[0]);
            this.setCurrentTime(info[1]);
            this.setServiceDate(info[2]);
            this.setProviderNumber(Integer.parseInt(info[3]));
            this.setMemberNumber(Integer.parseInt(info[4]));
            this.setServiceCode(Integer.parseInt(info[5]));
            this.setComments(info[6]);

        }
        return;
    }

    public void deleteProviderFile() {
        String filename = ".\\src" + File.separator + "database" + File.separator + "ServiceRecord"
                + Integer.toString(this.memberNumber) + ".txt";
        if (checkProviderExistence()) {
            File providerFile = new File(filename);
            providerFile.delete();
        }
        return;
    }

    public boolean checkProviderExistence() {
        String filename = ".\\src" + File.separator + "database" + File.separator + "ServiceRecord"
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
    public String getCurrentDate() {
        return currentDate;
    }

    // method to get number
    public String getCurrentTime() {
        return currentTime;
    }

    // method to get status
    public String getServiceDate() {
        return serviceDate;
    }

    // method to get street address
    public int getProviderNumber() {
        return providerNumber;
    }

    // method to get city address
    public int getMemberNumber() {
        return memberNumber;
    }

    // method to get zip code address
    public int getServiceCode() {
        return serviceCode;
    }

    // method to get state address
    public String getComments() {
        return comments;
    }

    // method to set name
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    // method to set number
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    // method to set status
    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    // method to set street address
    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }

    // method to set city address
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    // method to set zip code address
    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    // method to set state address
    public void setComments(String comments) {
        this.comments = comments;
    }

}
