import java.util.ArrayList;

public abstract class ShieldDecorator extends BoardComponent {

	protected BoardComponent decoratedBoardComponent;
	
//	Shield decoratedShield;
	
	public ShieldDecorator(BoardComponent decoratedboardComponent)
	{
		super();
		this.decoratedBoardComponent = (Square) decoratedboardComponent;
//		this.decoratedBoardComponent =  decoratedboardComponent;
	}
	
	public ArrayList<BoardComponent> getChildren()
	{
		ArrayList<BoardComponent> children = new ArrayList<>();
		//bring square's children
		children = ((Square)decoratedBoardComponent).getChildren();
		return children;
		
	}
	
	@Override
	public void Operation()
	{
		decoratedBoardComponent.Operation();
	}

	@Override
	public void Add(BoardComponent child)
	{
		decoratedBoardComponent.Add(child);
	}

	@Override
	public void Remove(BoardComponent child)
	{
		decoratedBoardComponent.Remove(child);
	}
	
//	public BoardComponent getDecoratedBoardComponent() {
//		return decoratedBoardComponent;
//	}
//	public Shield decorate(Shield shield) {
//		return shield;
//		
//	}
	
//	public void decorateComponent()
//	{
//		this.setShield(decoratedShield);
//	}
	
	public Square removeDecoratorandGet(BoardComponent removedDecoratedComponent)
	{
		return (Square) decoratedBoardComponent;
	}
	
	
}
