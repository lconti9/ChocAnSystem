import java.io.Console;

public class OperatorMenu {
    public static void prompt() {
        String selection = "";
        while (!selection.equals("4")) {
            selection = selectOption(
                    "Please select the number of the option you wish to select:\n1. Add Member\n2. Remove Member\n3. Update Member\n4. Check Member Exists\n5. Add Provider\n6. Remove Provider\n7. Update Provider\n8. Check Provder Exists\n9. Exit");
            switch (selection) {
            case "1":

            case "2":
            case "3":
            case "4":
                break;
            default:
                displayError();
            }
        }
    }

    public static String selectOption(String prompt) {

        Console console = System.console();

        System.out.println(prompt);

        String selection = console.readLine();

        return selection;
    }

    private static void displayError() {
        System.out.println("!!Invalid Input!!\n");
    }
}
