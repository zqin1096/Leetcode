/*
Given a board with m by n cells, each cell has an initial state live (1) or
dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
diagonal) using the following four rules:

Any live cell with fewer than two live neighbors dies, as if caused by
under-population.

Any live cell with two or three live neighbors lives on to the next generation.

Any live cell with more than three live neighbors dies, as if by
over-population.

Any dead cell with exactly three live neighbors becomes a live cell, as if by
reproduction.

Write a function to compute the next state (after one update) of the board
given its current state. The next state is created by applying the above rules
simultaneously to every cell in the current state, where births and deaths
occur simultaneously.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;
                if (i - 1 >= 0) {
                    live += board[i - 1][j];
                }
                if (i + 1 < board.length) {
                    live += board[i + 1][j];
                }
                if (j - 1 >= 0) {
                    live += board[i][j - 1];
                }
                if (j + 1 < board[i].length) {
                    live += board[i][j + 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    live += board[i - 1][j - 1];
                }
                if (i - 1 >= 0 && j + 1 < board[i].length) {
                    live += board[i - 1][j + 1];
                }
                if (i + 1 < board.length && j - 1 >= 0) {
                    live += board[i + 1][j - 1];
                }
                if (i + 1 < board.length && j + 1 < board[i].length) {
                    live += board[i + 1][j + 1];
                }
                temp[i][j] = live;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (temp[i][j] < 2) {
                        board[i][j] = 0;
                    } else if (temp[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (temp[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
// In-place solution: use 2 bits to store 2 states.
// Next state   current state
// 0            0
// 0            1
// 1            0
// 1            1
