package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/17/2017.
 *
 * Sentences:
 *
 * S1: 
 * P1:
 *
 * S2:
 * P2:
 *
 * S3:
 * P3:
 *
 * S4:
 * P4:
 *
 * S5:
 * P5:
 *
 *
 */

public class sentance {
    private static String[][] sentence ;

    sentance (String[] words, String[] pos)
    {
        sentence[0] = words;
        sentence[1] = pos;
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
