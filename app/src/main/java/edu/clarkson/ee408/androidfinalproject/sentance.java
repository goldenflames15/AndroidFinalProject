package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/17/2017.
 *
 *
 */

public class sentance {
    public static String[] words ;
    public static String[] parts;


    sentance(String[] words, String[] parts){
        for (int i=0; i<=words.length; i++) {
            words[i]=words[i];
            parts[i]=parts[i];
        }
    }

    public static String[] getFull(sentance sen){
        return sen.words;
    }

    public static String[] getPOS(sentance sen){
        return sen.parts;
    }

    public static String getWord(String[] sen) {
        String word = "";
        int min = 0;
        int max = sen[0].length();
        word = sen[(int) Math.floor(Math.random() * max) + min];
        return word;
    }

    public static String getWordsPart(String[] w, String[] p, String word){
        int index=0;
        for(int i=0; i<=w.length;i++)
        {
            if (w[i]==word)
            {
                index =i;
            }
        }
        return p[index];
    }

        public static String fullSentence(String[] sen)
        {
            String full = "";

            for (int i = 0; i < sen.length; i++)
            {
                if(i < sen.length)
                {
                    full+= sen[i] + " ";
                }

                else
                {
                    full+= sen[i];
                }

            }
            return full;
        }

    public static boolean checkPos(String word, String part)
    {
        int index = 0;

        for (int i = 0; i < words.length; i++)
        {
            if(words[i] == word)
            {
                index = i;
                break;
            }
        }

        return part == words[index];
    }
}
