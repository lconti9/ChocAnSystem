import java.io.IOException;
import java.util.Scanner;

public class ManagerMenu {

    // function to prompt user of their desired function
    public static void prompt() throws IOException {
        Scanner console = new Scanner(System.in); // Create a Scanner object
        String selection = "";
        while (!selection.equals("5")) {
            selection = selectOption(
                    "\nPlease select the number of the option you wish to select:\n1. Send Member Report\n2. Send Provider Report\n3. Send EFT Report\n4.Send Summary Report\n5. Exit");
            switch (selection) {
                case "1":
                    System.out.println("\nEnter Member Number:");
                    String memberNumString = console.nextLine();
                    while (!ProviderMenu.isNumeric(memberNumString)) {
                        System.out.println("\n!!invalid Input!!\nEnter Member Number:");
                        memberNumString = console.nextLine();
                    }
                    ReportController.sendMemberReport(Integer.parseInt(memberNumString));
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            console.close();
        }
    }

    // method to select options from the terminal
    public static String selectOption(String prompt) {

        Scanner console = new Scanner(System.in); // Create a Scanner object

        System.out.println(prompt);

        String selection = console.nextLine();

        console.close();

        return selection;
    }
}
