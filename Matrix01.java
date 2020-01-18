import java.util.LinkedList;
import java.util.Queue;

/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
each cell.
The distance between two adjacent cells is 1.
 */
public class Matrix01 {
    // Similar to 286.
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            // If the value at a position is Integer.MAX_VALUE, it means that
            // the smallest distance for this position has not found.
            if (pos[0] - 1 >= 0 && result[pos[0] - 1][pos[1]] == Integer.MAX_VALUE) {
                // Update the distance for this position instantly (better)
                // to avoid adding the same position to the queue.
                result[pos[0] - 1][pos[1]] = result[pos[0]][pos[1]] + 1;
                queue.add(new int[]{pos[0] - 1, pos[1]});
            }
            if (pos[0] + 1 < matrix.length && result[pos[0] + 1][pos[1]] == Integer.MAX_VALUE) {
                result[pos[0] + 1][pos[1]] = result[pos[0]][pos[1]] + 1;
                queue.add(new int[]{pos[0] + 1, pos[1]});
            }
            if (pos[1] - 1 >= 0 && result[pos[0]][pos[1] - 1] == Integer.MAX_VALUE) {
                result[pos[0]][pos[1] - 1] = result[pos[0]][pos[1]] + 1;
                queue.add(new int[]{pos[0], pos[1] - 1});
            }
            if (pos[1] + 1 < matrix[0].length && result[pos[0]][pos[1] + 1] == Integer.MAX_VALUE) {
                result[pos[0]][pos[1] + 1] = result[pos[0]][pos[1]] + 1;
                queue.add(new int[]{pos[0], pos[1] + 1});
            }
        }
        return result;
    }
}
