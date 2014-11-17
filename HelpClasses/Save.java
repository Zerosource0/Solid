/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.HelpClasses;

import solid.Control.MainController;

import java.util.ArrayList;
/**
 *
 * @author marcj_000
 */
public class Save {
    
    public Save(String filePath){
        
        //FileHandler fileHandler = new FileHandler();
        
        ArrayList<String> wordsForSaving = new ArrayList<String>();
        
        for (int i = 0; i < MainController.collection.size(); i++){
        
            wordsForSaving.add(MainController.collection.get(i).formatForSaving());
            
        }
        FileHandler.save(wordsForSaving, filePath);
        
    }
    
}
