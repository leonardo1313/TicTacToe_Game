package com.optimahorizonapps.tictactoe_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;
    private Button playAgainBtn;
    private Button homeBtn;
    private TextView playerDisplayTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);

        playAgainBtn = findViewById(R.id.playAgain_button);
        homeBtn = findViewById(R.id.home_button);
        playerDisplayTV = findViewById(R.id.playerDisplay_textView);

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if(playerNames != null) {
            playerDisplayTV.setText((String.format("%s's Turn", playerNames[0])));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        ticTacToeBoard.setUpGame(playAgainBtn, homeBtn, playerDisplayTV, playerNames);
    }

    public void playAgainButtonClick(View view) {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view) {
        Intent intent = new Intent(GameDisplay.this, MainActivity.class);
        startActivity(intent);
    }
}