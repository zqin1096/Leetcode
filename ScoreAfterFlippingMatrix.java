/*
We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that
row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a
binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        // Change the most significant bit to 1.
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        for (int i = 1; i < A[0].length; i++) {
            if (!count(A, i)) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = 1 - A[j][i];
                }
            }
        }
        double num = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = A[0].length - 1; j >= 0; j--) {
                num += Math.pow(2, A[0].length - 1 - j) * A[i][j];
            }
        }
        return (int) num;
    }

    // Check if the number of 1 is more than or equal to the number of 0 in a
    // column.
    private boolean count(int[][] A, int col) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][col] == 1) {
                num++;
            } else {
                num--;
            }
        }
        return num >= 0;
    }
}
