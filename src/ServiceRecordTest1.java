/*
Group Member: Caroline Johnson
Class: ServiceRecordTest1.java
Description: Holds test cases for ServiceRecord.java
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ServiceRecordTest1 {

    int memberNumber = 123123123;
    int providerNumber = 321321321;
    String comments = "Hello World";

    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void testSetMemberNumber() {
        this.setMemberNumber(memberNumber);
        this.getMemberNumber();
    }

    @Test 
    void testSetProviderNumber() {
        this.setProviderNumber(providerNumber);
        this.getProviderNumber();
    }

    @Test
    void testSetComments(){
        this.setComments(comments);
        this.getComments();
    }
}