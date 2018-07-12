import simulator.aircrafts.Coordinates;

class Baloon extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);//Passing this variables to the superclass constructor.
    }


    @Override
    public void updateConditions() {
        String weather = this._weatherTower.getWeather(this.coordinates);

        switch(weather){

            case SUN:

                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                if(this.coordinates.getHeight() > 100){
                    this.coordinates.setHeight(100);
                }
                if(this.coordinates.getHeight() <= 0){

                    //Write to file
                }
                break;

            case RAIN:

                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                if(this.coordinates.getHeight() > 100){
                    this.coordinates.setHeight(100);
                }
                if(this.coordinates.getHeight() <= 0){

                    //Write to file
                }
                break;

            case FOG:

                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                if(this.coordinates.getHeight() > 100){
                    this.coordinates.setHeight(100);
                }
                if(this.coordinates.getHeight() <= 0){

                    //Write to file
                }
                break;

            case SNOW:

                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                if(this.coordinates.getHeight() > 100){
                    this.coordinates.setHeight(100);
                }
                if(this.coordinates.getHeight() <= 0){

                    //Write to file
                }
                break;


            //get the current weather from the weather provider
            // w = WeatherProvider.getProvider.getCurrentWe(super.coordinates);
            // change conditions according to the weather
            // if w = SUN do what is required, if w = SNOW  do whatever. etc
            // print result according to the weather
            // if the height is 0 or less print landing message and unregister from towel
            //message = "landing";
            //Logger.getInstance().writeToFile(message);

        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}