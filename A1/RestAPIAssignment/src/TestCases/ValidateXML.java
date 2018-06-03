package TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import JavaClasses.ValidateXMLHelper;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.*;

class ValidateXML {

	ValidateXMLHelper validateXMLHelper = new ValidateXMLHelper();
	static DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
		static DocumentBuilder dB;
		static Document outputDoc;
		static Element order;
		boolean validation;
		
		@BeforeAll
	    public static void setup()
	    {
			
	    
		try {
		dB = dBF.newDocumentBuilder();
		 outputDoc = dB.newDocument();
        
		outputDoc = dB.newDocument();
		order = outputDoc.createElement("order");
		outputDoc.appendChild(order);
		Element dealerElement = outputDoc.createElement("dealer");
		order.appendChild(dealerElement);
		Element itemElement = outputDoc.createElement("orderitems");
		order.appendChild(itemElement);
		
	} catch (ParserConfigurationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	    }
		
		@Before
	    public void runBeforeTestMethod()
	    {
			validation = true;
	    }
	@Test
	@DisplayName("Validate XML - "
			+ "missing deliveryaddress tag")
	void test1() {
		validation = validateXMLHelper.validateXML(order);
		assertEquals(false,validation);
	}
	@Test
	@DisplayName("Validate XML - "
			+ "valid structure")
	void test2() {
		Element dAElement = outputDoc.createElement("deliveryaddress");
		order.appendChild(dAElement);
		validation = validateXMLHelper.validateXML(order);
		assertEquals(true,validation);
	}
	
	@Test
	@DisplayName("Validate XML - "
			+ "extra tag")
	void test3() {
		Element dAElement = outputDoc.createElement("extratag");
		order.appendChild(dAElement);
		validation = validateXMLHelper.validateXML(order);
		assertEquals(false,validation);
	}
}
