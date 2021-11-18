import java.io.Console;
import java.util.Arrays;
import java.util.List;

public class ProviderMenu {
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

    public static String selectOption(String prompt) {

        Console console = System.console();

        System.out.println(prompt);

        String selection = console.readLine();

        return selection;
    }

}
