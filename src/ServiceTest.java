//Author: Shanissee Lee

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
    int serviceCode = 100001;
    double serviceFee = 99.99;
    String serviceName = "spa";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSuccess() {
		Service obj = new Service();
		obj.setServiceCode(serviceCode);
		
		assertEquals(obj.getServiceCode(),100001);
		
	}
	
	@Test (expected=AssertionError.class)
	public void testFailure() {
		Service obj = new Service();
		obj.setServiceCode(serviceCode);
		
		try {
			obj.getServiceCode();
		}
		catch(AssertionError e){
			//return;
			throw e;
		}
		//continue;
		fail("Does not exist");
		//System.out.println("next fail ");
	}
	
	@Test
    public void testSanity() {
		
		Service obj = new Service();
		obj.setServiceCode(serviceCode);
		int com = 100002;
		
		obj.setServiceCode(com);
		
		assertEquals(com,obj.getServiceCode());
    }

}
