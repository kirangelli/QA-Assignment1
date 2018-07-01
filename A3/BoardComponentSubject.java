import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BoardComponentSubject implements ISubject {

	private static List<IAsteroidImpactObserver> observers;
	private static BoardComponentSubject instance = null;
	static List<IAsteroidImpactObserver> detachingObservers = null;
	
	public static BoardComponentSubject Instance()
	{
		if (null == instance)
		{
			instance = new BoardComponentSubject();
			observers = new ArrayList<IAsteroidImpactObserver>();

			
		}
		return instance;
	}
	
	@Override
	public void Attach(IAsteroidImpactObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void Detach(IAsteroidImpactObserver observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void Notify(ArrayList<BoardComponent> children) {
		// TODO Auto-generated method stub
		for(int i=0;i<children.size();i++)
		{
			for(int j=0;j<observers.size();j++)
			{
				// if children is an observer
				if(children.get(i).equals(observers.get(j)))
				{
					observers.get(j).Update();
				}
			}
			
		}
		
		
	}
}
	
	
	
//	public void removeDetachedObservers()
//	{
//		observers.removeAll(detachingObservers);
//		detachingObservers = null;
//	}
//}
