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

    private JFrame jfAdd = new JFrame();
    private MainController control = new MainController();
    private JTextField newEnglishWord = new JTextField();
    private JTextField newCzechWord = new JTextField();
    private JButton addWordButton = new JButton();


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
        newWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEnglishWord.setText("");
                newCzechWord.setText("");
                jfAdd.setVisible(true);
            }
        });

        guessButton.setText("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController control = new MainController();

                if(control.checkGuess(englishWord.getText(),czechWord.getText())){
                    init();
                }
                
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

        addWord();
    }

    public void init() {
        MainController control = new MainController();
        englishWord.setText(control.getRandomQuestion());
        czechWord.setText("");
    }

    public void addWord() {
        MigLayout layout = new MigLayout("fillx,wrap 2", "[left][grow,fill]");
        JPanel panel = new JPanel(layout);
        //panel.add(new JLabel("Add new word."),"span 2");
        panel.add(new JLabel(""),"span 3");
        panel.add(new JLabel("English word:"));
        panel.add(newEnglishWord,"wrap");
        panel.add(new JLabel("Czech translation:"));
        panel.add(newCzechWord,"wrap");
        panel.add(new JLabel(""));
        panel.add(addWordButton);

        addWordButton.setText("Add word");
        addWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.add(newEnglishWord.getText(),newCzechWord.getText());
                control.save(MainClass.filePath);
                jfAdd.setVisible(false);
                newEnglishWord.setText("");
                newCzechWord.setText("");
            }
        });

        jfAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jfAdd.setLayout(new BorderLayout());
        jfAdd.setLocationRelativeTo(null);
        jfAdd.add(panel, BorderLayout.CENTER);
        jfAdd.setSize(400, 250);
        jfAdd.setVisible(true);
        jfAdd.setVisible(false);
    }
}
