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

class ParseDealer {

	ParseHelper parseHelper = new ParseHelper();
	
	static DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
	static DocumentBuilder dB;
	static Document outputDoc;
	static Element dealer,dealerElement;
	boolean validation;
	
	@BeforeAll
    public static void setup()
    {
		
    
	try {
	dB = dBF.newDocumentBuilder();
	 outputDoc = dB.newDocument();
    
	outputDoc = dB.newDocument();
	dealer = outputDoc.createElement("dealer");
	outputDoc.appendChild(dealer);
	dealerElement = outputDoc.createElement("dealerid");
	
	dealerElement.appendChild(outputDoc.createTextNode("id"));
	dealer.appendChild(dealerElement);
	Element dealerAccessKey = outputDoc.createElement("dealeraccesskey");
	dealerAccessKey.appendChild(outputDoc.createTextNode("key"));
	dealer.appendChild(dealerAccessKey);
	
} catch (ParserConfigurationException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
    }
	
	
	@Test
	@DisplayName("Parse Dealer element - "
			+ "dealer element in proper format")
	void test1() {
		
		
		assertEquals(true,parseHelper.parseDealer(dealer));
		
		
	}
	
	@Test
	@DisplayName("Parse Dealer element - "
			+ "Checking the storage of parsed dealer element")
	void test2() {
		parseHelper.parseDealer(dealer);
		
		assertEquals("id", parseHelper.getDealer().getDealerId());
		assertEquals("key", parseHelper.getDealer().getDealerAccessKey());
	}
	@Test
	@DisplayName("Parse Dealer element - "
			+ "missing dealerid tag")
	void test3() {
		
		dealer.removeChild(dealerElement);
		assertEquals(false,parseHelper.parseDealer(dealer));
		
		
	}

}
