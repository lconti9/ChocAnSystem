import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
Group Member: Shanissee Lee
Class: EFTReport.java
Description: Holds attributes and methods for EFT Report
Status: Incomplete
*/

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

    public void collectReports() throws FileNotFoundException {
        this.servicesProvided = ServiceRecord.searchProviderServices(this.provider.getProviderNumber());
    }

    public void writeToFile() throws IOException {
        String filename = ".\\src" + File.separator + "reports" + File.separator + provider.getProviderNumber()
                + "EFT_report.txt";
        String filestring = "";
        float totalFees = 0;
        filestring = filestring.concat("Provider Name: " + provider.getProviderName() + "\n" + "Provider Number: "
                + this.providerNumber);
        for (ServiceRecord sr : servicesProvided) {
            ProviderDirectory pr = new ProviderDirectory();
            pr.getProviderDirectory();
            totalFees += pr.getServiceFee(sr.getServiceCode());
        }
        this.transferAmount = totalFees / 2;
        filestring = filestring
                .concat("\n\nTotal Fees: $" + String.format("%.2f", totalFees) + "\nTotal Funds to Transfer: $"
                        + String.format("%.2f", this.transferAmount));
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
    }
}