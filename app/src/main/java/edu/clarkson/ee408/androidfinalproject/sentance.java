package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/17/2017.
 *
 *
 */

public class sentance {
    static int MAX_SENTENCE_SIZE = 10;
    private static String[] words = new String[MAX_SENTENCE_SIZE];
    private static String[] parts = new String[MAX_SENTENCE_SIZE];
//private static String[] words;
//private static String[] parts;

    sentance(String[] newWords, String[] newParts){
        System.out.println("function called");
        int length = newParts.length;
        for (int i=0; i<length-1; i++) {
            words[i]=newWords[i];
            System.out.println("word added");
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

        public static String fullSentence(String[] sen)
        {
            String full = "";
            StringBuilder build;

            for (int i = 0; i < sen.length-1; i++)
            {
                if(i < sen.length)
                {

                    full= full + (sen[i] + " "); //use StringBuilder.append ??? using += appends the entire thing onto the end again apparently
                    //+= and + copy the entire thing onto the end EVERY TIME
                    //THIS NEEDS TO BE FIXED
                    //I DON'T GET IT
                }

                else
                {
                    full= full + sen[i];
                }

            }
            return full;
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
