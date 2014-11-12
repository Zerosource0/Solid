/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.HelpClasses;

import solid.MainClass;

/**
 *
 * @author marcj_000
 */
public class Probability {
    
    public static void increaseProbability(String question){
    
        for(int i = 0; i < MainClass.collection.size(); i++){
            if(MainClass.collection.get(i).getEnglish().equals(question)) {
                if(MainClass.collection.get(i).getProbability() <= 8){
                MainClass.collection.get(i).setProbability(MainClass.collection.get(i).getProbability() + 2);
                }
            }
        }
        
    }
    
    public static void decreaseProbability(String question){
        
        for(int i = 0; i < MainClass.collection.size(); i++){
            if(MainClass.collection.get(i).getEnglish().equals(question)) {
                if(MainClass.collection.get(i).getProbability() >= 2){
                MainClass.collection.get(i).setProbability(MainClass.collection.get(i).getProbability() - 2);
                }
            }
        }
        
    }
    
}
