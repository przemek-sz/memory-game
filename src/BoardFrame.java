import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class BoardFrame extends JFrame {

    public static int c = 0;

    BoardFrame(int k, JFrame f) {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(k, k));

        for(Character character:Card.createDeck(k)){
            Card card = new Card();
            card.setBottom(character);
            card.setFont(new Font("Arial",Font.BOLD,450/k));
            card.addActionListener(actionEvent ->{
                Card.showCard(card);
                new Thread(new Checker()).start();
            });
            boardPanel.add(card);
        }


        JPanel menuPanel = new JPanel();
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(actionEvent -> {
            dispose();
            f.setVisible(true);

        });


        JLabel timer = new JLabel();
        timer.setText("000");

        menuPanel.add(menuButton);
        menuPanel.add(timer);

        add(boardPanel);
        add(menuPanel, BorderLayout.SOUTH);


        pack();

        setMinimumSize(new Dimension(640,480));

        setSize((640*(k/4)),480*(k/4));
        setVisible(true);

        new Thread(new Counter(timer,k,this,f)).start();


    }

}
