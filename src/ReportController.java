import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
Group Member: Luca Conti
Class: ReportController.java
Description: Backend for interfacting manager menu or main accounting procedure with producing reports
*/

public class ReportController {

    // Generates and Sends Member Report
    public static void sendMemberReport(int memberNumber) throws IOException {
        MemberReport mr = new MemberReport(); // Creates new member report
        if (mr.getMember(memberNumber)) { // Checks to make sure member number exists
            mr.collectReports(); // Generates list of member service records
            mr.writeToFile(); // Writes report to a file
        } else { // If member number does not exist, notify user and quit
            System.out.println("\nMember does not exist\n");
        }

        Scanner console = new Scanner(System.in); // Creates scanner for inputs

        System.out.println("\nEnter Email: "); // Prompts for email
        String email = console.nextLine(); // Reads email
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE); // Email
                                                                                                              // regex
                                                                                                              // pattern
        while (!ptr.matcher(email).matches()) { // Waits until user input matches regex pattern
            System.out.println("\n!!Invalid Input!!\nEnter Email: "); // Notifys user email does not match patter
            email = console.nextLine();
        }
        System.out.println("\nMember Report email sent to " + email); // "Sends" email of report

        console.close();

    }

    // Generates and sends Provider Report
    public static void sendProviderReport(int providerNumber) throws IOException {
        ProviderReport pr = new ProviderReport(); // Generates provider report class
        if (pr.getProvider(providerNumber)) { // checks provider number exists
            pr.collectReports();// Finds all provider service records
            pr.writeToFile();// Creates reports from records
        } else {
            System.out.println("\nProvider does not exist\n");
        }

        // Same as member report
        Scanner console = new Scanner(System.in);

        System.out.println("\nEnter Email: ");
        String email = console.nextLine();
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        while (!ptr.matcher(email).matches()) {
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            email = console.nextLine();
        }
        System.out.println("\nProvider Report email sent to " + email);

        console.close();

    }

    // Generates EFT Report
    public static void sendEFTReport(int providerNumber) throws IOException {
        EFTReport eft = new EFTReport(); // Generates EFT report class
        if (eft.getProvider(providerNumber)) { // Checks provider number exists
            eft.collectReports(); // Finds all of the provider's service records
            eft.writeToFile(); // Writes record in file
        } else {
            System.out.println("\nProvider does not exist\n");
        }

        // Same as member report
        Scanner console = new Scanner(System.in);

        System.out.println("\nEnter Email: ");
        String email = console.nextLine();
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        while (!ptr.matcher(email).matches()) {
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            email = console.nextLine();
        }
        System.out.println("\nProvider Report email sent to " + email);

        console.close();

    }

    // Generates Summary Report
    public static void sendSummaryReport() throws IOException {
        SummaryReport sr = new SummaryReport(); // Generates summary report

        sr.getProviders(); // Generates a list of all providers
        sr.writeToFile(); // Compiles list of all services provided by each provider in a file

        Scanner console = new Scanner(System.in);
        System.out.println("\nEnter Email: ");
        String email = console.nextLine();
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        while (!ptr.matcher(email).matches()) {
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            email = console.nextLine();
        }
        System.out.println("\nSummary Report email sent to " + email);
        console.close();
    }
}
