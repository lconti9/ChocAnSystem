/*
Group Member: William Jefferson
Class: ProviderController.java
Description: Holds methods for provider
*/

//import statements
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

//method for main functionality
public class ProviderController {

    // method to validate member
    public static boolean validateMember(int memberNumber) throws FileNotFoundException {
        Member member = new Member(memberNumber);
        if (member.checkMemberExistence()) {
            member.openFromFile();
            if (member.getMemberStatus().equals("1")) {
                ProviderMenu.displayValid();
                return true;
            } else {
                ProviderMenu.displaySuspended();
            }
        } else {
            ProviderMenu.displayInvalid();
        }
        return false;
    }

    // method to bill chocan member
    public static void billChocAn(int providerNumber) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("\nSwipe member card now: ");
        String memberNumString = console.nextLine();

        while (!ProviderMenu.isNumeric(memberNumString) && memberNumString.length() != 9) {
            System.out.println("\n!!invalid Input!!\nSwipe member card now: ");
            memberNumString = console.nextLine();
        }

        if (validateMember(Integer.parseInt(memberNumString))) {
            String serviceDate = ProviderMenu.keyInDate();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String currentDate = dtf.format(now).split(" ")[0];
            String currentTime = dtf.format(now).split(" ")[1];

            ProviderDirectory providerDirectory = new ProviderDirectory();
            providerDirectory.getProviderDirectory();

            String correctService = "";
            String serviceCodeString = "";

            while (!correctService.equals("y")) {
                System.out.println("\nEnter Service Number (6-digits): ");
                serviceCodeString = console.nextLine();

                while (!ProviderMenu.isNumeric(serviceCodeString) || serviceCodeString.length() != 6) {
                    System.out.println("!!Invalid Input!!\nEnter Service Number (6-digits): ");
                    serviceCodeString = console.nextLine();
                }

                if (!providerDirectory.checkServiceExists(Integer.parseInt(serviceCodeString))) {
                    System.out.println("\nService code does not exist\n");
                    console.close();
                    return;
                } else {
                    System.out.println("\nIs " + providerDirectory.getServiceName(Integer.parseInt(serviceCodeString))
                            + " the correct service? (y/n)");
                    correctService = console.nextLine();

                }
            }

            System.out.println("\nEnter any comments: ");
            String comments = console.nextLine();

            ServiceRecord sr = new ServiceRecord();
            sr.setCurrentDate(currentDate);
            sr.setCurrentTime(currentTime);
            sr.setServiceDate(serviceDate);
            sr.setProviderNumber(providerNumber);
            sr.setMemberNumber(Integer.parseInt(memberNumString));
            sr.setServiceCode(Integer.parseInt(serviceCodeString));
            sr.setComments(comments);

            sr.writeServiceToFile();
            console.close();
        }
    }

    // method to request provider directory
    public static void requestProviderDirectory() throws FileNotFoundException {
        requestProviderEmail();
    }

    // method to receive member card ID
    public static void recieveCardID(int memberNumber) throws FileNotFoundException {
        validateMember(memberNumber);
    }

    // method to request provider email
    public static void requestProviderEmail() {
        Scanner console = new Scanner(System.in);

        System.out.println("\nEnter Provider Email: ");
        String email = console.nextLine();
        Pattern ptr = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        while (!ptr.matcher(email).matches()) {
            System.out.println("\n!!Invalid Input!!\nEnter Provider Email: ");
            email = console.nextLine();
        }
        System.out.println("\nProvider Directory email sent to " + email + "\n");

        console.close();

    }
}
