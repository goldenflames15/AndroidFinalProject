package edu.clarkson.ee408.androidfinalproject;

import java.util.Random;
import java.lang.Math;

/**
 * Created by Rancerle on 11/25/2017.
 */

public class quiz
{

    public quiz(){};

    public int pickWord(String sen)
     {
         int min = 0;
         int max = sen.length();
         return (int)Math.floor(Math.random()*max) + min;
     }


    public int alertPlayer(String Pos1, String Pos2)
    {

        if(sentance.checkPos(Pos1, Pos2))
        {
            return 0;
        }

        else
        {
            return 1;
        }
    }
}
