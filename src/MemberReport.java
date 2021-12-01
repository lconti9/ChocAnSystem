/*
Group Member: Shanissee Lee
Class: MemberReport.java
Description: Holds attributes and methods for Member Report
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//method for main functionality
public class MemberReport {

    // private variables to hold member report data
    private Member member;
    private ArrayList<ServiceRecord> serviceRecords;

    // initialize the variables to null
    public MemberReport() {
        member = null;
        serviceRecords = new ArrayList<ServiceRecord>();
    }

    // initializing member as the member associated with the member number passed as a parameter
    public boolean getMember(int memberNumber) throws FileNotFoundException {
        member = new Member(memberNumber);
        if (member.checkMemberExistence()) {
            member.openFromFile();
            return true;
        } else {
            System.out.println("\nMember does not exist\n");
            return false;
        }
    }

    // pulling information from service records associated with member
    public void collectReports() throws FileNotFoundException {
        ServiceRecord.searchMemberService(this.member.getMemberNumber(), serviceRecords);
    }

    public void writeToFile() throws IOException {
        String filename = ".\\src" + File.separator + "reports" + File.separator + member.getMemberNumber()
                + "member_report.txt";
        String filestring = "";
        filestring = filestring.concat("Member Name: " + member.getMemberName() + "\n" + "Member Number: "
                + Integer.toString(member.getMemberNumber()) + "\n"
                + "Member Street: " + member.getMemberAddressStreet() + "\n" + "Member City: "
                + member.getMemberAddressCity() + "\n"
                + "Member Zip Code: " + Integer.toString(member.getMemberAddressZipCode()) + "\n\n");
        for (ServiceRecord sr : serviceRecords) {
            Provider provider = new Provider(sr.getProviderNumber());
            ProviderDirectory pr = new ProviderDirectory();
            pr.getProviderDirectory();
            if (provider.checkProviderExistence()) {
                provider.openFromFile();
                filestring = filestring.concat("Service Date: " + sr.getServiceDate() + "\n" + "Provider Name: "
                        + provider.getProviderName() + "\n" + "Service Name: "
                        + pr.getServiceName(sr.getServiceCode()) + "\n\n");
            }
        }
        FileWriter writer = new FileWriter(filename);
        writer.write(filestring);
        writer.close();
    }
}