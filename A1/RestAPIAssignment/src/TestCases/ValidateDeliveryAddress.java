package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import JavaClasses.DeliveryAddress;
import JavaClasses.Item;
import JavaClasses.ParseHelper;

class ValidateDeliveryAddress {

	ParseHelper parseHelper = new ParseHelper();
	
	
	DeliveryAddress dA =new DeliveryAddress();

	@Test
	@DisplayName(" deliveryaddress validation - "
			+ "valid address")
	void test1() {
		
		dA.setName("name");
		dA.setCity("city");
		dA.setPostalCode("postalCode");
		dA.setProvince("province");
		dA.setStreet("street");
		assertEquals(true,dA.isValidAddress());
	}

	@Test
	@DisplayName(" deliveryaddress validation - "
			+ "invalid address")
	void test2() {
		
			
			dA.setName("");
			dA.setCity("city");
			dA.setPostalCode("postalCode");
			dA.setProvince("province");
			dA.setStreet("street");
			assertEquals(false,dA.isValidAddress());
		}	
	}


