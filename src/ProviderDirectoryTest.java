
/*
 * Group Member: TJ Trueblood
 * Class: ProviderDirectoryTest.java
 * Description: Holds test cases for ProviderDirectory.java
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderDirectoryTest {
	
	// Setting up an instance variable to test
	int serviceCode = 123123;

	// New ProviderDirectory obejct
	ProviderDirectory pd;
	
	//Setup Function
	@BeforeEach
	void setUp() throws Exception {
		pd = new ProviderDirectory();
		pd.getProviderDirectory();
	}
	
	//Working Test
	@Test
	void testGetServiceName() throws Exception {
		assertEquals(pd.getServiceName(100001), "Therapy");
	}
	
	//Failing Test
	@Test
	void testGetServiceNameFail() throws Exception {
		assertEquals(pd.getServiceName(999999), "\nService does not exist\n");
	}

}
