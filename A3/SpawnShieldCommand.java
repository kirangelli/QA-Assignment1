import java.util.ArrayList;

public class SpawnShieldCommand extends Command
{
	ArrayList<ArrayList<BoardComponent>> board;
	public SpawnShieldCommand(Object receiver, String[] args)
	{
		super(receiver, args);
	}

	@Override
	public void Execute()
	{
		// The receiver for the SpawnBuildingCommand is the Square to spawn the building in.
		Square square = (Square) receiver;
		// The args for SpawnAsteroidCommand are the X,Y coordinate for the asteroid
		// used by the factory, and the height of the asteroid.

		IAsteroidGameFactory factory = GameBoard.Instance().GetFactory();
		System.out.println("Spawning shield at (" + args[0] + "," + args[1]);
//		square.Add(factory.MakeBuilding());
//		GameBoard.Instance().IncrementBuildingCount();
		
		square = new SquareShieldDecorator(factory.MakeShield());
		((SquareShieldDecorator) square).decorateComponent();
		board = new ArrayList<>();
		board = GameBoard.Instance().GetBoard();
		
		ArrayList<BoardComponent> row = new ArrayList<>();
		//getting row of the board
		row =board.get(Integer.parseInt(args[0]));
		
		//editing element in the row
		row.set(Integer.parseInt(args[1]),square);
		
		//replacing the row of board with new row
		board.set(Integer.parseInt(args[0]), row);
		
		GameBoard.Instance().SetBoard(board);
		
	}
}