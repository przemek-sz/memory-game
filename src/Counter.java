import javax.swing.*;

import static java.lang.Thread.sleep;

public class Counter implements Runnable {


    int k=0;
    int time=0;
    int minutes=0;
    int second=0;
    JLabel timerLabel =null;
    JFrame boardFrame=null;
    JFrame menuFrame =null;


    Counter(JLabel timerLabel,int k,JFrame boardFrame,JFrame mainFrame){
        this.timerLabel =timerLabel;
        this.k=k;
        this.boardFrame=boardFrame;
        this.menuFrame =mainFrame;
    }


    @Override
    public void run() {

        while(BoardFrame.c<(k*k)/2&&boardFrame.isVisible()){
            try {
                System.out.println("counter");
                time++;
                SwingUtilities.invokeLater(() -> {
                    minutes=time/60;
                    second=time%60;

                    timerLabel.setText(minutes+":"+second);
                });

                sleep(1000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }


        }
        BoardFrame.c=0;
        boardFrame.dispose();
        menuFrame.setVisible(true);
        new RankFrame(k,time);

    }
}
