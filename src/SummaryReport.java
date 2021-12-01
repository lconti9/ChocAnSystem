/*
Group Member: TJ Trueblood
Class: SummaryReport.java
Description: Holds attributes and methods for Summary Report
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SummaryReport {

    // private variables to hold summary report data
    private ArrayList<Provider> providerList = new ArrayList<Provider>();
    private int totalNumberProviders;
    private int totalNumberConsultations;
    private double totalFeesOwed;
    private double totalProviderFees[];

    // initialize the variables to null
    public void summaryReport() {
        providerList = null;
        totalNumberProviders = 0;
        totalNumberConsultations = 0;
        totalFeesOwed = 0;
        totalProviderFees = null;
    }

    //method to write to file
    public void writeToFile() throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);

        String filename = ".\\src" + File.separator + "reports" + File.separator + currentDate + "summary_report.txt";
        String filestring = "Summary Report";
        int i = 0;
        for (Provider pr : providerList) {
            this.totalNumberConsultations += getReports(pr.getProviderNumber());
            this.totalProviderFees[i] = getProviderSumFees(pr.getProviderNumber());
            filestring = filestring.concat("\n\nProvider Name: " + pr.getProviderName() + "\nProvider Number: "
                    + pr.getProviderNumber() + "\nTotal Consultations: " + getReports(pr.getProviderNumber())
                    + "\nTotal Fees: $" + String.format("%.2f", getProviderSumFees(pr.getProviderNumber())));
            i++;
        }
        filestring = filestring.concat(
                "\n\nTotal Number of Providers: " + this.totalNumberProviders + "\nTotal Number of Consultations: "
                        + this.totalNumberConsultations + "\nTotal Fees Owed: $" + this.totalFeesOwed);
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
    }

    //method to sum grand total
    public void sumGrandTotal() {
        double total = 0;
        for (double fee : this.totalProviderFees) {
            total += fee;
        }
        this.totalFeesOwed = total;
        return;
    }

    //method to get providers
    public void getProviders() throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "providerlist.txt";
        File providerList = new File(filename);
        Scanner reader = new Scanner(providerList);
        String line = "";
        while (reader.hasNextLine()) {
            this.totalNumberProviders += 1;
            line = reader.nextLine();
            Provider pr = new Provider(Integer.parseInt(line.split(",")[1]));
            pr.openFromFile();
            this.providerList.add(pr);
        }
        this.totalProviderFees = new double[this.totalNumberProviders];
        reader.close();
    }

    //method to get reports
    public int getReports(int number) throws FileNotFoundException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "serviceprovidedlist.txt";
        File servicesProvided = new File(filename);
        Scanner reader = new Scanner(servicesProvided);
        String line = "";
        int numReports = 0;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.split(",")[3].equals(Integer.toString(number))) {
                if (ServiceRecord.weekApart(line.split(",")[2])) {
                    numReports += 1;
                }
            }
        }
        reader.close();
        return numReports;
    }

    //method to get provider sum fees
    public double getProviderSumFees(int number) throws FileNotFoundException, IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "serviceprovidedlist.txt";
        File servicesProvided = new File(filename);
        Scanner reader = new Scanner(servicesProvided);
        String line = "";
        double sumFee = 0;
        ProviderDirectory pr = new ProviderDirectory();
        pr.getProviderDirectory();
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.split(",")[3].equals(Integer.toString(number))) {
                if (ServiceRecord.weekApart(line.split(",")[2])) {
                    double fee = pr.getServiceFee(Integer.parseInt(line.split(",")[5]));
                    sumFee += fee;
                }
            }
        }
        reader.close();
        return sumFee;
    }
}