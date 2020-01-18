import java.util.*;

/*
Given a list of scores of different students, return the average score of each
student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the
student's score.  The average score is calculated using integer division.
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] score : items) {
            pq.add(score);
        }
        while (!pq.isEmpty()) {
            int[] score = pq.remove();
            if (map.containsKey(score[0])) {
                List<Integer> scores = map.get(score[0]);
                if (scores.size() < 5) {
                    scores.add(score[1]);
                }
            } else {
                List<Integer> scores = new ArrayList<>();
                scores.add(score[1]);
                map.put(score[0], scores);
            }
        }
        PriorityQueue<int[]> average = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (Map.Entry<Integer, List<Integer>> scores : map.entrySet()) {
            int sum = 0;
            for (int i : scores.getValue()) {
                sum += i;
            }
            average.add(new int[]{scores.getKey(), sum / 5});
        }
        int[][] result = new int[map.keySet().size()][2];
        for (int i = 0; i < result.length; i++) {
            int[] score = average.remove();
            result[i][0] = score[0];
            result[i][1] = score[1];
        }
        return result;
    }
}
