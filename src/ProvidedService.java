/*
Group Member: Jacob Aid
Class: ProvidedService.java
Description: Holds attributes and methods for Provided Service
*/

public class ProvidedService {

    //private variables to hold provided service data
    private int providedServiceCode;
    private String providedServiceDateProvided;
    private String providedServiceDateCurrent;
    private int providedServiceMemberNumber;
    private int providedServiceProviderNumber;
    private String providedServiceComment;

    //initialize the variables to null
    public ProvidedService(){
        providedServiceCode = 0;
        providedServiceDateProvided = null;
        providedServiceDateCurrent = null;
        providedServiceMemberNumber = 0;
        providedServiceProviderNumber = 0;
        providedServiceComment = null;
    }

    //method to get service code
    public int getProvidedServiceCode(){
        return providedServiceCode;
    } 
    
    //method to get service date
    public String getProvidedServiceDateProvided(){
        return providedServiceDateProvided;
    }  

    //method to get current date
    public String getProvidedServiceDateCurrent(){
        return providedServiceDateCurrent;
    } 

    //method to get member number
    public int getProvidedServiceMemberNumber(){
        return providedServiceMemberNumber;
    } 

    //method to get provider number
    public int getProvidedServiceProviderNumber(){
        return providedServiceProviderNumber;
    } 

    //method to get comment
    public String getProvidedServiceComment(){
        return providedServiceComment;
    } 

    //method to set service code
    public void setProvidedServiceCode(int providedServiceCode){
        this.providedServiceCode = providedServiceCode;
    }   
    
    //method to set service date
    public void setProvidedServiceDateProvided(String providedServiceDateProvided){
        this.providedServiceDateProvided = providedServiceDateProvided;
    }       

    //method to set current date
    public void setProvidedServiceDateCurrent(String providedServiceDateCurrent){
        this.providedServiceDateCurrent = providedServiceDateCurrent;
    } 

    //method to set member number
    public void setProvidedServiceMemberNumber(int providedServiceMemberNumber){
        this.providedServiceMemberNumber = providedServiceMemberNumber;
    }   

    //method to set provider number
    public void setProvidedServiceProviderNumber(int providedServiceProviderNumber){
        this.providedServiceProviderNumber = providedServiceProviderNumber;
    }  

    //method to set comment
    public void setProvidedServiceComment(String providedServiceComment){
        this.providedServiceComment = providedServiceComment;
    }     
    
}