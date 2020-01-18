import java.util.*;

/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.
Then, either:
Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.  It is
guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log. The
letter-logs are ordered lexicographically ignoring identifier, with the
identifier used in case of ties.  The digit-logs should be put in their
original order.

Return the final order of the logs.
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Map<String[], Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            String[] tokens = new String[3];
            int index = logs[i].indexOf(" ");
            tokens[0] = logs[i].substring(0, index);
            tokens[1] = logs[i].substring(index + 1);
            map.put(tokens, i);
        }
        PriorityQueue<Map.Entry<String[], Integer>> pq =
                new PriorityQueue<>(new Comparator<Map.Entry<String[], Integer>>() {
                    @Override
                    public int compare(Map.Entry<String[], Integer> o1, Map.Entry<String[], Integer> o2) {
                        char c1 = o1.getKey()[1].charAt(0);
                        char c2 = o2.getKey()[1].charAt(0);
                        if (Character.isLetter(c1) && Character.isDigit(c2)) {
                            return -1;
                        }
                        if (Character.isDigit(c1) && Character.isLetter(c2)) {
                            return 1;
                        }
                        if (Character.isLetter(c1) && Character.isLetter(c2)) {
                            if (o1.getKey()[1].compareTo(o2.getKey()[1]) == 0) {
                                return o1.getKey()[0].compareTo(o2.getKey()[0]);
                            } else {
                                return o1.getKey()[1].compareTo(o2.getKey()[1]);
                            }
                        }
                        if (Character.isDigit(c1) && Character.isDigit(c2)) {
                            return o1.getValue() - o2.getValue();
                        }
                        throw new IllegalArgumentException();
                    }
                });
        pq.addAll(map.entrySet());
        String[] result = new String[logs.length];
        for (int i = 0; i < result.length; i++) {
            Map.Entry<String[], Integer> entry = pq.remove();
            result[i] = entry.getKey()[0] + " " + entry.getKey()[1];
        }
        return result;
    }
}
