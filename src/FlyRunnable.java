/**
 * Created by maxim on 7.01.16.
 */
public class FlyRunnable implements Runnable{

    private final MailRocket rocket;

    public FlyRunnable(MailRocket rocket) {
        this.rocket = rocket;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                fly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //Terminate thread
        Thread.currentThread().interrupt();

    }

    public void fly () throws InterruptedException {
        //Unpack, refuel, pack, fly
        synchronized (rocket.currentPosition.getWaitingPackages()) {


            if (rocket.currentPosition.maintenanceRocket(rocket)) {
                //we have a pack, lets fly
                System.out.println("We fly from " + rocket.currentPosition.getPlanet() + " to " + rocket.packageToSend.getDestination().getPlanet());
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                rocket.currentPosition = rocket.packageToSend.getDestination();
            } else {
                // ok, no packs anymore here or we cant deliver them, change rocket position
                try {
                    Planet.setRandomStartOfficeToRocket(rocket);
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
