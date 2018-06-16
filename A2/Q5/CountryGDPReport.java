public class CountryGDPReport
{
	Canada canada;
	Mexico mexico;

	public CountryGDPReport()
	{
		canada = new Canada();
		mexico = new Mexico();
	}

	public void PrintCountryGDPReport()
	{
		canada.PrintCountryGDPReport();
		mexico.PrintCountryGDPReport();
	}
}