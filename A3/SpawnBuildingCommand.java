public class SpawnBuildingCommand extends Command
{
	public SpawnBuildingCommand(Object receiver, String[] args)
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
		System.out.println("Spawning building at (" + args[0] + "," + args[1]+")");
//		Building b = (Building) factory.MakeBuilding();
		
		square.Add(factory.MakeBuilding());
		GameBoard.Instance().IncrementBuildingCount();
	}
}