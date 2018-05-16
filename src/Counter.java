import javax.swing.*;

import static java.lang.Thread.sleep;

public class Counter implements Runnable {


    int k = 0;
    int time = 0;
    int minutes = 0;
    int seconds = 0;
    static int foundPair = 0;
    JLabel timerLabel = null;
    JFrame boardFrame = null;
    JFrame menuFrame = null;


    Counter(JLabel timerLabel, int k, JFrame boardFrame, JFrame mainFrame) {
        this.timerLabel = timerLabel;
        this.k = k;
        this.boardFrame = boardFrame;
        this.menuFrame = mainFrame;
    }


    @Override
    public void run() {

        while (foundPair < (k * k) / 2 && boardFrame.isVisible()) {
            try {
                time++;
                SwingUtilities.invokeLater(() -> {
                    minutes = time / 60;
                    seconds = time % 60;

                    timerLabel.setText(minutes + ":" + seconds);
                });

                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boardFrame.dispose();
        menuFrame.setVisible(true);
        if (foundPair == (k * k) / 2) {
            new RankFrame(k, time);
        }
        foundPair = 0;
    }
}
