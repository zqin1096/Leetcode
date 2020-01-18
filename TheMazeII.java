import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/*
There is a ball in a maze with empty spaces and walls. The ball can go through
empty spaces by rolling up, down, left or right, but it won't stop rolling
until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the
shortest distance for the ball to stop at the destination. The distance is
defined by the number of empty spaces traveled by the ball from the start
position (excluded) to the destination (included). If the ball cannot stop at
the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the
empty space. You may assume that the borders of the maze are all walls. The
start and destination coordinates are represented by row and column indexes.
 */
public class TheMazeII {

    private class Pair {

        int[] position;
        int distance;

        Pair(int[] position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }

    // Dijkstra.
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.distance - o2.distance;
            }
        });
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            // Shortest distance from start to this position is found.
            Pair pair = pq.remove();
            if (pair.position[0] == destination[0] && pair.position[1] == destination[1]) {
                return pair.distance;
            }
            visited[pair.position[0]][pair.position[1]] = true;
            int[] up = moveUp(maze, pair.position);
            // If a position is visited, it means the shortest distance from
            // start to this position is found. Hence, there is no need to
            // add it to the priority queue.
            if (!visited[up[0]][up[1]]) {
                pq.add(new Pair(up, pair.distance + pair.position[0] - up[0]));
            }
            int[] down = moveDown(maze, pair.position);
            if (!visited[down[0]][down[1]]) {
                pq.add(new Pair(down,
                        pair.distance + down[0] - pair.position[0]));
            }
            int[] left = moveLeft(maze, pair.position);
            if (!visited[left[0]][left[1]]) {
                pq.add(new Pair(left,
                        pair.distance + pair.position[1] - left[1]));
            }
            int[] right = moveRight(maze, pair.position);
            if (!visited[right[0]][right[1]]) {
                pq.add(new Pair(right,
                        pair.distance + right[1] - pair.position[1]));
            }
        }
        return -1;
    }

    private int[] moveUp(int[][] maze, int[] current) {
        int[] pos = new int[2];
        pos[0] = current[0];
        pos[1] = current[1];
        while (pos[0] - 1 >= 0 && maze[pos[0] - 1][pos[1]] == 0) {
            pos[0] = pos[0] - 1;
        }
        return pos;
    }

    private int[] moveDown(int[][] maze, int[] current) {
        int[] pos = new int[2];
        pos[0] = current[0];
        pos[1] = current[1];
        while (pos[0] + 1 < maze.length && maze[pos[0] + 1][pos[1]] == 0) {
            pos[0] = pos[0] + 1;
        }
        return pos;
    }

    private int[] moveLeft(int[][] maze, int[] current) {
        int[] pos = new int[2];
        pos[0] = current[0];
        pos[1] = current[1];
        while (pos[1] - 1 >= 0 && maze[pos[0]][pos[1] - 1] == 0) {
            pos[1] = pos[1] - 1;
        }
        return pos;
    }

    private int[] moveRight(int[][] maze, int[] current) {
        int[] pos = new int[2];
        pos[0] = current[0];
        pos[1] = current[1];
        while (pos[1] + 1 < maze[0].length && maze[pos[0]][pos[1] + 1] == 0) {
            pos[1] = pos[1] + 1;
        }
        return pos;
    }
}
