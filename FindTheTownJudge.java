import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> people = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            people.remove(trust[i][0]);
            if (map.containsKey(trust[i][0])) {
                map.get(trust[i][0]).add(trust[i][1]);
            } else {
                map.put(trust[i][0], new ArrayList<>());
                map.get(trust[i][0]).add(trust[i][1]);
            }
        }
        if (people.size() != 1) {
            return -1;
        } else {
            int judge = people.iterator().next();
            for (List<Integer> list : map.values()) {
                if (!list.contains(judge)) {
                    return -1;
                }
            }
            return judge;
        }
    }
    // Can also be solved using directed graph. All pairs are directed edge.
    // In-degree - out-degree(0) = N - 1.
    // trust[i][0]: out, trust[i][1]: in.
}
