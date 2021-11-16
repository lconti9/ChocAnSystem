import java.util.Arrays;
import java.util.List;

public class ProviderPrompt {
    public static void providerTerminal() {
        String[] optionArray = { "Verify Member", "Bill Member", "Access Provider Directory", "Exit" };
        List<String> optionList = Arrays.asList(optionArray);

        String option = "";
        while (!option.equals("Exit")) {
            option = PromptController.prompt(optionList);

            if (option.equals("Provider")) {
                ProviderPrompt.providerTerminal();
            } else if (option.equals("Manager")) {
                System.out.println("Do stuff");
            } else if (option.equals("Operator")) {
                System.out.println("Do stuff");
            }

        }
    }
}
