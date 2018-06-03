package JavaClasses;
import java.util.*;

public class Dealer implements ISecurity{

	public String dealerId,dealerAccessKey;
	public static HashMap<String, String> dealers;

	public void setDealerId(String dealerId)
	{
		this.dealerId = dealerId;

	}
	
	public void setDealerAccessKey(String dealerAccessKey)
	{
		this.dealerAccessKey = dealerAccessKey;
	}
	
	public String getDealerId()
	{
		return dealerId;
	}
	
	public String getDealerAccessKey()
	{
		return dealerAccessKey;
	}
	
	
	@Override
	public boolean isDealerAuthorized(String dealerId, String dealerAccessKey) {
		// TODO Auto-generated method stub
		
		
			for(Map.Entry dealer:dealers.entrySet())
			{
				if(dealer.getKey().equals(dealerId))
				{
					if(dealer.getValue().equals(dealerAccessKey))
					{
						return true;
					}
				}
			}
			return false;
	
	}
	
	static
	{
		dealers = new HashMap<String,String>();
		dealers.put("XXX-1234-ABCD-1234", "kkklas8882kk23nllfjj88290");
		dealers.put("XXX-1234-ABCD-1235", "abcd");
	}
	
	
}
