/*
Group Member: Caroline Johnson
Class: Provider.java
Description: Holds attributes and methods for Provider
*/

public class Provider {

    //private variables to hold provider data
    private String providerName;
    private int providerNumber;
    private String providerAddressStreet;
    private String providerAddressCity;
    private int providerAddressZipCode;
    private String providerAddressState;

    //initialize the variables to null
    public Provider(){
        providerName = null;
        providerNumber = 0;
        providerAddressStreet = null;
        providerAddressCity = null;
        providerAddressZipCode = 0;
        providerAddressState = null;
    }

    //method to get name
    public String getProviderName(){
        return providerName;
    }

    //method to get number
    public int getProviderNumber(){
        return providerNumber;
    }    
    
    //method to get street address
    public String getProviderAddressStreet(){
        return providerAddressStreet;
    }  

    //method to get city address
    public String getProviderAddressCity(){
        return providerAddressCity;
    } 

    //method to get zip code address
    public int getProviderAddressZipCode(){
        return providerAddressZipCode;
    }

    //method to get state address
    public String getProviderAddressState(){
        return providerAddressState;
    }

    //method to set name
    public void setProviderName(String providerName){
        this.providerName = providerName;
    }

    //method to set number
    public void setProviderNumber(int providerNumber){
        this.providerNumber = providerNumber;
    }    
    
    //method to set street address
    public void setProviderAddressStreet(String providerAddressStreet){
        this.providerAddressStreet = providerAddressStreet;
    }        

    //method to set city address
    public void setProviderAddressCity(String providerAddressCity){
        this.providerAddressCity = providerAddressCity;
    } 
    
    //method to set zip code address
    public void setProviderAddressZipCode(int providerAddressZipCode){
        this.providerAddressZipCode = providerAddressZipCode;
    }  
    
    //method to set state address
    public void setProviderAddressState(String providerAddressState){
        this.providerAddressState = providerAddressState;
    }        
}