import java.util.HashSet;
import java.util.Set;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
(representing land) connected 4-directionally (horizontal or vertical.) You may
assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as
another if and only if one island can be translated (and not rotated or
reflected) to equal the other.
 */
public class NumberOfDistinctIslands {
    // DFS.
    // Encode the shape of the island into a string.
    public int numDistinctIslands(int[][] grid) {
        Set<String> distinct = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    // Mark the first found position as "00".
                    dfs(grid, i, j, sb, 0, 0);
                    distinct.add(sb.toString());
                }
            }
        }
        return distinct.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int x,
                     int y) {
        sb.append(x);
        sb.append(y);
        grid[i][j] = -1;
        // The sequence of dfs is the same (up, down, left, right). If 2
        // islands have the same shape, then the dfs path should be the same
        // and the encoded string should be the same.
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            dfs(grid, i - 1, j, sb, x - 1, y);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            dfs(grid, i + 1, j, sb, x + 1, y);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            dfs(grid, i, j - 1, sb, x, y - 1);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            dfs(grid, i, j + 1, sb, x, y + 1);
        }
    }
}
