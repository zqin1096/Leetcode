import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a matrix of integers A with R rows and C columns, find the maximum score
of a path starting at [0,0] and ending at [R-1,C-1].

The score of a path is the minimum value in that path.  For example, the value
of the path 8 →  4 →  5 →  9 is 4.

A path moves some number of times from one visited cell to any neighbouring
unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 */
public class PathWithMaximumMinimumValue {
    // DFS. TLE.
//    int max = 0;
//
//    public int maximumMinimumPath(int[][] A) {
//        maximumMinimumPath(A, new boolean[A.length][A[0].length], 0, 0,
//                A[0][0]);
//        return max;
//    }
//
//    private void maximumMinimumPath(int[][] A, boolean[][] visited, int r,
//                                    int c, int score) {
//        if (r == A.length - 1 && c == A[0].length - 1) {
//            score = Math.min(score, A[r][c]);
//            max = Math.max(max, score);
//            return;
//        }
//        visited[r][c] = true;
//        score = Math.min(score, A[r][c]);
//        if (r - 1 >= 0 && !visited[r - 1][c]) {
//            maximumMinimumPath(A, visited, r - 1, c, score);
//        }
//        if (r + 1 < A.length && !visited[r + 1][c]) {
//            maximumMinimumPath(A, visited, r + 1, c, score);
//        }
//        if (c - 1 >= 0 && !visited[r][c - 1]) {
//            maximumMinimumPath(A, visited, r, c - 1, score);
//        }
//        if (c + 1 < A[0].length && !visited[r][c + 1]) {
//            maximumMinimumPath(A, visited, r, c + 1, score);
//        }
//        visited[r][c] = false;
//    }
    public int maximumMinimumPath(int[][] A) {
        // Priority queue + BFS.
        // The score of a path is the minimum value in that path and we want
        // to find the maximum score of a path from [0, 0] to [R-1, C-1].
        // So we should try to find path with higher value first, since lower
        // value make the score of the path lower.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // Sort the cells in decreasing order based on their values.
                return o2[2] - o1[2];
            }
        });
        Integer[][] values = new Integer[A.length][A[0].length];
        values[0][0] = A[0][0];
        pq.add(new int[]{0, 0, A[0][0]});
        while (!pq.isEmpty()) {
            // Once a cell is popped from the priority queue, the maximum
            // score of the path that ends in this cell is found.
            int[] cell = pq.remove();
            if (cell[0] == A.length - 1 && cell[1] == A[0].length - 1) {
                return cell[2];
            }
            int r = cell[0];
            int c = cell[1];
            if (r - 1 >= 0 && values[r - 1][c] == null) {
                // Compare the values of the current cell and the neighboring
                // cells.
                values[r - 1][c] = Math.min(cell[2], A[r - 1][c]);
                pq.add(new int[]{r - 1, c, values[r - 1][c]});
            }
            if (r + 1 < A.length && values[r + 1][c] == null) {
                values[r + 1][c] = Math.min(cell[2], A[r + 1][c]);
                pq.add(new int[]{r + 1, c, values[r + 1][c]});
            }
            if (c - 1 >= 0 && values[r][c - 1] == null) {
                values[r][c - 1] = Math.min(cell[2], A[r][c - 1]);
                pq.add(new int[]{r, c - 1, values[r][c - 1]});
            }
            if (c + 1 < A[0].length && values[r][c + 1] == null) {
                values[r][c + 1] = Math.min(cell[2], A[r][c + 1]);
                pq.add(new int[]{r, c + 1, values[r][c + 1]});
            }
        }
        return -1;
    }
}
