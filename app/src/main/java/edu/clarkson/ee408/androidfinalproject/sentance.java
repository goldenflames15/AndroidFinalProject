package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/17/2017.
 *
 *
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class sentance {
    static int MAX_SENTENCE_SIZE = 10;
    private static String[] words = new String[MAX_SENTENCE_SIZE];
    private static String[] parts = new String[MAX_SENTENCE_SIZE];
//private static String[] words;
//private static String[] parts;

    sentance(String[] newWords, String[] newParts){
        System.out.println("function called");
        int length = newParts.length;
        for (int i=0; i<length; i++) {
            words[i]=newWords[i];
            System.out.println("word added: " + newWords[i]);
            parts[i]=newParts[i];
            System.out.println("POS added");
        }
        System.out.println("sentence added");
    }

    public static String[] getFull(sentance sen){
        return sen.words;
    } //This is named badly, it should be like getWordsArray, since fullSentence returns the actual sentence as one string

    public static String[] getPOS(sentance sen){
        return sen.parts;
    }

    /*
    public static String getWord(String[] sen) { //Chooses a random word
        String word = "";
        int min = 0;
        int max = sen.length;
        word = sen[(int) Math.floor(Math.random() * max) + min];
        return word;
    }

    public static String getWordsPart(String[] w, String[] p, String word){
        int index=0;
        for(int i=0; i<=w.length-1;i++)
        {
            if (word.equals(w[i]))
            {
                index =i;
            }
        }
        return p[index];
    }
*/
    public static String fullSentence(String[] sen)
        {
            return String.join(" ", sen);
        }

    public static boolean checkPos(String word, String part) //this doesn't work?
    {
        int index = 0;

        for (int i = 0; i < words.length; i++)
        {
            if(words[i].equals(word))
            {
                index = i;
                break;
            }
        }

        return part.equals(words[index]);
    }
}
