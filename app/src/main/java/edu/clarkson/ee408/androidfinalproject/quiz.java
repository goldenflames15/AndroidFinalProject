package edu.clarkson.ee408.androidfinalproject;

import java.util.Random;
import java.lang.Math;

/**
 * Created by Rancerle on 11/25/2017.
 */

public class quiz
{

    public quiz(){};

    public int pickWord(sentance sen) //Does this need to be sen[]
     {
         int min = 0;
         int max = sen[0].length(); //Error????
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

    //resetGame function
    //result function
}
