package JavaClasses;
public class Item implements IPartManager{

	public int partNumber, quantity;
	
	public void setPartNumber(int partNumber)
	{
		this.partNumber = partNumber;
		
	}
	
	public void setquantity (int quantity)
	{
		this.quantity = quantity;
	}
	public int getPartNumber()
	{
		return partNumber;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public boolean isValidItem()
	{
		if(partNumber<=0)
			return false;
		if(quantity<=0)
			return false;
		return true;
	}

	@Override
	public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity,
			DeliveryAddress deliveryAddress) {
		// TODO Auto-generated method stub
		if(partNumber==1111)
			return PartResponse.OUT_OF_STOCK;
		else if(partNumber == 2222)
			return PartResponse.NO_LONGER_MANUFACTURED;
		else
			return PartResponse.SUCCESS;
	}
	
	
}
