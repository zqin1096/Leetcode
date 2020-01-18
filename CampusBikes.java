import java.util.Comparator;
import java.util.PriorityQueue;

/*
On a campus represented as a 2D grid, there are N workers and M bikes, with
N <= M. Each worker and bike is a 2D coordinate on this grid.

Our goal is to assign a bike to each worker. Among the available bikes and
workers, we choose the (worker, bike) pair with the shortest Manhattan distance
between each other, and assign the bike to that worker. (If there are multiple
(worker, bike) pairs with the same shortest Manhattan distance, we choose the
pair with the smallest worker index; if there are multiple ways to do that, we
choose the pair with the smallest bike index). We repeat this process until
there are no available workers.

The Manhattan distance between two points p1 and p2 is
Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Return a vector ans of length N, where ans[i] is the index (0-indexed) of the
bike that the i-th worker is assigned to.
 */
public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // int[0]: index of the worker, int[1]: index of the bike, int[2]:
        // the distance between the worker and the bike.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    if (o1[0] == o2[0]) {
                        // Choose the pair with the smallest bike index.
                        return o1[1] - o2[1];
                    } else {
                        // Choose the pair with the smallest worker index.
                        return o1[0] - o2[0];
                    }
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        // Add every possible pair to the priority queue.
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                pq.add(new int[]{i, j, distance(workers[i], bikes[j])});
            }
        }
        int[] ans = new int[workers.length];
        boolean[] chosenWorkers = new boolean[workers.length];
        boolean[] chosenBikes = new boolean[bikes.length];
        while (!pq.isEmpty()) {
            int[] pair = pq.remove();
            if (!chosenWorkers[pair[0]] && !chosenBikes[pair[1]]) {
                ans[pair[0]] = pair[1];
                chosenWorkers[pair[0]] = true;
                chosenBikes[pair[1]] = true;
            }
        }
        return ans;
    }

    private int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
