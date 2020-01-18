/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around
is not allowed).
 */
public class LongestIncreasingPathInAMatrix {
    // DFS with memorization.
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // length[i][j] represents the length of the longest increasing path
        // starting from this cell. If the value of length[i][j]] is not 0,
        // it means that the value for this cell has found and does not need
        // to search again.
        int[][] length = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, dfs(matrix, i, j,
                        // In this case, we do not need a new 2D array to
                        // store the longest increasing path every time.
                        new boolean[matrix.length][matrix[0].length], length));
            }
        }
        return max;
    }

    // Find the length of the longest increasing path starting from (i, j).
    private int dfs(int[][] matrix, int i, int j, boolean[][] visited,
                    int[][] length) {
        if (length[i][j] > 0) {
            return length[i][j];
        }
        int max = 1;
        int cell = matrix[i][j];
        // A cell cannot be used twice in a path.
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && matrix[i - 1][j] > cell) {
            int up = dfs(matrix, i - 1, j, visited, length);
            max = Math.max(max, 1 + up);
        }
        if (i + 1 < matrix.length && !visited[i + 1][j] && matrix[i + 1][j] > cell) {
            int down = dfs(matrix, i + 1, j, visited, length);
            max = Math.max(max, 1 + down);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && matrix[i][j - 1] > cell) {
            int left = dfs(matrix, i, j - 1, visited, length);
            max = Math.max(max, 1 + left);
        }
        if (j + 1 < matrix[0].length && !visited[i][j + 1] && matrix[i][j + 1] > cell) {
            int right = dfs(matrix, i, j + 1, visited, length);
            max = Math.max(max, 1 + right);
        }
        // Mark it as false since another path may use this cell.
        visited[i][j] = false;
        // Store the result in the cache.
        length[i][j] = max;
        return max;
    }
}
