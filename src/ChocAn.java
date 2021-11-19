/*
Group Member: Luca Conti
Class: ChocAn.java
Description: Main class for the ChocAn System
Status: Incomplete
*/

//import statements
import java.io.Console;
import java.util.Arrays;
import java.util.List;

//method for main functionality
public class ChocAn {
        public static void main(String args[]) {
        selectUser();
    }

    //method to determine which type of user is accessing the software
    public static void selectUser() {
        String[] userArray = { "Provider", "Manager", "Operator", "Exit" };
        List<String> userList = Arrays.asList(userArray);

        Console console = System.console();

        String userType = "";
        System.out.println("Please Enter User Type (Provider, Manager, Operator) or type \"Exit\" to exit system:");
        userType = console.readLine();

        while (!userList.contains(userType)) {
            System.out.println(
                    "\n!!Error Invalid Input!!\nPlease Enter User Type (Provider, Manager, Operator) or type \"Exit\" to exit system:");
            userType = console.readLine();
        }

        System.out.println("\n----------------------------------------------------------\n");

        if (userType.equals("Provider")) {
            ProviderMenu.prompt();
            selectUser();
        } else if (userType.equals("Manager")) {
            System.out.println("Do stuff");
            selectUser();
        } else if (userType.equals("Operator")) {
            System.out.println("Do stuff");
            selectUser();
        }

    }
}