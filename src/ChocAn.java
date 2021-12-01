/*
Group Member: @author Luca Conti
Class: ChocAn.java
Description: Main class for the ChocAn System
*/

//import statements
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;;

//method for main functionality
public class ChocAn {

    // Main function of choc an system @param command line arguments
    public static void main(String args[]) throws IOException {
        // Create a Scanner object for reading user input
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Sets string used for user input selection
        String userType = "";

        // While loop that waits until user choses 4 (Exit)
        while (!userType.equals("4")) {

            // Prompts user of their option of terminals
            System.out.println("Please select user type:\n1. Provider\n2. Manager\n3. Operator\n4. Exit");

            // Reads input from terminal
            userType = console.readLine();

            // Switch case based off of user input
            switch (userType) {

                // Provider Terminal Selected
                case "1":
                    System.out.println("----------------------------------------------------------\n");
                    // Sends user to provider menu
                    ProviderMenu.prompt();
                    break;

                // Manager Terminal Selected
                case "2":
                    System.out.println("----------------------------------------------------------\n");
                    // Sends user to manager menu
                    ManagerMenu.prompt();
                    break;

                // Operator Terminal Selected
                case "3":
                    System.out.println("----------------------------------------------------------\n");
                    ;// Sends user to operator menu
                    OperatorMenu.prompt();
                    break;

                // Exit is selected
                case "4":
                    break;

                // No valid input selected
                default:
                    // Prompts user that input was not a valid option
                    System.out.println("\n!!Invalid Input!!\n");
            }
            System.out.println("----------------------------------------------------------\n");
        }

        // @Return void
    }
}