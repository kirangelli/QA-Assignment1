import java.util.ArrayList;

// Asteroid is a leaf component in the composite structure
public class Asteroid extends BoardComponent
{
	private int height;
	
	public Asteroid(int height)
	{
		super();
		this.height = height;
	}
	
	@Override
	public void Operation()
	{
		// The operation performed by Asteroid objects is to fall from the sky
		// one level at a time, when they hit the ground (height == 0) they impact
		// and destroy whatever buildings are in the square!
		height -= 1;

		if (0 == height)
		{
			// When an Asteroid impacts the ground it needs to send an event to the
			// observer to tell it that it impacted the ground in the square it belongs
			// to.
			// <-- Send event to observer.
			
			ArrayList<BoardComponent> children = new ArrayList<>();
			children = ((Square) parent).getChildren();
			
			System.out.println("Asteroid hit the ground");
			//if square has shield
			if(((Square)parent).hasAShield)
			{
				ArrayList <BoardComponent> notifyingChildren = new ArrayList<>();
				for(int i=0;i<children.size();i++)
				{
					if(children.get(i).getClass()==Shield.class)
					{
						notifyingChildren.add(children.get(i));
						BoardComponentSubject.Instance().Notify(notifyingChildren);
					}
				}
			}
			
			//square doesn't have shield
			else
			{
				BoardComponentSubject.Instance().Notify(children);
			}

			parent.Remove(this);
		}
	}

	@Override
	public void Add(BoardComponent child)
	{
		// I'm a leaf!
	}

	@Override
	public void Remove(BoardComponent child)
	{
		// I'm a leaf!
	}	
}