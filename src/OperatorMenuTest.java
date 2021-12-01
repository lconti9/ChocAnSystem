//Author: Jacob Aid

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorMenuTest {
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test  //passing test
	void testPrompt() throws IOException {
		
		String userInput = "9";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		String expected = "Please select the number of the option you wish to select:\n1. Add Member\n2. Remove Member\n3. Update Member\n4. Check Member Exists\n5. Add Provider\n6. Remove Provider\n7. Update Provider\n8. Check Provder Exists\n9. Exit";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		OperatorMenu.prompt();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		
		assertEquals(expected, actual);
	}
	
	@Test  //passing test
	void testPromptFail() throws IOException {
		
		String userInput = String.format("9", System.lineSeparator());
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		String expected = "!!Invalid Input!!\\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		OperatorMenu.prompt();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		assertEquals(expected, actual);
	}

}
