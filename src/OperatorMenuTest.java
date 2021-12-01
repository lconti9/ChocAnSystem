//Author: Jacob Aid
package src;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorMenuTest {
	
	Member member;

	@BeforeEach
	void setUp() throws Exception {
		member = new Member(123456789);
		member.setMemberName("Jacob");
		member.setMemberStatus("Active");
	}

	@Test  //passing test
	void testPromptCheckMemberExistsPass() throws IOException {
		String userInput = "8";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		userInput = "123456789";
		ByteArrayInputStream bais2 = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais2);
		
		
		
		String expected = "Member does exist: Jacob (Active)\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		OperatorMenu.prompt();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		assertEquals(expected, actual);
	}
	
	@Test  //passing test
	void testPromptCheckMemberExistsFail() throws IOException {
		
		String userInput = "0";
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
