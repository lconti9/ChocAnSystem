//Author: Shanissee Lee

import static org.junit.Assert.assertEquals;


import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EFTReportTest {
	int providerNum = 123456789;
	int providerNum2 = 123456788;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testSuccess()  {
		Provider prov = new Provider(providerNum);
		Provider test = new Provider();
		EFTReport obj = new EFTReport();
			
		
		
		try {
			assertEquals(true, obj.getProvider(providerNum));
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.setProviderNumber(prov.getProviderNumber());
		}
		finally {
			assertEquals(prov.getProviderNumber(),test.getProviderNumber());
		}

		}
	
	
	@Test 
	public void testFailure() throws FileNotFoundException {
		EFTReport obj = new EFTReport();

		try {
			assertEquals(false, obj.getProvider(providerNum2));
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return;
			//e.printStackTrace();
		}
		
		//System.out.println("next fail ");
	}
	
	@Test
    public void testSanity() {
		EFTReport obj = new EFTReport();
		Provider prov = new Provider(providerNum);
		

			try {
				assertEquals(prov.checkProviderExistence(),obj.getProvider(providerNum));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    }

}
