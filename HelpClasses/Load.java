/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.HelpClasses;

import java.io.File;
import java.util.ArrayList;
import solid.HelpClasses.FileHandler;
import solid.Word;
/**
 *
 * @author marcj_000
 */
public class Load {
    
    public ArrayList<Word> LoadWords(String filePath){
        
        
        ArrayList<Word> wordsToReturn = new ArrayList<Word>();
        ArrayList<String> loadedText = new ArrayList<String>();
        
        loadedText = FileHandler.load(filePath);
        
        if(loadedText != null)
            {
            for (String word : loadedText){
                Word tempWord = new Word(word);
                wordsToReturn.add(tempWord);
            }
        } 
        else
        {
            return null;
        }
        return wordsToReturn;
    }
}
