import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by maxim on 7.01.16.
 */
public class MailOffice {

    private Planet planet;
    private List<Package> receivedPackages;

    public double getAverageWeight() {
        return getReceivedTotalWeight() / getTotalReceived();
    }

    public List<Planet> getSourcePlanets() {
        return receivedPackages.stream().map(Package::getSource).collect(Collectors.toList());
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

}
