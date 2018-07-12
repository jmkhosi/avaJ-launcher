package simulator.aircrafts;

import simulator.WeatherTower;

public interface Flyable
{//Collectioon of abstract methods
        
	public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    
}