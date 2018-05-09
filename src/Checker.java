import javax.swing.*;

import static java.lang.Thread.sleep;

public class Checker implements Runnable {

    static Card first = null;
    static Card second = null;


    @Override
    public void run() {

        if (first != null && second != null) {
            System.out.println("Sprawdzanie");
            Card f=first;
            Card s=second;
            checkCard();
        }
    }



    public void checkCard() {


        if (first.bottom == second.bottom) {
            System.out.println("Takie same");
            BoardFrame.c++;
            Card.canClick=true;
        } else {

            System.out.println("Różne");

            try {
                sleep(2000);
            } catch (InterruptedException e) {

            }
            SwingUtilities.invokeLater(() -> {
                first.setTextToTop();
                second.setTextToTop();
            });
            Card.canClick=true;
        }
    }
}
