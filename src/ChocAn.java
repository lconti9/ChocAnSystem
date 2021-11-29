/*
Group Member: Luca Conti
Class: ChocAn.java
Description: Main class for the ChocAn System
Status: Incomplete
*/

//import statements
import java.io.Console;
import java.io.IOException;

//method for main functionality
public class ChocAn {
    public static void main(String args[]) throws IOException {
        Console console = System.console();

        String userType = "";
        while (!userType.equals("4")) {
            System.out.println("Please select user type:\n1. Provider\n2. Manager\n3. Operator\n4. Exit");
            userType = console.readLine();
            switch (userType) {
                case "1":
                    System.out.println("----------------------------------------------------------\n");
                    ProviderMenu.prompt();
                    break;
                case "2":
                    System.out.println("----------------------------------------------------------\n");
                    // ManagerMenu.prompt();
                case "3":
                    System.out.println("----------------------------------------------------------\n");
                    OperatorMenu.prompt();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("\n!!Invalid Input!!\n");
            }
            System.out.println("----------------------------------------------------------\n");
        }
    }
}