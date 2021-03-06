/*
Group Member: TJ Trueblood
Class: ServiceRecord.java
Description: Holds data and methods relating to service record
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

//method for main functionality
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

    // method to write to file
    public void writeServiceToFile() throws IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "serviceprovidedlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String filestring = "";
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            filestring = filestring.concat(line + "\n");
        }
        filestring = filestring
                .concat(this.currentDate + "," + this.currentTime + "," + this.serviceDate + ","
                        + Integer.toString(this.providerNumber) + "," + Integer.toString(this.memberNumber) + "," +
                        Integer.toString(this.serviceCode) + "," + this.comments);
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
        reader.close();
        return;

    }

    // method to search member service
    public static void searchMemberService(int memberNumber, ArrayList<ServiceRecord> serviceRecords)
            throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "serviceprovidedlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String line;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.split(",")[4].equals(Integer.toString(memberNumber))) {
                if (weekApart(line.split(",")[2])) {
                    String[] data = line.split(",");
                    ServiceRecord sr = new ServiceRecord();
                    sr.setServiceDate(data[2]);
                    sr.setProviderNumber(Integer.parseInt(data[3]));
                    sr.setServiceCode(Integer.parseInt(data[5]));
                    serviceRecords.add(sr);
                    ;
                }
            }
        }
        reader.close();
    }

    // method to search provider services
    public static ArrayList<ServiceRecord> searchProviderServices(int providerNumber)
            throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "serviceprovidedlist.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        String line;
        ArrayList<ServiceRecord> srl = new ArrayList<ServiceRecord>();
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.split(",")[3].equals(Integer.toString(providerNumber))) {
                if (weekApart(line.split(",")[2])) {
                    String[] data = line.split(",");
                    ServiceRecord sr = new ServiceRecord();
                    sr.setCurrentDate(data[0]);
                    sr.setCurrentTime(data[1]);
                    sr.setServiceDate(data[2]);
                    sr.setMemberNumber(Integer.parseInt(data[4]));
                    sr.setServiceCode(Integer.parseInt(data[5]));
                    srl.add(sr);
                }

            }
        }
        reader.close();
        // System.out.println(srl.size());
        // for (int i=0;i<srl.size();i++) {
        // System.out.println(srl.get(i));
        // }
        return srl;
    }

    // method to ensure data is pulled from the current week
    public static boolean weekApart(String serviceDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate serviceD = LocalDate.parse(serviceDate, formatter);
        LocalDate currD = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(serviceD, currD);
        if (daysBetween < 7 && daysBetween > 0) {
            return true;
        }
        return false;
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
