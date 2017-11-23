package edu.clarkson.ee408.androidfinalproject;


import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/* https://nlp.stanford.edu/software/tagger.shtml#Download */
//This is the Stanford parts of speech link

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] sentence1 = {"The", " sky", " is", " blue,", " and", " the", " grass", " is", " green."};
        String[] sentence2 = {"Go", " to", " the", " last", " building", " on", " the", " left."};
        String[] sentence3 = {"Let's", " go", " to", " the", " moon!"};
        String[] sentence4 = {"You", " must", " construct", " additional", " pylons."};
        String[] sentence5 = {"I", " am", " the", " very", " model", " of", " a", " modern", " major", " general!"};

        String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun"};

    }

    /*
    * page()
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

    /*void onClick(){
        if(sentences.checkPos(word, button.getText().toString()))
        {
            setButtonColor(Color green);
            playsound, ding
        }

        else
        {
            setButtonColor(Color red);
            playsound buzzer
        }

        transition (right to left if wrong, left to right if correct);
    }*/
}
