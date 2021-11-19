/*
Group Member: Caroline Johnson
Class: Service.java
Description: Holds attributes and get/set methods for Service
*/

public class Service {

    // private variables to hold service data
    private int serviceCode;
    private double serviceFee;
    private String serviceName;

    // initialize the variables to null
    public Service(String name, double fee, int code) {
        serviceCode = code;
        serviceFee = fee;
        serviceName = name;
    }

    // method to get code
    public int getServiceCode() {
        return serviceCode;
    }

    // method to get fee
    public double getServiceFee() {
        return serviceFee;
    }

    // method to get name
    public String getServiceName() {
        return serviceName;
    }

    // method to set code
    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    // method to set fee
    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    // method to set name
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}