public class USDollarAccount 
{
	static final float EXCHANGE_RATE = 0.75f;

	
	private BankAccount bankAccount = new BankAccount();
	public void Credit(float amount)
	{
		
		
		bankAccount.Credit(amount * EXCHANGE_RATE);
	}

	public void Debit(float amount)
	{
		
		bankAccount.Debit(amount * EXCHANGE_RATE);
	}
}