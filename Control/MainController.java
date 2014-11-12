/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author marcj_000
 */
public class MainController implements Interface.WordPairControlInterface {

    
    @Override
    public void add(String question, String answer) {
        //Pre: Post: A new word pair is added to the existing collection of word
        //pairs. This method does not save to file!
       
    }

    @Override
    public int size() {
       //Pre: Post: Returns the number of wordpairs in the collection (not the file).
        
        return 0;
    }

    @Override
    public String getRandomQuestion() {
       //Pre: At least one word pair must be present Post: Returns a question
       //randomly selected from the collection of word pairs.
        
        return null;
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        //Pre: Post: Returns true if (question, quess) exists as a word pair in the
        //collection, otherwise false.
        
        return false;
    }

    @Override
    public String lookup(String question) {
        //Returns the answer corresponding to the question if this
        //exists in the collection. Otherwise it returns null.
        
        return null;
    }

    @Override
    public boolean load(String filename) {
        //Word pairs are read from the file "filename" and added to the
        //collection of word pairs. Returns true if successfully done. Otherwise it
        //returns false.
        return false;
    }

    @Override
    public boolean save(String filename) {
        //Pre: Post: All word pairs from the collection has been written to the
        //file "filename" Returns true if successfully done. Otherwise false.
        return false;
    }

    @Override
    public void clear() {
        //Pre: Post: The existing collection of word pairs is cleared
        
        
    }
    
}
