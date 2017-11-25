package edu.clarkson.ee408.androidfinalproject;

/**
 * Created by Rancerle on 11/25/2017.
 */

public class quiz
{
     /*
    * createPage()
    * {
    *   int index = rand() sen.length() - 1;
    *
    *   textview.highlight(sen[0][index]);
    *   while(find == 0)
    *   {
    *       for(int j = 0; j < 3; j++)
    *       {
    *           if(assignedPos[rand() assignedPos.length() - 1] == button[j].getText().toString())
    *               find
    *       }
    *   }
    * }
    * */

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
