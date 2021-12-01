/*
 * Group Member: TJ Trueblood
 * Class: OperatorControllerTest.java
 * Description: Holds test cases for the OperatorController class
 */

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorControllerTest {

	//Creating a new OperatorController Object to use
	OperatorController oc;
	
	//Setup Function
	@BeforeEach
	void setUp() throws Exception {
		oc = new OperatorController();
	}

	//Working test case for isNumeric()
	@Test
	void testIsNumeric()  {
		String test = "123456";
		assertEquals(true, OperatorController.isNumeric(test));
	}
	
	//Failing test case for isNumeric()
	@Test
	void testIsNumericFail(){
		String test = "Hello";
		assertEquals(false, OperatorController.isNumeric(test));
	}
}
