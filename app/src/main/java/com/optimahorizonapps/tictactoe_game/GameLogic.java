package com.optimahorizonapps.tictactoe_game;

public class GameLogic {

    private int[][] gameBoard;
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

            return true;
        } else {
            return false;
        }

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
