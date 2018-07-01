import java.util.ArrayList;

// Building is the leaf node for the composite pattern, Square's can have MULTIPLE Buildings
// Buildings cannot have children.
public class Shield extends BoardComponent
{
	private int shieldHealth;
	private final ArrayList<BoardComponent> children;
	ArrayList<ArrayList<BoardComponent>> board;
	int X,Y;
	public Shield()
	{
		super();
		shieldHealth = 2;
		children = new ArrayList<BoardComponent>();
		board= null;
	}

	@Override
	public void Operation()
	{
		// shield just stand there, they don't do anything.
		
		//if square is decorated with shield, this will be called during tick()
		ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
		for (int i = 0; i < childrenCopy.size(); i++)
		{
			BoardComponent child = childrenCopy.get(i);
			child.Operation();
		} 
	}

	@Override
	public void Add(BoardComponent child)
	{
		// Do nothing, I'm a leaf.
	}

	@Override
	public void Remove(BoardComponent child)
	{
		// Do nothing, I'm a leaf.
	}
	
	@Override
	public void Update()
	{
		shieldHealth-= 1;
		
		
		
		if(shieldHealth==0)
		{
			System.out.println("shield is destroyed");
			
			//detach shield
			BoardComponentSubject.Instance().Detach(this);
			
			// remove shield decoration
			BoardComponent sqParent  = (Square)parent;
			((Square)sqParent).hasAShield = false;
//			((SquareShieldDecorator)sqParent).removeDecorator(this);  
			parent.Remove(this);

		}
		else
		System.out.println("shield is hit but not destroyed");
	}
	

}