package edu.clarkson.ee408.androidfinalproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* https://nlp.stanford.edu/software/tagger.shtml#Download */
//This is the Stanford parts of speech link

public class MainActivity extends AppCompatActivity {

    private quiz game;
    private sentance[] sentences;
    private boardSetter setsBoard;
    private Button b1, b2, b3, b4, ng;
    private TextView t1, cc, t2;
    private String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "contraction"};;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new quiz();
        setsBoard= new boardSetter();
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

        System.out.println("sen1");

        String[] sen2 = {"Go", " to", " the", " last", " building", " on", " the", " left."};
        String[] pos2 = {"verb", "preposition", "adverb", "adjective", "noun", "preposition", "adverb", "noun"};

        System.out.println("sen2");

        String[] sen3 = {"Let's", " go", " to", " the", " moon!"};
        String[] pos3 = {"contraction", "verb", "preposition", "adverb", "noun"};

        System.out.println("sen3");

        String[] sen4 = {"You", " must", " construct", " additional", " pylons."};
        String[] pos4 = {"noun", "verb", "verb", "adjective", "noun"};

        System.out.println("sen4");

        String[] sen5 = {"I", " am", " the", " very", " model", " of", " a", " modern", " major-general!"};
        String[] pos5 = {"noun", "verb", "adverb", "adjective", "noun", "preposition", "noun", "adjective", "noun"};

        System.out.println("sen5");

        sentences = new sentance[]
                {
                        new sentance(sen1, pos1),
                        new sentance(sen2, pos2),
                        new sentance(sen3, pos3),
                        new sentance(sen4, pos4),
                        new sentance(sen5, pos5)
                };

        System.out.println("Array made");

        setsBoard.setBoard();

        System.out.println("board made");

        View.OnClickListener click = new View.OnClickListener()
        { //when any of the 4 main buttons are pressed
            @Override
            public void onClick(View v) {
                int attempts = 0;
                Button b = (Button) v; //b is the answer the player selected
                String word = "";
                word = b.getText().toString();
                String correct = t2.getText().toString();

                if (game.alertPlayer( word, correct) == 0) {
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
                    if (attempts == 0) { //this will always be 0, turns broken, needs to be fixed
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
                setsBoard.setBoard();
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
        public  void setBoard(){ //This has to be called before anything else happens or else we have to set the text empty and then set the board
            //otherwise it doesn't start the game correctly
            sentance display = sentences[(int)Math.floor(Math.random()*4)];
            t1.setText(""); //**This is how you alter the text in the sentence textview
            t1.setText(display.fullSentence(display.getFull(display)));
            b1.setText(""); //To set the answers b1-b4
            b2.setText(""); //To set the answers b1-b4
            b3.setText(""); //To set the answers b1-b4
            b4.setText(""); //To set the answers b1-b4

            int checker = 0;
            int assigned = 1;
            //int indexChosen = (int)Math.floor(Math.random()*(display.getFull(display).length));
            String picker = " ";
            //String POS[] = new String[4];
            String POS[] = {"", "", "", ""};
            String chosenWord = display.getWord(display.getFull(display)); //chooses a word
            POS[0] = display.getWordsPart(display.getPOS(display), display.getFull(display),chosenWord); //puts the correct answer in the first slot
            //t2.setText(display.getPOS(display)[indexChosen]);
            t2.setText(chosenWord);
            while (assigned <= 3) //initialises the array of parts of speach with the three randos
            {
                picker = assignedPos[(int)Math.floor(Math.random()*(8))];
                if(!POS[0].equals(picker)) //only allows a POS to be assigned if it has not been already
                    checker++;
                if(!POS[1].equals(picker))
                    checker++;
                if(!POS[2].equals(picker))
                    checker++;
                if(!POS[3].equals(picker))
                    checker++;
                if(checker == 4 ) {
                    POS[assigned] = picker;
                    checker = 0;
                    assigned++;
                }
            }
            assigned = 0;

            while (assigned < 1)
            {
                picker = POS[(int)Math.floor(Math.random()*4)];
                if(!b1.getText().toString().equals(picker)) //only allows the POS to be assigned from the array if it hasn't already
                    checker++;
                if(!b2.getText().toString().equals(picker))
                    checker++;
                if(!b3.getText().toString().equals(picker))
                    checker++;
                if(!b4.getText().toString().equals(picker))
                    checker++;
                if(checker == 4 )
                {
                    b1.setText(picker);
                    b1.setEnabled(true);
                    checker = 0;
                    assigned++;
                }
            }

            while (assigned < 2)
            {
                picker = POS[(int)Math.floor(Math.random()*4)];
                if(!b1.getText().toString().equals(picker))
                    checker++;
                if(!b2.getText().toString().equals(picker))
                    checker++;
                if(!b3.getText().toString().equals(picker))
                    checker++;
                if(!b4.getText().toString().equals(picker))
                    checker++;
                if(checker == 4 )
                {
                    b2.setText(picker);
                    b2.setEnabled(true);
                    checker = 0;
                    assigned++;
                }
            }

            while (assigned < 3)
            {
                picker = POS[(int)Math.floor(Math.random()*4)];
                if(!b1.getText().toString().equals(picker))
                    checker++;
                if(!b2.getText().toString().equals(picker))
                    checker++;
                if(!b3.getText().toString().equals(picker))
                    checker++;
                if(!b4.getText().toString().equals(picker))
                    checker++;
                if(checker == 4 )
                {
                    b3.setText(picker);
                    b3.setEnabled(true);
                    checker = 0;
                    assigned++;
                }
            }

            while (assigned < 4)
            {
                picker = POS[(int)Math.floor(Math.random()*4)];
                if(!b1.getText().toString().equals(picker))
                    checker++;
                if(!b2.getText().toString().equals(picker))
                    checker++;
                if(!b3.getText().toString().equals(picker))
                    checker++;
                if(!b4.getText().toString().equals(picker))
                    checker++;
                if(checker == 4 )
                {
                    b4.setText(picker);
                    b4.setEnabled(true);
                    checker = 0;
                    assigned++;
                }
            }
        }
    }
}