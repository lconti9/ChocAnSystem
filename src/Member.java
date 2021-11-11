/*
Member: Caroline Johnson
Class: Member.java
Description: Holds attributes and methods for Member
*/

public class Member {

    //private variables to hold member data
    private String memberName;
    private int memberNumber;
    private String memberStatus;
    private String memberAddressStreet;
    private String memberAddressCity;
    private String memberAddressZipCode;
    private String memberAddressState;

    //initialize the variables to null
    public Member(){
        memberName = null;
        memberNumber = 0;
        memberStatus = null;
        memberAddressStreet = null;
        memberAddressCity = null;
        memberAddressZipCode = null;
        memberAddressState = null;
    }

    //method to get name
    public int getMemberName(){
        return memberName;
    }

    //method to get number
    public int getMemberNumber(){
        return memberNumber;
    }    

    //method to get status
    public int getMemberStatus(){
        return memberStatus;
    } 
    
    //method to get street address
    public int getMemberAddressStreet(){
        return memberAddressStreet;
    }  

    //method to get city address
    public int getMemberAddressCity(){
        return memberAddressCity;
    } 

    //method to get zip code address
    public int getMemberAddressZipCode(){
        return memberAddressZipCode;
    }

    //method to get state address
    public int getMemberAddressState(){
        return memberAddressState;
    }

    //method to set name
    public void setMemberName(int memberName){
        this.memberName = memberName;
    }

    //method to set number
    public void setMemberNumber(int memberNumber){
        this.memberNumber = memberNumber;
    }    

    //method to set status
    public void setMemberStatus(int memberStatus){
        this.memberStatus = memberStatus;
    }  
    
    //method to set street address
    public void setMemberAddressStreet(int memberAddressStreet){
        this.memberAddressStreet = memberAddressStreet;
    }        

    //method to set city address
    public void setMemberAddressCity(int memberAddressCity){
        this.memberAddressCity = memberAddressCity;
    } 
    
    //method to set zip code address
    public void setMemberAddressZipCode(int memberAddressZipCode){
        this.memberAddressZipCode = memberAddressZipCode;
    }  
    
    //method to set state address
    public void setMemberAddressState(int memberAddressState){
        this.memberAddressState = memberAddressState;
    }        
}