import java.util.Arrays;
import java.util.List;

/**
 * Created by maxim on 7.01.16.
 */
public class HotMailRocket extends MailRocket {

    public static final int ONE_HOT_START_FUEL = 25;
    public static final int ONE_EXTRA_HOT_START_FUEL = 50;
    public static final int MAX_PACKAGE_WEIGHT = 80;
    public static final List<Planet> HIGH_FUEL_COST_PLANETS = Arrays.asList(Planet.MERCURY, Planet.VENUS);

    public HotMailRocket() {
        super();
    }

    @Override
    public boolean start() {
        if (HIGH_FUEL_COST_PLANETS.contains(packageToSend.getDestinationPlanet()) && HIGH_FUEL_COST_PLANETS.contains(packageToSend.getSourcePlanet())) {

            if (HIGH_FUEL_COST_PLANETS.contains(packageToSend.getSourcePlanet())) {
                if (fuel < ONE_EXTRA_HOT_START_FUEL) {
                    return false;
                } else {
                    fuel -= ONE_EXTRA_HOT_START_FUEL;
                    return true;
                }
            } else {
                if (fuel < ONE_HOT_START_FUEL) {
                    return false;
                } else {
                    fuel -= ONE_HOT_START_FUEL;
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean pack(Package packingPackage) {
        if (packingPackage.getPackageWeight() > MAX_PACKAGE_WEIGHT) {
            System.out.println("You can't pack so much packages on one rocket. Max 80");
            return false;
        } else {
            packageToSend = packingPackage;
            return true;
        }
    }
}
