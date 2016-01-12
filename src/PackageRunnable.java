import java.util.List;
import java.util.Random;

/**
 * Created by maxim on 7.01.16.
 */
public class PackageRunnable implements Runnable {

    public static final int PACKAGE_COUNT_TO_CREATE = 1500;
    public static final int MIN_PACKAGE_WEIGHT = 1;
    public static final int MAX_PACKAGE_WEIGHT = 80;
    public static int totalPackagesCreated = 0;

    public static final Random random = new Random();

    @Override
    public void run() {
        while(!Thread.interrupted() && totalPackagesCreated != PACKAGE_COUNT_TO_CREATE) {

            List<Planet> twoRandomPlanets = Planet.getTwoRandomPlanets();
            Package generatedPackage = new Package(
                    PostSystem.getMailOffice(
                            twoRandomPlanets.get(0)).get(),
                    PostSystem.getMailOffice(
                            twoRandomPlanets.get(1)).get(),
                    getPackageRandomWeight());

            generatedPackage.getSource().addPackageToSend(generatedPackage);
            totalPackagesCreated++;

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //All packages created
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // For testing ...
        //        synchronized (PostSystem.mailOffices) {
        //            //PostSystem.mailOffices.forEach(mailOffice -> System.out.println(mailOffice.getTotalReceived()));
        //            PostSystem.mailOffices.forEach(mailOffice -> System.out.println(mailOffice.getPlanet() + " planet waiting : " + mailOffice.getWaitingPackages().size()));
        //        }


        Thread.currentThread().interrupt();
    }

    public int getPackageRandomWeight() {
        return random.nextInt((MAX_PACKAGE_WEIGHT - MIN_PACKAGE_WEIGHT) + 1) + MIN_PACKAGE_WEIGHT;
    }

}
