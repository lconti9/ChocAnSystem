import java.util.ArrayList;

public class ProviderDirectory {
    private ArrayList<Service> serviceList = new ArrayList<Service>();

    public boolean checkServiceExists(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return true;
            }
        }
        return false;
    }

    public String getServiceName(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return service.getServiceName();
            }
        }
        return "Service does not exist";
    }

    public double getServiceFee(int serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode() == serviceCode) {
                return service.getServiceFee();
            }
        }
        return -1;
    }

}
