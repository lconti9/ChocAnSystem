package P4JUnit;

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
	}
	
	//Working Test
	@Test
	void testGetServiceName() throws Exception {
		pd.getServiceName(123123);
	}
	
	//Failing Test
	@Test
	void testGetGetServiceNameFail() throws Exception {
		pd.getServiceName(000001);
	}

}
