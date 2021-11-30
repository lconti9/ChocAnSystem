/*
Group Member: TJ Trueblood
Class: ProviderDirectory.java
Description: Holds methods relating to provider directory
*/

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//method for main functionality
public class ProviderDirectory {
    private ArrayList<Service> serviceList = new ArrayList<Service>();

    // method to check if a service exists
    public boolean checkServiceExists(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return true;
            }
        }
        return false;
    }

    // method to get the name of a service
    public String getServiceName(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return service.getServiceName();
            }
        }
        return "\nService does not exist\n";
    }

    // method to get the fee of a service
    public double getServiceFee(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return service.getServiceFee();
            }
        }
        return -1;
    }

    //method to get provider directory
    public void getProviderDirectory() throws FileNotFoundException, IOException {
        String filename = ".\\src" + File.separator + "data" + File.separator + "providerdirectory.txt";
        File providerDirectory = new File(filename);
        providerDirectory.createNewFile();
        Scanner myReader = new Scanner(providerDirectory);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] info = data.split(",");
            Service newService = new Service(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]));
            serviceList.add(newService);
        }
        myReader.close();
        return;
    }

}
