import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostSystem {

    public static final List<MailOffice> mailOffices = new ArrayList<>();
    public static final List<MailRocket> mailRockets = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        //Create offices
        synchronized (mailOffices) {
            for (Planet planet : Planet.values()) {
                MailOffice mailOffice = new MailOffice(planet);
                mailOffices.add(mailOffice);
            }
        }

        //Create 20 default rockets
        createRockets(20);
        //Create 5 hot resist rockets
        createHotResistRockets(5);

        Thread packageGeneratorThread = new Thread(new PackageRunnable());
        packageGeneratorThread.start();


    }

    public static void createRockets(int total) {
        synchronized (mailRockets) {
            if (total != 0) {
                mailRockets.add(new MailRocket());
                mailRockets.notifyAll();
                createRockets(total - 1);
            }
        }
    }

    public static void createHotResistRockets(int total) {
        synchronized (mailRockets) {
            if (total != 0) {
                mailRockets.add(new HotMailRocket());
                mailRockets.notifyAll();
                createHotResistRockets(total - 1);
            }
        }
    }

    public static Optional<MailOffice> getMailOffice(Planet planet) {
        return mailOffices.stream().filter(mailOffice -> mailOffice.getPlanet().equals(planet)).findFirst();
    }


}
