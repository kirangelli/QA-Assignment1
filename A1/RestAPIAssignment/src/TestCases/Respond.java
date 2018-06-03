package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import JavaClasses.OrderPlacing;

class Respond {

	
	@Test
	@DisplayName(" invalid item entry")
	void test1() {
		
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><order><result>failure</result>"
				+ "<error>Invalid order</error><errormessage>Invalid Item Entry</errormessage></order>";
		
		String actual = OrderPlacing.respond("src\\JavaClasses\\input2.xml");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName(" invalid delivery address")
	void test2() {
		
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><order>"
				+ "<result>failure</result><error>Invalid order</error><errormessage>"
				+ "Invalid delivery address</errormessage></order>";
		
		String actual = OrderPlacing.respond("src\\JavaClasses\\input1.xml");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName(" unauthorised dealer")
	void test3() {
		
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><order>"
				+ "<result>failure</result><error>Not authorized</error></order>";
		
		String actual = OrderPlacing.respond("src\\JavaClasses\\input3.xml");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName(" authorised dealer")
	void test4() {
		
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><order><orderitems>"
				+ "<item><partnumber>2222</partnumber><quantity>22</quantity>"
				+ "<result>failure</result><errormessage>NO_LONGER_MANUFACTURED</errormessage>"
				+ "</item><item><partnumber>3333</partnumber><quantity>22</quantity>"
				+ "<result>success</result><errormessage/></item></orderitems></order>";
		
		String actual = OrderPlacing.respond("src\\JavaClasses\\input4.xml");
		assertEquals(expected, actual);
	}

}
