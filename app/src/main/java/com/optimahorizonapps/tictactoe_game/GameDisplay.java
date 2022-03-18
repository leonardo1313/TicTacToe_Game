package com.optimahorizonapps.tictactoe_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
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