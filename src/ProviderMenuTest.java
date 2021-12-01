import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Group Member: Will Jefferson
 * Class: Provider Menu
 * Description: Holds test cases for the ProviderMenu isNumeric class
 */

class ProviderMenuTest {

	//Creating a new OperatorController Object to use
	ProviderMenu pm;
	
	//Setup Function
	@BeforeEach
	void setUp() throws Exception {
		pm = new ProviderMenu();
	}

	//Working test case for isNumeric()
	@Test
	void testIsNumeric()  {
		String test = "123456";
		assertEquals(true, ProviderMenu.isNumeric(test));
	}
	
	//Failing test case for isNumeric()
	@Test
	void testIsNumericFail(){
		String test = "Hello";
		assertEquals(false, ProviderMenu.isNumeric(test));
	}
}

