package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/17/2017.
 *
 *
 */

public class sentance {
    private static String[][] sentence ;

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
}
