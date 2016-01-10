/**
 * Created by maxim on 7.01.16.
 */
public class Package {

    private MailOffice source;
    private MailOffice destination;
    private int packageWeight;

    public Package(MailOffice source, MailOffice destination, int packageWeight) {
        this.source = source;
        this.destination = destination;
        this.packageWeight = packageWeight;
    }

    public MailOffice getSource() {
        return source;
    }

    public MailOffice getDestination() {
        return destination;
    }

    public Planet getSourcePlanet() {
        return source.getPlanet();
    }

    public Planet getDestinationPlanet() {
        return destination.getPlanet();
    }

    public int getPackageWeight() {
        return packageWeight;
    }

}
