
/**
 * Created by maxim on 2.01.16.
 */
public class MailRocket  {

    public static final int MAX_FUEL = 100;
    public static final int ONE_START_FUEL = 20;
    public static final int PACKAGE_MAXIMUM_WEIGHT = 100;

    protected int fuel, fuelSum;

    protected Package packageToSend;
    protected MailOffice currentPosition;

    public MailRocket () {
        // NB ! We need to create offices first!
        Planet.setRandomPlanetToRocket(this);

        Thread thread = new Thread(new FlyRunnable(this));
        thread.start();
    }

    public boolean start() {
        if (fuel < ONE_START_FUEL) {
            return false;
        }

        if (packageToSend != null && (packageToSend.getDestinationPlanet().equals(Planet.MERCURY) || packageToSend.getDestinationPlanet().equals(Planet.VENUS))) {
            return false;
        }

        fuel -= ONE_START_FUEL;
        return true;
    }

    public MailRocket refuel() {
        int fuelToAdd = MAX_FUEL - fuel;
        fuelSum += fuelToAdd;
        fuel += fuelToAdd;

        return this;
    }

    public boolean pack(Package packingPackage) {

        if (packingPackage.getPackageWeight() > PACKAGE_MAXIMUM_WEIGHT) {
            System.out.println("You can't pack so much packages on one rocket. Max 100");
            return false;
        } else {
            packageToSend = packingPackage;
            return true;
        }
    }

}
