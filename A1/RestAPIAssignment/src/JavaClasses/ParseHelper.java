package JavaClasses;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseHelper {

	Dealer d ;
	Item[] item ;
	DeliveryAddress dA;
	public boolean parseDealer(Element dealer)
	{
		d=new Dealer();
		  String dealerId,dealerAccessKey;
		  try
		  {
          dealerId = dealer.getElementsByTagName("dealerid")
                  .item(0)
                  .getTextContent();
          dealerAccessKey = dealer.getElementsByTagName("dealeraccesskey")
                  .item(0)
                  .getTextContent();
          d.setDealerId(dealerId);
          d.setDealerAccessKey(dealerAccessKey);
          return true;
		  }
		  catch (NullPointerException npe)
		  {
			  return false;
		  }
	}	
	
	public boolean parseOrderItem(Element orderItem)
	{
		 
		try
		{
        NodeList items = orderItem.getElementsByTagName("item");
        item = new Item[items.getLength()];
        for (int j = 0; j < items.getLength(); j++) {
            Node itemNode = items.item(j);
            item[j] = new Item();
//            System.out.println("node name:" + item.getNodeName()); 
            
            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                Element itemElement = (Element) itemNode;
                
                int partNumber,quantity;
                partNumber = Integer.parseInt(itemElement.getElementsByTagName("partnumber")
             		   .item(0).getTextContent());
                
                quantity = Integer.parseInt(itemElement.getElementsByTagName("quantity")
             		   .item(0).getTextContent());
                
                item[j].setPartNumber(partNumber);
                item[j].setquantity(quantity);
//                if(!i.isValidItem())
//                {
//             	   invalidItem = true;
//                }   	   
               
            }
            
        }
        
	}
        catch (NullPointerException npe)
		  {
			  return false;
		  }
		return true;
	}
	
	public boolean parseDeliveryAddress(Element deliveryAddressElement)
	{
		dA = new DeliveryAddress();
		try
		{
		String name,street,city,postalCode,province;
          name = deliveryAddressElement.getElementsByTagName("name")
       		   .item(0).getTextContent();
          street = deliveryAddressElement.getElementsByTagName("street")
                  .item(0)
                  .getTextContent();
          city = deliveryAddressElement.getElementsByTagName("city")
                  .item(0)
                  .getTextContent();
          postalCode = deliveryAddressElement.getElementsByTagName("postalcode")
              .item(0)
              .getTextContent();
          province = deliveryAddressElement.getElementsByTagName("province")
            .item(0)
            .getTextContent();
          dA.setName(name);
          dA.setStreet(street);
          dA.setCity(city);
          dA.setPostalCode(postalCode);
          dA.setProvince(province);
		}
		catch(NullPointerException npe)
		  {
			  return false;
		  }
		return true;

		
		
	}
	public Dealer getDealer()
	{
		return d;
	}
	
	public Item[] getItemArray()
	{
		return item;
	}
	
	public DeliveryAddress getDeliveryAddress()
	{
		return dA;
	}
}
