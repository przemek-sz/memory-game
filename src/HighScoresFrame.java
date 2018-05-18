import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HighScoresFrame extends JFrame {

    HighScoresFrame() {
        super();
        JList jList = null;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<String> lines = new ArrayList<>(Arrays.asList(new WriterReader().readFile().split("\n")));
        List<String> sortList = new ArrayList<>();

        StringBuffer stringBuffer;
        String max = null;
        int maxJ = 0;

        if (lines.toString().length() > 2) {
            for (int i = 0; i < lines.size(); i++) {
                stringBuffer = new StringBuffer();

                if (max == null) {
                    max = lines.get(i);
                } else if (Integer.parseInt(lines.get(i).split(" ")[4]) > Integer.parseInt(max.split(" ")[4])) {
                    max = lines.get(i);
                    maxJ = i;
                }

                if (i + 1 == lines.size()) {
                    i = -1;
                    lines.remove(maxJ);
                    stringBuffer.append(max.split(" ")[0] + " ");
                    stringBuffer.append(max.split(" ")[1] + " ");
                    stringBuffer.append(max.split(" ")[2] + ":" + max.split(" ")[3] + " ");
                    stringBuffer.append(max.split(" ")[4]);
                    sortList.add(stringBuffer.toString());
                    max = null;
                    maxJ = 0;
                }
            }
            jList = new JList(sortList.toArray());
            jList.setFont(new Font("Arial", Font.PLAIN, 20));
            jList.setBackground(new Color(153, 163, 164));
        }


        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setViewportView(jList);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        add(jScrollPane);

        pack();
        setSize(250, 350);
        setTitle("High Scores");
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
