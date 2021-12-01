import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
Group Member: @author Luca Conti
Class: ReportController.java
Description: Backend for interfacting manager menu or main accounting procedure with producing reports
*/

public class ReportController {

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
        Scanner console = new Scanner(System.in);

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.nextLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.nextLine();
        }

        // "Sends" email of report
        System.out.println("\nMember Report email sent to " + email);

        // Closes Scanner
        console.close();
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
        Scanner console = new Scanner(System.in);

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.nextLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.nextLine();
        }

        // "Sends" email of report
        System.out.println("\nMember Report email sent to " + email);

        // Closes Scanner
        console.close();

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
        Scanner console = new Scanner(System.in);

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.nextLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.nextLine();
        }

        // "Sends" email of report
        System.out.println("\nMember Report email sent to " + email);

        // Closes Scanner
        console.close();

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
        Scanner console = new Scanner(System.in);

        // Prompts user for email address to send report to
        System.out.println("\nEnter Email: ");
        // Reads email from user input
        String email = console.nextLine();
        // Created regex pattern for email addresses
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        // Loops until user input matches regex pattern
        while (!ptr.matcher(email).matches()) {
            // Notifys user email does not match pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            // Reads next user input
            email = console.nextLine();
        }

        // "Sends" email of report
        System.out.println("\nMember Report email sent to " + email);

        // Closes Scanner
        console.close();
        // Exits function @return null
    }
}
