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


/*
    sentance (String[] words, String[] pos)
    {
        for (int i = 0; i < words.length; i++)
        {
            sentence[0][i] = words[i];
        }

        for (int i = 0; i < pos.length; i++)
        {
            sentence[1][i] = pos[i];
        }
    }

    public String getSen()
    {
        String full = "";

        for (int i = 0; i < sentence[0].length; i++)
        {
            if(i < sentence[0].length)
            {
                full+= sentence[0][i] + " ";
            }

            else
            {
                full+= sentence[0][i];
            }

        }
        return full;
    }


/*
    public int pickWordPos(String[] sen) //Does this need to be sen[]
    {

        return ;
    }


/*
    public int alertPlayer(String Pos1, String Pos2)
    {

        if(checkPos(Pos1, Pos2))
        {
            return 0;
        }

        else
        {
            return 1;
        }
    }

    public static boolean checkPos(String word, String part)
    {
        int index = 0;

        for (int i = 0; i < sentence[0].length; i++)
        {
            if(sentence[0][i] == word)
            {
                index = i;
                break;
            }
        }

        return part == sentence[1][index];
    }
    */
}
