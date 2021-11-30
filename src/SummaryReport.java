package P4Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
Group Member: TJ Trueblood
Class: SummaryReport.java
Description: Holds attributes and methods for Summary Report
Status: Incomplete
*/

public class SummaryReport {

    // private variables to hold summary report data
    private ArrayList<Provider> providerList = new ArrayList<Provider>();
    private int totalNumberProviders;
    private int totalNumberConsultations;
    private float totalFeesOwed;
    private int totalProviderFees[];

    
    
    // initialize the variables to null
    public void summaryReport() {
        providerList = null;
        totalNumberProviders = 0;
        totalNumberConsultations = 0;
        totalFeesOwed = 0;
        totalProviderFees = null;
    }

    public void writeToFile() throws IOException {
    	String filename = ".\\src" + File.separator + "reports" + File.separator + "summary_report.txt";
    	String filestring = "";
    	for (Provider provider : providerList) {
    		filestring = filestring.concat("Provider Name: " + provider.getProviderName() + "\n" + 
    		"Number of Consultations: " + provider.getConsultations() + "\n" + 
    		"Total Fee: " + provider.getProviderSumFees(this.getProviderNumber()));
    	}
    	
    }
    
    public int sumGrandTotal() {
    	
    }
    
    public void getProviders() {
    	
    }
    
    public void getReports(int number) {
    	
    }
    
    public int getProviderSumFees(int number) {
    	int sumFees = 0;
    	for (Provider provider : providerList) {
    		if (provider.getProviderNumber() == number) {
    			sumFees += getProviderFees(number);
    		}
    	}
    	return sumFees;
    }
}