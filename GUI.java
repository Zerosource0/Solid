package solid;

import net.miginfocom.swing.MigLayout;
import solid.Control.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JTextField englishWord = new JTextField();
    private JTextField czechWord = new JTextField();
    private JButton guessButton = new JButton();
    private JButton newWordButton = new JButton();
    private JButton nextButton = new JButton();

    public GUI() {
        MigLayout layout = new MigLayout("fillx,wrap 3", "[left][grow,fill][left]");
        JPanel panel = new JPanel(layout);
        panel.add(new JLabel("Welcome to LangLearner."),"span 2");
        panel.add(newWordButton);
        panel.add(new JSeparator(SwingConstants.HORIZONTAL),"span 3");
        panel.add(new JLabel("English:"));
        panel.add(englishWord,"wrap");
        panel.add(new JLabel("Czech:"));
        panel.add(czechWord);
        panel.add(guessButton);
        panel.add(new JLabel(""));
        panel.add(nextButton);

        newWordButton.setText("Add new word");

        guessButton.setText("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController control = new MainController();

                control.checkGuess(englishWord.getText(),czechWord.getText());
                control.save(MainClass.filePath);
            }
        });

        nextButton.setText("Next Word");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
            }
        });

        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        jf.setLocationRelativeTo(null);
        jf.add(panel, BorderLayout.CENTER);
        jf.setSize(400, 250);
        jf.setVisible(true);
    }

    public void init() {
        MainController control = new MainController();
        englishWord.setText(control.getRandomQuestion());
        czechWord.setText("");
    }
}
