/*
On a 2-dimensional grid, there are 4 types of squares:
1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending
square, that walk over every non-obstacle square exactly once.
 */
public class UniquePathsIII {
    // DFS.
    int result = 0;
    int numOfNonObstacles = 0;

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    numOfNonObstacles++;
                }
                if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                    numOfNonObstacles++;
                }
                if (grid[i][j] == 0) {
                    numOfNonObstacles++;
                }
            }
        }
        uniquePathsIII(grid, new boolean[grid.length][grid[0].length], 0,
                start, end);
        return result;
    }

    private void uniquePathsIII(int[][] grid, boolean[][] visited, int num,
                                int[] curr, int[] end) {
        if (grid[curr[0]][curr[1]] == -1) {
            return;
        }
        if (visited[curr[0]][curr[1]]) {
            return;
        }
        visited[curr[0]][curr[1]] = true;
        num++;
        if (num == numOfNonObstacles && (end[0] == curr[0] && end[1] == curr[1])) {
            result++;
            visited[curr[0]][curr[1]] = false;
            return;
        }
        if (curr[0] - 1 >= 0) {
            uniquePathsIII(grid, visited, num, new int[]{curr[0] - 1,
                    curr[1]}, end);
        }
        if (curr[0] + 1 < grid.length) {
            uniquePathsIII(grid, visited, num, new int[]{curr[0] + 1,
                    curr[1]}, end);
        }
        if (curr[1] - 1 >= 0) {
            uniquePathsIII(grid, visited, num, new int[]{curr[0],
                    curr[1] - 1}, end);
        }
        if (curr[1] + 1 < grid[0].length) {
            uniquePathsIII(grid, visited, num, new int[]{curr[0],
                    curr[1] + 1}, end);
        }
        visited[curr[0]][curr[1]] = false;
    }
}
