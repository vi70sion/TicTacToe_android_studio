package com.example.tictactoe;

public class TicTacT {

    private char[][] board;
    private char currentPlayer;

    public TicTacT() {
        board = new char[3][3];
        currentPlayer = 'X';

    }

    public char[][] getBoard() { return board; }
    public char getCurrentPlayer() { return currentPlayer; }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; //letter "O", not a number
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
