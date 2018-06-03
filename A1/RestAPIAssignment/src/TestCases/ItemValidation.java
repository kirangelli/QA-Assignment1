package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import JavaClasses.Dealer;
import JavaClasses.Item;
import JavaClasses.ParseHelper;

class ItemValidation {

ParseHelper parseHelper = new ParseHelper();
	
int partNumber;
int quantity;
Item i =new Item();

@Test
@DisplayName(" DealerAuthorization - "
		+ "Valid partnumber and quantity")
void test1() {
	partNumber = 123;
	quantity = 2;
	i.setPartNumber(partNumber);
	i.setquantity(quantity);
	assertEquals(true,i.isValidItem());
}

@Test
@DisplayName(" DealerAuthorization - "
		+ "InValid partnumber and quantity")
void test2() {
	partNumber = -123;
	quantity = -2;
	i.setPartNumber(partNumber);
	i.setquantity(quantity);
	assertEquals(false,i.isValidItem());
}



}
