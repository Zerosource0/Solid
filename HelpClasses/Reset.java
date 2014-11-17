/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.HelpClasses;

import java.util.ArrayList;
import solid.HelpClasses.Load;
import solid.MainClass;
import solid.Word;

/**
 *
 * @author marcj_000
 */
public class Reset {
    
    public void resetDictionary(){
    
        Load loader = new Load();
        
        MainClass.collection = loader.LoadWords("src/solid/files/OriginalDictionary.txt");
    
        Save saver = new Save("src/solid/files/Dictionary.txt");
        
    }
    
}
