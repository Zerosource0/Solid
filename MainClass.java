/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import solid.Control.MainController;
/**
 *
 * @author marcj_000
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Reset reset = new Reset();
        //reset.resetDictionary();
        
        GUI userInterface = new GUI();
        MainController control = new MainController();
        System.out.println(control.size());
        control.load(MainController.filePath);

        userInterface.init();

        control.save(MainController.filePath);
    }
    
}
