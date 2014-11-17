/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.HelpClasses;

import solid.Control.MainController;

import java.util.Random;

/**
 *
 * @author marcj_000
 */
public class Search {
    
    public String getRandomQuestion(){
        boolean wordPassed = false;
        String englishWord = "";
        int iterations = 0;
        int adjustedRandom = 0;

        // Generate random number in range of amount of words
        Random rand = new Random();
        int randomNum = rand.nextInt(MainController.collection.size());

        do {
            // adjusterRandom points at next words, if previous didn't pass probability test
            adjustedRandom = randomNum+iterations;
            // adjustedRandom resets if it reaches collection size
            if(adjustedRandom >= MainController.collection.size()) {
                adjustedRandom = 0;
            }

            // probability of individual words can reach max of 10, as words can reach max 10 too.
            int randomProbability = rand.nextInt(10);

            /* IF random probability is less than word's probability, test is successful. If not "do" method will try to run
            probability test on next word. */
            if(randomProbability < MainController.collection.get(adjustedRandom).getProbability()) {

                System.out.println(MainController.collection.get(adjustedRandom).getEnglish() +
                " passed!. (Probability of " + MainController.collection.get(adjustedRandom).getProbability() + ")");
                englishWord = MainController.collection.get(adjustedRandom).getEnglish();
                wordPassed = true;
            } else {
                iterations++;
                System.out.println(MainController.collection.get(adjustedRandom).getEnglish() +
                " didn't passed!. (Probability of " + MainController.collection.get(adjustedRandom).getProbability() + ")");
            }

        } while (wordPassed == false);

        return  englishWord;
    }
    
    
    public String SearchFor (String question){
        
        
        for (int i = 0; i < MainController.collection.size(); i++){
            
            if(MainController.collection.get(i).getEnglish().equals(question))
            {
                return MainController.collection.get(i).getCzech();
            }
        }
        return null;
    }

}
