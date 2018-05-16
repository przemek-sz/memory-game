import javax.swing.*;
import java.awt.*;


public class BoardFrame extends JFrame {

    BoardFrame(int k, JFrame menuFrame) {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(k, k));


        for (Character character : Card.createDeck(k)) {
            Card card = new Card();
            card.setBottom(character);
            card.setFont(new Font("Arial", Font.BOLD, 450 / k));
            card.setSize(10, 100);
            card.setBackground(new Color(164, 188, 183));
            card.addActionListener(actionEvent -> {
                Card.showCard(card);
            });
            boardPanel.add(card);
        }


        JPanel menuPanel = new JPanel();
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(actionEvent -> {
            dispose();
            menuFrame.setVisible(true);

        });


        JLabel timer = new JLabel();
        timer.setText("000");

        menuPanel.add(menuButton);
        menuPanel.add(timer);

        add(boardPanel);
        add(menuPanel, BorderLayout.SOUTH);


        pack();

        setMinimumSize(new Dimension(640, 480));

        setSize((640 * (k / 4)), 480 * (k / 4));
        setLocationRelativeTo(null);
        setVisible(true);

        new Thread(new Counter(timer, k, this, menuFrame)).start();

    }

}
