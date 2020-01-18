import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of
the matrix in spiral order.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left < right && top < bottom) {
            // Add the number from [left, right).
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            // [top, bottom).
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right]);
            }
            // [right, left).
            for (int i = right; i > left; i--) {
                result.add(matrix[bottom][i]);
            }
            // [bottom, top).
            for (int i = bottom; i > top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (left == right) {
            // It means that one column from top to bottom has not added.
            // It can't go from bottom to top since that would complete 1
            // iteration.
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][left]);
            }
        } else if (top == bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
        }
        return result;
    }
}
/*
1   2   3
4   5   6
7   8   9
Every iteration can go 4 directions.
Go right, go down, go left, go up.
1,2 3,6 9,8 7,4: first iteration.

 */
