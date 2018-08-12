package simulator.aircrafts;

public class Coordinates {
	private	int		longitude;
	private	int		latitude;
	private	int		height;

	Coordinates(int _longitude, int _latitude, int _height)
	{
		this.longitude = _longitude;
		this.latitude = _latitude;
		this.height = _height;
	}

	//Setters
	public	void setLongitude(int _longitude)
	{
		if (_longitude < 0)
			this.longitude = 0;

		this.longitude = _longitude;
	}
	
	public	void setLatitude(int _latitude)
	{
		if (_latitude < 0)
			this.latitude = 0;

		this.latitude = _latitude;
	}
	
	public	void setHeight(int _height)
	{
		if (_height > 100)
			this.height = 100;
		else if (_height < 0)
			this.height = 0;
		else
			this.height = _height;
	}


	//Getters
	public int	getLongitude()
	{
		return (this.longitude);
	}

	public int getLatitude()
	{
	return (this.latitude);
	}

	public int	getHeight()
	{
		return (this.height);
	}
}