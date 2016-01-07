import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maxim on 7.01.16.
 */
public class MailOffice {

    private Planet planet;
    private int totalReceived, receivedTotalWeight;
    private List<Package> receivedPackages;

    public double getAverageWeight() {
        return receivedTotalWeight / totalReceived;
    }

    public List<Planet> getSourcePlanets() {
        return receivedPackages.stream().map(Package::getSource).collect(Collectors.toList());
    }

}
