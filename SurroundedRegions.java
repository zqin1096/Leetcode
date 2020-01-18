/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {
    // TLE.
//    public void solve(char[][] board) {
//        if (board == null || board.length == 0) {
//            return;
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == 'O' && dfs(board, i, j, new boolean[board.length][board[0].length])) {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }
//
//    private boolean dfs(char[][] board, int row, int col, boolean[][] visited) {
//        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length) {
//            return true;
//        }
//        if (visited[row][col]) {
//            return true;
//        }
//        visited[row][col] = true;
//        if (board[row][col] == 'X') {
//            return true;
//        } else {
//            if (row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1) {
//                return false;
//            } else {
//                return dfs(board, row + 1, col, visited) && dfs(board,
//                        row - 1,
//                        col, visited) && dfs(board, row, col - 1, visited) && dfs(board, row, col + 1, visited);
//            }
//        }
//    }
}
