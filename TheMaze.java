/*
There is a ball in a maze with empty spaces and walls. The ball can go through
empty spaces by rolling up, down, left or right, but it won't stop rolling
until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine
whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the
empty space. You may assume that the borders of the maze are all walls. The
start and destination coordinates are represented by row and column indexes.
 */
public class TheMaze {
    boolean ans = false;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
        return ans;
    }

    public void dfs(int[][] maze, int[] start, int[] destination,
                    boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return;
        }
        visited[start[0]][start[1]] = true;
        if (start[0] == destination[0] && start[1] == destination[1]) {
            ans = true;
            return;
        }
        dfs(maze, moveUp(maze, start), destination, visited);
        dfs(maze, moveDown(maze, start), destination, visited);
        dfs(maze, moveLeft(maze, start), destination, visited);
        dfs(maze, moveRight(maze, start), destination, visited);
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
