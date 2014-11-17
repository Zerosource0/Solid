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
public class Probability {
    
    public static void increaseProbability(String question){
    
        for(int i = 0; i < MainController.collection.size(); i++){
            if(MainController.collection.get(i).getEnglish().equals(question)) {
                if(MainController.collection.get(i).getProbability() <= 8){
                    MainController.collection.get(i).setProbability(MainController.collection.get(i).getProbability() + 2);
                }
            }
        }
        
    }
    
    public static void decreaseProbability(String question){
        
        for(int i = 0; i < MainController.collection.size(); i++){
            if(MainController.collection.get(i).getEnglish().equals(question)) {
                if(MainController.collection.get(i).getProbability() >= 2){
                    MainController.collection.get(i).setProbability(MainController.collection.get(i).getProbability() - 2);
                }
            }
        }
        
    }
    
}
