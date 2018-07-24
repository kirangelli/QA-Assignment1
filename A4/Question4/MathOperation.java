public class MathOperation {


	private int leftOperand;
	private int rightOperand;
	private OperationType operationType;

	public MathOperation(OperationType operationType, int leftOperand, int rightOperand)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operationType = operationType;
	}

	public int GetResult()
	{
		return operationType.compute(leftOperand, rightOperand);
		
	}
}
