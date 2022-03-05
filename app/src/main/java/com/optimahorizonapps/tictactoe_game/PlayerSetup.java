package com.optimahorizonapps.tictactoe_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSetup extends AppCompatActivity {

    private EditText playerOne_et;
    private EditText playerTwo_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        playerOne_et = findViewById(R.id.playerOneNameInput_et);
        playerTwo_et = findViewById(R.id.playerTwoNameInput_et);
    }

    public void submitButtonClick(View view) {
        String playerOneName = playerOne_et.getText().toString();
        String playerTwoName = playerTwo_et.getText().toString();

        if(!playerOneName.equals("") && !playerTwoName.equals("")) {
            Intent intent = new Intent(PlayerSetup.this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[] {playerOneName, playerTwoName});
            startActivity(intent);
        } else {
            Toast.makeText(this, "Enter player names!", Toast.LENGTH_SHORT).show();
        }


    }
}