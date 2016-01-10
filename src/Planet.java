import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by maxim on 2.01.16.
 */

public enum Planet {
    MERCURY,
    VENUS,
    EARTH,
    MARS,
    JUPITER,
    SATURN,
    URANUS,
    NEPTUNE,
    PLUTO,
    IO,
    MOON;

    private static final List<Planet> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static List<Planet> getTwoRandomPlanets()  {
        int randOne = RANDOM.nextInt(SIZE);
        int randTwo = RANDOM.nextInt(SIZE);

        if (randOne == randTwo) return getTwoRandomPlanets();

        return Arrays.asList(VALUES.get(randOne), VALUES.get(randTwo));
    }

    public static MailRocket setRandomPlanetToRocket(MailRocket rocket) {
        Planet randomPlanet = VALUES.get(RANDOM.nextInt(SIZE));

        if (!(rocket instanceof HotMailRocket) && HotMailRocket.HIGH_FUEL_COST_PLANETS.contains(randomPlanet)) {
            return setRandomPlanetToRocket(rocket);
        }

        rocket.currentPosition = PostSystem.getMailOffice(randomPlanet).get();

        return rocket;
    }
}
