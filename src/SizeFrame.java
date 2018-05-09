import javax.swing.*;
import java.awt.*;

public class SizeFrame extends JFrame {

    SizeFrame(JFrame f) {

        super();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JLabel jLabel = new JLabel("Select Size:");

        JSpinner jSpinner = new JSpinner();
        jSpinner.setModel(new SpinnerNumberModel(2, 2, 30, 2));

        JButton jButtonPlay = new JButton("Play");
        jButtonPlay.addActionListener(actionEvent -> {
            new BoardFrame((int) (jSpinner.getValue()), f);
            dispose();
            f.setVisible(false);
        });
        JButton jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(actionEvent -> dispose());


        add(jLabel);
        add(jSpinner);
        add(jButtonBack);
        add(jButtonPlay);


        pack();
        setSize(new Dimension(225, 100));
        setVisible(true);
    }
}
