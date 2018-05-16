import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RankFrame extends JFrame {

    RankFrame(int k, int time) {
        super();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField jTextField = new JTextField();

        JButton jButton = new JButton("Ok");
        jButton.addActionListener(actionEvent -> {
            new WriterReader().writeFile(jTextField.getText(), k, time);
            dispose();
        });


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        jPanel.setBorder(new EmptyBorder(new Insets(60, 50, 60, 50)));
        jPanel.add(new JLabel(" Your Name"));
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.setBackground(new Color(153, 163, 164));
        add(jPanel);

        pack();
        setSize(new Dimension(225, 250));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
