

public class Book implements IBookItem,IItem
{
	
	public String GetAuthor()
	{
		return "Hemingway";
	}

	public String GetTitle()
	{
		return "For Whom The Bell Tolls";
	}

	public boolean IsDigitalOnly()
	{
		return false;
	}

	
}