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

import JavaClasses.Item;
import JavaClasses.ParseHelper;

class ParseOrderItems{

	ParseHelper parseHelper = new ParseHelper();
	
	static DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
	static DocumentBuilder dB;
	static Document outputDoc;
	static Element orderItems,itemElement,partNumberElement;
	boolean validation;
	
	@BeforeAll
    public static void setup()
    {
		
    
	try {
	dB = dBF.newDocumentBuilder();
	 outputDoc = dB.newDocument();
    
	
	orderItems = outputDoc.createElement("orderitems");
	outputDoc.appendChild(orderItems);
	itemElement = outputDoc.createElement("item");
	partNumberElement = outputDoc.createElement("partnumber");
	partNumberElement.appendChild(outputDoc.createTextNode("1111"));
	Element quantityElement = outputDoc.createElement("quantity");
	quantityElement.appendChild(outputDoc.createTextNode("2"));
	itemElement.appendChild(partNumberElement);
	itemElement.appendChild(quantityElement);
	orderItems.appendChild(itemElement);
	
	
	
	
} catch (ParserConfigurationException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
    }
	
	
	@Test
	@DisplayName("Parse orderitem element - "
			+ "orderitem element in proper format")
	void test1() {
		
		
		assertEquals(true,parseHelper.parseOrderItem(orderItems));
		
		
	}
	
	@Test
	@DisplayName("Parse orderitem element - "
			+ "Checking the storage of parsed orderitem element")
	void test2() {
		parseHelper.parseOrderItem(orderItems);
		Item [] i = parseHelper.getItemArray();
		assertEquals(1111, i[0].getPartNumber());
		assertEquals(2, i[0].getQuantity());
	}
	@Test
	@DisplayName("Parse orderitem element - "
			+ "missing partnumber tag")
	void test3() {
		
		itemElement.removeChild(partNumberElement);
		assertEquals(false,parseHelper.parseOrderItem(orderItems));
		
		
	}

}
