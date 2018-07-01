import java.util.ArrayList;

// Square is a composite, making up the Composite pattern (contains components)
public class Square extends BoardComponent
{
	private final ArrayList<BoardComponent> children;
	private BoardComponent parent;
	boolean hasAShield;
	Shield shield;
	public Square()
	{
		super();
		children = new ArrayList<BoardComponent>();
		hasAShield = false;
		shield = null;
	}

	@Override
	public void Operation()
	{
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
		// I am now this child's parent.
		children.add(child);
		child.SetParent(this);
	}

	@Override
	public void Remove(BoardComponent child)
	{
		children.remove(child);
	}
	
	//called after decorating
	public void setShield(Shield shield)
	{
		hasAShield = true;
		this.shield = shield;
		System.out.println("Shield set");
	}
	
	
	public Shield getShield()
	{
		return shield;
	}
	
	//called after removing decorator
	
	public void removeShield()
	{
		hasAShield = false;
		shield = null;
		System.out.println("Shield removed");
	}
	

	public ArrayList<BoardComponent> getChildren()
	{
		return children;
		
	}
}