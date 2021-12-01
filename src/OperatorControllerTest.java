/*
 * Group Member: TJ Trueblood
 * Class: OperatorControllerTest.java
 * Description: Holds test cases for the OperatorController class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

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

	//Working test case for removeMember()
	@Test
	void testRemoveMember() throws FileNotFoundException, IOException {
		//Base for user inputs
		int memberNumber = 123456789;
		ByteArrayInputStream bais = new ByteArrayInputeStream(userInput.getBytes());
		System.setIn(bais);
		
		//Function should successfully delete member
		oc.removeMember(123456789);
	}
	
	//Failing test case for removeMember()
	@Test
	void testRemoveMemberFail() throws FileNotFoundException, IOExceptionj {
		//Base for expected output
		String expected = "\n!!Invalid Input!!\nEnter new Member Number (must be 9 digits long):";
		ByteArrayOutputStream baos = new ByteOutputArrayStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);;
		
		//Test with failing output
		oc.removeMember(007);
			
		//Get actual output
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		//Compare error messages
		assertEquals(expected, actual);
	}
}
