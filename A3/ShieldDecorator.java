
public abstract class ShieldDecorator extends Square {

//	protected BoardComponent decoratedBoardComponent;
	
	Shield decoratedShield;
	
	public ShieldDecorator(Shield decoratedboardComponent)
	{
		decoratedShield = decoratedboardComponent;
//		this.decoratedBoardComponent =  decoratedboardComponent;
	}
	
//	public BoardComponent getDecoratedBoardComponent() {
//		return decoratedBoardComponent;
//	}
//	public Shield decorate(Shield shield) {
//		return shield;
//		
//	}
	
	public void decorateComponent()
	{
		this.setShield(decoratedShield);
	}
	
	public void removeDecorator(BoardComponent removedDecoratedComponent)
	{
		this.removeShield();
	}
	
	
}
