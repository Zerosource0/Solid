package solid;

import net.miginfocom.swing.MigLayout;
import solid.Control.MainController;
import solid.HelpClasses.Reset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI {
    private JTextField englishWord = new JTextField();
    private JTextField czechWord = new JTextField();
    private JButton guessButton = new JButton();
    private JButton newWordButton = new JButton();
    private JButton nextButton = new JButton();
    private JLabel rewardLabel = new JLabel();
    private JButton lookupButton = new JButton();

    private JFrame jf = new JFrame();
    private JButton resetButton = new JButton();
   
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
        panel.add(englishWord);
        panel.add(lookupButton);
        panel.add(new JLabel("Czech:"));
        panel.add(czechWord);
        panel.add(guessButton);
        panel.add(new JLabel(""));
        panel.add(nextButton);
        panel.add(resetButton);
        panel.add(new JLabel(""));
        panel.add(rewardLabel);
        
        resetButton.setText("Reset Progress");
        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Reset reset = new Reset();
                reset.resetDictionary();
            }
        });

        newWordButton.setText("Add new word");
        newWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEnglishWord.setText("");
                newCzechWord.setText("");
                jfAdd.setLocationRelativeTo(jf);
                jfAdd.setVisible(true);
                jf.setVisible(false);
            }
        });

        lookupButton.setText("Lookup");
        lookupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czechWord.setText(control.lookup(englishWord.getText()));
                guessButton.setEnabled(false);
            }
        });

        guessButton.setText("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController control = new MainController();

                if(control.checkGuess(englishWord.getText(),czechWord.getText())){
                    rewardLabel.setText("That's right!");
                    init();
                } else {
                    rewardLabel.setText("Let's try again...");
                }
                control.save(MainController.filePath);
            }
        });

        nextButton.setText("Next Word");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessButton.setEnabled(true);
                rewardLabel.setText("");
                init();
            }
        });


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
                control.save(MainController.filePath);
                jf.setLocationRelativeTo(jfAdd);
                jfAdd.setVisible(false);
                jf.setVisible(true);
                newEnglishWord.setText("");
                newCzechWord.setText("");
            }
        });

        jfAdd.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jfAdd.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                jf.setLocationRelativeTo(jfAdd);
                jfAdd.setVisible(false);
                jf.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        jfAdd.setLayout(new BorderLayout());
        jfAdd.setLocationRelativeTo(jf);
        jfAdd.add(panel, BorderLayout.CENTER);
        jfAdd.setSize(400, 250);
    }
}
