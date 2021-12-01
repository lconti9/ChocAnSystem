//Author: Shanissee Lee

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberReportTest {

	int memNum = 123456789;
	int memNum2 = 123456788;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testSuccess()  {
		Member mem = new Member(memNum);
		Member test = new Member();
		MemberReport obj = new MemberReport();
		
		
		try {
			assertEquals(true ,obj.getMember(memNum));
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.setMemberNumber(mem.getMemberNumber());
		}
		finally {
			assertEquals(mem.getMemberNumber(),test.getMemberNumber());
		}
			

		}
	
	
	@Test 
	public void testFailure() throws FileNotFoundException {
		MemberReport obj = new MemberReport();

		try {
			assertEquals(false ,obj.getMember(memNum2));
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return;
			//e.printStackTrace();
		}
		

		//continue;
		//System.out.println("next fail ");
	}
	
	@Test
    public void testSanity() {
		MemberReport obj = new MemberReport();
		Member mem = new Member(memNum);
		

			try {
				assertEquals(mem.checkMemberExistence(),obj.getMember(memNum));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    }

}
