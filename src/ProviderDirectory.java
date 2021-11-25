/*
Group Member: TJ Trueblood
Class: ProviderDirectory.java
Description: 
Status:
*/

//import statements
import java.util.ArrayList;

//method for main functionality
public class ProviderDirectory {
    private ArrayList<Service> serviceList = new ArrayList<Service>();

    //method to check if a service exists
    public boolean checkServiceExists(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return true;
            }
        }
        return false;
    }

    //method to get the name of a service
    public String getServiceName(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return service.getServiceName();
            }
        }
        return "Service does not exist";
    }

    //method to get the fee of a service
    public double getServiceFee(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return service.getServiceFee();
            }
        }
        return -1;
    }

}
