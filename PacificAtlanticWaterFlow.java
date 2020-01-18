import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix of non-negative integers representing the height of each
unit cell in a continent, the "Pacific ocean" touches the left and top edges of
the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell
to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and
Atlantic ocean.
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        // 00: cannot flow to both oceans.
        // 01: can only flow to Pacific ocean.
        // 10: can only flow to Atlantic ocean.
        // 11: can flow to both ocean.
        int[][] flow = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            flow[0][i] = (flow[0][i] | 1);
            dfs(matrix, flow, 0, i,
                    new boolean[matrix.length][matrix[0].length], 1);
        }
        // Top row and left column can flow to Pacific ocean.
        for (int i = 0; i < matrix.length; i++) {
            flow[i][0] = (flow[i][0] | 1);
            dfs(matrix, flow, i, 0,
                    new boolean[matrix.length][matrix[0].length], 1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            flow[matrix.length - 1][i] = (flow[matrix.length - 1][i] | 2);
            dfs(matrix, flow, matrix.length - 1, i,
                    new boolean[matrix.length][matrix[0].length], 2);
        }
        // Bottom row and right column can flow to Atlantic ocean.
        for (int i = 0; i < matrix.length; i++) {
            flow[i][matrix[0].length - 1] = (flow[i][matrix[0].length - 1] | 2);
            dfs(matrix, flow, i, matrix[0].length - 1,
                    new boolean[matrix.length][matrix[0].length], 2);
        }
        for (int i = 0; i < flow.length; i++) {
            for (int j = 0; j < flow[i].length; j++) {
                if (flow[i][j] == 3) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int[][] flow, int i, int j, boolean[][] visited, int ocean) {
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && matrix[i][j] <= matrix[i - 1][j]) {
            flow[i - 1][j] = (flow[i - 1][j] | ocean);
            dfs(matrix, flow, i - 1, j, visited, ocean);
        }
        if (i + 1 < matrix.length && !visited[i + 1][j] && matrix[i][j] <= matrix[i + 1][j]) {
            flow[i + 1][j] = (flow[i + 1][j] | ocean);
            dfs(matrix, flow, i + 1, j, visited, ocean);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && matrix[i][j] <= matrix[i][j - 1]) {
            flow[i][j - 1] = (flow[i][j - 1] | ocean);
            dfs(matrix, flow, i, j - 1, visited, ocean);
        }
        if (j + 1 < matrix[0].length && !visited[i][j + 1] && matrix[i][j] <= matrix[i][j + 1]) {
            flow[i][j + 1] = (flow[i][j + 1] | ocean);
            dfs(matrix, flow, i, j + 1, visited, ocean);
        }
    }
}
