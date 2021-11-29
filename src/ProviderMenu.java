/*
Group Member: William Jefferson
Class: ProviderMenu.java
Description: Display terminal prompts for Provider
Status:
*/

//import statements
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

//method for main functionality
public class ProviderMenu {

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // method to display prompts to terminal
    public static void prompt() throws NumberFormatException, IOException {
        Console console = System.console();
        System.out.println("Enter Provider Number:");
        String providerNumberString = console.readLine();

        while (providerNumberString.length() != 9 || !isNumeric(providerNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter Provider Number (must be 9 digits long):");
            providerNumberString = console.readLine();
        }

        if (promptForVerification(providerNumberString)) {
            String selection = "";
            while (!selection.equals("4")) {
                selection = selectOption(
                        "Please select the number of the option you wish to select:\n1. Validate Member\n2. Bill ChocAn Member\n3. Accesss Provider Directory\n4. Exit");
                switch (selection) {
                    case "1":
                        swipeCard();
                        break;
                    case "2":
                        ProviderController.billChocAn(Integer.parseInt(providerNumberString));
                        break;
                    case "3":
                        ProviderController.requestProviderDirectory();
                        break;
                    case "4":
                        break;
                    default:
                        System.out.println("!!Invalid Input!!\n");
                }
            }
        }
    }

    // method to select options from the terminal
    public static String selectOption(String prompt) {

        Console console = System.console();

        System.out.println(prompt);

        String selection = console.readLine();

        return selection;
    }

    public static void swipeCard() throws NumberFormatException, FileNotFoundException {
        System.out.println("Swipe member card now: ");
        Console console = System.console();
        String memberNumString = console.readLine();
        while (!isNumeric(memberNumString)) {
            System.out.println("!!invalid Input!!\nSwipe member card now: ");
            memberNumString = console.readLine();
        }
        ProviderController.recieveCardID(Integer.parseInt(memberNumString));
    }

    public static void displayValid() {
        System.out.println("\nValid Member\n");
    }

    public static void displayInvalid() {
        System.out.println("\nInalid Member\n");
    }

    public static void displaySuspended() {
        System.out.println("\nSuspended Member\n");
    }

    public static void displayFee(double fee) {
        System.out.println("Fee: $" + fee);
    }

    public static boolean promptForVerification(String providerNumberString) throws FileNotFoundException {
        int providerNumber = Integer.parseInt(providerNumberString);

        Provider provider = new Provider(providerNumber);

        if (provider.checkProviderExistence()) {
            provider.openFromFile();
            System.out.println("\nWelcome " + provider.getProviderName() + "\n");
            return true;
        } else {
            return false;
        }
    }

    public static String keyInDate() {
        Console console = System.console();
        Pattern pattern = Pattern.compile("^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$");
        System.out.println("Enter Date of Service (MM-DD-YYYY): ");
        String serviceDate = console.readLine();
        while (!pattern.matcher(serviceDate).matches()) {
            System.out.println("!!Invalid Input!!\nEnter Date of Service (MM-DD-YYYY): ");
            serviceDate = console.readLine();
        }
        return serviceDate;
    }
}
