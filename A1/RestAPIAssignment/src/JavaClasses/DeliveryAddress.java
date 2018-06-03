package JavaClasses;
public class DeliveryAddress

{
	public String name;
	public String street;
	public String city;
	public String province;
	public String postalCode;
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getProvince() {
		return province;
	}
	
	public boolean isValidAddress()
	{
		
		if(name.equals(null) || name.equals(""))
			return false;
		if(street.equals(null) || street.equals(""))
			return false;
		if(city.equals(null) || city.equals(""))
			return false;
		if(postalCode.equals(null) || postalCode.equals(""))
			return false;
		if(province.equals(null) || province.equals(""))
			return false;
		return true;
	}
	
}