package com.optimahorizonapps.tictactoe_game;

import android.view.View;
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
    public boolean winnerCheck() {
        boolean isWinner = false;

        for(int r = 0; r < 3; r++) {
            if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
                gameBoard[r][0] != 0) {
                isWinner = true;
            }
        }

        for(int c = 0; c < 3; c++) {
            if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] &&
                    gameBoard[0][c] != 0) {
                isWinner = true;
            }
        }

        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                    gameBoard[0][0] != 0) {
                isWinner = true;
            }

        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                gameBoard[2][0] != 0) {
            isWinner = true;
        }

        int boardFilled = 0;
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(gameBoard[r][c] != 0) {
                    boardFilled+=1;
                }
            }
        }

        if(isWinner) {
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurnTV.setText(String.format("%s Won!!!!!", playerNames[player - 1]));
            return true;
        }
        else if(boardFilled == 9) {
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurnTV.setText(R.string.tie_game);
            return true;
        }
        else {
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
        player = 1;
        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);
        playerTurnTV.setText(String.format("%s's Turn", playerNames[0]));
    }
}
