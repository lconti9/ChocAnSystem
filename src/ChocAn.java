/*
Group Member: Luca Conti
Class: ChocAn.java
Description: Main class for the ChocAn System
*/

//import statements
import java.io.IOException;
import java.util.Scanner;

//method for main functionality
public class ChocAn {
    public static void main(String args[]) throws IOException {
        Scanner console = new Scanner(System.in); // Create a Scanner object
        String userType = ""; // Sets string used for user input selection
        while (!userType.equals("4")) { // Loops until user choses 4 (Exit)
            System.out.println("Please select user type:\n1. Provider\n2. Manager\n3. Operator\n4. Exit");// Promps user
                                                                                                          // of inputs
            userType = console.nextLine(); // Reads input
            switch (userType) { // Selects based off of user input
                case "1":
                    System.out.println("----------------------------------------------------------\n");
                    ProviderMenu.prompt();// Sends user to provider menut
                    break;
                case "2":
                    System.out.println("----------------------------------------------------------\n");
                    ManagerMenu.prompt();// Sends user to manager menu
                    break;
                case "3":
                    System.out.println("----------------------------------------------------------\n");
                    OperatorMenu.prompt();// Sends user to operator menu
                    break;
                case "4":
                    break;
                default:
                    System.out.println("\n!!Invalid Input!!\n");// Input was not a valid option
            }
            System.out.println("----------------------------------------------------------\n");
        }
        console.close(); // Closes scanner
    }
}