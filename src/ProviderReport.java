/*
Group Provider: Shanissee Lee
Class: ProviderReport.java
Description: Holds attributes and methods for Provider Report
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.events.ProcessingInstruction;

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

    //method to get provider and check existence
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

    //method to collect reports
    public void collectReports() throws FileNotFoundException {
    	//System.out.println("prov "+this.provider.getProviderNumber());
    	//System.out.println("size here "+this.servicesProvided.size());
        this.servicesProvided = ServiceRecord.searchProviderServices(this.provider.getProviderNumber());
    }

<<<<<<< HEAD
    public ArrayList<ServiceRecord> collect() throws FileNotFoundException{
    	ArrayList<ServiceRecord>  Provided = ServiceRecord.searchProviderServices(provider.getProviderNumber());
    	return Provided;
    }
   
=======
    //method to write to file
>>>>>>> branch 'master' of https://shanissee@bitbucket.org/tklocklear/fall2021team7.git
    public void writeToFile() throws IOException {
        String filename = ".\\src" + File.separator + "reports" + File.separator + provider.getProviderNumber()
                + "provider_report.txt";
        String filestring = "";
        filestring = filestring.concat("Provider Name: " + provider.getProviderName() + "\n" + "Provider Number: "
                + Integer.toString(provider.getProviderNumber()) + "\n"
                + "Provider Street: " + provider.getProviderAddressStreet() + "\n" + "Provider City: "
                + provider.getProviderAddressCity() + "\n"
                + "Provider Zip Code: " + Integer.toString(provider.getProviderAddressZipCode()) + "\n\n");
        	
        	//Iterator it = servicesProvided.iterator();
        	//for (ServiceRecord sr : servicesProvided) {
        	ServiceRecord sr;
     //   	System.out.println("here ");
        	ArrayList<ServiceRecord> servicesProvided = collect();

        	for (int i=0;i<servicesProvided.size();i++) {
        	sr=servicesProvided.get(i);	
            Member member = new Member(sr.getMemberNumber());
            ProviderDirectory pr = new ProviderDirectory();
            pr.getProviderDirectory();
        //    System.out.println("Mem = "+ sr.getMemberNumber());
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