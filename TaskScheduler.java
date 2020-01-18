import java.util.*;

/*
Given a char array representing tasks CPU need to do. It contains capital
letters A to Z where different letters represent different tasks. Tasks could
be done without original order. Each task could be done in one interval. For
each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same
tasks, there must be at least n intervals that CPU are doing different tasks or
just be idle.

You need to return the least number of intervals the CPU will take to finish
all the given tasks.
 */
public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
        pq.addAll(map.entrySet());
        int intervals = 0;
        int scheduled = 0;
        while (!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> list = new LinkedList<>();
            for (int i = 0; i <= n; i++) {
                if (scheduled == tasks.length) {
                    break;
                }
                if (!pq.isEmpty()) {
                    // Choose the most tasks.
                    Map.Entry<Character, Integer> entry = pq.remove();
                    scheduled++;
                    entry.setValue(entry.getValue() - 1);
                    if (entry.getValue() != 0) {
                        list.add(entry);
                    }
                }
                intervals++;
            }
            // Add the tasks back for next iteration.
            for (int i = 0; i < list.size(); i++) {
                pq.add(list.get(i));
            }
        }
        return intervals;
    }
}
