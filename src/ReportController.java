import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReportController {

    // Generates and Sends Member Report
    public static void sendMemberReport(int memberNumber) throws IOException {
        MemberReport mr = new MemberReport();
        if (mr.getMember(memberNumber)) {
            mr.collectReports();
            mr.writeToFile();
        } else {
            System.out.println("\nMember does not exist\n");
        }

        Scanner console = new Scanner(System.in); // Create a Scanner object
        System.out.println("\nEnter Email: ");
        String email = console.nextLine();
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        while (!ptr.matcher(email).matches()) {
            System.out.println("\n!!Invalid Input!!\nEnter Email: ");
            email = console.nextLine();
        }
        System.out.println("\nMember Report email sent to " + email);
        console.close();
    }
}
