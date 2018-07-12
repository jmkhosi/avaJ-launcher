package simulator.aircrafts;

import simulator.WeatherTower;
import simulator.WriteFile;

class Helicopter extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    Helicopter(String name, Coordinates coordinates) {
		    super(name, coordinates);//Passing this variables to the superclass constructor.
    }


    @Override
    public void updateConditions() {

        String weather = this._weatherTower.getWeather(this.coordinates);

        switch(weather){
            case "SUN":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                    if(this.coordinates.getHeight() > 100)
                        this.coordinates.setHeight(100);
                WriteFile.getWriteFile().WriteToFile(........);
                break;

            case "RAIN":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                //Write to file
                break;

            case "FOG":

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                //Write to file
                break;

            case "SNOW":

                this.coordinates.setLongitude(this.coordinates.getLongitude() - 12);
                //Write to file
                break;

            }

                if(this.coordinates.getHeight() <= 0) {
                    //Write to file landing
                    //Write to
                }

        //get the current weather from the weather provider
        // w = WeatherProvider.getProvider.getCurrentWe(super.coordinates);
        // change conditions according to the weather
        // if w = SUN do what is required, if w = SNOW  do whatever. etc
        // print result according to the weather
        // if the height is 0 or less print landing message and unregister from towel
        //message = "landing";
        //Logger.getInstance().writeToFile(message);

        }


    @Override
    public void registerTower(WeatherTower weatherTower) {

        this._weatherTower = weatherTower;

         //Write to file

    }
}