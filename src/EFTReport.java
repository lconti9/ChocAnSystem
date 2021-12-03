/*
Group Member: Shanissee Lee
Class: EFTReport.java
Description: Holds attributes and methods for EFT Report
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//method for main functionality
public class EFTReport {

    // private variables to hold EFT report data
    private Provider provider;
    private int providerNumber;
    private float transferAmount;
    private ArrayList<ServiceRecord> servicesProvided;

    // initialize the variables to null
    public EFTReport() {
        provider = null;
        providerNumber = 0;
        transferAmount = 0;
        servicesProvided = new ArrayList<ServiceRecord>();
    }

    // method to get provider and check existence
    public boolean getProvider(int providerNumber) throws FileNotFoundException {
        this.provider = new Provider(providerNumber);
        if (provider.checkProviderExistence()) {
            this.providerNumber = providerNumber;
            provider.openFromFile();
            return true;
        } else {
            System.out.println("\nProvider does not exist\n");
            return false;
        }
    }

    // method to collect reports
    public void collectReports() throws FileNotFoundException {
        this.servicesProvided = ServiceRecord.searchProviderServices(this.provider.getProviderNumber());
    }

    // method to write to file
    public void writeToFile() throws IOException {
        String filename = ".\\src" + File.separator + "reports" + File.separator + "EFT_Report" + this.providerNumber
                + ".txt";
        String filestring = "";
        float totalFees = 0;
        filestring = filestring.concat("Provider Name: " + provider.getProviderName() + "\n" + "Provider Number: "
                + this.providerNumber);
        for (ServiceRecord sr : servicesProvided) {
            ProviderDirectory pr = new ProviderDirectory();
            pr.getProviderDirectory();
            totalFees += pr.getServiceFee(sr.getServiceCode());
        }
        this.transferAmount = totalFees;
        filestring = filestring
                .concat("\n\nTotal Fees: $" + String.format("%.2f", totalFees) + "\nTotal Funds to Transfer: $"
                        + String.format("%.2f", this.transferAmount));
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
    }
    
    public String returnFileString() throws IOException {
        String filestring = "";
        float totalFees = 0;
        filestring = filestring.concat("Provider Name: " + provider.getProviderName() + "\n" + "Provider Number: "
                + this.providerNumber);
        for (ServiceRecord sr : servicesProvided) {
            ProviderDirectory pr = new ProviderDirectory();
            pr.getProviderDirectory();
            totalFees += pr.getServiceFee(sr.getServiceCode());
        }
        this.transferAmount = totalFees;
        filestring = filestring
                .concat("\n\nTotal Fees: $" + String.format("%.2f", totalFees) + "\nTotal Funds to Transfer: $"
                        + String.format("%.2f", this.transferAmount));
        return filestring;
    }
}