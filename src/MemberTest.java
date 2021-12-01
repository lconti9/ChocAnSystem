/*
Group Member: Caroline Johnson
Class: MemberTest.java
Description: Holds test cases for Member.java
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberTest {

	Member mem;
    String memberName = "John Doe";
    int memberNumber = 222333444;
    String memberStatus = "Valid";

    @BeforeEach
    void setUp() throws Exception {
    	mem = new Member(memberNumber);
    }

    @Test
    void testSetMemberName() {
        mem.setMemberName(memberName);
        assertEquals(memberName, mem.getMemberName());
    }

    @Test 
    void testSetMemberNumber() {
        mem.setMemberNumber(memberNumber);
        assertEquals(memberNumber, mem.getMemberNumber());
    }

    @Test
    void testSetMemberStatus(){
        mem.setMemberStatus(memberStatus);
        assertEquals(memberStatus, mem.getMemberStatus());
    }
}
