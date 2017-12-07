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

    //I want to set the blank box to red/green and also say correct or not
    //Add sounds??
    //private quiz game;
    private sentance[] sentences;
    private Button b1, b2, b3, b4, ng;
    private TextView t1, cc, t2;
    private String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "contraction"};;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //game = new quiz();

        //Declaring buttons and textviews
        b1 = (Button) findViewById(R.id.Button1);
        b2 = (Button) findViewById(R.id.Button2);
        b3 = (Button) findViewById(R.id.Button3);
        b4 = (Button) findViewById(R.id.Button4);
        ng = (Button) findViewById(R.id.newGame);
        t1= (TextView) findViewById(R.id.sentence);
        cc= (TextView) findViewById(R.id.colorChange);
        t2= (TextView) findViewById(R.id.word);

        String[] sen0 ={"This", "is", "a", "sentence."};
        String[] pos0 ={"adverb", "verb", "preposition", "noun"};

        String[] sen1 = {"The", " sky", " is", " blue,", " and", " the", " grass", " is", " green."};
        String[] pos1 = {"adverb", "noun", "verb", "adjective", "conjunction", "adverb", "adjective"};

        String[] sen2 = {"Go", " to", " the", " last", " building", " on", " the", " left."};
        String[] pos2 = {"verb", "preposition", "adverb", "adjective", "noun", "preposition", "adverb", "noun"};

        String[] sen3 = {"Let's", " go", " to", " the", " moon!"};
        String[] pos3 = {"contraction", "verb", "preposition", "adverb", "noun"};

        String[] sen4 = {"You", " must", " construct", " additional", " pylons."};
        String[] pos4 = {"noun", "verb", "verb", "adjective", "noun"};

        String[] sen5 = {"I", " am", " the", " very", " model", " of", " a", " modern", " major", " general!"};
        String[] pos5 = {"noun", "verb", "adverb", "adjective", "noun", "preposition", "adjective", "adjective", "noun"};

        sentences = new sentance[]
                {
                        new sentance(sen0, pos0),
                        new sentance(sen1, pos1),
                        new sentance(sen2, pos2),
                        new sentance(sen3, pos3),
                        new sentance(sen4, pos4),
                        new sentance(sen5, pos5)
                };
        //boardSetter.setBoard();
        sentance chosenSentence = sentences[(int)Math.floor(Math.random()*5)];
        String chosenWord = sentance.getWord(chosenSentence.words);
        String chosenPart =sentance.getWordsPart(chosenSentence.words, chosenSentence.parts, chosenWord);
        t1.setText(sentance.fullSentence(chosenSentence.words));
        t2.setText(chosenWord);
        //pick a random button, and assign a random word
        //I don't know how to pick random parts and assign them to random buttons without repeating parts....
        //Trying to make an array of 4 numbers non-repeating to assign random parts to and then change the buttons to those?


        ng.setBackgroundColor(Color.RED);
        ng.setEnabled(false);


        View.OnClickListener click = new View.OnClickListener()
        { //when any of the 4 main buttons are pressed
            @Override
            public void onClick(View v) {
                Button b = (Button) v; //b is the answer the player selected
                String playerPart = b.getText().toString();
                String correctPart = t2.getText().toString();

                //if (sentences.alertPlayer("", "") == 0) {
                if(playerPart.equals(correctPart)) { //if word is correct
                    b.setBackgroundColor(Color.GREEN); //sets the button they pressed to green
                    ng.setBackgroundColor(Color.GREEN); //sets the playAgain button to green, to show it's activated again
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    ng.setEnabled(true); //activates the playAgain button
                }
                else /* if (!pickedWord.equals(correctWord)) {
                        b.setBackgroundColor(Color.RED); //indicates wrong choice
                        b.setEnabled(false); //disables wrong choice
                        //change cc
                    } else */ { //their last chance
                    b.setBackgroundColor(Color.RED);
                    ng.setBackgroundColor(Color.GREEN); //activates new game
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    ng.setEnabled(true);
                }
            }
        };

        View.OnClickListener playAgain = new View.OnClickListener()
        { //below will be what happens when play again button is pressed
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                //When they push the play again button, this is where the stuff needs to be executed
                sentance chosenSentence = sentences[(int)Math.floor(Math.random()*5)];
                String chosenWord = sentance.getWord(chosenSentence.words);
                String chosenPart ="";
                t1.setText(sentance.fullSentence(chosenSentence.words));
                t2.setText(chosenWord);

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

        b1.setText(""); //To set the answers b1-b4
        b2.setText("");
        b3.setText("");
        b4.setText("");
    }

/*
    private class boardSetter{
        public void setBoard(){
            //sentance display = sentences[(int)Math.floor(Math.random()*4)]; //picks a random sentence
            t1.setText(""); //**This is how you alter the text in the sentence textview
            b1.setText(""); //To set the answers b1-b4
            b2.setText("");
            b3.setText("");
            b4.setText("");

            sentance chosenSentence = sentences[(int)Math.floor(Math.random()*5)];
            String chosenWord = sentance.getWord(chosenSentence.words);
            String chosenPart ="";
            t1.setText(sentance.fullSentence(chosenSentence.words));
            t2.setText(chosenWord);










        }


    }
    */
}

/* int checker = 0;
            int assigned = -1;
            String picker = " ";
            String POS[] = new String[];
            POS[0] = display[1][(game.pickWord(display))) + 0;

            while (assigned <= 3)
            {
                picker = assigned[(int)Math.floor(Math.random()*(assignedpos.length()-1)) + 0
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
            }*/