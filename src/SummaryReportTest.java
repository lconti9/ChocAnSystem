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
		int reports = sr.getReports(123123123);
		assertEquals(1, reports);
	}
	
	@Test
	void testGetReportsFail() throws FileNotFoundException {
		//Get number of reports from a nonexistent provider
		int reports = sr.getReports(121212123);
		assertEquals(0, reports);
	}

}
