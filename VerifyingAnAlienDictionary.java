import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        // Use priority queue.
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < o1.length() && i < o2.length(); i++) {
                    if (o1.charAt(i) == o2.charAt(i)) {
                        continue;
                    } else {
                        return map.get(o1.charAt(i)) - map.get(o2.charAt(i));
                    }
                }
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            pq.add(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            if (!pq.poll().equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
