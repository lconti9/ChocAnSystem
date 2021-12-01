/*
Group Member: Caroline Johnson
Class: MemberTest.java
Description: Holds test cases for Member.java
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberTest {

    String memberName = "John Doe";
    int memberNumber = 222333444;
    String memberStatus = "Valid";

    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void testSetMemberName() {
        this.setMemberName(memberName);
        this.getMemberName();
    }

    @Test 
    void testSetMemberNumber() {
        this.setMemberNumber(memberNumber);
        this.getMemberNumber();
    }

    @Test
    void testSetMemberStatus(){
        this.setMemberStatus(memberStatus);
        this.getMemberStatus();
    }
}
