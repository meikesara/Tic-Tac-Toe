package com.example.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // Initialise variables
    Game game;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare variables
        game = new Game();
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textView = findViewById(R.id.Message);

        // If savedInstancestate is not empty get and set the text into the button
        if (savedInstanceState != null) {
            button1.setText(savedInstanceState.getString("button1"));
            button2.setText(savedInstanceState.getString("button2"));
            button3.setText(savedInstanceState.getString("button3"));
            button4.setText(savedInstanceState.getString("button4"));
            button5.setText(savedInstanceState.getString("button5"));
            button6.setText(savedInstanceState.getString("button6"));
            button7.setText(savedInstanceState.getString("button7"));
            button8.setText(savedInstanceState.getString("button8"));
            button9.setText(savedInstanceState.getString("button9"));
            textView.setText(savedInstanceState.getCharSequence("TextView"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("button1", button1.getText().toString());
        outState.putString("button2", button2.getText().toString());
        outState.putString("button3", button3.getText().toString());
        outState.putString("button4", button4.getText().toString());
        outState.putString("button5", button5.getText().toString());
        outState.putString("button6", button6.getText().toString());
        outState.putString("button7", button7.getText().toString());
        outState.putString("button8", button8.getText().toString());
        outState.putString("button9", button9.getText().toString());
        outState.putCharSequence("TextView", textView.getText());
    }

    public void tileClicked(View view) {
        int id = view.getId();
        int row = 0;
        int column = 0;

        // Change the row and column depending on the button that was clicked
        switch(id) {
            case (R.id.button1):
                row = 0;
                column = 0;
                break;
            case (R.id.button2):
                row = 0;
                column = 1;
                break;
            case (R.id.button3):
                row = 0;
                column = 2;
                break;
            case (R.id.button4):
                row = 1;
                column = 0;
                break;
            case (R.id.button5):
                row = 1;
                column = 1;
                break;
            case (R.id.button6):
                row = 1;
                column = 2;
                break;
            case (R.id.button7):
                row = 2;
                column = 0;
                break;
            case (R.id.button8):
                row = 2;
                column = 1;
                break;
            case (R.id.button9):
                row = 2;
                column = 2;
                break;
        }

        // Get the state of the current button
        TileState state = game.choose(row, column);

        // Get current button
        Button button = (Button) view;

        GameState gamestate;

        // Change the text in the button depending on the state
        switch(state) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                break;
        }

        // Declare the game-state
        gamestate = game.won();

        // Change the text in the textview depending on the game state
        if (gamestate == GameState.PLAYER_ONE || gamestate == GameState.PLAYER_TWO || gamestate == GameState.DRAW) {
            TextView textView = findViewById(R.id.Message);

            if (gamestate == GameState.PLAYER_ONE){
                textView.setText("Player one has won");
            } else if (gamestate == GameState.PLAYER_TWO) {
                textView.setText("Player Two has won");
            } else {
                textView.setText("It's a draw");
            }
        }
    }

    public void resetClicked(View view) {
        // Start new game, when 'new game' button is pressed
        game = new Game();

        // Empty the text in all buttons
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        textView.setText("");
    }
}
