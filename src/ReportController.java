/*
Group Member: @author Luca Conti
Class: ReportController.java
Description: Backend for interfacing manager menu or main accounting procedure with producing reports
*/

//import statements
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReportController {
	
	public static void runMainAccountingProcedure() throws IOException {
		//Member file name
		String filename = ".\\src" + File.separator + "reports" + File.separator + "mainaccountingprocedure.txt";
		String filestring = "";
		
		String memberFilename = ".\\src" + File.separator + "data" + File.separator + "memberlist.txt";
        
		//Opens Member file
		File memberFile = new File(memberFilename);
		
		//Opens File Reader
        Scanner reader = new Scanner(memberFile);
        String line = "";
        //Loops for every member in file
        while(reader.hasNextLine()) {
        	line = reader.nextLine();
        	
        	//Creates new member report
        	MemberReport mr = new MemberReport();
        	
        	//Checks that member exists
        	if (mr.getMember(Integer.parseInt(line.split(",")[1]))) {
                // Generates list of member service records
                mr.collectReports();
                // Writes report to a file
                filestring = filestring.concat(mr.returnFileString());
                filestring = filestring.concat("\n\n");

            }
        }
        
        //Provider Filename
        String providerFilename = ".\\src" + File.separator + "data" + File.separator + "providerlist.txt";
        //Opens provider file
        File providerFile = new File(providerFilename);
        //Opens file reader
        reader.close();
        reader = new Scanner(providerFile);
        line = "";
        
        //Loops for every provider in file
        while(reader.hasNextLine()) {
        	line = reader.nextLine();
        	
        	//Gets provider num from file
        	int providerNum = Integer.parseInt(line.split(",")[1]);
        	
        	//Generates Provider Report
            ProviderReport pr = new ProviderReport();
            
            // checks provider number exists
            if (pr.getProvider(providerNum)) {
                // Finds all provider service records
                pr.collectReports();
                // Creates reports from records
                filestring = filestring.concat(pr.returnFileString());
                filestring = filestring.concat("\n\n");
            
            }
            
            // Generates EFT report class
            EFTReport eft = new EFTReport();
            
            // Checks provider number exists
            if (eft.getProvider(providerNum)) {
                // Finds all of the provider's service records
                eft.collectReports();
                // Writes record in file
                filestring = filestring.concat(eft.returnFileString());
                filestring = filestring.concat("\n\n");

            }
        }
      
        SummaryReport sr = new SummaryReport();

        // Generates a list of all providers
        sr.getProviders();
        // Compiles list of all services provided by each provider in a file
        filestring = filestring.concat(sr.returnFileString());
        
        reader.close();
        
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
        
	}

    // Generates and Sends Member Report @param member number
    public static void sendMemberReport(int memberNumber) throws IOException {
        // Creates new member report class
        MemberReport mr = new MemberReport();
        // Gets member number from user and makes sure member exists
        if (mr.getMember(memberNumber)) {
            // Generates list of member service records
            mr.collectReports();
            // Writes report to a file
            mr.writeToFile();
        }
        // If member number does not exist, notify user and quit
        else {
            // Displays that member does not exist
            System.out.println("\nMember does not exist\n");

            // Exits function @return null
            return;
        }

        // Creates scanner for inputs
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.readLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.readLine();
        }

        // "Sends" email of report
        System.out.println("\n Member Report email sent to " + email);

        // Exits function @return null

    }

    // Generates and sends Provider Report @param provider number
    public static void sendProviderReport(int providerNumber) throws IOException {
        // Generates provider report class
        ProviderReport pr = new ProviderReport();
        // checks provider number exists
        if (pr.getProvider(providerNumber)) {
            // Finds all provider service records
            pr.collectReports();
            // Creates reports from records
            pr.writeToFile();
        }
        // Case for if user enters invalid provider number
        else {
            // Uses standard output stream to say provider does not exist
            System.out.println("\nProvider does not exist\n");
            // Exits function @return null
            return;
        }

        // Creates scanner for inputs
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.readLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.readLine();
        }

        // "Sends" email of report
        System.out.println("\n Provider Report email sent to " + email);

        // Exits function @return null
    }

    // Generates EFT Report @param provider number
    public static void sendEFTReport(int providerNumber) throws IOException {
        // Generates EFT report class
        EFTReport eft = new EFTReport();
        // Checks provider number exists
        if (eft.getProvider(providerNumber)) {
            // Finds all of the provider's service records
            eft.collectReports();
            // Writes record in file
            eft.writeToFile();
        }
        // If user does not enter a valid provider number
        else {
            // Informs user that provider doesn't exist
            System.out.println("\nProvider does not exist\n");
            // Exits function @return null
            return;
        }

        // Creates scanner for inputs
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.readLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.readLine();
        }

        // "Sends" email of report
        System.out.println("\n EFT Report email sent to " + email);

        // Exits function @return null
    }

    // Generates Summary Report
    public static void sendSummaryReport() throws IOException {

        // Generates summary report
        SummaryReport sr = new SummaryReport();

        // Generates a list of all providers
        sr.getProviders();
        // Compiles list of all services provided by each provider in a file
        sr.writeToFile();

        // Creates scanner for inputs
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.readLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.readLine();
        }

        // "Sends" email of report
        System.out.println("\n Summary Report email sent to " + email);

        // Exits function @return null
    }
}
