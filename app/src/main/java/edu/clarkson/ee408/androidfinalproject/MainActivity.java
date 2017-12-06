package edu.clarkson.ee408.androidfinalproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* https://nlp.stanford.edu/software/tagger.shtml#Download */
//This is the Stanford parts of speech link

/* https://nlp.stanford.edu/software/tagger.shtml#Download */
//This is the website for parts of speech extension

public class MainActivity extends AppCompatActivity {

    private quiz game;
    private sentance[] sentences;
    private Button b1, b2, b3, b4, ng;
    private TextView t1, cc, t2;
    private String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "contraction"};;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        game = new quiz();

        //Declaring buttons
        b1 = (Button) findViewById(R.id.Button1);
        b2 = (Button) findViewById(R.id.Button2);
        b3 = (Button) findViewById(R.id.Button3);
        b4 = (Button) findViewById(R.id.Button4);
        ng = (Button) findViewById(R.id.newGame);
        t1= (TextView) findViewById(R.id.sentence);
        cc= (TextView) findViewById(R.id.colorChange);
        t2= (TextView) findViewById(R.id.word);

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

        sentences = new sentance[]
        {
                new sentance(sen1, pos1),
                new sentance(sen2, pos2),
                new sentance(sen3, pos3),
                new sentance(sen4, pos4),
                new sentance(sen5, pos5)
        };



        View.OnClickListener click = new View.OnClickListener()
        { //when any of the 4 main buttons are pressed
            @Override
            public void onClick(View v) {
                int attempts = 0;
                Button b = (Button) v; //b is the answer the player selected
                String word = "";
                word = b.getText().toString();

                if (game.alertPlayer("", "") == 0) {
                    attempts = 0;
                    b.setBackgroundColor(Color.GREEN); //sets the button they pressed to green
                    ng.setBackgroundColor(Color.GREEN); //sets the playAgain button to green, to show it's activated again
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    ng.setEnabled(true); //activates the playAgain button
                }

                else {
                    if (attempts == 0) {
                        attempts++;
                        b.setBackgroundColor(Color.RED);
                        b.setEnabled(false);
                    } else {
                        attempts = 0;
                        b.setBackgroundColor(Color.RED);
                        ng.setBackgroundColor(Color.GREEN);
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        ng.setEnabled(true);
                    }
                }
            }
        };

        View.OnClickListener playAgain = new View.OnClickListener()
        { //below will be what happens when play again button is pressed
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                //When they push the play again button, this is where the stuff needs to be executed


                ng.setBackgroundColor(Color.RED); //When they push the button,
                ng.setEnabled(false);
            }
        };


        //These make things happen when the buttons are pressed, functions and such
        b1.setOnClickListener(click);
        b2.setOnClickListener(click);
        b3.setOnClickListener(click);
        b4.setOnClickListener(click);
        ng.setOnClickListener(playAgain);
    }

    private class boardSetter{
        public void setBoard(){ //This has to be called before anything else happens or else we have to set the text empty and then set the board
            //otherwise it doesn't start the game correctly
            sentance display = sentences[(int)Math.floor(Math.random()*4) + 0];
            t1.setText(""); //**This is how you alter the text in the sentence textview
            //t1.setText(display.join());
            b1.setText(""); //To set the answers b1-b4


            //int checker = 0;
            //int assigned = 1;
            //String picker = " ";
            //String POS[] = new String[];
            //POS[0] = display[1][(game.pickWord(display))) + 0;
            /*
            while (assigned <= 3)
            {
                picker = assignedpos[(int)Math.floor(Math.random()*(assignedpos.length()-1)) + 0
                if(POS[0] != picker)
                    checker++;
                if(POS[1] != picker)
                    checker++;
                if(POS[2] != picker)
                    checker++;
                if(POS[3] != picker)
                    checker++;
                if(checker == 4 )
                    POS[assigned] = picker;
                    checker = 0;
                    assigned++;
            }

            while (assigned <= 3)
            {
                picker = POS[(int)Math.floor(Math.random()*3) + 0];
                if(b1.getText().toString() != assigned)
                    checker++;
                if(b2.getText().toString() != assigned)
                    checker++;
                if(b3.getText().toString() != assigned)
                    checker++;
                if(b4.getText().toString() != assigned)
                    checker++;
                if(checker == 4 )
                    b1[assigned] = picker;
                    checker = 0;
                    assigned++;
            }
            */
        }
    }
}
