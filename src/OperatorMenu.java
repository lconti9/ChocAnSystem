/*
Group Member: Jacob Aid
Class: OperatorMenu.java
Description: Display terminal prompts for Operator
*/

//import statements
import java.io.IOException;
import java.util.Scanner;

//method for main functionality
public class OperatorMenu {

    // method to display prompts to terminal
    public static void prompt() throws IOException {
        String selection = "";
        while (!selection.equals("9")) {
            selection = selectOption(
                    "Please select the number of the option you wish to select:\n1. Add Member\n2. Remove Member\n3. Update Member\n4. Check Member Exists\n5. Add Provider\n6. Remove Provider\n7. Update Provider\n8. Check Provder Exists\n9. Exit");
            switch (selection) {
                case "1":
                    OperatorController.addMember();
                    break;
                case "2":
                    OperatorController.removeMember();
                    break;
                case "3":
                    OperatorController.updateMember();
                    break;
                case "4":
                    OperatorController.checkMemberExists();
                    break;
                case "5":
                    OperatorController.addProvider();
                    break;
                case "6":
                    OperatorController.removeProvider();
                    break;
                case "7":
                    OperatorController.updateProvider();
                    break;
                case "8":
                    OperatorController.checkProviderExists();
                    break;
                case "9":
                    break;
                default:
                    displayError();
            }
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

    // method to show error statement
    private static void displayError() {
        System.out.println("!!Invalid Input!!\n");
    }
}
