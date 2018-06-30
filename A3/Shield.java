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
			//detach shield
			BoardComponentSubject.Instance().Detach(this);
			System.out.println("shield is hit");
			board = GameBoard.Instance().GetBoard();
			for (int i = 0; i < board.size(); i++)
			{
				
				ArrayList<BoardComponent> row = board.get(i);
				for (int j = 0; j < row.size(); j++)
				{
					if(row.get(j).equals(this))
					{
						 BoardComponent bc = this;
						 bc = new SquareShieldDecorator(this);
						 ((SquareShieldDecorator) bc).removeDecorator(bc);
						 row.set(j, ((SquareShieldDecorator) bc));
						 board.set(i,row);
						 System.out.println("shield is destroyed");
						 GameBoard.Instance().SetBoard(board);
						 return;
					}
				}
				
				
			}
		}
	}
	
	//set position of shield
	public void setX(int X)
	{
		this.X = X;
	}
	
	public void setY(int Y)
	{
		this.Y = Y;
	}
	
	//get position of shield
	public int getX()
	{
		return X;
	}
	public int getY()
	{
		return Y;
	}
}