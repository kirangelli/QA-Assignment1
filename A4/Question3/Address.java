public class Address {
	public String street;
	public String city;
	public String province;
	public String postalCode;
	
	public Address()
	{
		
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setProvince(String province)
	{
		this.province = province;
	}
	
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getProvince()
	{
		return province;
	}
	
	public String getPostalCode()
	{
		return postalCode;
	}

}
