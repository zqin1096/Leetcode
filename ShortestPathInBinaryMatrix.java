import java.util.LinkedList;
import java.util.Queue;

/*
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is
composed of cells C_1, C_2, ..., C_k such that:
Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are
different and share an edge or corner).
C_1 is at location (0, 0) (ie. has value grid[0][0]).
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1]).
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to
bottom-right. If such a path does not exist, return -1.
 */
public class ShortestPathInBinaryMatrix {
    // BFS for shortest distance.
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int[][] distance = new int[row][col];
        distance[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < directions.length; i++) {
                int a = directions[i][0] + x;
                int b = directions[i][1] + y;
                if (a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == 0) {
                    // Mark it as -1 to avoid revisiting.
                    grid[a][b] = -1;
                    distance[a][b] = distance[x][y] + 1;
                    queue.add(new int[]{a, b});
                }
            }
        }
        return distance[row - 1][col - 1] == 0 ? -1 :
                distance[row - 1][col - 1];
    }
}
