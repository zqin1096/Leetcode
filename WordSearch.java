/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where
"adjacent" cells are those horizontally or vertically neighboring. The same
letter cell may not be used more than once.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j,
                        boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        // If index if out of the bound of the board or the characters do not
        // match, then return false;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        // The same letter cell may not be used more than once.
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean exist =
                dfs(board, word, index + 1, i - 1, j, visited) || dfs(board,
                        word, index + 1, i + 1, j, visited) || dfs(board,
                        word, index + 1, i, j - 1, visited) || dfs(board,
                        word, index + 1, i, j + 1, visited);
        // After finish searching this path, we need to mark it as unvisited,
        // which is important in this problem. The other paths may go through
        // this cell and it needs to be in the unvisited state.
        visited[i][j] = false;
        return exist;
    }
}
