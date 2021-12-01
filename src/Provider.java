/*
Group Member: Caroline Johnson
Class: Provider.java
Description: Holds attributes and save, open, 
delete, get, set methods for Provider
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//method for main functionality
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

    //method to save provider data to file
    public void saveToFile() throws IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "providerlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String filestring = "";
        if (checkProviderExistence()) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.split(",")[1].equals(Integer.toString(this.providerNumber))) {
                    filestring = filestring.concat(this.providerName + "," + Integer.toString(this.providerNumber) + ","
                            + this.providerAddressStreet + "," + this.providerAddressCity + ","
                            + Integer.toString(this.providerAddressZipCode) + "," + this.providerAddressState + "\n");
                } else {
                    filestring = filestring.concat(line + "\n");
                }
            }

        } else {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                filestring = filestring.concat(line + "\n");

            }
            filestring = filestring.concat(this.providerName + "," + Integer.toString(this.providerNumber) + ","
                    + this.providerAddressStreet + "," + this.providerAddressCity + "," +
                    Integer.toString(this.providerAddressZipCode) + "," + this.providerAddressState);
        }
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
        reader.close();
        return;
    }

    //method to open provider data from file
    public void openFromFile() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "providerlist.txt";
        if (checkProviderExistence()) {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String line = myReader.nextLine();
            while (!line.split(",")[1].equals(Integer.toString(this.providerNumber))) {
                line = myReader.nextLine();
            }
            myReader.close();
            String[] info = line.split(",");
            this.setProviderName(info[0]);
            this.setProviderNumber(Integer.parseInt(info[1]));
            this.setProviderAddressStreet(info[2]);
            this.setProviderAddressCity(info[3]);
            this.setProviderAddressZipCode(Integer.parseInt(info[4]));
            this.setProviderAddressState(info[5]);
        }
        return;
    }

    //method to delete provider data from file
    public void deleteProviderFile() throws IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "providerlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String filestring = "";
        if (checkProviderExistence()) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.split(",")[1].equals(Integer.toString(this.providerNumber))) {
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

    //method to check if provider exists
    public boolean checkProviderExistence() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "providerlist.txt";
        File providerlist = new File(filename);
        Scanner reader = new Scanner(providerlist);
        while (reader.hasNextLine()) {
            String provider = reader.nextLine();
            if (provider.split(",")[1].equals(Integer.toString(this.providerNumber))) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;

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