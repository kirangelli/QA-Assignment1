package JavaClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.management.modelmbean.XMLParseException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class OrderPlacing {

	
	public static String respond(String fileName) {
		// TODO Auto-generated method stub
		
		Dealer d = new Dealer();
		Boolean invalidItem =false;
		List<Item> itemlist = new ArrayList<Item>();
		DeliveryAddress dA = new DeliveryAddress();
		DatabaseMock dBM = new DatabaseMock();
		ValidateXMLHelper validateXMLHelper = new ValidateXMLHelper();
		ParseHelper parseHelper = new ParseHelper();
//		IPartManager.PartResponse pr;
		
		try {
	         File xmlOrderFile = new File(fileName);
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document document = dBuilder.parse(xmlOrderFile);
	         document.getDocumentElement().normalize();
	         System.out.println(document.getDocumentElement().getNodeName());
	         
	       //format of the xml
//	         List<String> orderTags= new ArrayList<String>();
//	 		orderTags.add("dealer");
//	 		orderTags.add("orderitems");
//	 		orderTags.add("deliveryaddress");
//	 		orderTags.add("#comment");
//	 		orderTags.add("#text");
//	 		int tagsLength = orderTags.size();
//	 		int temp;
	 		Element order =(Element) (document.getElementsByTagName("order")).item(0);
//	 		boolean validXml = true;
		
	 		
//	 		NodeList orderChildren= order.getChildNodes();
//
//	 		for( temp =0;temp<orderChildren.getLength();temp++)
//	 		{
//
//	 			if(orderChildren.item(temp).getNodeName().equals("#comment") ||
// 						orderChildren.item(temp).getNodeName().equals("#text"))
//	 				continue;
//	 			if(orderTags.contains(orderChildren.item(temp).getNodeName()))
//	 			{
//	 				
//	 				orderTags.remove(orderChildren.item(temp).getNodeName());
//	 			}
//	 			else // has a tag that doesn't exist in the format
//	 			{
//	 				validXml= false;
//	 				
//	 			}
//	 		}
	 		
	 		
	    		if(!validateXMLHelper.validateXML(order))
	    		{
	    			String msg = "Format of the xml doesn't match with " + 
	    					"the expectation. Please look at the xml";
	    			System.out.println(msg);
	    			return msg;
	    		}
	       
	    		
	    	
	         NodeList dealer = document.getElementsByTagName("dealer");

	         // only one dealer node is present
	         Node dealerNode = dealer.item(0);
	         Document outputDoc = null;
	         //parsing dealer part
//	         if(dealerNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element dealerElement = (Element) dealerNode;
//	               String dealerId,dealerAccessKey;
//	               dealerId = dealerElement.getElementsByTagName("dealerid")
//	                       .item(0)
//	                       .getTextContent();
//	               dealerAccessKey = dealerElement.getElementsByTagName("dealeraccesskey")
//	                       .item(0)
//	                       .getTextContent();
//	               d.setDealerId(dealerId);
//	               d.setDealerAccessKey(dealerAccessKey);
	              
	               if(!parseHelper.parseDealer(dealerElement))
	               {
	            	   return "dealer Element is not valid";
	               }
	               // order items part
	               Element orderItem = (Element)
	            		   document.getElementsByTagName("orderitems").item(0);
	               if(!parseHelper.parseOrderItem(orderItem))
	               {
	            	   return "orderitem Element is not valid";
	               }
	               
//	               NodeList items = document.getElementsByTagName("item");
//	               for (int j = 0; j < items.getLength(); j++) {
//	                   Node item = items.item(j);
//	                   Item i = new Item();
////	                   System.out.println("node name:" + item.getNodeName()); 
//	                   
//	                   if (item.getNodeType() == Node.ELEMENT_NODE) {
//	                       Element itemElement = (Element) item;
//	                       
//	                       int partNumber,quantity;
//	                       partNumber = Integer.parseInt(itemElement.getElementsByTagName("partnumber")
//	                    		   .item(0).getTextContent());
//	                       
//	                       quantity = Integer.parseInt(itemElement.getElementsByTagName("quantity")
//	                    		   .item(0).getTextContent());
//	                       
//	                       i.setPartNumber(partNumber);
//	                       i.setquantity(quantity);
//	                       if(!i.isValidItem())
//	                       {
//	                    	   invalidItem = true;
//	                       }   	   
//	                       itemlist.add(i);
//	                   }
//	               }
//	               }
	               
	               // delivery address
	               
	               Element deliveryAddressElement = (Element)
	            		   document.getElementsByTagName("deliveryaddress").item(0);
	               if(!parseHelper.parseDeliveryAddress(deliveryAddressElement))
	               {
	            	   return "Delivery Address Element is not valid";
	               }
//	               NodeList deliveryAddress = document.getElementsByTagName("deliveryaddress");
//	               Node address = deliveryAddress.item(0);
//	  	         
//	  	         if(address.getNodeType() == Node.ELEMENT_NODE) {
//	  	               Element deliveryAddressElement = (Element) address;
//	  	               String name,street,city,postalCode,province;
//	  	               name = deliveryAddressElement.getElementsByTagName("name")
//	  	            		   .item(0).getTextContent();
//	  	               street = deliveryAddressElement.getElementsByTagName("street")
//	  	                       .item(0)
//	  	                       .getTextContent();
//	  	               city = deliveryAddressElement.getElementsByTagName("city")
//	  	                       .item(0)
//	  	                       .getTextContent();
//	  	               postalCode = deliveryAddressElement.getElementsByTagName("postalcode")
//  	                       .item(0)
//  	                       .getTextContent();
//	  	               province = deliveryAddressElement.getElementsByTagName("province")
//	                       .item(0)
//	                       .getTextContent();
//	  	               dA.setName(name);
//	  	               dA.setStreet(street);
//	  	               dA.setCity(city);
//	  	               dA.setPostalCode(postalCode);
//	  	               dA.setProvince(province);
////	  	               System.out.println(dA.isValidAddress());
//	  	         }
	         
	            	              
	            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
	       		DocumentBuilder dB = dBF.newDocumentBuilder();
	       		outputDoc = dB.newDocument();
	    		Element rootElement = outputDoc.createElement("order");
	    		outputDoc.appendChild(rootElement);
	    		
	    		
	    		
	    		
	    		//checking for invalid xml
	    		if(!parseHelper.getDeliveryAddress().isValidAddress())
	    		{
	    			// invalid address
	    			
	    			Element resultElement = outputDoc.createElement("result");
	    			rootElement.appendChild(resultElement);
	    			resultElement.appendChild(outputDoc.createTextNode("failure"));
	    			Element errorElement = outputDoc.createElement("error");
	    			errorElement.appendChild(outputDoc.createTextNode("Invalid order"));
	    			rootElement.appendChild(errorElement);
	    			Element errorMessageElement = outputDoc.createElement("errormessage");
	    			errorMessageElement.appendChild(outputDoc.createTextNode("Invalid delivery address"));
	    			rootElement.appendChild(errorMessageElement);
	    		}
	    		
	    		//check the entire item[] for validation
	    		else if(anyInValidItem(parseHelper.getItemArray()))
	    		{
	    			Element resultElement = outputDoc.createElement("result");
	    			rootElement.appendChild(resultElement);
	    			resultElement.appendChild(outputDoc.createTextNode("failure"));
	    			Element errorElement = outputDoc.createElement("error");
	    			errorElement.appendChild(outputDoc.createTextNode("Invalid order"));
	    			rootElement.appendChild(errorElement);
	    			Element errorMessageElement = outputDoc.createElement("errormessage");
	    			errorMessageElement.appendChild(outputDoc.createTextNode("Invalid Item Entry"));
	    			rootElement.appendChild(errorMessageElement);
	    		}
	    		
	    		// if dealer not authorized
	    		else if(!d.isDealerAuthorized(parseHelper.getDealer().dealerId,
	    				parseHelper.getDealer().dealerAccessKey))
	    		{
	    			Element resultElement = outputDoc.createElement("result");
	    			rootElement.appendChild(resultElement);
	    			resultElement.appendChild(outputDoc.createTextNode("failure"));
	    			Element errorElement = outputDoc.createElement("error");
	    			errorElement.appendChild(outputDoc.createTextNode("Not authorized"));
	    			rootElement.appendChild(errorElement);
	    			
	    			
	    		}
	    		//if dealer authorized
	    		else
	    		{
	    			Element orderItemsElement = outputDoc.createElement("orderitems");
	    			rootElement.appendChild(orderItemsElement);
	    			 Item itemsArray [] = parseHelper.getItemArray();
	    			//invalid dbm part
	    			for(int k=0;k<itemsArray.length;k++)
	    			{
	    				
	    				Element itemElement = outputDoc.createElement("item");
	    				orderItemsElement.appendChild(itemElement);
	    				Element partNumberElement = outputDoc.createElement("partnumber");
	    				partNumberElement.appendChild(outputDoc.createTextNode(""+itemsArray[k].partNumber));
	    				Element quantityElement = outputDoc.createElement("quantity");
	    				quantityElement.appendChild(outputDoc.createTextNode(""+itemsArray[k].quantity));
	    				Element resultElement = outputDoc.createElement("result");
	    				Element errorMessageElement = outputDoc.createElement("errormessage");
	    				itemElement.appendChild(partNumberElement);
	    				itemElement.appendChild(quantityElement);
	    				itemElement.appendChild(resultElement);
	    				itemElement.appendChild(errorMessageElement);
	    				
	    			if(!dBM.isValidPart(itemsArray[k].partNumber))
	    			{
	    				resultElement.appendChild(outputDoc.createTextNode("failure"));
	    				errorMessageElement.appendChild(outputDoc.createTextNode("invalid part"));
	    			}
	    			else if(!itemsArray[k].SubmitPartForManufactureAndDelivery(itemsArray[k].partNumber
	    			, itemsArray[k].quantity, dA).equals((IPartManager.PartResponse.SUCCESS))){
	    				resultElement.appendChild(outputDoc.createTextNode("failure"));
	    				errorMessageElement.appendChild(outputDoc.createTextNode(""+itemsArray[k].SubmitPartForManufactureAndDelivery(itemsArray[k].partNumber
	    		    			, itemsArray[k].quantity, dA)));
	    				
	    			}
	    			else
	    				resultElement.appendChild(outputDoc.createTextNode("success"));

	    			}
	    		
	         }

	         
	         
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 		Transformer transformer = transformerFactory.newTransformer();
	 		DOMSource source = new DOMSource(outputDoc);
	 		StreamResult result = new StreamResult(new File("C://Users//kiran//Desktop//output.xml"));

	 		
	 		 
	 		transformer.transform(source, result);
//	 		StringWriter sw = new StringWriter();
//	 		StringBuffer sb = sw.getBuffer(); 
	 		
	 		
//	 		System.out.println(((StringWriter)result.getWriter()).getBuffer().toString());
	 		File f1 = new File("C://Users//kiran//Desktop//output.xml");
	 		
	 				//result.getOutputStream().toString();
	 		Scanner sc = new Scanner(f1);
	 		String output = sc.nextLine();
	 		sc.close();
	 		return output;
	}
		/*catch()
		{
			create invalid xml format exception class
		}*/
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			return "file not found";
		}
		catch(NumberFormatException e)
		{
			return "string found instead of number";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fileName;
	}


	public static boolean anyInValidItem(Item[] item) {
		// TODO Auto-generated method stub
		
		for(int i =0;i<item.length;i++)
		{
			
			if(!item[i].isValidItem())
				return true;
		}
		
		return false;
	}



	
	public static void main(String[] args) throws XMLParseException
	{
		String outputResponse = respond("src\\JavaClasses\\input4.xml");
		System.out.println(outputResponse);
	}

}
