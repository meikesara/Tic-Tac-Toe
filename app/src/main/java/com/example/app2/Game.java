package com.example.app2;

public class Game {
    // Create variables
    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    // Initiliase board at the start of a new game
    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    // Change the tile state of a particular tile
    public TileState choose(int row, int column) {
        if (board[row][column] == TileState.BLANK) {
            movesPlayed++;
            if (playerOneTurn) {
                board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                return TileState.CROSS;
            } else {
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                return TileState.CIRCLE;
            }
        } else {
            return TileState.INVALID;
        }
    }

    // Check if game is won
    public GameState won() {
        int checkPlayer1row;
        int checkPlayer2row;
        int checkPlayer1column;
        int checkPlayer2column;
        int row;
        int column;

        if ((board[0][0] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][2] == TileState.CROSS) ||
                (board[2][0] == TileState.CROSS && board[1][1] == TileState.CROSS && board[0][2] == TileState.CROSS)) {
            for (int i = 0; i < BOARD_SIZE; i++)
                for (int j = 0; j < BOARD_SIZE; j++)
                    board[i][j] = TileState.INVALID;
            return GameState.PLAYER_ONE;
        } else if ((board[0][0] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][2] == TileState.CIRCLE) ||
                (board[2][0] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[0][2] == TileState.CIRCLE)) {
            for (int i = 0; i < BOARD_SIZE; i++)
                for (int j = 0; j < BOARD_SIZE; j++)
                    board[i][j] = TileState.INVALID;
            return GameState.PLAYER_TWO;
        }

        if (movesPlayed == 9) {
            return GameState.DRAW;
        }

        for (int i = 0; i < 3; i++) {
            checkPlayer1row = 0;
            checkPlayer2row = 0;
            checkPlayer1column = 0;
            checkPlayer2column = 0;
            for (int j = 0; j < 3; j++) {
                row = i;
                column = j;
                if (board[row][column] == TileState.CROSS) {
                    checkPlayer1row++;
                } else if (board[row][column] == TileState.CIRCLE) {
                    checkPlayer2row++;
                }
                if (board[column][row] == TileState.CROSS) {
                    checkPlayer1column++;
                } else if (board[column][row] == TileState.CIRCLE) {
                    checkPlayer2column++;
                }
                if (checkPlayer1row == 3 || checkPlayer1column == 3) {
                    for (i = 0; i < BOARD_SIZE; i++)
                        for (j = 0; j < BOARD_SIZE; j++)
                            board[i][j] = TileState.INVALID;
                    return GameState.PLAYER_ONE;
                } else if (checkPlayer2row == 3 || checkPlayer2column == 3) {
                    for (i = 0; i < BOARD_SIZE; i++)
                        for (j = 0; j < BOARD_SIZE; j++)
                            board[i][j] = TileState.INVALID;
                    return GameState.PLAYER_TWO;
                }
            }
        }
        return GameState.IN_PROGRESS;
    }
}
