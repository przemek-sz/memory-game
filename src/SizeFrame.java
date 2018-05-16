import javax.swing.*;
import java.awt.*;

public class SizeFrame extends JFrame {

    SizeFrame(JFrame menuFrame) {

        super();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JLabel jLabel = new JLabel("Select Size:");

        JSpinner jSpinner = new JSpinner();
        jSpinner.setModel(new SpinnerNumberModel(2, 2, 30, 2));

        JButton jButtonPlay = new JButton("Play");
        jButtonPlay.addActionListener(actionEvent -> {
            if ((int) jSpinner.getValue() % 2 == 0) {
                new BoardFrame((int) (jSpinner.getValue()), menuFrame);
                dispose();
                menuFrame.setVisible(false);
            } else {
                JDialog dialog = new JDialog();
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.add(new JLabel("Podaj liczbe parzysta"), BorderLayout.PAGE_START);
                JButton jButton = new JButton("OK");
                jButton.addActionListener(actionEvent1 -> {
                    dialog.dispose();
                });
                panel.add(jButton, BorderLayout.PAGE_END);
                dialog.add(panel);
                dialog.setSize(250, 100);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        JButton jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(actionEvent -> dispose());


        add(jLabel);
        add(jSpinner);
        add(jButtonBack);
        add(jButtonPlay);


        pack();
        setSize(new Dimension(225, 100));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
