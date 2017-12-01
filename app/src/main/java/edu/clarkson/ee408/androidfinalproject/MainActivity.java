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

/* https://nlp.stanford.edu/software/tagger.shtml#Download */
//This is the website for parts of speech extension

public class MainActivity extends AppCompatActivity {

    private quiz game;
    private sentance[] sentences;
    private Button b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new quiz();

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

        sentences = new sentance[]{new sentance(sen1, pos1),
                new sentance(sen2, pos2),
                new sentance(sen3, pos3),
                new sentance(sen4, pos4),
                new sentance(sen5, pos5)};

        String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "contraction"};

        //buttonHandler bh = new buttonHandler();
        View.OnClickListener click = new View.OnClickListener() { //when any of the 4 main buttons are pressed
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String word = "";
                //word =b.getText().toString();
                b.setText(""); // This will be where their choice is sent (ie. which button they pushed
            }
        };

        View.OnClickListener playAgain = new View.OnClickListener() { //below will be what happens when play again button is pressed
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                //When they push the play again button, this is where the stuff needs to be executed
            }
        };

        //Declaring buttons
        b1 = (Button) findViewById(R.id.Button1);
        b2 = (Button) findViewById(R.id.Button2);
        b3 = (Button) findViewById(R.id.Button3);
        b4 = (Button) findViewById(R.id.Button4);
        b5 = (Button) findViewById(R.id.Button5); //WHY CAN'T IT FIND BUTTON5 WTF

        //These make things happen when the buttons are pressed, functions and such
        b1.setOnClickListener(click);
        b2.setOnClickListener(click);
        b3.setOnClickListener(click);
        b4.setOnClickListener(click);
        b5.setOnClickListener(playAgain);
    }
}
/*
    public void showNewGameDialog() {                                //If you make PlayDialog a new class then this would go in that
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Would you like to keep going?");
        PlayDialog playAgain = new PlayDialog();
        alert.setPositiveButton("YES", playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
    }


   /* public class buttonHandler implements View.OnClickListener { //It says this should be in it's own java file since it's a class, just use functions there's no reason for extra classes
        public void onClick( View v ) {

        }

        public class PlayDialog implements DialogInterface.OnClickListener {
            public void onClick( DialogInterface dialog, int id ) {
                if( id == -1 )
                {
                    game.resetGame( ); //game isn't in this class so can't use it like this
                    bh.enableButtons( true );
                    bh.resetButtons( );
                    bh.setStatusBackgroundColor( Color.GREEN );
                    bh.setStatusText( game.result( ) );
                }

                else if( id == -2 )
                {
                    MainActivity.this.finish();
                }
            }
        }

*/

