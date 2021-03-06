/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.Control;

import solid.HelpClasses.Load;
import solid.HelpClasses.Probability;
import solid.HelpClasses.Save;
import solid.HelpClasses.Search;
import solid.Word;

import java.util.ArrayList;

/**
 *
 * @author marcj_000
 */

public class MainController implements solid.Interface.WordPairControlInterface {
    public static ArrayList<Word> collection = new ArrayList<Word>();
    public static String filePath = "src/solid/files/Dictionary.txt";
    
    @Override
    public void add(String question, String answer) {
        //Pre: Post: A new word pair is added to the existing collection of word
        //pairs. This method does not save to file!

        Word tempWord = new Word(question + "," + answer + ",10");
        collection.add(tempWord);
    }

    @Override
    public int size() {
       //Pre: Post: Returns the number of wordpairs in the collection (not the file).
        return collection.size();
    }

    @Override
    public String getRandomQuestion() {
       //Pre: At least one word pair must be present Post: Returns a question
       //randomly selected from the collection of word pairs.
        Search searcher = new Search();
        return searcher.getRandomQuestion();
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        //Pre: Post: Returns true if (question, quess) exists as a word pair in the
        //collection, otherwise false.

        Search searcher = new Search();
        if(searcher.SearchFor(question).equals(quess))
        {
            System.out.println("guessed right");
            Probability.decreaseProbability(question);
            return true;
        }
        System.out.println("guessed wrong");
        Probability.increaseProbability(question);
        return false;
    }

    @Override
    public String lookup(String question) {
        //Returns the answer corresponding to the question if this
        //exists in the collection. Otherwise it returns null.
        
        Search searcher = new Search();
        
        String searchedWord;
        
        searchedWord = searcher.SearchFor(question);
        
        if(searchedWord == null){
            System.out.println("Word does not exist in collection");
            return null;
        }
        System.out.println(searchedWord);
        return searchedWord;
    }

    @Override
    public boolean load(String filename) {
        //Word pairs are read from the file "filename" and added to the
        //collection of word pairs. Returns true if successfully done. Otherwise it
        //returns false.
        
        Load loader = new Load();
        collection = loader.LoadWords(filename);
        if (collection == null){
            System.out.println("File didn't load!");
            return false;
        }
        

        //System.out.println(MainClass.collection.get(0).formatForSaving());
        return true;
    }

    @Override
    public boolean save(String filename) {
        //Pre: Post: All word pairs from the collection has been written to the
        //file "filename" Returns true if successfully done. Otherwise false.
        try{
        Save saver = new Save(filename);
        } catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        //Pre: Post: The existing collection of word pairs is cleared
        collection.clear();
        
    }
    
}
