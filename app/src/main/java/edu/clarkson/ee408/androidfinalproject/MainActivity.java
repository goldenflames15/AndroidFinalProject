package edu.clarkson.ee408.androidfinalproject;


import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import java.util.Random;
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
        quiz game = new quiz();

        String[] sen1 = {"The", " sky", " is", " blue,", " and", " the", " grass", " is", " green."};
        String[] pos1 = {"adverb", "noun", "verb", "adjective", "conjunction", "adverb", "adjective"};
        String[] sen2 = {"Go", " to", " the", " last", " building", " on", " the", " left."};
        String[] pos2 = {"verb", "preposition", "adverb", "adjective", "noun", "preposition", "adverb", "noun"};
        String[] sen3 = {"Let's", " go", " to", " the", " moon!"};
        String[] pos3 = {"contraction", "verb", "preposition", "adverb", "noun"};
        String[] sen4 = {"You", " must", " construct", " additional", " pylons."};
        String[] pos4 = {"noun", "verb", "verb", "adjective", "noun"};
        String[] sen5 = {"I", " am", " the", " very", " model", " of", " a", " modern", " major", " general!"};
        String[] pos5 = {"noun", "verb", "adverb", "adjective", "noun", "preposition", "noun", "adjective", "noun"};

        sentance[] sentences;
        sentences = new sentance[]{new sentance(sen1,pos1),
                                   new sentance(sen2, pos2),
                                   new sentance(sen3, pos3),
                                   new sentance(sen4, pos4),
                                   new sentance(sen5, pos5)};

        String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "contraction", "none of the above"};

    }


}
