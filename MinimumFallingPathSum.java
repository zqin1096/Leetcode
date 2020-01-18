
public class MinimumFallingPathSum {
    // Dynamic programming.
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // Pre-process the array.
        int[][] square = new int[A.length][A.length + 2];
        for (int i = 0; i < square.length; i++) {
            // Add two columns.
            square[i][0] = Integer.MAX_VALUE;
            square[i][square[i].length - 1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 1; j < square[i].length - 1; j++) {
                square[i][j] = A[i][j - 1];
            }
        }
        for (int i = 1; i < square.length; i++) {
            for (int j = 1; j < square[i].length - 1; j++) {
                // square[i][j] represents the current minimum falling path sum that includes the original value in
                // square[i][j].
                square[i][j] = square[i][j] + Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i - 1][j + 1]));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < square[0].length; i++) {
            min = Math.min(square[square.length - 1][i], min);
        }
        return min;
    }
}
