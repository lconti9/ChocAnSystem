//Author Luca Conti

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderControllerTest {
	
	ProviderController pc;

	@BeforeEach
	void setUp() throws Exception {
		pc = new ProviderController();
	}

	@Test
	void testValidateMember() throws FileNotFoundException {
		int memNum = 123456789;
		boolean memberExists = ProviderController.validateMember(memNum);
		assertEquals(true, memberExists);
	}
	
	@Test
	void testValidateMemberFail() throws FileNotFoundException {
		int memNum = 909090909;
		boolean memberExistsFail = ProviderController.validateMember(memNum);
		assertEquals(false, memberExistsFail);
	}

}
