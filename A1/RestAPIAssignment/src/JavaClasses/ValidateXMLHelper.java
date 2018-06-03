package JavaClasses;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ValidateXMLHelper {

	public boolean validateXML(Element order)
	{
		
		   List<String> orderTags= new ArrayList<String>();
	 		orderTags.add("dealer");
	 		orderTags.add("orderitems");
	 		orderTags.add("deliveryaddress");
	 		orderTags.add("#comment");
	 		orderTags.add("#text");

	 		int temp;

		
	 		
	 		NodeList orderChildren= order.getChildNodes();

	 		for( temp =0;temp<orderChildren.getLength();temp++)
	 		{
	 			if(orderChildren.item(temp).getNodeName().equals("#comment") ||
						orderChildren.item(temp).getNodeName().equals("#text"))
	 				continue;
	 			if(orderTags.contains(orderChildren.item(temp).getNodeName()))
	 			{
	 				
	 				orderTags.remove(orderChildren.item(temp).getNodeName());
	 			}
	 			else // has a tag that doesn't exist in the format
	 			{
	 				return false;
	 				
	 			}
	 		}
	 		if(orderTags.size()>2)
	 			//some tag is missing
	 			return false;
	 		
	 		//expected tags exist
		return true;
		
	}
}
