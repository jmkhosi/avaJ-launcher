package simulator.aircrafts;

class Aircraft{

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    public static long _idCounter = 0;//STATIC: Can be accessed without any object(instance).

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId(); //1
    }

    public long nextId()

    {
        return (Aircraft._idCounter++);
    }
}