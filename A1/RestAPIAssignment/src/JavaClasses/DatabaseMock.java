package JavaClasses;
public class DatabaseMock implements IDatabase{
	
	static int[]  partNumbers = new int[5];
	static
	{
		partNumbers[0] = 1111;
		partNumbers[1] = 2222;
		partNumbers[2] = 3333;
		partNumbers[3] = 4444;
		partNumbers[4] = 5555;
	}
	@Override
	public boolean isValidPart(int partNumber) {
		// TODO Auto-generated method stub
		for (int i=0;i<5;i++)
		{
			if(partNumbers[i] == partNumber)
				return true;
		}
		return false;
	}
	
	

}
