/*
Group Member: Caroline Johnson
Class: Member.java
Description: Holds attributes and get/set methods for Member
Status: Complete
*/

public class Member {

    // private variables to hold member data
    private String memberName;
    private int memberNumber;
    private String memberStatus;
    private String memberAddressStreet;
    private String memberAddressCity;
    private int memberAddressZipCode;
    private String memberAddressState;

    // initialize the variables to null
    public Member(int num) {
        memberName = null;
        memberNumber = num;
        memberStatus = null;
        memberAddressStreet = null;
        memberAddressCity = null;
        memberAddressZipCode = 0;
        memberAddressState = null;
    }

    // method to get name
    public String getMemberName() {
        return memberName;
    }

    // method to get number
    public int getMemberNumber() {
        return memberNumber;
    }

    // method to get status
    public String getMemberStatus() {
        return memberStatus;
    }

    // method to get street address
    public String getMemberAddressStreet() {
        return memberAddressStreet;
    }

    // method to get city address
    public String getMemberAddressCity() {
        return memberAddressCity;
    }

    // method to get zip code address
    public int getMemberAddressZipCode() {
        return memberAddressZipCode;
    }

    // method to get state address
    public String getMemberAddressState() {
        return memberAddressState;
    }

    // method to set name
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // method to set number
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    // method to set status
    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    // method to set street address
    public void setMemberAddressStreet(String memberAddressStreet) {
        this.memberAddressStreet = memberAddressStreet;
    }

    // method to set city address
    public void setMemberAddressCity(String memberAddressCity) {
        this.memberAddressCity = memberAddressCity;
    }

    // method to set zip code address
    public void setMemberAddressZipCode(int memberAddressZipCode) {
        this.memberAddressZipCode = memberAddressZipCode;
    }

    // method to set state address
    public void setMemberAddressState(String memberAddressState) {
        this.memberAddressState = memberAddressState;
    }

}