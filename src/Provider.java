import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Group Member: Caroline Johnson
Class: Provider.java
Description: Holds attributes and get/set methods for Provider
Status: Complete
*/
public class Provider {

    // private variables to hold provider data
    private String providerName;
    private int providerNumber;
    private String providerAddressStreet;
    private String providerAddressCity;
    private int providerAddressZipCode;
    private String providerAddressState;

    // initialize the variables to null
    public Provider(int number) {
        providerName = null;
        providerNumber = number;
        providerAddressStreet = null;
        providerAddressCity = null;
        providerAddressZipCode = 0;
        providerAddressState = null;
    }

    public void saveToFile() throws IOException {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Provider"
                + Integer.toString(this.providerNumber) + ".txt";
        try {
            File myObj = new File(filename);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter fWriter = new FileWriter(filename);
        String fileString = this.providerName + "," + Integer.toString(this.providerNumber) + ","
                + this.providerAddressStreet + "," + this.providerAddressCity + ","
                + Integer.toString(this.providerAddressZipCode) + "," + this.providerAddressState;
        fWriter.write(fileString);
        fWriter.close();
    }

    public void openFromFile() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Provider"
                + Integer.toString(this.providerNumber) + ".txt";
        if (checkProviderExistence()) {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            myReader.close();
            String[] info = data.split(",");
            this.setProviderName(info[0]);
            this.setProviderNumber(Integer.parseInt(info[1]));
            this.setProviderAddressStreet(info[2]);
            this.setProviderAddressCity(info[3]);
            this.setProviderAddressZipCode(Integer.parseInt(info[4]));
            this.setProviderAddressState(info[5]);

        }
        return;
    }

    public void deleteProviderFile() {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Provider"
                + Integer.toString(this.providerNumber) + ".txt";
        if (checkProviderExistence()) {
            File providerFile = new File(filename);
            providerFile.delete();
        }
        return;
    }

    public boolean checkProviderExistence() {
        String filename = ".\\src" + File.separator + "database" + File.separator + "Provider"
                + Integer.toString(this.providerNumber) + ".txt";
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
    public String getProviderName() {
        return providerName;
    }

    // method to get number
    public int getProviderNumber() {
        return providerNumber;
    }

    // method to get street address
    public String getProviderAddressStreet() {
        return providerAddressStreet;
    }

    // method to get city address
    public String getProviderAddressCity() {
        return providerAddressCity;
    }

    // method to get zip code address
    public int getProviderAddressZipCode() {
        return providerAddressZipCode;
    }

    // method to get state address
    public String getProviderAddressState() {
        return providerAddressState;
    }

    // method to set name
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    // method to set number
    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }

    // method to set street address
    public void setProviderAddressStreet(String providerAddressStreet) {
        this.providerAddressStreet = providerAddressStreet;
    }

    // method to set city address
    public void setProviderAddressCity(String providerAddressCity) {
        this.providerAddressCity = providerAddressCity;
    }

    // method to set zip code address
    public void setProviderAddressZipCode(int providerAddressZipCode) {
        this.providerAddressZipCode = providerAddressZipCode;
    }

    // method to set state address
    public void setProviderAddressState(String providerAddressState) {
        this.providerAddressState = providerAddressState;
    }

}