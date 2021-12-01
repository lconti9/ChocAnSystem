/*
Group Member: Caroline Johnson
Class: ProviderTest.java
Description: Holds test cases for Provider.java
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProviderTest {

    String providerName = "Jane Doe";
    int providerNumber = 321321321;
    int providerZip = 12345;

    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void testSetProviderName() {
        this.setProviderName(providerName);
        this.getProviderName();
    }

    @Test 
    void testSetProviderNumber() {
        this.setProviderNumber(providerNumber);
        this.getProviderNumber();
    }

    @Test
    void testSetProviderZip(){
        this.setProviderAddressZipCode(providerZip);
        this.getProviderAddressZipCode();
    }
}