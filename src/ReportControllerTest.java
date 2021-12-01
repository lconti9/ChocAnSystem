//Author: Luca Conti

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportControllerTest {

	ReportController rc;
	@BeforeEach
	void setUp() throws Exception {
		rc = new ReportController();
	}

	@Test
	void testMemberReport() throws IOException {
		//Set up user inputs
		String userInput = "luca@gmail.com";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);

		//Set expected output
		String expected = "\n Member Report email sent to luca@gmail.com";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
			
		//Run function with inputs
		ReportController.sendMemberReport(123456789);
			
		//Get actual output
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		//Compare outputs
		assertEquals(expected, actual);
	}
	
	@Test
	void testMemberReportFail() throws IOException {
		//Set expected output
		String expected = "\nMember does not exist\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
			
		//Test with failing input
		ReportController.sendMemberReport(000000000);
			
		//Get actual output
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(lines);
		
		//Compare error messages
		assertEquals(expected, actual);
	}
	

}
