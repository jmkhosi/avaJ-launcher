package simulator.aircrafts;

import simulator.WeatherTower;
import simulator.WriteFile;

class JetPlane extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
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

                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);

                WriteFile.getWriteFile().WriteToFile("JetPlane#" + this.name + "(" + this.id + "): It's too hot");
                break;

            case "RAIN":

                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                WriteFile.getWriteFile().WriteToFile("JetPlane#" + this.name + "(" + this.id + "): Turn on the windshield wipers");
                break;

            case "FOG":

                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                WriteFile.getWriteFile().WriteToFile("JetPlane#" + this.name + "(" + this.id + "): It's foggy today..I can't see. Better switch on the lights to bright");
                break;

            case "SNOW":

                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                WriteFile.getWriteFile().WriteToFile("JetPlane#" + this.name + "(" + this.id + "): OMG! It is super cold. Keep the engine running");
                break;

            default:

                WriteFile.getWriteFile().WriteToFile("JetPlane#" + this.name + "(" + this.id + "): NO RESPONSE FROM WEATHER TOWER");


        }

        if (this.coordinates.getHeight() == 0) {

            WriteFile.getWriteFile().WriteToFile("JetPlane#" + this.name + "(" + this.id + ")Landing.");
//            this._weatherTower.unregister(this);
            WriteFile.getWriteFile().WriteToFile("Tower says:JetPlane#" + this.name + "(" + this.id + ")" + " Unregistered from Weather Tower.");


        }

    }


    @Override
    public void registerTower(WeatherTower weatherTower) {

        this._weatherTower = weatherTower;
        WriteFile.getWriteFile().WriteToFile("Tower says:JetPlane#" + this.name + "(" + this.id + ")" + " Registered to Weather Tower.");
        this._weatherTower.register(this);

        //Write to file

    }
}