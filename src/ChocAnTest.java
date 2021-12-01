//Author: Luca Conti

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChocAnTest {
	
	ChocAn ca;

	@BeforeEach
	void setUp() throws Exception {
		ca = new ChocAn();
	}

	@Test
	void testMain() throws IOException {
		//Set up user input
		String userInput = "4";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		
		//Set expected terminal output
		String expected = "Please select user type:\n1. Provider\n2. Manager\n3. Operator\n4. Exit";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		//Run function with inputs
		ChocAn.main(null);
		
		//Get actual output
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 2];
		System.out.println(lines);
		
		//Compare outputs
		assertEquals(expected, actual);
	}
	
	@Test
	void testMainFail() throws IOException {
		//Set up user inputs
		String userInput = String.format("w%s4", System.lineSeparator());
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		//Set expected output
		String expected = "\n!!Invalid Input!!\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		//Run function with inputs
		ChocAn.main(null);
		
		//Get actual outputs
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 4];
		System.out.println(lines);
		
		//Compare outputs
		assertEquals(expected, actual);
	}

}
