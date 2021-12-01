/*
Group Member: Caroline Johnson
Class: ServiceRecordTest1.java
Description: Holds test cases for ServiceRecord.java
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ServiceRecordTest1 {

	ServiceRecord sr;
    int memberNumber = 123123123;
    int providerNumber = 321321321;
    String comments = "Hello World";

    @BeforeEach
    void setUp() throws Exception {
    	sr = new ServiceRecord();
    }

    @Test
    void testSetMemberNumber() {
        sr.setMemberNumber(memberNumber);
        assertEquals(memberNumber, sr.getMemberNumber());
    }

    @Test 
    void testSetProviderNumber() {
        sr.setProviderNumber(providerNumber);
        assertEquals(providerNumber, sr.getProviderNumber());
    }

    @Test
    void testSetComments(){
        sr.setComments(comments);
        assertEquals(comments, sr.getComments());
    }
}