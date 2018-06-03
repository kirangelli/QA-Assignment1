package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import JavaClasses.Dealer;

class DealerAuthorization {

	String dealerId;
	String dealerAccessKey;
	Dealer d =new Dealer();
	
	@Test
	@DisplayName(" DealerAuthorization - "
			+ "Valid Dealer")
	void test1() {
		dealerId = "XXX-1234-ABCD-1234";
		dealerAccessKey = "kkklas8882kk23nllfjj88290";
		assertEquals(true,d.isDealerAuthorized(dealerId, dealerAccessKey));
	}
	
	@Test
	@DisplayName(" DealerAuthorization - "
			+ "InValid Dealer")
	void test2() {
		dealerId = "invalidID";
		dealerAccessKey = "kkklas8882kk23nllfjj88290";
		assertEquals(false,d.isDealerAuthorized(dealerId, dealerAccessKey));
	}

}
