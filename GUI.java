package solid;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JTextField englishWord = new JTextField();
    private JButton guessButton = new JButton();

    public GUI() {
        MigLayout layout = new MigLayout("fillx,wrap 3", "[left]rel[grow,fill][right]");
        JPanel panel = new JPanel(layout);
        panel.add(new JLabel("English:"));
        panel.add(englishWord,"wrap");
        panel.add(new JLabel("Czech:"));
        panel.add(new JTextField());
        panel.add(guessButton);
        panel.add(new JLabel("Label Three:"), "span 2");
        panel.add(new JTextField(), "span 2,grow");

        guessButton.setText("Guess");


        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        jf.setLocationRelativeTo(null);
        jf.add(panel, BorderLayout.CENTER);
        jf.setSize(400, 300);
        jf.setVisible(true);
    }
}
