package edu.clarkson.ee408.androidfinalproject;

import java.util.Random;

/**
 * Created by Rancerle on 11/25/2017.
 */

public class quiz
{

     int pickWord(String sen)
     {
         return Random.nextInt((sen.length() - 1) - 0 + 1) + 0;
     }


    int alertPlayer(String Pos1, String Pos2)
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
