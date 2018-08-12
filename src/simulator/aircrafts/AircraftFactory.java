package simulator.aircrafts;


public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equals("Helicopter")) {
            Helicopter helicopter = new Helicopter(name, coordinates);
            return helicopter;
        } else if (type.equals("JetPlane")) {

            JetPlane jetplane = new JetPlane(name, coordinates);
            return jetplane;

        } else if (type.equals("Baloon")) {

            Baloon baloon = new Baloon(name, coordinates);
            return baloon;

        }
        return null;
    }
}