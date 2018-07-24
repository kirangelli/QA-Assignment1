public class Calculator {
	
	public static OperationType operationType;
	public static MathOperation op;

	public static int Divide(int left, int right)
	{
		operationType = new Divide();
		return getOperationResult(left,right);
	}

	public static int Multiply(int left, int right)
	{
		operationType = new Multiply();
		return getOperationResult(left,right);
	}

	public static int Add(int left, int right)
	{
		operationType = new Add();
		return getOperationResult(left,right);
	}

	public static int Subtract(int left, int right)
	{
		operationType = new Subtract();
		return getOperationResult(left,right);
	}
	
	public static int getOperationResult(int left, int right)
	{
		 op = new MathOperation(operationType, left, right);
		return op.GetResult();
	}
}
