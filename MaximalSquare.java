/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square
containing only 1's and return its area.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // Max length of the side.
        int max = 0;
        // dp(i,j) represents the side length of the maximum square whose
        // bottom right corner is the cell with index (i,j) in the original
        // matrix.
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // Check the max side length of the square cornered at
                    // (i - 1, j - 1), (i - 1, j), and (i, j - 1).
                    // Draw a graph.
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}