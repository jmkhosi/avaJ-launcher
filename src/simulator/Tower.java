package simulator;

import simulator.aircrafts.Flyable;
import simulator.aircrafts.*;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {

	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		if (observers.contains(flyable))
			return ;
		observers.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		if (!observers.contains(flyable))
			return;
		observers.remove(flyable);
	}	
	
//	protected void	conditionsChanged()
//	{
//		for (int i = 0; i < observers.size(); i++)
//		{
//			observers.get(i).updateConditions();
//		}
//	}

	protected void conditionsChanged() {
		Iterator<Flyable> iterator = observers.iterator();
		while (iterator.hasNext())
		{
			Flyable flyable = iterator.next();
			flyable.updateConditions();
			Aircraft aircraft = (Aircraft)flyable;
			if (aircraft.getCoordinates().getHeight() == 0) {
				iterator.remove();
				unregister(flyable);
			}
		}
		if (observers.size() == 0)
		{
			System.out.println("Every aircraft has landed");
			WriteFile.getWriteFile().closeFile();
			System.exit(0);
		}
	}
}