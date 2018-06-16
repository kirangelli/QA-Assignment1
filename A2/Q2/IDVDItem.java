import java.time.Duration;
import java.util.ArrayList;

public interface IDVDItem
{
	public Duration GetPlayTime();

	public ArrayList<String> GetCastList();
}