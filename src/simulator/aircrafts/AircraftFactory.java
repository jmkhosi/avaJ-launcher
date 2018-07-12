package simulator.aircrafts;

public class AircraftFactory{

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equals("Helicopter"))
        {
            Helicopter helicopter = new Helicopter(name, coordinates);
            return helicopter;
        }
        else if (type.equals("JetPlane")){

        }




      return null;
    }
}