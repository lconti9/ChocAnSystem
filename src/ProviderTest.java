/*
Group Member: Caroline Johnson
Class: ProviderTest.java
Description: Holds test cases for Provider.java
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProviderTest {

	Provider pr;
    String providerName = "Jane Doe";
    int providerNumber = 321321321;
    int providerZip = 12345;

    @BeforeEach
    void setUp() throws Exception {
    	pr = new Provider(providerNumber);
    }

    @Test
    void testSetProviderName() {
        pr.setProviderName(providerName);
        assertEquals(providerName, pr.getProviderName());
    }

    @Test 
    void testSetProviderNumber() {
        pr.setProviderNumber(providerNumber);
        assertEquals(providerNumber, pr.getProviderNumber());
    }

    @Test
    void testSetProviderZip(){
        pr.setProviderAddressZipCode(providerZip);
        assertEquals(providerZip, pr.getProviderAddressZipCode());
    }
}