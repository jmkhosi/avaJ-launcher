package simulator;

import simulator.aircrafts.AircraftFactory;
import simulator.aircrafts.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();


    public static void main(String[] arg) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    try {
                        if (line.split(" ").length == 5 ) {
                            Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                                    Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                                    Integer.parseInt(line.split(" ")[4]));
                            if (flyable != null)
                                flyable.registerTower(weatherTower);
                        }
                    } catch(Exception e) {
                        e.getMessage();
                    }
                }

                for (int index = 1; index <= simulations; index++) {
                    WriteFile.getWriteFile().WriteToFile("");
                    weatherTower.changeWeather();
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + arg[0]);
        } catch (IOException e) {
            System.out.println("Error while reading the file " + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify simulation file");
        } catch (NullPointerException e) {
            System.out.println("Value is null");
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number entered in file");
        } finally {
            WriteFile.getWriteFile().closeFile();
        }
    }
}
