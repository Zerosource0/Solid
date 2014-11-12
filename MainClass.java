/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import Control.MainController;
import java.util.ArrayList;

/**
 *
 * @author marcj_000
 */
public class MainClass {

    public static ArrayList<Word> collection = new ArrayList<Word>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainController control = new MainController();
        control.load("src/solid/Dictionary.txt");
        //control.save("src/solid/Dictionary.txt");
    }
    
}
