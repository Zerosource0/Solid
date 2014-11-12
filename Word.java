/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

/**
 *
 * @author marcj_000
 */
public class Word {
    String english;
    String czech;
    int probability;
    
    public Word(String eng, String cze, int prob){
        english = eng;
        czech = cze;
        probability = prob;
    }
    
    public Word(String loadedString){
    
        String[] parts = loadedString.split(",");
        english = parts[0];
        czech = parts[1];
        probability = Integer.parseInt(parts[2]);
    }
    
    public String formatForSaving(){
    
        String formattedString = english + "," + czech + "," + probability;
        return formattedString;
    }
    
}
