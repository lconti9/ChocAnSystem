//Author: Jacob Aid
package src;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorControllerTest1 {
	
	Member member;

	@BeforeEach
	void setUp() throws Exception {
		member = new Member(123456789);
		member.setMemberName("Jacob");
		member.setMemberStatus("Active");
	}

	@Test  //passing test
	void testCheckMemberExistsPass() throws IOException {
		String userInput = "123456789";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		String expected = "Member does exist: Jacob (Active)";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		OperatorController.checkMemberExists();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		assertEquals(expected, actual);
	}
	
	@Test  //failing test
	void testCheckMemberExistsFail() throws IOException {
		String expected = "Member does not exist\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		OperatorController.checkMemberExists();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		assertEquals(expected, actual);
		
	}

}
