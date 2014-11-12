/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import solid.Control.MainController;
import java.util.ArrayList;

/**
 *
 * @author marcj_000
 */
public class MainClass {

    public static ArrayList<Word> collection = new ArrayList<Word>();
    public static String filePath = "src/solid/files/Dictionary.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI userInterface = new GUI();
        MainController control = new MainController();
        control.load(filePath);
        
        //control.checkGuess("cat", "kočka");
        control.save(filePath);
        
        
    }
    
}
