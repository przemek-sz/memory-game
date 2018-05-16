import javax.swing.*;

import static java.lang.Thread.sleep;

public class Checker implements Runnable {

    static Card first = null;
    static Card second = null;


    @Override
    public void run() {

        if (first != null && second != null) {
            checkCard();
        }

    }

    public void checkCard() {


        if (first.bottom == second.bottom) {
            first = null;
            second = null;
            Counter.foundPair++;

        } else {

            try {
                sleep(2000);
            } catch (InterruptedException e) {

            }

            SwingUtilities.invokeLater(() -> {
                first.setTextToTop();
                first.setExposed(false);
                first = null;

                second.setTextToTop();
                second.setExposed(false);
                second = null;
            });
        }
    }
}
