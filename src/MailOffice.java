import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by maxim on 7.01.16.
 */
public class MailOffice {

    private Planet planet;

    private final List<Package> waitingPackages = new ArrayList<>();
    private final List<Package> receivedPackages = new ArrayList<>();

    public MailOffice(Planet planet) {
        this.planet = planet;
    }

    public double getAverageWeight() {
        return getReceivedTotalWeight() / getTotalReceived();
    }

    public List<Planet> getSourcePlanets() {
        return receivedPackages.stream().map(Package::getSourcePlanet).collect(Collectors.toList());
    }

    public int getTotalReceived() {
        return receivedPackages.size();
    }

    public int getReceivedTotalWeight() {
        return receivedPackages.stream().mapToInt(Package::getPackageWeight).sum();
    }

    public long packCountQuery(Predicate<Package> packagesFilter) {
        return receivedPackages.stream().filter(packagesFilter).count();
    }

    public void addPackageToSend(Package packageToSend) {
        synchronized (waitingPackages) {
            waitingPackages.add(packageToSend);
            waitingPackages.notifyAll();
        }
    }

    public synchronized List<Package> getWaitingPackages() {
        return waitingPackages;
    }

    public synchronized boolean maintenanceRocket(MailRocket maintenantingRocket) {
        unpack(maintenantingRocket);
        maintenantingRocket.refuel();
        return pack(maintenantingRocket) && maintenantingRocket.start();
    }

    public void unpack(MailRocket incomingRocket) {
        synchronized (receivedPackages) {
            if (incomingRocket.packageToSend != null) {
                receivedPackages.add(incomingRocket.packageToSend);
                incomingRocket.packageToSend = null;
            }
        }
    }

    public boolean pack(MailRocket outcomingRocket) {
        synchronized (waitingPackages) {
            boolean isPacked = waitingPackages.size() > 0 && outcomingRocket.pack(waitingPackages.get(0));
            if (isPacked) waitingPackages.remove(0);
            return isPacked;
        }
    }

    public Planet getPlanet() {
        return planet;
    }

}
