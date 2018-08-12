package simulator.aircrafts;

public class Aircraft{

    protected long id;//Visible to the package and all sub-classes (protected).
    protected String name;
    protected Coordinates coordinates;
    public static long _idCounter = 0;//STATIC: Can be accessed without any object(instance).

    protected Aircraft(String name, Coordinates coordinates)//Constructor : Sets everything up ...Instantiate everything
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId(); //1
    }

    public long nextId()
    {
        return (_idCounter++);//Each time we add a new aircraft with its coordinates

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static long get_idCounter() {
        return _idCounter;
    }

    public static void set_idCounter(long _idCounter) {
        Aircraft._idCounter = _idCounter;
    }
}