/*
Given a positive integer n, generate a square matrix filled with elements from
1 to n^2 in spiral order.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        // Similar with Spiral Matrix I.
        int[][] result = new int[n][n];
        int i = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                result[top][j] = i;
                i++;
            }
            for (int j = top; j < bottom; j++) {
                result[j][right] = i;
                i++;
            }
            for (int j = right; j > left; j--) {
                result[bottom][j] = i;
                i++;
            }
            for (int j = bottom; j > top; j--) {
                result[j][left] = i;
                i++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (left == right) {
            for (int j = top; j <= bottom; j++) {
                result[j][left] = i;
                i++;
            }
        } else if (top == bottom) {
            for (int j = left; j <= right; j++) {
                result[top][j] = i;
                i++;
            }
        }
        return result;
    }
}
