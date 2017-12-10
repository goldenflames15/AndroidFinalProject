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

    private sentance chosenSentence;
    private String correct;

    private String assignedPos[] =
            {
                    "adjective",
                    "adverb",
                    "conjunction",
                    "interjection",
                    "noun",
                    "preposition",
                    "pronoun",
                    "contraction",
                    "definite article"
            };

    private String[] sen1 = {"The", " sky", " is", " blue,", " and", " a", " cloud", " is", " fluffy."};
    private String[] pos1 = {"definite article", "noun", "verb", "adjective", "conjunction", "definite article", "noun, verb, adjective"};

        //System.out.println("sen1");

    //private String[] sen2 = {"Go", " to", " the", " last", " building", " on", " the", " left."};
    //private String[] pos2 = {"verb", "preposition", "adverb", "adjective", "noun", "preposition", "adverb", "noun"};

        //System.out.println("sen2");

    //private String[] sen3 = {"Let's", " go", " to", " the", " moon!"};
   // private String[] pos3 = {"contraction", "verb", "preposition", "adverb", "noun"};

        //System.out.println("sen3");

    //private String[] sen4 = {"You", " must", " construct", " additional", "pylons."};
    //private String[] pos4 = {"noun", "verb", "verb", "adjective", "noun"};

        //System.out.println("sen4");

    //private String[] sen5 = {"I", " am", " the", " very", " model", " of", " a", " modern", " major", "general!"};
    //private String[] pos5 = {"noun", "verb", "adverb", "adjective", "noun", "preposition", "adjective", "noun"};

        //System.out.println("sen5");


    //sentences = new sentance[5];
    private sentance sentance1 = new sentance(sen1,pos1);
    //private sentance sentance2= new sentance(sen2,pos2);
    //private sentance sentance3= new sentance(sen3,pos3);
    //private sentance sentance4= new sentance(sen4,pos4);
   // private sentance sentance5= new sentance(sen5,pos5);
   private sentance[] sentences = new sentance[5];

    private int attempts = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sentences[0] = sentance1;
        //sentences[1] = sentance2;
        //sentences[2] = sentance3;
        //sentences[3] = sentance4;
        //sentences[4] = sentance5;

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


        System.out.println("Array made");

        ng.setEnabled(false);

        setsBoard.setBoard();

        System.out.println("board made");



        View.OnClickListener click = new View.OnClickListener()
        { //when any of the 4 main buttons are pressed
            @Override
            public void onClick(View v) {

                Button b = (Button) v; //b is the answer the player selected
                String word = "";
                word = b.getText().toString();
                
                if (chosenSentence.checkPos(correct, b.getText().toString())) { //**this line is causing an error
                    attempts = 0;
                    b.setBackgroundColor(Color.GREEN); //sets the button they pressed to green
                    cc.setBackgroundColor(Color.GREEN);
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
                        cc.setBackgroundColor(Color.GREEN);
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
                //Needs to make this reset the board correctly when they pick playAgain
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

            t1.setText(""); //**This is how you alter the text in the sentence textview
            b1.setText(""); //To set the answers b1-b4
            b2.setText("");
            b3.setText("");
            b4.setText("");

            sentance chosenSentence = sentences[(int)Math.floor(Math.random()*5)];
            //chosenSentence = sentences[0];

            Collections.shuffle(Arrays.asList(assignedPos));

            String temp[] = assignedPos;
            
            System.out.print(chosenSentence.fullSentence(chosenSentence.getFull(chosenSentence)));
            int indexChosen = (int)Math.floor(Math.random()*(chosenSentence.getFull(chosenSentence).length));
            System.out.print("index chosen= " +indexChosen);

            t1.setText(sentance.fullSentence(chosenSentence.getFull(chosenSentence))); //displays the sentence to the user
            t2.setText(chosenSentence.getFull(chosenSentence)[indexChosen]); //displays the word to the user

            String POS[] = new String[4];

            POS[0] = "";
            POS[1] = "";
            POS[2] = "";
            POS[3] = "";

            POS[0] = chosenSentence.getPOS(chosenSentence)[indexChosen];//sets the correct POS in the POS array
            correct = POS[0];
            System.out.print("part of speech chosen= " +POS[0]);

            Collections.shuffle(Arrays.asList(temp));

            POS[1] = temp[0];
            POS[2] = temp[1];
            POS[3] = temp[2];

            if (temp[0].equals(POS[0]) || temp[1].equals(POS[0]) || temp[2].equals(POS[0]))
            {
                while (temp[0].equals(POS[0]) || temp[1].equals(POS[0]) || temp[2].equals(POS[0]))
                {
                    Collections.shuffle(Arrays.asList(temp));
                    POS[1] = temp[0];
                    POS[2] = temp[1];
                    POS[3] = temp[2];
                }
            }

            Collections.shuffle(Arrays.asList(POS));

            b1.setText(POS[0]); //To set the answers b1-b4
            b2.setText(POS[1]);
            b3.setText(POS[2]);
            b4.setText(POS[3]);
            b1.setBackgroundColor(0xFFbe56ff);
           // b1.setBackgroundColor(0xbe56ff); //Sets the background colors back
            b2.setBackgroundColor(0xFFba4590);
            b3.setBackgroundColor(0xFF56ebff);
            b4.setBackgroundColor(0xFFffad56);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);

            ng.setEnabled(false);
            ng.setBackgroundColor(Color.RED);
            cc.setBackgroundColor(Color.RED);
        }
    }
}
