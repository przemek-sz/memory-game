import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class MenuFrame extends JFrame {


    MenuFrame() {

        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(new Insets(30, 0, 0, 0)));
        mainPanel.setBackground(new Color(153, 163, 164));


        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(new EmptyBorder(new Insets(40, 70, 40, 70)));
        menuPanel.setBackground(new Color(153, 163, 164));


        JLabel jLabel1 = new JLabel("Memory");
        jLabel1.setBorder(new EmptyBorder(new Insets(0, 30, 0, 30)));


        //JLabel jLabel2 = new JLabel("s16859");
        //jLabel2.setBorder(new EmptyBorder(new Insets(0,30,0,30)));


        JButton jButton1 = new JButton(" New Game ");
        jButton1.addActionListener((actionEvent) -> new SizeFrame(this));
        JButton jButton2 = new JButton("High Scores");
        jButton2.addActionListener(actionEvent -> new HighScoresFrame());
        JButton jButton3 = new JButton("      Exit        ");
        jButton3.addActionListener((actionEvent) -> dispose());


        menuPanel.add(jLabel1);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        //menuPanel.add(jLabel2);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        menuPanel.add(jButton1);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        menuPanel.add(jButton2);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        menuPanel.add(jButton3);


        mainPanel.add(menuPanel);
        add(mainPanel);

        pack();
        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
