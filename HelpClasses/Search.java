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
public class Search {
    
    public String SearchFor (String question){
        
        
        for (int i = 0; i < MainClass.collection.size(); i++){
            
            if(MainClass.collection.get(i).getEnglish().equals(question))
            {
                
                System.out.println("Yay");
                return MainClass.collection.get(i).getCzech();
            }
        }
        return null;
    }

}
