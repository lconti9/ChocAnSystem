/*
Group Member: William Jefferson
Class: ProviderMenu.java
Description: Display terminal prompts for Provider
Status:
*/

//import statements
import java.io.Console;

//method for main functionality
public class ProviderMenu {

    //method to display prompts to terminal
    public static void prompt() {
        String selection = "";
        while (!selection.equals("4")) {
            selection = selectOption(
                    "Please select the number of the option you wish to select:\n1. Validate Member\n2. Bill ChocAn Member\n3. Accesss Provider Directory\n4. Exit");
            switch (selection) {
            case "1":
            case "2":
            case "3":
            case "4":
                break;
            default:
                System.out.println("!!Invalid Input!!\n");
            }
        }
    }

    //method to select options from the terminal
    public static String selectOption(String prompt) {

        Console console = System.console();

        System.out.println(prompt);

        String selection = console.readLine();

        return selection;
    }

}