package simulator.aircrafts;

import simulator.WeatherTower;
import simulator.WriteFile;

class Baloon extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    Baloon(String name, Coordinates coordinates) {
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

        switch (weather) {
            case "SUN":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name + "(" + this.id + "): Shit man... It's so hot today");
                break;

            case "RAIN":

                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name + "(" + this.id + "): It's raining. Better watch out for lighting.");
                break;

            case "FOG":

                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name + "(" + this.id + "): It's foggy today..I can't see");
                break;

            case "SNOW":

                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name + "(" + this.id + "): My GOSH...It's freezing up here");
                break;

            default:

                WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name + "(" + this.id + "): NO WEATHER RESPONSE");





        }

        if (this.coordinates.getHeight() == 0) {

            WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name + "(" + this.id + ")Landing.");
            WriteFile.getWriteFile().WriteToFile("Baloon#" + this.name +"("+ this.id +")" + " Unregistered from Weather Tower.");

        }


    }


    @Override
    public void registerTower(WeatherTower weatherTower) {

        this._weatherTower = weatherTower;
        WriteFile.getWriteFile().WriteToFile("Tower says:Baloon#" + this.name + "(" + this.id + ")" + " Registered to Weather Tower.");
        _weatherTower.register(this);

        //Write to file
    }
}
