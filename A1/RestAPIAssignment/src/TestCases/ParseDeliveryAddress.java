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

import JavaClasses.ParseHelper;

class ParseDeliveryAddress {

ParseHelper parseHelper = new ParseHelper();
	
	static DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
	static DocumentBuilder dB;
	static Document outputDoc;
	static Element deliveryAddressElement,nameElement;
	boolean validation;
	
	@BeforeAll
    public static void setup()
    {
		
    
	try {
	dB = dBF.newDocumentBuilder();
	 outputDoc = dB.newDocument();
    
	outputDoc = dB.newDocument();
	deliveryAddressElement = outputDoc.createElement("deliveryaddress");
	outputDoc.appendChild(deliveryAddressElement);
	nameElement = outputDoc.createElement("name");
	
	nameElement.appendChild(outputDoc.createTextNode("kiran"));
	deliveryAddressElement.appendChild(nameElement);
	Element street = outputDoc.createElement("street");
	street.appendChild(outputDoc.createTextNode("jhvhv"));
	deliveryAddressElement.appendChild(street);
	Element city = outputDoc.createElement("city");
	city.appendChild(outputDoc.createTextNode("qhvh"));
	deliveryAddressElement.appendChild(city);
	Element province = outputDoc.createElement("province");
	province.appendChild(outputDoc.createTextNode("bjhjj"));
	deliveryAddressElement.appendChild(province);
	Element postalcode = outputDoc.createElement("postalcode");
	postalcode.appendChild(outputDoc.createTextNode("sdcsc"));
	deliveryAddressElement.appendChild(postalcode);
	
} catch (ParserConfigurationException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
    }
	
	
	@Test
	@DisplayName("Parse DeliveryAddress element - "
			+ " DeliveryAddress element in proper format")
	void test1() {
		
		
		assertEquals(true,parseHelper.parseDeliveryAddress(deliveryAddressElement));
		
		
	}
	
	@Test
	@DisplayName("Parse deliveryaddress element - "
			+ "Checking the storage of parsed DeliveryAddress element")
	void test2() {
		parseHelper.parseDeliveryAddress(deliveryAddressElement);
		
		assertEquals("kiran", parseHelper.getDeliveryAddress().getName());
		assertEquals("jhvhv", parseHelper.getDeliveryAddress().getStreet());
		assertEquals("qhvh", parseHelper.getDeliveryAddress().getCity());
		assertEquals("bjhjj", parseHelper.getDeliveryAddress().getProvince());
		assertEquals("sdcsc", parseHelper.getDeliveryAddress().getPostalCode());
	}
	@Test
	@DisplayName("Parse DeliveryAddress element - "
			+ "missing name tag")
	void test3() {
		
		deliveryAddressElement.removeChild(nameElement);
		assertEquals(false,parseHelper.parseDeliveryAddress(deliveryAddressElement));
		
		
	}

}
