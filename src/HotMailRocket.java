/**
 * Created by maxim on 7.01.16.
 */
public class HotMailRocket extends MailRocket {

    public static final int ONE_HOT_START_FUEL = 25;

    @Override
    public void start() {
        if (fuel < ONE_HOT_START_FUEL) {
            System.out.println("Not enough fuel");
        }

        fuel -= ONE_HOT_START_FUEL;
    }

}
