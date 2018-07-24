public class Person
{
	private String name;

	
	private TelephoneNumber telephoneNumber;
	private Authenticator authenticator;

	private String userName;
	private String password;

	public Person(String name)
	{
		this.name = name;
		telephoneNumber = new TelephoneNumber();
		authenticator = new Authenticator();
	}

	public void SetAreaCode(String areaCode)
	{
		this.telephoneNumber.setAreaCode(areaCode);
	}
	public String GetAreaCode()
	{
		return telephoneNumber.getAreaCode();
	}
	public void SetPhoneNumber(String phoneNumber)
	{
		this.telephoneNumber.setPhoneNumber(phoneNumber);
	}
	public String GetPhoneNumber()
	{
		
		return telephoneNumber.getPhoneNumber();
	}

	public void SetLoginCredentials(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	public boolean AuthenticateUser()
	{
		return authenticator.AuthenticateUser(userName, password);
	}
}