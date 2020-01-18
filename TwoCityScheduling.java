import java.util.Comparator;
import java.util.PriorityQueue;

/*
There are 2N people a company is planning to interview. The cost of flying the
i-th person to city A is costs[i][0], and the cost of flying the i-th person to
city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N
people arrive in each city.
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            // Sort the costs based on A - B.
            public int compare(int[] o1, int[] o2) {
                int difference1 = o1[0] - o1[1];
                int difference2 = o2[0] - o2[1];
                return difference1 - difference2;
            }
        });
        for (int[] cost : costs) {
            pq.add(cost);
        }
        int sum = 0;
        int i = 0;
        while (i < costs.length / 2) {
            sum += pq.poll()[0];
            i++;
        }
        while (i < costs.length) {
            sum += pq.poll()[1];
            i++;
        }
        return sum;
    }
}
