package simulator.aircrafts;

import simulator.WeatherTower;
import simulator.WriteFile;

class Helicopter extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    Helicopter(String name, Coordinates coordinates) {
		    super(name, coordinates);//Passing this variables to the superclass constructor.
    }


    //get the current weather from the weather provider
    // w = WeatherProvider.getProvider.getCurrentWe(super.coordinates);
    // change conditions according to the weather
    // if w = SUN do what is required, if w = SNOW  do whatever. etc
    // print result according to the weather
    // if the height is 0 or less print landing message and unregister from towel
    //message = "landing";
    //Logger.getInstance().writeToFile(message);

    @Override
    public void updateConditions() {

        String weather = this._weatherTower.getWeather(this.coordinates);

        switch(weather)
        {
            case "SUN":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);

                WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +"): What a lovely day...I do love summer but man its too hot today.!");
                    break;

            case "RAIN":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +"):Damn! This windshield wipers are not working with this heavy rain");
                break;

            case "FOG":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +"): It's foggy today..I can't see");
                break;

            case "SNOW":

                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +"): My GOSH...It's freezing up here");
                break;

            default:

                WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +"): NO WEATHER RESPONSE");


            }

            if(this.coordinates.getHeight() == 0) {

            WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +")Landing.");
            WriteFile.getWriteFile().WriteToFile("Helicopter#" + this.name +"("+ this.id +")" + " Unregistered from Weather Tower.");
                //Write to file landing
                //Write to
            }

        }


    @Override
    public void registerTower(WeatherTower weatherTower) {

        this._weatherTower = weatherTower;
        WriteFile.getWriteFile().WriteToFile("Tower says:Helicopter#" + this.name +"("+ this.id +")" + " Registered to Weather Tower.");
        _weatherTower.register(this);
         //Write to file

    }
}