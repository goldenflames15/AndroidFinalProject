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

    private quiz game;
    private sentance[] sentences;

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
/*
        buttonHandler bh = new buttonHandler( );

        b1 = (Button) findViewById(R.id.b1); //These need to be new buttons we don't have yet
        b2 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(myhandler1);
        b2.setOnClickListener(myhandler2);
*/

    public void showNewGameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Would you like to keep going?");
        PlayDialog playAgain = new PlayDialog();
        alert.setPositiveButton("YES", playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
    }
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


}
