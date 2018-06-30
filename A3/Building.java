// Building is the leaf node for the composite pattern, Square's can have MULTIPLE Buildings
// Buildings cannot have children.
public class Building extends BoardComponent
{
	private int buildingHealth;
	
	public Building()
	{
		super();
		buildingHealth = 2;
	}

	@Override
	public void Operation()
	{
		// Buildings just stand there, they don't do anything.
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
	public void Update() {
		if(this.parent.getClass() == Shield.class)
				return;
		buildingHealth-= 1;
		if(buildingHealth==0)
		{
			//detach
//			BoardComponentSubject.Instance().Detach(this);
			System.out.println("removing the building");
			parent.Remove(this);
			GameBoard.Instance().DecrementBuildingCount();

			BoardComponentSubject.Instance().Detach(this);
		}
		else {
			System.out.println("building shot but not destroyed");
		}
		
	}
}