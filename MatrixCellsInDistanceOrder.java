import java.util.Comparator;
import java.util.PriorityQueue;

/*
We are given a matrix with R rows and C columns has cells with integer
coordinates (r, c), where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance
from (r0, c0) from smallest distance to largest distance.  Here, the distance
between two cells (r1, c1) and (r2, c2) is the Manhattan distance,
|r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies
this condition.)
 */
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int distance1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
                int distance2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
                return distance1 - distance2;
            }
        });
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                pq.add(new int[]{i, j});
            }
        }
        int[][] res = new int[R * C][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            res[i][0] = cell[0];
            res[i][1] = cell[1];
            i++;
        }
        return res;
    }
}
