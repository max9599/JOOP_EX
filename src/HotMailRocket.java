import java.util.ArrayList;

/**
 * Created by maxim on 7.01.16.
 */
public class HotMailRocket extends MailRocket {

    public static final int ONE_HOT_START_FUEL = 25;
    public static final int MAX_PACKAGES_WEIGHT = 80;

    @Override
    public void start() {
        if (fuel < ONE_HOT_START_FUEL) {
            System.out.println("Not enough fuel");
        }

        fuel -= ONE_HOT_START_FUEL;
    }

    @Override
    public void pack(Package packingPackage) {
        if (packages == null) {
            packages = new ArrayList<>();
        }

        if (totalPackagesWeight + packingPackage.getPackageWeight() > MAX_PACKAGES_WEIGHT) {
            System.out.println("You can't pack so much packages on one hot resist rocket. Max 80");
        } else {
            packages.add(packingPackage);
        }
    }
}
