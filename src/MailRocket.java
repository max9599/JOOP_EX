import sun.text.CollatorUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 2.01.16.
 */
public class MailRocket  {

    public static final int MAX_FUEL = 100;
    public static final int ONE_START_FUEL = 20;
    public static final int PACKAGES_MAXIMUM_WEIGHT = 100;

    protected int fuel, fuelSum, totalPackagesWeight;

    protected List<Package> packages;

    public void start() {
        if (fuel < ONE_START_FUEL) {
            System.out.println("Not enough fuel");
        }
        fuel -= ONE_START_FUEL;
    }

    public void refuel() {
        int fuelToAdd = MAX_FUEL - fuel;
        fuelSum += fuelToAdd;
        fuel += fuelToAdd;
    }

    public void pack(Package packingPackage) {
        if (packages == null) {
            packages = new ArrayList<>();
        }

        if (totalPackagesWeight + packingPackage.getPackageWeight() > PACKAGES_MAXIMUM_WEIGHT) {
            System.out.println("You can't pack so much packages on one rocket.");
        } else {
            packages.add(packingPackage);
        }

    }

    public List<Package> unpack() {
        List<Package> packagesToUnPack = new ArrayList<>(packages);
        packages.clear();
        return packagesToUnPack;
    }

}
