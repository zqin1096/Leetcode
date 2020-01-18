import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(i,
                    points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1,
                                       Map.Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });
        pq.addAll(map.entrySet());
        for (int i = 0; i < K; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            result[i][0] = points[entry.getKey()][0];
            result[i][1] = points[entry.getKey()][1];
        }
        return result;
    }
}
