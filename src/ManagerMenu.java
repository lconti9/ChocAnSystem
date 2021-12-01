/*
Group Member: William Jefferson
Class: ManagerMenu.java
Description: Display terminal prompts for Manager
*/

//import statements
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;;

//method for main functionality
public class ManagerMenu {

    // function to prompt user of their desired function
    public static void prompt() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String selection = "";
        while (!selection.equals("5")) {
            selection = selectOption(
                    "\nPlease select the number of the option you wish to select:\n1. Send Member Report\n2. Send Provider Report\n3. Send EFT Report\n4. Send Summary Report\n5. Exit");
            switch (selection) {
                case "1":
                    System.out.println("\nEnter Member Number:");
                    String memberNumString = console.readLine();
                    while (!ProviderMenu.isNumeric(memberNumString) && memberNumString.length() == 9) {
                        System.out.println("\n!!invalid Input!!\nEnter Member Number:");
                        memberNumString = console.readLine();
                    }
                    ReportController.sendMemberReport(Integer.parseInt(memberNumString));
                    break;
                case "2":
                    System.out.println("\nEnter Provider Number:");
                    String providerNumString = console.readLine();
                    while (!ProviderMenu.isNumeric(providerNumString) && providerNumString.length() == 9) {
                        System.out.println("\n!!invalid Input!!\nEnter Provider Number:");
                        providerNumString = console.readLine();
                    }
                    ReportController.sendProviderReport(Integer.parseInt(providerNumString));
                    break;
                case "3":
                    System.out.println("\nEnter Provider Number:");
                    String providerNumString2 = console.readLine();
                    while (!ProviderMenu.isNumeric(providerNumString2) && providerNumString2.length() == 9) {
                        System.out.println("\n!!invalid Input!!\nEnter Provider Number:");
                        providerNumString = console.readLine();
                    }
                    ReportController.sendEFTReport(Integer.parseInt(providerNumString2));
                    break;
                case "4":
                    ReportController.sendSummaryReport();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid Input");
            }

        }
    }

    // method to select options from the terminal
    public static String selectOption(String prompt) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(prompt);

        String selection = console.readLine();

        return selection;
    }
}
