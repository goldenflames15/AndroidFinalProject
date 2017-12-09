package edu.clarkson.ee408.androidfinalproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;

/* https://nlp.stanford.edu/software/tagger.shtml#Download */
//This is the Stanford parts of speech link

public class MainActivity extends AppCompatActivity {

    private quiz game;

    private boardSetter setsBoard;
    private Button b1, b2, b3, b4, ng;
    private TextView t1, cc, t2;
    private String assignedPos[] = {"adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "contraction"};
    private int attempts = 0;
    
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
        String[] pos1 = {"adverb", "noun", "verb", "adjective", "conjunction", "adverb", "adjective, verb, adjective"};

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


        //sentences = new sentance[5];
        sentance sentance1 = new sentance(sen1,pos1);
        sentance sentance2= new sentance(sen2,pos2);
        sentance sentance3= new sentance(sen3,pos3);
        sentance sentance4= new sentance(sen4,pos4);
        sentance sentance5= new sentance(sen5,pos5);
        sentance[] sentences = {sentance1, sentance2, sentance3, sentance4, sentance5};

        System.out.println("Array made");

        setsBoard.setBoard();

        System.out.println("board made");



        View.OnClickListener click = new View.OnClickListener()
        { //when any of the 4 main buttons are pressed
            @Override
            public void onClick(View v) {

                Button b = (Button) v; //b is the answer the player selected
                String word = "";
                word = b.getText().toString();
                //need to check words part with their choices part
                String correct = t2.getText().toString();

                if (game.alertPlayer(word, correct) == 0) { //this isn't actually checking if they are right
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
           // sentance display = sentences[(int)Math.floor(Math.random()*4)]; //picks a random sentence
           // System.out.print(display.fullSentence(display));
            t1.setText(""); //**This is how you alter the text in the sentence textview
            b1.setText(""); //To set the answers b1-b4
            b2.setText("");
            b3.setText("");
            b4.setText("");

            //sentance chosenSentence = sentences[(int)Math.floor(Math.random()*5)];
            sentance chosenSentence = sentences[0];
            
            System.out.print(chosenSentence.fullSentence(chosenSentence.getFull(chosenSentence)));
            int indexChosen = (int)Math.floor(Math.random()*(chosenSentence.getFull(chosenSentence).length));

            // String chosenWord = sentance.getWord(chosenSentence.words);
            //String chosenPart ="";

           t1.setText(sentance.fullSentence(chosenSentence.getFull(chosenSentence))); //displays the sentence to the user
           t2.setText(chosenSentence.getFull(chosenSentence)[indexChosen]); //displays the word to the user

            int checker = 0;
            int assigned = -1;
            String picker = " ";
            String POS[] = new String[4];
            POS[0] = chosenSentence.getPOS(chosenSentence)[indexChosen]; //sets the correct POS in the POS array

            while(assignedPos[0].equals(POS[0]) || assignedPos[1].equals(POS[0]) || assignedPos[2].equals(POS[0]))
            {
                Collections.shuffle(Arrays.asList(assignedPos));
            }

            POS[1] = assignedPos[0];
            POS[2] = assignedPos[1];
            POS[3] = assignedPos[2];

            Collections.shuffle(Arrays.asList(POS));

            b1.setText(POS[0]); //To set the answers b1-b4
            b2.setText(POS[1]);
            b3.setText(POS[2]);
            b4.setText(POS[3]);
        }
    }
}
