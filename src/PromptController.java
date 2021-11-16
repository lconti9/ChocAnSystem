import java.util.List;
import java.io.Console;

public class PromptController {
    public static String prompt(List<String> options) {
        String selection = "";
        Console console = System.console();

        for (String option : options) {
            System.out.println(option + "\n");
        }
        System.out.println("Please select option:");
        selection = console.readLine();

        while (!options.contains(selection)) {
            System.out.println("\n!!Error Invalid Input!!\n");
            for (String option : options) {
                System.out.println(option + "\n");
            }
            System.out.println("Please select option:");
            selection = console.readLine();
        }
        return selection;
    }
}
