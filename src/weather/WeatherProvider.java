package weather;

import simulator.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String[] weather;

	private WeatherProvider() {
		weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
	}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null){
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{

		return randomiseWeather(coordinates);
	}

	private String randomiseWeather(Coordinates coordinates) {
		int seed = coordinates.getHeight() * coordinates.getLongitude() * coordinates.getLatitude();
		Random random = new Random(Double.doubleToLongBits(Math.random() + seed));


		int index = random.nextInt(4);
		return weather[index];
	}
}
