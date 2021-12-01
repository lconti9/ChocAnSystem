import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummaryReportTest {

	SummaryReport sr;
	
	@BeforeEach
	void setUp() throws Exception {
		sr = new SummaryReport();
	}

	@Test
	void testGetReports() throws FileNotFoundException {
		//Get number of reports from a known provider
		int reports = sr.getReports(123456789);
		assertEquals(3, reports);
	}

}
