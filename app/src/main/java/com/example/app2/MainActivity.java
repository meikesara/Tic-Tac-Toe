package com.example.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        TextView textView = findViewById(R.id.Message);

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

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        TextView textView = findViewById(R.id.Message);

        String TextButton1 = button1.getText().toString();
        String TextButton2 = button2.getText().toString();
        String TextButton3 = button3.getText().toString();
        String TextButton4 = button4.getText().toString();
        String TextButton5 = button5.getText().toString();
        String TextButton6 = button6.getText().toString();
        String TextButton7 = button7.getText().toString();
        String TextButton8 = button8.getText().toString();
        String TextButton9 = button9.getText().toString();
        CharSequence TextTextView = textView.getText();

        outState.putString("button1", TextButton1);
        outState.putString("button2", TextButton2);
        outState.putString("button3", TextButton3);
        outState.putString("button4", TextButton4);
        outState.putString("button5", TextButton5);
        outState.putString("button6", TextButton6);
        outState.putString("button7", TextButton7);
        outState.putString("button8", TextButton8);
        outState.putString("button9", TextButton9);
        outState.putCharSequence("TextView", TextTextView);
    }

    public void tileClicked(View view) {
        int id = view.getId();
        int row = 0;
        int column = 0;

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

        TileState state = game.choose(row, column);
        Button button = (Button) view;
        GameState gamestate;

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
        gamestate = game.won();

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
        game = new Game();
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        TextView textView = findViewById(R.id.Message);

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
