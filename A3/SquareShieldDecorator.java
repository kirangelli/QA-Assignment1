
public class SquareShieldDecorator extends ShieldDecorator {

	public Shield shield;
	public SquareShieldDecorator(BoardComponent boardComponent, Shield shield) {
		super(boardComponent);
		//decorating square with shield
		this.shield = shield;
		((Square)boardComponent).Add(shield);
//		shield.SetParent(this);
//		decoratedBoardComponent = (Shield) shield;
		
		// TODO Auto-generated constructor stub
	}

	


	


}
