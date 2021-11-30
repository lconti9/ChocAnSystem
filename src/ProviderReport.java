import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
Group Provider: Shanissee Lee
Class: ProviderReport.java
Description: Holds attributes and methods for Provider Report
*/

public class ProviderReport {

    // private variables to hold provider report data
    private Provider provider;
    private ArrayList<ServiceRecord> servicesProvided;
    private int totalConsultations;
    private float totalFees;

    // initialize the variables to null
    public void providerReport() {
        provider = null;
        servicesProvided = new ArrayList<ServiceRecord>();
        totalConsultations = 0;
        totalFees = 0;
    }

    public boolean getProvider(int providerNumber) throws FileNotFoundException {
        provider = new Provider(providerNumber);
        if (provider.checkProviderExistence()) {
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
                + "provider_report.txt";
        String filestring = "";
        filestring = filestring.concat("Provider Name: " + provider.getProviderName() + "\n" + "Provider Number: "
                + Integer.toString(provider.getProviderNumber()) + "\n"
                + "Provider Street: " + provider.getProviderAddressStreet() + "\n" + "Provider City: "
                + provider.getProviderAddressCity() + "\n"
                + "Provider Zip Code: " + Integer.toString(provider.getProviderAddressZipCode()) + "\n\n");
        for (ServiceRecord sr : servicesProvided) {
            Member member = new Member(sr.getMemberNumber());
            ProviderDirectory pr = new ProviderDirectory();
            pr.getProviderDirectory();
            if (member.checkMemberExistence()) {
                member.openFromFile();
                filestring = filestring.concat("Service Date: " + sr.getServiceDate() + "\n" + "Computer Input Date: "
                        + sr.getCurrentDate() + " " + sr.getCurrentTime() + "\nMember Name: "
                        + member.getMemberName() + "\nMember Number:" + member.getMemberNumber() + "\nService Code: "
                        + sr.getServiceCode() + "\nFee: $" + pr.getServiceFee(sr.getServiceCode()) + "\n\n");
                this.totalConsultations += 1;
                this.totalFees += pr.getServiceFee(sr.getServiceCode());
            }
        }
        filestring = filestring
                .concat("Total Consultations: " + this.totalConsultations + "\nTotal Fee: $"
                        + String.format("%.2f", this.totalFees));
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
    }
}