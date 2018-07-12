package simulator.aircrafts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftFactoryTest {

    @Test
    void newAircraft() {
        AircraftFactory factory = new AircraftFactory();

        Flyable helicopterFlyable = factory.newAircraft("Helicopter", "H1", 1,3,60);
    }
}