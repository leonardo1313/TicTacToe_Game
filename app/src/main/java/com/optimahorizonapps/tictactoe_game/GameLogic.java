package com.optimahorizonapps.tictactoe_game;

public class GameLogic {

    private int[][] gameBoard;

    GameLogic() {
        gameBoard = new int[3][3];
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0; //we populate our board with 0s, so we know which spots are available to place a marker
            }
        }
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }
}
