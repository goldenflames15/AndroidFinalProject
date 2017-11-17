package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/17/2017.
 */

public class sentance {
    private String[][] sentence ;

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
}
