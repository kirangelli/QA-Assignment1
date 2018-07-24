public class Person
{
	public String name;

	public Address address = new Address();
	public Person()
	{
		name = "Rob";
	}

	public boolean IsPersonRob()
	{
		address.setStreet("Rob street");
		address.setCity("Rob city");
		address.setProvince("Rob province");
		address.setPostalCode("Rob postalcode");
		return name.equals("Rob") && IsRobsAddress(address);
	}

	private boolean IsRobsAddress(Address address)
	{
		return address.getStreet().equals("Rob street") &&
			address.getCity().equals("Rob city") &&
			address.getProvince().equals("Rob province") &&
			address.postalCode.equals("Rob postalcode");
	}
}