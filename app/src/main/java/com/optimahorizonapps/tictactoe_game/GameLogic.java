package com.optimahorizonapps.tictactoe_game;

import android.widget.Button;
import android.widget.TextView;

public class GameLogic {

    private int[][] gameBoard;
    private String[] playerNames = {"Player 1", "Player 2"};
    private Button playAgainBtn;
    private Button homeBtn;
    private TextView playerTurnTV;

    private int player = 1;


    GameLogic() {
        gameBoard = new int[3][3];
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0; //we populate our board with 0s, so we know which spots are available to place a marker
            }
        }
    }

    public boolean updateGameBoard(int row, int column) {
        if(gameBoard[row - 1][column - 1] == 0) {
            gameBoard[row - 1][column - 1] = player;

            if(player == 1) {
                playerTurnTV.setText((String.format("%s's Turn", playerNames[1])));
            } else {
                playerTurnTV.setText((String.format("%s's Turn", playerNames[0])));
            }

            return true;
        } else {
            return false;
        }

    }

    public void setPlayAgainBtn(Button playAgainBtn) {
        this.playAgainBtn = playAgainBtn;
    }

    public void setHomeBtn(Button homeBtn) {
        this.homeBtn = homeBtn;
    }

    public void setPlayerTurnTV(TextView playerTurnTV) {
        this.playerTurnTV = playerTurnTV;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void resetGame() {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0; //we populate our board with 0s, so we know which spots are available to place a marker
            }
        }
    }
}
