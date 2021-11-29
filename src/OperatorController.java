import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
Group Member: Jacob Aid
Class: OperatorController.java
Description: Holds methods for Operator
Status: Incomplete
*/

public class OperatorController {

    private static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // method to add member
    public static void addMember() throws IOException {
        System.out.println("Enter new Member Number (must be 9 digits long):");
        Console console = System.console();

        String memberNumberString = console.readLine();

        while (memberNumberString.length() != 9 || !isNumeric(memberNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter new Member Number (must be 9 digits long):");
            memberNumberString = console.readLine();
        }

        int memberNumber = Integer.parseInt(memberNumberString);

        Member newMember = new Member(memberNumber);

        if (newMember.checkMemberExistence()) {
            return;
        }

        System.out.println("Enter Member Name:");
        newMember.setMemberName(console.readLine());

        System.out.println("Enter Member Status:\n1. Active\n2. Suspended");
        String status = console.readLine();
        while (!status.equals("1") && !status.equals("2")) {
            System.out.println("!!Invalid Input!!\nEnter Member Status:\n1. Active\n2. Suspended");
            status = console.readLine();
        }
        newMember.setMemberStatus(status);

        System.out.println("Enter Member Street Address:");
        newMember.setMemberAddressStreet(console.readLine());

        System.out.println("Enter Member City:");
        newMember.setMemberAddressCity(console.readLine());

        System.out.println("Enter Member Zip:");
        String memberZip = console.readLine();
        while (memberZip.length() != 5 || !isNumeric(memberZip)) {
            System.out.println("!!Invalid Input!!\nEnter Member Zip Code:");
            memberZip = console.readLine();
        }
        newMember.setMemberAddressZipCode(Integer.parseInt(memberZip));

        System.out.println("Enter Member State:");
        newMember.setMemberAddressState(console.readLine());

        newMember.saveToFile();

        return;

    }

    // method to remove member
    public static void removeMember() {
        System.out.println("Enter Member Number (must be 9 digits long):");
        Console console = System.console();

        String memberNumberString = console.readLine();

        while (memberNumberString.length() != 9 || !isNumeric(memberNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter new Member Number (must be 9 digits long):");
            memberNumberString = console.readLine();
        }

        int memberNumber = Integer.parseInt(memberNumberString);

        Member member = new Member(memberNumber);

        if (member.checkMemberExistence()) {
            member.deleteMemberFile();
        } else {
            System.out.println("Member does not exist");
        }
        return;
    }

    // method to update member data
    public static void updateMember() throws IOException {
        System.out.println("Enter Member Number (must be 9 digits long):");
        Console console = System.console();

        String memberNumberString = console.readLine();

        while (memberNumberString.length() != 9 || !isNumeric(memberNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter Member Number (must be 9 digits long):");
            memberNumberString = console.readLine();
        }

        int memberNumber = Integer.parseInt(memberNumberString);

        Member member = new Member(memberNumber);

        if (!member.checkMemberExistence()) {
            System.out.println("Member does not exist\n");
            return;
        }

        member.openFromFile();

        String option = "";
        while (!option.equals("7")) {
            System.out.println(
                    "Please select what you wish to update:\n1. Change Member Name\n2. Change Member Status\n3. Change Member Street\n4. Change Member City\n5. Change Member Zip\n6. Change Member State\n7. Save and Exit");
            option = console.readLine();
            switch (option) {
            case "1":
                System.out.println("Enter new Member Name (Old: " + member.getMemberName() + "):");
                member.setMemberName(console.readLine());
                break;
            case "2":
                System.out.println(
                        "Enter new Member Status (Old: " + member.getMemberStatus() + "):\n1. Active\n2. Suspended");
                String status = console.readLine();
                while (!status.equals("1") && !status.equals("2")) {
                    System.out.println("!!Invalid Input!!\nEnter Member Status:\n1. Active\n2. Suspended");
                    status = console.readLine();
                }
                member.setMemberStatus(status);
                break;
            case "3":
                System.out.println("Enter new Member Street (Old: " + member.getMemberAddressStreet() + "):");
                member.setMemberAddressStreet(console.readLine());
                break;
            case "4":
                System.out.println("Enter new Member City (Old: " + member.getMemberAddressCity() + "):");
                member.setMemberAddressCity(console.readLine());
                break;
            case "5":
                System.out.println(
                        "Enter new Member Zip (Old: " + Integer.toString(member.getMemberAddressZipCode()) + "):");
                String memberZip = console.readLine();
                while (memberZip.length() != 5 || !isNumeric(memberZip)) {
                    System.out.println("!!Invalid Input!!\nEnter Member Zip Code:");
                    memberZip = console.readLine();
                }
                member.setMemberAddressZipCode(Integer.parseInt(memberZip));
                break;
            case "6":
                System.out.println("Enter new Member State (Old: " + member.getMemberAddressState() + "):");
                member.setMemberAddressState(console.readLine());
                break;
            case "7":
                break;
            default:
                System.out.println("\n!!Invalid Input!!\n");
            }
        }
        member.saveToFile();
    }

    // method to check if member exists
    public static void checkMemberExists() {
        System.out.println("Enter Member Number (must be 9 digits long):");
        Console console = System.console();

        String memberNumberString = console.readLine();

        while (memberNumberString.length() != 9 || !isNumeric(memberNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter new Member Number (must be 9 digits long):");
            memberNumberString = console.readLine();
        }

        int memberNumber = Integer.parseInt(memberNumberString);

        Member member = new Member(memberNumber);

        if (member.checkMemberExistence()) {
            System.out
                    .println("Member does exist: " + member.getMemberName() + " (" + member.getMemberStatus() + ")\n");
        } else {
            System.out.println("Member does not exist\n");
        }
        return;
    }

    // method to add provider
    public static void addProvider() throws IOException {
        System.out.println("Enter new Provider Number (must be 9 digits long):");
        Console console = System.console();

        String providerNumberString = console.readLine();

        while (providerNumberString.length() != 9 || !isNumeric(providerNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter new Provider Number (must be 9 digits long):");
            providerNumberString = console.readLine();
        }

        int providerNumber = Integer.parseInt(providerNumberString);

        Provider newProvider = new Provider(providerNumber);

        if (newProvider.checkProviderExistence()) {
            System.out.println("Provider already exists\n");
            return;
        }

        System.out.println("Enter Provider Name:");
        newProvider.setProviderName(console.readLine());

        System.out.println("Enter Provider Street Address:");
        newProvider.setProviderAddressStreet(console.readLine());

        System.out.println("Enter Provider City:");
        newProvider.setProviderAddressCity(console.readLine());

        System.out.println("Enter Provider Zip:");
        String providerZip = console.readLine();
        while (providerZip.length() != 5 || !isNumeric(providerZip)) {
            System.out.println("!!Invalid Input!!\nEnter Provider Zip Code:");
            providerZip = console.readLine();
        }
        newProvider.setProviderAddressZipCode(Integer.parseInt(providerZip));

        System.out.println("Enter Provider State:");
        newProvider.setProviderAddressState(console.readLine());

        newProvider.saveToFile();

        return;
    }

    // method to remove provider
    public static void removeProvider() {
        System.out.println("Enter Provider Number (must be 9 digits long):");
        Console console = System.console();

        String providerNumberString = console.readLine();

        while (providerNumberString.length() != 9 || !isNumeric(providerNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter new Provider Number (must be 9 digits long):");
            providerNumberString = console.readLine();
        }

        int providerNumber = Integer.parseInt(providerNumberString);

        Provider provider = new Provider(providerNumber);

        if (provider.checkProviderExistence()) {
            provider.deleteProviderFile();
        } else {
            System.out.println("Provider does not exist\n");
        }
        return;
    }

    // method to update provider data
    public static void updateProvider() throws IOException {
        System.out.println("Enter Provider Number (must be 9 digits long):");
        Console console = System.console();

        String providerNumberString = console.readLine();

        while (providerNumberString.length() != 9 || !isNumeric(providerNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter Provider Number (must be 9 digits long):");
            providerNumberString = console.readLine();
        }

        int providerNumber = Integer.parseInt(providerNumberString);

        Provider provider = new Provider(providerNumber);

        if (!provider.checkProviderExistence()) {
            System.out.println("Provider does not exist\n");
            return;
        }

        provider.openFromFile();

        String option = "";
        while (!option.equals("6")) {
            System.out.println(
                    "Please select what you wish to update:\n1. Change Provider Name\n2. Change Provider Street\n3. Change Provider City\n4. Change Provider Zip\n5. Change Provider State\n6. Save and Exit");
            option = console.readLine();
            switch (option) {
            case "1":
                System.out.println("Enter new Provider Name (Old: " + provider.getProviderName() + "):");
                provider.setProviderName(console.readLine());
                break;
            case "2":
                System.out.println("Enter new Provider Street (Old: " + provider.getProviderAddressStreet() + "):");
                provider.setProviderAddressStreet(console.readLine());
                break;
            case "3":
                System.out.println("Enter new Provider City (Old: " + provider.getProviderAddressCity() + "):");
                provider.setProviderAddressCity(console.readLine());
                break;
            case "4":
                System.out.println("Enter new Provider Zip (Old: " + provider.getProviderAddressZipCode() + "):");
                String providerZip = console.readLine();
                while (providerZip.length() != 5 || !isNumeric(providerZip)) {
                    System.out.println("!!Invalid Input!!\nEnter Provider Zip Code:");
                    providerZip = console.readLine();
                }
                provider.setProviderAddressZipCode(Integer.parseInt(providerZip));
                break;
            case "5":
                System.out.println("Enter new Provider State (Old: " + provider.getProviderAddressState() + "):");
                provider.setProviderAddressState(console.readLine());
                break;
            case "6":
                break;
            default:
                System.out.println("\n!!Invalid Input!!\n");
            }
        }
        provider.saveToFile();
    }

    // method to check if provider exists
    public static void checkProviderExists() throws FileNotFoundException {
        System.out.println("Enter Provider Number (must be 9 digits long):");
        Console console = System.console();

        String providerNumberString = console.readLine();

        while (providerNumberString.length() != 9 || !isNumeric(providerNumberString)) {
            System.out.println("!!Invalid Input!!\nEnter new Provider Number (must be 9 digits long):");
            providerNumberString = console.readLine();
        }

        int providerNumber = Integer.parseInt(providerNumberString);

        Provider provider = new Provider(providerNumber);

        if (provider.checkProviderExistence()) {
            provider.openFromFile();
            System.out.println("Provider does exist: " + provider.getProviderName() + "\n");
        } else {
            System.out.println("Provider does not exist\n");
        }
        return;
    }
}
