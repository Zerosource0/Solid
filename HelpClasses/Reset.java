/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.HelpClasses;

import solid.Control.MainController;

/**
 *
 * @author marcj_000
 */
public class Reset {
    
    public void resetDictionary(){
    
        Load loader = new Load();

        MainController.collection = loader.LoadWords("src/solid/files/OriginalDictionary.txt");
    
        Save saver = new Save("src/solid/files/Dictionary.txt");
        
    }
    
}
