//Author: Jacob Aid
package src;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderReportTest {
	
	Provider provider;
	ProviderReport providerReport;

	@BeforeEach
	void setUp() throws Exception {
		provider = new Provider(123456789);
		providerReport = new ProviderReport();
	}

	@Test
	void testGetProviderPass() throws FileNotFoundException {
		boolean actual = providerReport.getProvider(100000000);
		boolean  expected = false;
		
		assertEquals(actual, expected);
		
	}
	
	@Test
	void testGetProviderFail() throws FileNotFoundException {
		boolean actual = providerReport.getProvider(100000000);
		boolean  expected = true;
		
		assertEquals(actual, expected);
		
	}

}
