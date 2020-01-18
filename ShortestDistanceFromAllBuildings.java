import java.util.LinkedList;
import java.util.Queue;

/*
You want to build a house on an empty land which reaches all buildings in the
shortest amount of distance. You can only move up, down, left and right. You
are given a 2D grid of values 0, 1 or 2, where:
Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
 */
public class ShortestDistanceFromAllBuildings {
    public static int shortestDistance(int[][] grid) {
        // Total distance from a land to all the buildings.
        int[][] sum = new int[grid.length][grid[0].length];
        // Represent the empty land.
        int val = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // Store the distance from a position to a building.
                    int[][] distance = new int[grid.length][];
                    for (int k = 0; k < distance.length; k++) {
                        distance[k] = grid[k].clone();
                    }
                    // If a building cannot be reached, it means that no path
                    // exists to go to that building. So min will stay
                    // unchanged. The grid will minus 1 (0 -> -1 -> -2 ...)
                    // If a building is not connected to other buildings, it
                    // will not find the empty land (val).
                    min = Integer.MAX_VALUE;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] land = queue.remove();
                        int x = land[0];
                        int y = land[1];
                        if (x - 1 >= 0 && grid[x - 1][y] == val) {
                            grid[x - 1][y]--;
                            distance[x - 1][y] = distance[x][y] + 1;
                            // The initial distance is 1 instead of 0, so we
                            // need to subtract 1 from the sum.
                            sum[x - 1][y] += (distance[x - 1][y] - 1);
                            min = Math.min(min, sum[x - 1][y]);
                            queue.add(new int[]{x - 1, y});
                        }
                        if (x + 1 < grid.length && grid[x + 1][y] == val) {
                            grid[x + 1][y]--;
                            distance[x + 1][y] = distance[x][y] + 1;
                            sum[x + 1][y] += (distance[x + 1][y] - 1);
                            min = Math.min(min, sum[x + 1][y]);
                            queue.add(new int[]{x + 1, y});
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == val) {
                            grid[x][y - 1]--;
                            distance[x][y - 1] = distance[x][y] + 1;
                            sum[x][y - 1] += (distance[x][y - 1] - 1);
                            min = Math.min(min, sum[x][y - 1]);
                            queue.add(new int[]{x, y - 1});
                        }
                        if (y + 1 < grid[0].length && grid[x][y + 1] == val) {
                            grid[x][y + 1]--;
                            distance[x][y + 1] = distance[x][y] + 1;
                            sum[x][y + 1] += (distance[x][y + 1] - 1);
                            min = Math.min(min, sum[x][y + 1]);
                            queue.add(new int[]{x, y + 1});
                        }
                    }
                    if (min == Integer.MAX_VALUE) {
                        return -1;
                    }
                    val--;
                }
            }
        }
        return min;
    }
}
